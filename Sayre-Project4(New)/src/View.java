
/**
 * @author csayre
 * @version 4/24/2014
 * @file View.java - runs the program
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;

/**
 * imports json libraries 
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class View {

	//steam api 5D0615D35FB669702643632129E0CEC9

	private FileInputStream file = new FileInputStream("res/steamid.txt");
	private Scanner scan = new Scanner(file);
	private OutputStreamWriter osw = null;
	
	/**
	 * Constructor for View. This is what runs the program.
	 * @throws Exception
	 */

	public View() throws Exception
	{
		File statText = new File("res/output.txt");
		FileOutputStream writer = new FileOutputStream(statText);
		osw = new OutputStreamWriter(writer); 
		try
		{
			while(scan.hasNext())
			{
				String steamid = scan.nextLine();
				getUserData(steamid);
				osw.write("");
				getFriendsList(steamid);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Queries the Steam API and returns information about the user. 
	 * Writes steamid, username, the state of the user, and the number of games that the user owns to a file. 
	 * @param userID
	 * @throws Exception
	 */

	private void getUserData(String userID) throws Exception
	{
		String JsonString = readURL("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=5D0615D35FB669702643632129E0CEC9&steamids="+ userID);
		JSONObject x = JSONObject.fromObject(JsonString);
		JSONObject response = (JSONObject) x.get("response");
		JSONArray players = (JSONArray) response.get("players");
		JSONObject player = (JSONObject) players.get(0);
		String steamid = (String) player.get("steamid");
		osw.write("Steamid: " + steamid);
		String name = (String) player.get("personaname");
		osw.write("Player Name: " + name);
		int personaState = (Integer) player.get("personastate");
		state(personaState);
		int numGames = this.getNumberGames(steamid);
		osw.write("Number of games: " + numGames);
	}

	private void getFriendsList(String userID) throws Exception
	{

		try
		{
			String JsonStringFriends = readURL("http://api.steampowered.com/ISteamUser/GetFriendList/v0001/?key=5D0615D35FB669702643632129E0CEC9&steamid="+ userID + "&relationship=friend");
			JSONObject a = JSONObject.fromObject(JsonStringFriends);
			JSONObject response = (JSONObject) a.get("friendslist");
			JSONArray friend = (JSONArray) response.get("friends");
			for(int i = 0; i < friend.size(); i++)
			{
				JSONObject player = (JSONObject) friend.get(i);
				String steamid = (String) player.get("steamid");
				String relationship = (String) player.get("relationship");
				int friendSince = (Integer) player.get("friend_since");
			}
		}
		catch(Exception e)
		{
			osw.write("User has no friends.");
		}
	}

	private int getNumberGames(String steamid) throws Exception
	{
		String JsonString = readURL("http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=5D0615D35FB669702643632129E0CEC9&steamid="+steamid+"&format=json");
		JSONObject a = JSONObject.fromObject(JsonString);
		JSONObject response = (JSONObject) a.get("response");
		try
		{
			int numGames = (Integer) response.get("game_count");
			return numGames;
		}
		catch(Exception e)
		{
			return 0;
		}


	}

	private void state(int input) throws IOException
	{
		if(input == 0)
		{
			osw.write("User is offline");
		}
		else if (input == 1)
		{
			osw.write("User is online");
		}
		else if(input == 2)
		{
			osw.write("User is busy");
		}
		else if(input == 3)
		{
			osw.write("User is away");
		}
		else if(input == 4)
		{
			osw.write("User is Snoozing");
		}
		else if (input == 5)
		{
			osw.write("User is looking to trade");
		}
		else if(input == 6)
		{
			osw.write("User is looking to play");
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
