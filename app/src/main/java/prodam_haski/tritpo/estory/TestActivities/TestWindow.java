package prodam_haski.tritpo.estory.TestActivities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import prodam_haski.tritpo.estory.BDManager.DatabaseHelper;
import prodam_haski.tritpo.estory.BDManager.ExternalDbOpenHelper;
import prodam_haski.tritpo.estory.BDManager.Task;
import prodam_haski.tritpo.estory.BDManager.TaskManager;
import prodam_haski.tritpo.estory.Interfaces.Language;
import prodam_haski.tritpo.estory.Interfaces.TypeOfTest;
import prodam_haski.tritpo.estory.R;
import prodam_haski.tritpo.estory.StartActivities.MainActivity;
import prodam_haski.tritpo.estory.StartActivities.TestSelection;

public class TestWindow extends AppCompatActivity implements TypeOfTest, Language {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    List<Task> taskList;
   // ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(getApplicationContext(), "ForEastory");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_window);

        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        w.setBackgroundDrawableResource(setting.backgroundInstall());

        //databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        //databaseHelper.create_db();


        //SQLiteDatabase db = dbOpenHelper.getDb();

        final RadioButton userAnswer1=(RadioButton) findViewById(R.id.radioButton1);
        final RadioButton userAnswer2=(RadioButton) findViewById(R.id.radioButton2);
        final RadioButton userAnswer3=(RadioButton) findViewById(R.id.radioButton3);
        final RadioButton userAnswer4=(RadioButton) findViewById(R.id.radioButton4);
        final Button answer=(Button) findViewById(R.id.buttonAnswer);
        final Button image=(Button) findViewById(R.id.buttonImage);
        final Button description=(Button) findViewById(R.id.buttonDescription);
        final TextView textTask = (TextView)findViewById(R.id.textTask);
        final Button buttonNext=(Button)findViewById(R.id.buttonNext);
        final Button buttonPrev=(Button)findViewById(R.id.buttonPrevios);

        if(change.getLanguage().equals("by")){
            answer.setText(R.string.answer_by);
        }

        description.setClickable(false);
        image.setClickable(false);

    }

    {/*   @Override
    public void onResume() {
        super.onResume();
        // открываем подключение
        db = databaseHelper.open();
        //получаем данные из бд в виде курсора
        switch (setting.getType()){
            //  case 0: listTask.add(createTask());break;
            case 1: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLEANTIQUITY, null);break;
            case 2: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLEMEDIVAL, null);break;
            case 3: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLENEW1, null);break;
            case 4: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLENEW2, null);break;
            case 5: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLESOVIETS, null);break;
            case 6: userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLENEWEST, null);break;
        }

        for(int i=0;i<10;i++){
            Task task=new Task();
            List<String> answers = null;

            userCursor.moveToPosition(i);

            if(change.getLanguage().equals("by")){
                task.setTaskText(userCursor.getString(2)) ;
                task.setDescription(userCursor.getString(14));
                for (int j=7;j<11;j++){
                    answers.add(userCursor.getString(j));
                }
            }

            if(change.getLanguage().equals("ru")){
                task.setTaskText(userCursor.getString(1)) ;
                task.setDescription(userCursor.getString(13));
                for (int j=3;j<7;j++){
                    answers.add(userCursor.getString(j));
                }
            }

            task.setImage(userCursor.getBlob(12));
            task.setRightAnswer(userCursor.getInt(11));

            taskList.add(i,task);

        }

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
*/}
    {/*  public List<Task> createList(){
        List<Task> listTask = null;
        for (int i=0;i<SIZE;i++){
            switch (setting.getType()){
                //  case 0: listTask.add(createTask());break;
                case 1: listTask.add(createTask("TaskAntiquity"));break;
                case 2: listTask.add(createTask("TaskMedival"));break;
                case 3: listTask.add(createTask("TaskNew1"));break;
                case 4: listTask.add(createTask("TaskNew2"));break;
                case 5: listTask.add(createTask("Soviets"));break;
                case 6: listTask.add(createTask("TaskNewest"));break;
            }
        }
        return listTask;
    }

    public Task createTask(String period){
        Task task=new Task();
        final Random random = new Random();
        String text = null ;
        byte[] image=null;
        List<String> answers = null;
        int rightAnswer=0;
        String textDescrition = null;


        cursor.moveToPosition(1);

        if(change.getLanguage().equals("by")){
            text = cursor.getString(2);
            textDescrition = cursor.getString(14);
            for (int j=7;j<11;j++){
                answers.add(cursor.getString(j));
            }
        }

        if(change.getLanguage().equals("ru")){
            text = cursor.getString(1);
            textDescrition = cursor.getString(13);
            for (int j=3;j<7;j++){
                answers.add(cursor.getString(j));
            }
        }



        task.setAnswers(answers);
        task.setImage(image);
        task.setRightAnswer(rightAnswer);
        task.setTaskText(text);
        task.setDescription(textDescrition);

        cursor.close();
        return task;
    }*/}

    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(TestWindow.this, TestSelection.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}
    }
}
