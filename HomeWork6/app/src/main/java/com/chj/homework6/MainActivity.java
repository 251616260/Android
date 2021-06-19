package com.chj.homework6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CourseService cs;
    EditText et_name,et_price;
    Button btnSave,btnAdd,btnMod,btnDel,btnSel;
    View layout1,layout2;
    String _id,cName,cPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater =getLayoutInflater();
        layout1=inflater.inflate(R.layout.activity_main,null);
        layout2=inflater.inflate(R.layout.moddate,null);
        setContentView(layout1);
        init();
    }

    private void init() {
        this.cs = new CourseService(this);
        btnAdd=(Button)this.findViewById(R.id.btnAdd);
        btnMod=(Button)this.findViewById(R.id.btnMod);
        btnDel=(Button)this.findViewById(R.id.btnDel);
        btnSel=(Button)this.findViewById(R.id.btnSel);
    }

    public void addOnClick(View view){
        setContentView(layout2);
        btnSave=(Button)this.findViewById(R.id.btnSave);
        et_name=(EditText)this.findViewById(R.id.editText1);
        et_price=(EditText)this.findViewById(R.id.editText2);
        et_name.setText("");
        et_price.setText("");
        btnSave.setOnClickListener(v->{
            if(et_name.getText().equals(null)||et_price.getText().equals(null)){
                Toast.makeText(MainActivity.this,"不能为空！",Toast.LENGTH_SHORT).show();
            }else{
                String name=et_name.getText().toString().trim();
                float price =Float.parseFloat(et_price.getText().toString().trim());
                Course course = new Course(1,name,price);
                cs.save(course);
                setContentView(layout1);
                queryDate();
            }
        });
    }
    public void modOnClick(View view){
        Toast.makeText(MainActivity.this,"请选择要修改的记录然后点击！",Toast.LENGTH_SHORT).show();
        queryDate();
    }
    public void delOnClick(View view){
        Toast.makeText(MainActivity.this,"请选择要删除改的记录然后长按！",Toast.LENGTH_SHORT).show();
        queryDate();
    }
    public void selOnClick(View view){
        queryDate();
    }

    private void queryDate() {
        List<Course> courses = cs.getAllCourse();
        ListView lv = (ListView)findViewById(R.id.listCourse);
        List<HashMap<String,Object>> data = new ArrayList<>();
        for(Course course:courses){
            HashMap<String,Object> item = new HashMap<>();
            item.put("_id",course.getId());
            item.put("bookname",course.getBookName());
            item.put("price",course.getPrice());
            data.add(item);
        }
        String[] tempStr = new String[]{"_id","bookname","price"};
        int[] tempInt = new int[]{R.id.cid,R.id.cname,R.id.cprice};
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,data,R.layout.item,tempStr,tempInt);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener((AdapterView<?> parent,View arg1,int position,long arg3)->{
            listToItem(parent,position);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示信息");
            builder.setMessage("是否删除");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cs.delete(Integer.parseInt(_id));
                    Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                    setContentView(layout1);
                    queryDate();
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setContentView(layout1);
                }
            });
            builder.show();
            return false;
        });
        lv.setOnItemClickListener((AdapterView<?> parent,View arg1,int position,long arg3)->{
            listToItem(parent,position);
            setContentView(layout2);
            btnSave=(Button)findViewById(R.id.btnSave);
            et_name=(EditText)findViewById(R.id.editText1);
            et_price=(EditText)findViewById(R.id.editText2);
            et_name.setText(cName);
            et_price.setText(cPrice);
            btnSave.setOnClickListener(v->{
                if(et_name.getText().equals(null)||et_price.getText().equals(null)){
                    Toast.makeText(MainActivity.this,"不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    String name = et_name.getText().toString().trim();
                    float price = Float.parseFloat(et_price.getText().toString().trim());
                    Course course = new Course(Integer.parseInt(_id),name,price);
                    cs.update(course);
                    setContentView(layout1);
                    queryDate();
                }
            });
        });
    }

    private void listToItem(AdapterView<?> parent,int position) {
        ListView ls = (ListView)parent;

        HashMap<String,Object> item1 = (HashMap<String, Object>)ls.getItemAtPosition(position);
        _id = item1.get("_id").toString();
        cName = item1.get("bookname").toString();
        cPrice = item1.get("price").toString();
    }
}