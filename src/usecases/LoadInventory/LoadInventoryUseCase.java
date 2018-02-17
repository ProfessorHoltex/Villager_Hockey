package usecases.LoadInventory;

import java.util.UUID;

import gateways.InventoryGateway;

public class LoadInventoryUseCase implements LoadInventory {

	private UUID player;
	private InventoryGateway inventoryGateway;
	
	@Override
	public void execute(UUID player) {
		setPlayer(player);
		load();
	}
	
	private void load() {
		inventoryGateway.load(player);
	}
	
	private void setPlayer(UUID player) {
		this.player = player;
	}

	@Override
	public void setInventoryGateway(InventoryGateway inventoryGateway) {
		this.inventoryGateway = inventoryGateway;
	}

}
