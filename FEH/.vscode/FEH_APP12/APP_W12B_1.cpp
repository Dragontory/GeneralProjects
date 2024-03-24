/*  Name:  Tory	Yang					                 */
/*  Date:  11/14/2022     						         */
/*  Assignment:  APP W12B-1						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//libraries
#include <stdio.h>

//new added struct definition
struct Student {
char Name[30];
int classRank;
};

//struct definition
struct BuckID_Account {
long int ID;
float Dollars;
int mealBlocks;
struct Student Personal;
};

//function prototype
void fillstruct (struct BuckID_Account [], int );

int main ( ) {

//variable and struct declarations
int k,n;
struct BuckID_Account OSU[3];

//for loop to fill struct
for ( n = 1 ; n <= 3 ; n++ ) {
printf("\n\nEnter data for Student # %d\n", n);
fillstruct (OSU, n - 1);
}

//prints elements for each struct
for ( k = 0 ; k < 3 ; k++ ) {

//modified name and added class rank and meal blocks
printf("\n%s, ID# %d,\n", OSU[k].Personal.Name, OSU[k].ID);
printf("is ranked number %d in his class.\n",OSU[k].Personal.classRank);
printf("They have a balance of $%6.2f and a meal block of %d.\n", OSU[k].Dollars, OSU[k].mealBlocks);
}

}

//function fillstruct
void fillstruct (struct BuckID_Account a[], int j)

{

printf ("Enter BuckID Number: ");
scanf ("%ld", &a[j].ID);

//modified
printf ("Enter Student Name: ");
scanf ("%s", &a[j].Personal.Name);

//added classRank
printf ("Enter Class Rank: ");
scanf ("%d", &a[j].Personal.classRank);

printf ("Enter Account Balance: ");
scanf ("%f", &a[j].Dollars);

//added mealBlocks
printf ("Enter Meal Block: ");
scanf ("%d", &a[j].mealBlocks);


}