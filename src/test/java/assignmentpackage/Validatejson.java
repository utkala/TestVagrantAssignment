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
	int expectedCount = 4;
	int WicketKeeperCount;
	int WicketKeeperCountExpected=1;
	int length;
	
	//@DataProvider(name="validatePlayers")
	public String[] readJson() throws IOException, ParseException
	{
		JSONParser jsonparser = new JSONParser();
		FileReader reader =new FileReader(".//jsonfiles/teamRCB.json");
		
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
	
	public String[] readJsonRole() throws IOException, ParseException
	{
		JSONParser jsonparser = new JSONParser();
		FileReader reader =new FileReader(".//jsonfiles/teamRCB.json");
		
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
	
	//@Test(dataProvider="validatePlayers")
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
				 
		Assert.assertEquals(WicketKeeperCount,WicketKeeperCountExpected);
	}
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
		 
		Assert.assertEquals(countForeignPlayers,expectedCount);
	}

	

} 

