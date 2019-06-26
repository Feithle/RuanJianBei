package Configer;

import Bean.UserBean;

public class InformationConfig {
    public UserBean InformationConfigOfUser(String markContent, String key, int N) {
        UserBean userBean = new UserBean();
        userBean.setMarkContent(markContent);
        userBean.setKey(key);
        userBean.setN(N);
        return userBean;
    }
}
