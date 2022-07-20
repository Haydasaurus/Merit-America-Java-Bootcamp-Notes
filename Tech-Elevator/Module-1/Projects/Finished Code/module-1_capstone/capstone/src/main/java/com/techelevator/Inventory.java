package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    String path = "capstone/vendingmachine.csv";
    File inventoryFile = new File(path);

    VendingProducts vendingProducts = new VendingProducts();

    public static List<VendingProducts> productsList = new ArrayList<>();

    public Inventory() {}

    public void createInventory(){
        try(Scanner fileInput = new Scanner(new File(String.valueOf(inventoryFile)))) {
            while(fileInput.hasNextLine()){
                String[] eachItem = fileInput.nextLine().split("\\|");
                // puts each object into VendingProducts(slotId|name|parsed(price)|category, inventory)
                vendingProducts = new VendingProducts(eachItem[0],eachItem[1], Double.parseDouble(eachItem[2]), eachItem[3], vendingProducts.inventory);
                productsList.add(vendingProducts);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayProducts(){
        for(VendingProducts products :productsList){
            System.out.println(products);
        }
    }
    public static List<VendingProducts> getProductsList() {
        return productsList;
    }

    public static void setProductsList(List<VendingProducts> productsList) {
        Inventory.productsList = productsList;
    }
}