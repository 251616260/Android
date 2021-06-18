package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class SqliteActivity extends AppCompatActivity {

    CourseService cs;
    EditText etname, etprice;
    Button btnSave, btnadd, btnmod, btndel, btnSel;
    String cid, cname, cprice;
    View layout1, layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        layout1 = inflater.inflate(R.layout.activity_main, null);
        layout2 = inflater.inflate(R.layout.moddate, null);
        setContentView(layout1);
        this.cs = new CourseService(this);
        btnadd = (Button)this.findViewById(R.id.btnAdd);
        btnmod = (Button)this.findViewById(R.id.btnMod);
        btndel = (Button)this.findViewById(R.id.btnDel);
        btnSel = (Button)this.findViewById(R.id.btnSel);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                setContentView(layout2);
                btnSave = (Button)findViewById(R.id.btnSave);
                etname = (EditText)findViewById(R.id.editText1);
                etprice = (EditText)findViewById(R.id.editText2);
                etname.setText("");
                etprice.setText("");
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        if(etname.getText().equals(null)
                            || etprice.getText().equals(null)) {
                        } else {
                            String name = etname.getText().toString().trim();
                            float price = Float.parseFloat(etprice.getText().toString().trim());
                            Course course = new Course(1, name, price);

                            cs.save(course);
                            setContentView(layout1);
                            queryDate();
                        }
                    }
                });
            }
        });

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(SqliteActivity.this,"请先选择要修改的记录然后单击！",Toast.LENGTH_SHORT).show();
                queryDate();
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(SqliteActivity.this,"请先选择要删除的记录然后长按！",Toast.LENGTH_SHORT).show();
                queryDate();
            }
        });

        btnSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                queryDate();
            }
        });

    }

    private void queryDate() {
        List<Course> courses = cs.getAllCourse();
        ListView lv = (ListView)findViewById(R.id.listCourse);
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

        for (Course course : courses) {
            HashMap<String, Object> item = new HashMap<String, Object>();
            item.put("cid", course.getCid());
            item.put("cname",course.getCname());
            item.put("cprice", course.getPrice());
            data.add(item);
        }
        String[] tempstr = new String[] {"cid", "cname", "cprice"};
        int[] tempint = new int[] {R.id.cid, R.id.cname, R.id.cprice};
        SimpleAdapter adapter = new SimpleAdapter(SqliteActivity.this, data, R.layout.item, tempstr, tempint);
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                listtoItem(parent, position);
                new AlertDialog.Builder(SqliteActivity.this)
                        .setTitle("提示信息")
                        .setMessage("是否删除")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                cs.delete(Integer.parseInt(cid));
                                Toast.makeText(SqliteActivity.this,"删除成功！", Toast.LENGTH_SHORT).show();
                                setContentView(layout1);
                                queryDate();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                setContentView(layout1);
                            }
                        }).show()
                return false;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
                listtoItem(parent, position);
                setContentView(layout2);
                btnSave = (Button)findViewById(R.id.btnSave);
                etname = (EditText)findViewById(R.id.editText1);
                etprice = (EditText)findViewById(R.id.editText2);
                etname.setText(cname);
                etprice.setText(cprice);
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        if(etname.getText().equals(null) || etprice.getText().equals(null)){
                            Toast.makeText(SqliteActivity.this, "不能为空！", Toast.LENGTH_SHORT).show();
                        }
                        else if (etprice.getText()){
                        }
                        else {
                            String name = etname.getText().toString().trim();
                            float price = Float.parseFloat(etprice.getText().toString().trim());
                            Course course = new Course(Integer.parseInt(cid),name,price);

                            cs.update(course);
                            setContentView(layout1);
                            queryDate();
                        }
                    }
                });
            }
        });
    }

    private  void listtoItem(AdapterView<?> parent, int position) {
        ListView ls = (ListView) parent;

        HashMap<String, Object> item1 = (HashMap<String, Object>) ls.getItemAtPosition(position);
        cid = item1.get("cid").toString();
        cname = item1.get("cname").toString();
        cprice = item1.get("cprice").toString();
    }
}