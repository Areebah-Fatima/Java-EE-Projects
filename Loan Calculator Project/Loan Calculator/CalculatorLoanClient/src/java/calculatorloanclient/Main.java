
package calculatorloanclient;

// Imports
import BEAN.CalculatorLoanBeanRemote;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.text.*;

/**
 *
 * @author Areebah Fatima
 * This File creates a GUI client in JavaFX to use the EJB for loan calculations 
 *  of monthly payment and total payment
 */


public class Main extends Application { 

   @javax.ejb.EJB
    private static CalculatorLoanBeanRemote calculatorLoanBean;

 
   @Override 
   public void start(Stage stage) {      
      
      // Creating labels (just text) 
      Label labelInterest = new Label("Annual Interest Rate");       
      
      Label labelYears = new Label("Number Of Years"); 
      
      Label labelAmount = new Label("Loan Amount"); 
	
      // Monthly Payment
      Label lblMonthlyResult = new Label(""); 
      
      // Total payment
      Label lblTotal = new Label(""); 
      
      //Creating Text Field for Annual Interest Rate, Number Of Years, Loan Amount  
      TextField txtRate = new TextField();     
      TextField txtYears = new TextField(); 
      TextField txtAmount = new TextField(); 
      
       
      //Creating Buttons
      
  
      Button calcButton = new Button("Calculate"); 

      // What will occur when the button is pressed
      calcButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                       
                // Store data entered in textfields
                double rate = Double.parseDouble(txtRate.getText());
                int years = Integer.parseInt(txtYears.getText());
                double amount = Double.parseDouble(txtAmount.getText());
                       
                // This will format our end results to 2 decimal places
                DecimalFormat df = new DecimalFormat("#################.##");
                       
                // Use Ejb, call our monthly and total payment functions, store result
                double monthly = calculatorLoanBean.MonthlyPayment(rate, years, amount);
                double total = calculatorLoanBean.TotalPayment(monthly, years);
                       
                // Set the lables to hold a "message" on GUI that will show the formatted result
                lblMonthlyResult.setText("Monthly Payment:      " + df.format(monthly));
                lblTotal.setText("Total Payment:     " + df.format(total));
             }
        });
      
      
      Button btnExit = new Button("Exit");
        
        // What will occur when the button is pressed
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override 
            public void handle(ActionEvent e) {
              
              // Print goodbye message and close window
              System.out.println("Goodbye!");
              stage.close();
            }
        });
      
      // Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      // Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      // Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      // Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      // Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      // Arranging all the nodes in the grid 
      // col, row
      
      gridPane.add(labelInterest, 0, 0); 
      gridPane.add(labelYears, 0, 1); 
      gridPane.add(labelAmount, 0, 2); 
      
      
      gridPane.add(txtRate, 1, 0); 
      gridPane.add(txtYears, 1, 1); 
      gridPane.add(txtAmount, 1, 2); 
     
      gridPane.add(lblMonthlyResult, 0, 6);
      gridPane.add(lblTotal, 0, 7);  
      gridPane.add(calcButton, 1, 3);
      gridPane.add(btnExit, 1, 4);

      
      // Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      // Setting title to the Stage 
      stage.setTitle("Loan Calculator"); 
         
      // Adding scene to the stage 
      stage.setScene(scene); 
         
      // Displaying the contents of the stage 
      stage.show(); 
   } 
   
   public static void main(String args[]){ 
      launch(args); 
   } 
  
} 
