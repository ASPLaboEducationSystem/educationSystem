import java.util.ArrayList;
import java.util.List;

public class Educatee{
    private String id;
    private List<Unit> list = new ArrayList<Unit>();
    public Educatee(){
    }
    public Educatee(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public List<Unit> getList(){
        return this.list;
    }
    public void setList(List<Unit> list){
        this.list = list;
    }
    public void add(Unit unit){
        this.list.add(unit);
    }
    public Unit get(int index){
        return this.list.get(index);
    }
    public int size(){
        return this.list.size();
    }
}