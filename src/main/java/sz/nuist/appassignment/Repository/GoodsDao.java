package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Goods;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GoodsDao extends JpaRepository<Goods,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM goods")
    List<Goods> getAllGoods();


    @Query(nativeQuery = true,value = "SELECT * FROM goods WHERE TypeId=:tid")
    List<Goods> getGoodsList(@Param("tid") Integer tid);

    @Query(nativeQuery = true,value = "SELECT * FROM goods WHERE goodsId=:gid")
    List<Goods> getGoodsDetail(@Param("gid") Integer gid);

    @Query(nativeQuery = true,value = "SELECT * FROM goods WHERE goodsId=:gid1")
    Goods getStock(@Param("gid1") Integer gid1);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE goods SET stock=:amount WHERE goodsid=:goodsid ")
    Integer updateStock(@Param("amount") Integer amount,@Param("goodsid") Integer goodsid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO goods(goodsName,Intro,typeId,Price,Stock,Img) VALUES(?1,?2,?3,?4,?5,?6)")
    Integer uploadGoods(@Param("goodsname") String goodsname,@Param("intro") String intro,@Param("typeid") Integer typeid,@Param("price") Integer price,@Param("stock") Integer stock,@Param("img") String img);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE goods SET goodsname=:goodsname,price=:price,Intro=:intro,typeId=:typeid WHERE goodsid=:goodsid")
    Integer updateGoods(@Param("goodsname") String goodsname,@Param("intro") String intro,@Param("typeid") Integer typeid,@Param("price") Integer price,@Param("goodsid") Integer goodsid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE goods SET goodsname=:goodsname,price=:price,Intro=:intro,typeId=:typeid,Img=:img WHERE goodsid=:goodsid")
    Integer updateGoodsImg(@Param("goodsname") String goodsname,@Param("intro") String intro,@Param("typeid") Integer typeid,@Param("price") Integer price,@Param("img") String img,@Param("goodsid") Integer goodsid);
}
