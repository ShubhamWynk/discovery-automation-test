
package model.request.getSongsContentList;

import lombok.Data;

@Data
public class GetSongsContantListReq {
    private String language;
    private int pageNo;
    private int pageSize;
    private String sort;
}
