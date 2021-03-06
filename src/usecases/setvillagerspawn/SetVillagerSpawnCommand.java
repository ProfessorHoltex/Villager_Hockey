package usecases.setvillagerspawn;

import java.util.List;
import java.util.UUID;

import entities.command.AbstractCommand;
import usecases.setvillagerspawn.SetVillagerSpawn.SetVillagerSpawnResponse;

public class SetVillagerSpawnCommand extends AbstractCommand {

	@Override
	public void execute(UUID player, List<String> arguments) {
		SetVillagerSpawn useCase = new SetVillagerSpawnUseCase();
		SetVillagerSpawnView view = new SetVillagerSpawnViewImpl(player);
		SetVillagerSpawnResponse presenter = new SetVillagerSpawnPresenter(view);
		SetVillagerSpawnController controller = new SetVillagerSpawnController(useCase, presenter);
		controller.handleRequest(player, arguments);
	}

	@Override
	public String getName() {
		return "setspawner";
	}

	@Override
	public String[] getArgumentLabels() {
		return new String[] {"game"};
	}
	
}
