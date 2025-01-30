/* ファイルを読み書きするユーティリティークラス */
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class PathUtils{
	public static final String CRLF = "\r\n";
    // 改行(\r\n)で要素に区切ったListを返却する。
	public static List<String> readAllLines(Path path, Charset charset){
		String all = readAll(path, charset);
		return Arrays.asList(all.split(CRLF));
	}
    // ファイルにあるすべてのバイナリーデータを読み込み、String型で返却する。(指定した文字コードで変換する)
	public static String readAll(Path path, Charset charset){
		try{
			return new String(Files.readAllBytes(path), charset);
		} catch(IOException e){
			e.printStackTrace();
		}
		return "";
	}
	public static Path writeString(Path path, String all, Charset charset){
		try{
			return Files.write(path, all.getBytes(charset));
		} catch(IOException e){
			e.printStackTrace();
		}
		return path;
	}
}