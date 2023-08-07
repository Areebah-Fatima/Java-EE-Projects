/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

// imports
import EJB.SurveyBean;
import entity.Survey;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.ejb.EJB;
import javax.validation.Valid;

/**
 *
 * @author areebah
 */

@Named(value = "cDISurveyBean")
@SessionScoped
public class CDISurveyBean implements Serializable {

    
    @EJB
    private SurveyBean surveyEJB;
    private String result;
    private Survey survey = new Survey();
    
    public CDISurveyBean() {
    }
    
    // getter setters
    public SurveyBean getSurveyEJB() {
        return surveyEJB;
    }

    public void setSurveyEJB(SurveyBean surveyEJB) {
        this.surveyEJB = surveyEJB;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    
    // function to persist all survey attributes to database
    public String addSurvey(){
        
        surveyEJB.persist(survey);
        result = "Thanks For Your Contributions!";
        return "Pg7.xhtml";
    }
    
    public void editDate(Date dates) {
	  survey.setDateOfVisit(dates);
    }

    // performs date validation
    public String checkDate(Date given){
        
        // stores current date 
        LocalDate currentDate = LocalDate.now();
        
        // date from 7 days prior
        LocalDate currentDateMinus7Days = currentDate.minusDays(7);
        
        
        LocalDate localDate = given.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // if true date is beyond 7 days prior and we need to display an error page else continue with survey
        if(localDate.isBefore(currentDateMinus7Days)){
            
            return "ErrorPage.xhtml";
            
        }
        else{
        
            return "Pg2.xhtml";
        
        }

    }
}
