package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Sales;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface SalesDao extends JpaRepository<Sales,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO sales(customerId,goodsId,salenum,saleDate,saleprice) VALUES (?1,?2,?3,?4,?5)")
    Integer setSales(@Param("customerid") Integer customerid, @Param("goodsid") Integer goodsid, @Param("salesnum") Integer salesnum, @Param("saledate") Date saledate,@Param("saleprice") Integer saleprice);

    @Query(nativeQuery = true,value = "SELECT goodsname, salesId,customerId,goodsId,salenum,saledate,saleprice,typeid,typename,status,adminid FROM sales WHERE status=0")
    List<Sales> getSalesList();

    @Query(nativeQuery = true,value = "SELECT g.goodsname, salesId,customerId,g.goodsId,salenum,saledate,saleprice,g.typeId,typename,status,adminid FROM sales s JOIN goods g ON s.goodsId=g.goodsId WHERE g.typeId=:tid AND status=0")
    List<Sales> getSalesListByTid(@Param("tid") Integer tid);

    @Query(nativeQuery = true,value = "SELECT goodsname, salesId,customerId,goodsId,salenum,saledate,saleprice,typeid,typename,status,adminid FROM sales")
    List<Sales> getAllList();

    @Query(nativeQuery = true,value = "SELECT g.goodsname, salesId,customerId,g.goodsId,salenum, saledate,saleprice,g.typeId,typename,status,adminid FROM sales s JOIN goods g ON s.goodsId=g.goodsId WHERE g.typeId=:tid")
    List<Sales> getAllListByTid(@Param("tid") Integer tid);

    @Query(nativeQuery = true,value = "SELECT g.goodsname, SUM(salenum) salenum,s.goodsid,SUM(saleprice) saleprice,salesId,customerId,saleDate,t.typeName,g.typeId,adminid,status FROM sales s JOIN goods g ON s.goodsId=g.goodsId JOIN type t ON g.typeId=t.typeId GROUP BY goodsid")
    List<Sales> getAmountList();

    @Query(nativeQuery = true,value = "SELECT g.goodsname, SUM(salenum) salenum,s.goodsid,SUM(saleprice) saleprice,salesId,customerId,saleDate,t.typeName,g.typeId,adminid,status FROM sales s JOIN goods g ON s.goodsId=g.goodsId JOIN type t ON g.typeId=t.typeId GROUP BY goodsid HAVING g.typeId=:tid ")
    List<Sales> getAmountListByTid(@Param("tid") Integer tid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE sales SET status=1,adminid=:adminid WHERE salesid=:salesid")
    Integer confirmSaleOrder(@Param("adminid") Integer adminid,@Param("salesid") Integer salesid);

    @Query(nativeQuery = true,value = "SELECT salesId,customerId,s.goodsid,adminid,status,s.typeid,s.typename,saledate,g.goodsName,salenum,saleprice FROM sales s JOIN goods g ON s.goodsId=g.goodsId WHERE customerId=:uid AND status=0 ORDER BY saledate DESC ")
    List<Sales> getListByUid(@Param("uid") Integer uid);

    @Query(nativeQuery = true,value = "SELECT salesId,customerId,s.goodsid,adminid,status,s.typeid,s.typename,saledate,g.goodsName,salenum,saleprice FROM sales s JOIN goods g ON s.goodsId=g.goodsId WHERE customerId=:uid AND status=1 ORDER BY saledate DESC ")
    List<Sales> getHisListByUid(@Param("uid") Integer uid);
}
