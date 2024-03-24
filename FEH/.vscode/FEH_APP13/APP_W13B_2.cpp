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
#include <cstring>


using namespace std;

//class definition
class Year {
    //can be accessed by client
    public:
        Year(int y);
        void GetData();
        void FindMax();
        void Average();
        void DisplayValues();
    //cant be accessed by client
    private:
        int current_year;
        int max_index;
        float year_avg;
        float monthly_avg[12];
};

//main
int main() {
    //initializes three variables for y and prompts user for 3 years
    int a,b,c;
    cout << endl << "Enter any 3 years between 1980 and 2007: ";
    cin >> a >>b>>c;
    Year y1(a);
    Year y2(b);
    Year y3(c);

    //calculates for first year entered
    y1.GetData();
    y1.FindMax();
    y1.Average();
    y1.DisplayValues();
    
    //calculates for second year entered
    y2.GetData();
    y2.FindMax();
    y2.Average();
    y2.DisplayValues();

    //calculates for third year entered
    y3.GetData();
    y3.FindMax();
    y3.Average();
    y3.DisplayValues();

}

//constructor
Year::Year(int y) {
    max_index=0;
    year_avg=0;

    //sets all array elements to 0
    for(int i = 0; i < 12; i++) {
        monthly_avg[i]=0;
    }
    current_year = y;

}

//GetData function
void Year::GetData(){
    //opens input file
    ifstream fin;
    fin.open("C:\\Users\\toryy\\OneDrive\\Documents\\Visual Studio Code\\FEH\\.vscode\\FEH_APP13\\W13B_co2data.txt");

    //gets data for the corresponding year
    for(int i = 0; i < (current_year-1979)*12; i++) {
        fin >> monthly_avg[i%12];
    }
    
};

//FindMxx function
void Year::FindMax() {
    
    //for loops to find max in array
    for(int i = 0; i < 12; i++) {
        if(monthly_avg[max_index]<monthly_avg[i]) {
            max_index=i;
        }

    }

};

//average function
void Year::Average() {

    float sum = 0;
    //for loop to calculate sum of all elements
    for(int i = 0; i < 12; i++) {
        sum+=monthly_avg[i];
    }
    //calculates average
    year_avg=sum/12.0;

};

//DisplayValues function that displays the results
void Year::DisplayValues() {
    cout << "The current year entered is " << current_year << "." << endl;
    cout << "The average CO2 concentration for this year is " << year_avg << " ppm." << endl;
    cout << "The month with the higehst CO2 concentraion was month " << max_index+1 << " with a concentration of " << monthly_avg[max_index] << " ppm." << endl;

};





  
    