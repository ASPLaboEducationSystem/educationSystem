/* –â‘è‚ÌŽÀ‘ÌƒNƒ‰ƒX */
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

public class Question{
    @JsonbProperty(value = "id")
    private String id;
    @JsonbProperty(value = "questionText")
    private String questionText;
    @JsonbProperty(value = "selections")
    private List<String> selections = new ArrayList<String>();
    @JsonbProperty(value = "correctAnswer")
    private int correctAnswer;
    @JsonbProperty(value = "explanationText")
    private String explanationText;
    @JsonbProperty(value = "hintText")
    private String hintText;
    public Question(){
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getQuestionText(){
        return this.questionText;
    }
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
    public List<String> getSelections(){
        return this.selections;
    }
    public void setSelections(List<String> selections){
        this.selections = selections;
    }
    public String getHintText(){
        return this.hintText;
    }
    public void setHintText(String hintText){
        this.hintText = hintText;
    }
    public String getExplanationText(){
        return this.explanationText;
    }
    public void setExplanationText(String explanationText){
        this.explanationText = explanationText;
    }
    public int getCorrectAnswer(){
        return this.correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer = correctAnswer;
    }
}