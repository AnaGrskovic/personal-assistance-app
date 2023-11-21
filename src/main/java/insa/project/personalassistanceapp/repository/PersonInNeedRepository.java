package insa.project.personalassistanceapp.repository;

import insa.project.personalassistanceapp.model.PersonInNeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonInNeedRepository extends JpaRepository<PersonInNeed, Long> {
    @Query("""
            SELECT pin FROM PersonInNeed pin
            WHERE pin.user.username = :username
                        """)
    Optional<PersonInNeed> findByUsername(@Param("username") String username);
}
