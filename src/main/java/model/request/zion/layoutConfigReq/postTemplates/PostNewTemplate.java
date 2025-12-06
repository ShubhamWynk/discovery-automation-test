package model.request.zion.layoutConfigReq.postTemplates;

import java.util.List;

import lombok.Data;
import model.request.common.SupportedClient;

@Data
public class PostNewTemplate {
    private String collectionIdRequired;
    private String contentType;
    private String defaultAction;
    private String defaultContentAction;
    private String defaultSource;
    private String endpointRequired;
    private String fixedSource;
    private String key;
    private String label;
    private String realm;
    private List<SupportedClient> supportedClients;
    private String title;
}
