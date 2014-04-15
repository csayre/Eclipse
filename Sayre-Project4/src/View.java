import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

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

//google api key: AIzaSyCswB_VbZLtqmzcMMu-_uCiWXgobq-KhzY
	public View() throws Exception
	{
		try
		{
			String JSonString = readURL("https://maps.googleapis.com/maps/api/js?key=AIzaSyCswB_VbZLtqmzcMMu-_uCiWXgobq-KhzY&sensor=TRUE");
			JSONObject x = JSONObject.fromObject(JSonString);
			System.out.println(x);
			
//			JSONObject weatherData =(JSONObject)(x.get("weatherObservation")); 
//			if(x.get("weatherObservation") == null)
//			{
//				System.out.println("No data found");
//			}
//			else
//			{		
//				System.out.println("Weather data for " + weatherData.get("stationName")+"\n");
//				System.out.println("Temperature is " + weatherData.get("temperature") + " degrees (Celsius) with " + weatherData.get("clouds")+"\n");
//				System.out.println("\n");
//		}
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
