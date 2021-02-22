package DataSource;

import User.User;
import java.util.HashMap;

public class UserDS {

    static HashMap<String, User> userToNameMap;

    static {
        userToNameMap = new HashMap<String, User>();
    }


    public HashMap<String, User> getUserToNameMap() {
        return userToNameMap;
    }

    public void setUserToNameMap(HashMap<String, User> userToNameMap) {
        UserDS.userToNameMap = userToNameMap;
    }
}
