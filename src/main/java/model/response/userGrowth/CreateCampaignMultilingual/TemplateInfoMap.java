
package model.response.userGrowth.CreateCampaignMultilingual;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class TemplateInfoMap {

    @SerializedName("FALLBACK")
    private List<String> fALLBACK;
    @Expose
    private List<String> hi;

    public List<String> getFALLBACK() {
        return fALLBACK;
    }

    public void setFALLBACK(List<String> fALLBACK) {
        this.fALLBACK = fALLBACK;
    }

    public List<String> getHi() {
        return hi;
    }

    public void setHi(List<String> hi) {
        this.hi = hi;
    }

}
