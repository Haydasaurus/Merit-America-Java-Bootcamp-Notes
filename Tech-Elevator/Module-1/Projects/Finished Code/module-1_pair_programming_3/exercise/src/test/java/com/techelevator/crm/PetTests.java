package com.techelevator.crm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests {

    @Test
    public void listVaccinations_First() {

        Pet sut = new Pet("Frank", "Pug");
        List<String> vaccines = new ArrayList<>();
        vaccines.add("Rabies");
        vaccines.add("Distemper");
        vaccines.add("Parvo");

        sut.setVaccinations(vaccines);
        String vaccinations = sut.listVaccinations();

        Assert.assertEquals("Rabies, Distemper, Parvo", vaccinations);
    }

    @Test
    public void listVaccinations_Second() {

        Pet sut = new Pet("Kodak", "Corgi");
        List<String> vaccines = new ArrayList<>();
        vaccines.add("Rabies");
        vaccines.add("Distemper");

        sut.setVaccinations(vaccines);
        String vaccinations = sut.listVaccinations();

        Assert.assertEquals("Rabies, Distemper", vaccinations);
    }

    @Test
    public void listVaccinations_Third() {

        Pet sut = new Pet("Minnie", "Minpin");
        List<String> vaccines = new ArrayList<>();
        vaccines.add("Rabies");

        sut.setVaccinations(vaccines);
        String vaccinations = sut.listVaccinations();

        Assert.assertEquals("Rabies", vaccinations);
    }

}