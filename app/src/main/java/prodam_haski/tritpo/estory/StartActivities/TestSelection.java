package prodam_haski.tritpo.estory.StartActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import prodam_haski.tritpo.estory.Interfaces.Language;
import prodam_haski.tritpo.estory.Interfaces.TypeOfTest;
import prodam_haski.tritpo.estory.R;
import prodam_haski.tritpo.estory.TestActivities.TestWindow;

public class TestSelection extends AppCompatActivity implements Language, TypeOfTest {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.types_of_test);

        final Button buttonCommon = (Button)findViewById(R.id.buttonCommon);
        final Button buttonAnciety = (Button)findViewById(R.id.buttonAnciety);
        final Button buttonMedival = (Button)findViewById(R.id.buttonMedival);
        final Button buttonNew1 = (Button)findViewById(R.id.buttonNew1);
        final Button buttonNew2 = (Button)findViewById(R.id.buttonNew2);
        final Button buttonSoviets = (Button)findViewById(R.id.buttonSoviets);
        final Button buttonNewest = (Button)findViewById(R.id.buttonNewest);
        final ImageButton buttonBack = (ImageButton)findViewById(R.id.buttonBack);

        if(change.getLanguage().equals("by")){
            buttonCommon.setText(R.string.common_by);
            buttonAnciety.setText(R.string.antiquity_by);
            buttonMedival.setText(R.string.medival_by);
            buttonNew1.setText(R.string.new_by);
            buttonNew2.setText(R.string.newtime_by);
            buttonSoviets.setText(R.string.soviets_by);
            buttonNewest.setText(R.string.newesttime_by);
        }

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(TestSelection.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(0);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonAnciety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(1);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonMedival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(2);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonNew1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(3);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonNew2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(4);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonSoviets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(5);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        buttonNewest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    setting.setType(6);
                    Intent intent = new Intent(TestSelection.this, TestWindow.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });

        Window w=getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //System button back

    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(TestSelection.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}
    }
}
