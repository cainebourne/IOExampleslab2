/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author L115student
 */
public class Lab2 {
    public static void main(String[] args) {
        File data = new File("src/contactList.txt");
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  System.out.println(line);
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Problem While Reading File");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(data, true)));
        } catch(IOException ioe) {
            System.out.println("Problem While Writing File");
        } finally {
            out.println("Todd Smith");
            out.println("444 Small St.");
            out.println("Delafield, Wisconsin 53018");
            out.println("Peter Francis");
            out.println("555 Awesome St.");
            out.println("Milwaukee, Wisconsin 53172");
            out.close();
        }
        try {
            in = new BufferedReader(new FileReader(data));
            String line = "";
            for (int i = 0; i < 4; i++) {
                line = in.readLine();
            }
            
            in.readLine();
            String cityState = in.readLine();
            String[] locationArray = cityState.split(" ");
            System.out.print(line + " state: " + locationArray[locationArray.length - 2]);
        } catch(IOException ioe) {
            System.out.println("Problem While Reading File");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
        
    }
}
