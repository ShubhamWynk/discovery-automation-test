
package model.request.zion.layoutConfigReq.postNewPage;

import lombok.Data;

@Data
public class SegmentPage {
    private Boolean isFallback;
    private String pageId;
    private String segmentId;
    private Boolean tagRank;
}
