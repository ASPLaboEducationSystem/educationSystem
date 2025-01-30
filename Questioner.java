/* 問題演習の進行を管理するクラス */
public class Questioner implements Usecase{
    @Override
    public void start(Educatee educatee, int selectedUnitNumber){
        QuestionList questionList = QuestionDeserializer.getQuestionList(selectedUnitNumber);
        Unit unit = educatee.get(selectedUnitNumber - 1);

        for(int i = 0; i < questionList.size(); i++){
            Question question = questionList.get(i);
            Score score = unit.get(i);

            /* 問題文の取得 */
            String questionText = question.getQuestionText();
            String id = question.getId();

            /* 問題文の出力 */
            System.out.println("ーーー問題" + id + "ーーー");
            System.out.println(questionText);
            System.out.println();

            /* 選択肢の取得・出力 */
            System.out.println("ーーー選択肢ーーー");
            for(String selection : question.getSelections()){
                System.out.println(selection);
            }
            System.out.println();

            /* ヒントが必要かを表示する */
            System.out.println("ヒントは必要ですか？(1:必要 2:不必要)");

            /* ヒントが必要かを入力してもらう */
            int inputAnswer = ScannerUtils.inputInt(2);
            System.out.println();

            /* ヒントが必要かを判断 */
            if(inputAnswer == 1){
                
                /* ヒントを取得する */
                String hintText = question.getHintText();
                
                /* ヒントを表示する */
                System.out.println("ーーーヒントーーー");
                System.out.println(hintText);
                System.out.println();
            }

            /* 回答を促すメッセージ */
            System.out.println("選択肢を入力してください(1～3)");
            
            /* 学習者から回答を取得 */
            inputAnswer = ScannerUtils.inputInt(3);

            /* 正答の取得 */
            int correctAnswer = question.getCorrectAnswer();
            
            /* 問題の正誤判定 & Educateeに正誤を記録*/
            if(inputAnswer == correctAnswer){
                System.out.println("正解");
                // Educateeに正解を記録
                score.setStatus(AnswerStatus.Collect);
            } else{
                System.out.println("不正解");
                System.out.println("正解は" + correctAnswer + "です");
                // Educateeに不正解を記録
                score.setStatus(AnswerStatus.Uncollect);
            }

            /* 問題の解説を取得 */
            String explanationText = question.getExplanationText();

            /* 解説を表示 */
            System.out.println();
            System.out.println("ーーー解説ーーー");
            System.out.println(explanationText);
            System.out.println();
            System.out.println();
            System.out.println();
        }
        /** ScoreをXMLファイルに記録する */
        EducateeList educateeList = new EducateeList();
        educateeList.add(educatee);
        EducateeListUtils.save("EducateeList.xml", educateeList);
    }
}