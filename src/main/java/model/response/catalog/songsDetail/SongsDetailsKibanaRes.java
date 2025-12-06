
package model.response.catalog.songsDetail;

import lombok.Data;

import com.google.gson.annotations.SerializedName;

@Data
public class SongsDetailsKibanaRes {
    private _shards _shards;
    private Hits hits;
    @SerializedName("timed_out")
    private Boolean timedOut;

    private Long took;

}
