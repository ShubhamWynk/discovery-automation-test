package model.response.userGrowth;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AddCampaignRequestPayload {
    public String id;
    public String title;
    public String realm;
    public String description;
    public String lastUpdatedBy;
    public String createdBy;
    public int priority;
    public long startTime;
    public String timezone;
    public long endTime;
    public ArrayList<String> platform;
    public ArrayList<String> excludePlatforms;
    public String type;
    public String status;
    public String deliveryType;
    public ArrayList<String> tags;
    public String cronExpression;
    public String segmentId;
    public ArrayList<Variant> variants;
    public boolean ignoreFrequencyCapping;
    public boolean ignoreGlobalMinimumDelay;
    public int throttlingValue;
    public boolean ignoreDNDSettings;
    public String conversionGoals;
    public Object exclusionCriteria;
    public Action action;
    public ArrayList<String> eventConfig;
    public ArrayList<String> eventType;
    public boolean overrideESIndex;
    public boolean isD1;
    public String category;
    public ArrayList<String> goals;
    public ArrayList<String> attributionWindows;
   // public boolean d1;

    @Data
    public static class TemplateInfoMap{
        public ArrayList<String> additionalProp1;
        public ArrayList<String> additionalProp2;
        public ArrayList<String> additionalProp3;
    }

    @Data
    public static class Variant{
        public String variantTag;
        public String variantName;
        public String childSegmentId;
        public String config;
        public int splitPercentage;
        public TemplateInfoMap templateInfoMap;
    }

    @Data
    public static class Action{
        public String type;
        public String value;
    }
}
