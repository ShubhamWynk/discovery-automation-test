
package model.response.openFaas.getUserRPL;

import lombok.Data;

@Data
public class Content {
    private String contentId;
    private Long lastupdated;
    private Long position;
    private String type;
}
