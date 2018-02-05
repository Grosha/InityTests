package moon_active_scene;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class SetUpAppium {
    final DesiredCapabilities capabilities;
    public AndroidDriver driver;
    private final static String packageDK = "com.moonactive.automationtest";
    private final static String mainActivity = "com.unity3d.player.UnityPlayerActivity";

    public SetUpAppium() {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", packageDK);
        capabilities.setCapability("appWaitPackage", packageDK);
        capabilities.setCapability("appActivity", mainActivity);
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        initDriver(driver);

        //switch to native app + portrait mode
        driver.context("NATIVE_APP");
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public abstract void initDriver(AndroidDriver driver);
}