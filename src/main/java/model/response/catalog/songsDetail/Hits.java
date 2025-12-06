
package model.response.catalog.songsDetail;

import java.util.List;
import lombok.Data;

import com.google.gson.annotations.SerializedName;

@Data
public class Hits {
    private List<Hit> hits;
    @SerializedName("max_score")
    private Double maxScore;
    private Total total;

}
