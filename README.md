# COSC2658-GP-CodeCracking
This is the submission solution for the RMIT COSC2469 - Algorithm Analysis Group Project assignment 2024. 

# Technical Description
* Given a secret string of 16 characters that consist of either "R", "M", "I", or "T".
* We can only tell how many characters are in the correct position not which characters.
* Guess the secret string

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

# Initial thinking
* This seems to be similar to the bulls & cows algorithm or mastermind algorithm.
* First we can create one letter string and run it to check how many hits did we received. Return the string with highest hit.
* Split the string to two sub-strings. Run each sub-string throught the same process and return new substring that have the highest hit. Recursively split the sub string and repeat the process.
* 
* Psudo code idea:
- Generate multiple strings with one letter select randomly from R, M, I, T.
- Compare hit and take the highest value of hit.
- Split the strings into smaller substring.
- Generate new one letter string that does not contain the same letter and check for hit. Return highest hit.
- Recursively call the function until string hit is the same as string lenght.
