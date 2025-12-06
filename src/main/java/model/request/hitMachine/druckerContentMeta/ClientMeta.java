
package model.request.hitMachine.druckerContentMeta;

import lombok.Data;

@Data
public class ClientMeta {
    private String clientKey;
    private Boolean useContentDominantArtistFilter;
    private Boolean useContentDominantLangFilter;
    private Boolean useContentPublishedYearFilter;
    private Boolean userRplStateFilter;
    private Long windowIndex;
    private Long windowSize;
}
