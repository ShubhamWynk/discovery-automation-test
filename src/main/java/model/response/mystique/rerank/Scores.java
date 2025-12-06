
package model.response.mystique.rerank;

import lombok.Data;

import java.util.Map;

@Data
public class Scores {
    private Map<String,Double> scores;
}
