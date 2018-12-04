package sz.nuist.appassignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sz.nuist.appassignment.domin.Type;

import java.util.List;


@Repository
public interface TypeDao extends JpaRepository<Type,Integer> {
    @Query(nativeQuery = true,value = "SELECT * FROM type")
    List<Type> getType();
}
