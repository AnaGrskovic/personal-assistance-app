package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
