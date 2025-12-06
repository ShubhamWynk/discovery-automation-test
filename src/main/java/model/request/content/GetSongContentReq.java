
package model.request.content;

import lombok.Data;

@Data
public class GetSongContentReq {
    private int pageNo;
    private int pageSize;
    private String query;
    private String sort;
}
