package sz.nuist.appassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sz.nuist.appassignment.Repository.TypeDao;
import sz.nuist.appassignment.domin.Type;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeController {
    private List<Type> type=new ArrayList<Type>();
    @Autowired
    private TypeDao typeDao;


    @RequestMapping("/getType")
    public List<Type> getType(){
        type=typeDao.getType();
        return type;
    }
}
