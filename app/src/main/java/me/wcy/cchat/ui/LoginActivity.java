package me.wcy.cchat.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import me.wcy.cchat.R;
import me.wcy.cchat.tools.AppCache;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etHost;
    private EditText etPort;

    private EditText etAccount;
    private EditText etToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etHost = findViewById(R.id.et_host);
        etPort = findViewById(R.id.et_port);

        etAccount = findViewById(R.id.et_account);
        etToken = findViewById(R.id.et_token);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                doLoginAction();
                break;
            case R.id.btn_server:
                doServerAction();
                break;
        }

    }

    private void doServerAction() {
        int port = Integer.parseInt(etPort.getText().toString());

        //  启动服务器 create service
        AppCache.getServerService().startServer(port);
    }

    private void doLoginAction() {
        AppCache.getClientService().login(

                etHost.getText().toString(),
                Integer.parseInt(etPort.getText().toString()),

                etAccount.getText().toString(),
                etToken.getText().toString(),
                (code, msg, aVoid) -> {
                    if (code == 200) {
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(this, "登录失败 code=" + code + ", msg=" + msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
