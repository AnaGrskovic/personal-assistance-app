package insa.project.personalassistanceapp.model;

import insa.project.personalassistanceapp.util.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PersonInNeed extends User {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public PersonInNeed(String username, String password, String firstName, String lastName, Date dateOfBirth, String address, String city, String postalCode, String country) {
        this.role = Role.PERSON_IN_NEED;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }
}
