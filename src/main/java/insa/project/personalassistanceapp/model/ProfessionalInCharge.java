package insa.project.personalassistanceapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "professional_in_charge")
public class ProfessionalInCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_in_charge_id")
    private Long professionalInChargeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
