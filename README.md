# COSC2658-GP-POISearch
This is the submission for the RMIT COSC2469 - Algorithm Analysis Group Project assignment 2024. This project is a Point of Interest Search that act similar to Google Maps. Given a bounding rectangle (Top left corner, wigth and height) and type of service (ATM, Restautrants, hospital) return the set of places. Top K will be use if to many places.

# Technical Description
* Map size: 10,000,000 x 10,000,000
* Bounding rectangle: smallest 100 x 100 and biggest 100,000 x 100,000
* Service types up to 10
* Number of places up to 100,000,000
* Maximum places show in the search result: 50
* Euclidient distance is used in this project

A Map2D ADT is created that support:
* Add: add a place to the map. For each place. It will contain it coordinate (X,Y0 and service type. A place can offer multiple services
* Edit: edit a place. Only the services provided can be changed. The X and Y are fixed
* Remove: remove a place
* Search: Search for a list of places and described above.

Assumption: all data entered is valid and requires no validation
Testing: Random-generated data is created to test the work

# Delireables
* A README.txt file that describes the contribution score of all members and contain the link to the project video
* Sources Code: Java
* Technical report: A PDF document that contain:
  * An overview and high-level design of the system
  * The data structure and algorithm we apply or develop (Not restricted to course material). This will describe detail the work of data structure and algorithm
  * Complexity Analysis of the the program
  * Evaluation method and how did we evaluate the efficiency of the system experimentally
  * Conclusion: the advantages and limitations of the system.
* Video demonstration (10-15 minutes) showing how the system work on Youtube and present it URL in the README.txt file.

# Contribution Score
The starting score for each student is 5 points. Each group can decide to add/remove points to/from each member, but the total point of the whole group is kept unchanged (it is = (the number of members) * 5). Additional rules:

The maximum point for a member is 7.
If a member gets zero points => that member gets zero for the whole group project assignment. In this case, the total point of the whole group = (the number of members whose scores > zero) * 5.
The contribution score must be agreed upon by all members. If there are disagreements, you must inform the lecturer/coordinator before the due time.
The maximum score for the whole project is 35. If you get more than 35 (due to a high contribution score), the final score is 35.

# Solution to the problem
1. Checking the edge case of repeated one string for each available characters R,M,I,T. This will also inform us which characters actual make up the code and it frequency
2. Use this to create our first guess by randomly spread our letter to increase the likely hood of being closer to the correct key. Since our guess will contain all correct characters we just need to find out the correct position.
3. Use guess() method to check for our current number of match and move accordingly.
4. We proceed to swap the characters in the key, if it increase or decrease we will lock down the position (if the increase is by 2 we know the )