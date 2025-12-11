package model.Common.arsenalCollection;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ArsenalCollectionResponse {
    public String id;
    public String collectionId;
    public String realm;
    public String type;
    public String status;
    public String category;
    public ArrayList<String> languages;
    public Object regions;
    public String title;
    public String subtitle;
    public String description;
    public Object isImmersive;
    public Object owner;
    public Object promoterDeeplink;
    public Object logoUrl;
    public Object videoUrl;
    public Object cps;
    public Object contentTypes;
    public Object extra;
    public ArrayList<Content> contents;
    public Object sortStrategy;
    public DynamicMeta dynamicMeta;
    public int cacheTime;
    public Artworks artworks;
    public Object mTags;
    public ArrayList<Object> tags;
    public Object xFilters;
    public Object xAppKey;
    public Object xPageLink;

    @Data
    public class Artworks{
    }

    @Data
    public class Content{
        public String type;
        public String contentId;
        public int position;
        public Extras extras;
    }

    @Data
    public class DynamicMeta{
        public Object functionName;
        public Object useCase;
        public boolean isFollowable;
        public String refreshType;
        public Object protocol;
        public MixParam mixParam;
        public String functionType;
        public String url;
        public Object collectionId;
    }

    @Data
    public class Extras{
        public String _title;
        public String _modelSource;
        public String _tile_entity_id;
        public String _tile_entity;
    }

    @Data
    public class MixParam{
        public Object sourceStrategy;
        public String useCase;
        public Object sortStrategy;
        public Object filterStrategy;
        public Object mixOperator;
        public int itemPerMix;
        public int minItemPerMix;
        public int mixCount;
        public Object multiSourceRequest;
        public Object postProcessing;
        public Object noir;
        public Object zionUIDisplay;
        public Params params;
    }

    @Data
    public class Params{
        public ArrayList<String> models;
    }
}
