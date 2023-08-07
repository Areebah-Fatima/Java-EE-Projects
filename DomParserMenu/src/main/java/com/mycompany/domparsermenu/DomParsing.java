// By: Areebah Fatima
package com.mycompany.domparsermenu;

// Imports
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DomParsing {

  // DOM Parsing Function
  public List<Food> parse() {

    List<Food> foodList = new ArrayList<>();

    try {
        
      // Path to xml document
      File xmlDocument = Paths.get("src/main/java/com/mycompany/domparsermenu/menu.xml").toFile();

      // DOM Factory
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      // Parsing the document
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();
      Document document = documentBuilder.parse(xmlDocument);

      // Getting the food node
      NodeList foodListNode = document.getElementsByTagName("food");
      for (int i = 0; i < foodListNode.getLength(); i++) {
        Element foodItemNode = (Element) foodListNode.item(i);
        Food foodItem = new Food();
        
        // Get node for food item name and print it
        Node nameNode = foodItemNode.getChildNodes().item(1);
        foodItem.setName(String.valueOf(nameNode.getFirstChild().getNodeValue()));
        System.out.println("Name: " + String.valueOf(nameNode.getFirstChild().getNodeValue()));
        
        // Get node for food item price (using tag) and print it
        Node priceNode = foodItemNode.getElementsByTagName("price").item(0);
        foodItem.setPrice(String.valueOf(priceNode.getFirstChild().getNodeValue()));
        System.out.println("Price: " + priceNode.getTextContent());
        
        // Get node for food item description (using tag) and print it
        Node descriptionNode = foodItemNode.getElementsByTagName("description").item(0);
        foodItem.setDescription(String.valueOf(descriptionNode.getFirstChild().getNodeValue()));
        System.out.println("Description: " + descriptionNode.getTextContent());
        
        // Get node for food item calories (using tag) and print it
        Node caloriesNode = foodItemNode.getElementsByTagName("calories").item(0);
        foodItem.setCalories(Integer.valueOf(caloriesNode.getFirstChild().getNodeValue()));
        System.out.println("Calories: " + caloriesNode.getTextContent() + "\n");
        
        foodList.add(foodItem);
      }

    } catch (SAXException | IOException | ParserConfigurationException e) {
      e.printStackTrace();
    }
    return foodList;
  }
  
      public static void main(String[] args) {
        
         DomParsing parser = new DomParsing();
         List<Food> list = parser.parse();
        
        
    }
}
