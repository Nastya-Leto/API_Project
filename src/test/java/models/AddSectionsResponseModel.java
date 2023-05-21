package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSectionsResponseModel {

    String description,announcement,name;
    Integer depth,display_order,id,parent_id,suite_id;




}
