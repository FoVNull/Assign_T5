package sz.nuist.appassignment.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sz.nuist.appassignment.Repository.CustomerDao;
import sz.nuist.appassignment.domin.Customer;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@RestController//spring自动把return变为json,若想返回页面用controller注释
@Controller
public class CustomerInfo {
    @Autowired
    private CustomerDao customerDao;
    private Customer cus=new Customer();
    private Encryption encryption=new Encryption();
    private Filter filter=new Filter();
    private  Customer cusn=new Customer();


    @RequestMapping(value="/checkUserLog")
    public String checklog(HttpServletRequest request, HttpServletResponse response,Model check){
        String username = request.getParameter("username");
        String psw = request.getParameter("psw");
        psw= encryption.SHA256(psw);
        String str="";
        cus= customerDao.checklogin(username,psw);

        if(cus!=null){
            Cookie usercookie = new Cookie("username",username);
            usercookie.setMaxAge(2*60*60);
            Cookie useridcookie = new Cookie("userid",cus.getId().toString());
            useridcookie.setMaxAge(2*60*60);
            response.addCookie(usercookie);
            response.addCookie(useridcookie);
            str="redirect:/";
        }
        else{
            check.addAttribute("checklog","用户名或密码错误");
            str="user/login";
        }
        return str;
    }


    @RequestMapping(value = "/regController")
    public String register(HttpServletRequest request, HttpServletResponse response,Model reginfo) {
        String username = request.getParameter("username");
        String psw = request.getParameter("password");
        String repsw = request.getParameter("repassword");
        String str = "";
        cusn= customerDao.checkname(username);
        if (!(psw.equals(repsw))) {
            reginfo.addAttribute("checkreg", "两次密码不一致");
            str = "user/register";
//            return str;
        }
        else if (filter.Filter(psw) || filter.Filter(username)) {
            reginfo.addAttribute("checkreg", "注册信息包含非法字符");
            str = "user/register";
//           return str;
        }
            else if (username.length() > 10 || psw.length() > 10 || psw.length() < 6) {
                reginfo.addAttribute("checkreg", "用户名或密码长度不对");
                str = "user/register";
//                return str;
        }
                else if(cusn!=null){
                    reginfo.addAttribute("checkreg","用户名已存在");
                    str="user/register";
        }
                     else {
                        psw = encryption.SHA256(psw);
                        Integer customerid = 10000+(int) (Math.random() * 90000);
                        //(char)('a'+Math.random()*('z'-'a'+1));
                        Customer checkid=customerDao.checkid(customerid);
                        while (checkid!=null) {
                            customerid= 10000+(int) (Math.random() * 90000);
                            checkid=customerDao.checkid(customerid);
                        }
                        customerDao.register(customerid, username, psw);
                        str = "redirect:login";
                        //return str;
        }
        return str;
    }
}
