
package model.request.pothunter.candidate;

import java.util.List;
import lombok.Data;

@Data
public class CandidateReq {
    private Config config;
    private Boolean evaluateCandidate;
    private List<String> similarContent;
    private List<String> sources;
}
