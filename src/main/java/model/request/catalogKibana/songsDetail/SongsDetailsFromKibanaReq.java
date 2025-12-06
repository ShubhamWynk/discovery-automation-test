
package model.request.catalogKibana.songsDetail;

import java.util.List;
import lombok.Data;

@Data
public class SongsDetailsFromKibanaReq {
    private List<String> _source;
    private Query query;
    private Long size;
}
