
package model.response.similarSong;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class SimilarSongRes {
    private String entityId;
    private Double relevanceScore;
}
