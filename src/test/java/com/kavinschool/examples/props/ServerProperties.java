package com.kavinschool.examples.props;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:env",
        "system:properties",
        "classpath:server.properties"
})
public interface ServerProperties extends Config{
	@Key("BASE_URL")
    @DefaultValue("https://kavinschool.com/playground/DemoInputs.html")
    String baseUrl();

    @Key("SELENIUM_GRID_HUB_URL")
    @DefaultValue("http://localhost:4444/wd/hub")
    String seleniumGridHubUrl();

    @Key("CHROME_DRIVER_BINARY")
    @DefaultValue("C:\\bin\\chromedriver.exe")
    String chromeDriverBinary();

    @Key("GOOGLE_CHROME_BINARY")
    @DefaultValue("/usr/bin/google-chrome")
    String googleChromeBinary();

    @Key("RUN_TYPE")
    @DefaultValue("local")
    String runType();

    @Key("BROWSER_TYPE")
    @DefaultValue("Chrome")
    String browserType();
    
    @Key("KEEP_BROWSER_OPEN")
    @DefaultValue("false")
	public
    boolean keepBrowserOpen();

}
