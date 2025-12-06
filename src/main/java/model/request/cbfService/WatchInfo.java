
package model.request.cbfService;

import java.util.List;


import lombok.Data;
import model.response.watchHistory.WatchHistory;

@Data
public class WatchInfo {
    private List<Favourite> favourites;
    private List<WatchHistory> watchHistories;
}
