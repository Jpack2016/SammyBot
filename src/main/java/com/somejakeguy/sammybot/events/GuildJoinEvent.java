package com.somejakeguy.sammybot.events;

import com.somejakeguy.sammybot.SammyBot;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildJoinEvent extends ListenerAdapter{

    SammyBot mew = new SammyBot();

    //This event is called whenever a user enters a Guild (aka a server)
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        mew.getLogger().info(e.getMember().getEffectiveName() + " Joined Guild " + e.getGuild().getName());
    }
}
