package usecases.ShowHelp;

import java.util.List;
import java.util.UUID;

import command.AbstractCommand;
import context.Context;
import usecases.ShowHelp.ShowHelp.ShowHelpResponse;

public class ShowHelpCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		ShowHelp useCase = new ShowHelpUseCase();
		ShowHelpView view = new ShowHelpViewImpl(player);
		ShowHelpResponse presenter = new ShowHelpPresenter(view);
		useCase.setCommandGateway(Context.commandGateway);
		useCase.setPermissionGateway(Context.permissionGateway);
		useCase.execute(player, presenter);
	}

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {};
	}

}
