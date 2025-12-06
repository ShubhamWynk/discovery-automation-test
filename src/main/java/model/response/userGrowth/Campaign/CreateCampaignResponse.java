
package model.response.userGrowth.Campaign;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CreateCampaignResponse {

    @SerializedName("action")
    private Action mAction;
    @SerializedName("category")
    private Object mCategory;
    @SerializedName("conversionGoals")
    private Object mConversionGoals;
    @SerializedName("createdBy")
    private String mCreatedBy;
    @SerializedName("createdOn")
    private Long mCreatedOn;
    @SerializedName("cronExpression")
    private Object mCronExpression;
    @SerializedName("d1")
    private Boolean mD1;
    @SerializedName("deliveryType")
    private String mDeliveryType;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("endTime")
    private Long mEndTime;
    @SerializedName("eventConfig")
    private Object mEventConfig;
    @SerializedName("eventType")
    private Object mEventType;
    @SerializedName("excludePlatforms")
    private Object mExcludePlatforms;
    @SerializedName("exclusionCriteria")
    private Object mExclusionCriteria;
    @SerializedName("id")
    private String mId;
    @SerializedName("ignoreDNDSettings")
    private Object mIgnoreDNDSettings;
    @SerializedName("ignoreFrequencyCapping")
    private Object mIgnoreFrequencyCapping;
    @SerializedName("ignoreGlobalMinimumDelay")
    private Object mIgnoreGlobalMinimumDelay;
    @SerializedName("lastUpdatedBy")
    private Object mLastUpdatedBy;
    @SerializedName("lastUpdatedOn")
    private Long mLastUpdatedOn;
    @SerializedName("overrideESIndex")
    private Object mOverrideESIndex;
    @SerializedName("platform")
    private List<String> mPlatform;
    @SerializedName("priority")
    private Long mPriority;
    @SerializedName("realm")
    private String mRealm;
    @SerializedName("segmentId")
    private String mSegmentId;
    @SerializedName("stalenessAllowed")
    private Boolean mStalenessAllowed;
    @SerializedName("stalenessFactorAllowed")
    private Object mStalenessFactorAllowed;
    @SerializedName("startTime")
    private Long mStartTime;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("tags")
    private List<String> mTags;
    @SerializedName("throttlingValue")
    private Object mThrottlingValue;
    @SerializedName("timezone")
    private String mTimezone;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("variants")
    private List<Variant> mVariants;

    public Action getAction() {
        return mAction;
    }

    public void setAction(Action action) {
        mAction = action;
    }

    public Object getCategory() {
        return mCategory;
    }

    public void setCategory(Object category) {
        mCategory = category;
    }

    public Object getConversionGoals() {
        return mConversionGoals;
    }

    public void setConversionGoals(Object conversionGoals) {
        mConversionGoals = conversionGoals;
    }

    public String getCreatedBy() {
        return mCreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        mCreatedBy = createdBy;
    }

    public Long getCreatedOn() {
        return mCreatedOn;
    }

    public void setCreatedOn(Long createdOn) {
        mCreatedOn = createdOn;
    }

    public Object getCronExpression() {
        return mCronExpression;
    }

    public void setCronExpression(Object cronExpression) {
        mCronExpression = cronExpression;
    }

    public Boolean getD1() {
        return mD1;
    }

    public void setD1(Boolean d1) {
        mD1 = d1;
    }

    public String getDeliveryType() {
        return mDeliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        mDeliveryType = deliveryType;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Long endTime) {
        mEndTime = endTime;
    }

    public Object getEventConfig() {
        return mEventConfig;
    }

    public void setEventConfig(Object eventConfig) {
        mEventConfig = eventConfig;
    }

    public Object getEventType() {
        return mEventType;
    }

    public void setEventType(Object eventType) {
        mEventType = eventType;
    }

    public Object getExcludePlatforms() {
        return mExcludePlatforms;
    }

    public void setExcludePlatforms(Object excludePlatforms) {
        mExcludePlatforms = excludePlatforms;
    }

    public Object getExclusionCriteria() {
        return mExclusionCriteria;
    }

    public void setExclusionCriteria(Object exclusionCriteria) {
        mExclusionCriteria = exclusionCriteria;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Object getIgnoreDNDSettings() {
        return mIgnoreDNDSettings;
    }

    public void setIgnoreDNDSettings(Object ignoreDNDSettings) {
        mIgnoreDNDSettings = ignoreDNDSettings;
    }

    public Object getIgnoreFrequencyCapping() {
        return mIgnoreFrequencyCapping;
    }

    public void setIgnoreFrequencyCapping(Object ignoreFrequencyCapping) {
        mIgnoreFrequencyCapping = ignoreFrequencyCapping;
    }

    public Object getIgnoreGlobalMinimumDelay() {
        return mIgnoreGlobalMinimumDelay;
    }

    public void setIgnoreGlobalMinimumDelay(Object ignoreGlobalMinimumDelay) {
        mIgnoreGlobalMinimumDelay = ignoreGlobalMinimumDelay;
    }

    public Object getLastUpdatedBy() {
        return mLastUpdatedBy;
    }

    public void setLastUpdatedBy(Object lastUpdatedBy) {
        mLastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdatedOn() {
        return mLastUpdatedOn;
    }

    public void setLastUpdatedOn(Long lastUpdatedOn) {
        mLastUpdatedOn = lastUpdatedOn;
    }

    public Object getOverrideESIndex() {
        return mOverrideESIndex;
    }

    public void setOverrideESIndex(Object overrideESIndex) {
        mOverrideESIndex = overrideESIndex;
    }

    public List<String> getPlatform() {
        return mPlatform;
    }

    public void setPlatform(List<String> platform) {
        mPlatform = platform;
    }

    public Long getPriority() {
        return mPriority;
    }

    public void setPriority(Long priority) {
        mPriority = priority;
    }

    public String getRealm() {
        return mRealm;
    }

    public void setRealm(String realm) {
        mRealm = realm;
    }

    public String getSegmentId() {
        return mSegmentId;
    }

    public void setSegmentId(String segmentId) {
        mSegmentId = segmentId;
    }

    public Boolean getStalenessAllowed() {
        return mStalenessAllowed;
    }

    public void setStalenessAllowed(Boolean stalenessAllowed) {
        mStalenessAllowed = stalenessAllowed;
    }

    public Object getStalenessFactorAllowed() {
        return mStalenessFactorAllowed;
    }

    public void setStalenessFactorAllowed(Object stalenessFactorAllowed) {
        mStalenessFactorAllowed = stalenessFactorAllowed;
    }

    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Long startTime) {
        mStartTime = startTime;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public Object getThrottlingValue() {
        return mThrottlingValue;
    }

    public void setThrottlingValue(Object throttlingValue) {
        mThrottlingValue = throttlingValue;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public List<Variant> getVariants() {
        return mVariants;
    }

    public void setVariants(List<Variant> variants) {
        mVariants = variants;
    }

}
