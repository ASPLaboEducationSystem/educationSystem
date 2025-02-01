import java.util.ArrayList;
import java.util.List;

public class EducateeList{
    private List<Educatee> list = new ArrayList<Educatee>();
    public EducateeList(){
    }
    public List<Educatee> getList(){
        return this.list;
    }
    public void setList(List<Educatee> list){
        this.list = list;
    }
    public void add(Educatee educatee){
        this.list.add(educatee);
    }
    public Educatee get(int index){
        return this.list.get(index);
    }
    public int size(){
        return this.list.size();
    }
}