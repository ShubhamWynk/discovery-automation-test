
package model.request.hitMachine.updateAssortment;

import java.util.List;
import lombok.Data;

@Data
public class UpdateAssortmentsReq {
    private List<String> campaignIds;
    private String contentType;
    private String id;
    private Boolean isActive;
    private String title;
}
