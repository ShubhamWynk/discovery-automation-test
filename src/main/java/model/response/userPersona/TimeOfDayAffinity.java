package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Data
public class TimeOfDayAffinity {

    @SerializedName("uid")
    private String uid;

    @SerializedName("weekday")
    private String weekday;

    @SerializedName("window_start")
    private String windowStart;

    @SerializedName("window_end")
    private String windowEnd;

    @SerializedName("program_affinity")
    private List<ProgramAffinity> programAffinity;

    @SerializedName("channel_affinity")
    private List<ChannelAffinity> channelAffinity;

    @SerializedName("day")
    private String day;
}
