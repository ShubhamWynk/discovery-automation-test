
package model.response.userGrowth.Campaign;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Variant {

    @SerializedName("childSegmentId")
    private String mChildSegmentId;
    @SerializedName("templateInfoMap")
    private TemplateInfoMap mTemplateInfoMap;
    @SerializedName("variantName")
    private String mVariantName;
    @SerializedName("variantTag")
    private String mVariantTag;

    public String getChildSegmentId() {
        return mChildSegmentId;
    }

    public void setChildSegmentId(String childSegmentId) {
        mChildSegmentId = childSegmentId;
    }

    public TemplateInfoMap getTemplateInfoMap() {
        return mTemplateInfoMap;
    }

    public void setTemplateInfoMap(TemplateInfoMap templateInfoMap) {
        mTemplateInfoMap = templateInfoMap;
    }

    public String getVariantName() {
        return mVariantName;
    }

    public void setVariantName(String variantName) {
        mVariantName = variantName;
    }

    public String getVariantTag() {
        return mVariantTag;
    }

    public void setVariantTag(String variantTag) {
        mVariantTag = variantTag;
    }

}
