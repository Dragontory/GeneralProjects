/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W10B-3 					         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( ) {
    //Initialize pointers and variables
    FILE *inFile,*outFile;
    float max,min,maxTime,minTime,time,voltage,change,firstVoltage;
    float maxStrain, minStrain,input=5.0,amplification=500,gage=2.085;

    //Open input and output files
    inFile=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\FEH_APP10\\W10B_bike.txt","r");
    outFile=fopen("APP_W10B_3_result.txt","w");
    
    //check if can't open file
    if(inFile==NULL) {
        printf("Error in Opening the File. :(\n");       
    } else {
        //scans first number into first Voltage
        fscanf(inFile,"%f",&firstVoltage);
        max=firstVoltage;
        min=firstVoltage;
        //while loop to read each voltage and find the max, min, and the associated times
        while(fscanf(inFile,"%f",&voltage)!=EOF) {
            if(voltage>max) {
                max=voltage;
                maxTime=time;
            }
            if(voltage<min){
                min=voltage;
                minTime=time;
            }
            time+=0.005;
        }
    }

    //calculates strains of max and min voltages
    maxStrain=(max-firstVoltage)/(input*amplification*gage);  
    minStrain=(min-firstVoltage)/(input*amplification*gage);  

    //prints results to screen
    printf("The max voltage is %.3f volts, and the min voltage is %.3f volts.\n",max,min);
    printf("The elapsed time between the max and min is %.3f seconds.\n",fabs(maxTime-minTime));
    printf("The strain for the max is %f \u03B5. The strain for the min is %f \u03B5.\n",maxStrain,minStrain);

    //prints results to output file
    fprintf(outFile,"The max voltage is %.3f volts, and the min voltage is %.3f volts.\n",max,min);
    fprintf(outFile,"The elapsed time between the max and min is %.3f seconds.\n",fabs(maxTime-minTime));
    fprintf(outFile,"The strain for the max is %f \u03B5. The strain for the min is %f \u03B5.\n",maxStrain,minStrain);



}