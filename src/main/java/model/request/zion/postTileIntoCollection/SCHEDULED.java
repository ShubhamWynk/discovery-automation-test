
package model.request.zion.postTileIntoCollection;


import lombok.Data;

@Data
public class SCHEDULED {
    private Long availableFrom;
    private Long availableTill;
    private String collectionId;
    private String id;
    private String location;
    private String status;
    private String type;
}
