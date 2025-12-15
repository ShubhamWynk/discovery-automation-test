package steps.api;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.request.zion.layout.segments.Rule;
import model.request.zion.layout.segments.postSegment.PostSegment;
import model.response.zion.layout.segment.PostNewSegment.PostNewSegmentRes;
import model.response.zion.layout.segment.getSegment.GetSegmentation;
import org.junit.Assert;
import services.zionServices.ZionServices;

import java.util.*;
import static helpers.ApiHelper.appName;
import static helpers.ApiHelper.gson;

public class Segmentation {

    PostNewSegmentRes postNewSegmentRes;

    public PostNewSegmentRes getSegmentById(String id,Map<String,String> param){
        Response response = ZionServices.getSegmentFromZionById(id,param);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewSegmentRes.class);
    }

    public PostNewSegmentRes postNewSegment(PostSegment postSegment) {
        Response response = ZionServices.postSegment(postSegment);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewSegmentRes.class);
    }

    private PostSegment createSegmentRequestWithoutRule(String segmentName){
        PostSegment postSegment = new PostSegment();
        postSegment.setName(segmentName);
        postSegment.setAllUserSegment(false);
        postSegment.setSegmentType(null);
        postSegment.setEditable(null);
        postSegment.setSplitPercentage(0);
        postSegment.setActive(null);
        postSegment.setParentSegmentId(null);
        postSegment.setLastUpdatedExperimentId(null);
        postSegment.setChildSegments(null);
        postSegment.setExperimentId(null);
        postSegment.setRealm(appName);
        postSegment.setFallback(null);
        return postSegment;
    }

    private Rule createRule(List<Map<String, String>> rows, int i){
        Rule rule = new Rule();
        //rule.setId("2345654");
        List<String> list = Arrays.asList(rows.get(i).get("Attribute Value").split(","));
        rule.setAttributeValue(list);
        rule.setAttributeName(rows.get(i).get("Attribute"));
        rule.setMultiValueAttribute(rows.get(i).get("Attribute Value").contains(","));
        rule.setOperator(rows.get(i).get("Operator"));
        rule.setType("SINGLE_RULE");
        return rule;
    }

    private Rule createRules(List<Map<String, String>> rows,int j,Rule rule3){
        Rule rule = new Rule();
        rule.setCombinator(rows.get(j).get("combinator"));
        rule.setNot(false);
        rule.setType("RULE_GROUP");
        rule.setMultiValueAttribute(false);
        rule.setAttributeName(null);
        List<Rule> rules = new ArrayList<>();
        for (int i=j; i < j+2; i++){
            if( rows.size()>2 && i >1) {
                rules.add(rule3);
                Rule rule2 = createRule(rows, i);
                rules.add(rule2);
                break;
            }
            Rule rule2 = createRule(rows, i);
            rules.add(rule2);
        }
        rule.setRules(rules);
        return rule;
    }

    @Given("^User create segment \"([^\"]*)\"$")
    public void userCreateSegment(String segmentName, DataTable dataTable) throws Throwable {
        List<Map<String, String>> rows = dataTable.asMaps(String.class,String.class);
        PostSegment postSegmentReq = createSegmentRequestWithoutRule(segmentName);

        Rule rule = null;
        if(rows.size()>1){
            rule = createRules(rows,0, null);
            for(int i=2;i<rows.size();i++) {
                rule = createRules(rows,i,rule);
            }
        }
        else{ rule = createRule(rows, 0); }

        postSegmentReq.setRule(rule);
        postNewSegmentRes = postNewSegment(postSegmentReq);
    }

    @Then("^Verify segment should be added$")
    public void verifySegmentShouldBeAdded() {
        PostNewSegmentRes getSegmentRes = getSegmentById(postNewSegmentRes.getId(),new HashMap<>());
        Assert.assertEquals(getSegmentRes.getName(), postNewSegmentRes.getName());
        Assert.assertEquals(getSegmentRes.getSplitPercentage(), postNewSegmentRes.getSplitPercentage());
        Assert.assertEquals(getSegmentRes.getRealm(), postNewSegmentRes.getRealm());
        Assert.assertEquals(getSegmentRes.getId(), postNewSegmentRes.getId());

        GetSegmentation getSegmentation = LayoutConfigSteps.getSegmentsFromZion(postNewSegmentRes.getName());
        for (int i = 0; i < getSegmentation.getData().size(); i++) {
            if (getSegmentation.getData().get(i).getName().equals(postNewSegmentRes.getName())) {
                Assert.assertEquals(getSegmentation.getData().get(i).getName(), postNewSegmentRes.getName());
                Assert.assertEquals(getSegmentation.getData().get(i).getSplitPercentage(), postNewSegmentRes.getSplitPercentage());
                Assert.assertEquals(getSegmentation.getData().get(i).getRealm(), postNewSegmentRes.getRealm());
                Assert.assertEquals(getSegmentation.getData().get(i).getId(), postNewSegmentRes.getId());
                break;
            }
        }
        Assert.fail();
    }
}
