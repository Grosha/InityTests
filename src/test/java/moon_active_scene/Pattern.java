package moon_active_scene;

import java.io.File;

public class Pattern {

    public static File classpathRoot = new File(System.getProperty("user.dir"));
    public static File imgDir = new File(classpathRoot, "src/main/resources");

    public static String IMAGE_BUTTON_GO = imgDir + "/button_go.png";
    public static String IMAGE_CHECKBOX_FALSE = imgDir + "/checkbox_can_proceed_false.png";
    public static String IMAGE_CHECKBOX_TRUE = imgDir + "/checkbox_can_proceed_true.png";
    public static String IMAGE_BUTTON_BACK = imgDir + "/button_back.png";
    public static String IMAGE_TEXT_FAILURE = imgDir + "/text_failure.png";
    public static String IMAGE_TEXT_SUCCESS = imgDir + "/text_success.png";
}
