
package model.request.zion.layout.module.createModule;

import lombok.Data;

@Data
public class ACTION {
    private String actionType;
    private String actionValue;
    private String color;
    private String listingType;
    private String packageId;
    private ScreenParams screenParams;
    private String source;
    private String title;
    private String title_L2;
}
