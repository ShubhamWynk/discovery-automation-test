package model.response.userGrowth.GetCampaignThroughId;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data
public class GetCampaignThroughIdResponse {
    public String id;
    public String title;
    public String realm;
    public String description;
    public long createdOn;
    public long lastUpdatedOn;
    public Object lastUpdatedBy;
    public String createdBy;
    public int priority;
    public long startTime;
    public String timezone;
    public long endTime;
    public ArrayList<String> platform;
    public Object excludePlatforms;
    public String type;
    public String status;
    public String deliveryType;
    public ArrayList<String> tags;
    public Object cronExpression;
    public String segmentId;
    public ArrayList<Variant> variants;
    public Object ignoreFrequencyCapping;
    public Object ignoreGlobalMinimumDelay;
    public Object throttlingValue;
    public Object ignoreDNDSettings;
    public Object conversionGoals;
    public Object exclusionCriteria;
    public Action action;
    public Object eventConfig;
    public Object eventType;
    public Object overrideESIndex;
    public Object stalenessFactorAllowed;
    public String category;
    public Object goals;
    public Object attributionWindows;
    public boolean d1;
    public boolean stalenessAllowed;

    @Data
    public static  class Action{
        public String type;
        public String value;
    }

    @Data
    public static class TemplateInfoMap{
        @SerializedName("FALLBACK")
        public ArrayList<String> fALLBACK;
    }

    @Data
    public static class Variant{
        public String variantTag;
        public String variantName;
        public String childSegmentId;
        public TemplateInfoMap templateInfoMap;

    }
}
