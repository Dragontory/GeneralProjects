/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W10B-2 					         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( ) {
    //Problem 2 without pointer variables
    //initialize pointer variables
    float a, b, c, avg;
    float *ptr1, *ptr2, *ptr3, *ptr4;
    ptr1 = &a;
    ptr2 = &b;  
    ptr3 = &c;
    ptr4 = &avg;

    //prompts user for three numbers
    printf("Enter 3 numbers: ");
    scanf("%f\n%f\n%f",&a,&b,&c);

    //calculates and prints out average, absolute values, absolute value average, and the value and address of a
    avg=(a+b+c)/3.0;
    printf("\nThe average of the three numbers is %.3f.\n",avg);
    printf("The absolute values of the inputted values are %.2f, %.2f, and %.2f.\n",fabs(a),fabs(b),fabs(c));
    printf("The average of the absolute values is %.3f.\n",(fabs(a)+fabs(b)+fabs(c))/3.0);
    printf("The value of a is %.2f. The address of a is %p.\n",a,&a);

}