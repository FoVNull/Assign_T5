package sz.nuist.appassignment.domin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    private Integer adminid;
    private String adminname;
    private String psw;
    private String role;
    @GeneratedValue

    public void setAdminId(Integer adminid){
        this.adminid=adminid;
    }
    public void setAdminName(String adminname){
        this.adminname=adminname;
    }
    public void setPsw(String psw){
        this.psw=psw;
    }
    public void setRole(String role){
        this.role=role;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public String getAdminName() {
        return adminname;
    }

    public String getPsw() {
        return psw;
    }

    public String getRole() {
        return role;
    }
}
