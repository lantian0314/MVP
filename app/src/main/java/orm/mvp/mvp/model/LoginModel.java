package orm.mvp.mvp.model;

import orm.mvp.mvp.bean.User;

/**
 * Created by xingyatong on 2018/3/13.
 * Model层的定义
 */
public class LoginModel {

    /**
     * 处理登录逻辑判断，验证用户名以及密码
     *
     * @param user
     * @param onLoginResultListener
     */
    public void Login(User user, onLoginResultListener onLoginResultListener) {
        String name = user.getUserName();
        String pwd = user.getUserPwd();
        if (name.equals("mvp") && pwd.equals("123456")) {
            if (onLoginResultListener != null) {
                onLoginResultListener.loginSuccess(user);//登陆成功的回调
            }
        } else {
            if (onLoginResultListener != null) {
                onLoginResultListener.loginFail();//登陆失败
            }
        }

    }


    /**
     * 网络检查后的回调
     */
    public interface onLoginResultListener {
        void loginSuccess(User user);

        void loginFail();
    }
}
