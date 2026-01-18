package model.Common.arsenalCollection;

import model.Common.arsenalCollection.constants.DeduplicationMethod;
import lombok.*;

@Data
public class PostProcessing {
    private Boolean enableDeduplication;
    private DeduplicationMethod deduplicationMethod;
    private CollectionComparator comparator;
    private Bucket bucket;
    private String strategy;
}