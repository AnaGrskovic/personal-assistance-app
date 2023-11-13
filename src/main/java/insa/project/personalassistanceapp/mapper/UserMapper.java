package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.dto.UserDto;
import insa.project.personalassistanceapp.model.dto.UserForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapUserFormToUser(UserForm userForm);
    UserDto mapObjectToDto(User user);
}
