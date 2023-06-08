
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetListCasesResponseModel {

    String name, description, url;
    Integer suite_id, project_id;

    Timestamp created_after, created_before;


}
