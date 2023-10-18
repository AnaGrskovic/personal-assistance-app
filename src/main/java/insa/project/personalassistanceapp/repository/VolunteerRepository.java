package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
