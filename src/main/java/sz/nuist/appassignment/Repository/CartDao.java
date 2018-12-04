package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Cart;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO Cart(customerid,goodsid,amount) VALUES(?1,?2,?3) ")
    Integer setCart(@Param("customerid") Integer customerid,@Param("goodsid") Integer goodsid,@Param("amount") Integer amount);

    @Query(nativeQuery = true,value = "SELECT cartid,c.goodsId,g.goodsName,g.Price,amount,g.img,customerid,g.stock FROM cart c JOIN goods g ON c.goodsId=g.goodsId WHERE customerId=:customerid")
    List<Cart> getCart(@Param("customerid") Integer customerid);

    @Query(nativeQuery = true,value = "SELECT cartid,c.goodsId,g.goodsName,g.Price,amount,g.img,customerid,g.stock FROM cart c JOIN goods g ON c.goodsId=g.goodsId WHERE cartid=:cartid")
    Cart getCartbyId(@Param("cartid") Integer cartid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "DELETE FROM Cart WHERE cartid=:cartid")
    Integer deleteCartbyId(@Param("cartid") Integer cartid);
}
