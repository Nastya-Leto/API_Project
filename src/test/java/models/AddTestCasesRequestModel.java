package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.List;

@Data
public class AddTestCasesRequestModel {

    String title,refs;
    Timespan estimate;
    Integer type_id, priority_id,template_id,section_id;
    List<ListStepsData> custom_steps_separated;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListStepsData {

        private String content, expected;


    }

}
