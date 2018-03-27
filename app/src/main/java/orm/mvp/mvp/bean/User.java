package orm.mvp.mvp.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;


/**
 * Created by xingyatong on 2018/3/13.
 */
public class User{

    public final ObservableField<String> userName1 = new ObservableField<>();
    public final ObservableField<String> userPwd1 = new ObservableField<>();
    private String userName;
    private String userPwd;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;

    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
