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

# Solution to the problem
