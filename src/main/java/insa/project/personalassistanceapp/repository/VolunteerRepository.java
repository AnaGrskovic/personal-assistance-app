package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    @Query("""
            SELECT v FROM Volunteer v
            WHERE v.user.username = :username
                        """)
    Optional<Volunteer> findByUsername(@Param("username") String username);
}
