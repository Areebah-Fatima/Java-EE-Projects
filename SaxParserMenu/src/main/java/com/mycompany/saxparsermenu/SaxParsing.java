// By: Areebah Fatima
package com.mycompany.saxparsermenu;

// Imports
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class SaxParsing extends DefaultHandler {

    
  private List<Food> foodList = new ArrayList<>();
  private Food foodItem;
  
  // Buffer for tags
  private Boolean dealingWithName = false;
  private StringBuffer nameBuffer;
  
  private Boolean dealingWithDescription = false;
  private StringBuffer descriptionBuffer;
  
  private Boolean dealingWithCalories = false;
  private StringBuffer calorieBuffer;
  
  private Boolean dealingWithPrice = false;
  private StringBuffer priceBuffer;

  public List<Food> parse() {

    try {
        
      // Path to xml doc
      File xmlDocument = Paths.get("src/main/java/com/mycompany/saxparsermenu/menu.xml").toFile();
      // SAX Factory
      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      // Parsing the document
      saxParser.parse(xmlDocument, this);
    } catch (SAXException | IOException | ParserConfigurationException e) {
      e.printStackTrace();
    }
    return foodList;
  }

  @Override
  public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attrs) throws SAXException {

    // Switch structure based on qualifiedName (food, name, etc) 
    switch (qualifiedName) {
      // Getting the order_line node
      case "food":
        foodItem = new Food();
        break;
      case "name":
        dealingWithName = true;
        nameBuffer = new StringBuffer();
        break;
      case "price":
        dealingWithPrice = true;
        priceBuffer = new StringBuffer();
        break;
      case "description":
        dealingWithDescription = true;
        descriptionBuffer = new StringBuffer();
        break;
      case "calories":
        dealingWithCalories = true;
        calorieBuffer = new StringBuffer();
        break;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
      
    // If the start element set any of the if to true it means we need to add to the appropriate buffer
    if (dealingWithName){
      nameBuffer.append(ch, start, length);}
    if (dealingWithPrice){
      priceBuffer.append(ch, start, length);}
    if (dealingWithDescription){
      descriptionBuffer.append(ch, start, length);}
    if (dealingWithCalories){
      calorieBuffer.append(ch, start, length);}
  }

  @Override
  public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {

    // Switch structure to set values, print them, and set flags back to false
    switch (qualifiedName) {
      case "food":
        foodList.add(foodItem);
        break;
      case "name":
        foodItem.setName(String.valueOf(nameBuffer.toString()));
        System.out.println("Name: " + String.valueOf(nameBuffer.toString()));
        dealingWithName = false;
        break;
      case "description":
        foodItem.setDescription(String.valueOf(descriptionBuffer.toString()));
        System.out.println("Description: " + String.valueOf(descriptionBuffer.toString()));
        dealingWithDescription = false;
        break;
      case "price":
        foodItem.setPrice(String.valueOf(priceBuffer.toString()));
        System.out.println("Price: " + String.valueOf(priceBuffer.toString()));
        dealingWithPrice = false;
        break;
      case "calories":
        foodItem.setCalories(Integer.valueOf(calorieBuffer.toString()));
        System.out.println("Calories: " + Integer.valueOf(calorieBuffer.toString()) + "\n ");
        dealingWithCalories = false;
        break;
    }
  }
  
    public static void main(String[] args) {
        
         SaxParsing parser = new SaxParsing();
         List<Food> list = parser.parse();
    
        
    }
}