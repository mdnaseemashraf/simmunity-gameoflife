
package simmunityai;

import java.io.IOException;
/**
 *
 * @author MD Naseem Ashraf
 */
public class analysisClass {

    //INTERNAL ANALYSIS CALL
     public static void analyze(int z[][], int x, int y)
    {
         int rbc = 0; int wbc = 0; int virus = 0; int cellsize = x*y; int blood_plasma = 0;

         //PROCESS BLOOD MATRIX CELLS
        for (int i = 0; i<x; i++){
            for (int j = 0; j<y; j++){
                if(z[i][j]==1)  //RBC Count update
                {rbc++;}
                else if(z[i][j]==2)  //Virus Count update
                {virus++;}
                else if(z[i][j]==3)  //WBC Count update
                {wbc++;}
                else    //Plasma Count update
                {blood_plasma++;}
            }
        }
         
        //Create a Record Object to be Stored into Stat file.
         firstStatRecord record = new firstStatRecord(rbc, wbc, virus, blood_plasma);                
         record.writeAltRecord(record); //WRITE TO STAT FILE
    }    
}
