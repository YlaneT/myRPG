package Util;

import org.json.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UtilJson {
	public static JSONObject readJson (String filename) {
		JSONObject o = null;
		try {
			String      contents = new String(Files.readAllBytes(Paths.get(filename)));
			JSONTokener tokener  = new JSONTokener(contents);
			o = new JSONObject(tokener);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static JSONArray readJsonArray (String filename) {
		JSONArray a = null;
		try {
			String      contents = new String(Files.readAllBytes(Paths.get(filename)));
			JSONTokener tokener  = new JSONTokener(contents);
			a = new JSONArray(tokener);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}
}
