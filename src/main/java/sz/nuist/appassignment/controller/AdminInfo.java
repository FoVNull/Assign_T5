package sz.nuist.appassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sz.nuist.appassignment.Repository.AdminDao;
import sz.nuist.appassignment.domin.Admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminInfo {
    @Autowired
    private AdminDao adminDao;
    private Encryption encryption=new Encryption();
    private Admin admin=new Admin();

    @RequestMapping("/checkAdminLog")
    public String checkAdminLog(HttpServletRequest request, HttpServletResponse response, Model check){
        String adminname=request.getParameter("adminname");
        String psw=request.getParameter("psw");
        //psw=encryption.SHA256(psw);
        String str="";
        admin=adminDao.checkAdminLog(adminname,psw);
        if (admin!=null){
            Cookie admincookie = new Cookie("role",admin.getRole());
            admincookie.setMaxAge(2*60*60);
            response.addCookie(admincookie);
            Cookie adminidcookie = new Cookie("adminid",admin.getAdminid().toString());
            admincookie.setMaxAge(2*60*60);
            response.addCookie(adminidcookie);
            if(admin.getRole().equals("salesadmin")){
                str="redirect:/salesadmin";
            }
            if(admin.getRole().equals("baseadmin")){
                str="redirect:/baseadmin";
            }
            if(admin.getRole().equals("SuperAdmin")){
                str="redirect:/superadmin";
            }
        }
        else {
            check.addAttribute("check","wrong");
            str="admin/adminlogin";
        }
        return str;
    }
}
