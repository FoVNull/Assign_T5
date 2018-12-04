package sz.nuist.appassignment.controller;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sz.nuist.appassignment.Repository.GoodsDao;
import sz.nuist.appassignment.Repository.SalesDao;
import sz.nuist.appassignment.domin.Goods;
import sz.nuist.appassignment.domin.Sales;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SalesController {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SalesDao salesDao;
    private List<Sales> salesList=new ArrayList<Sales>();

    @RequestMapping("/getSalesList")
    public List<Sales> getSalesList(Integer tid){
        if(tid==0) {
            salesList = salesDao.getSalesList();
            return salesList;
        }
        else{
            salesList = salesDao.getSalesListByTid(tid);
            return salesList;
        }
    }

    @RequestMapping("/getAllList")
    public  List<Sales> getAllList(Integer tid){
        if(tid==0){
            salesList=salesDao.getAllList();
            return salesList;
        }
        else {
            salesList=salesDao.getAllListByTid(tid);
            return salesList;
        }
    }

    @RequestMapping("/getAmountList")
    public  List<Sales> getAmountList(Integer tid){
        if(tid==0) {
            salesList = salesDao.getAmountList();
            return salesList;
        }
        else{
            salesList=salesDao.getAmountListByTid(tid);
            return salesList;
        }
    }

    @RequestMapping("confirmSaleOrder")
    public String confirmSaleOrder(Integer adminid,String submitid){
        JSONArray json=JSONArray.fromObject(submitid);
        JSONObject jsonObject;
        Integer total=0;
        for (int i = 0; i < json.size(); i++) {
            Integer sid = Integer.parseInt(json.getString(i));
            salesDao.confirmSaleOrder(adminid,sid);
        }
        return "";
    }

    @RequestMapping("/getListByUid")
    public List<Sales> getListByUid(Integer userid){
        salesList=salesDao.getListByUid(userid);
        return salesList;
    }

    @RequestMapping("/getHistList")
    public List<Sales> getHisList(Integer userid){
        salesList=salesDao.getHisListByUid(userid);
        return salesList;
    }
}
