package model.response.userGrowth.template;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CreateTemplateRequestPayload {
    public boolean active;
    public boolean appRefreshInBackground;
    public long createdOn;
    public String languageCode;
    public boolean largeIcon;
    public String largeIconUrl;
    public long lastUpdatedOn;
    public boolean makeNotificationSticky;
    public ArrayList<String> platform;
    public TemplateConfig templateConfig;
    public String messageSubtitle;
    public CatalogConfig catalogConfig;
    public String name;
    public String description;
    public String smsHeader;
    public String smsTemplateId;
    public String smsType;
    public String messageTitle;
    public String messageBody;
    public ArrayList<Collection> collections;
    public EsConfig esConfig;
    public ArrayList<RichContent> richContents;
    public Action action;

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
        public ContentConfig contentConfig;
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
    public static class PlaceholderMapping{
        public String actionValue;
        public String artwork;
        public String movieId;
        public String type;
        public String movieName;
        public String cp;
        public String usl;
    }

    @Data
    public static class RichContent{
        public String type;
        public String value;
    }
}
