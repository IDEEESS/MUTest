package fr.ideeess.mutest.commands;

import fr.ideeess.mutest.MUTest;
import fr.ideeess.mutest.events.Event;
import fr.ideeess.mutest.events.TeleportPlayerToEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class EventCommand implements CommandExecutor {
    MUTest main;
    public EventCommand(MUTest main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Logger logger = main.getLogger();

        if (!(sender instanceof Player player)){
            sender.sendMessage(ChatColor.RED + "Seul un joueur peut exécuter cette commande");
            return false;
        }

        if (main.getEvent() == null){
            player.sendMessage(ChatColor.RED + "Aucun événement n'est en cours");
            return false;
        }

        Event event = main.getEvent();

        new TeleportPlayerToEvent(player, event);
        logger.info(player.getName() + " a rejoint l'événement " + event.getName());

        return true;
    }
}
