
package model.request.zion.layout.segments;

import java.util.List;


import lombok.Data;

@Data
public class Rule {
    private String attributeName;
    private List<String> attributeValue;
    private String combinator;
    private String id;
    private Boolean multiValueAttribute;
    private Boolean not;
    private String operator;
    private List<Rule> rules;
    private String type;
}
