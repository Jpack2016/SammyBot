package com.somejakeguy.sammybot.utils;

import com.somejakeguy.sammybot.SammyBot;
import com.somejakeguy.sammybot.misc.Evolution;
import com.somejakeguy.sammybot.misc.PokemonSpec;
import java.util.ArrayList;
import java.util.List;

import me.sargunvohra.lib.pokekotlin.model.*;
import net.dv8tion.jda.core.EmbedBuilder;
import org.apache.commons.lang3.text.WordUtils;

public class PokeUtils {

    private SammyBot mew = new SammyBot();

    /**
     * This class is a way of shortening methods used of retrieving information from the PokeAPI database
     * REST based calls that return a large list of data from single source (ie just a pokemon, pokemon type, etc)
     * Container class PokemonSpec holds all relevant information until EmbedBuilder puts it in a nice view
     * @return embed    EmbedBuilder returns an embed to be built if the pokemon is found, fails if database is unreachable or pokeID is invalid
     **/
    public EmbedBuilder choosePoke(int pokeID) {
        try {

            mew.getPokeAPI().getPokemonSpecies(pokeID);
            PokemonSpecies pokeSpe = mew.getPokeAPI().getPokemonSpecies(pokeID);
            Pokemon poke = mew.getPokeAPI().getPokemon(pokeID);

            PokemonSpec pokemon = new PokemonSpec();
            pokemon.setId(poke.getId());
            pokemon.setName(poke.getName());

            List<PokemonSpeciesFlavorText> descriptions = pokeSpe.getFlavorTextEntries();
            String desc = "";
            String reg = "";
            int id = 0;

            for(PokemonSpeciesFlavorText fl : descriptions) {
                if (fl.getLanguage().getName().equals("en")) {
                    if(fl.getVersion().getId() > id){
                        id = fl.getVersion().getId();
                        desc = fl.getFlavorText();
                        reg = fl.component3().getName();
                    }
                }
            }

            desc = desc.replaceAll("\n", " ");
            reg = WordUtils.capitalize(reg.replace("-", " "));
            pokemon.setRegion("from the region " + reg);
            pokemon.setDescription(desc);

            String poketype = "";
            for(PokemonType type : poke.getTypes()){
                poketype += "," + WordUtils.capitalize(type.getType().getName());
            }
            pokemon.setPokeType(poketype.substring(1).replace(",", ", "));

            pokemon.setCatchRate(pokeSpe.getCaptureRate());
            pokemon.setBaseHappiness(pokeSpe.getBaseHappiness());

            pokemon.setGeneration("" + pokeSpe.getGeneration().getId());
            if (pokeSpe.getEvolvesFromSpecies() != null) {
                pokemon.setEvolvedFrom(pokeSpe.getEvolvesFromSpecies().getName());
            } else {
                pokemon.setEvolvedFrom(null);
            }

            pokemon.setEvoID(pokeSpe.component17().getId());

            //This Evolution ID refers to the Eevee Chain (https://bulbapedia.bulbagarden.net/wiki/Eevee_(Pok%C3%A9mon)
            //Because the Embeds have a limit on how much information can fit in them, this line was added as the only exception due to it being so large
            if(pokemon.getEvoID() != 67){
                pokemon.setEvolutions(checkAndSetEvos(pokemon.getEvoID()));
            }

            pokemon.setAuthorURL("https://img.pokemondb.net/artwork/" + pokemon.getName().toLowerCase() + ".jpg");
            pokemon.setThumbnailURL("https://img.pokemondb.net/artwork/" + pokemon.getName().toLowerCase() + ".jpg");
            pokemon.setMaleURL(poke.getSprites().getFrontDefault());

            return pokemon.pokeEmbed();
        } catch (Throwable t) {
            return null;
        }
    }

    /**
     * This checks to see if the pokemon has any evolutions based on the evolution ID obtained from the above method
     * Sets the evolutions of the pokemon(if any)
     * Container class Evolution holds all relevant information until toString method is called
     * @param evoID Evolution ID of the evolution chain. This is predetermined by the database site itself
     * @return evols    List<String> List of all possible evolutions of a pokemon (if there is any)
     */
    private List<String> checkAndSetEvos(int evoID) {
        List<String> evols = new ArrayList<>();
        ChainLink ch = mew.getPokeAPI().getEvolutionChain(evoID).getChain();
        List<ChainLink> getFirst = ch.getEvolvesTo();
        Evolution evo1;
        Evolution evo2;

        if (!getFirst.isEmpty()) {
            evols.add("#" + ch.getSpecies().getId() + " - " + WordUtils.capitalize(ch.getSpecies().getName()) + ":::First Stage");
            evo1 = new Evolution();
            evo2 = new Evolution();

            for (ChainLink l : getFirst) {
                EvolutionDetail evo1d = l.getEvolutionDetails().get(0);

                evo1.setName("#" + l.getSpecies().getId() + " - " + WordUtils.capitalize(l.getSpecies().getName()));
                evo1.setEvoType(WordUtils.capitalize(evo1d.getTrigger().getName()));
                if (evo1d.getItem() != null) {
                    evo1.setEvoStoneItem(WordUtils.capitalize(evo1d.getItem().getName()));
                } else {
                    evo1.setEvoStoneItem(null);
                }
                if (evo1d.getHeldItem() != null) {
                    evo1.setHeldItem(WordUtils.capitalize(evo1d.getHeldItem().getName()));
                } else {
                    evo1.setHeldItem(null);
                }
                if (evo1d.getMinLevel() != null) {
                    evo1.setMinLevel(evo1d.getMinLevel());
                } else {
                    evo1.setMinLevel(0);
                }
                if (evo1d.getMinHappiness() != null) {
                    evo1.setMinHappiness(evo1d.getMinHappiness());
                } else {
                    evo1.setMinHappiness(0);
                }
                if (evo1d.getMinBeauty() != null) {
                    evo1.setMinBeauty(evo1d.getMinBeauty());
                } else {
                    evo1.setMinBeauty(0);
                }
                if (evo1d.getMinAffection() != null) {
                    evo1.setMinAffection(evo1d.getMinLevel());
                } else {
                    evo1.setMinAffection(0);
                }
                if (evo1d.getKnownMoveType() != null) {
                    evo1.setKnowsAMoveType(WordUtils.capitalize(evo1d.getKnownMoveType().getName()));
                } else {
                    evo1.setKnowsAMoveType(null);
                }
                if (evo1d.getKnownMove() != null) {
                    evo1.setKnowsMove(WordUtils.capitalize(evo1d.getKnownMove().getName()));
                } else {
                    evo1.setKnowsMove(null);
                }
                if (evo1d.getGender() != null) {
                    evo1.setGender(evo1d.getGender());
                } else {
                    evo1.setGender(null);
                }
                if (!evo1d.getTimeOfDay().isEmpty()) {
                    evo1.setTimeOfDay(WordUtils.capitalize(evo1d.getTimeOfDay()));
                } else {
                    evo1.setTimeOfDay(null);
                }
                if (evo1d.getPartySpecies() != null) {
                    evo1.setNeedsPokemonInParty(WordUtils.capitalize(evo1d.getPartySpecies().getName()));
                } else {
                    evo1.setNeedsPokemonInParty(null);
                }
                if (evo1d.getPartyType() != null) {
                    evo1.setNeedsPartyPokemonType(WordUtils.capitalize(evo1d.getPartyType().getName()));
                } else {
                    evo1.setNeedsPartyPokemonType(null);
                }
                if (evo1d.getRelativePhysicalStats() != null) {
                    evo1.setPhysStats(evo1d.getRelativePhysicalStats());
                } else {
                    evo1.setPhysStats(null);
                }
                if (evo1d.getTradeSpecies() != null) {
                    evo1.setTradeWithPokemon(WordUtils.capitalize(evo1d.getTradeSpecies().getName()));
                } else {
                    evo1.setTradeWithPokemon(null);
                }
                if (evo1d.getNeedsOverworldRain()) {
                    evo1.setNeedsToBeRaining(true);
                } else {
                    evo1.setNeedsToBeRaining(false);
                }
                if (evo1d.getTurnUpsideDown()) {
                    evo1.setHaveDeviceUpsideDown(true);
                } else {
                    evo1.setHaveDeviceUpsideDown(false);
                }
                if (evo1d.getLocation() != null) {
                    evo1.setLocations(WordUtils.capitalize(evo1d.getLocation().getName()));
                } else {
                    evo1.setLocations(null);
                }
                evols.add(evo1.toString());

                List<ChainLink> evolu2 = l.getEvolvesTo();
                if(!(evolu2.isEmpty())){
                    for (ChainLink l2 : evolu2) {
                        EvolutionDetail evo2d = l2.getEvolutionDetails().get(0);

                        evo2.setName("#" + l2.getSpecies().getId() + " - " + WordUtils.capitalize(l2.getSpecies().getName()));
                        evo2.setEvoType(WordUtils.capitalize(evo2d.getTrigger().getName()));
                        if (evo2d.getItem() != null) {
                            evo2.setEvoStoneItem(WordUtils.capitalize(evo2d.getItem().getName()));
                        } else {
                            evo2.setEvoStoneItem(null);
                        }
                        if (evo2d.getHeldItem() != null) {
                            evo2.setHeldItem(WordUtils.capitalize(evo2d.getHeldItem().getName()));
                        } else {
                            evo2.setHeldItem(null);
                        }
                        if (evo2d.getMinLevel() != null) {
                            evo2.setMinLevel(evo2d.getMinLevel());
                        } else {
                            evo2.setMinLevel(0);
                        }
                        if (evo2d.getMinHappiness() != null) {
                            evo2.setMinHappiness(evo2d.getMinHappiness());
                        } else {
                            evo2.setMinHappiness(0);
                        }
                        if (evo2d.getMinBeauty() != null) {
                            evo2.setMinBeauty(evo2d.getMinBeauty());
                        } else {
                            evo2.setMinBeauty(0);
                        }
                        if (evo2d.getMinAffection() != null) {
                            evo2.setMinAffection(evo2d.getMinLevel());
                        } else {
                            evo2.setMinAffection(0);
                        }
                        if (evo2d.getKnownMoveType() != null) {
                            evo2.setKnowsAMoveType(WordUtils.capitalize(evo2d.getKnownMoveType().getName()));
                        } else {
                            evo2.setKnowsAMoveType(null);
                        }
                        if (evo2d.getKnownMove() != null) {
                            evo2.setKnowsMove(WordUtils.capitalize(evo2d.getKnownMove().getName()));
                        } else {
                            evo2.setKnowsMove(null);
                        }
                        if (evo2d.getGender() != null) {
                            evo2.setGender(evo2d.getGender());
                        } else {
                            evo2.setGender(null);
                        }
                        if (!evo2d.getTimeOfDay().isEmpty()) {
                            evo2.setTimeOfDay(WordUtils.capitalize(evo2d.getTimeOfDay()));
                        } else {
                            evo2.setTimeOfDay(null);
                        }
                        if (evo2d.getPartySpecies() != null) {
                            evo2.setNeedsPokemonInParty(WordUtils.capitalize(evo2d.getPartySpecies().getName()));
                        } else {
                            evo2.setNeedsPokemonInParty(null);
                        }
                        if (evo2d.getPartyType() != null) {
                            evo2.setNeedsPartyPokemonType(WordUtils.capitalize(evo2d.getPartyType().getName()));
                        } else {
                            evo2.setNeedsPartyPokemonType(null);
                        }
                        if (evo2d.getRelativePhysicalStats() != null) {
                            evo2.setPhysStats(evo2d.getRelativePhysicalStats());
                        } else {
                            evo2.setPhysStats(null);
                        }
                        if (evo2d.getTradeSpecies() != null) {
                            evo2.setTradeWithPokemon(WordUtils.capitalize(evo2d.getTradeSpecies().getName()));
                        } else {
                            evo2.setTradeWithPokemon(null);
                        }
                        if (evo2d.getNeedsOverworldRain()) {
                            evo2.setNeedsToBeRaining(true);
                        } else {
                            evo2.setNeedsToBeRaining(false);
                        }
                        if (evo2d.getTurnUpsideDown()) {
                            evo2.setHaveDeviceUpsideDown(true);
                        } else {
                            evo2.setHaveDeviceUpsideDown(false);
                        }
                        if (evo2d.getLocation() != null) {
                            evo1.setLocations(WordUtils.capitalize(evo2d.getLocation().getName()));
                        } else {
                            evo2.setLocations(null);
                        }
                        evols.add(evo2.toString());
                    }
                }
            }
        }

        else {
            evols = null;
        }
        return evols;
    }
}