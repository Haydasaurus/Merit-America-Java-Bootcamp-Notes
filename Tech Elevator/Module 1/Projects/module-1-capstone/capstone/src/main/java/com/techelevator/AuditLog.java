package com.techelevator;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLog {

    public static Money money = new Money();
    static ShoppingCart shoppingCart = new ShoppingCart();

    //AUDIT LOG
    public static void log(String action, double actionAmount, double newTotal) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        String formatDateAndTime = now.format(formatter);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Log.txt", true))) {
            pw.println(">" + formatDateAndTime + " " + action + " " + VendingProducts.nf.format(actionAmount) + " " + VendingProducts.nf.format(newTotal));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //NEEDS WORK
    //SALES REPORT
    public static void salesReport(String name, Integer total) {

        //we need this to create a new txt file each time that displays [SalesReport + date + time]
        //each sales report needs to have it's own name

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        String formatDateAndTime = now.format(formatter);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(System.getProperty("user.dir") + "\\SalesReport.txt", true))) {
            pw.println(name+"|"+total);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    //this works alongside our SALES REPORT
    public static void printSalesTotal() {

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(System.getProperty("user.dir") + "\\SalesReport.txt", true))) {
            pw.println("TOTAL SALES: \r\n"+VendingProducts.nf.format(money.getTotal()-money.getCurrentMoney()));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
