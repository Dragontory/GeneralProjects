/*  Name:  Tory	Yang					                 */
/*  Date:  11/14/2022     						         */
/*  Assignment:  APP W12B-1						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

//libraries
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <math.h>
#include <string.h>
#include <stdlib.h>

//definitions
#define FALSE 0
#define TRUE 1

using namespace std;

//main
int main () {  
    //initliazes variables and opens input and output files 
    ifstream fin;
    ofstream fout;
    float triangle[5][2], hypotenuse;
    char calculation;
    char quit = FALSE;
    int option;

    fin.open("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\FEH_APP13\\W13B_triangle.txt");
    fout.open("my_output.dat", fstream::app);

    //reads in data
    //for(int i = 0; i < sizeof(arr)/sizeof(arr[0]); i++)
    for(int i = 0; i < 5; i++) {
        fin >> triangle[i][0] >> triangle [i][1];
    }

    //while loop to play again
    while(quit == FALSE) {
        //prompts user for triangle number and calculates hypotenuse
        cout << "\n\nEnter a Triangle Number (1-5): ";
        cin >> option;
        hypotenuse = sqrt(pow(triangle[option-1][0],2.0)+pow(triangle[option-1][1],2.0));

        //prompts user to choose a calculation or to quit
        cout << "P,p - Calculate the Perimeter" << endl;
        cout << "A,a - Calculate the Area" << endl;
        cout << "H,h - Calculate the Hypotenuse" << endl;
        cout << "Q,q - Quit :(" << endl;
        cin >> calculation;

        //switch case to carry out chosen calculation
        switch (calculation) {
            case ' ':
	        case '\n':
                break;
            //perimeter
            case 'P': 
            case 'p':
                cout << "The Perimeter of triangle " << option << " is " << hypotenuse+triangle[option-1][0]+triangle[option-1][1] << " mm" << endl;
                break; 
            //hypotenuse
            case 'H':
            case 'h':
                cout << "The Hypotenuse of triangle " << option << " is " << hypotenuse << " mm" << endl;
                break;
            //area
            case 'A':
            case 'a':
                cout << "The Area of triangle " << option << " is " << triangle[option-1][0]*triangle[option-1][1]/2 << " mm^2" << endl;
                break;
            //quit
            case 'Q':
            case 'q':
                cout << "You quit :(" << endl;
                quit = TRUE;
                break;

            default:
                cout << "Error :(" << endl;
                break;
        }

    }



    /*
    int a, b;
    cout << "Enter two integers: ";
    cin >> a >> b;

    cout << "\nThe sum of the two integers is " << a+b;
    */


}