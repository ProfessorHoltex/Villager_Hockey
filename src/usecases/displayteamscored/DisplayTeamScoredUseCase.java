package usecases.displayteamscored;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Team;
import game.Game;
import gateways.GameGateway;

public class DisplayTeamScoredUseCase implements DisplayTeamScored {

	private Game game;
	private GameGateway gameGateway;
	private DisplayTeamScoredRequest request;
	private DisplayTeamScoredResponse response;
	
	@Override
	public void execute(DisplayTeamScoredRequest request, DisplayTeamScoredResponse response) {
		setRequest(request);
		setResponse(response);
		initializeGame();
		sendResponse();
	}
	
	private void sendResponse() {
		List<UUID> viewers = game.getUniquePlayerIds();
		response.presentTeamScored(viewers, request.getTeam());
		response.presentScore(viewers, createResponseItems());		
	}
	
	private List<ScoreResponseItem> createResponseItems() {
		List<ScoreResponseItem> responseItems = new ArrayList<ScoreResponseItem>();
		for (Team team : findAllTeamsOfGame()) {
			ScoreResponseItem responseItem = new ScoreResponseItem();
			responseItem.setTeam(team.getName());
			responseItem.setScore(team.getScore());
			responseItems.add(responseItem);
		}
		return responseItems;
	}
	
	private List<Team> findAllTeamsOfGame() {
		return game.getTeams().findAllTeams();
	}
	
	private void initializeGame() {
		game = gameGateway.findGameByName(request.getGame());
	}
	
	private void setRequest(DisplayTeamScoredRequest request) {
		this.request = request;
	}
	
	private void setResponse(DisplayTeamScoredResponse response) {
		this.response = response;
	}

	@Override
	public void setGameGateway(GameGateway gameGateway) {
		this.gameGateway = gameGateway;
	}

}
