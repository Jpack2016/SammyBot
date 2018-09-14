package com.somejakeguy.sammybot.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.text.WordUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

public class MessageUtils {

    /**
     * Tries to parse the integer from the string given
     * @param value     String that contains an integer
     * @return boolean  Returns true or false depending on if the string is a number or not
     */
    public boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Defines the word or phrase using the Urban Dictionary API.
     * Makes a request to the api and returns JSONObject or and empty JSON string
     * @param word  word or phrase given by the user to be defined by Urban Dictionary
     * @return definition   String defintion of the word or phrase, including likes/dislikes and author
     */
    public String defineWord(String word){

        try {
            URL url = new URL("http://api.urbandictionary.com/v0/define?term=" + URLEncoder.encode(word, "UTF-8"));
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            JsonParser jp = new JsonParser();
            JsonObject obj = (JsonObject) jp.parse(reader);

            reader.close();
            JsonArray list = (JsonArray) obj.get("list");

            if(list.size() == 0)
                return "No Urban Dictionary Definition Found!";

            JsonObject listel = (JsonObject) list.get(0);

            return "Word: " + WordUtils.capitalize(word.toLowerCase()) +"\n"
                    + "Definition: " + listel.get("definition").toString().replaceAll("\\\\r\\\\n","\n") + "\n"
                    + "Author: " + listel.get("author") + "\n"
                    + "Likes: " + listel.get("thumbs_up") + "\n"
                    + "Dislikes: " + listel.get("thumbs_down");
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Urban Dictionary Error!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Urban Dictionary Error!";
        }
    }

    /**
     * Handler for messages that exceed Discord's 2000 character limit!
     * As part of Discord's spam handler, it rejects messages larger then 2000 characters, so this must be split into multiple messages!
     * Goes back to the nearest space character to avoid cutting off a word
     * Recursively checks input message until it can no longer be broken up!
     * @param commandresult String result of the command to be broken up into smaller messages (if possible)
     * @param lines     List<String> List of current messages that have been broken up already!
     * @return messages List<String> List of messages to be replied to the user who typed the command!
     */
    public List<String> commandlines(String commandresult, List<String> lines){
        if(commandresult.length() < 2000) {
            lines.add(commandresult);
            return lines;
        }

        else {
            char c = commandresult.charAt(1999);
            int j = 1999;

            while(!(c == ' ')){
                c = commandresult.charAt(j);
                j--;
            }

            lines.add(commandresult.substring(0, j));
            commandlines(commandresult.substring(j), lines);
        }

        return lines;
    }
}
