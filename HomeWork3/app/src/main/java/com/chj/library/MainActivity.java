package com.chj.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        final EditText et1 = (EditText)this.findViewById(R.id.et_name);
        final EditText et2 = (EditText)this.findViewById(R.id.et_price);
        final EditText et3 = (EditText)this.findViewById(R.id.et_author);
        final EditText et4 = (EditText)this.findViewById(R.id.et_press);
        final EditText et5 = (EditText)this.findViewById(R.id.et_publish);
        final EditText et6 = (EditText)this.findViewById(R.id.et_isbn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="书名："+et1.getText().toString()+"\n"+
                        "单价"+et2.getText().toString()+"\n"+
                        "作者"+et3.getText().toString()+"\n"+
                        "出版社"+et4.getText().toString()+"\n"+
                        "出版日期"+et5.getText().toString()+"\n"+
                        "ISBN"+et6.getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });
    }
}