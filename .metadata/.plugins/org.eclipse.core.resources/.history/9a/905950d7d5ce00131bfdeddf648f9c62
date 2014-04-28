
/**
 * @author csayre
 * @version 4/24/2014
 * @file View.java - runs the program
 *
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * imports json libraries 
 */


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



public class View {

	//steam api 5D0615D35FB669702643632129E0CEC9
	
	/**
	 * Steam API information 
	 * 
	 * http://steamcommunity.com/dev
	 * 
	 * Explanation of Steam API - https://developer.valvesoftware.com/wiki/Steam_Web_API#GetGlobalAchievementPercentagesForApp_.28v0001.29
	 * 
	 * Explains the URL address to query, parameters, and what is returned. 
	 */



	/**
	 * Constructor for View. This is what runs the program.
	 * @throws Exception
	 */

	public View() throws Exception
	{
		FileInputStream file = new FileInputStream("res/steamid.txt");
		Scanner scan = new Scanner(file);
		try
		{
			while(scan.hasNext())
			{
				String steamid = scan.nextLine();
				getUserData(steamid);
				System.out.println();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Queries the Steam API and returns information about the user. 
	 * Writes steamid, username, the state of the user, and the number of games that the user owns to the console. 
	 * If the users friends list is not shared the following message is displayed, "Users privacy settings does not allow sharing of this information."
	 * If the users game list is not shared the following message is displayed, "Users privacy settings does not allow sharing of this information."
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
		System.out.println("Steamid: " + steamid);
		String name = (String) player.get("personaname");
		System.out.println("Player Name: " + name);
		int personaState = (Integer) player.get("personastate");
		state(personaState);
		int numGames = this.getNumberGames(steamid);
		if(numGames == 0)
		{
			System.out.println("Users privacy settings does not allow sharing of this information.");
		}
		else
		{
			System.out.println("Number of games: " + numGames);	
		}
		int friends = getFriendsList(steamid);
		if(friends == 0)
		{
			System.out.println("Users privacy settings does not allow sharing of this information.");
		}
		else
		{
			System.out.println("Number of Friends: " + friends);	
		}
	}
	
	/**
	 * Helper method using another steam API, this api access the users friends list. 
	 * @param userID
	 * @return the number of friends a person has
	 * @throws Exception
	 */

	private int getFriendsList(String userID)
	{
		int numOfFri = 0;
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
				numOfFri++;
			}
		}
		catch(Exception e)
		{
			return 0;
		}
		return numOfFri;
	}

	/**
	 * helper method using a 3rd steam API, this API accesses the users game list
	 * @param steamid
	 * @return returns the number of games that a user owns
	 * @throws Exception
	 */
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
	
	/**
	 * Helper method to determine the user state. 
	 * @param input
	 * @throws IOException
	 */

	private void state(int input) throws IOException
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

/**
 * Code given By Joe Chase to parse the URL data. 
 * @param webservice
 * @return
 * @throws Exception
 */
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
