
package model.request.zion.layoutConfigReq.postNewPage;

import lombok.Data;

@Data
public class SegmentSection {
    private String sectionId;
    private String segmentId;
    private Boolean tagRank;
    private int weight;
}
