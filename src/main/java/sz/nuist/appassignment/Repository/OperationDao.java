package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Operation;

import javax.transaction.Transactional;
import java.sql.Date;

@Repository
public interface OperationDao extends JpaRepository<Operation,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "INSERT INTO operation(goodsid,adminid,adminOperation,operationDate) VALUES(?1,?2,?3,?4)")
    Integer operationRecord(@Param("goodsid") Integer goodsid, @Param("adminid") Integer adminid, @Param("adminoperation") String adminoperation, @Param("operationdate")Date operationdate);

}
