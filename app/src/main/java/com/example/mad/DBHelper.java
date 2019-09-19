package com.example.mad;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

   public static final String DATABASE_NAME = "MAD.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_QUERY1 = "CREATE TABLE " + UserMaster.Users.TABLE_NAME_LOGIN + " ( " +
                UserMaster.Users.COLUMN_NAME_ID1 + " INTEGER PRIMARY KEY," +
                UserMaster.Users.COLUMN_NAME_NAME + " TEXT, " +
                UserMaster.Users.COLUMN_NAME_PASSWORD + " TEXT)";

        String SQL_CREATE_QUERY2 = "CREATE TABLE " + UserMaster.Users.TABLE_NAME_SCORE + " ( " +
                UserMaster.Users.COLUMN_NAME_ID2 + " INTEGER PRIMARY KEY, " +
                UserMaster.Users.COLUMN_NAME_NAME + " TEXT, " +
                UserMaster.Users.COLUMN_NAME_PASSWORD + " TEXT, " +
                UserMaster.Users.COLUMN_NAME_LEVEL + " TEXT, " +
                UserMaster.Users.COLUMN_NAME_SCORE + " TEXT) ";
        sqLiteDatabase.execSQL(SQL_CREATE_QUERY1);
        sqLiteDatabase.execSQL(SQL_CREATE_QUERY2);


    }

    public void addInfo_Login_Table(String name, String password) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_NAME, name);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD, password);

        long newRowID = sqLiteDatabase.insert(UserMaster.Users.TABLE_NAME_LOGIN, null, values);
    }
    public void addInfo_Score_Table(String name, String password, String level, String score){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues values = new ContentValues();
       // values.put(UserMaster.Users.COLUMN_NAME_ID2, UserMaster.Users.COLUMN_NAME_ID1 );
        values.put(UserMaster.Users.COLUMN_NAME_NAME, name);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD, password);
        values.put(UserMaster.Users.COLUMN_NAME_LEVEL, level);
        values.put(UserMaster.Users.COLUMN_NAME_SCORE, score);

        long newRowID = sqLiteDatabase.insert(UserMaster.Users.TABLE_NAME_SCORE, null, values);
    }
//    public Cursor getInfo_Score_Table(){
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from Game_Score",null );
//        return cursor;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserMaster.Users.TABLE_NAME_SCORE);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserMaster.Users.TABLE_NAME_LOGIN);

    }
}
