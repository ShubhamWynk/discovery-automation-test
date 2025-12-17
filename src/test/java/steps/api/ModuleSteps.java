package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import model.request.common.SupportedClient;
import model.request.zion.layout.module.createModule.ACTION;
import model.request.zion.layout.module.createModule.CreateModuleReq;
import model.request.zion.layout.module.createModule.DISPLAY;
import model.request.zion.layout.module.createModule.Meta;
import model.response.zion.layout.section.getSectionDetails.Content;


import java.util.List;

public class ModuleSteps {

//    CreateModuleReq createModule;
//    @Given("^User create payload for new Module$")
//    public void userCreatePayloadForNewModule(List<CreateModuleReq> createModuleReq) {
//        createModule=createModuleReq.get(0);
//    }
//
//    @And("^User add supported client in new Module payload$")
//    public void userAddSupportedClientInNewModulePayload(List<SupportedClient> supportedClients) {
//        createModule.setSupportedClients(supportedClients);
//    }
//
//    @And("^User add Content to the new Module Payload$")
//    public void userAddContentToTheNewModulePayload(List<Content> content) {
//        createModule.setContent(content.get(0));
//    }
//
//    @And("^User add meta display to the new Module Payload$")
//    public void userAddMetaDisplayToTheNewModulePayload(List<DISPLAY> display) {
//        Meta meta=new Meta();
//        meta.setDISPLAY(display.get(0));
//        createModule.setMeta(meta);
//    }
//
//    @And("^User add meta Action to the new Module Payload$")
//    public void userAddMetaActionToTheNewModulePayload(List<ACTION> action) {
//        createModule.getMeta().setACTION(action.get(0));
//    }

//    @Then("^User hit api for create new module$")
//    public void userHitApiForCreateNewModule() {
//
//    }
}
