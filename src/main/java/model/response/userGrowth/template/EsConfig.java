
package model.response.userGrowth.template;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class EsConfig {
    public PlaceholderMapping placeholderMapping;

    @Data
    public static class PlaceholderMapping{
        public String usl;
    }

}
