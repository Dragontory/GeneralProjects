/**********************************************************************/
/*  AUTHOR:  Tory Yang                                                */
/*  DATE: 11/21/2022                                                  */
/*  INSTRUCTOR: Amy Kramer                                            */
/*  HOUR: 10:20 AM                                                    */
/**********************************************************************/

#include <stdio.h>
#include <math.h>

//function prototype
int factorial(int);

int main()
{
	int n=10; //total number of flips
	int k=6; //total number of heads

	float prob; 
	//int n_fac=factorial(n);
	//int k_fac=factorial(k);
	//Fill in this line with the probability function (you must use the function factorial).
	//calculates probability
	prob = (1.0/pow(2.0,n)) * (factorial(n)*1.0/(factorial(k)*factorial(n-k)*1.0));

	//prints to screen
	printf("The probability of %i heads in %i flips is %f\n",k,n,prob);
}

//Write the function here
//function definition
int factorial(int num) {
	int sum = 1;
	for(int i = num; i > 0; i--) {
		sum*=i;
	}
	return sum;
}
