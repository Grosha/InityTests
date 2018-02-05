package moon_active_scene;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;

public class SetUpSikuli extends SetUpAppium {

    protected  SikuliHelper sikuliHelper;

    @Override
    public void initDriver(AndroidDriver driver) {
        if(sikuliHelper == null) {
            sikuliHelper = new SikuliHelper();
        }
        sikuliHelper.setDriver(driver);
    }

    @AfterMethod
    @Override
    public void setDown() {
        super.setDown();
        sikuliHelper.setDefaultSikuliSettings();
    }
}
