import java.util.ArrayList;
import java.util.List;

public class Unit{
    private String sectionId;
    private List<Score> list = new ArrayList<Score>();
    public Unit(){
    }
    public Unit(String sectionId){
        this.sectionId = sectionId;
    }
    public String getSectionId(){
        return this.sectionId;
    }
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    public List<Score> getList(){
        return this.list;
    }
    public void setList(List<Score> list){
        this.list = list;
    }
    public void add(Score score){
        this.list.add(score);
    }
    public Score get(int index){
        return this.list.get(index);
    }
    public int size(){
        return this.list.size();
    }
}
