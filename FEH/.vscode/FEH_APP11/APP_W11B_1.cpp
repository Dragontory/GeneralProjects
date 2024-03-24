/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W11B-1						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//Libraries
#include  <stdio.h>
#include  <math.h>
#include <string.h>
int main ( ) {
    //Declare pointers, variables, and arrays
    FILE *fptr1, *fptr2;
    int APlus=0, AMinus=0, BPlus=0, BMinus=0, OPlus=0, OMinus=0, ABPlus=0, ABMinus=0;
    char names[50], blood[10], ABPlus_Names[300][50];
    int i=0, n=0;

    //Opens input and output files
    fptr1=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\FEH_APP11\\W11B_bloodtypes.txt","r");
    fptr2=fopen("APP_W11B_1_results.txt","w");

    //checks if file doesn't open
    if(fptr1==NULL) {
        printf("Error in Opening the File. :(\n");       
    } else {
        //scans each name and blood type until end of file
        while(fscanf(fptr1,"%s%s",&names,&blood)!=EOF) {
            //checks to see which blood type each person has and increments the corresponding variable
            //if blood is AB+, copies name into 2d array
            if(strcmp(blood,"A+")==0) {
                APlus++;
            } else if(strcmp(blood,"A-")==0) {
                AMinus++;
            } else if(strcmp(blood,"B+")==0) {
                BPlus++;
            } else if(strcmp(blood,"B-")==0) {
                BMinus++;
            } else if(strcmp(blood,"O+")==0) {
                OPlus++;
            } else if(strcmp(blood,"O-")==0) {
                OMinus++;
            } else if(strcmp(blood,"AB+")==0) {
                ABPlus++;
                strcpy(ABPlus_Names[n],names);
                n++;
            } else {
                ABMinus++;
            }
            i++;
            
        }
        
    }

    //prints number of people with each blood type
    printf("There are %d people with blood type A+, %d with A-, %d with B+, %d with B-,\n",APlus,AMinus,BPlus,BMinus);
    printf("%d with O+, %d with O-, %d with AB+, and %d with AB-.\n",OPlus,OMinus,ABPlus,ABMinus);
    
    //prints to screen and ouput file the names of people with AB+ blood type
    for(int j = 0; j < n+1;j++) {
        puts(ABPlus_Names[j]);
        fputs(ABPlus_Names[j],fptr2);
    }

    //close output and input files
    fclose(fptr1);
    fclose(fptr2);

}