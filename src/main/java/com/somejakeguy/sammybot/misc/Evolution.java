package com.somejakeguy.sammybot.misc;

public class Evolution {

    /**
     * This class was created as a container for storing all evolution data received from the PokeAPI
     * After all data is entered, it is converted to a single String (as most of these functions arent used for each individual pokemon)
     * This single string is then given to the PokmeonSpec class and entered in the evolution chain section
     **/

    private String name;
    private String evoType;
    private String evoStoneItem;
    private String heldItem;
    private int minLevel;
    private int minHappiness;
    private int minBeauty;
    private int minAffection;
    private String knowsAMoveType;
    private String knowsMove;
    private String gender;
    private String timeOfDay;
    private String needsPokemonInParty;
    private String needsPartyPokemonType;
    private String physStats;
    private String tradeWithPokemon;
    private boolean needsToBeRaining;
    private boolean haveDeviceUpsideDown;
    private String locations;

    /**
     * Sets the name of the evolution pokemon, obtained by api from evoID
     * @param name  Name of the pokemon that will be evolved into
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the pokemon set by setName
     * @return name     String name of the pokemon that will be evolved into
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the evolution type of evolution, obtained by the api from evoID
     * @param evoType   Type of evolution, refer to the API to see types (https://pokeapi.co/)
     */
    public void setEvoType(String evoType) {
        this.evoType = evoType;
    }

    /**
     * Retrieve the evolution type set by setEvoType
     * @return evoType  String Type of evolution
     */
    public String getEvoType() {
        return this.evoType;
    }

    /**
     * Set the held item needed to evolve, obtained by the api from evoID
     * @param heldItem  Held item of a pokemon needed to evolve (if any)
     */
    public void setHeldItem(String heldItem) {
        this.heldItem = heldItem;
    }

    /**
     * Retrieve the held item set by setHeldItem
     * @return heldItem String held item needed for the pokemon to evolve (if any)
     */
    public String getHeldItem() {
        return this.heldItem;
    }

    /**
     * Set the evolution stone needed to evolve, obtained by the api from evoID
     * @param evoStoneItem  Evolution Stone of a pokemon needed to evolve (if any)
     */
    public void setEvoStoneItem(String evoStoneItem) {
        this.evoStoneItem = evoStoneItem;
    }

    /**
     * Retrieve the evolution stone set by setEvoStoneItem
     * @return heldItem String held item needed for the pokemon to evolve (if any)
     */
    public String getEvoStoneItem() {
        return this.evoStoneItem;
    }

    /**
     * Set the minimum level before an evolution is possible, obtained by the api from evoID
     * @param minLevel  Minimal level the pokemon needs to be before it can evolve
     */
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    /**
     * Retrieve the minimal level set by setMinLevel
     * @return minLevel Integer representing the minimal level a pokemon needs to be before it can evolve
     */
    public int getMinLevel() {
        return this.minLevel;
    }

    /**
     * Set the minimum beauty a pokemon needs before evolution is possible, obtained by the api from evoID
     * @param minBeauty Minimal beauty a pokemon needs to have before it can evolve
     */
    public void setMinBeauty(int minBeauty) {
        this.minBeauty = minBeauty;
    }

    /**
     * Retrieve the minimal beauty level set by setMinBeauty
     * @return minBeauty    Integer representing the minimal beauty level a pokemon needs to evolve
     */
    public int getMinBeauty() {
        return this.minBeauty;
    }

    /**
     * Set the minimum happiness a pokemon needs to evolve, obtained by the api from evoID
     * @param minHappiness Minimal happiness a pokemon needs to have to evolve
     */
    public void setMinHappiness(int minHappiness) {
        this.minHappiness = minHappiness;
    }

    /**
     * Retrieve the minimal happiness set by setMinHappiness
     * @return minHappiness Integer representing the minimal happiness a pokemon needs to evolve
     */
    public int getMinHappiness() {
        return this.minHappiness;
    }

    /**
     * Set the minimum affection a pokemon needs to evolve, obtained by the api from evoID
     * @param minAffection Minimal affection a pokemon needs to have to evolve
     */
    public void setMinAffection(int minAffection) {
        this.minAffection = minAffection;
    }

    /**
     * Retrieve the minimal affection set by setMinAffection
     * @return minAffection Integer representing the minimal affection a pokemon needs to evolve
     */
    public int getMinAffection() {
        return this.minAffection;
    }

    /**
     * Set the move type needed by a pokemon to evolve, obtained by the api from evoID
     * @param knowsAMoveType Move type needed to be known by the pokemon
     */
    public void setKnowsAMoveType(String knowsAMoveType) {
        this.knowsAMoveType = knowsAMoveType;
    }

    /**
     * Retrieve the move type needed to be known set by setKnowsAMoveType
     * @return knowsAMoveType   String Move type (http://pokemon.wikia.com/wiki/Types) needed to be known by this pokemon to evolve
     */
    public String getKnowsAMoveType() {
        return this.knowsAMoveType;
    }

    /**
     * Set the move needed to be known for the pokemon to evolve, obtained by the api from evoID
     * @param knowsMove Move a pokemon needs to know to evolve
     */
    public void setKnowsMove(String knowsMove) {
        this.knowsMove = knowsMove;
    }

    /**
     * Retrieve the move needed to be known set by setKnowsMove
     * @return knowsMove    String Move that needs to be known for this pokemon to evolve
     */
    public String getKnowsMove() {
        return this.knowsMove;
    }

    /**
     * Set the gender of a pokemon, obtained by the api from evoID
     * @param gender Gender of the pokemon (if not legendary or uber)
     * String changes based on integer gender input. Information can be found in pokeapi (http://pokeapi.co)
     */
    public void setGender(Integer gender) {
        if (gender == null) {
            this.gender = null;
        } else if (gender == 1) {
            this.gender = "Female";
        } else if (gender == 0) {
            this.gender = "Male";
        }
    }

    /**
     * Retrieve gender set by setGender
     * @return gender   String Gender of either Male, Female, or null(pokemon does not have gender)
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Set the time of day needed to evolve (if any), obtained by the api from evoID
     * @param timeOfDay
     */
    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    /**
     * Retrieve the time of day set by setTimeOfDay
     * @return timeOfDay    String time of day needed in game for the pokemon to evolve
     */
    public String getTimeOfDay() {
        return this.timeOfDay;
    }

    /**
     * Set additional pokemon needed for the pokemon to evolve (if any), obtained by the api from evoID
     * @param needsPokemonInParty additional pokemon needed for the pokemon to evolve
     */
    public void setNeedsPokemonInParty(String needsPokemonInParty) {
        this.needsPokemonInParty = needsPokemonInParty;
    }

    /**
     * Retrieve the need pokemon in party set by setNeedsPokemonInParty
     * @return needsPokemonInParty  String Additional pokemon needed in your party for the pokemon to evolve
     */
    public String getNeedsPokemonInParty() {
        return this.needsPokemonInParty;
    }

    /**
     * Set additional pokemon types needed for the pokemon to evolve (if any), obtained by the api from evoID
     * @param needsPartyPokemonType additional pokemon types needed for the pokemon to evolve
     */
    public void setNeedsPartyPokemonType(String needsPartyPokemonType) {
        this.needsPartyPokemonType = needsPartyPokemonType;
    }

    /**
     * Retrieve the need pokemon in party set by setNeedsPartyPokemonType
     * @return needsPartyPokemonType  String Additional pokemon type(s) needed in your party for the pokemon to evolve
     */
    public String getNeedsPartyPokemonType() {
        return this.needsPartyPokemonType;
    }

    /**
     * Set the physical stats of a pokemon, obtained by the api from evoID
     * @param physStats physical stats of the pokemon that will evolve and what happens based on it
     * String changes based on integer physStats input. Information can be found in pokeapi (http://pokeapi.co)
     */
    public void setPhysStats(Integer physStats) {
        if (physStats != null) {
            if (physStats == 1) {
                this.physStats = "Attack > Defense";
            } else if (physStats == 0) {
                this.physStats = "Attack = Defense";
            } else if (physStats == -1) {
                this.physStats = "Attack < Defense";
            }
        }
        else {
            this.physStats = null;
        }
    }

    /**
     * Retrieve the physical stats set by setPhysStats
     * @return physStats    String Either Attack needs to be greater, defense needs to be greater, or both needs to be equal
     */
    public String getPhysStats() {
        return this.physStats;
    }

    /**
     * Set needs to be traded to evolve, obtained by the api from evoID
     * @param tradeWithPokemon pokemon that must be traded with the pokemon that is trying to evolve
     */
    public void setTradeWithPokemon(String tradeWithPokemon) {
        this.tradeWithPokemon = tradeWithPokemon;
    }

    /**
     * Retrieve the pokemon needed to trade with set by setTradeWithPokemon
     * @return tradeWithPokemon     String pokemon that needs to trade with whatever pokemon needs to evolve
     */
    public String getTradeWithPokemon() {
        return this.tradeWithPokemon;
    }

    /**
     * Set location of where evolution must occur, obtained by the api from evoID
     * @param locations Location in which evolution must occur
     */
    public void setLocations(String locations) {
        this.locations = locations;
    }

    /**
     * Retrieve the location set by setLocations
     * @return locations    String Location in game where evolution can occur
     */
    public String getLocations() {
        return this.locations;
    }

    /**
     * Sets the condition of it raining to evolve, obtained by the api from evoId
     * @param needsToBeRaining Whether it needs to be raining or not for this pokemon to evolve
     */
    public void setNeedsToBeRaining(boolean needsToBeRaining) {
        this.needsToBeRaining = needsToBeRaining;
    }

    /**
     * Retrieve the condition of rain set by setNeedsToBeRaining
     * @return needsToBeRaining     boolean true or false if rain is needed for the pokemon to evolve
     */
    public boolean isNeedsToBeRaining() {
        return this.needsToBeRaining;
    }

    /**
     * Sets the haveDeviceUpsideDown true or false on whether its required for the specific evolution, obtained by the api from evoID
     * @param haveDeviceUpsideDown Whether the handheld has to be upside down (games only)
     */
    public void setHaveDeviceUpsideDown(boolean haveDeviceUpsideDown) {
        this.haveDeviceUpsideDown = haveDeviceUpsideDown;
    }

    /**
     * Retrieves haveDeviceUpsideDown set by setHaveDeviceUpsideDown
     * @return haveDeviceUpsideDown boolean True if device is needed to be turned upside down
     *                                      False if device is not needed to be upside down
     */
    public boolean isHaveDeviceUpsideDown() {
        return this.haveDeviceUpsideDown;
    }

    /**
     * Function to convert all evolution data into a single string!
     * Most functions will either be null or unused because some functions are unique to specific pokemon!
     * @return evolution    String Sentence(s) which tell how the specific evolution is possible
     */
    public String toString() {
        String result = getName() + ":::";
        if (getMinLevel() != 0) {
            result = result + "Evolves At Lvl " + getMinLevel();
            if (getHeldItem() != null) {
                result = result + ", Holding The " + getHeldItem() + " Item Too!\n";
            } else {
                result = result + "\n";
            }
        }
        if (getEvoType().equalsIgnoreCase("trade"))
        {
            result = result + "Evolves by Trading\n";
            if (getHeldItem() != null) {
                result = result + "And Must Be Holding " + getHeldItem() + " Too!\n";
            }
            else if (getTradeWithPokemon() != null) {
                result = result + "But You MUST Trade It With This Pokemon: " + getTradeWithPokemon() + "!\n";
            }
        }
        if (getEvoStoneItem() != null) {
            result = result + "Evolves Using The " + getEvoStoneItem() + "\n";
        }
        if (getGender() != null) {
            result = result + "Must Be Gender " + getGender() + "!\n";
        }
        if (getMinBeauty() != 0) {
            result = result + "Must Have A Minimum Beauty of" + getMinBeauty() + "!\n";
        }
        if (getMinAffection() != 0) {
            result = result + "Must Have A Minimum Affection of" + getMinAffection() + "!\n";
        }
        if (getMinHappiness() != 0) {
            result = result + "Must Have A Minimum Happiness of" + getMinHappiness() + "!\n";
        }
        if (getTimeOfDay() != null) {
            result = result + "Can Only Evolve At " + getTimeOfDay() + " Time!\n";
        }
        if (getKnowsAMoveType() != null) {
            result = result + "Can Only Evolve If It Knows A Move Of Type " + getKnowsAMoveType() + "!\n";
        }
        if (getLocations() != null) {
            result = result + "Can Only Evolve If It Knows The Move " + getLocations() + "!\n";
        }
        if (getKnowsMove() != null) {
            result = result + "Can Only Evolve If It Knows The Move " + getKnowsMove() + "!\n";
        }
        if (getNeedsPokemonInParty() != null) {
            result = result + "Can Only Evolve If The Pokemon " + getNeedsPokemonInParty() + " Is In The Party!\n";
        }
        if (getNeedsPartyPokemonType() != null) {
            result = result + "Can Only Evolve If The Pokemon Of Type " + getNeedsPartyPokemonType() + " Is In The Party!\n";
        }
        if (getPhysStats() != null) {
            result = result + "Can Only Evolve If The Pokemon Has " + getPhysStats() + ".\n";
        }
        if (isHaveDeviceUpsideDown()) {
            result = result + "Weird Case: Hold The DS Upside Down To Evolve!\n";
        }
        if (isNeedsToBeRaining()) {
            result = result + "Weird Case: Make Sure It Is Raining In The World (Rain Dance Or Drizzle Don't Count)!\n";
        }
        return result;
    }
}