import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


/**
 * 
 */

/**
 * @author ChrisSayre
 *
 */


public class View {

	//steam api 5D0615D35FB669702643632129E0CEC9
	
	/*
	 * String JSonString = readURL("http://api.geonames.org/weatherIcaoJSON?ICAO="+name+"&formatted=true&username=csayre");
				JSONObject x = JSONObject.fromObject(JSonString);
				JSONObject weatherData =(JSONObject)(x.get("weatherObservation")); 
	 * 
	 */
	

	
	public View() throws Exception
	{
		try
		{

			String JsonString = readURL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=5D0615D35FB669702643632129E0CEC9&steamids=76561198008615109");
			Object obj=JSONValue.parse(JsonString);
			System.out.println(obj);
			JSONArray array =(JSONArray) obj;
			JSONObject test = new JSONObject();
			System.out.println(array.get(1));
			

		}
		catch(IOException e)
		{

		}
	}


	public static String readURL(String webservice) throws Exception {
		URL oracle = new URL(webservice);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						oracle.openStream()));

		String inputLine;
		String result = "";

		while ((inputLine = in.readLine()) != null)
			result = result + inputLine;

		in.close();
		return result;
	}
}
