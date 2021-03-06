package usecases.addteam;

import java.util.List;

public interface AddTeamView {

	void displayNoPermission();
	
	void displayNoSuchGame(String name);
	
	void displayTeamWithNameAlreadyExists(String name);
	
	void displayTeamWithColorAlreadyExists(String color);
	
	void displayInvalidTeamName(String name);
	
	void displayTeamSuccessfullyAdded(String game, String team);
	
	void displayTeamColorIsNotValid(String color, List<String> possibleValues);
	
	void displayMaximumAmountOfTeamsAlreadyReached(String maximum);
	
}
