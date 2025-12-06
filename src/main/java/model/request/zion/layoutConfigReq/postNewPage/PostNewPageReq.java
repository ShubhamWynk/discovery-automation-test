
package model.request.zion.layoutConfigReq.postNewPage;

import java.util.List;

import lombok.Data;

@Data
public class PostNewPageReq {
    private List<String> adapterKeys;
    private String id;
    private String key;
    private String pageType;
    private List<SegmentSection> segmentSections;
    private String realm;
    private List<SegmentPage> segmentPages;
    private String title;
}
