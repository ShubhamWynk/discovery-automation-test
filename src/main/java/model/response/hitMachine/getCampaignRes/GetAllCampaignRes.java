
package model.response.hitMachine.getCampaignRes;

import lombok.Data;
import model.request.hitMachine.createCampaign.CreateCampaignReq;

import java.util.List;

@Data
public class GetAllCampaignRes {
    private Long pageNo;
    private Long pageSize;
    private List<CreateCampaignReq> result;
    private Long total;
}
