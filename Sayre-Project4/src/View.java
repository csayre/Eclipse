import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sf.json.JSONObject;

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

			String JSonString = readURL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=5D0615D35FB669702643632129E0CEC9&steamids=76561198008615109");
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject id =(JSONObject)(x.get("steamid"));
			System.out.println(x);
			System.out.println(id);
			System.out.println(id.toString());
//			System.out.println(x.size());
//			System.out.println(x.toString());
//			System.out.println(x);
//			System.out.println(id);
//			if(x.get("weatherObservation") == null)
//			{
//				System.out.println("No data found");
//			}			
//			else
//			{						
//				System.out.println("Weather data for " + weatherData.get("stationName")+"\n");
//				System.out.println("Temperature is " + weatherData.get("temperature") + " degrees (Celsius) with " + weatherData.get("clouds")+"\n");
//				System.out.println("\n");		
//			}
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
