package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInNeedDto {
    private UserDto userDto;
    private Long personInNeedId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
