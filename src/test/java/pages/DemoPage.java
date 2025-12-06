package pages;

import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
import config.ConfigLoader;

public class DemoPage extends PageObject {
    private static final Config conf = ConfigLoader.load();

    public void navigateToUrl(){
        openUrl(conf.getString("demoUrl"));
    }
}
