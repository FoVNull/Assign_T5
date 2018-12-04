package sz.nuist.appassignment.domin;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    private Integer cartid;
    private Integer customerid;
    private Integer goodsid;
    private Integer amount;
//    private Goods goods;

    private Integer price;

    private String img;

    private String goodsname;
//    @JoinColumn(name="goodsid")//指定在本实体所映射的那个表中关联的外键
//    @ManyToOne(targetEntity=Goods.class)
//    public Goods getGoods() {
//        return goods;
//    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCartid() {
        return cartid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    @Transient
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public void setImg1(String img) {
        this.img = img;
    }
    @Transient
    public String getImg1() {
        return img;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
    @Transient
    public String getGoodsname() {
        return goodsname;
    }

}

