//Read ME

- Book.sql
	- Connected on my machine to jdbc:derby://localhost:1527/BookDB
	- This file is responsible for creating and populating the database tables (Author, Book, WrittenBy)

FindBook.zip Content

- FindBooks.java
	- Click src -> java -> find books -> FindBooks.java
	- This file is responsible for:
		- Creating list view, Labels, Buttons. (Javafx GUI)
		- Retrieving and displaying data from databases/data tables 
		- Setting up and manipulates the stage
		- Initializing a database (using connections and a drivermanager)
		- Searching through a data base/ data tables for items that match the user's query

FindBooks.java has the nbproject/private & root/dist items removed from its folders. My Laptop was having issues with running those files after the deletion of those items so I did the following:

1) Build FindBooks (Java Application) click Update on the pop up message
2) Run as normal

There might also be a message when you hover over the cup icon in the projects list saying "save to compile is turned off". To fix this just right click the FindBooks project select properties, the select compiling under the build menu, and finally check box compile on save. 