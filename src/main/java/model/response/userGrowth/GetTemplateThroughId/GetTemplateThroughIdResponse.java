package model.response.userGrowth.GetTemplateThroughId;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GetTemplateThroughIdResponse {
    public String id;
    public String name;
    public String description;
    public String type;
    public String realm;
    public boolean active;
    public String messageTitle;
    public String messageSubtitle;
    public String messageBody;
    public String languageCode;
    public Object backgroundColor;
    public boolean largeIcon;
    public String largeIconUrl;
    public boolean makeNotificationSticky;
    public boolean appRefreshInBackground;
    public Object createdBy;
    public Object createdOn;
    public Object lastUpdatedBy;
    public Object lastUpdatedOn;
    public CatalogConfig catalogConfig;
    public EsConfig esConfig;
    public TemplateConfig templateConfig;
    public ArrayList<RichContent> richContents;
    public Object whatsappTemplateId;
    public Action action;
    public Object whatsappDynamicHeaders;
    public Object whatsappDynamicBody;
    public Object whatsappDynamicFooters;
    public ArrayList<Collection> collections;
    public String smsType;
    public String smsTemplateId;
    public String smsHeader;

    @Data
    public static class TemplateConfig {
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class Action {
        public String type;
        public String value;
    }

    @Data
    public static class CatalogConfig {
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class Collection {
        public String collectionId;
        public ContentConfig contentConfig;
    }

    @Data
    public static class ContentConfig {
        public String contentFetchingStrategy;
    }

    @Data
    public static class EsConfig {
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class PlaceholderMapping {
        public String movieId;
        public String type;
        public String cp;
        public String movieName;
        public String actionValue;
    }

    @Data
    public static class RichContent {
        public String type;
        public String value;
        public Object fallbackValue;
        public Object id;

    }
}
