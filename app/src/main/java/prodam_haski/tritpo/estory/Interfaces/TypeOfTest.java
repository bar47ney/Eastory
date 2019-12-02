package prodam_haski.tritpo.estory.Interfaces;

import android.content.Context;
import android.graphics.drawable.Drawable;

import prodam_haski.tritpo.estory.R;

public interface TypeOfTest {

    static int SIZE = 10;

    TestSetting setting = new TestSetting();

    class TestSetting{
        /*type of test   0- common 1-antiquity 2-medival 3-newtime1 4 -newtime2 5-soviets 6-newest*/
        int type;

        public int getType(){return type;}
        public void setType(int value){type=value;}

       public int backgroundInstall() {
           switch (type) {
               case 0:
                   return R.drawable.commonback;
               case 1:
                   return R.drawable.polotsk1;
               case 2:
                   return R.drawable.polotsk2;
               case 3:
                   return R.drawable.new1;
               case 4:
                   return R.drawable.newback;
               case 5:
                   return R.drawable.newestback;
               case 6:
                   return R.drawable.library;
           }
           return 0;
       }
    }
}
