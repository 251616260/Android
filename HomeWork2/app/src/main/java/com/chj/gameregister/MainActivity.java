package com.chj.gameregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b1 = (Button)this.findViewById(R.id.b1);
        final EditText name = (EditText)this.findViewById(R.id.et_name);
        final EditText passwd = (EditText)this.findViewById(R.id.et_passwd);
        //当Edit控件内容为空时，登陆按钮不可用
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(name.getText())||TextUtils.isEmpty(passwd.getText())){
                    b1.setEnabled(false);
                }else{
                    b1.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(name.getText())||TextUtils.isEmpty(passwd.getText())){
                    b1.setEnabled(false);
                }else{
                    b1.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登陆成功跳转到新界面
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                //根据用户名显示不同的提示
                if(name.getText().toString().equals("root")) {
                    Toast.makeText(MainActivity.this, "登陆成功,管理员", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "登陆成功，用户"+name.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}