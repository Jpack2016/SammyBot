package com.somejakeguy.sammybot.misc;

import net.dv8tion.jda.core.EmbedBuilder;
import org.apache.commons.lang3.text.WordUtils;
import java.util.List;

public class PokemonSpec {

    /**
     * This class was created as a container for storing all pokemon data received from the PokeAPI
     * After all data is entered, it is converted to an EmbedBuilder for a prettier view in PokeUtils!
     **/

    private int id;
    private String name;
    private String region;
    private String description;
    private String type;
    private int baseHappiness;
    private int catchRate;
    private String generation;
    private int evoID;
    private String evolvedFrom;
    private List<String> evolutions;
    private String authorURL;
    private String maleURL;
    private String thumbnailURL;

    /**
     * Sets the ID of the current pokemon once the PokeAPI has determined that
     * the ID the user is trying to find is valid!
     *
     * @param id    an integer obtained from the user who typed the command
     *              ID of the pokemon to find and gather information about once found
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the ID set by the setId
     * @return id   Integer ID of the pokemon
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the name of the pokemon, obtained by the api from the ID
     * @param name  Name of the pokemon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name set by the setName
     * @return name     String name of the current Pokemon
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the description of the pokemon, obtained by the api from the ID
     * @param description  Pokedex description of the pokemon
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the name set by the setName
     * @return description      String Pokedex description and its most recent region that updated it
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the region that the pokemon's description is from, obtained by the api from the ID
     * @param region    The region that the pokedex description was from
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Retrieves the region set by the setRegion
     * @return region   String Region where pokedex description is from
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the Type(s) of the pokemon, obtained by the api from the ID
     * @param type The type(s) the pokemon is (http://pokemon.wikia.com/wiki/Types)
     */
    public void setPokeType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the type(s) set by the setPokeType
     * @return type     String Type or types the current pokemon is
     */
    public String getPokeType() {
        return type;
    }

    /**
     * Sets the generation of the pokemon, obtained by the api from the ID
     * @param generation    Generation in which the pokemon was first introduced into the game
     */
    public void setGeneration(String generation) {
        if (generation.equalsIgnoreCase("1")) {
            this.generation = "Originally From Kanto";
        } else if (generation.equalsIgnoreCase("2")) {
            this.generation = "Originally From Johto";
        } else if (generation.equalsIgnoreCase("3")) {
            this.generation = "Originally From Hoenn";
        } else if (generation.equalsIgnoreCase("4")) {
            this.generation = "Originally From Sinnoh";
        } else if (generation.equalsIgnoreCase("5")) {
            this.generation = "Originally From Unova";
        } else if (generation.equalsIgnoreCase("6")) {
            this.generation = "Originally From Kalos";
        } else if (generation.equalsIgnoreCase("7")) {
            this.generation = "Originally From Alola";
        }
    }

    /**
     * Retrieves the generation set by the setGeneration
     * @return region   String Generation in which the pokemon was first introduced
     */
    public String getGeneration() {
        return this.generation;
    }

    /**
     * Sets the base happiness of the pokemon, obtained by the api from the ID
     * @param baseHappiness     Base happiness of the pokemon (relevant to the handheld games)
     */
    public void setBaseHappiness(int baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    /**
     * Retrieves the base happiness set by setBaseHappiness
     * @return baseHappiness    Integer representing the base happiness of a pokemon in the games
     */
    public int getBaseHappiness() {
        return this.baseHappiness;
    }

    /**
     * Sets the catch rate of the pokemon, obtained by the api from the ID
     * @param catchRate     The catch rate of a pokemon
     */
    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }

    /**
     * Retrieves the Catch Rate set by setCatchRate
     * @return catchRate    Integer Catch rate of the pokemon, calculated by (https://bulbapedia.bulbagarden.net/wiki/Catch_rate)
     */
    public int getCatchRate() {
        return this.catchRate;
    }

    /**
     * Sets the url image of the pokemon using the pokemon name and a predetermined link.
     * This is used in the Embed described below!
     * @param authorURL     URL to an image used as the authorURL in the embed!
     */
    public void setAuthorURL(String authorURL) {
        this.authorURL = authorURL;
    }

    /**
     * Retrieves the authorURL set by setAuthorURL
     * @return authorURL    String Hardcoded png image of the pokemon from (https://img.pokemondb.net)
     */
    public String getAuthorURL() {
        return authorURL;
    }

    /**
     * Sets the URL image of the male version of the pokemon (if possible), obtained by the api from the ID
     * @param maleURL   URL of the male sprite version of the pokemon
     */
    public void setMaleURL(String maleURL) {
        this.maleURL = maleURL;
    }

    /**
     * Retrieves the maleURL set setMaleURL
     * @return maleURL  URL of the male sprite version of the pokemon
     */
    public String getMaleURL() {
        return maleURL;
    }

    /**
     * Sets the URL image of the pokemon using the pokemon name and a predetermined link.
     * This is used in the Embed described below!
     * @param thumbnailURL  URL of the thumbnail to use in the description portion of the Embed
     */
    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    /**
     * Retrieves the thumbnailURL set by setThumbnailURL
     * @return thumbnailURL    String Hardcoded png image of the pokemon from (https://img.pokemondb.net)
     */
    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

    /**
     * Set the evolution ID of the pokemon, obtained from the api from the ID
     * @param evoID    ID of the evolution chain of the current pokemon
     */
    public void setEvoID(int evoID) {
        this.evoID = evoID;
    }

    /**
     * Retrieves the evolution ID set by setEvoID
     * @return evoID    Integer ID of the evolution chain of the current pokemon
     */
    public int getEvoID() {
        return this.evoID;
    }

    /**
     * Set the pokemon that the current pokemon evolved from, obtained from evolution chain
     * @param evolvedFrom   Pokemon that the current pokemon evolved from (if possible)
     */
    public void setEvolvedFrom(String evolvedFrom) {
        this.evolvedFrom = evolvedFrom;
    }

    /**
     * Retrieve the pokemon that the current has evolved from set by setEvolvedFrom
     * @return evolvedFrom  String The pokemon that the current pokemon has evolved from (if possible)
     */
    public String getEvolvedFrom() {
        return this.evolvedFrom;
    }

    /**
     * Set the possible evolutions of the current pokemon, obtained by the api from the evoID
     * @param evolutions    List of all possible evolutions of the current pokemon (if any)
     */
    public void setEvolutions(List<String> evolutions) {
        this.evolutions = evolutions;
    }

    /**
     * Retrieves the list of possible evolutions set by setEvolutions
     * @return evolutions   List<String> List of all possible evolutions of the current pokemon
     */
    public List<String> getEvolutions() {
        return this.evolutions;
    }

    /**
     * This function is an Embeded Builder that is used by JDA in a command response.
     * This function takes every function listed above and neatly creates a more optimal and visual response!
     * This was used instead of a very large String with new lines printed everywhere
     * @return embed    Embed Pokemon information in a neatly embeded builder used by MessageChatListener to send back to command user!
     */
    public EmbedBuilder pokeEmbed() {

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(java.awt.Color.RED);
        embed.setAuthor("Name: " + WordUtils.capitalize(getName()), null, getAuthorURL());
        embed.setTitle("PokeDex Desc " + getRegion() + ":");
        embed.setDescription(getDescription()).setThumbnail(getThumbnailURL());
        embed.addField("Type:", getPokeType(), false).addField("Generation:", getGeneration(), false);

        if(getEvolvedFrom() != null){
            embed.addField("Evolution ID:", WordUtils.capitalize(getEvolvedFrom()), false);
        }
        else{
            embed.addField("Evolution ID:", "This Pokemon has no previous evolution!", false);
        }

        embed.addField("Catch Rate:", "The Catch Rate Of This Pokemon Is " + getCatchRate() + "! \"[Catch Rate](https://bulbapedia.bulbagarden.net/wiki/Catch_rate)\"", false);
        embed.addField("Base Happiness:", "" + getBaseHappiness(), false);
        embed.setImage(getMaleURL());

        if (getEvolutions() != null) {

                embed.addField("Evolution", "This Pokemon's evolution chain:", false);
                for (String e : getEvolutions()) {
                    String[] evo = e.split(":::");
                    embed.addField(evo[0], evo[1], true);
                }

        }
        else {
            //This Evolution ID refers to the Eevee Chain (https://bulbapedia.bulbagarden.net/wiki/Eevee_(Pok%C3%A9mon)
            //Because the Embeds have a limit on how much information can fit in them, this line was added as the only exception due to it being so large
            if(getEvoID() == 67) {
                embed.addField("Evolution:", "Eevee's evolution is too long for this message,\n" +
                        "[Please see this link (Bottom of Page)!](https://bulbapedia.bulbagarden.net/wiki/Eevee_(Pok%C3%A9mon)", false);
            }
            else
                embed.addField("Evolution:", "This Pokemon Does Not Evolve!", false);
        }

        return embed;
    }
}