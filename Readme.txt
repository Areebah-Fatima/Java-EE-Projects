//Read ME

// Loan Calculator Project Content

- CalculatorLoanClient
	- Click src -> java -> calculatorloanclient -> Main.java
	- These files are responsible for the client side of the application. Its code is mostly responsible for setting up and creating the javafx GUI
		- Creates Labels, Textfields, Buttons. Uses the EJB to call functions such as MonthlyPayment and TotalPayment. Then it sets up and manipulates the stage.

- CalculatorLoanEnterpriseApplication
	- Click CalculatorLoanEnterpriseApplication-ejb -> src -> java -> BEAN -> CalculatorLoanBean.java
	- This File contains our so called "business logic". Or in other words the contents of our MonthlyPayment and TotalPayment methods. (has Stateless EJB)

- CalculatorLoanClassLib
	- Click src -> BEAN -> CalculatorLoanBeanRemote.java
	- This File contains the CalculatorLoanBeanRemote Remote Interface. It simply contains the functions MonthlyPayment and TotalPayment.


Both folders have the nbproject/private & root/dist items removed from their folders. My Laptop was having issues with running those files after the deletion of those items so I did the following on the NetBeans IDE:

1) Build class library and click Update on the pop up message
2) Build Client and click Update on the pop up message
3) Build EntApp-ejb and click Update on the pop up message
4) Right click EntApp-ejb, click properties, select run, add the glass fish server
