package com.chj.homework4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String string = "ok";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t2 = (TextView)this.findViewById(R.id.t2);
        Button bt = (Button) this.findViewById(R.id.b1);
        ProgressBar pb = (ProgressBar)this.findViewById(R.id.p1);
        pb.setProgress(0);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(pb.getProgress()+10);
                t2.setText(pb.getProgress()+"%");
                if(pb.getProgress()==100){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("进度条已满");
                    builder.setCancelable(false);
                    builder.setPositiveButton("清空", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            pb.setProgress(0);
                            t2.setText(pb.getProgress()+"%");
                        }
                    });
                    builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
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