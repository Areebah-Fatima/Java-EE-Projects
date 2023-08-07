//Read ME

// Shopping Cart Project Content

- ShopCartClient
	- Click src -> java -> shopcartclient -> Main.java
	- These files are responsible for the client side of the application. Its code is mostly responsible for setting up and creating the javafx GUI
		- Creates Combo-box, Labels, Textfields, Buttons. Uses the EJB to call functions such as AddToCart and PlaceOrder. Then it sets up and manipulates the stage.

- ShopCartEntApplication
	- Click ShopCartEntApplication-ejb -> src -> java -> ShopBEAN -> ShopCartBean.java
	- This File contains our so called "business logic". Or in other words the contents of our AddToCart, PlaceOrder, getList, and exit methods. (has Stateful EJB)

- ShopCartLib
	- Click src -> ShopBEAN -> ShopCartBeanRemote.java
	- This File contains the ShopCartBeanRemote Remote Interface. It simply contains the functions AddToCart, PlaceOrder, getList, and exit.


Both folders have the nbproject/private & root/dist items removed from their folders. My Laptop was having issues with running those files after the deletion of those items so I did the following on the NetBeans IDE:

1) Build class library and click Update on the pop up message
2) Build Client and click Update on the pop up message
3) Build EntApp-ejb and click Update on the pop up message
4) Right click EntApp-ejb, click properties, select run, add the glass fish server
