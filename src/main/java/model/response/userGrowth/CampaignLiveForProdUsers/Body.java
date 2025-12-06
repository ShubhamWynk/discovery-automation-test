
package model.response.userGrowth.CampaignLiveForProdUsers;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Body {

    @SerializedName("catchup")
    private Boolean mCatchup;
    @SerializedName("concurrency")
    private Long mConcurrency;
    @SerializedName("createdBy")
    private String mCreatedBy;
    @SerializedName("dagName")
    private String mDagName;
    @SerializedName("dagrun_timeout_sec")
    private Long mDagrunTimeoutSec;
    @SerializedName("defaultArgs")
    private DefaultArgs mDefaultArgs;
    @SerializedName("isActive")
    private Boolean mIsActive;
    @SerializedName("is_paused_upon_creation")
    private Boolean mIsPausedUponCreation;
    @SerializedName("max_active_runs")
    private Long mMaxActiveRuns;
    @SerializedName("orchestratorId")
    private Long mOrchestratorId;
    @SerializedName("orientation")
    private String mOrientation;
    @SerializedName("schedule_interval")
    private String mScheduleInterval;
    @SerializedName("tasks")
    private Object mTasks;

    public Boolean getCatchup() {
        return mCatchup;
    }

    public void setCatchup(Boolean catchup) {
        mCatchup = catchup;
    }

    public Long getConcurrency() {
        return mConcurrency;
    }

    public void setConcurrency(Long concurrency) {
        mConcurrency = concurrency;
    }

    public String getCreatedBy() {
        return mCreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        mCreatedBy = createdBy;
    }

    public String getDagName() {
        return mDagName;
    }

    public void setDagName(String dagName) {
        mDagName = dagName;
    }

    public Long getDagrunTimeoutSec() {
        return mDagrunTimeoutSec;
    }

    public void setDagrunTimeoutSec(Long dagrunTimeoutSec) {
        mDagrunTimeoutSec = dagrunTimeoutSec;
    }

    public DefaultArgs getDefaultArgs() {
        return mDefaultArgs;
    }

    public void setDefaultArgs(DefaultArgs defaultArgs) {
        mDefaultArgs = defaultArgs;
    }

    public Boolean getIsActive() {
        return mIsActive;
    }

    public void setIsActive(Boolean isActive) {
        mIsActive = isActive;
    }

    public Boolean getIsPausedUponCreation() {
        return mIsPausedUponCreation;
    }

    public void setIsPausedUponCreation(Boolean isPausedUponCreation) {
        mIsPausedUponCreation = isPausedUponCreation;
    }

    public Long getMaxActiveRuns() {
        return mMaxActiveRuns;
    }

    public void setMaxActiveRuns(Long maxActiveRuns) {
        mMaxActiveRuns = maxActiveRuns;
    }

    public Long getOrchestratorId() {
        return mOrchestratorId;
    }

    public void setOrchestratorId(Long orchestratorId) {
        mOrchestratorId = orchestratorId;
    }

    public String getOrientation() {
        return mOrientation;
    }

    public void setOrientation(String orientation) {
        mOrientation = orientation;
    }

    public String getScheduleInterval() {
        return mScheduleInterval;
    }

    public void setScheduleInterval(String scheduleInterval) {
        mScheduleInterval = scheduleInterval;
    }

    public Object getTasks() {
        return mTasks;
    }

    public void setTasks(Object tasks) {
        mTasks = tasks;
    }

}
