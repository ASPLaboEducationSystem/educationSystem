public class T1_1 {
    public static void main(String[] args) {
        EducateeList educateeList = new EducateeList();
        Educatee educatee1 = new Educatee("s001");
        Unit unit1 = new Unit("1");
        Score score1 = new Score("1");
        Score score2 = new Score("2");

        score1.setStatus(AnswerStatus.Collect);
        score2.setStatus(AnswerStatus.Uncollect);
        
        unit1.add(score1);
        unit1.add(score2);
        educatee1.add(unit1);
        educateeList.add(educatee1);

        EducateeListUtils.save("EducateeList.xml", educateeList);

        EducateeList loadedEducateeList = EducateeListUtils.load("EducateeList.xml");

        for(Educatee educatee : loadedEducateeList.getList()){
            System.out.println("id:" + educatee.getId());
            for(Unit unit : educatee.getList()){
                for(Score score : unit.getList()){
                    System.out.println("score" + score.getQuestionId());
                }
            }
        }
    }
}