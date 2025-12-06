
package model.request.zion.layoutConfigReq.PostNewSection;

import java.util.List;
import lombok.Data;
import model.response.zion.layoutConfig.getPage.SegmentModule;

@Data
public class PostNewSectionReq {
    private String id;
    private Long moduleLimit;
    private String realm;
    private List<SegmentModule> segmentModules;
    private String title;
    private String type;
}
