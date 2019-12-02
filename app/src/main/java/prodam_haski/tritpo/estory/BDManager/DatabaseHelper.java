package prodam_haski.tritpo.estory.BDManager;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import prodam_haski.tritpo.estory.Interfaces.TypeOfTest;

public class DatabaseHelper extends SQLiteOpenHelper implements TypeOfTest {
    public static final String TABLEANTIQUITY = "Antiquity";// название таблицы в бд
    public static final String TABLEMEDIVAL = "Medival";
    public static final String TABLENEW1 = "New1";
    public static final String TABLENEW2 = "New2";
    public static final String TABLENEWEST = "Newest";
    public static final String TABLESOVIETS = "Soviets";

    private static String DB_PATH; // полный путь к базе данных
    private static String DB_NAME = "ForEastory.db";
    private static final int SCHEMA = 3; // версия базы данных

    // названия столбцов
    static final String COLUMN_ID = "_id";
    static final String COLUMN_TASKRU = "task_ru";
    static final String COLUMN_TASKBY = "task_by";
    static final String COLUMN_ANSWER1RU = "answer1_ru";
    static final String COLUMN_ANSWER2RU = "answer2_ru";
    static final String COLUMN_ANSWER3RU = "answer3_ru";
    static final String COLUMN_ANSWER4RU = "answer4_ru";
    static final String COLUMN_ANSWER1BY = "answer1_by";
    static final String COLUMN_ANSWER2BY = "answer2_by";
    static final String COLUMN_ANSWER3BY = "answer3_by";
    static final String COLUMN_ANSWER4BY = "answer4_by";
    static final String COLUMN_DESCRIPTIONRU = "description_ru";
    static final String COLUMN_DESCRIPTIONBY = "description_by";
    static final String COLUMN_RIGHTANSWER = "rightAnswer";
    static final String COLUMN_IMAGE = "image";
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + "/"+DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
    }

    public void create_db(){
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH);
            if (!file.exists()) {
                this.getReadableDatabase();
                //получаем локальную бд как поток
                myInput = myContext.getAssets().open(DB_NAME);
                // Путь к новой бд
                String outFileName = DB_PATH;

                // Открываем пустую бд
                myOutput = new FileOutputStream(outFileName);

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        }
        catch(IOException ex){
            Log.d("DatabaseHelper", ex.getMessage());
        }
    }
    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}