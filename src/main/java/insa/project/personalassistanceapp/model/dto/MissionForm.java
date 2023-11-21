package insa.project.personalassistanceapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionForm {
    private String personInNeedUsername;
    private String volunteerUsername;
    private String missionName;
    private String missionDescription;
}
