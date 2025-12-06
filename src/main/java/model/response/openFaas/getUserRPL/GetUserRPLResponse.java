
package model.response.openFaas.getUserRPL;

import java.util.List;
import lombok.Data;


@Data
public class GetUserRPLResponse {
    private List<Content> contents;
    private DynamicMeta dynamicMeta;
}
