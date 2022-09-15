# Adventure Game API

A nail-biting fantasy adventure, in a world full of dangerous creatures!

Set out on an action packed quest with the hero Frodo as he journeys through forests, mountains and caves, as he battles deadly monsters for their gold to acquire the strongest weapon and defeat the mighty troll.




# Project Overview

Bright Network Technology Academy have tasked the team at Electronic Otters (EO Games) to produce an API which uses Spring boot and SQL within Java, so the team have embarked on a new project to deliver an exciting text-based adventure game with turn based combat. This is a text-based adventure game where the player fights turn-based battles against monsters.

# Table of Contents 

- [Setup](#setup)
- [How to play](#how-to-play)
- [Project structure](#project-structure)
- [Further extensions / considerations](#further-extensions--considerations)



# Setup 


1. First ensure that Java 17 is installed to run the game.
2. Clone this repository by clicking the green 'code' sign on top of this page. Click the SSH key and type in your terminal the following: git clone "the SSH key".
3. Open up and run the file in IntelliJ.
4. Open up Postman to start the requests.

# How to play

## Request Paths:
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 5px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
.tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}
.tg .tg-dvpl{border-color:inherit;text-align:right;vertical-align:top}
.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}
</style>
<table class="tg">
<thead>
  <tr>
    <th class="tg-dvpl">HTTP Request Paths</th>
    <th class="tg-c3ow">Request Type</th>
    <th class="tg-c3ow">Description</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-dvpl">.../players?</td>
    <td class="tg-c3ow">POST</td>
    <td class="tg-0pky">Post the player</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../players</td>
    <td class="tg-c3ow">GET</td>
    <td class="tg-0pky">Gets the player</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../players/1</td>
    <td class="tg-c3ow">GET</td>
    <td class="tg-0pky">Gets the player by their ID</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../games?playerId=1</td>
    <td class="tg-c3ow">POST</td>
    <td class="tg-0pky">Posts a new game by their ID</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../shops</td>
    <td class="tg-c3ow">GET</td>
    <td class="tg-0pky">Shows the shop</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../players?playerId=1&amp;weaponId=1</td>
    <td class="tg-c3ow">PATCH</td>
    <td class="tg-0pky">Allows player to buy a weapon</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../games</td>
    <td class="tg-c3ow">GET</td>
    <td class="tg-0pky">Gets the game</td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../games/combat?battleId=1</td>
    <td class="tg-c3ow">GET</td>
    <td class="tg-0pky">Gets the player to start the battle </td>
  </tr>
  <tr>
    <td class="tg-dvpl">.../games/1?battleId=1</td>
    <td class="tg-c3ow">PATCH</td>
    <td class="tg-0pky">Gets the player to attack</td>
  </tr>
</tbody>
</table>

## Postman:

(pic)

Using postman we can ensure that our game runs as we initially planned. We can use http requests to get automated responses. It is also our way of testing each command and debugging where necessary.




# Project structure


# Further extensions / considerations

- Currently, only one game can be running at a time. This could be 

- To make the game more interactive, our nexte extension would have been to provide the player the option to "block" aswell as "attack"

