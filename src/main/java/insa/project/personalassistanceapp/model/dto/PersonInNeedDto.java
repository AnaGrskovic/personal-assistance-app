package insa.project.personalassistanceapp.model.dto;

import insa.project.personalassistanceapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInNeedDto {
    private Long userId;
    private Long personInNeedId;
    private Role role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
