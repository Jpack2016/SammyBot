# SammyBot
This is a discord bot written in JDA, with the PokeAPI also included. This bot was named after my girlfriend and grabs me Pokemon information when I'm playing games. Written in Java and makes REST calls to urban dictionary API and PokeAPI through PokeKotlin

JDA Information: https://github.com/DV8FromTheWorld/JDA
PokeAPI: http://pokeapi.co

This is a gradle application and was my first project using it. I wrote this in IntelliJ IDEA and add more things as time goes on. I havbe more things planned and will edit as necessary. As stated in the comments, this makes REST calls to Urban Dictionary's API, which has a JSON response, and PokeKotlin, which has different response types based on the information you give it.

I ran this application in a batch file in the same directory as my exported Jar file. The code is in a file called sammybot.exe.txt but the following is the code for it:
java -jar SammyBot-0.1.0.jar
pause

I made container classes for the evolution information of pokemon and pokemon information itself as it was too long on its own and really cluttered the MessageChatListener. 

Some sample Output is here:
![pokestats command](https://i.imgur.com/0kmQVAW.png)
![help command](https://i.imgur.com/Usy4yeX.png)
![define command](https://i.imgur.com/SFf0si0.png)
![console output](https://i.imgur.com/NxwQPMm.png)
![more console output](https://i.imgur.com/ZKdQTab.png)
