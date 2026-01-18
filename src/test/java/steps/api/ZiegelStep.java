package steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.response.ziegel.TileRes;
import org.junit.Assert;
import services.discovery.ZiegelService;
import utilities.Utils;

import java.io.IOException;
import java.util.Map;

import static helpers.ApiHelper.gson;

public class ZiegelStep {
    TileRes res1;
    @And("fetch tile meta data for {string} tile with user query param")
    public void fetchTileMetaDataForTileWithQueryParam(String arg0, DataTable dataTable) throws IOException {
        Map<String, String> params = Utils.convertDataTableToMap(dataTable).getFirst();
        params.putAll(UserInfo.liveAttribute);
        Response res = ZiegelService.getStaticTileDetails(arg0, params);
        Assert.assertEquals(200, res.getStatusCode());
        res1 = gson().fromJson(res.body().asString(), TileRes.class);
    }

    @And("fetch tile meta data for {string} tile without user query param")
    public void fetchTileMetaDataForTileWithoutUserQueryParam(String arg0, DataTable dataTable) throws IOException {
        Map<String, String> params = Utils.convertDataTableToMap(dataTable).getFirst();
        Response res = ZiegelService.getStaticTileDetails(arg0, params);
        Assert.assertEquals(200, res.getStatusCode());
        res1 = gson().fromJson(res.body().asString(), TileRes.class);
    }

    @Then("Verify the tile behave as Broadband upSell tile on the banner")
    public void verifyTheTileBehaveAsBroadbandUpSellTileOnTheBanner() {
        Assert.assertEquals("Upgrade Now",res1.getIptvDisplayTitle());
        Assert.assertEquals("Upgrade Now",res1.getDisplayTitle());
        Assert.assertEquals("For Just 3.99 More",res1.getTitle());
        Assert.assertEquals("Watch Content from Amazon Prime & Hotstar",res1.getSubtitle());
        Assert.assertEquals("xstream://airtelxstream.com?type=BB_UPGRADE_COMPARE_SINGLE_PLAN&productOfferingId=BLACK_62372&sourceName=banner",res1.getDeepLinkJson().get("STB"));
    }

    @Then("Verify the tile behave as normal tile on the banner")
    public void verifyTheTileBehaveAsNormalTileOnTheBanner() {
        Assert.assertEquals("Watch Now",res1.getDisplayTitle());
        Assert.assertEquals("Invasion BB",res1.getTitle());
        Assert.assertTrue(res1.getSubtitle().contains("PICK OF THE WEEK"));
    }
}
