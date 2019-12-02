package prodam_haski.tritpo.estory.StartActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import prodam_haski.tritpo.estory.Interfaces.Language;
import prodam_haski.tritpo.estory.R;

public class MainActivity extends AppCompatActivity implements Language {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this, TestSelection.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e){}
            }
        });

        final Button changeButton = (Button)findViewById(R.id.changeLanguage);

        if(change.getLanguage().equals("by")){
            startButton.setText(R.string.start_by);
            changeButton.setText(R.string.change_by);
        }

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (change.getLanguage().equals("ru")) {
                        startButton.setText(R.string.start_by);
                        changeButton.setText(R.string.change_by);
                        change.swipeLanguage();
                    }
                    else {
                        startButton.setText(R.string.start_ru);
                        changeButton.setText(R.string.change_ru);
                        change.swipeLanguage();
                    }

                }catch (Exception e){}
            }
        });

        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //System button back double pressed
    private long backPressedTime;
    private Toast backToast;

    @Override
    public void onBackPressed(){

        if (backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast= Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();

    }
}
