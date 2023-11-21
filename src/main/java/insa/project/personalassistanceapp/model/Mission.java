package insa.project.personalassistanceapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id", updatable = false, nullable = false)
    private Long missionId;

    @ManyToOne
    @JoinColumn(name = "person_in_need_id")
    private PersonInNeed personInNeed;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "mission_status_id")
    private MissionStatus missionStatus;

}
