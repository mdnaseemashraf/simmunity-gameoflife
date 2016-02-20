package simmunityai;

import java.util.*;
import java.io.*;
/**
 *
 * @author MD Naseem Ashraf
 */
public class cmdsClass {

    public static void ChkCmd(String ch)
    {
        Scanner inx = new Scanner(System.in);

        //EXITING THE TERMINAL
        if(ch.equalsIgnoreCase("Exit")||ch.equalsIgnoreCase("Quit"))
            {                
                System.out.println("Enter Y to confirm Exit else enter N.");
                System.out.printf(">> ");   ch = inx.nextLine();
                if(ch.equalsIgnoreCase("Y"))
                {                                        
                    System.out.println("Exiting...");   System.exit(0);
                }
            }

        //CLEAR TERMINAL DISPLAY
        else if(ch.equalsIgnoreCase("Clear")||ch.equalsIgnoreCase("cls"))   
        {    for(int kx = 1; kx<100; kx++)    System.out.println();   }        

        //RUN RANDOM SIMULATION
        else if(ch.equals("Run"))
        {
            System.out.println("Do you Want to run a random simulation? Enter Y for Yes.");
                System.out.printf(">> ");   ch = inx.nextLine();
                if(ch.equalsIgnoreCase("Y"))
                {
                    System.out.println("Enter Dimensions X:");
                    System.out.printf(">> ");   int chx = inx.nextInt();
                    System.out.println("Enter Dimensions Y:");
                    System.out.printf(">> ");   int chy = inx.nextInt();
                    System.out.println("Enter Number of Steps to Simulate:");
                    System.out.printf(">> ");   int chz = inx.nextInt();                    

                    try
                    {
                        RandomSimmunity.RandomSim(chx,chy,chz); //Call RandomSim method
                        //RandomSimmunity.createUniverse(chx,chy); //Write Universe Dimensions for MATLAB
                    }
                    catch (IOException e)
                    {}
            }
        }//End of Run Command

        //RUN RANDOM SIMULATION SLOW
        else if(ch.equals("Runx"))
        {
            System.out.println("Running a Random Simulation::");
            System.out.println("Enter Dimensions X:");
            System.out.printf(">> ");   int chx = inx.nextInt();
            System.out.println("Enter Dimensions Y:");
            System.out.printf(">> ");   int chy = inx.nextInt();
            System.out.println("Enter Number of Steps to Simulate:");
            System.out.printf(">> ");   int chz = inx.nextInt();

            try
            {
                RandomSimmunity.RandomSimSlow(chx,chy,chz); //Call RandomSim method
                //RandomSimmunity.createUniverse(chx,chy); //Write Universe Dimensions for MATLAB
            }
            catch (IOException e)
            {}
        }//End of Run Command
        
    }//End Method Check Command    
}
