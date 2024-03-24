/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W09B-2						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( )
{
    //Opens file and initializes variables
    FILE *fptr;
    float fluid, c, Ga, Q, P, Tbsp, tsp;
    fptr=fopen("W09B_2_result.txt","w");

    //Prompts User for volume in Fluid Ounces and reads user response
    printf("Enter the Volume in Fluid Ounces:");
    scanf("%f",&fluid);

    //Converts the inputted volume
    c=fluid/8.0;
    P=c/2.0;
    Q=c/4.0;
    Ga=Q/4.0;
    Tbsp=fluid*2.0;
    tsp=fluid*6.0;

    //Displays results
    printf("\nThe equivalent volume in cups is %.2f cups",c);
    printf("\nThe equivalent volume in pints is %.2f pints",P);
    printf("\nThe equivalent volume in quarts is %.2f quarts",Q);
    printf("\nThe equivalent volume in gallons is %.2f gallons",Ga);
    printf("\nThe equivalent volume in tablespoons is %.2f Tbsps",Tbsp);
    printf("\nThe equivalent volume in teaspoons is %.2f Teaspoons",tsp);

    //Writes results to output file and closes file
    fprintf(fptr, "The equivalent volumes are %.2f cups, %.2f pints, %.2f quarts, %.2f gallons, %.2f Tbsps, and %.2f Teaspoons",
    c,P,Q,Ga,Tbsp,tsp);
    fclose(fptr);

}
