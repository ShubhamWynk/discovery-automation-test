
package model.request.hitMachine.druckerContentMeta;

import java.util.List;
import lombok.Data;

@Data
public class ContentMeta {
    private List<String> artistIds;
    private List<String> languages;
    private List<Long> publishedYears;
    private Long streamTarget;
    private Long timeWindow;
    private Long triggerTime;
}
