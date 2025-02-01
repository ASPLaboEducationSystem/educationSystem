/* Json��Utility���[�e�B���e�B�[�N���X */
import java.nio.charset.Charset;
import java.nio.file.Path;

public class JsonUtils{
    public static final Charset CHARSET = Charset.forName("UTF-8");

    /* �t�@�C�����̂��ׂĂ̕������擾����B(PathUtils��readAll���\�b�h�𗘗p����) */
    public static String readAll(Path path){
        return PathUtils.readAll(path, CHARSET);
    }
    
    /* �w�肵��path�Ɏw�肵����������������ށB(PathUtils��writeString���\�b�h�𗘗p����) */
	public static Path writeString(Path path, String all){
		return PathUtils.writeString(path, all, CHARSET);
	}
}

