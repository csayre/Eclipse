import java.net.*;
import java.util.Scanner;
import java.io.*;
import net.sf.json.*;
import org.apache.commons.lang.exception.*;

public class Driver {

	public static void main(String[] args) throws Exception {

		FileInputStream file = new FileInputStream("res/Airports.txt");
		Scanner scan = new Scanner(file);
		OutputStreamWriter osw = null;
		try {
		     File statText = new File("res/output.txt");
		        FileOutputStream is = new FileOutputStream(statText);
		        osw = new OutputStreamWriter(is); 
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
					osw.write("Weather data for " + weatherData.get("stationName")+"\n");
					osw.write("Temperature is " + weatherData.get("temperature") + " degrees (Celsius) with " + weatherData.get("clouds")+"\n");
					osw.write("\n");
				}
			}	
			scan.close();
		}
		catch(IOException e)
		{

		}
		finally
		{

			try {osw.close();} catch (Exception ex) {}
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