
package model.response.hitMachine.getAllMetaContent;

import java.util.List;
import lombok.Data;
import model.response.hitMachine.createMetaContentRes.CreateMetaContentRes;

@Data
public class GetAllMetaContentRes {
    private Long pageNo;
    private Long pageSize;
    private List<CreateMetaContentRes> result;
    private Long total;
}
