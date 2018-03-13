package orm.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import orm.mvp.R;
import orm.mvp.mvp.bean.User;
import orm.mvp.mvp.presenter.LoginPresenter;
import orm.mvp.mvp.view.LoginView;

/**
 * Created by xingyatong on 2018/3/13.
 * 这里需要创建presenter对象，presenter对象中是有view对象和model对象的！
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_userpwd)
    EditText et_userpwd;
    @BindView(R.id.btn_login)
    Button btn_login;

    private LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter();
        loginPresenter.bindView(LoginActivity.this);//绑定View和Presenter，因为这个Activity已经实现了接口，已经包含了View对象
    }

    @Override
    public String getUserName() {
        return et_username.getText().toString();
    }

    @Override
    public String getUserPwd() {
        return et_userpwd.getText().toString();
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showNetEror() {

    }

    @Override
    public void showVerifyFail() {
        Toast.makeText(LoginActivity.this, "验证失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_login})
    public void loginClick(Button button) {
        switch (button.getId()) {
            case R.id.btn_login:
                //需要对登录的数据验证判断，用到presenter
                loginPresenter.login();
                break;
        }
    }
}
