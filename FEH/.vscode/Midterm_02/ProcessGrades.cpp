/**********************************************************************/
/*  AUTHOR:  Tory Yang                                                */
/*  DATE: 11/21/2022                                                  */
/*  INSTRUCTOR: Amy Kramer                                            */
/*  HOUR: 10:20 AM                                                    */
/**********************************************************************/

//libraries
#include <stdio.h>
#include <stdlib.h>

int main()
{
    //file pointers
    FILE *inptr,*outptr;

    //opens input and output files
    inptr=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\Midterm_02\\RawGrades.txt","r");
    outptr=fopen("ProcessedGrades.txt","w");

    //initialize variables and arrays
    int a=0, b=0, c=0, d=0, e=0, count;
    float Grade_1[500], Grade_2[500], Grade_3[500];
    char First_Last[100];
    
    //checks if file opens
    if (inptr==NULL) {
        printf("File couldn't open :(");
    } else {
        int i = 0;
        //scans in names and the 3 grades
        while(fscanf(inptr,"%s%f%f%f",&First_Last,&Grade_1[i],&Grade_2[i],&Grade_3[i])!=EOF) {

            //prints name and average grade
            //printf("\n%s %.1f",First_Last,(Grade_1[i]+Grade_2[i]+Grade_3[i])/3.0);
            fprintf(outptr,"\n%s %.1f",First_Last,(Grade_1[i]+Grade_2[i]+Grade_3[i])/3.0);

            //if statements to determine the grade letter on OSU grading scale
            if(Grade_1[i] >= 90) {
                a++;
            } else if(Grade_1[i]>=80 && Grade_1[i] < 90) {
                b++;
            } else if(Grade_1[i]>=70 && Grade_1[i] < 80) {
                c++;
            } else if(Grade_1[i]>=60 && Grade_1[i] < 70) {
                d++;
            } else if(Grade_1[i] < 60) {
                e++;
            } else {
                printf("Error determining grade");
            }

            if(Grade_2[i] >= 90) {
                a++;
            } else if(Grade_2[i]>=80 && Grade_2[i] < 90) {
                b++;
            } else if(Grade_2[i]>=70 && Grade_2[i] < 80) {
                c++;
            } else if(Grade_2[i]>=60 && Grade_2[i] < 70) {
                d++;
            } else if(Grade_2[i] < 60) {
                e++;
            } else {
                printf("Error determining grade");
            }

            if(Grade_3[i] >= 90) {
                a++;
            } else if(Grade_3[i]>=80 && Grade_3[i] < 90) {
                b++;
            } else if(Grade_3[i]>=70 && Grade_3[i] < 80) {
                c++;
            } else if(Grade_3[i]>=60 && Grade_3[i] < 70) {
                d++;
            } else if(Grade_3[i] < 60) {
                e++;
            } else {
                printf("Error determining grade");
            }           
            
            i++;
        }

        //prints number of each grade
        printf("\nThere were %d A's, %d B's, %d C's, %d D's, and %d E's.",a,b,c,d,e);
        //fprintf(outptr,"\nThere were %d A's, %d B's, %d C's, %d D's, and %d E's.",a,b,c,d,e);

    }

    //closes files
    fclose(outptr);
    fclose(inptr);

}