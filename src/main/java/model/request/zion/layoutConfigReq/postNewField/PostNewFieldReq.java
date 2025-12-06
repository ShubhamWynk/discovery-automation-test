
package model.request.zion.layoutConfigReq.postNewField;

import lombok.Data;

@Data
public class PostNewFieldReq {
    private String action;
    private Attributes attributes;
    private String category;
    private Boolean frequentlyUsed;
    private String key;
    private Meta meta;
    private String realm;
    private String source;
    private String templateKey;
    private String title;
    private String type;
}
