/** 学習者を選択するクラス */
import java.util.Scanner;

public class EducateeSelector{
    public static boolean isRun = true;
    public EducateeSelector(){
    }
    public void start(){
        // 学習者のidを入力してもらう
        Scanner scanner = new Scanner(System.in);
        System.out.print("idを入力してください: ");
        String inputId = scanner.nextLine();
        System.out.println();

        // EducateeListを取得する
        EducateeList educateeList = EducateeListUtils.load("EducateeList.xml");

        // EducateeListの中から，入力された学習者を取り出す．
        Educatee educatee = this.searchEducateeById(educateeList, inputId);

        // EducateeList内に学習者が存在しなかったら，新規登録する．
        // idを間違えて使用してしまった場合の処理はない．passwordを入力してもらう?
        if(educatee == null){
            educatee = new Educatee(inputId);
            for(int i = 0; i < 10; i++){
                Unit unit = new Unit(String.valueOf(i + 1));
                QuestionList questionList = QuestionDeserializer.getQuestionList(i + 1);
                for(Question question : questionList.getList()){
                    String questionId = question.getId();
                    Score score = new Score(questionId);
                    score.setStatus(AnswerStatus.Unanswered);
                    unit.add(score);
                }
                educatee.add(unit);
            }
            educateeList.add(educatee);
            EducateeListUtils.save("EducateeList.xml", educateeList);
        }

        // ModeSelectorを呼び出す
        ModeSelector modeSelector = new ModeSelector();
        while(isRun){
            modeSelector.selectMode(educatee); //ユースケースと単元の選択を行う(本来はアプリ全体のクラスを呼んだ方が良いかも)
        }
    }
    private Educatee searchEducateeById(EducateeList educateeList, String keyId){
        for(Educatee educatee : educateeList.getList()){
            if(keyId.equals(educatee.getId())){
                return educatee;
            }
        }
        return null;
    }
}