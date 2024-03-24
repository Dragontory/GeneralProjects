/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  EWA_05      					         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//definitions and include statements
#include  <stdio.h>
#include  <math.h>
#define CMPD_PER_GPH 0.0908498828
#define TEV_PER_CAL 26125697.8238
#define P_PER_LY 0.30659458
#define O_PER_S 1.0/60.0
int main ( ) {
    //creates pointer and initializes variables
    FILE *fptr;
    float stremma, lightYear, calorie, GPH, oxgang, parsecs, TEV, CMPD;
    //opens output file
    fptr=fopen("EWA_05.txt","w");

    //prompts user for information and reads the user's response
    printf("Enter an area in stremmas: ");
    scanf("%f", &stremma);

    printf("\nEnter a distance in light years: ");
    scanf("%f", &lightYear);

    printf("\nEnter an amoutn of energy in calories: ");
    scanf("%f", &calorie);

    printf("\nEnter a flowrate in gallons/hour: ");
    scanf("%f", &GPH);

    //conversion
    oxgang=stremma*O_PER_S;
    parsecs=lightYear*P_PER_LY;
    TEV=calorie*TEV_PER_CAL;
    CMPD=GPH*CMPD_PER_GPH;

    //Displays results
    printf("The inputted values were %10.2f stremma, %10.2f light years, %10.2f calories, and %10.2f gallons/hour.\n",stremma, lightYear, calorie, GPH);
    printf("The converted values are %10.2f oxgang, %10.2f parsecs, %e tetraelectronvolts, and %10.2f meters^3/day.\n",oxgang, parsecs, TEV, CMPD);
    printf("Program has completed.\n");

    //Writes values to output file
    fprintf(fptr,"The inputted values were %10.2f stremma, %10.2f light years, %10.2f calories, and %10.2f gallons/hour.\n",stremma, lightYear, calorie, GPH);
    fprintf(fptr,"The converted values are %10.2f oxgang, %10.2f parsecs, %e tetraelectronvolts, and %10.2f meters^3/day.\n",oxgang, parsecs, TEV, CMPD);

    //closes file
    fclose(fptr);



}