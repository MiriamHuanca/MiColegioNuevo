package cct.example.micolegio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c) {

        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {

        dbHelper.close();
    }

    public void insert(String ci, String names, String last_name, String gender, String nationality, String birthdate, String grade, String parallel, String domicile, String type,String ci_t,
                       String names_t, String direction_t, String telephone_t) {
        ContentValues contentValue = new ContentValues();

        contentValue.put(DatabaseHelper.CI, ci);
        contentValue.put(DatabaseHelper.NAMES, names);
        contentValue.put(DatabaseHelper.LAST_NAME, last_name);
        contentValue.put(DatabaseHelper.GENDER, gender);
        contentValue.put(DatabaseHelper.NATIONALITY, nationality);
        contentValue.put(DatabaseHelper.BIRTHDATE, birthdate);
        contentValue.put(DatabaseHelper.GRADE, grade);
        contentValue.put(DatabaseHelper.PARALLEL, parallel);
        contentValue.put(DatabaseHelper.DOMICILE, domicile);
        contentValue.put(DatabaseHelper.TYPE, type);
        contentValue.put(DatabaseHelper.USER, names+ci);
        contentValue.put(DatabaseHelper.PASSWORD, ci);
        contentValue.put(DatabaseHelper.CI_T, ci_t);
        contentValue.put(DatabaseHelper.NAMES_T, names_t);
        contentValue.put(DatabaseHelper.WORK_T, direction_t);
        contentValue.put(DatabaseHelper.TELEPHONE_T, telephone_t);


        System.out.println(contentValue);
        //Log.wtf(contentValue, "entro en insert");

        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper.CI, DatabaseHelper.NAMES,
                DatabaseHelper.LAST_NAME, DatabaseHelper.GENDER, DatabaseHelper.NATIONALITY,
                DatabaseHelper.BIRTHDATE,DatabaseHelper.GRADE,DatabaseHelper.PARALLEL,
                DatabaseHelper.DOMICILE,DatabaseHelper.TYPE,DatabaseHelper.USER,DatabaseHelper.PASSWORD,
                DatabaseHelper.CI_T,DatabaseHelper.NAMES_T,DatabaseHelper.WORK_T,DatabaseHelper.TELEPHONE_T
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        Log.wtf("wtf", "entro en fetch");
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    public Cursor fetchConsulEst(String ci) {
        String[] columns = new String[] { DatabaseHelper.CI, DatabaseHelper.NAMES,
                DatabaseHelper.LAST_NAME, DatabaseHelper.GENDER, DatabaseHelper.NATIONALITY,
                DatabaseHelper.BIRTHDATE,DatabaseHelper.GRADE,DatabaseHelper.PARALLEL,
                DatabaseHelper.DOMICILE,DatabaseHelper.TYPE,DatabaseHelper.USER,DatabaseHelper.PASSWORD,
                DatabaseHelper.CI_T,DatabaseHelper.NAMES_T,DatabaseHelper.WORK_T,DatabaseHelper.TELEPHONE_T
        };
        Log.wtf("llego",ci);
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, DatabaseHelper.CI + "="+ci, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Log.wtf("llego a DBMnager","ok");
        return cursor;
    }

   /* public int update(long _id, String name, String desc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.STATE, desc);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }*/

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

    public void insertPro(String ci, String names,String surname, String gender, String birthdate, String mail, String telephone, String specialty, String domicile, String type) {
        ContentValues contentValue = new ContentValues();

        contentValue.put(DatabaseHelper.CI_P, ci);
        contentValue.put(DatabaseHelper.NAME_ABSOLUTE_P, names);
        contentValue.put(DatabaseHelper.SURNAME_P, surname);
        contentValue.put(DatabaseHelper.GENDER_P, gender);
        contentValue.put(DatabaseHelper.BIRTHDATE_P, birthdate);
        contentValue.put(DatabaseHelper.MAIL_P, mail);
        contentValue.put(DatabaseHelper.TELEPHONE_P, telephone);
        contentValue.put(DatabaseHelper.SPECIALTY_P, specialty);
        contentValue.put(DatabaseHelper.DOMICILE_P, domicile);
        contentValue.put(DatabaseHelper.TYPE_P, type);
        contentValue.put(DatabaseHelper.USER_P, names+ci);
        contentValue.put(DatabaseHelper.PASSWORD_P, ci);


        System.out.println(contentValue);
        //Log.wtf(contentValue, "entro en insert");

        database.insert(DatabaseHelper.TABLE_NAME_TEACHER, null, contentValue);


    }

    public Cursor fetchPro() {
        String[] columns = new String[] { DatabaseHelper.CI_P, DatabaseHelper.NAME_ABSOLUTE_P,DatabaseHelper.SURNAME_P,
                DatabaseHelper.GENDER_P, DatabaseHelper.BIRTHDATE_P,
                DatabaseHelper.MAIL_P,DatabaseHelper.TELEPHONE_P,
                DatabaseHelper.SPECIALTY_P,DatabaseHelper.DOMICILE_P,DatabaseHelper.TYPE_P,DatabaseHelper.USER_P,DatabaseHelper.PASSWORD_P
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME_TEACHER, columns, null, null, null, null, null);
        Log.wtf("wtf", "entro en fetch");
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }


    public void deletePro(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME_TEACHER, DatabaseHelper.ID_P + "=" + _id, null);
    }

public Cursor fetchType(String ci) {
       String[] columns = new String[] { DatabaseHelper.TYPE, DatabaseHelper.CI
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, DatabaseHelper.CI + "="+ci, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Log.wtf("llego a DBMnager","ok");
        return cursor;
    }

    public Cursor fetchTypeDocente(String ci) {
        String[] columns = new String[] { DatabaseHelper.TYPE_P, DatabaseHelper.CI_P
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME_TEACHER, columns, DatabaseHelper.CI_P + "="+ci, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Log.wtf("llego a DBMnager","ok");
        return cursor;
    }

    public Cursor exitsDirector(String ci) {
        String[] columns = new String[] { DatabaseHelper.TYPE_P, DatabaseHelper.CI_P
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME_TEACHER, columns, DatabaseHelper.CI_P + "="+ci, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Log.wtf("llego a DBMnager","ok");
        return cursor;
    }

    public Cursor fetchConsulDoc(String ci) {
        String[] columns = new String[] { DatabaseHelper.CI_P, DatabaseHelper.NAME_ABSOLUTE_P,DatabaseHelper.SURNAME_P,
                DatabaseHelper.GENDER_P, DatabaseHelper.BIRTHDATE_P,
                DatabaseHelper.MAIL_P,DatabaseHelper.TELEPHONE_P,
                DatabaseHelper.SPECIALTY_P,DatabaseHelper.DOMICILE_P,
                DatabaseHelper.TYPE_P,DatabaseHelper.USER_P,DatabaseHelper.PASSWORD_P
        };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME_TEACHER, columns, DatabaseHelper.CI_P + "="+ci, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Log.wtf("llego a DBMnager","ok");
        return cursor;
    }


}
