import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBackScene extends SetUpAppium {
    private GoScene goScene;
    private BackScene backScene;

    @Override
    public void initDriver() {
        goScene = new GoScene(driver);
        backScene = new BackScene(driver);
    }

    @DataProvider(name = "back")
    public static Object[][] goSceneSetting() {
        return new Object[][]{
                {true, GoScene.getPatternCheckboxTrue()},
                {false, GoScene.getPatternCheckboxFalse()}
        };
    }

    @Test(dataProvider = "back")
    public void testBackToTheGoScene(boolean checkBoxStatus, String resultStatusCheckbox) {
        goScene.waitUntilImageExists(goScene.getPatternButtonGo(), 5);

        goScene.toggleCanProceedCheckBox(checkBoxStatus);
        goScene.clickByImage(goScene.getPatternButtonGo());

        goScene.waitUntilImageExists(backScene.getPatternButtonBack(), 2);
        goScene.clickByImage(backScene.getPatternButtonBack());

        Assert.assertTrue(goScene.elementExists(resultStatusCheckbox), "Incorrect checkbox status was shown when returned from scene 'Back'");
    }
}
