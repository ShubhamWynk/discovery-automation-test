
package model.request.mystique.rerank;

import java.util.List;
import lombok.Data;

@Data
public class MystiqueRerankReq {
    private List<String> item_ids;
    private Boolean normalise_items;
    private Boolean normalise_user;
    private String qid;
    private String use_case;
    private String user_id;
}
