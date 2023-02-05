package assignmentpackage;

import java.io.IOException;


import org.json.simple.parser.ParseException;

public class ValidateForeignPlayers extends Validatejson {

	String names[];
	String role[];
		
	public static void main(String[] args) throws IOException, ParseException {
				ValidateForeignPlayers vj = new ValidateForeignPlayers();
          vj.names = vj.readJson();
          vj.validateForeignPlayers(vj.names);
          vj.role = vj.readJsonRole();
          vj.validatePlayersRole(vj.role);
          
          
          
	}

}
