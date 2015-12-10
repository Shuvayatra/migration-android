package com.yipl.nrna.data.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.yipl.nrna.domain.util.MyConstants;

/**
 * Created by Nirazan-PC on 12/9/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    Context context;
    private SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, MyConstants.DATABASE.DBINFO.DATABASE_NAME, null, MyConstants.DATABASE.DBINFO.DB_VERSION);
        db = getWritableDatabase();
        Log.i("database", "constructor called");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MyConstants.DATABASE.TABLE_POST.CREATE_TABLE_POST);
        Log.i("database", "database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }



    public SQLiteDatabase getSqlLiteDatabse() {
        return db;
    }

    public void close(){

        db.close();

    }
}