
package model.request.cbfService;

import lombok.Data;


@Data
public class CbfServiceRequest {
    private History history;
    private Long k;
    private String output_type;
    private Double pop_weight;
    private Object subscription;
}
