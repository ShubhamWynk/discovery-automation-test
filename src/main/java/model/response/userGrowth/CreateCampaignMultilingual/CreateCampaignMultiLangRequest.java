
package model.response.userGrowth.CreateCampaignMultilingual;

import java.util.List;

import lombok.Data;

@Data

public class CreateCampaignMultiLangRequest {
   
    private String _id;
   
    private Action action;
   
    private String createdBy;
   
    private Long createdOn;
   
    private Boolean d1;
   
    private String deliveryType;
   
    private String description;
   
    private Long endTime;
   
    private Long lastUpdatedOn;
   
    private List<String> platform;
   
    private Long priority;
   
    private String realm;
   
    private String segmentId;
   
    private Boolean stalenessAllowed;
   
    private Long startTime;
   
    private String status;
   
    private List<String> tags;
   
    private String timezone;
   
    private String title;
   
    private String type;
   
    private List<Variant> variants;

}
