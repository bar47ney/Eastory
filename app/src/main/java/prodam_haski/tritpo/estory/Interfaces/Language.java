package prodam_haski.tritpo.estory.Interfaces;

public interface Language {
    Changing change = new Changing();

    class Changing {
        String language = new String("ru");

        public String getLanguage(){return language;}

        public void setLanguage(String value){language=value;}

        public void swipeLanguage(){
            if (language.equals("ru"))setLanguage("by");
            else setLanguage("ru");
        }
    }
}
