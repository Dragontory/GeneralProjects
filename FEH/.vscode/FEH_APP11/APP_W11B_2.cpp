/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W11B-2 					         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//Libraries
#include  <stdio.h>
#include  <math.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <Windows.h>

int main ( ) {
    //Variables
    float minTime,green,yellow;
    int start;
    int NS=1;

    //Prompts user for minimum total time, green cycle, and yellow cycle
    printf("Enter a total minimum time to run the program (s): ");
    scanf("%f",&minTime);

    printf("\nEnter the length of the green cycle (s): ");
    scanf("%f",&green);

    printf("\nEnter the length of the yellow cycle (s): ");
    scanf("%f",&yellow);
    printf("\n");

    //start time
    start=time(NULL);

    //while total time is less than inputted time, changes lights based on time
    while ((time(NULL)-start)<minTime) {
        if(NS==1) {
            printf("NS Light = Green, EW Light = Red\n");
            printf("waiting 4 seconds\n");
            NS=2;
            sleep(green);   
        } else if(NS==2) {
            printf("NS Light = Yellow, EW Light = Red\n");
            printf("waiting 2 seconds\n");
            NS=3;
            sleep(yellow);
        } else if(NS==3) {
            printf("NS Light = Red, EW Light = Green\n");
            printf("waiting 4 seconds\n");
            NS=4;
            sleep(green);
        } else {
            printf("NS Light = Red, EW Light = Yellow\n");
            printf("waiting 2 seconds\n");
            NS=1;
            sleep(yellow);
        }
        
        /*printf("NS Light = Green, EW Light = Red\n");
        printf("waiting 4 seconds\n");
        sleep(green);

        printf("NS Light = Yellow, EW Light = Red\n");
        printf("waiting 2 seconds\n");
        sleep(yellow);

        printf("NS Light = Red, EW Light = Green\n");
        printf("waiting 4 seconds\n");
        sleep(green);

        printf("NS Light = Red, EW Light = Yellow\n");
        printf("waiting 2 seconds\n");
        sleep(yellow);*/

    }

    //prints final cycle
    if(NS==1) {
        printf("NS Light = Green, EW Light = Red\n"); 
    } else if(NS==2) {
        printf("NS Light = Yellow, EW Light = Red\n");
    } else if(NS==3) {
        printf("NS Light = Red, EW Light = Green\n");
    } else {
            printf("NS Light = Red, EW Light = Yellow\n");
        }
    printf("%.2f seconds have passed\n",minTime);


}