package sz.nuist.appassignment.domin;

import org.apache.commons.beanutils.converters.SqlDateConverter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer salesid;
    private Integer customerid;
    private Integer goodsid;
    private Integer salenum;
    private Date saledate;
    private Integer saleprice;
    private Integer status;
    private Integer adminid;
    private String typename;
    private Integer typeid;

    private String goodsname;

    @ManyToOne
    @JoinColumn(name = "goodsid", insertable = false, updatable = false)
    private Goods goods;

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }


    public Integer getSalenum() {
        return salenum;
    }

    public Integer getSalesid() {
        return salesid;
    }


    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public void setSaledate(Date saledate) {
        this.saledate = saledate;
    }

    public Date getSaledate() {
        return saledate;
    }

    public Integer getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Integer saleprice) {
        this.saleprice = saleprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypename() {
        return typename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }


    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
}
