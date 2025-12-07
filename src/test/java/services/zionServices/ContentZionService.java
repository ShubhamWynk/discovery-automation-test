package services.zionServices;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.content.GetSongContentReq;
import model.request.getSongsContentList.GetSongsContantListReq;
import model.request.zion.postTileIntoCollection.PostTileIntoCollectionReq;
import model.request.zion.updateCollectionStatus.UpdateCollectionStatusReq;
import java.util.Map;

public class ContentZionService extends ApiHelper {
    public static Response getContentSong(GetSongContentReq getSongContentReq) {
        return zionApiUrl().body(gson().toJson(getSongContentReq)).post("/content/song/search?realm="+appName);
    }

    public static Response getSongsContent(GetSongsContantListReq getSongsContantListReq) {
        return zionApiUrl().body(gson().toJson(getSongsContantListReq)).post("/content/song/search?realm="+appName);
    }

    public static Response updateCollectionStatus(String id, UpdateCollectionStatusReq updateCollectionStatusReq) {
        return zionApiUrl().body(gson().toJson(updateCollectionStatusReq)).post("/content/collection/"+id+"/updateStatus?realm="+ appName);
    }

    public static Response getCollections(Map<String, String> param) {
        param.put("realm",appName);
        return zionApiUrl().params(param).get("/content/collections");
    }

    public static Response postNewCollection(PostTileIntoCollectionReq postTileIntoCollectionReq) {
        postTileIntoCollectionReq.setRealm(appName);
        return zionApiUrl().body(gson().toJson(postTileIntoCollectionReq)).post("/content/collection/?realm="+appName);
    }

    public static Response postTilesIntoCollection(String collectionId,PostTileIntoCollectionReq postTileIntoCollectionReq) {
        postTileIntoCollectionReq.setRealm(appName);
        return zionApiUrl().body(gson().toJson(postTileIntoCollectionReq)).post("/content/collection/"+collectionId+"?realm="+appName);
    }
}
