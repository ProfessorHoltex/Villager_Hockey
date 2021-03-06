package usecases.teleportplayerstoteamspawns;

import context.Context;
import usecases.teleportplayerstoteamspawns.TeleportPlayersToTeamSpawns.TeleportPlayersToTeamSpawnsResponse;

public class TeleportPlayersToTeamSpawnsController {

	public void onTeleportPlayersToTeamSpawns(String game) {
		TeleportPlayersToTeamSpawnsView view = new TeleportPlayersToTeamSpawnsViewImpl();
		TeleportPlayersToTeamSpawnsResponse presenter = new TeleportPlayersToTeamSpawnsPresenter(view);
		TeleportPlayersToTeamSpawns useCase = new TeleportPlayersToTeamSpawnsUseCase();
		useCase.setGameGateway(Context.gameGateway);
		useCase.execute(game, presenter);
	}
	
}
