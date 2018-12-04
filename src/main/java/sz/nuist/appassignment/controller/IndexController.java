package sz.nuist.appassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/adminlogin")
    public String adminlogin(){
        return "admin/adminlogin";
    }

    @GetMapping("/goodslist")
    public String goodslist(){
        return "goodslist";
    }

    @GetMapping("/goodsdetail")
    public String goodsdetail(){
        return "goodsdetail";
    }

    @GetMapping("/cartlist")
    public String cartlist(){
        return "user/cartlist";
    }

    @GetMapping("/salesadmin")
    public String salesadmin(){
        return "admin/salesadmin";
    }

    @GetMapping("/salesmanage")
    public String salesmanage(){
        return "admin/salesmanage";
    }

    @GetMapping("/newgoods")
    public String newgoods(){
        return "admin/newgoods";
    }

    @GetMapping("/editgoods")
    public String editgoods(){
        return "admin/editgoods";
    }

    @GetMapping("/baseadmin")
    public String baseamin(){
        return "base/baseadmin";
    }

    @GetMapping("/basemanage")
    public String basemanage(){
        return "base/basemanage";
    }

    @GetMapping("/uploadorder")
    public String uploadorder(){
        return "base/uploadorder";
    }

    @GetMapping("/user")
    public String user(){
        return "user/user";
    }
}
