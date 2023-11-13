package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalInChargeDto {
    //TODO check if another field isn't necessary/is needed
    private UserDto userDto;
    private Long professionalInChargeId;

}
