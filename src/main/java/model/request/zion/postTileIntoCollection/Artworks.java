
package model.request.zion.postTileIntoCollection;

import java.util.List;


import lombok.Data;


@Data
public class Artworks {
    private List<Object> ARCHIVED;
    private List<DEFAULT> DEFAULT;
    private List<SCHEDULED> SCHEDULED;
}
