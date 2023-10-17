package insa.project.personalassistanceapp.model.dto;

import insa.project.personalassistanceapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalInChargeDto {
    //TODO check if another field isn't necessary/is needed
    private Long userId;
    private Long professionalInChargeId;
    private Role role;
    private String username;
    private String password;
}
