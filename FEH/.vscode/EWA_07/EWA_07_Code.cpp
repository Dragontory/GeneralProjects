/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  EWA_07      					         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//definitions and include statements
#include  <stdio.h>
#include  <math.h>

int main ( ) {
    //creates pointer and initializes variables
    FILE *fptr1, *fptr2;
    float number2, fAverage1, fAverage2, fAverage3, fAverage4, count1, count2, count3, count4;
    int number1, count;
    float iAverage1, iAverage2, iAverage3, iAverage4, count5, count6, count7, count8;

    //opens files
    fptr1=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\EWA_07\\EWA_07_random.dat","r");
    fptr2=fopen("EWA_07.txt","w");

    //check if can't open file
    if(fptr1==NULL) {
        printf("Error in Opening the File. :(\n");       
    } else {
        //reads in integer and float until EOF
        while(fscanf(fptr1,"%i%f",&number1,&number2)!=EOF) {
            count++;
            //switch case for integers
            switch(number1) {
                case 1: case 2: case 3: 
                    iAverage1+=number1;
                    count5++;
                    break;
                case 4: case 5: case 6: 
                    iAverage2+=number1;
                    count6++;
                    break;
                case 7: case 8: case 9: 
                    iAverage3+=number1;
                    count7++;
                    break;
                case 10: case 11: case 12: 
                    iAverage4+=number1;
                    count8++;
                    break;
                default:
                    printf("Error :(\n");
            }
            //if else for float
            if(number2>=0 && number2<=25) {
                fAverage1+=number2;
                count1++;
            } else if(number2>25 && number2<=50) {
                fAverage2+=number2;
                count2++;
            } else if(number2>50 && number2<=75) {
                fAverage3+=number2;
                count3++;
            } else if(number2>75 && number2<=100) {
                fAverage4+=number2;
                count4++;
            } else {
                printf("Error :(\n");
            }

        }

    }

    //calculates averages of each range
    iAverage1=iAverage1/count5;
    iAverage2=iAverage2/count6;
    iAverage3=iAverage3/count7;
    iAverage4=iAverage4/count8;

    fAverage1=fAverage1/count1;
    fAverage2=fAverage2/count2;
    fAverage3=fAverage3/count3;
    fAverage4=fAverage4/count4;

    //Display results to screen and output file
    printf("There are %i integers and floats.\n",count);
    fprintf(fptr2,"There are %i integers and floats.\n",count);

    printf("The average of the integers from 1-3 was %.2f.\n",iAverage1);
    printf("The average of the integers from 4-6 was %.2f.\n",iAverage2);
    printf("The average of the integers from 7-9 was %.2f.\n",iAverage3);
    printf("The average of the integers from 10-12 was %.2f.\n",iAverage4);

    printf("The average of the floats from 0 to <=25 was %.2f.\n",fAverage1);
    printf("The average of the floats from >25 to <=50 was %.2f.\n",fAverage2);
    printf("The average of the floats from >50 to <=75 was %.2f.\n",fAverage3);
    printf("The average of the floats from >75 to <=100 was %.2f.\n",fAverage4);

    fprintf(fptr2,"The average of the integers from 1-3 was %.2f.\n",iAverage1);
    fprintf(fptr2,"The average of the integers from 4-6 was %.2f.\n",iAverage2);
    fprintf(fptr2,"The average of the integers from 7-9 was %.2f.\n",iAverage3);
    fprintf(fptr2,"The average of the integers from 10-12 was %.2f.\n",iAverage4);

    fprintf(fptr2,"The average of the floats from 0 to <=25 was %.2f.\n",fAverage1);
    fprintf(fptr2,"The average of the floats from >25 to <=50 was %.2f.\n",fAverage2);
    fprintf(fptr2,"The average of the floats from >50 to <=75 was %.2f.\n",fAverage3);
    fprintf(fptr2,"The average of the floats from >75 to <=100 was %.2f.\n",fAverage4);



    //close files
    fclose(fptr1);
    fclose(fptr2);
    
}