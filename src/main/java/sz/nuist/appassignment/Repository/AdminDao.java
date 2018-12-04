package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM admin WHERE AdminName=:adminname AND Psw=:psw")
    Admin checkAdminLog(@Param("adminname") String adminname,@Param("psw") String psw);

}
