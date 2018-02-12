package usecases.ListGames;

import java.util.List;
import java.util.UUID;

import spigot.AbstractCommand;
import usecases.ListGames.ListGames.ListGamesResponse;

public class ListGamesCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		ListGames useCase = new ListGamesUseCase();
		ListGamesView view = new ListGamesViewImpl(player);
		ListGamesResponse presenter = new ListGamesPresenter(view);
		useCase.execute(player, presenter);
	}

	@Override
	public String getName() {
		return "list";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {};
	}
	
}