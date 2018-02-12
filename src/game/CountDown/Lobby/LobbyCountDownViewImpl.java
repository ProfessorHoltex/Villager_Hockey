package game.CountDown.Lobby;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import context.Context;
import view.MessageView;
import view.TitleBarView;
import view.impl.TitleBarViewImpl;

public class LobbyCountDownViewImpl implements LobbyCountDownView {

	private TitleBarView titleBarView;
	
	public LobbyCountDownViewImpl() {
		titleBarView = new TitleBarViewImpl();
	}
	
	private void displayMessage(UUID viewer, String message) {
		MessageView messageView = Context.messageView;
		messageView.displayMessage(viewer, message);
	}
	
	@Override
	public void displayGameStartsInGivenSeconds(List<UUID> viewers, int timeToWaitInSeconds) {
		String message = LobbyCountDownViewMessages.LOBBY_COUNT_DOWN_TIME_TO_WAIT;
		message = message.replace("$seconds$", timeToWaitInSeconds + "");
		for (UUID viewer : viewers) {
			displayMessage(viewer, message);
		}
	}

	@Override
	public void displayGameStarts(List<UUID> viewers) {
		for (UUID viewer : viewers) {
			displayMessage(viewer, LobbyCountDownViewMessages.LOBBY_COUNT_DOWN_GAME_STARTS);
		}
	}

	@Override
	public void displayCountDownTimeInSeconds(List<UUID> viewers, int seconds) {
		for (UUID viewer : viewers) {
			Player player = Bukkit.getPlayer(viewer);
			player.setLevel(seconds);
		}
	}

	@Override
	public void displayMapTitle(List<UUID> viewers, String title, String subtitle, int time) {
		for (UUID viewer : viewers) {
			titleBarView.displayTitle(viewer, title, subtitle, time);
		}
	}

}