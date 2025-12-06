
package model.request.hitMachine.createCampaign;

import java.util.List;

import lombok.Data;

@Data
public class CreateCampaignReq {
    private String campaignName;
    private String clientKey;
    private String contentType;
    private Boolean isActive;
    private List<String> languages;
    private List<SplitPercentages> splitPercentages;
    private Long createdOn;
    private String id;
    private Long lastUpdatedOn;
}
