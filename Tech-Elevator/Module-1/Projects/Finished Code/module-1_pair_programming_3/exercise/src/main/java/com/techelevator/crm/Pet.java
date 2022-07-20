package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;

public class Pet {                                                                  //Step Four Pt1 - Create the Pet class
    private String name;                                                            //Step Four Pt2 - Property name (Name of pet)
    private String species;                                                         //Step Four Pt2 - Property species (species of pet)
    private List<String> vaccinations = new ArrayList<>();                          //Step Four Pt2 - Property vaccinations (Vaccinations the pet has received)

    public Pet(String name, String species) {                                       //Step Four Pt3 - Constructor (accepts name and species as Strings)
        this.name = name;
        this.species = species;
    }

    public String listVaccinations() {                                              //Step Four Pt4 - Method for listVaccinations
        String result = "";                                                     //Create a String variable
        for (String vaccination : vaccinations) {                               //List through the list elements
            result += vaccination + ", ";                                       //Add a comma to the String
        }
        result = result.substring(0, result.length() - 2);                      //Check if
        return result;                                                          //Return the String
    }

    public String getName() {                                                       //Step Four Pt2 - Getter for name
        return name;
    }

    public void setName(String name) {                                              //Step Four Pt2 - Setter for name
        this.name = name;
    }

    public String getSpecies() {                                                    //Step Four Pt2 - Getter for species
        return species;
    }

    public void setSpecies(String species) {                                        //Step Four Pt2 - Setter for species
        this.species = species;
    }

    public List<String> getVaccinations() {                                         //Step Four Pt2 - Getter for vaccinations
        return vaccinations;
    }

    public void setVaccinations(List<String> vaccinations) {                        //Step Four Pt2 - Setter for vaccinations
        this.vaccinations = vaccinations;
    }

}
