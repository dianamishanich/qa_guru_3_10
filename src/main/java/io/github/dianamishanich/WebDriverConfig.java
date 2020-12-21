package io.github.dianamishanich;
import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources({
        "classpath:default.properties"
})
public interface WebDriverConfig extends Config {

    @DefaultValue("CHROME")
    @Key("webdriver.browser.name")
    BrowserName browserName();

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean remote();

    @DefaultValue("http://localhost:4444/wd/hub/")
    @Key("webdriver.remote.url")
    URL remoteURL();

}
