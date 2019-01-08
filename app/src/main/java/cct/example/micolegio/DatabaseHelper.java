package cct.example.micolegio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "STUDENTS";

    // atributos del estudiante
    public static final String _ID = "id";
    public static final String CI = "ci";
    public static final String NAMES = "names";             //nombre
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";           //genero
    public static final String NATIONALITY = "nationality"; //nacionalidad_domicilio
    public static final String BIRTHDATE = "birthdate";     //fechaNac
    public static final String GRADE="curso";
    public static final String PARALLEL="paralelo";
    public static final String DOMICILE="dimicilio";
    public static final String USER="user";
    public static final String PASSWORD="password";
    public static final String TYPE="type";

    public static final String CI_T = "ci_t";
    public static final String NAMES_T = "names_t";             //nombre
    public static final String WORK_T = "work_t";
    public static final String TELEPHONE_T = "telephone_t";           //genero



    // Table Name Teacher
    public static final String TABLE_NAME_TEACHER = "TEACHERS";

    // Table  present columns
    public static final String ID_P = "_id";
    public static final String CI_P = "ci";
    public static final String NAME_ABSOLUTE_P = "names_p";
    public static final String SURNAME_P="surname_p";
    public static final String GENDER_P = "gender_pt";
    public static final String BIRTHDATE_P = "birthdate_p";
    public static final String MAIL_P = "mail_p";
    public static final String TELEPHONE_P = "telephone_p";
    public static final String SPECIALTY_P = "specialty_p";
    public static final String DOMICILE_P = "domicile_p";
    public static final String USER_P="user_p";
    public static final String PASSWORD_P="password_p";
    public static final String TYPE_P = "type_p";


    // Table Name Presents
    public static final String TABLE_NAME_PRESENT = "PRESENTS";

    // Table  present columns
    public static final String _ID_PRESENT = "_id";
    public static final String NAME_PRESENT = "name_present";
    public static final String STATE_PRESENT = "state_present";
    public static final String _ID_FOREIGN_PERSON = "_id_person";
    public static final String TYPO="tipo";



    // Database Information
    static final String DB_NAME = "MY_HIGH_SCHOOL.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table students
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NATIONALITY + " TEXT, "
            + GENDER + " TEXT, "
            + NAMES + " TEXT, "
            + CI + " TEXT, "
            + GRADE + " TEXT, "
            + PARALLEL + " TEXT, "
            + DOMICILE + " TEXT, "
            + TYPE + " TEXT, "
            + BIRTHDATE + " TEXT, "
            + USER + " TEXT, "
            + PASSWORD + " TEXT, "
            + LAST_NAME + " TEXT,"
            + NAMES_T + " TEXT, "
            + CI_T + " TEXT, "
            + WORK_T + " TEXT, "
            + TELEPHONE_T + " TEXT );";


    // Creando la tabla teachers
    private static final String CREATE_TABLE_TEACHERS = "create table " + TABLE_NAME_TEACHER + "("
            + ID_P + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CI_P + " TEXT, "
            + NAME_ABSOLUTE_P + " TEXT, "
            + SURNAME_P + " TEXT, "
            + USER_P + " TEXT, "
            + PASSWORD_P + " TEXT, "
            + GENDER_P + " TEXT, "
            + BIRTHDATE_P + " TEXT, "
            + MAIL_P + " TEXT, "
            + TELEPHONE_P + " TEXT, "
            + SPECIALTY_P + " TEXT, "
            + DOMICILE_P + " TEXT, "
            + TYPE_P + " TEXT );";


    // Creating table presemt
    private static final String CREATE_TABLE_PRESENTS = "create table " + TABLE_NAME_PRESENT + "("
            + _ID_PRESENT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME_PRESENT + " TEXT, "
            + STATE_PRESENT + " INTEGER, "
            + _ID_FOREIGN_PERSON + " INTEGER );";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_TEACHERS);
        //db.execSQL(CREATE_TABLE_PRESENTS);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME_TEACHER);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PRESENT);
        onCreate(db);
    }
}