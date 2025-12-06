
package model.request.hitMachine.druckerContentMeta;

import java.util.List;
import lombok.Data;

@Data
public class DrukerContentMetaReq {
    private List<ClientMeta> clientMetas;
    private String contentId;
    private ContentMeta contentMeta;
    private String contentType;
    private String distributionStrategy;
    private Boolean isActive;
    private String key;
    private String killSwitchStrategy;
    private String knobStrategy;
}
