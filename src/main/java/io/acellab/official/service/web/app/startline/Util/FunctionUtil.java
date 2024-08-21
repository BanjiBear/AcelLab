package io.acellab.official.service.web.app.startline.Util;

public class FunctionUtil {

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$";
        return password.matches(passwordRegex);
    }

}
