/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W11B-3						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//Libraries
#include  <stdio.h>
#include  <math.h>
#include <string.h>

//function prototypes
float mydot (float vector1[], float vector2[]);
void mycross (float vector3[], float vector4[], float *cross);

int main ( ) {
    //Initialize Variables and Pointers
    FILE *fptr;
    char play = 'Y', option='A';
    float udot[3], vdot[3], ucross[3], vcross[3];
    float cross[3];
    char buffer_character;

    //opens output file
    fptr=fopen("APP_W11B_3_result.txt","w");

    //While loop to play again
    while(play!='n' && play!='N') {
      
        //Prompts user for either dot or cross product
        printf("Enter 'D' for dot product or 'C' for cross product: ");
        scanf("%c",&option);
        
        //dot product
        if(option=='D' || option=='d') {
            printf("\nEnter values for x, y, and z for vector U (dot): ");
            scanf("%f%f%f", &udot[0],&udot[1],&udot[2]);

            printf("\nEnter values for x, y, and z for vector V (dot): ");
            scanf("%f%f%f", &vdot[0],&vdot[1],&vdot[2]);

            printf("\nThe dot product of U and V is %f.\n",mydot(udot,vdot));
            fprintf(fptr,"\nThe dot product of U and V is %f.\n",mydot(udot,vdot));
            buffer_character=getchar();

        }
        //cross product
        if(option=='C' || option=='c') {
            printf("\nEnter values for x, y, and z for vector U (cross): ");
            scanf("%f%f%f", &ucross[0],&ucross[1],&ucross[2]);

            printf("\nEnter values for x, y, and z for vector V (cross): ");
            scanf("%f%f%f", &vcross[0],&vcross[1],&vcross[2]);
            
            mycross(ucross,vcross,cross);

            printf("The cross product of U and V is <%f,%f,%f>.\n",cross[0],cross[1],cross[2]);
            fprintf(fptr,"The cross product of U and V is <%f,%f,%f>.\n",cross[0],cross[1],cross[2]);
            buffer_character=getchar();
        }
        
        //play again?
        printf("Play again? 'Y' or 'N': ");
        scanf("%c",&play);
        char buffer_character=getchar();
    }

}

//functions
float mydot(float vector1[], float vector2[]) {
    return vector1[0]*vector2[0] + vector1[1]*vector2[1] + vector1[2]*vector2[2];
}

void mycross(float vector3[], float vector4[], float *cross) {
    cross[0] = vector3[1]*vector4[2]-vector3[2]*vector4[1];
    cross[1] = vector3[2]*vector4[0]-vector3[0]*vector4[2];
    cross[2] = vector3[0]*vector4[1]-vector3[1]*vector4[0];
}
