
package simmunityai;
import java.io.*;
import java.util.*;

/**
 *
 * @author MD Naseem Ashraf
 */
public class RandomSimmunity {

 //RandomSim(int XDimension, int YDimension, int Number of Steps)
 public static void RandomSim(int x, int y, int z) throws IOException{

    int t = (z*2)+1;    //Total number of FRAMES.
    createUniverse(x,y,t);  //Write Universe data to file.

	//Alter FileWriter Path as per your setup.
    PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Toshiba/Desktop/SIMMUNITY/Outputs/SimData.txt",true));

    int [][] blood = new int[x][y];
    int [][] clone = new int[x][y];

    Random random= new Random();
    int attack=0;

    int a12 =(int) (0.60*(x*y));
    for (int i=1; i<=a12; i++){      //60% RBC
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=1;
    }

    int a13 =(int) (0.10*(x*y));
    for (int i=1; i<=a13; i++){      //10-11% Pathogen
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=2;
    }

    int a14 =(int) (0.10*(x*y));
    for (int i=1; i<=a14; i++){      //10-11% WBC
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=3;
    }

    //INITIAL BLOOD SITUATION
    for (int i=0; i<=x-1; i++){
        for (int j=0; j<=y-2; j++){
            clone[i][j]=blood[i][j];
            out.printf("\t%d", blood[i][j]);
            out.print(",");
        }
        clone[i][y-1]=blood[i][y-1];
        out.printf("\t%d", blood[i][y-1]);
        out.println("");
    }
    out.flush();

    analysisClass.analyze(blood, x, y);   //Do an Initial Statistic analysis on matrix blood

int step=z;

for (int step1=1; step1<=step; step1++){

    for (int i=0; i<=x-1; i++){                       //PATHOGEN RULE 1: Eat RBC & Duplicate
        for (int j=0; j<=y-1; j++){
            attack=0;
            if(blood[i][j]==2){
                if((i>0)&&(j>0)){
                    if((blood[i-1][j-1]==1)&&(clone[i-1][j-1]!=2)){
                        clone[i-1][j-1]=2;
                        attack=1;}
		}

                if((j>0)&&(attack!=1)){
                    if((blood[i][j-1]==1)&&(clone[i][j-1]!=2)){
                        clone[i][j-1]=2;
                        attack=1;
                    }
                }

                if((j>0)&&(i<x-1)&&(attack!=1)){
                    if((blood[i+1][j-1]==1)&&(clone[i+1][j-1]!=2)){
                        clone[i+1][j-1]=2;
                        attack=1;
                    }
                }

                if((i>0)&&(attack!=1)){
                    if((blood[i-1][j]==1)&&(clone[i-1][j]!=2)){
                        clone[i-1][j]=2;
                        attack=1;
                    }
                }

                if((i<x-1)&&(attack!=1)){
                    if((blood[i+1][j]==1)&&(clone[i+1][j]!=2)){
                        clone[i+1][j]=2;
                        attack =1;
                    }
                }

                if((i>1)&&(j<y-1)&&(attack!=1)){
                    if((blood[i-1][j+1]==1)&&(clone[i-1][j+1]!=2)){
                        clone[i-1][j+1]=2;
                        attack =1;
                    }
                }

                if((j<y-1)&&(attack!=1)){
                    if((blood[i][j+1]==1)&&(clone[i][j+1]!=2)){
                        clone[i][j+1]=2;
                        attack =1;
                    }
                }

                if((j<y-1)&&(i<x-1)&&(attack!=1)){
                    if((blood[i+1][j+1]==1)&&(clone[i+1][j+1]!=2)){
                        clone[i+1][j+1]=2;
                        attack =1;
                    }
                }

		                /*    if (attack==0)
		                        clone[i][j]=0;   //Pathogen DIES of STARVATION*/

		                    /*else
		                        clone[i][j]=0;   //Pathogen MOVES to FEED*/

                }
        }
    }

            for (int i=0; i<=x-1; i++){                       //WBC RULE 1: Eat Pathogen & Duplicate
                for (int j=0; j<=y-1; j++){
                    int attack1=0;
                    if(blood[i][j]==3){
                        if((i>0)&&(j>0)){
                           if((blood[i-1][j-1]==2)&&(clone[i-1][j-1]!=3)){
                              clone[i-1][j-1]=3;
                              attack1=1;}
                        }

                        if((j>0)&&(attack1!=1)){
                            if((blood[i][j-1]==2)&&(clone[i][j-1]!=3)){
                                clone[i][j-1]=3;
                                attack1=1;
                            }
                        }

                        if((j>0)&&(i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j-1]==2)&&(clone[i+1][j-1]!=3)){
                                clone[i+1][j-1]=3;
                                attack1=1;
                            }
                        }

                        if((i>0)&&(attack1!=1)){
                            if((blood[i-1][j]==2)&&(clone[i-1][j]!=3)){
                                clone[i-1][j]=3;
                                attack1=1;
                            }
                        }

                        if((i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j]==2)&&(clone[i+1][j]!=3)){
                                clone[i+1][j]=3;
                                attack1 =1;
                            }
                        }

                        if((i>1)&&(j<y-1)&&(attack1!=1)){
                            if((blood[i-1][j+1]==2)&&(clone[i-1][j+1]!=3)){
                                clone[i-1][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if((j<y-1)&&(attack1!=1)){
                            if((blood[i][j+1]==2)&&(clone[i][j+1]!=3)){
                                clone[i][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if((j<y-1)&&(i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j+1]==2)&&(clone[i+1][j+1]!=3)){
                                clone[i+1][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if (attack1==0)
                            clone[i][j]=0;   //WBC DIES of STARVATION*/

                        /*else
                            clone[i][j]=0;   //Pathogen MOVES to FEED*/
                    }
                }
            }

            //STEP OUTPUT
            for (int i=0; i<=x-1; i++){
                for (int j=0; j<=y-2; j++){
                    blood[i][j]=clone[i][j];
                    out.printf("\t%d", blood[i][j]);
                    out.print(",");
                }
                blood[i][y-1]=clone[i][y-1];
                out.printf("\t%d", blood[i][y-1]);
                out.println("");
            }
            //out.println("");
            out.flush();

		        //RBC Death after every 3 Steps
		/*        if(((step1+1)%3)==0){
		        for (int i=1; i<=4; i++){              //10-11% RBC dies
		            int rbcx= random.nextInt(5);
		            int rbcy= random.nextInt(7);

		            if (blood[rbcx][rbcy]==1){
		                blood[rbcx][rbcy]=0;
		            }
		    }
		 }*/

		    //RBC REGENERATION
		        int a21 = (int) (0.10*(x*y));
		    for (int i=1; i<=a21; i++){              //10-11% RBC
		            int rbcx= random.nextInt(x);
		            int rbcy= random.nextInt(y);

		            if (blood[rbcx][rbcy]==0){
		                blood[rbcx][rbcy]=1;
		            }
		    }

		   //WBC REGENERATION
		    for (int i=1; i<=a21; i++){              //10-11% WBC
		            int rbcx= random.nextInt(x);
		            int rbcy= random.nextInt(y);

		            if (blood[rbcx][rbcy]==0){
		                blood[rbcx][rbcy]=3;
		            }
		    }

		        //Simulation  AFTER RBC & WBC REGENERATION

		       for (int i=0; i<=x-1; i++){
		            for (int j=0; j<=y-2; j++){
		                clone[i][j]=blood[i][j];
		                out.printf("\t%d", blood[i][j]);
		                out.print(",");
		            }
		            blood[i][y-1]=clone[i][y-1];
		            out.printf("\t%d", blood[i][y-1]);
		            out.println("");                            
		        }
                        //out.println("");
		        out.flush();

                        analysisClass.analyze(blood, x, y);   //Do a Statistic analysis on matrix blood

		        }//Step end
		 }//Method End

 public static void createUniverse(int x, int y, int t) throws IOException
 {
	 //Alter FileWriter Path as per your setup.
     PrintWriter WriteUniverse = new PrintWriter(new FileWriter("C:/Users/Toshiba/Desktop/SIMMUNITY/Universes Collection/RandomUniverse.txt",true));
     WriteUniverse.printf("\t%d", x);
     WriteUniverse.print(",");
     WriteUniverse.printf("\t%d", y);
     WriteUniverse.print(",");
     WriteUniverse.printf("\t%d", t);
     WriteUniverse.flush();
 }//Method End

 public static void RandomSimSlow(int x, int y, int z) throws IOException{

    int t = (z*4)+1;    //Total number of FRAMES.
    createUniverse(x,y,t);  //Write Universe data to file.

	//Alter FileWriter Path as per your setup.
    PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Toshiba/Desktop/SIMMUNITY/Outputs/SimData.txt",true));

    int [][] blood = new int[x][y];
    int [][] clone = new int[x][y];

    Random random= new Random();
    int attack=0;

    int a12 =(int) (0.60*(x*y));
    for (int i=1; i<=a12; i++){      //60% RBC
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=1;
    }

    int a13 =(int) (0.10*(x*y));
    for (int i=1; i<=a13; i++){      //10-11% Pathogen
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=2;
    }

    int a14 =(int) (0.10*(x*y));
    for (int i=1; i<=a14; i++){      //10-11% WBC
        int rbcx= random.nextInt(x);
        int rbcy= random.nextInt(y);
        blood[rbcx][rbcy]=3;
    }

    //INITIAL BLOOD SITUATION
    for (int i=0; i<=x-1; i++){
        for (int j=0; j<=y-2; j++){
            clone[i][j]=blood[i][j];
            out.printf("\t%d", blood[i][j]);
            out.print(",");
        }
        clone[i][y-1]=blood[i][y-1];
        out.printf("\t%d", blood[i][y-1]);
        out.println("");
    }
    out.flush();

    analysisClass.analyze(blood, x, y);   //Do an Initial Statistic analysis on matrix blood

int step=z;

for (int step1=1; step1<=step; step1++){

    for (int i=0; i<=x-1; i++){                       //PATHOGEN RULE 1: Eat RBC & Duplicate
        for (int j=0; j<=y-1; j++){
            attack=0;
            if(blood[i][j]==2){
                if((i>0)&&(j>0)){
                    if((blood[i-1][j-1]==1)&&(clone[i-1][j-1]!=2)){
                        clone[i-1][j-1]=2;
                        attack=1;}
		}

                if((j>0)&&(attack!=1)){
                    if((blood[i][j-1]==1)&&(clone[i][j-1]!=2)){
                        clone[i][j-1]=2;
                        attack=1;
                    }
                }

                if((j>0)&&(i<x-1)&&(attack!=1)){
                    if((blood[i+1][j-1]==1)&&(clone[i+1][j-1]!=2)){
                        clone[i+1][j-1]=2;
                        attack=1;
                    }
                }

                if((i>0)&&(attack!=1)){
                    if((blood[i-1][j]==1)&&(clone[i-1][j]!=2)){
                        clone[i-1][j]=2;
                        attack=1;
                    }
                }

                if((i<x-1)&&(attack!=1)){
                    if((blood[i+1][j]==1)&&(clone[i+1][j]!=2)){
                        clone[i+1][j]=2;
                        attack =1;
                    }
                }

                if((i>1)&&(j<y-1)&&(attack!=1)){
                    if((blood[i-1][j+1]==1)&&(clone[i-1][j+1]!=2)){
                        clone[i-1][j+1]=2;
                        attack =1;
                    }
                }

                if((j<y-1)&&(attack!=1)){
                    if((blood[i][j+1]==1)&&(clone[i][j+1]!=2)){
                        clone[i][j+1]=2;
                        attack =1;
                    }
                }

                if((j<y-1)&&(i<x-1)&&(attack!=1)){
                    if((blood[i+1][j+1]==1)&&(clone[i+1][j+1]!=2)){
                        clone[i+1][j+1]=2;
                        attack =1;
                    }
                }

		                /*    if (attack==0)
		                        clone[i][j]=0;   //Pathogen DIES of STARVATION*/

		                    /*else
		                        clone[i][j]=0;   //Pathogen MOVES to FEED*/

               for (int fi=0; fi<=x-1; fi++)
               {
                for (int fj=0; fj<=y-2; fj++)
                {
                    clone[fi][fj]=blood[fi][fj];
                    out.printf("\t%d", blood[fi][fj]);
                    out.print(",");
                }
                clone[fi][y-1]=blood[fi][y-1];
                out.printf("\t%d", blood[fi][y-1]);
                out.println("");
               }
                out.flush();

                analysisClass.analyze(blood, x, y);   //Do a Statistic analysis on matrix blood

                }
        }
    }

            for (int i=0; i<=x-1; i++){                       //WBC RULE 1: Eat Pathogen & Duplicate
                for (int j=0; j<=y-1; j++){
                    int attack1=0;
                    if(blood[i][j]==3){
                        if((i>0)&&(j>0)){
                           if((blood[i-1][j-1]==2)&&(clone[i-1][j-1]!=3)){
                              clone[i-1][j-1]=3;
                              attack1=1;}
                        }

                        if((j>0)&&(attack1!=1)){
                            if((blood[i][j-1]==2)&&(clone[i][j-1]!=3)){
                                clone[i][j-1]=3;
                                attack1=1;
                            }
                        }

                        if((j>0)&&(i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j-1]==2)&&(clone[i+1][j-1]!=3)){
                                clone[i+1][j-1]=3;
                                attack1=1;
                            }
                        }

                        if((i>0)&&(attack1!=1)){
                            if((blood[i-1][j]==2)&&(clone[i-1][j]!=3)){
                                clone[i-1][j]=3;
                                attack1=1;
                            }
                        }

                        if((i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j]==2)&&(clone[i+1][j]!=3)){
                                clone[i+1][j]=3;
                                attack1 =1;
                            }
                        }

                        if((i>1)&&(j<y-1)&&(attack1!=1)){
                            if((blood[i-1][j+1]==2)&&(clone[i-1][j+1]!=3)){
                                clone[i-1][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if((j<y-1)&&(attack1!=1)){
                            if((blood[i][j+1]==2)&&(clone[i][j+1]!=3)){
                                clone[i][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if((j<y-1)&&(i<x-1)&&(attack1!=1)){
                            if((blood[i+1][j+1]==2)&&(clone[i+1][j+1]!=3)){
                                clone[i+1][j+1]=3;
                                attack1 =1;
                            }
                        }

                        if (attack1==0)
                            clone[i][j]=0;   //WBC DIES of STARVATION*/

                        /*else
                            clone[i][j]=0;   //Pathogen MOVES to FEED*/
                    }
                }
            }

            //STEP OUTPUT
            for (int i=0; i<=x-1; i++){
                for (int j=0; j<=y-2; j++){
                    blood[i][j]=clone[i][j];
                    out.printf("\t%d", blood[i][j]);
                    out.print(",");
                }
                blood[i][y-1]=clone[i][y-1];
                out.printf("\t%d", blood[i][y-1]);
                out.println("");
            }
            //out.println("");
            out.flush();

		        //RBC Death after every 3 Steps
		/*        if(((step1+1)%3)==0){
		        for (int i=1; i<=4; i++){              //10-11% RBC dies
		            int rbcx= random.nextInt(5);
		            int rbcy= random.nextInt(7);

		            if (blood[rbcx][rbcy]==1){
		                blood[rbcx][rbcy]=0;
		            }
		    }
		 }*/

		    //RBC REGENERATION
		        int a21 = (int) (0.10*(x*y));
		    for (int i=1; i<=a21; i++){              //10-11% RBC
		            int rbcx= random.nextInt(x);
		            int rbcy= random.nextInt(y);

		            if (blood[rbcx][rbcy]==0){
		                blood[rbcx][rbcy]=1;
		            }
		    }

               for (int fi=0; fi<=x-1; fi++)
               {
                for (int fj=0; fj<=y-2; fj++)
                {
                    clone[fi][fj]=blood[fi][fj];
                    out.printf("\t%d", blood[fi][fj]);
                    out.print(",");
                }
                clone[fi][y-1]=blood[fi][y-1];
                out.printf("\t%d", blood[fi][y-1]);
                out.println("");
               }
                out.flush();

                analysisClass.analyze(blood, x, y);   //Do a Statistic analysis on matrix blood

		   //WBC REGENERATION
		    for (int i=1; i<=a21; i++){              //10-11% WBC
		            int rbcx= random.nextInt(x);
		            int rbcy= random.nextInt(y);

		            if (blood[rbcx][rbcy]==0){
		                blood[rbcx][rbcy]=3;
		            }
		    }

		        //Simulation  AFTER RBC & WBC REGENERATION

		       for (int i=0; i<=x-1; i++){
		            for (int j=0; j<=y-2; j++){
		                clone[i][j]=blood[i][j];
		                out.printf("\t%d", blood[i][j]);
		                out.print(",");
		            }
		            blood[i][y-1]=clone[i][y-1];
		            out.printf("\t%d", blood[i][y-1]);
		            out.println("");
		        }
                        //out.println("");
		        out.flush();

                        analysisClass.analyze(blood, x, y);   //Do a Statistic analysis on matrix blood

		        }//Step end
		 }

}
