public class ShowScore implements Usecase{
    @Override
    public void start(Educatee educatee, int selectedUnitNumber){
        //this.print(educatee); 全ての単元のスコアを表示する
        Unit unit = educatee.get(selectedUnitNumber - 1);
        this.print(unit);
        System.out.println(); //改行
    }
    public void print(Educatee educatee){
        System.out.println("educateeId: " + educatee.getId());
        for(Unit unit : educatee.getList()){
            this.print(unit);
        }
    }
    public void print(Unit unit){
        System.out.println("unitId: " + unit.getSectionId());
        for(Score score : unit.getList()){
            this.print(score);
        }
    }
    public void print(Score score){
        System.out.println("score" + score.getQuestionId() + ": " + score.getStatus());
    }
}