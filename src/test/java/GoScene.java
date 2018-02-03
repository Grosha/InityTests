import io.appium.java_client.android.AndroidDriver;

public class GoScene extends SikuliHelper implements ImageDirectory {

    private String IMAGE_BUTTON_GO = "/button_go.png";
    private static String IMAGE_CHECKBOX_FALSE = "/checkbox_can_proceed_false.png";
    private static String IMAGE_CHECKBOX_TRUE = "/checkbox_can_proceed_true.png";

    public GoScene(AndroidDriver driver) {
        super(driver);
    }

    public String getPatternButtonGo() {
        return imgDir + IMAGE_BUTTON_GO;
    }

    public static String getPatternCheckboxFalse() {
        return imgDir + IMAGE_CHECKBOX_FALSE;
    }

    public static String getPatternCheckboxTrue() {
        return imgDir + IMAGE_CHECKBOX_TRUE;
    }

    public void toggleCanProceedCheckBox(boolean checkboxStatus) {
        if (elementExists(getPatternCheckboxTrue()) != checkboxStatus) {
            clickByImage(getPatternCheckboxTrue());
        }
    }
}
