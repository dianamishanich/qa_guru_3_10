package io.github.dianamishanich;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    @Override
    public WebDriver get() {
        final WebDriverConfig config = ConfigFactory.newInstance().create(WebDriverConfig.class);
        if (config.remote()) {
            return new RemoteWebDriver(config.remoteURL(), DesiredCapabilities.htmlUnit());

        } else {
            switch (config.browserName()) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    return new OperaDriver();
                default:
                    throw new RuntimeException("Unknown browser name: " + config.browserName());
            }
        }
    }

}

