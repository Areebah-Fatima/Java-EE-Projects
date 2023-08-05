
package BEAN;

// Imports
import javax.ejb.Stateless;

/**
 *
 * @author areebah
 */

@Stateless
public class CalculatorLoanBean implements CalculatorLoanBeanRemote {

   // This function will calculate the Monthly Payment amount
    @Override
    public double MonthlyPayment(double annualInterestRate, int numberOfYears,
      double loanAmount) {

        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment; 
    
    }

    // This function will calculate the total Payment amount
    @Override
    public double TotalPayment(double monthlyPayment, int numberOfYears) {
        
        double totalPayment = monthlyPayment * numberOfYears * 12;
        return totalPayment;    
  }
    
}
