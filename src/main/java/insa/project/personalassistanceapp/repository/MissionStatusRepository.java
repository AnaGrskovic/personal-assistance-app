package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionStatusRepository extends JpaRepository<MissionStatus, Long> {
}
