package orm.mvp.mvp.presenter;

import android.app.Activity;
import android.text.TextUtils;

import orm.mvp.mvp.bean.User;
import orm.mvp.mvp.model.LoginModel;
import orm.mvp.mvp.view.LoginView;

/**
 * Created by xingyatong on 2018/3/13.
 * mvp中Presenter中的设计
 * 也是比较难，需要重点理解的一个
 * presenter是主持人的意思，view和model的中间者
 * 需要同时要有View的对象和Model的对象！一般做法是：在构造方法中创建model对象，并创建一个方法绑定View接口
 * 这里可以发现数据处理后或者逻辑判断完后都是给mvp中的View对象来做操作的！
 */
public class LoginPresenter extends BasePresenter {

    private LoginModel loginModel;
    private LoginView loginView;
    private User user;

    public LoginPresenter() {
        loginModel = new LoginModel();
        user = new User();
    }

    @Override
    public void bindView(Object mvpview) {
        super.bindView(mvpview);
        loginView = (LoginView) mvpview;
    }

    public void login() {
        user.setUserName(loginView.getUserName());
        user.setUserPwd(loginView.getUserPwd());
        if (isParamsOk()) {
            loginModel.Login(user, new LoginModel.onLoginResultListener() {
                @Override
                public void loginSuccess(User user) {
                    if (loginView != null) {
                        loginView.loginSuccess(user);
                    }
                }

                @Override
                public void loginFail() {
                    if (loginView != null) {
                        loginView.showVerifyFail();
                    }
                }
            });
        }
    }

    private boolean isParamsOk() {
        if (TextUtils.isEmpty(user.getUserName()) || TextUtils.isEmpty(user.getUserPwd())) {
            if (loginView != null) {
                loginView.showVerifyFail();
            }
        }
        return true;
    }
}
