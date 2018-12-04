package sz.nuist.appassignment.domin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    private Integer customerid;
    private String username;
    private String psw;


    public Integer getId(){
        return customerid;
    }
    public String getUsername(){
        return username;
    }
    public String getPsw(){return  psw;}
    public void setId(Integer id){
        this.customerid=id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPsw(String psw){this.psw=psw;}

}
