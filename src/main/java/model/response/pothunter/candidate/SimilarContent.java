
package model.response.pothunter.candidate;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SimilarContent {

    @SerializedName("SUGGEST_DOWNLOADS_SIMILAR_SONG")
    private List<SUGGESTDOWNLOADSSIMILARSONG> sUGGESTDOWNLOADSSIMILARSONG;
}
