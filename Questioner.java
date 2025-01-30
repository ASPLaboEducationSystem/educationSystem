/* ��艉�K�̐i�s���Ǘ�����N���X */
public class Questioner implements Usecase{
    @Override
    public void start(Educatee educatee, int selectedUnitNumber){
        QuestionList questionList = QuestionDeserializer.getQuestionList(selectedUnitNumber);
        Unit unit = educatee.get(selectedUnitNumber - 1);

        for(int i = 0; i < questionList.size(); i++){
            Question question = questionList.get(i);
            Score score = unit.get(i);

            /* ��蕶�̎擾 */
            String questionText = question.getQuestionText();
            String id = question.getId();

            /* ��蕶�̏o�� */
            System.out.println("�[�[�[���" + id + "�[�[�[");
            System.out.println(questionText);
            System.out.println();

            /* �I�����̎擾�E�o�� */
            System.out.println("�[�[�[�I�����[�[�[");
            for(String selection : question.getSelections()){
                System.out.println(selection);
            }
            System.out.println();

            /* �q���g���K�v����\������ */
            System.out.println("�q���g�͕K�v�ł����H(1:�K�v 2:�s�K�v)");

            /* �q���g���K�v������͂��Ă��炤 */
            int inputAnswer = ScannerUtils.inputInt(2);
            System.out.println();

            /* �q���g���K�v���𔻒f */
            if(inputAnswer == 1){
                
                /* �q���g���擾���� */
                String hintText = question.getHintText();
                
                /* �q���g��\������ */
                System.out.println("�[�[�[�q���g�[�[�[");
                System.out.println(hintText);
                System.out.println();
            }

            /* �񓚂𑣂����b�Z�[�W */
            System.out.println("�I��������͂��Ă�������(1�`3)");
            
            /* �w�K�҂���񓚂��擾 */
            inputAnswer = ScannerUtils.inputInt(3);

            /* �����̎擾 */
            int correctAnswer = question.getCorrectAnswer();
            
            /* ���̐��딻�� & Educatee�ɐ�����L�^*/
            if(inputAnswer == correctAnswer){
                System.out.println("����");
                // Educatee�ɐ������L�^
                score.setStatus(AnswerStatus.Collect);
            } else{
                System.out.println("�s����");
                System.out.println("������" + correctAnswer + "�ł�");
                // Educatee�ɕs�������L�^
                score.setStatus(AnswerStatus.Uncollect);
            }

            /* ���̉�����擾 */
            String explanationText = question.getExplanationText();

            /* �����\�� */
            System.out.println();
            System.out.println("�[�[�[����[�[�[");
            System.out.println(explanationText);
            System.out.println();
            System.out.println();
            System.out.println();
        }
        /** Score��XML�t�@�C���ɋL�^���� */
        EducateeList educateeList = new EducateeList();
        educateeList.add(educatee);
        EducateeListUtils.save("EducateeList.xml", educateeList);
    }
}