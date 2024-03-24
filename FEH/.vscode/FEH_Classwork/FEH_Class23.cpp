

#include  <stdio.h>
#include  <math.h>

int main() {
int array[4];

for(int i = 0; i<4; i++) {
    array[i]=i*2;
    printf("Array at index %i = %i",i,array[i]);
}
}