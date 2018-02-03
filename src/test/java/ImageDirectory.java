import java.io.File;

public interface ImageDirectory {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File imgDir = new File(classpathRoot, "src/main/resources");
}
