#include  <stdio.h>
#include  <math.h>
int main ( ) {
    //Initialize pointers and variables
    FILE *inFile,*outFile;
    float diameter[20], volume, surfaceArea, averageRadius, averageVolume, ASA, radius;
    float count;
    int i=0,greater=0, less=0;

    inFile=fopen("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\EWA_06\\EWA_06_gumdrops.dat","r");
    outFile=fopen("EWA_06.txt","w");

    //check if can't open file
    if(inFile==NULL) {
        printf("Error in Opening the File. :(\n");       
    } else {
        //printf("|     Radius (cm)     |     Surface Area (cm^2)     |     Volume (cm^3)     |\n");
        while(fscanf(inFile,"%f",&diameter[i])!=EOF) {
        
            volume=4.0/3.0*M_PI*pow(diameter[i]/2,3.0);
            surfaceArea=4.0*M_PI*pow(diameter[i]/2,2.0);

            averageRadius=averageRadius+diameter[i]/2;
            averageVolume+=volume;
            ASA+=surfaceArea;

            printf("The radius of the sphere is %10.3f cm.\n",diameter[i]/2);
            printf("The volume of this sphere is %10.3f cm^3.\n",volume);
            printf("The surface area of this sphere is %10.3f cm^2.\n\n",surfaceArea);
            
            //printf("|   %10.3f        |     %10.3f              |   %10.3f          |\n",radius[i],volume,surfaceArea);

            fprintf(outFile,"The radius of the sphere is %10.3f cm.\n",diameter[i]/2);
            fprintf(outFile,"The volume of this sphere is %10.3f cm^3.\n",volume);
            fprintf(outFile,"The surface area of this sphere is %10.3f cm^2.\n\n",surfaceArea);
            count++;
            i++;

        }
    }

    averageRadius=averageRadius/count;
    averageVolume=averageVolume/count;
    ASA=ASA/count;


    for(int j=0;j<count;j++) {
        if((diameter[j]/2)>averageRadius){
            greater++;
        } else {
            less++;
        }

    }


    printf("The average radius is %10.3f cm. There are %d spheres that have a greater radius than the average radius, and %d that have a smaller or equal to radius.\n",averageRadius,greater,less);
    printf("The average surface area of the spheres is %10.3f cm^2.\n",ASA);

    fprintf(outFile,"The radius is %10.3f cm. There are %d spheres that have a greater radius than the average radius, and %d that have a smaller or equal to radius.\n",averageRadius,greater,less);
    fprintf(outFile,"The average surface area of the spheres is %10.3f cm^2.\n",ASA);

    if(averageVolume>=3.0) {
        printf("Because the average volume of the sphere, %10.3f cm^3, is greater than 3.0 cm^3, the customer complaints are invalid.\n",averageVolume);
        fprintf(outFile,"Because the average volume of the sphere, %10.3f cm^3, is greater than 3.0 cm^3, the customer complaints are invalid.\n",averageVolume);
    } else {
        printf("Because the average volume of the sphere, %10.3f cm^3, is greater than 3.0 cm^3, the customer complaints are valid.\n",averageVolume);
        fprintf(outFile,"Because the average volume of the sphere, %10.3f cm^3, is greater than 3.0 cm^3, the customer complaints are valid.\n",averageVolume);
    }
    
}
