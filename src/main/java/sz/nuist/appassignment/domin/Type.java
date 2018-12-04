package sz.nuist.appassignment.domin;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Type {
    @Id
    private Integer typeid;
    private String typename;

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
