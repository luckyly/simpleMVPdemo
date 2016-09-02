package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.w3.sp.myapplication.R;

import presenter.ILoginPresenter;
import presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity  implements ILoginView, View.OnClickListener {

    private Button btn_login;
    private Button btn_clear;
    private EditText et_name;
    private EditText et_pwd;

    private ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_clear= (Button) findViewById(R.id.btn_clear);
        btn_login= (Button) findViewById(R.id.btn_login);
        et_name= (EditText) findViewById(R.id.et_name);
        et_pwd= (EditText) findViewById(R.id.et_password);

        btn_clear.setOnClickListener(this);
        btn_login.setOnClickListener(this);

        iLoginPresenter=new LoginPresenterImpl(this);

    }

    @Override
    public void onClearText() {
        et_pwd.setText("");
        et_name.setText("");
    }

    @Override
    public void onLoginResult(Boolean Result, int code) {
        if(Result){
            Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登录失败，请检查用户名和密码。",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_clear:
                iLoginPresenter.clear();
                break;
            case R.id.btn_login:
                String name=et_name.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();
                if(name.equals("")||pwd.equals("")){
                    Toast.makeText(this,"用户名和密码不能为空！",Toast.LENGTH_SHORT).show();
                }
                iLoginPresenter.doLogin(name,pwd);
                break;
        }
    }
}
