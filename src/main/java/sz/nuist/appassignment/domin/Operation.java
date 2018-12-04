package sz.nuist.appassignment.domin;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Operation {
    @Id
    private Integer adminid;
    private Integer goodsid;
    private String adminoperation;
    private Date operationdate;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public Date getOperationdate() {
        return operationdate;
    }

    public String getAdminoperation() {
        return adminoperation;
    }

    public void setAdminoperation(String adminoperation) {
        this.adminoperation = adminoperation;
    }

    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }
}
