/* Question.java‚ÌW–ñƒNƒ‰ƒX */
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

public class QuestionList{
    @JsonbProperty(value = "list")
    private List<Question> list = new ArrayList<Question>();
    public QuestionList(){
    }
    public List<Question> getList(){
        return this.list;
    }
    public void setList(List<Question> list){
        this.list = list;
    }
    public void add(Question question){
        this.list.add(question);
    }
    public Question get(int index){
        return this.list.get(index);
    }
    public Question remove(int index){
        return this.list.remove(index);
    }
    public int size(){
        return this.list.size();
    }
}