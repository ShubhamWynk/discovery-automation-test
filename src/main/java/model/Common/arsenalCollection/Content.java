
package model.Common.arsenalCollection;

import lombok.Data;

import java.util.Map;


@Data
public class Content {
    private String contentId;
    private Long position;
    private String type;
    private Map<String,String> extras;
}
