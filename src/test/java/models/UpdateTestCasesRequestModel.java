package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.List;

@Data
public class UpdateTestCasesRequestModel {

    String title,refs;
    Timespan estimate;
    Integer type_id, priority_id,section_id,case_id;

}
