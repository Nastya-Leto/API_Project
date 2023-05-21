package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTestCasesResponseModel {

    String title;

    List<UpdateTestCasesResponseModel.ListCaseData> custom;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListCaseData {

        private String line, column;
    }
}
