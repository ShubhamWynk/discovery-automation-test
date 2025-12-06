package model.response.userGrowth.CampaignLiveForProdUsers;

import lombok.Data;

@Data
public class CampaignLiveForAllProdUsersRequest {
    public String campaignId;
    public String campaignName;
    public String createdBy;
    public boolean d1;
    public String endDate;
    public boolean isDeployable;
    public boolean isProd;
    public int pageSize;
    public String realm;
    public String scheduleCron;
    public String segmentId;
    public boolean isSegmentationTrigger;
}
