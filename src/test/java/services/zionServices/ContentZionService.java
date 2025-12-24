package services.zionServices;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.content.GetSongContentReq;
import model.request.getSongsContentList.GetSongsContantListReq;
import model.request.zion.postTileIntoCollection.PostTileIntoCollectionReq;
import model.request.zion.updateCollectionStatus.UpdateCollectionStatusReq;
import services.BaseServiceClient;

import java.util.Map;


public class ContentZionService extends BaseServiceClient {

    private static final Headers zionHeaders = new Headers(
            new Header("rtkn", ApiHelper.getAuth()),
            new Header("Content-Type", "application/json"),
            new Header("accept", "*/*")
    );

    public static Response getContentSong(GetSongContentReq getSongContentReq) {
        return baseApiUrl("zionApiUrl", zionHeaders).body(gson().toJson(getSongContentReq)).post("/content/song/search?realm=" + appName);
    }

    public static Response getSongsContent(GetSongsContantListReq getSongsContantListReq) {
        return baseApiUrl("zionApiUrl", zionHeaders).body(gson().toJson(getSongsContantListReq)).post("/content/song/search?realm=" + appName);
    }

    public static Response updateCollectionStatus(String id, UpdateCollectionStatusReq updateCollectionStatusReq) {
        return baseApiUrl("zionApiUrl", zionHeaders).body(gson().toJson(updateCollectionStatusReq)).post("/content/collection/" + id + "/updateStatus?realm=" + appName);
    }

    public static Response getCollections(Map<String, String> param) {
        param.put("realm", appName);
        return baseApiUrl("zionApiUrl", zionHeaders).params(param).get("/content/collections");
    }

    public static Response postNewCollection(PostTileIntoCollectionReq postTileIntoCollectionReq) {
        postTileIntoCollectionReq.setRealm(appName);
        return baseApiUrl("zionApiUrl", zionHeaders).body(gson().toJson(postTileIntoCollectionReq)).post("/content/collection/?realm=" + appName);
    }

    public static Response postTilesIntoCollection(String collectionId, PostTileIntoCollectionReq postTileIntoCollectionReq) {
        postTileIntoCollectionReq.setRealm(appName);
        return baseApiUrl("zionApiUrl", zionHeaders).body(gson().toJson(postTileIntoCollectionReq)).post("/content/collection/" + collectionId + "?realm=" + appName);
    }
}
