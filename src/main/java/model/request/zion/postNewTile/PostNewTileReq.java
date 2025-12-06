
package model.request.zion.postNewTile;

import java.util.List;


import lombok.Data;

@Data
public class PostNewTileReq {
    private String aspectRatio;
    private String deepLink;
    private String displayTitle;
    private String entity;
    private String entityId;
    private String realm;
    private List<String> regions;
    private String segmentId;
    private String status;
    private String thumbnailUrl;
    private String title;
    private String type;
}
