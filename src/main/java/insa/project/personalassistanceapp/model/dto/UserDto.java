package insa.project.personalassistanceapp.model.dto;

import insa.project.personalassistanceapp.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private Role role;
    private String username;
    private String password;
}
