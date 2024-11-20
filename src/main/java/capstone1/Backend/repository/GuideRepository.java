package capstone1.Backend.repository;

import capstone1.Backend.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Integer> {
    // LIKE 검색
    @Query(value = "SELECT * FROM OBD_Diagnostic_Guide " +
            "WHERE errCode LIKE %:errCode% " +
            "AND (carType LIKE %:carType% OR carType = 'All')", nativeQuery = true)
    List<Guide> findByErrCode(@Param("errCode") String errCode, @Param("carType") String carType);

    // LIKE 검색
    @Query(value = "SELECT * FROM OBD_Diagnostic_Guide " +
            "WHERE carType LIKE %:carType% OR carType = 'All'", nativeQuery = true)
    List<Guide> findAllByCarType(@Param("carType") String carType);

    Guide findByErrId(int errId);
}
