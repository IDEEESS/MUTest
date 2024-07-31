package fr.ideeess.mutest;

import fr.ideeess.mutest.commands.EventCommand;
import fr.ideeess.mutest.commands.NewEventCommand;
import fr.ideeess.mutest.events.Event;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MUTest extends JavaPlugin {

    private Event event = null;
    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        super.onEnable();

        //Commandes
        getCommand("newevent").setExecutor(new NewEventCommand(this));
        getCommand("event").setExecutor(new EventCommand(this));
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
