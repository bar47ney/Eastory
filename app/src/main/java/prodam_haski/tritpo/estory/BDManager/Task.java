package prodam_haski.tritpo.estory.BDManager;

import java.sql.Blob;
import java.util.List;

import prodam_haski.tritpo.estory.Interfaces.Language;
import prodam_haski.tritpo.estory.Interfaces.TypeOfTest;

public class Task  {

    private String taskText;
    private List<String> answers;
    private int rightAnswer;
    private byte[] image;
    private String description;

    public void setTaskText(String value){taskText=value;}
    public void setRightAnswer(int value){rightAnswer=value;}
    public void setImage(byte[] value){image=value;}
    public void setAnswers(List<String> value){answers=value;}
    public void setDescription(String value){description=value;}

    public String getTaskText(){return taskText;}
    public int getRightAnswer(){return rightAnswer;}
    public List<String> getAnswers(){return answers;}
    public byte[] getImage(){return image;}
    public String getDescription(){return description;}

}
