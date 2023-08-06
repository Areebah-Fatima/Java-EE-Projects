// Read ME

- CarProject.java
	- Click src -> carproject -> CarProject.java
	- Connected on my machine to jdbc:derby://localhost:1527/CarDB
	- This file is responsible for creating three car objects and persisting them to the database

- Car.java
	- Click src -> carproject -> Car.java
	- Connected on my machine to jdbc:derby://localhost:1527/CarDB
	- This file is responsible for the car entity. It has the fields (ID,Make,Model,CarYear) and their getter/setters.

The following file has the nbproject/private & root/dist items removed from its folders. My Laptop was having issues with running those files after the deletion of those items so I did the following:

1) Build CarProject/TestJPARelation2 (Java Application) click Update on the pop up message
2) Run as normal

There might also be a message when you hover over the cup icon in the projects list saying "save to compile is turned off". To fix this just right click the CarProject/TestJPARelation2 project select properties, the select compiling under the build menu, and finally check box compile on save. 