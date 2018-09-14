package com.somejakeguy.sammybot;

import com.somejakeguy.sammybot.events.GuildJoinEvent;
import com.somejakeguy.sammybot.events.MessageChatListener;
import com.somejakeguy.sammybot.events.ReadyListener;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.LoginException;

public class SammyBot {

    //Pokemon API (https://github.com/PokeAPI/pokeapi)
    private PokeApi pokea = new PokeApiClient();

    //Log4j logger
    private static Logger logger = LogManager.getLogger("SammyBot");

    /**
     * Returns the Pokemon API, which enables the user to send a request to the site(http://pokeapi.co) and obtain information back
     * @return PokeApi
     **/
    public PokeApi getPokeAPI(){
        return this.pokea;
    }

    /**
     * Returns the log4j logger, which writes information to the console in which this application is ran in!
     * @return log4j Logger
     **/
    public Logger getLogger(){
        return logger;
    }

    public static void main(String[] args){
        logger.info("PokeAPI is a go. Attempting to login to JDA/Discord...");

        try {
            /**
             * JDA Section (https://github.com/DV8FromTheWorld/JDA)
             * Input your own token here
             * Obtain your token by going to (https://discordapp.com/developers/applications/)
             * Then choose which application (bot) you want to have running this code
             * Afterwards, copy the "Token" under Bot and pass it in the #setToken
             **/

            JDA jda = new JDABuilder(AccountType.BOT).setToken("").buildAsync();

            jda.addEventListener(new ReadyListener());
            jda.addEventListener(new MessageChatListener());
            jda.addEventListener(new GuildJoinEvent());
        } catch (LoginException e) {
            logger.warn(e.getMessage());
        }
    }
}
