package fr.ideeess.mutest.events;

import fr.ideeess.mutest.MUTest;
import fr.ideeess.mutest.events.Event;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportPlayerToEvent {
    Player player;
    Event event;

    public TeleportPlayerToEvent(Player player, Event event, MUTest main) {
        this.player = player;
        this.event = event;

        int x = event.getX();
        int y = event.getY();
        int z = event.getZ();
        float pitch = event.getPitch();
        float yaw = event.getYaw();

        player.teleport(new Location(player.getWorld(),x,y,z,yaw,pitch));
        player.sendMessage(ChatColor.GREEN + "Vous avez bien été téléporté à l'événement " + ChatColor.RED + event.getName());
        main.getLogger().info("Le joueur " + player.getName() + " s'est téléporté à l'événement");
    }
}
