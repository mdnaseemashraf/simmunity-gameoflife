
package simmunityai;

import java.io.*;

/**
 *
 * @author MD Naseem Ashraf
 */
public class firstStatRecord {
    
    private int rbc;
    private int wbc;
    private int virus;
    private int blood_plasma;

    public firstStatRecord( ){
        this(0,0,0,0);
    }

    //INITIALIZE A RECORD
    public firstStatRecord( int rbc, int wbc, int virus, int blood_plasma ){        
        setRbc(rbc);
        setWbc(wbc);
        setVirus(virus);
        setBlood_plasma(blood_plasma);
    }        

    //Set RBC
    public void setRbc(int r){
        rbc = r;
    }
    //Get RBC
    public int getRbc(){
        return(rbc);
    }

    //Set WBC
    public void setWbc(int w){
        wbc = w;
    }
    //Get WBC
    public int getWbc(){
        return(wbc);
    }

    //Set Virus
    public void setVirus(int v){
        virus = v;
    }
    //Get Virus
    public int getVirus(){
        return(virus);
    }

    //Set Blood Plasma
    public void setBlood_plasma(int bp){
        blood_plasma = bp;
    }
    //Get Blood Plasma
    public int getBlood_plasma(){
        return(blood_plasma);
    }

    //WRITE RECORD TO FILE
    public void writeAltRecord(firstStatRecord record)
    {
        try {
			 //Alter FileWriter Path as per your setup.
             PrintWriter WriteRecord = new PrintWriter(new FileWriter("C:/Users/Toshiba/Desktop/SIMMUNITY/Outputs/FirstStat.txt",true));             
             WriteRecord.printf("\t%d", record.getRbc());   //Write RBC Count
             WriteRecord.print(",");
             WriteRecord.printf("\t%d", record.getWbc());   //Write WBC Count
             WriteRecord.print(",");
             WriteRecord.printf("\t%d", record.getVirus()); //Write Virus Count
             WriteRecord.print(",");
             WriteRecord.printf("\t%d", record.getBlood_plasma());  //Write Blood Plasma Count
             WriteRecord.println("");
             WriteRecord.flush();
        }//end of try block
        catch(IOException ioException)
        {}//end of catch
    }
    
}
