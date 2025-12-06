
package model.response.userGrowth.CampaignLiveForProdUsers;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class MakeCampaignLiveForAllUsersResponse {

    @SerializedName("body")
    private Body mBody;
    @SerializedName("headers")
    private Headers mHeaders;
    @SerializedName("statusCode")
    private String mStatusCode;
    @SerializedName("statusCodeValue")
    private Long mStatusCodeValue;

    public Body getBody() {
        return mBody;
    }

    public void setBody(Body body) {
        mBody = body;
    }

    public Headers getHeaders() {
        return mHeaders;
    }

    public void setHeaders(Headers headers) {
        mHeaders = headers;
    }

    public String getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(String statusCode) {
        mStatusCode = statusCode;
    }

    public Long getStatusCodeValue() {
        return mStatusCodeValue;
    }

    public void setStatusCodeValue(Long statusCodeValue) {
        mStatusCodeValue = statusCodeValue;
    }

}
