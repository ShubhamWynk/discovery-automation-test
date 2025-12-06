
package model.response.catalog.songsDetail;

import lombok.Data;


@Data
public class Hit {
    private String _id;
    private String _index;
    private Double _score;
    private _source _source;
    private String _type;
}
