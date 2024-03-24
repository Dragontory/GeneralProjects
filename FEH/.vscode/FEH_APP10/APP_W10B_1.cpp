/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W10B-1						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( ) {
    //Creates file pointers, initializes variables, and opens input and output file
    FILE *infile, *outfile;
    float base=0, height=0, averageBase=0, averageHeight=0, averageArea=0;
    int counter=0;
    infile=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\FEH_APP10\\W10B_triangle.txt","r");
    outfile=fopen("APP_W10B_1_result.txt","w");

    //check if file wasn't opened correctly
    if(infile==NULL) {
        printf("Error in Opening the File. :(\n");       
    } else {
        //while loop to read each base and height and calculate the area
        while(fscanf(infile,"%f%f",&base, &height)!=EOF) {
            //displays to screen and to output file
            printf("The base of the current triangle is %.3f. The height of the curent triangle is %.3f.\n",base, height);
            printf("The calculated area is %f.\n",0.5*base*height);
            fprintf(outfile,"The base of the current triangle is %.3f. The height of the curent triangle is %.3f.\n",base, height);
            fprintf(outfile,"The calculated area is %.3f.\n",0.5*base*height);

            //increments counter by 1 and sums up the base, height, and area
            averageBase+=base;
            averageHeight+=height;
            averageArea=averageArea+0.5*base*height;
            counter++;
        }
    }

    //prints number of triangles and averages to screen and to ouput file
    printf("There are %d triangles. The average base is %.3f.\n",counter, averageBase/counter);
    printf("The average height is %.3f. The average area is %.3f.\n",averageHeight/counter,averageArea/counter);
    fprintf(outfile,"There are %d triangles. The average base is %.3f.\n",counter, averageBase/counter);
    fprintf(outfile,"The average height is %.3f. The average area is %.3f.\n",averageHeight/counter,averageArea/counter);

    //closes files
    fclose(infile);
    fclose(outfile);






}