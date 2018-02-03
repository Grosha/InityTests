import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGoScene extends SetUpAppium {
    private GoScene goScene ;
    private BackScene backScene;

    public void initDriver() {
        goScene = new GoScene(driver);
        backScene = new BackScene(driver);
    }

    @DataProvider(name = "go")
    public static Object[][] backSceneSetting() {
        return new Object[][]{
                {true, BackScene.getPatternTextSuccess()},
                {false, BackScene.getPatternTextFailure()}
        };
    }

    @Test(dataProvider = "go")
    public void testResultGo(boolean checkBoxStatus, String resultText) {
        goScene.waitUntilImageExists(goScene.getPatternButtonGo(), 5);

        goScene.toggleCanProceedCheckBox(checkBoxStatus);
        goScene.clickByImage(goScene.getPatternButtonGo());

        backScene.waitUntilImageExists(backScene.getPatternButtonBack(), 2);
        Assert.assertTrue(backScene.elementExists(resultText), "Incorrect result text was shown for checkbox status " + checkBoxStatus);
    }
}
