package Tests.junitCalismalari.Conditions;

import config.ConfigReader;

public class Conditions {
    public static boolean customCondition() {
        return false;
    }


   public static boolean isChrome() {
        boolean result = false;
        if (ConfigReader.getProperty("browser").equals("chrome")) {
            result = true;
        }
        return result;
    }

    public static boolean isFirefox() {
        boolean result = false;
        if (ConfigReader.getProperty("browser").equals("firefox")) {
            result = true;
        }
        return result;
    }

    public static boolean isSafari() {
        boolean result = false;
        if (ConfigReader.getProperty("browser").equals("safari")) {
            result = true;
        }
        return result;
    }


}
