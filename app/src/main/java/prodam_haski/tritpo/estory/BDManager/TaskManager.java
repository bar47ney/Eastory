package prodam_haski.tritpo.estory.BDManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Blob;
import java.util.List;
import java.util.Random;

import prodam_haski.tritpo.estory.Interfaces.Language;
import prodam_haski.tritpo.estory.Interfaces.TypeOfTest;

public class TaskManager implements Language, TypeOfTest {

    private List<Task> listTask;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase myDb;

    public TaskManager(SQLiteDatabase Db, DatabaseHelper DBHelper){
        myDBHelper=DBHelper;
        myDb = Db;
    }

    public List<Task> createList(){
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

        Cursor cursor = myDb.rawQuery("SELECT * FROM "+period, null);
        //cursor.moveToPosition(random.nextInt(20));
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

        rightAnswer= cursor.getInt(11);
        image=cursor.getBlob(12);

        task.setAnswers(answers);
        task.setImage(image);
        task.setRightAnswer(rightAnswer);
        task.setTaskText(text);
        task.setDescription(textDescrition);

        cursor.close();
        return task;
    }

}
