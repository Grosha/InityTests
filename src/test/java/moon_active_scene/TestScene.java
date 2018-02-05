package moon_active_scene;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScene extends SetUpAppium {

    private SikuliHelper sikuliHelper;

    @Override
    public void initDriver() {
        sikuliHelper = new SikuliHelper(driver);
    }

    @DataProvider(name = "backScene")
    public static Object[][] goSceneSetting() {
        return new Object[][]{
                {true, Pattern.IMAGE_CHECKBOX_TRUE},
                {false, Pattern.IMAGE_CHECKBOX_FALSE}
        };
    }

    @Test(dataProvider = "backScene")
    public void testBackToTheGoScene(boolean checkBoxStatus, String resultStatusCheckbox) {
        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_GO, 5);

        sikuliHelper.toggleCheckBox(Pattern.IMAGE_CHECKBOX_TRUE, checkBoxStatus);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_GO);

        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_BACK, 2);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_BACK);

        Assert.assertTrue(sikuliHelper.elementExists(resultStatusCheckbox), "Incorrect checkbox status was shown when returned from scene 'Back'");
    }

    @DataProvider(name = "goScene")
    public static Object[][] backSceneSetting() {
        return new Object[][]{
                {true, Pattern.IMAGE_TEXT_SUCCESS},
                {false, Pattern.IMAGE_TEXT_FAILURE}
        };
    }

    @Test(dataProvider = "goScene")
    public void testResultGo(boolean checkBoxStatus, String resultText) {
        sikuliHelper = new SikuliHelper(driver, 0.9);
        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_GO, 5);

        sikuliHelper.toggleCheckBox(Pattern.IMAGE_CHECKBOX_TRUE, checkBoxStatus);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_GO);

        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_BACK, 2);
        Assert.assertTrue(sikuliHelper.elementExists(resultText), "Incorrect result text was shown for checkbox status " + checkBoxStatus);
    }
}
