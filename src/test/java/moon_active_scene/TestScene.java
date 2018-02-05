package moon_active_scene;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestScene extends SetUpSikuli {

    @DataProvider(name = "welcomeScene")
    public static Object[][] welcomeSceneSetting() {
        return new Object[][]{
                {true, Pattern.IMAGE_CHECKBOX_TRUE},
                {false, Pattern.IMAGE_CHECKBOX_FALSE}
        };
    }

    @Test(dataProvider = "welcomeScene")
    public void testBackToTheWelcomeScene(boolean checkBoxStatus, String resultStatusCheckbox) {
        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_GO, 5);

        sikuliHelper.toggleCheckBox(Pattern.IMAGE_CHECKBOX_TRUE, checkBoxStatus);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_GO);

        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_BACK, 2);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_BACK);

        Assert.assertTrue(sikuliHelper.elementExists(resultStatusCheckbox), "Incorrect checkbox status was shown when returned from scene 'Back'");
    }

    @DataProvider(name = "resultScene")
    public static Object[][] resultSceneSetting() {
        return new Object[][]{
                {true, Pattern.IMAGE_TEXT_SUCCESS},
                {false, Pattern.IMAGE_TEXT_FAILURE}
        };
    }

    @Test(dataProvider = "resultScene")
    public void testResultScene(boolean checkBoxStatus, String resultText) {
        sikuliHelper.setMinSimilarity(0.9);
        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_GO, 5);

        sikuliHelper.toggleCheckBox(Pattern.IMAGE_CHECKBOX_TRUE, checkBoxStatus);
        sikuliHelper.clickByImage(Pattern.IMAGE_BUTTON_GO);

        sikuliHelper.waitUntilImageExists(Pattern.IMAGE_BUTTON_BACK, 2);
        Assert.assertTrue(sikuliHelper.elementExists(resultText), "Incorrect result text was shown for checkbox status " + checkBoxStatus);
    }
}
