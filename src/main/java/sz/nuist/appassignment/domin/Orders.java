package sz.nuist.appassignment.domin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    private Integer orderid;
    private Integer goodsid;
    private Integer ordernum;
    private String supply;
    private String supplytel;
    private Date orderdate;
    private Integer status;
    private Integer putadminid;
    private Integer setadminid;

    private Integer typeid;

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public String getSupply() {
        return supply;
    }

    public String getSupplyTel() {
        return supplytel;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public void setSupplyTel(String supplytel) {
        this.supplytel = supplytel;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getPutadminid() {
        return putadminid;
    }

    public void setPutadminid(Integer putadminid) {
        this.putadminid = putadminid;
    }

    public Integer getSetadminid() {
        return setadminid;
    }

    public void setSetadminid(Integer setadminid) {
        this.setadminid = setadminid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getTypeid() {
        return typeid;
    }
}
