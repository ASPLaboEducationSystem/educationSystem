public class Score {
    private String questionId;
    private AnswerStatus status = AnswerStatus.Unanswered; //未回答に設定
    public Score(){
    }
    public Score(String questionId){
        this.questionId = questionId;
    }
    public String getQuestionId(){
        return this.questionId;
    }
    public void setQuestionId(String questionId){
        this.questionId = questionId;
    }
    public AnswerStatus getStatus(){
        return this.status;
    }
    public void setStatus(AnswerStatus status){
        this.status = status;
    }
}
