/* JsonのUtilityユーティリティークラス */
import java.nio.charset.Charset;
import java.nio.file.Path;

public class JsonUtils{
    public static final Charset CHARSET = Charset.forName("UTF-8");

    /* ファイル内のすべての文字を取得する。(PathUtilsのreadAllメソッドを利用する) */
    public static String readAll(Path path){
        return PathUtils.readAll(path, CHARSET);
    }
    
    /* 指定したpathに指定した文字列を書き込む。(PathUtilsのwriteStringメソッドを利用する) */
	public static Path writeString(Path path, String all){
		return PathUtils.writeString(path, all, CHARSET);
	}
}

