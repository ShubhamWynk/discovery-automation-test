
package model.request.mystique.apply;

import lombok.Data;

@Data
public class Params {
    private String mystiqueStrategy;
    private String uid;
    private String userId;
    private int cutOff;
    private String duration;
    private String boost;
    private String n;
    private String source;
    private String realm;
    private String rerankType;
    private String cpId;
    private String upperIndex;
    private String lowerIndex;
    private String lang;
}
