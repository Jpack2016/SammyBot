package com.somejakeguy.sammybot.events;

import com.somejakeguy.sammybot.SammyBot;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter{

    SammyBot mew = new SammyBot();

    //This event is called when the bot has successfully connected to Discord's API and servers!
    @Override
    public void onReady(ReadyEvent e){
        mew.getLogger().info("JDA Logged in successfully!");
        e.getJDA().getPresence().setGame(Game.playing("Made by SomeJakeGuy"));

        mew.getLogger().info("SammyBot is apart of the following servers:");
        for(Guild g : e.getJDA().getGuilds()) {
            mew.getLogger().info(g.getName() + " - " +  g.getMembers().size() + " Members!");
        }
    }
}
