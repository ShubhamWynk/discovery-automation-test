
package model.response.catalog.songsDetail;

import lombok.Data;

@Data
public class _shards {
    private Long failed;
    private Long skipped;
    private Long successful;
    private Long total;
}
