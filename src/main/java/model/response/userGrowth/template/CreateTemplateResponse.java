
package model.response.userGrowth.template;

import lombok.Data;

import java.util.List;

@Data
public class CreateTemplateResponse {
    private Action action;
    private Boolean active;
    private String type;
    private String realm;
    private Boolean appRefreshInBackground;
    private Object backgroundColor;
    private CatalogConfig catalogConfig;
    private List<Collection> collections;
    private Object createdBy;
    private Object createdOn;
    private String description;
    private EsConfig esConfig;
    private String id;
    private String languageCode;
    private Boolean largeIcon;
    private String largeIconUrl;
    private Object lastUpdatedBy;
    private Object lastUpdatedOn;
    private Boolean makeNotificationSticky;
    private String messageBody;
    private String messageSubtitle;
    private String messageTitle;
    private String name;
    private List<String> platform;
    private List<RichContents> richContents;
    private String smsHeader;
    private String smsTemplateId;
    private String smsType;
    private Object templateConfig;
    private Object whatsappDynamicBody;
    private Object whatsappDynamicFooters;
    private Object whatsappDynamicHeaders;
    private Object whatsappTemplateId;
}
