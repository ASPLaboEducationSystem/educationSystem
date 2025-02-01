/* ユースケースと単元の選択を行うクラス */
public class ModeSelector{
    private final String[] USECASE_LIST = {
        "1.問題を演習する",
        "2.単元解説を閲覧する",
        "3.スコアを閲覧する",
        "4.終了する"
    };
    private final String[] UNIT_LIST = {
        "1.標準出力/文字列連結",
        "2.変数",
        "3.演算子",
        "4.条件分岐",
        "5.不等号/不等価",
        "6.論理演算子",
        "7.for制御文",
        "8.配列",
        "9.乱数",
        "10.標準入力"
    };
    /* ユースケースと単元の選択を行う */
    public void selectMode(Educatee educatee){
        UsecaseList usecaseList = new UsecaseList();

        int selectedUsecaseNumber = this.selectUsecase(); /* ユースケースを選択する */
        System.out.println();

        /* ユースケースで終了を選択された場合にプログラムを終了する */ 
        if(selectedUsecaseNumber == 4){
            EducateeSelector.isRun = false;
        } else{
            int selectedUnitNumber = this.selectUnit(); /* 単元を選択する */
            System.out.println();

            /* 選択されたユースケースの単元をスタートする */
            Usecase usecase = usecaseList.get(selectedUsecaseNumber - 1);
            usecase.start(educatee, selectedUnitNumber);
        }
    }

    /* ユースケースを選択する */
    public int selectUsecase(){
        /* ユースケースを表示する */
        System.out.println("何をしますか？(番号で選択してください)");
        this.printList(USECASE_LIST);
        
        /* ユースケースを入力する */        
        return ScannerUtils.inputInt(USECASE_LIST.length);
    }

    /* 単元を選択する */
    public int selectUnit(){
        /* 単元を表示する */
        System.out.println("単元を入力してください(番号で選択してください)");
        this.printList(UNIT_LIST);

        /* 単元を入力する */
        return ScannerUtils.inputInt(UNIT_LIST.length);
    }

    /* 一覧を表示する */
    public void printList(String[] words){
        for(String s : words){
            System.out.println(s);
        }
    }
}