package main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import usecases.chatingame.ChatEventListener;
import usecases.performaction.breakblock.BreakBlockEventListener;
import usecases.performaction.breakjoinsign.BreakJoinSignEventListener;
import usecases.performaction.changefoodlevel.ChangeFoodLevelEventListener;
import usecases.performaction.clickinventory.ClickInventoryEventListener;
import usecases.performaction.clickjoinsign.ClickJoinSignEventListener;
import usecases.performaction.consumeitem.ConsumeItemEventListener;
import usecases.performaction.damageitem.DamageItemEventListener;
import usecases.performaction.dropitem.DropItemEventListener;
import usecases.performaction.move.MoveEventListener;
import usecases.performaction.openinventory.OpenInventoryEventListener;
import usecases.performaction.pickupitem.PickupItemEventListener;
import usecases.performaction.placejoinsign.PlaceJoinSignEventListener;
import usecases.performaction.quit.QuitEventListener;
import usecases.performaction.receivedamage.ReceiveDamageEventListener;
import usecases.performaction.shootpuck.ShootPuckEventListener;
import usecases.performaction.swaphanditems.SwapHandItemsEventListener;
import usecases.prepareplayerforlobby.LobbyMenuListener;
import usecases.selectteam.ShowTeamsEventListener;

public class ListenerRegistration {

	private JavaPlugin plugin;

	public void registerListeners(JavaPlugin plugin) {
		this.plugin = plugin;
		createAndRegisterEventListeners();
	}

	private void createAndRegisterEventListeners() {
		registerEventListener(new BreakBlockEventListener());
		registerEventListener(new ChangeFoodLevelEventListener());
		registerEventListener(new ConsumeItemEventListener());
		registerEventListener(new DamageItemEventListener());
		registerEventListener(new DropItemEventListener());
		registerEventListener(new MoveEventListener());
		registerEventListener(new PickupItemEventListener());
		registerEventListener(new QuitEventListener());
		registerEventListener(new OpenInventoryEventListener());
		registerEventListener(new ClickInventoryEventListener());
		registerEventListener(new ClickJoinSignEventListener());
		registerEventListener(new PlaceJoinSignEventListener());
		registerEventListener(new BreakJoinSignEventListener());
		registerEventListener(new ShowTeamsEventListener());
		registerEventListener(new ShootPuckEventListener());
		registerEventListener(new ReceiveDamageEventListener());
		registerEventListener(new LobbyMenuListener());
		registerEventListener(new ChatEventListener());
		registerEventListener(new SwapHandItemsEventListener());
	}

	private void registerEventListener(Listener listener) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	}

}
