package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddTestCasesResponseModel {

    String title,refs;
    Integer id,section_id,template_id,type_id
            ,priority_id,milestone_id,created_by;





}
