package insa.project.personalassistanceapp.model;

import insa.project.personalassistanceapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    protected Long userId;
    protected Role role;
    protected String username;
    protected String password;

}
