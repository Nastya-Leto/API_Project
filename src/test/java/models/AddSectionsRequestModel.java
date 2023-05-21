package models;

import lombok.Data;

@Data
public class AddSectionsRequestModel {

    String description, name;
    Integer suite_id, parent_id;

}
