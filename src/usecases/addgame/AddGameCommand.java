package usecases.addgame;

import java.util.List;
import java.util.UUID;

import context.Context;
import entities.command.AbstractCommand;
import usecases.addgame.AddGame.AddGameResponse;

public class AddGameCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		AddGame useCase = new AddGameUseCase();
		AddGameView view = new AddGameViewImpl(player);
		AddGameResponse presenter = new AddGamePresenter(view);
		useCase.setGameGateway(Context.gameGateway);
		useCase.setPermissionGateway(Context.permissionGateway);
		useCase.execute(player, arguments.get(0), presenter);
	}

	@Override
	public String getName() {
		return "addgame";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] { "name" };
	}

}
