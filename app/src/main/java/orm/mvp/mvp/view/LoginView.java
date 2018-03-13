package orm.mvp.mvp.view;

import orm.mvp.mvp.bean.User;

/**
 * Created by xingyatong on 2018/3/13.
 */
public interface LoginView {

    String getUserName();

    String getUserPwd();

    void loginSuccess(User user);

    void showNetEror();//网络错误

    void showVerifyFail();//信息验证失败
}
