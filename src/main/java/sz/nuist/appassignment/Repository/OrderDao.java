package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Orders;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Orders,Integer> {
    @Query(nativeQuery = true,value = "SELECT orderid,o.goodsid,ordernum,supply,supplyTel,orderDate,status,putadminid,setadminid,g.typeid FROM orders o JOIN goods g ON o.goodsid=g.goodsid WHERE status=0")
    List<Orders> getOrders();

    @Query(nativeQuery = true,value = "SELECT orderid,o.goodsid,ordernum,supply,supplyTel,orderDate,status,putadminid,setadminid,g.typeid FROM orders o JOIN goods g ON o.goodsid=g.goodsid WHERE status=0 AND g.typeid=:tid")
    List<Orders> getOrdersByTid(@Param("tid") Integer tid);

    @Query(nativeQuery = true,value="SELECT orderid,o.goodsid,ordernum,supply,supplyTel,orderDate,status,putadminid,setadminid,g.typeid FROM orders o JOIN goods g ON o.goodsid=g.goodsid")
    List<Orders> getAllOrders();

    @Query(nativeQuery = true,value="SELECT orderid,o.goodsid,ordernum,supply,supplyTel,orderDate,status,putadminid,setadminid,g.typeid FROM orders o JOIN goods g ON o.goodsid=g.goodsid WHERE g.typeid=:tid")
    List<Orders> getAllOrdersByTid(@Param("tid") Integer tid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE orders SET status=1,setadminid=:setadminid WHERE orderId=:orderid")
    Integer confirmStockOrders(@Param("setadminid") Integer setadminid,@Param("orderid") Integer orderid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value="INSERT INTO orders(goodsid,orderNum,supply,supplyTel,orderDate,putadminid,status) VALUES(?1,?2,?3,?4,?5,?6,0)")
    Integer uploadorder(@Param("goodsid") Integer goodsid, @Param("ordernum") Integer ordernum, @Param("supply") String supply, @Param("supplytel") String supplytel, @Param("orderdate")Date orderdate,@Param("putadminid") Integer putadminid);
}
