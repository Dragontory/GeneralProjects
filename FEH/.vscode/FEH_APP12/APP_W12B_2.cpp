/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W12B-2						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( ) {
    //Opens File and initializes variables/vectors
    FILE *fptr;
    float swim[6], bike[6], run[6], total[6], avgSwim, avgBike, avgRun, avgTotal;

    //error 1
    int mSwim, mBike, mRun, mTotal;
    int ySwim, yBike, yRun, yTotal;

    //error 2
    fopen("W09B_3_result.txt","w");

    //For Loop To Prompt User for Data from 2007 to 2012
    for (int i = 0; i<6; i++) {
        printf("\nEnter the Average Swim Speed (mph) for year %i: ", i+2007);
        //error 3
        scanf("%f",swim[i]);
        printf("\nEnter the Average Bike Speed (mph) for year %i: ", i+2007);
        scanf("%f",bike[i]);
        printf("\nEnter the Average Run Speed (mph) for year %i: ", i+2007);
        scanf("%f",run[i]);
        printf("\nEnter the Average Speed for the Entire Race (mph) for year %i: ", i+2007);
        scanf("%f",total[i]);
    }

    //For Loop to calculate the fastest speeds and corresponding years, as well as the sum of all the speeds in each category
    for (int i = 0; i<6; i++) {
        if(mSwim<swim[i]){
            mSwim=swim[i];
            //error 4
            ySwim=i;
        }
        if(mBike<bike[i]){
            mBike=bike[i];
            yBike=i+2007;
        }
        if(mRun<run[i]){
            mRun=run[i];
            yRun=i+2007;
        }
        if(mRun<total[i]){
            mTotal=total[i];
            yTotal=i+2007;
        }
        avgSwim+=swim[i];
        avgBike+=bike[i];
        avgRun+=run[i];
        avgTotal+=total[i];
    }

    //calculates the average speed in each category
    avgSwim=avgSwim/6.0;
    avgBike=avgBike/6.0;
    avgRun=avgRun/6.0;
    avgTotal=avgTotal/6.0;

    //prints results
    printf("\nThe Year with the Fastest Swim Speed was %i with a Speed of %.2f mph. The Average Swim Speed was %.2f mph.",
    ySwim,mSwim,avgSwim);
    printf("\nThe Year with the Fastest Bike Speed was %i with a Speed of %.2f mph. The Average Bike Speed was %.2f mph.",
    yBike,mBike,avgBike);
    printf("\nThe Year with the Fastest Run Speed was %i with a Speed of %.2f mph. The Average Run Speed was %.2f mph.",
    yRun,mRun,avgRun);
    printf("\nThe Year with the Fastest Overall Speed was %i with a Speed of %.2f mph. The Average Overall Speed was %.2f mph.",
    yTotal,mTotal,avgTotal);

    //writes results to output file
    //error 5
    fprintf(fptr,"\nThe Fastest Swim Speed was %.2f mph in year %f. The Average Swim Speed was %.2f.",mSwim,ySwim,avgSwim);
    fprintf(fptr,"\nThe Fastest Bike Speed was %.2f mph in year %f. The Average Bike Speed was %.2f.",mBike,yBike,avgBike);
    fprintf(fptr,"\nThe Fastest Run Speed was %.2f mph in year %f. The Average Run Speed was %.2f.",mRun,yRun,avgRun);
    fprintf(fptr,"\nThe Fastest Overall Speed was %.2f mph in year %f. The Average Overal Speed was %.2f.",mTotal,yTotal,avgTotal);

    //closes file
    fclose(fptr);


}