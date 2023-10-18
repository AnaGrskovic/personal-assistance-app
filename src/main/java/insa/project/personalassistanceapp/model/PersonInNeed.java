package insa.project.personalassistanceapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInNeed {
    private User user;
    private Long personInNeedId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
