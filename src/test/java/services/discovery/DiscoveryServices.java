package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.segment.SegmentationCheckReq;

public class DiscoveryServices extends ApiHelper {

    public static Response getUserPersona(
            String uid, Boolean fetch_persona, Boolean fetch_custom_segments, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding
    ) {
        return baseApiUrl("discoveryUrl")
                .queryParam("fetch_persona",fetch_persona)
                .queryParam("fetch_custom_segments",fetch_custom_segments)
                .queryParam("realm",appName)
                .queryParam("fetch_click_rt_persona", fetch_click_rt_persona)
                .queryParam("fetchXstreamOnboarding", fetchXstreamOnboarding)
                .get("/segmentation/v1/persona/"+uid);
    }

    public static Response getExperimentForUser(String uid) {
        return baseApiUrl("discoveryUrl")
                .queryParam("realm", appName)
                .get("/segmentation/v1/persona/"+uid+"/experiment");
    }

    public static Response checkSegmentation(SegmentationCheckReq segmentationCheckReq) {
        return baseApiUrl("discoveryUrl").body(gson().toJson(segmentationCheckReq))
                .post("/segmentation/v1/segmentation");
    }

    public static Response getWatchHistory(String userID) {
        return watchContentApiUrl().queryParam("uid",userID)
                .get("/get/userWatchInfo");
    }
}
