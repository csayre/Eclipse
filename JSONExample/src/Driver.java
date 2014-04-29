import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * 
 */

/**
 * @author csayre
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=======decode=======");

		String s="[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		Object obj=JSONValue.parse(s);
		JSONArray array=(JSONArray)obj;
		System.out.println("======the 2nd element of array======");
		System.out.println(array.get(1));
		System.out.println();

		JSONObject obj2=(JSONObject)array.get(1);
		System.out.println("======field \"1\"==========");
		System.out.println(obj2.get("1"));    


		s="{}";
		obj=JSONValue.parse(s);
		System.out.println(obj);

		s="[5,]";
		obj=JSONValue.parse(s);
		System.out.println(obj);

		s="[5,,2]";
		obj=JSONValue.parse(s);
		System.out.println(obj);
	}

}