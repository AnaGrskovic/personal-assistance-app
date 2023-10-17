package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerForm {
    //TODO check if another field isn't necessary/is needed
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private String postalCode;
    private String country;
}
