package batFiles;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BatFilesTest {

    @Test
    public void omerPullRequest() {
        try {
            Runtime.getRuntime().exec(
                    "cmd /c start " + System.getProperty("user.dir") + "/src/test/java/batFiles/pull_request_omer.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void omerShutDown() {
        if (System.getProperty("user.dir").contains("savsa")) {

            try {
                Runtime.getRuntime().exec(
                        "cmd /c start " + System.getProperty("user.dir") + "/src/test/java/batFiles/shutdown_computer.bat");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void firefoxPullRequest() {
        try {
            Runtime.getRuntime().exec(
                    "cmd /c start " + System.getProperty("user.dir") + "/src/test/java/batFiles/pull_request_firefox.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
