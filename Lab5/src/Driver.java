import java.net.*;
import java.util.Scanner;
import java.io.*;
import net.sf.json.*;
import org.apache.commons.lang.exception.*;

public class Driver {

	public static void main(String[] args) throws Exception {

		FileInputStream file = new FileInputStream("res/Airports.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNext())
		{
			String name = scan.next();
			String JSonString = readURL("http://api.geonames.org/weatherIcaoJSON?ICAO="+name+"&formatted=true&username=csayre");
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject weatherData =(JSONObject)(x.get("weatherObservation")); 
			if(x.get("weatherObservation") == null)
			{
				System.out.println("No data found");
			}
			else
			{
				System.out.println("Weather data for " + weatherData.get("stationName"));
				System.out.println("Temperature is " + weatherData.get("temperature") + " degrees (Celsius) with " + weatherData.get("clouds"));	
			}
			System.out.println();
		}	
		scan.close();
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


