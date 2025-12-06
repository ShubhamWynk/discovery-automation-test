package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.segment.SegmentationCheckReq;

public class DiscoveryServices extends ApiHelper {

    public static Response getUserPersona(String uid) {
        return discoveryApiUrl().when()
                .queryParam("fetch_persona", true)
                .queryParam("fetch_custom_segments", true)
                .queryParam("realm", "XSTREAM")
                .queryParam("fetch_click_rt_persona", true)
                .queryParam("fetchXstreamOnboarding", true)
                .get("/segmentation/v1/persona/"+uid);
    }

    public static Response getUserPersona(
            String uid, Boolean fetch_persona, Boolean fetch_custom_segments, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding
    ) {
        return discoveryApiUrl().when()
                .queryParam("fetch_persona",fetch_persona)
                .queryParam("fetch_custom_segments",fetch_custom_segments)
                .queryParam("realm","XSTREAM")
                .queryParam("fetch_click_rt_persona", fetch_click_rt_persona)
                .queryParam("fetchXstreamOnboarding", fetchXstreamOnboarding)
                .get("/segmentation/v1/persona/"+uid);
    }

    public static Response getExperimentForUser(String uid) {
        return discoveryApiUrl().when()
                .queryParam("realm", "XSTREAM")
                .get("/segmentation/v1/persona/"+uid+"/experiment");
    }

    public static Response checkSegmentation(SegmentationCheckReq segmentationCheckReq) {
        return discoveryApiUrl().body(gson().toJson(segmentationCheckReq))
                .post("/segmentation/v1/segmentation");
    }

    public static Response getWatchHistory(String userID) {
        return watchContentApiUrl().when()
                .get("/get/userWatchInfo?uid="+userID);
    }
}
