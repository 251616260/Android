package com.chj.homework6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private  DBHelper dbhelper;
    public CourseService(Context context){
        this.dbhelper= (DBHelper) DBHelper.getmInstance(context);
    }
    public void save(Course cs){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.execSQL("insert into books(bookName,price) values(?,?)",new Object[]{
                cs.getBookName(),cs.getPrice()
        });
    }
    public void update(Course cs){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.execSQL("update books set bookName=?,price=? where _id=?",new Object[]{
                cs.getBookName(),cs.getPrice(),cs.getId()
        });
    }
    public void delete(int _id){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.execSQL("delete from books where _id=?",new Object[]{
                _id+""
        });
    }
    public List<Course> getAllCourse(){
        List<Course> courses = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from books",null);
        while(cursor.moveToNext()){
            int bid=cursor.getInt(cursor.getColumnIndex("_id"));
            String bookName = cursor.getString(cursor.getColumnIndex("bookName"));
            float price = cursor.getFloat(cursor.getColumnIndex("price"));
            Course cs = new Course(bid,bookName,price);
            courses.add(cs);
        }
        cursor.close();
        return courses;
    }
}
