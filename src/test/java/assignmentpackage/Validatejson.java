package assignmentpackage;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Validatejson {
	
	


	int countPlayers;
	int countForeignPlayers;
	static String path = ".//jsonfiles/teamRCB.json";
	static final int expectedCount = 4;
	int WicketKeeperCount;
	static final int WicketKeeperCountExpected=1;
	int length;
	static JSONParser jsonparser = new JSONParser();
	static FileReader reader ;
	
	
	//to read data employees data from json
	public String[] readJson() throws IOException, ParseException
	{
		reader =new FileReader(path);
		
		Object obj = jsonparser.parse(reader);
		JSONObject teamdetails = (JSONObject) obj;
		JSONArray players =(JSONArray) teamdetails.get("player");
		System.out.println(players.size());
		
		String arr[] = new String[players.size()];
		for(int i=0;i<players.size();i++)
		{
			JSONObject playerDetails = (JSONObject) players.get(i);
			String playerCountry = (String)playerDetails.get("country");
			arr[i] = playerCountry;
		}
		return arr;
	}
	
	//to read players role from json
	public String[] readJsonRole() throws IOException, ParseException
	{
		
		reader =new FileReader(path);
		
		Object obj = jsonparser.parse(reader);
		JSONObject teamdetails = (JSONObject) obj;
		JSONArray players =(JSONArray) teamdetails.get("player");
		System.out.println(players.size());
		
		String arrRole[] = new String[players.size()];
		for(int i=0;i<players.size();i++)
		{
			JSONObject playerDetails = (JSONObject) players.get(i);
			String playerrole = (String)playerDetails.get("role");
			arrRole[i] = playerrole;
		}
		return arrRole;
	}
	
	//to validate players role
	public void validatePlayersRole(String data[])
	{
	  length = data.length;
	  for(int i=0;i<length;i++)
	  {
		  System.out.println(data[i]);
		  if(data[i].equals("Wicket-keeper"))
			{
			  WicketKeeperCount++;
			}
				  }
				System.out.println(WicketKeeperCount);
				if(WicketKeeperCount>=1)
				{
				 System.out.println("There is atleast one wicket-keeper in team");
		
				}
				else
				{
					System.out.println("There is no Wicket keeper in team");
				}
				}
	
	//to validate number of foreign players
	public void validateForeignPlayers(String data[])
	{
	  length = data.length;
	  for(int i=0;i<length;i++)
	  {
		  System.out.println(data[i]);
		  if(data[i].equals("India"))
			{
				countPlayers++;
			}
			else
			{
				countForeignPlayers++;
			}
 
	  }
				System.out.println(countPlayers);
		System.out.println(countForeignPlayers);
		 
		Assert.assertEquals(countForeignPlayers,expectedCount,"There are more than 4 foreign players in team");
	}

	

} 

