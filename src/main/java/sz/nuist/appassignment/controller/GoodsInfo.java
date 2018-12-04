package sz.nuist.appassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sz.nuist.appassignment.Repository.CustomerDao;
import sz.nuist.appassignment.Repository.GoodsDao;
import sz.nuist.appassignment.Repository.OperationDao;
import sz.nuist.appassignment.Repository.TypeDao;
import sz.nuist.appassignment.domin.Goods;
import sz.nuist.appassignment.domin.Type;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsInfo {
    @Autowired
    private GoodsDao goodsDao;
    private List<Goods> list=new ArrayList<Goods>();
    private List<Goods> detail=new ArrayList<Goods>();
    private String path;
    @Autowired
    private OperationDao operationDao;

    @RequestMapping("/goodsList")
    @ResponseBody
    public List<Goods> goodsList(HttpServletRequest request, HttpServletResponse response, Model listinfo,Integer tid){
        if(tid==0){
            list=goodsDao.getAllGoods();
            return list;
        }
        else{
            list= goodsDao.getGoodsList(tid);
            if(list.equals(null)){
                listinfo.addAttribute("listinfo","none goods");
            }
            return list;
        }
    }

    @RequestMapping("/goodsDetail")
    @ResponseBody
    public List<Goods> goodsDetail(HttpServletRequest request, HttpServletResponse response, Model listinfo,Integer gid){
        list= goodsDao.getGoodsDetail(gid);
        if(list==null){
            listinfo.addAttribute("listinfo","none goods");
        }
        return list;
    }

    @RequestMapping("/updateGoods")
    public String updateGoods(HttpServletRequest request,Model upinfo,@RequestParam("uploaded_file") MultipartFile file){
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        Integer gid=Integer.parseInt(request.getParameter("put_gid"));
        Integer adminid=Integer.parseInt(request.getParameter("put_aid"));
        String returnstr="redirect:/editgoods?gid="+gid;
        String goodsname=request.getParameter("put_name");
        String intro=request.getParameter("put_intro");
        if (!(file.isEmpty()) && !(request.getParameter("put_name").equals(null)) && !(request.getParameter("put_price").equals(null))&& !(intro.equals(null))) {
            Integer price=Integer.parseInt(request.getParameter("put_price"));
            Integer typeid=Integer.parseInt(request.getParameter("s1"));
            String filetype = null;
            String fileName = file.getOriginalFilename();
            filetype = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if ("GIF".equals(filetype.toUpperCase())||"PNG".equals(filetype.toUpperCase())||"JPG".equals(filetype.toUpperCase())){
                String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + filetype;
                try {
                    file.transferTo(new File("E:\\IntelliJ IDEA\\IdeaProjects\\applyassignment\\src\\main\\resources\\static\\img",trueFileName));
//                    byte[] bytes = file.getBytes();
//                    Path path = Paths.get("E:\\IntelliJ IDEA\\IdeaProjects\\applyassignment\\src\\main\\resources\\static\\img\\" + trueFileName);
//                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filepath="/img/"+trueFileName;
                goodsDao.updateGoodsImg(goodsname,intro,typeid,price,filepath,gid);

                String description="update goods img/info";
                operationDao.operationRecord(gid,adminid,description,date);

            }
            else{
                upinfo.addAttribute("upinfo","imagetype can be only PNG/JPG");
                return returnstr;
            }
        }
        else if(!(request.getParameter("put_name").equals(null)) && !(request.getParameter("put_price").equals(null))&& !(intro.equals(null))){
            Integer price=Integer.parseInt(request.getParameter("put_price"));
            Integer typeid=Integer.parseInt(request.getParameter("s1"));
            goodsDao.updateGoods(goodsname,intro,typeid,price,gid);

            String description="update goods info";
            operationDao.operationRecord(gid,adminid,description,date);
        }
            else {
                upinfo.addAttribute("upinfo","please fill all of the infomation");
                return returnstr;
            }
            return "redirect:/salesadmin";
    }

    @RequestMapping("/uploadGoods")
    public String uploadGoods(HttpServletRequest request,Model upinfo,@RequestParam("uploaded_file") MultipartFile file){
        String goodsname=request.getParameter("put_name");
        String intro=request.getParameter("put_intro");
        if (!(file.isEmpty())&& !(request.getParameter("put_name").equals(null)) && !(request.getParameter("put_price").equals(null))&& !(request.getParameter("put_stock").equals(null))&& !(intro.equals(null))) {
            Integer price=Integer.parseInt(request.getParameter("put_price"));
            Integer stock=Integer.parseInt(request.getParameter("put_stock"));
            Integer typeid=Integer.parseInt(request.getParameter("s1"));
            String filetype = null;
            String fileName = file.getOriginalFilename();
            filetype = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if ("GIF".equals(filetype.toUpperCase())||"PNG".equals(filetype.toUpperCase())||"JPG".equals(filetype.toUpperCase())){
                // 项目在容器中实际发布运行的根路径，服务器路径 transferTo(path)
                //String realPath = request.getSession().getServletContext().getRealPath("/");
                // 自定义的文件名称
                String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + filetype;
                //path = realPath+trueFileName;
                // 转存文件
                try {
                    file.transferTo(new File("E:\\IntelliJ IDEA\\IdeaProjects\\applyassignment\\src\\main\\resources\\static\\img",trueFileName));
//                    byte[] bytes = file.getBytes();
//                    Path path = Paths.get("E:\\IntelliJ IDEA\\IdeaProjects\\applyassignment\\src\\main\\resources\\static\\img\\" + trueFileName);
//                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filepath="/img/"+trueFileName;
                goodsDao.uploadGoods(goodsname,intro,typeid,price,stock,filepath);
            }
            else{
                upinfo.addAttribute("upinfo","imagetype can be only PNG/JPG");
                return "admin/newgoods";
            }
        }
        else {
            upinfo.addAttribute("upinfo","please fill all of the infomation");
            return "admin/newgoods";
        }
        return "redirect:/newgoods";
    }
}
