/**
 * 
 */

/**
 * @author csayre
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class View {

	//steam api 5D0615D35FB669702643632129E0CEC9
	// steam id 76561198008615109

	/*
	 * 	String JSonString = readURL("http://api.geonames.org/weatherIcaoJSON?ICAO="+name+"&formatted=true&username=csayre");
	 *	JSONObject x = JSONObject.fromObject(JSonString);
	 *	JSONObject weatherData =(JSONObject)(x.get("weatherObservation")); 
	 * 
	 */

	public View() throws Exception
	{
		try
		{
			getUserData("76561198008615109");
			getFriendsList("76561198008615109");
			
			
						

		}
		catch(IOException e)
		{

		}
	}
	
	private void getUserData(String userID) throws Exception
	{
		String JsonString = readURL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=5D0615D35FB669702643632129E0CEC9&steamids="+ userID);
		JSONObject x = JSONObject.fromObject(JsonString);
		System.out.println(x);
		JSONObject response = (JSONObject) x.get("response");
		JSONArray players = (JSONArray) response.get("players");
		JSONObject player = (JSONObject) players.get(0);
		String steamid = (String) player.get("steamid");
		System.out.println("Steamid: " + steamid);
		String name = (String) player.get("personaname");
		System.out.println("Player Name: " + name);
		int personaState = (Integer) player.get("personastate");
		System.out.println(personaState);
		state(personaState);
	}
	
	private void getFriendsList(String userID) throws Exception
	{
		String[] id = new String[30];
		String JsonStringFriends = readURL("http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=5D0615D35FB669702643632129E0CEC9&steamid="+ userID + "&relationship=friend");
		System.out.println(JsonStringFriends);
		JSONObject a = JSONObject.fromObject(JsonStringFriends);
		JSONObject response = (JSONObject) a.get("friendslist");
		JSONArray friend = (JSONArray) response.get("friends");
		System.out.println(friend.size());
		for(int i = 0; i < friend.size(); i++)
		{
			JSONObject player = (JSONObject) friend.get(i);
			String steamid = (String) player.get("steamid");
			String relationship = (String) player.get("relationship");
			int friendSince = (Integer) player.get("friend_since");
			System.out.println(steamid);
		}
	}
	
	private void state(int input)
	{
		if(input == 0)
		{
			System.out.println("User is offline");
		}
		else if (input == 1)
		{
			System.out.println("User is online");
		}
		else if(input == 2)
		{
			System.out.println("User is busy");
		}
		else if(input == 3)
		{
			System.out.println("User is away");
		}
		else if(input == 4)
		{
			System.out.println("User is Snoozing");
		}
		else if (input == 5)
		{
			System.out.println("User is looking to trade");
		}
		else if(input == 6)
		{
			System.out.println("User is looking to play");
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
