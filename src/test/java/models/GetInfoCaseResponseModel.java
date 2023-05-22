
package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetInfoCaseResponseModel {

    String refs;
    Integer id, section_id;

}
