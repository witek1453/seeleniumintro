package configuration;


import driver.manager.BrowserType;

public class LocalWebDriverProperties {
    //LocalWebDriverProperties – klasa będzie dostarczała właściwości związanych z ścieżkami do plików *.exe oraz przeglądarki, na której ma być uruchomiony test

    // Metody zwracają właściwości dla poszczególnych kluczy, analogicznie jak w przypadku AppProperties

    public static BrowserType getLocalBrowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("local.browser"));
    }

    public static String getChromeWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("chrome.driver.location");
    }

    public static String getFirefoxWebDriverLocation() {
        return ConfigurationProperties.getProperties().getProperty("firefox.driver.location");
    }
}