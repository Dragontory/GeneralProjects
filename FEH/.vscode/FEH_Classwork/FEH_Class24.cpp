#include  <stdio.h>
#include  <math.h>

int main() {
    int x=5;
    int *ptr;
    ptr=&x;
    *ptr=10;
    printf("The value of x is %d and the address of x is %p.\n",*ptr,ptr);

}