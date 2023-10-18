package insa.project.personalassistanceapp.mapper;

import insa.project.personalassistanceapp.model.ProfessionalInCharge;
import insa.project.personalassistanceapp.model.dto.ProfessionalInChargeDto;
import insa.project.personalassistanceapp.model.dto.ProfessionalInChargeForm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ProfessionalInChargeMapper {
    ProfessionalInCharge mapFormToObject(ProfessionalInChargeForm professionalInChargeForm);

    ProfessionalInChargeDto mapObjectToDto(ProfessionalInCharge professionalInCharge);
}
