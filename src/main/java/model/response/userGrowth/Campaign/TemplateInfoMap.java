
package model.response.userGrowth.Campaign;

import java.util.List;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TemplateInfoMap {

    @SerializedName("FALLBACK")
    private List<String> mFALLBACK;

    public List<String> getFALLBACK() {
        return mFALLBACK;
    }

    public void setFALLBACK(List<String> fALLBACK) {
        mFALLBACK = fALLBACK;
    }

    @SerializedName("hi")
    private List<String> mHi;

    public List<String> getHi() {
        return mHi;
    }

    public void setHi(List<String> hi) {
        mHi = hi;
    }


}
