import java.util.ArrayList;
import java.util.List;

public class UsecaseList{
    private List<Usecase> list = new ArrayList<Usecase>();
    public UsecaseList(){
        this.add(new Questioner());
        this.add(new ShowBasicGrammer());
        this.add(new ShowScore());
    }
    public void add(Usecase usecase){
        this.list.add(usecase);
    }
    public Usecase get(int index){
        return this.list.get(index);
    }
    public int size(){
        return this.list.size();
    }
}