package hello;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
//		Object str = "{}";
//		Map  strMap = (Map)str;
		
//		String json = "{\"name\":null,\"url\":\"projects/exhibition/5B22E59BADE58CBA222C22434E30313055494E4E564F4144454D4F494931303531222C227363656E652D313436393738393133373539342D44454D4F31225D/C72B2F29-37F0-0001-3E69-13A01D8CF800/\"}";
		
		JSONObject json = new JSONObject();
		json.put("test", "jjw");
		json.put("w2", "");
		String a = json.getString("w2");
		System.out.println(a==null);
	}
}
