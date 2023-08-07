
package com.mycompany.domparsermenu;

public class Food {

    private String name;
    private String price;
    private String description;
    private Integer calories;

    //Constructors
    public Food() {
    }

    public Food(String name, String price, String description, Integer calories) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;

    }

    //Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

}