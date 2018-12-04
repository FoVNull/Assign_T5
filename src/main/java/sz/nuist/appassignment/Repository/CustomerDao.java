package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Admin;
import sz.nuist.appassignment.domin.Customer;

import javax.transaction.Transactional;


@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{
    @Query(nativeQuery = true,value = "SELECT * FROM customer WHERE Username=:username AND Psw=:psw")
    Customer checklogin(@Param("username") String username, @Param("psw") String psw);

    @Modifying
    @Transactional
    @Query(nativeQuery =true,value = "INSERT INTO customer(customerId,Username,Psw) VALUES (?1,?2,?3) ")
    Integer register(@Param("customerid") Integer customerid, @Param("username") String username, @Param("psw") String psw);

    @Query(nativeQuery = true,value = "SELECT * FROM customer WHERE customerId=:customerid")
    Customer checkid(@Param("customerid") Integer customerid);

    @Query(nativeQuery = true,value = "SELECT * FROM customer WHERE Username=:username")
    Customer checkname(@Param("username") String username);


}
