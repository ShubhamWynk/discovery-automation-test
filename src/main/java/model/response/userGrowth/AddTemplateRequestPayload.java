package model.response.userGrowth;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AddTemplateRequestPayload {
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
    public String backgroundColor;
    public boolean largeIcon;
    public String largeIconUrl;
    public boolean makeNotificationSticky;
    public boolean appRefreshInBackground;
    public String createdBy;
    public int createdOn;
    public String lastUpdatedBy;
    public int lastUpdatedOn;
    public CatalogConfig catalogConfig;
    public EsConfig esConfig;
    public TemplateConfig templateConfig;
    public ArrayList<RichContent> richContents;
    public String whatsappTemplateId;
    public Action action;
    public ArrayList<String> whatsappDynamicHeaders;
    public ArrayList<String> whatsappDynamicBody;
    public ArrayList<String> whatsappDynamicFooters;
    public ArrayList<Collection> collections;
    public String smsType;
    public String smsTemplateId;
    public String smsHeader;

    @Data
    public static class TemplateConfig{
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class Action{
        public String type;
        public String value;
    }

    @Data
    public static class CatalogConfig{
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class Collection{
        public String collectionId;
        public String collectionType;
        public ContentConfig contentConfig;
        public Params params;
    }

    @Data
    public static class ContentConfig{
        public String contentFetchingStrategy;
    }

    @Data
    public static class EsConfig{
        public PlaceholderMapping placeholderMapping;
    }

    @Data
    public static class Params{
        public String additionalProp1;
        public String additionalProp2;
        public String additionalProp3;
    }

    @Data
    public static class PlaceholderMapping{
        public String additionalProp1;
        public String additionalProp2;
        public String additionalProp3;
    }

    @Data
    public static class RichContent{
        public String type;
        public String value;
        public String fallbackValue;
        public String id;
    }
}
