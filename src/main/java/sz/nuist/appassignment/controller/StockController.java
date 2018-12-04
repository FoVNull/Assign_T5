package sz.nuist.appassignment.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sz.nuist.appassignment.Repository.GoodsDao;
import sz.nuist.appassignment.Repository.OrderDao;
import sz.nuist.appassignment.domin.Orders;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StockController {
    @Autowired
    private OrderDao orderDao;
    private List<Orders> orders = new ArrayList<Orders>();
    @Autowired
    private GoodsDao goodsDao;

    @RequestMapping("/getStockOrders")
    @ResponseBody
    public List<Orders> getStockOrder(Integer tid){
        if(tid==0){
            orders=orderDao.getOrders();
            return orders;
        }
        else{
            orders=orderDao.getOrdersByTid(tid);
            return orders;
        }
    }
    @RequestMapping("getAllOrders")
    @ResponseBody
    public List<Orders> getAllOrders(Integer tid){
        if(tid==0){
            orders=orderDao.getAllOrders();
            return orders;
        }
        else{
            orders=orderDao.getAllOrdersByTid(tid);
            return orders;
        }
    }

    @RequestMapping("/putStockOrders")
    public String putStockOrders(HttpServletRequest request,Integer adminid,Integer goodsid,Integer amount,String supply,String tel, Model info){
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        if(!(goodsid.equals(null))||!(amount.equals(null))||!(supply.equals(null))||!(tel.equals(null))||!(adminid.equals(null))){
            orderDao.uploadorder(goodsid,amount,supply,tel,date,adminid);
        }
        else{
            info.addAttribute("upinfo","please fill all info");
        }
        return "redirect:/baseadmin";
    }

    @RequestMapping("/confirmStockOrders")
    @ResponseBody
    public String confirmStockOrders(String submitid,Integer adminid){
        JSONArray json=JSONArray.fromObject(submitid);
        JSONObject jsonObject;
        for (int i = 0; i < json.size(); i++) {
            jsonObject = json.getJSONObject(i);
            Integer oid= Integer.parseInt(jsonObject.get("oid").toString());
            Integer num = Integer.parseInt(jsonObject.get("num").toString());
            Integer gid = Integer.parseInt(jsonObject.get("gid").toString());
            goodsDao.updateStock(num,gid);
            orderDao.confirmStockOrders(adminid,oid);
        }
        return "";
    }
}
