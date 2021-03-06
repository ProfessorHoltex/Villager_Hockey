package usecases.savegame;

import java.util.List;
import java.util.UUID;

import context.Context;
import entities.command.AbstractCommand;
import usecases.savegame.SaveGame.SaveGameResponse;

public class SaveGameCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		SaveGame useCase = new SaveGameUseCase();
		SaveGameView view = new SaveGameViewImpl(player);
		SaveGameResponse presenter = new SaveGamePresenter(view);
		useCase.setGameGateway(Context.gameGateway);
		useCase.setPermissionGateway(Context.permissionGateway);
		useCase.execute(player, arguments.get(0), presenter);
	}

	@Override
	public String getName() {
		return "save";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {"game"};
	}
	
}
