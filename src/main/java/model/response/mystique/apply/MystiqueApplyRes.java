
package model.response.mystique.apply;

import lombok.Data;
import model.request.mystique.apply.Content;

import java.util.List;

@Data
public class MystiqueApplyRes {
    private List<Content> contents;
}
