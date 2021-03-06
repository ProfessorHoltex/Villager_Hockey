package usecases.addteam;

import java.util.ArrayList;
import java.util.List;

import entities.Team;
import entities.TeamColor;
import entities.Teams;
import game.Game;
import gateways.GameGateway;
import gateways.PermissionGateway;
import gateways.Permissions;

public class AddTeamUseCase implements AddTeam {

	private static final int MAXIMUM_AMOUNT_OF_TEAMS = 2;
	
	private Game game;
	private Teams teams;
	private AddTeamRequest request;
	private GameGateway gameGateway;
	private PermissionGateway permissionGateway;

	@Override
	public void execute(AddTeamRequest request, AddTeamResponse response) {
		setRequest(request);

		if (noPermission()) {
			response.onNoPermission();
			return;
		}
		
		if (noSuchGame()) {
			response.onNoSuchGame(request.getGame());
			return;
		}
		
		initializeGame();
		initializeTeams();
		
		if (teamNameIsInvalid()) {
			response.onInvalidTeamName(request.getName() == null ? "null" : request.getName());
			return;
		}

		if (teamWithNameExists()) {
			response.onTeamWithNameAlreadyExists(request.getName());
			return;
		}
		
		if (parseTeamColor() == null) {
			response.onTeamColorIsNotValid(request.getColor(), getPossibleTeamColorValues());
			return;
		}
		
		if (teamWithColorExists()) {
			response.onTeamWithColorAlreadyExists(request.getColor());
			return;
		}
		
		if (maximumAmountReached()) {
			response.onMaximumAmountOfTeamsAlreadyReached(MAXIMUM_AMOUNT_OF_TEAMS);
			return;
		}
		
		addTeamToGame();
		response.onTeamSuccessfullyAdded(request.getGame(), request.getName());
	}
	
	private void initializeGame() {
		game = gameGateway.findGameByName(request.getGame());
	}
	
	private void initializeTeams() {
		teams = game.getTeams();
	}
	
	private boolean maximumAmountReached() {
		return game.getTeams().getNumberOfTeams() == MAXIMUM_AMOUNT_OF_TEAMS;
	}
	
	private List<String> getPossibleTeamColorValues() {
		List<String> values = new ArrayList<String>();
		for (TeamColor color : TeamColor.values()) {
			values.add(color + "");
		}
		return values;
	}
	
	private void addTeamToGame() {
		teams.add(new Team(request.getName(), parseTeamColor()));
	}
	
	private TeamColor parseTeamColor() {
		try {
			return TeamColor.valueOf(request.getColor());
		} catch (Exception e) {
			return null;
		}
	}
	
	private boolean teamNameIsInvalid() {
		return request.getName() == null || request.getName().trim().isEmpty();
	}

	private boolean teamWithNameExists() {
		return teams.containsTeamWithName(request.getName());
	}
	
	private boolean teamWithColorExists() {
		return teams.containsTeamWithColor(parseTeamColor());
	}

	private boolean noSuchGame() {
		return !gameGateway.containsGame(request.getGame());
	}

	private boolean noPermission() {
		return !permissionGateway.hasPermission(request.getPlayer(), Permissions.ADD_TEAM);
	}

	private void setRequest(AddTeamRequest request) {
		this.request = request;
	}

	@Override
	public void setGameGateway(GameGateway gameGateway) {
		this.gameGateway = gameGateway;
	}

	@Override
	public void setPermissionGateway(PermissionGateway permissionGateway) {
		this.permissionGateway = permissionGateway;
	}
	
}
