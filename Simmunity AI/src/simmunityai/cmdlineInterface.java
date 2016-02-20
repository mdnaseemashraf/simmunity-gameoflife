package simmunityai;

import java.util.*;
/**
 *
 * @author MD Naseem Ashraf
 */
public class cmdlineInterface {

    public static void main(String[] args) {

        Scanner inx = new Scanner(System.in);
        int esccond = 0;

        System.out.println("Welcome to Simmunity.");
        System.out.printf("\nVersion 1.4\nBy MD Naseem Ashraf\n==========================\n\n");

        while(esccond == 0)        //cmd line loop start
        {
            System.out.printf(">> ");
            String ch = inx.nextLine();            
            cmdsClass.ChkCmd(ch);      //Pass Command to ChkCmd for Command Identification
        }//cmd line loop end
    }
    
}
