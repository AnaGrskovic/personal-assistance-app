package insa.project.personalassistanceapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mission_status")
public class MissionStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_status_id")
    private Long missionStatusId;

    @Column(name="mission_status_name")
    private String missionStatusName;

}
