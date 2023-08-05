
package BEAN;

// Imports
import javax.ejb.Remote;

/**
 *
 * @author areebah
 */
@Remote
public interface CalculatorLoanBeanRemote {

   double MonthlyPayment(double annualInterestRate, int numberOfYears, double loanAmount);
   double TotalPayment(double monthlyPayment, int numberOfYears);
    
}
