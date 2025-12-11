package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.segment.SegmentationCheckReq;

public class DiscoveryServices extends ApiHelper {

    public static Response getUserPersona(
            String uid, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding, Boolean fetchSlotRtPersona
    ) {
        return baseApiUrl("discoveryUrl")
                .queryParam("realm",appName)
                .queryParam("fetch_persona",true)
                .queryParam("fetch_custom_segments",false)
                .queryParam("fetch_click_rt_persona", fetch_click_rt_persona)
                .queryParam("fetchXstreamOnboarding", fetchXstreamOnboarding)
                .queryParam("fetch_slot_rt_persona",fetchSlotRtPersona)
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
