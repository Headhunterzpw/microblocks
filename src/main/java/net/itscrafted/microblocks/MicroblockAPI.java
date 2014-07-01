package net.itscrafted.microblocks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MicroblockAPI {

	private MicroblockCommand cmd = new MicroblockCommand(new Microblocks());
	
	/**
	 * Add a head to the list of available <b>Microblocks</b>.
	 * <br>
	 * @param blockName - <em>The display name of the block.</em>
	 * @param playerName - <em>The player associated with the block.</em>
	 * @param safe - <em>Will this head change in the foreseeable future?</em>
	 */
	public void addHead(String blockName, String playerName, boolean safe) {
		MicroblockType.addExternal(blockName, playerName, safe);
		Bukkit.getLogger().info("Added Microblock '" + blockName + "' succesfully.");
	}
	
	/**
	 * Give a <b>Microblock</b> to a specific player, if the Microblock exists.
	 * <em>This is a very hacky method, and I recommend just calling /givemb from your plugin.</em>
	 * <br>
	 * @param player - <em>The player to recieve the block.</em>
	 * @param mbName - <em>The name of the Microblock to be given.</em>
	 */
	public void giveHead(Player player, String mbName) {
		if(MicroblockType.BLOCK_MAP.containsKey(mbName.toLowerCase())) {
			MicroblockType mbt = MicroblockType.BLOCK_MAP.get(mbName.toLowerCase());
			cmd.addMB(player, mbt.getPlayerName(), mbt.isSafe(), mbt.getBlockName());
		}else {
			Bukkit.getLogger().info("Couldn't add the Microblock '" + mbName + "' to " + player.getName() + "'s inventory, as it dosen't exist.");
		}
	}
	
}
