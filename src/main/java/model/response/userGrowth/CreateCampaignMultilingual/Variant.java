
package model.response.userGrowth.CreateCampaignMultilingual;


import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data

public class Variant {

   
    private String childSegmentId;
   
    private Map<String, List<String>> templateInfoMap;
   
    private String variantName;
   
    private String variantTag;

}
