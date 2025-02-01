/* JSONファイルからQuestionとQuestionListにデシリアライズするクラス */
import java.nio.file.Paths;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class QuestionDeserializer{
    // categoryを追加して、jsonファイルを1つにする。
    private static final String[] FILENAME = {"1.json", "2.json", "3.json", "4.json", "5.json", "6.json", "7.json", "8.json", "9.json", "10.json"};
    public static QuestionList getQuestionList(int selectedUnitNumber){
        String all = JsonUtils.readAll(Paths.get("../json/" + FILENAME[selectedUnitNumber - 1]));
        Jsonb jsonb = JsonbBuilder.create();
        QuestionList questionList = jsonb.fromJson(all, QuestionList.class);
        return questionList;
    }
}