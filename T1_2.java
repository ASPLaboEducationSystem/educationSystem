public class T1_2 {
    public static void main(String[] args) {
        EducateeList educateeList = new EducateeList();

        // Educateeを新たに追加
        Educatee educatee = new Educatee("s001");
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

        // 表示して確認
        EducateeList loadedEducateeList = EducateeListUtils.load("EducateeList.xml");

        for(Educatee educatee1 : loadedEducateeList.getList()){
            System.out.println("id:" + educatee1.getId());
            for(Unit unit : educatee.getList()){
                for(Score score : unit.getList()){
                    System.out.println("score" + score.getQuestionId() + " status:" + score.getStatus());
                }
            }
        }
    }
}