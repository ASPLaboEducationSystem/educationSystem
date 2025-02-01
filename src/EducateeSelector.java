/** �w�K�҂�I������N���X */
import java.util.Scanner;

public class EducateeSelector{
    public static boolean isRun = true;
    public EducateeSelector(){
    }
    public void start(){
        // �w�K�҂�id����͂��Ă��炤
        Scanner scanner = new Scanner(System.in);
        System.out.print("id����͂��Ă�������: ");
        String inputId = scanner.nextLine();
        System.out.println();

        // EducateeList���擾����
        EducateeList educateeList = EducateeListUtils.load("EducateeList.xml");

        // EducateeList�̒�����C���͂��ꂽ�w�K�҂����o���D
        Educatee educatee = this.searchEducateeById(educateeList, inputId);

        // EducateeList���Ɋw�K�҂����݂��Ȃ�������C�V�K�o�^����D
        // id���ԈႦ�Ďg�p���Ă��܂����ꍇ�̏����͂Ȃ��Dpassword����͂��Ă��炤?
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

        // ModeSelector���Ăяo��
        ModeSelector modeSelector = new ModeSelector();
        while(isRun){
            modeSelector.selectMode(educatee); //���[�X�P�[�X�ƒP���̑I�����s��(�{���̓A�v���S�̂̃N���X���Ă񂾕����ǂ�����)
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