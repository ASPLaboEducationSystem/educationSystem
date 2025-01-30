import java.nio.charset.Charset;
import java.nio.file.Paths;

public class ShowBasicGrammer implements Usecase{
    // –{—ˆ‚ÍNG
    private final String[] FILENAME = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt", "7.txt", "8.txt", "9.txt", "10.txt"};
    @Override
    public void start(Educatee educatee, int selectedUnitNumber){
        String data = PathUtils.readAll(Paths.get(this.FILENAME[selectedUnitNumber - 1]), Charset.forName("UTF-8"));
        System.out.println(data);
    }
}

