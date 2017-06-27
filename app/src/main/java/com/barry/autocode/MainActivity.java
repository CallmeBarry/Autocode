package com.barry.autocode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import tech.michaelx.authcode.AuthCode;
import tech.michaelx.authcode.CodeConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText tvcode = (EditText) findViewById(R.id.tv_code);
        CodeConfig config = new CodeConfig.Builder()
                .codeLength(4) // 设置验证码长度
                .smsFromStart(137) // 设置验证码发送号码前几位数字
                //.smsFrom(1690123456789) // 如果验证码发送号码固定，则可以设置验证码发送完整号码
                .smsBodyStartWith("老王科技") // 设置验证码短信开头文字
                .smsBodyContains("验证码") // 设置验证码短信内容包含文字
                .build();

        AuthCode.getInstance().with(this).config(config).into(tvcode);
    }
}
