/* ���[�X�P�[�X�ƒP���̑I�����s���N���X */
public class ModeSelector{
    private final String[] USECASE_LIST = {
        "1.�������K����",
        "2.�P��������{������",
        "3.�X�R�A���{������",
        "4.�I������"
    };
    private final String[] UNIT_LIST = {
        "1.�W���o��/������A��",
        "2.�ϐ�",
        "3.���Z�q",
        "4.��������",
        "5.�s����/�s����",
        "6.�_�����Z�q",
        "7.for���䕶",
        "8.�z��",
        "9.����",
        "10.�W������"
    };
    /* ���[�X�P�[�X�ƒP���̑I�����s�� */
    public void selectMode(Educatee educatee){
        UsecaseList usecaseList = new UsecaseList();

        int selectedUsecaseNumber = this.selectUsecase(); /* ���[�X�P�[�X��I������ */
        System.out.println();

        /* ���[�X�P�[�X�ŏI����I�����ꂽ�ꍇ�Ƀv���O�������I������ */ 
        if(selectedUsecaseNumber == 4){
            EducateeSelector.isRun = false;
        } else{
            int selectedUnitNumber = this.selectUnit(); /* �P����I������ */
            System.out.println();

            /* �I�����ꂽ���[�X�P�[�X�̒P�����X�^�[�g���� */
            Usecase usecase = usecaseList.get(selectedUsecaseNumber - 1);
            usecase.start(educatee, selectedUnitNumber);
        }
    }

    /* ���[�X�P�[�X��I������ */
    public int selectUsecase(){
        /* ���[�X�P�[�X��\������ */
        System.out.println("�������܂����H(�ԍ��őI�����Ă�������)");
        this.printList(USECASE_LIST);
        
        /* ���[�X�P�[�X����͂��� */        
        return ScannerUtils.inputInt(USECASE_LIST.length);
    }

    /* �P����I������ */
    public int selectUnit(){
        /* �P����\������ */
        System.out.println("�P������͂��Ă�������(�ԍ��őI�����Ă�������)");
        this.printList(UNIT_LIST);

        /* �P������͂��� */
        return ScannerUtils.inputInt(UNIT_LIST.length);
    }

    /* �ꗗ��\������ */
    public void printList(String[] words){
        for(String s : words){
            System.out.println(s);
        }
    }
}