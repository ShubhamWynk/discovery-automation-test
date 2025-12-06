
package model.request.pothunter.candidate;

import lombok.Data;

import java.util.List;

@Data
public class Config {
    private Long candidateEligibilityCutoff;
    private Boolean enableRplClustering;
    private List<String> languages;
    private Boolean removeSourceContentInSimilarSongResponse;
    private List<String> rplModuleCollectionIdExclusion;
    private Long rplModuleSizeCutoff;
    private Long rplModuleTimestampCutoff;
    private Long rplSizeCutoff;
    private Long rplTimestampCutoff;
    private Long skippedSizeCutoff;
    private Long skippedTimestampCutoff;
    private Boolean useSkippedSimilarSong;
    private String userId;
    private Boolean userMostPlayedSimilarSong;
}
