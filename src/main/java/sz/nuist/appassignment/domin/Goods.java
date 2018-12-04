package sz.nuist.appassignment.domin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    private Integer goodsid;
    private String goodsname;
    private String intro;
    private Integer typeid;
    private Integer price;
    private Integer stock;
    private String img;
    private String img2;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "goodsid")
    private List<Sales> sales=new ArrayList<>();


    public Integer getGoodsid() {
        return goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public Integer getPrice() {
        return price;
    }

    public String getIntro() {
        return intro;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImg1() {
        return img;
    }

    public String getImg2() {
        return img2;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImg1(String img) {
        this.img = img;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
}
