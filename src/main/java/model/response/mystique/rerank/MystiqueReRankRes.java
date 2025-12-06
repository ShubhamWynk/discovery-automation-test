
package model.response.mystique.rerank;

import lombok.Data;

import java.util.Map;

@Data
public class MystiqueReRankRes {
    private String qid;
    private Map<String,Double> scores;
    private Long status;
    private String user_id;
}
