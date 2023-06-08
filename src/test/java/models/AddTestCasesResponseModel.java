package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTestCasesResponseModel {

    String title, refs;
    Integer id, section_id, template_id, type_id, priority_id, milestone_id, created_by;


}
