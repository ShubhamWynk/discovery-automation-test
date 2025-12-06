
package model.request.zion.layout.segments.postSegment;

import lombok.Data;
import model.request.zion.layout.segments.Rule;

@Data
public class PostSegment {
    private Object active;
    private Boolean allUserSegment;
    private Object childSegments;
    private String createdBy;
    private Long createdOn;
    private Object editable;
    private Object experimentId;
    private Object fallback;
    private String lastUpdatedBy;
    private Object lastUpdatedExperimentId;
    private Long lastUpdatedOn;
    private String name;
    private Object parentSegmentId;
    private String realm;
    private Rule rule;
    private Object segmentType;
    private int splitPercentage;
    private String id;
}
