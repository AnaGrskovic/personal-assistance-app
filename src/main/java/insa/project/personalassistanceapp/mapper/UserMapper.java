package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.User;
import insa.project.personalassistanceapp.model.dto.UserDto;
import insa.project.personalassistanceapp.model.dto.UserForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapFormToObject(UserForm userForm);

    @Mapping(source = "role.roleName", target = "roleName")
    UserDto mapObjectToDto(User user);
}
