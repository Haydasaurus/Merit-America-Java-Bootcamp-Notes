package com.techelevator.util;

import java.awt.*;
import java.io.*;
import com.techelevator.util.TELogException;

public class TELog {
    public static void log(String message) throws IOException {
        File dataFile =  new File(System.getProperty("user.dir") + "exercise/logs/search.log");
        try(PrintWriter outPut = new PrintWriter(new FileOutputStream(dataFile,true))){
            outPut.println(message);
        }catch (TELogException e){
            throw new TELogException(e.getMessage());
            // System.err.println(e.getMessage());
        }
    }
}
