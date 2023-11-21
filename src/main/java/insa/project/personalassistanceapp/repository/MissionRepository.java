package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
            SELECT m FROM Mission m 
            WHERE m.missionStatus.missionStatusName = :name
            """)
    List<Mission> findAllByMissionStatusName(@Param("name") String missionStatusName);
}
