package helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class PgJasonParser {

	public String getPageObjects(String pageobject){
		JSONParser parser= new JSONParser();
		String objpath="";

	try{
		Path path= Paths.get("src/test/java/helpers/PageObjects.json");
		Path filepath= path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		Object obj= parser.parse(new FileReader(filepath.toString()));
		JSONObject jsonObject = (JSONObject)obj;
		objpath = (String) jsonObject.get(pageobject);		
	}
	catch(FileNotFoundException e){e.printStackTrace();}
	catch(IOException e){e.printStackTrace();}
	catch(ParseException e){e.printStackTrace();}
	catch(Exception e){e.printStackTrace();}
	return objpath;
	}
}
