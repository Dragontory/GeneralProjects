#include  <stdio.h>
#include  <math.h>
#include <string.h>
int main ( ) {
    char first[20], last[20];
    printf("Enter First Name: ");
    fgets(first, 20, stdin);

    printf("\nEnter Last Name: ");
    fgets(last, 20, stdin);

    //printf("Your name is %c %c.\n",first,last);

    puts(first);
    puts(last);


}