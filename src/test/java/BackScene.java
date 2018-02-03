import io.appium.java_client.android.AndroidDriver;

public class BackScene extends SikuliHelper implements ImageDirectory {

    private String IMAGE_BUTTON_BACK = "/button_back.png";
    private static String IMAGE_TEXT_FAILURE = "/text_failure.png";
    private static String IMAGE_TEXT_SUCCESS = "/text_success.png";

    public BackScene(AndroidDriver driver) {
        super(driver);
    }

    public String getPatternButtonBack() {
        return imgDir + IMAGE_BUTTON_BACK;
    }

    public static String getPatternTextFailure() {
        return imgDir + IMAGE_TEXT_FAILURE;
    }

    public static String getPatternTextSuccess() {
        return imgDir + IMAGE_TEXT_SUCCESS;
    }
}
