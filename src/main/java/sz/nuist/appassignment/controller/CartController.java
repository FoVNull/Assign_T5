package sz.nuist.appassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sz.nuist.appassignment.Repository.CartDao;
import sz.nuist.appassignment.Repository.GoodsDao;
import sz.nuist.appassignment.Repository.SalesDao;
import sz.nuist.appassignment.domin.Cart;
import net.sf.json.*;
import sz.nuist.appassignment.domin.Goods;

import java.util.*;

@RestController
public class CartController {
    @Autowired
    private CartDao cartDao;
    private List<Cart> cartlist = new ArrayList<Cart>();
    @Autowired
    private SalesDao salesDao;
    @Autowired
    private GoodsDao goodsDao;
    private Cart cart = new Cart();
    private Goods goods;


    @RequestMapping("/setCart")
    public String setCart(Model stockinfo, Integer goodsid, Integer amount, Integer customerid) {
        cartDao.setCart(customerid, goodsid, amount);
        return "";
    }


    @RequestMapping("/getCart")
    public List<Cart> getCart(Model cartinfo, Integer customerid) {
        cartlist = cartDao.getCart(customerid);
        if (cartlist==null) {
            cartinfo.addAttribute("cartinfo", "Your cart is empty");
        }
        return cartlist;
    }


    @RequestMapping("/userOrder")
    public String userOrder(String submitid, Integer customerid,Model stockinfo) {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        JSONArray json=JSONArray.fromObject(submitid);
        JSONObject jsonObject;
        Integer total=0;
        for (int i = 0; i < json.size(); i++) {
            Integer sid =Integer.parseInt(json.getString(i));
//            jsonObject=json.getJSONObject(i);
//            System.out.println(jsonObject.get("sid"));  如果有key的话用这种方法

            cart=cartDao.getCartbyId(sid);
            goods=goodsDao.getStock(cart.getGoodsid());
            total=total+cart.getPrice()*cart.getAmount();
            Integer amount=goods.getStock()-cart.getAmount();
            if(amount < 0){
                stockinfo.addAttribute("stockinfo","The goods:"+goods.getGoodsname()+"'s stock is lesser than your order,please set your order again");
                break;
            }
            goodsDao.updateStock(amount,cart.getGoodsid());
            salesDao.setSales(customerid,cart.getGoodsid(),cart.getAmount(),date,total);
            cartDao.deleteCartbyId(sid);
        }
            return "";
    }

    @RequestMapping("/deleteUserOrder")
    public String deleteUserOrder(String deleteid,Integer customerid){
        JSONArray json=JSONArray.fromObject(deleteid);
        for(int j=0;j<json.size();j++){
            Integer did=Integer.parseInt(json.getString(j));
            cartDao.deleteCartbyId(did);
        }

        return "";
    }
    @RequestMapping("/priceQuery")
    public Integer getPrice(String priceid){
        Integer total=0;
        JSONArray json=JSONArray.fromObject(priceid);
        for(int n=0;n<json.size();n++){
            Integer pid=Integer.parseInt(json.getString(n));
            Cart price=new Cart();
            price=cartDao.getCartbyId(pid);
            total=total+price.getPrice()*price.getAmount();
        }
        return total;
    }
}
