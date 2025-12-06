
package model.response.pothunter.candidate;

import java.util.List;
import lombok.Data;

@Data
public class CandidateRes {
    private String candidateState;
    private List<Object> candidates;
    private SimilarContent similarContent;
    private SourceContent sourceContent;
}
