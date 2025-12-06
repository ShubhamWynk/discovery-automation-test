
package model.request.mystique.apply;

import java.util.List;
import lombok.Data;

@Data
public class MystiqueApply {
    private List<Content> contents;
    private Meta meta;
}
