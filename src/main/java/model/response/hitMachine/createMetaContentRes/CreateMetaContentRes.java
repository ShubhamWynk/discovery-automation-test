
package model.response.hitMachine.createMetaContentRes;

import java.util.List;
import lombok.Data;
import model.request.hitMachine.druckerContentMeta.ClientMeta;
import model.request.hitMachine.druckerContentMeta.ContentMeta;

@Data
public class CreateMetaContentRes {
    private List<ClientMeta> clientMetas;
    private String contentId;
    private ContentMeta contentMeta;
    private String contentType;
    private String id;
    private Boolean isActive;
    private String key;
    private String knobStrategy;
    private Long lastUpdatedOn;
    private Long createdOn;
    private String distributionStrategy;
    private String killSwitchStrategy;

}
