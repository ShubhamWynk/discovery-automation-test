package model.Common.arsenalCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import constant.Operator;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class SourceCollection implements Serializable {
    private String collectionId;
    private String type;
    private Operator operator;
    private Double score;
    private Long order;
    private Map<String, List<String>> params;
    private List<CollectionFilter> filters;
    @JsonIgnore
    private transient List<Content> contents;

    @Override
    public String toString() {
        return "SourceCollection{" +
                "collectionId='" + collectionId + '\'' +
                ", order=" + order +
                '}';
    }
}