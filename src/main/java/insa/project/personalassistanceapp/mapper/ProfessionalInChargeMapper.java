package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.ProfessionalInCharge;
import insa.project.personalassistanceapp.model.dto.ProfessionalInChargeDto;
import insa.project.personalassistanceapp.model.dto.ProfessionalInChargeForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProfessionalInChargeMapper {

    @Mapping(source = "userForm", target = "user")
    ProfessionalInCharge mapFormToObject(ProfessionalInChargeForm professionalInChargeForm);

    @Mapping(source = "user", target = "userDto")
    ProfessionalInChargeDto mapObjectToDto(ProfessionalInCharge professionalInCharge);
}
