
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Timespan;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSectionsResponseModel {


    Integer offset, limit,size;
    List<GetSectionsResponseModel.ListSectionsData> sections;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListSectionsData {

        private String name;
        private Integer suite_id,id,depth,display_order;


    }




}
