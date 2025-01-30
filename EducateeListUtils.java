import java.io.File;
import javax.xml.bind.JAXB;

public class EducateeListUtils{
	public static void save(String filename, EducateeList educateeList){
		File file = new File(filename);
		JAXB.marshal(educateeList, file);
	}
	public static EducateeList load(String filename){
		File file = new File(filename);
		if(file.exists()){
			return JAXB.unmarshal(file, EducateeList.class);
		}
		return null;
	}
}