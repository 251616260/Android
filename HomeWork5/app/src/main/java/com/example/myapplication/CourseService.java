package com.example.myapplication;

import java.util.List;

public interface CourseService {
    DBHelper dbHelper;
    public CourseService(Context context){
        dbHelper = new DBHelper(context);
    }
    public void save(User user){
        SQLiteDatabase sd = dbHelper.getWritableDatabase();
        sd.execSQL("insert into user(userName,passwd)values(?,?)",new Object[]{user.getUserName(),user.getPasswd()});
    }
    public void update(User user){
        SQLiteDatabase sd = dbHelper.getWritableDatabase();
        sd.execSQL("update user set passwd=? where userName=?",new Object[]{user.getPasswd(),user.getUserName()});
    }
    public List<User> findAll(){
        List<User> list = new ArrayList();
        SQLiteDatabase sd = dbHelper.getReadableDatabase();
        Cursor cursor = sd.rawQuery("select * from user", null);
        while(cursor.moveToNext()){				//����ƶ�����һ��
            String userName = cursor.getString(cursor.getColumnIndex("userName"));
            String passwd = cursor.getString(cursor.getColumnIndex("passwd"));
            User user = new User(userName,passwd);
            list.add(user);
        }
        return list;
    }
}
