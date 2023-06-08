
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSuiteResponseModel {

    String name, description, url;
    Integer id, project_id;

}
