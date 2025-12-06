
package model.request.zion.layout.module.createModule;

import java.util.List;


import lombok.Data;
import model.request.common.SupportedClient;
import model.response.zion.layout.section.getSectionDetails.Content;

@Data
public class CreateModuleReq {
    private String actionType;
    private Boolean active;
    private Content content;
    private String contentActionType;
    private Meta meta;
    private String realm;
    private List<SupportedClient> supportedClients;
    private String templateKey;
    private String title;
}
