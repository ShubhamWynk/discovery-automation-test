package model.Common.arsenalCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import constant.CollectionSortingMethod;
import constant.ScoringMethod;
import lombok.*;

@Data
public class MultiSourceRequest {
    private List<SourceCollection> collections;
    private ScoringMethod scoringMethod;
    private Boolean reducer;
    private Boolean tileOutput;
    private CollectionSortingMethod sortingMethod;
}