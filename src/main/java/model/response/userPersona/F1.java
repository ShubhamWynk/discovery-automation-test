package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class F1  {
    @SerializedName("xstream__xstream_click_user_feature")
    private XstreamXstreamClickUserFeature xstreamXstreamClickUserFeature;

    @SerializedName("xstream__xstream_consumption_user_feature")
    private XstreamXstreamConsumptionUserFeature xstreamXstreamConsumptionUserFeature;
}
