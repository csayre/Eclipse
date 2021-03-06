
import java.net.*;
import java.util.Scanner;
import java.io.*;
import net.sf.json.*;
import org.apache.commons.lang.exception.*;

public class driver {

	public static void main(String[] args) throws Exception {

			String JSonString = readURL("http://api.geonames.org/weatherIcaoJSON?ICAO=KROA&formatted=true&username=csayre");
			JSONObject x = JSONObject.fromObject(JSonString);
			JSONObject weatherData =(JSONObject)(x.get("weatherObservation")); 
			System.out.println("Weather data for " + weatherData.get("stationName"));
			System.out.println("Temperature is " + weatherData.get("temperature") + " degrees (Celsius) with " + weatherData.get("clouds"));
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


