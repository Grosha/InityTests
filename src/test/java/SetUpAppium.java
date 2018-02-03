import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class SetUpAppium {
    public AndroidDriver driver;

    private String packageDK = "com.moonactive.automationtest";
    private String mainActivity = "com.unity3d.player.UnityPlayerActivity";


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", packageDK);
        capabilities.setCapability("appWaitPackage", packageDK);
        capabilities.setCapability("appActivity", mainActivity);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        initDriver();

        //switch to native app + portrait mode
        driver.context("NATIVE_APP");
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public abstract void initDriver();
}