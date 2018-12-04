# Assign_T5
Assignment of term 5. -Online Shop

IntelliJ IDEA;<br>
Spring boot -2.0.6<br>

项目结构<br>
controller:控制器<br>
domin:实体<br>
Repository:数据访问<br>
static:静态文件<br>
Template:视图<br>
Tree(部分)+文件说明：<br>
<pre>
├─src
│  ├─main
│  │  ├─java
│  │  │  └─sz
│  │  │      └─nuist
│  │  │          └─appassignment
│  │  │              │  AppassignmentApplication.java 启动器
│  │  │              │  
│  │  │              ├─controller
│  │  │              │      AdminInfo.java  管理员信息
│  │  │              │      CartController.java  购物车
│  │  │              │      CustomerInfo.java 用户
│  │  │              │      Encryption.java   加密
│  │  │              │      Filter.java     过滤器
│  │  │              │      GoodsInfo.java   商品
│  │  │              │      IndexController.java  Thymeleaf视图控制
│  │  │              │      SalesController.java  订单
│  │  │              │      StockController.java  库存
│  │  │              │      TypeController.java   商品类型
│  │  │              │      
│  │  │              ├─domin
│  │  │              │      Admin.java
│  │  │              │      Cart.java
│  │  │              │      Customer.java
│  │  │              │      Goods.java
│  │  │              │      Operation.java
│  │  │              │      Orders.java
│  │  │              │      Sales.java
│  │  │              │      Type.java
│  │  │              │      
│  │  │              └─Repository
│  │  │                      AdminDao.java
│  │  │                      CartDao.java
│  │  │                      CustomerDao.java
│  │  │                      GoodsDao.java
│  │  │                      OperationDao.java
│  │  │                      OrderDao.java
│  │  │                      SalesDao.java
│  │  │                      TypeDao.java
│  │  │                      
│  │  └─resources
│  │      │  application.properties   spring boot配置
│  │      │  
│  │      ├─static
│  │      │  ├─css
│  │      │  │          
│  │      │  ├─img
│  │      │  │      
│  │      │  ├─script
│  │      │  │   
│  │      │  └─video
│  │      │   
│  │      │          
│  │      └─templates
│  │          │  goodsdetail.html   商品详情
│  │          │  goodslist.html     商品列表
│  │          │  index.html         主页
│  │          │  
│  │          ├─admin
│  │          │      adminlogin.html  管理员登录
│  │          │      editgoods.html   编辑商品
│  │          │      newgoods.html    上传商品
│  │          │      salesadmin.html  销售管理员主页
│  │          │      salesmanage.html 销售管理员功能界面
│  │          │      
│  │          ├─base
│  │          │      baseadmin.html   库存管理员主页
│  │          │      basemanage.html  库存管理员功能界面
│  │          │      uploadorder.html 上传订货订单
│  │          │      
│  │          └─user
│  │                  cartlist.html  购物车列表
│  │                  login.html     用户登录
│  │                  register.html  用户注册
│  │                  user.html    用户主页，历史订单
│  │                  
│  └─test
│  
│                          
└

</pre>
