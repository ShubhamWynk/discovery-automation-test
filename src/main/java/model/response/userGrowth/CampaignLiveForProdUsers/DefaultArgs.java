
package model.response.userGrowth.CampaignLiveForProdUsers;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class DefaultArgs {

    @SerializedName("catchup")
    private Boolean mCatchup;
    @SerializedName("on_failure_callback")
    private Object mOnFailureCallback;
    @SerializedName("on_success_callback")
    private Object mOnSuccessCallback;
    @SerializedName("owner")
    private String mOwner;
    @SerializedName("params")
    private Params mParams;
    @SerializedName("retries")
    private Long mRetries;
    @SerializedName("retry_delay_sec")
    private Long mRetryDelaySec;
    @SerializedName("start_date")
    private String mStartDate;

    public Boolean getCatchup() {
        return mCatchup;
    }

    public void setCatchup(Boolean catchup) {
        mCatchup = catchup;
    }

    public Object getOnFailureCallback() {
        return mOnFailureCallback;
    }

    public void setOnFailureCallback(Object onFailureCallback) {
        mOnFailureCallback = onFailureCallback;
    }

    public Object getOnSuccessCallback() {
        return mOnSuccessCallback;
    }

    public void setOnSuccessCallback(Object onSuccessCallback) {
        mOnSuccessCallback = onSuccessCallback;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public Params getParams() {
        return mParams;
    }

    public void setParams(Params params) {
        mParams = params;
    }

    public Long getRetries() {
        return mRetries;
    }

    public void setRetries(Long retries) {
        mRetries = retries;
    }

    public Long getRetryDelaySec() {
        return mRetryDelaySec;
    }

    public void setRetryDelaySec(Long retryDelaySec) {
        mRetryDelaySec = retryDelaySec;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }

}
