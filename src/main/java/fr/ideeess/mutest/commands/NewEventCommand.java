package fr.ideeess.mutest.commands;

import fr.ideeess.mutest.MUTest;
import fr.ideeess.mutest.events.Event;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class NewEventCommand implements CommandExecutor {
    MUTest main;
    public NewEventCommand(MUTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Logger logger = main.getLogger();

        if (!(sender instanceof Player player)){
            sender.sendMessage(ChatColor.RED + "Seul un joueur peut exécuter cette action");
            return false;
        }

        String senderName = sender.getName();
        if (!sender.hasPermission("fr.ideeess.newevent")){
            logger.warning("Le joueur " + senderName + " a essayé de créer un event mais il n'a pas les permissions requises");
            sender.sendMessage(ChatColor.RED + "Vous n'avez pas la permission requise pour effectuer cette commande");
            return false;
        }

        if(args.length < 1){
            sender.sendMessage(ChatColor.RED + "Argument manquant : il faut préciser le nom de l'événement");
            return false;
        }

        String eventName = args[0];
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();
        float pitch = player.getLocation().getPitch();
        float yaw = player.getLocation().getYaw();

        if (main.getEvent() != null){
            player.sendMessage(ChatColor.RED + "Un événement est déjà en cours");
            return false;
        }

        Event event = new Event(eventName,x,y,z,pitch,yaw);
        for (Player players : Bukkit.getOnlinePlayers()){
            TextComponent annonce = new TextComponent(ChatColor.GREEN + "Un nouveau événement a été créé");
            annonce.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"event"));
            annonce.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Clique sur le message pour être téléporté à l'événement")));
            players.sendMessage(annonce.getText());
        }
        main.setEvent(event);
        logger.info("L'événement " + eventName + " a été créé");
        return true;
    }
}
