# Adventure Game API

A nail-biting fantasy adventure, in a world full of dangerous creatures!

Set out on an action packed quest with the hero Frodo as he journeys through forests, mountains and caves, as he battles deadly monsters for their gold to acquire the strongest weapon and defeat the mighty troll.




# Project Overview

Bright Network Technology Academy have tasked the team at Electronic Otters (EO Games) to produce an API which uses Spring boot and SQL within Java, so the team have embarked on a new project to deliver an exciting text-based adventure game with turn based combat against monsters.

# Table of Contents 

- [Setup](#setup)
- [How to play](#how-to-play)
- [Project structure](#project-structure)
- [Further extensions / considerations](#further-extensions--considerations)



# Setup 


1. First ensure that Java 17 is installed to run the game.
2. Clone this repository by clicking the green 'code' sign on top of this page. Click the SSH key and type in your terminal the following: `git clone "git@github.com:bendesousa/backend_project.git"`.
3. Open up and run the file in IntelliJ.
4. Make sure you have SQL downloaded and a database created through Terminal with the command: `createdb adventure_game.`
5. Open up Postman to start the requests.

# How to play

1. First create a POST request for a new player. 
2. Create a POST request for a new game. 
3. send a GET request to the shop to see all weapons.
4. send a PATCH request to the player to buy a weapon.
5. to start a battle send a GET request  
6. To attack the monster send a PATCH request
7. After defeating the monster, send a final PATCH request to receive your gold.
8. Feel free to head back to the shop, or start a new battle.
9. There are a total of three battles to beat to win the game with increasing difficulty.

## Request Paths:

This table shows all possible requests aswell as an example of their path variable and/or parameters

| HTTP Request Paths | Request Type | Description |
|:---:|:---:|:---:|
| .../players?name=frodo | POST | Post the player |
| .../players | GET | Gets the player |
| .../players/1 | GET | Gets the player by their ID |
| .../shops | GET | Shows the shop |
| .../players?playerId=1&weaponId=1 | PATCH | Allows player to buy a weapon |
| .../games?playerId=1 | POST | Posts a new game by their ID |
| .../games | GET | Gets the game |
| .../games/1 | GET | Gets the game by ID |
| .../games/combat?battleId=1 | GET | Gets the player to start the battle  |
| .../games/1?battleId=1 | PATCH | Gets the player to attack |


## Postman:

<p align="center">

</p>

![alt text](postman.png)


Using postman we can ensure that our game runs as we initially planned. We can use http requests to get automated responses. It is also our way of testing each command and debugging where necessary.




# Project structure

<p align="center">
The UML Diagram for our Project
</p>

![alt text](backend_UML.jpg)



<p align="center">
The ERD Diagram for our Project
</p>

![alt text](backend_ERD.jpg)



# Further extensions / considerations

-  Our initial idea for this project was to have only one game running at a time. Therefore we did not finish the code for playing a new game. There are bugs related to winning the game for a 2nd player and buying a weapon that another player owns.

- To make the game more interactive, our next extension would have been to provide the player the option to "block" as well as "attack"



