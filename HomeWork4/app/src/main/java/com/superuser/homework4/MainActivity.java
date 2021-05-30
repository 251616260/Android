package com.superuser.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et1 = (EditText) this.findViewById(R.id.editText);
        EditText et2 = (EditText) this.findViewById(R.id.editText2);
        TextView tsb = (TextView)this.findViewById(R.id.textView_sb);
        TextView tpb = (TextView)this.findViewById(R.id.textView_pb);
        SeekBar sb = (SeekBar)this.findViewById(R.id.seekBar);
        Button btn = (Button)this.findViewById(R.id.button);
        Button btn_add = (Button)this.findViewById(R.id.button_add);
        Button btn_minus = (Button)this.findViewById(R.id.button_minus);
        ProgressBar pb = (ProgressBar)this.findViewById(R.id.progressBar);
        pb.setProgress(0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = "图书名称："+et1.getText().toString().trim()+"  "+"出版社："+et2.getText().toString().trim();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tsb.setText(" "+(int)sb.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress()+10);
                tpb.setText(pb.getProgress()+"%");
                if(pb.getProgress()==100){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("进度条已满");
                    builder.setCancelable(false);
                    builder.setPositiveButton("清空", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            pb.setProgress(0);
                            tpb.setText(pb.getProgress()+"%");
                        }
                    });
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress()-10);
                tpb.setText(pb.getProgress()+"%");
                if(pb.getProgress()==0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("进度条已为0");
                    builder.setCancelable(false);
                    builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}