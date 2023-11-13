package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDto {
    //TODO check if another field isn't necessary/is needed
    private UserDto userDto;
    private Long volunteerId;
    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private String country;
}
