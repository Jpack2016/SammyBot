package com.somejakeguy.sammybot.events;

import com.somejakeguy.sammybot.SammyBot;
import com.somejakeguy.sammybot.utils.MessageUtils;
import com.somejakeguy.sammybot.utils.PokeUtils;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageChatListener extends ListenerAdapter{

    private SammyBot mew = new SammyBot();
    private PokeUtils pokeutil = new PokeUtils();
    private MessageUtils msgutil = new MessageUtils();

    /*
    This method is only called when a message is typed by a user in a guild (server) that the bot is a member of.
    Bots can only join servers by invite links done by an administrator of a guild (server).

    Normally Discord API has loads of Rate Limits to be handled properly, however the chat one is 5 messages/5 seconds.
    These messages are conveniently handled in a queue and auto retried once the time has passed.
    */
    @Override
    public void onMessageReceived(MessageReceivedEvent e){

        //We only care to have commands that are run by users not bots so we don't respond to bots
        if (!(e.getMessage().getAuthor().isBot())) {

            //This is the commadn prefix I chose since most bots don't use it. Can be changed
            if (e.getMessage().getContentDisplay().startsWith("-")) {

                String command = e.getMessage().getContentDisplay().substring(1);
                String[] args = command.split(" ");
                long currtime = System.currentTimeMillis();

                if (args[0].equalsIgnoreCase("pokestats")){
                    if(args.length > 1){
                        if(msgutil.tryParseInt(args[1])){
                            EmbedBuilder poke = pokeutil.choosePoke(Integer.parseInt(args[1]));
                            if (poke != null) {
                                long timediff = System.currentTimeMillis() - currtime;
                                poke.setFooter("Info From PokeAPI | Pokestats took " + timediff + "ms (" + (new DecimalFormat("0.0").format(timediff/1000.0D)) + "s) to run!", e.getJDA().getSelfUser().getAvatarUrl());
                                e.getTextChannel().sendMessage(poke.build()).queue();
                                //According to JDA Documentation, we must set this to null to avoid having embeds bleed into each other!
                                poke = null;
                            }
                            else {
                                e.getTextChannel().sendMessage(e.getMessage().getAuthor().getAsMention() +
                                        " Error, that isn't a valid Pokemon ID!").queue();
                            }
                        }
                        else {
                            e.getTextChannel().sendMessage(e.getMessage().getAuthor().getAsMention() +
                                    " Error, argument wasn't a number!").queue();
                        }
                    }

                    else {
                        e.getTextChannel().sendMessage(e.getMessage().getAuthor().getAsMention() +
                                " Error in command, Check Arguments!").queue();
                    }
                }

                else if (args[0].equalsIgnoreCase("ping")) {
                    e.getTextChannel().sendMessage("Pong!").queue();
                    long timediff = System.currentTimeMillis() - currtime;
                    e.getTextChannel().sendMessage("Ping took " + timediff + "ms to run!").queue();
                }

                else if (args[0].equalsIgnoreCase("help")) {
                    EmbedBuilder help = new EmbedBuilder();
                    help.setColor(java.awt.Color.RED);
                    //This is my personal ID given by discord. This will never change and is here to obtain my current avatar URL
                    help.setAuthor("SomeJakeGuy", null, e.getJDA().getUserById(161214443550801920L).getAvatarUrl());
                    help.setTitle("Help Command Index!");
                    help.setDescription("The following commands are available to this bot:");
                    help.addField("-help", "Brings up this Help menu!", false);
                    help.addField("-define <words>", "Define a word, so long as it exists in Urban Dictionary! Can contain multiple words!", false);
                    help.addField("-pokestats <pokemonID>", "Brings up basic stats of a pokemon. Must use their ID (or national pokedex #). " +
                            "Even returns information regarding Evolution!", false);
                    help.addField("-shutdown", "Only available via SomeJakeGuy to shutdown this bot!", false);

                    long timediff = System.currentTimeMillis() - currtime;
                    help.setFooter("Help took " + timediff + "ms (" + (new DecimalFormat("0.0").format(timediff/1000.0D)) + "s) to run!", e.getJDA().getSelfUser().getAvatarUrl());

                    e.getTextChannel().sendMessage(help.build()).queue();
                }

                else if(args[0].equalsIgnoreCase("define")){
                    String result = msgutil.defineWord(command.replace("define", ""));
                    List<String> list = msgutil.commandlines(result, new ArrayList<>());

                    for(String s : list)e.getTextChannel().sendMessage(s).queue();
                }

                else if (args[0].equalsIgnoreCase("shutdown")) {
                    //This is my personal ID given by discord. This will never change and is here to make sure I am the only person who can shutdown this bot via this command
                    if(e.getAuthor().getIdLong() == 161214443550801920L){
                        mew.getLogger().warn("SammyBot has Shutdown!");
                        e.getJDA().shutdownNow();
                    }
                    else {
                        e.getTextChannel().sendMessage(e.getAuthor().getAsMention() + " You are NOT my master!").queue();
                    }
                }
            }
        }

        if (e.isFromType(ChannelType.PRIVATE)) {
            mew.getLogger().info("[Private Msg] " + e.getAuthor().getName() + ": " + e.getMessage().getContentDisplay());
        }
        else {
            mew.getLogger().info("[" + e.getGuild().getName() + "] #" + e.getTextChannel().getName() + " "
                    + e.getMember().getEffectiveName() + ": " + e.getMessage().getContentDisplay());
        }
    }
}
