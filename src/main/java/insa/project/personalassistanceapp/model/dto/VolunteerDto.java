package insa.project.personalassistanceapp.model.dto;

import insa.project.personalassistanceapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDto {
    //TODO check if another field isn't necessary/is needed
    private Long userId;
    private Long volunteerId;
    private Role role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private String country;
}
