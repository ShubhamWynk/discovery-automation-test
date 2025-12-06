
package model.response.hitMachine.getAllAssortment;

import java.util.List;
import lombok.Data;
import model.request.hitMachine.updateAssortment.UpdateAssortmentsReq;

@Data

public class GetAllAssortmentRes {
    private Long pageNo;
    private Long pageSize;
    private List<UpdateAssortmentsReq> result;
    private Long total;
}
