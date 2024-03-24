/*  Name:  Tory Yang						             */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W08B-2						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( )
{

    printf ("**************************************************\n");
    printf ("*  Name:  Tory Yang   Date:  10/17/22            *\n");
    printf ("*  Seat:  C12    File:  APP_W08B_2.cpp           *\n");
    printf ("*  Instructor: Kramer  ABC 10:20:MM              *\n");
    printf ("************************************************\n\n");

    //initializes variables to floats 
    //h=3 in, b=6 in
    float h=3, b=6, i;

    //Calculates and prints out the dimensions and moment of inertia
    i=b*pow(h,3)/12;
    printf("A rectangle with b = %6.2f in and h = %6.2f in\n", b, h);
    printf("has an area moment of inertia of I = %6.2f in^4\n", i);

    //changes variables
    //h=6 in, b=3 in
    h=6, b=3;

    //Calculates and prints out the dimensions and moment of inertia
    i=b*pow(h,3)/12;
    printf("A rectangle with b = %6.2f in and h = %6.2f in\n", b, h);
    printf("has an area moment of inertia of I = %6.2f in^4\n", i);

    //changes variables
    //h=2 in, b=2h
    h=2, b=2*h;

    //Calculates and prints out the dimensions and moment of inertia
    i=b*pow(h,3)/12;
    printf("A rectangle with b = %6.2f in and h = %6.2f in\n", b, h);
    printf("has an area moment of inertia of I = %6.2f in^4\n", i);

    //changes variables
    //h=3 in, b=2h
    h=3, b=2*h;

    //Calculates and prints out the dimensions and moment of inertia
    i=b*pow(h,3)/12;
    printf("A rectangle with b = %6.2f in and h = %6.2f in\n", b, h);
    printf("has an area moment of inertia of I = %6.2f in^4\n", i);
}
