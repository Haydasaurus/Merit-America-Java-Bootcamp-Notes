package com.techelevator;

import java.util.*;

public class Money extends Inventory implements Purchasable {
    ShoppingCart shoppingCart = new ShoppingCart();

    final int MAX_INVENTORY = 5;
    boolean feedMore;

    //wallet is the "customers spendable money"
    public static List<Double> wallet = new ArrayList<>();

    public static void setWallet(List<Double> wallet) {
        Money.wallet = wallet;
    }

    //purchased are the items the customer has selected
    public static List<VendingProducts> purchased = new ArrayList<>();

    static Map<String, Integer> salesReport = new HashMap<>();
    static double currentMoney;

    public Money() {}

    public double getCurrentMoney(){
        currentMoney=getTotal();
        for(VendingProducts vendingProducts: purchased){
            currentMoney = currentMoney - vendingProducts.price;
        }
        return currentMoney;
    }

    //works in feedMoney and makePurchase
    public String remainingBalance(String message) {
        double remainder = getCurrentMoney();
        return message + " " + VendingProducts.nf.format(remainder);
    }

    @Override
    public double getTotal() {
        double money = 0;
        for (Double monies : wallet) {
            money += monies;
        }
        return money;
    }

    public void feedMoney() {
        feedMore = true;
        while(feedMore) {
            double monies = 0;
            System.out.println("Bills only [ $1 | $2 | $5 | $10 ]");
            Scanner usInp = new Scanner(System.in);
            try{
                monies = usInp.nextDouble();
            } catch (Exception e) {
                System.out.println("Not a valid input.\nLet's try again.");
                feedMore=false;
                break;
            }
            if (monies == 1 || monies == 2 || monies == 5 || monies == 10) {
                wallet.add(monies);
                System.out.println("Current Money Provided: " + VendingProducts.nf.format(getCurrentMoney()));
                //AUDIT LOG
                try{
                    AuditLog.log("FEED MONEY:", monies, getCurrentMoney());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.print("Would you like to add more?[Y or N]"+"\n");
                Scanner input = new Scanner(System.in);
                try{
                    String yOrN = input.nextLine();
                    if (yOrN.equalsIgnoreCase("y")) {
                        feedMoney();
                    }else feedMore=false;
                } catch (Exception e) {
                    System.out.println("Not a valid input");
                }
            }else if(monies!=1 || monies!=2 || monies!=5||monies!=10) {
                System.out.println("Sorry, we don't accept "+ VendingProducts.nf.format(monies) +".\r\nWhatever THAT is.");
                feedMoney();
            }
        }
    }

    //this keeps track of current vending products price
    public double getMoneyTracker(double moneyTracker){
        double sum=0;
        sum+=moneyTracker;
        return sum;
    }

    //could use work
//    public void makePurchase() {
//        String choice = "";
//        System.out.println("Please make a selection");
//        Scanner input = new Scanner(System.in);
//        try {
//            choice = input.nextLine();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        double currentMoney = getCurrentMoney();
//        double localMoneyTracker = 0;
//
//        if(!doesSlotIDExist(choice)){
//        }
//
//        for (VendingProducts vendingProducts : productsList) {
//
//
//            if ((vendingProducts.slotId.equalsIgnoreCase(choice) && (vendingProducts.inventory > 0))) {
//                localMoneyTracker += getMoneyTracker(vendingProducts.price);
//
//                if (currentMoney >= localMoneyTracker) {
//                    shoppingCart.addItems(vendingProducts);
//                    purchased.add(vendingProducts);
//                    vendingProducts.inventory--;
//                    //prints specific categories "fun word"
//                    System.out.println(vendingProducts.toStringCategory(vendingProducts.category));
//                    //prints products name and how many remaining
//                    System.out.println(vendingProducts.name + " | " + VendingProducts.nf.format(vendingProducts.price) + " | " + vendingProducts.inventory + " remaining.");
//                    System.out.println(remainingBalance("Your remaining balance is:"));
//                }
//                if (!vendingProducts.isInStock()) {
//                    System.out.println(vendingProducts.name + " | " + "is SOLD OUT");
//                }
//            }
//            else if (localMoneyTracker > currentMoney) {
//                System.out.println("Oh, no.. This isn't a charity.\nYou are " + VendingProducts.nf.format(getCurrentMoney() - vendingProducts.price) + " in the hole with this one.");
//                System.out.println("Would you like to insert more money?[Y or N]");
//                if (input.nextLine().equalsIgnoreCase("y")) {
//                    feedMoney();
//                } else {
//                    break;
//                }
//            }
//        }
//    }


    //SALES REPORT
    //doesn't print ALL items, only the ones that are sold
//                    try{
//                        if (!salesReport.containsKey(vendingProducts.name)) {
//                            salesReport.put(vendingProducts.name, 1);
//                        } else {
//                            salesReport.put(vendingProducts.name, salesReport.get(vendingProducts.name) + 1);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }


//            String auditStringSlotId = vendingProducts.name.concat(" ").concat(vendingProducts.slotId);
////                AuditLog.log(auditStringSlotId, currentMoney, currentMoney - vendingProducts.price);
//            //this might need work
//            try {
//                AuditLog.log(auditStringSlotId, getCurrentMoney() + vendingProducts.price, getCurrentMoney());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

    //this isn't working right, it prints right the first time
    //..then it prints " is a wrong slot number " for each purchase
    //it's because it's iterating over each item,
    // DEBUG
//            else if(!vendingProducts.getSlotId().equalsIgnoreCase(choice)){
//                System.out.println(choice+" is a wrong slot number");
//                break;
//            }

    public void makePurchase() {
        String choice="";
        System.out.println("Please make a selection");
        Scanner input = new Scanner(System.in);

        try{
            choice = input.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        double currentMoney = getCurrentMoney();
        double localMoneyTracker=0;

        for (VendingProducts vendingProducts : productsList) {
            if ((vendingProducts.slotId.equalsIgnoreCase(choice) && (vendingProducts.inventory > 0) )) {
                double moneyTracker = getMoneyTracker(vendingProducts.price);
                localMoneyTracker += moneyTracker;
                if (currentMoney >= localMoneyTracker) {
                    shoppingCart.addItems(vendingProducts);
                    purchased.add(vendingProducts);
                    vendingProducts.inventory--;
                    //prints specific categories "fun word"
                    System.out.println(vendingProducts.toStringCategory(vendingProducts.category));
                    //prints products name and how many remaining
                    System.out.println(vendingProducts.name + " | " + VendingProducts.nf.format(vendingProducts.price) + " | " + vendingProducts.inventory + " remaining.");
                    System.out.println(remainingBalance("Your remaining balance is:"));

                    if (!vendingProducts.isInStock()) {
                        System.out.println(vendingProducts.name + " | " + "is SOLD OUT");
                    }

                    //SALES REPORT
                    //doesn't print ALL items, only the ones that are sold
                    try {
                        if (!salesReport.containsKey(vendingProducts.name)) {
                            salesReport.put(vendingProducts.name, 1);
                        } else {
                            salesReport.put(vendingProducts.name, salesReport.get(vendingProducts.name) + 1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } if (localMoneyTracker > currentMoney) {
                    System.out.println("Oh, no.. This isn't a charity.\nYou are " + VendingProducts.nf.format(getCurrentMoney() - vendingProducts.price) + " in the hole with this one.");
                    System.out.println("Would you like to insert more money?[Y or N]");
                    if (input.nextLine().equalsIgnoreCase("y")) {
                        feedMoney();
                    } else {
                        break;
                    }
                }

                //AUDIT LOG
                try {
                    String auditStringSlotId = vendingProducts.name.concat(" ").concat(vendingProducts.slotId);
                    AuditLog.log(auditStringSlotId, getCurrentMoney() + vendingProducts.price, getCurrentMoney());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

//resets wallet and purchased items
    public void nextCustomerPlease() {
        try{
            AuditLog.log("GIVE CHANGE:",getCurrentMoney(),getCurrentMoney()-getCurrentMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (VendingProducts vp : purchased) {
            vp.inventory = MAX_INVENTORY;
        }
        wallet.clear();
        purchased.clear();
    }

    public void exitedBeforeFinish() {
        try{
            AuditLog.log("PROGRAM EXIT:",getCurrentMoney(),getCurrentMoney()-getCurrentMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (VendingProducts vp : purchased) {
            vp.inventory = MAX_INVENTORY;
        }
        wallet.clear();
        purchased.clear();
    }

    public String returnChange(double currentMoney) {
        double tracker = currentMoney + .01;
        int totalQuartersToReturn = 0;
        int totalDimesToReturn = 0;
        int totalNickelsToReturn = 0;
        double quarter = .25;
        double dime = .10;
        double nickel = .05;
        while (tracker >= 0) {
            if (tracker >= quarter) {
                totalQuartersToReturn++;
                tracker -= quarter;
            } else if (tracker >= dime) {
                totalDimesToReturn++;
                tracker -= dime;
            } else if (tracker >= nickel) {
                totalNickelsToReturn++;
                tracker -= nickel;
            }
            else{
                break;
            }
        }
        return "Change returned:"
                + totalQuartersToReturn
                + " Quarters, "
                + totalDimesToReturn
                + " Dimes, "
                + "and "
                + totalNickelsToReturn
                + " Nickles.";
    }
}
