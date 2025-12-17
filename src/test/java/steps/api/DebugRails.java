package steps.api;

import io.restassured.response.Response;
import io.cucumber.java.en.Then;
import model.request.segment.SegmentationCheckReq;
import model.response.origami.debug.LayoutDebug;
import model.response.origami.debug.MODULEDebug;
import model.response.zion.layout.segment.PostNewSegment.PostNewSegmentRes;
import org.junit.Assert;
import services.discovery.DiscoveryServices;
import services.zionServices.ZionServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.ApiHelper.gson;

public class DebugRails {
//    LayoutDebug layoutDebug;
//    MODULEDebug moduleDebug = new MODULEDebug();
//    Map<String, String> map2;
//
//    public PostNewSegmentRes getSegmentFromZionById(String segmentId, Map<String, String> map) {
//        Response response = ZionServices.getSegmentFromZionById(segmentId, map);
//        Assert.assertEquals(200, response.getStatusCode());
//        return gson().fromJson(response.body().asString(), PostNewSegmentRes.class);
//    }
//
//    public SegmentationCheckReq checkSegmentation(SegmentationCheckReq segmentationCheckReq) {
//        Response response = DiscoveryServices.checkSegmentation(segmentationCheckReq);
//        Assert.assertEquals(200, response.getStatusCode());
//        return gson().fromJson(response.body().asString(), SegmentationCheckReq.class);
//    }

//    public LayoutDebug getDiscoveryOrigamiLayoutDebug(String page, Map<String, String> map2) {
//        Response response = DiscoveryServices.getDiscoveryOrigamiLayoutDebug(page, map2);
//        Assert.assertEquals(200, response.getStatusCode());
//        return gson().fromJson(response.body().asString(), LayoutDebug.class);
//    }

//    public void checkSegmentation(List<String> segment, String uid) {
//        Response response = DiscoveryServices.getUserPersona(uid,true,true, true);
//        Assert.assertEquals(200, response.getStatusCode());
//        response.prettyPrint();
//        PostNewSegmentRes postNewSegmentRes = getSegmentFromZionById(segment.get(0), new HashMap<>());
//        System.out.println("Rule ==========>" + gson.toJson(postNewSegmentRes.getRule()));
//    }

//    @Given("^User hit origami-service for \"([^\"]*)\" page$")
//    public void userHitOrigamiServiceForPage(String page, DataTable dataTable) throws Throwable {
//        Map<String, String> map = dataTable.asMaps(String.class, String.class).get(0);
//        map2 = new HashMap<>();
//        map.forEach((key, value) -> {
//            if (!(value.equals(""))) map2.put(key, value);
//        });
//        layoutDebug = getDiscoveryOrigamiLayoutDebug(page, map2);
//    }

//    @And("^fetching \"([^\"]*)\" rail details$")
//    public void fetchingRailDetails(String railName) throws Throwable {
//        boolean isrendred = false;
//        for (int i = 0; i < layoutDebug.getMODULERENDERED().size(); i++) {
//            if (layoutDebug.getMODULERENDERED().get(i).getModule().getTitle().equals(railName)) {
//                System.out.println("rail " + railName + " is rendered in " + layoutDebug.getMODULERENDERED().get(i).getModule() + " section on ");
//                ArsenalCollectionRes arsenalCollectionRes = ArsenalService.getArsenalCollectionController(layoutDebug.getMODULERENDERED().get(i).getModule().getContent().getCollectionId(), map2.get("uid"));
//                if (arsenalCollectionRes.getContents().isEmpty()) {
//                    System.out.println("rail " + railName + " is rendered in " + layoutDebug.getMODULERENDERED().get(i).getModule() + " section on but collection" + layoutDebug.getMODULERENDERED().get(i).getModule().getContent().getCollectionId() + " has no content");
//                }
//                isrendred = true;
//                break;
//            }
//        }
//        if (!isrendred) {
//            for (int i = 0; i < layoutDebug.getMODULEINACTIVE().size(); i++) {
//                if (layoutDebug.getMODULEINACTIVE().get(i).getModule().getTitle().equals(railName)) {
//                    System.out.println("rail " + railName + " is not rendered and in inactive state");
//                    break;
//                }
//            }
//            for (int i = 0; i < layoutDebug.getMODULECLIENTNOTSUPPORTED().size(); i++) {
//                if (layoutDebug.getMODULECLIENTNOTSUPPORTED().get(i).getModule().getTitle().equals(railName)) {
//                    System.out.println("rail " + railName + " is not rendered and client not supported state");
//                    //System.out.println("Supported Client -->" + layoutDebug.getMODULECLIENTNOTSUPPORTED().get(i).getModule().getSupportedClients().stream().map(model.response.origami.debug.SupportedClient::getClient));
//                    break;
//                }
//            }
//            for (int i = 0; i < layoutDebug.getMODULESECTIONLIMIT().size(); i++) {
//                if (layoutDebug.getMODULESECTIONLIMIT().get(i).getModule().getTitle().equals(railName)) {
//                    System.out.println("rail " + railName + " is not rendered because of section limit");
//                    String section = layoutDebug.getMODULESECTIONLIMIT().get(i).getSectionTitle();
//                    String sectionId = layoutDebug.getMODULESECTIONLIMIT().get(i).getModule().getId();
//                    List<SECTIONRENDERED> z = (List<SECTIONRENDERED>) layoutDebug.getSECTIONRENDERED().stream().filter((elem) -> elem.getPageSection().getTitle().equals(section));
//                    List<model.response.origami.debug.SegmentModule> segmentModules = (List<model.response.origami.debug.SegmentModule>) z.get(0).getPageSection().getSegmentModules().stream().filter((ele) -> ele.getModuleId().equals(sectionId));
//                    System.out.println("section limit of " + section + "is " + z.get(0).getPageSection().getModuleLimit() + "and weight of the rail is " + segmentModules.get(0).getWeight());
//                    break;
//                }
//            }
//            for (int i = 0; i < layoutDebug.getMODULESEGMENTUNMATCHED().size(); i++) {
//                if (layoutDebug.getMODULESEGMENTUNMATCHED().get(i).getModule().getTitle().equals(railName)) {
//                    moduleDebug = layoutDebug.getMODULESEGMENTUNMATCHED().get(i);
//                    System.out.println("rail " + railName + " is not rendered and segment not matched");
//                    break;
//                }
//            }
//            for (int i = 0; i < layoutDebug.getMODULENOTSCHEDULE().size(); i++) {
//                if (layoutDebug.getMODULENOTSCHEDULE().get(i).getModule().getTitle().equals(railName)) {
//                    System.out.println("rail " + railName + " is not rendered and in inactive state");
//                    break;
//                }
//            }
//        }
//    }

//    @Then("^check module should lie in MODULE_SEGMENT_UNMATCHED if not in MODULE_RENDERED$")
//    public void checkModuleShouldLieInMODULE_SEGMENT_UNMATCHEDIfNotInMODULE_RENDERED() {
//        SegmentationCheckReq segmentationCheckReq = new SegmentationCheckReq();
//        segmentationCheckReq.setUid(map2.get("uid"));
//        segmentationCheckReq.setRealm(map2.get("realm"));
//        List<String> segments = new ArrayList<>();
//        segments.add(moduleDebug.getSegmentId());
//        segmentationCheckReq.setSegmentsToBeMatched(segments);
//        SegmentationCheckReq segmentationCheckRes = checkSegmentation(segmentationCheckReq);
//        if (segmentationCheckRes.getSegmentsToBeMatched() == null) {
//            System.out.println("==== Segment not Pass for this User =====" + map2.get("uid"));
//            checkSegmentation(segments, map2.get("uid"));
//        } else {
//            System.out.println("==== Segment Pass for this User =====" + map2.get("uid"));
//        }
//    }
}
