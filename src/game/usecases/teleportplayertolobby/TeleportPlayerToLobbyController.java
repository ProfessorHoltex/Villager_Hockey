package game.usecases.teleportplayertolobby;

import java.util.UUID;

import context.Context;

public class TeleportPlayerToLobbyController {

	public void onTeleportPlayerToLobby(UUID player) {
		TeleportPlayerToLobby useCase = new TeleportPlayerToLobbyUseCase();
		useCase.setGameGateway(Context.gameGateway);
		useCase.execute(player);
	}

}
