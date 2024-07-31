package fr.ideeess.mutest.commands;

import fr.ideeess.mutest.MUTest;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public class CancelEventCommand implements CommandExecutor {

    MUTest main;

    public CancelEventCommand(MUTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Logger logger = main.getLogger();

        if (!sender.hasPermission("fr.ideeess.cancelevent")){
            sender.sendMessage(ChatColor.RED + "Vous n'avez pas la permission pour exécuter cette commande");
            return false;
        }

        if (main.getEvent() == null){
            sender.sendMessage(ChatColor.RED + "Aucun événement n'est en cours");
            return false;
        }

        String eventName = main.getEvent().getName();

        main.setEvent(null);

        sender.sendMessage(ChatColor.GREEN + "L'événement " +ChatColor.RED + eventName + ChatColor.GREEN + " a bien été supprimé");
        logger.info("L'événement " + eventName + " a bien été supprimé");
        return true;
    }
}
