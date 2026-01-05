package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
public class RTPersonaIntentDetails {
    @SerializedName("intentValue")
    private RTPersonaIntentValues intentValue;
}