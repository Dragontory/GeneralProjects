/************************************************/
/*  Name:  Tory Yang       Date:  11/14/22      */
/*  Seat:  C12   File:  APP_W12B_3.cpp          */
/*  Instructor:  Amy Kramer 10:20 AM            */
/************************************************/

/*
Program to practice use of structs by creating a Calendar struct that contains date and time.  User is asked to input birth date and time and current date and time.  Calendar date and time are  converted to seconds from a "zero" time, then the time difference is computed in seconds and that time difference converted back to elapsed time in years, months, etc. and stored in a third Calendar struct.
*/


#include <stdio.h>

/* 
   Definitions of conversion constants and reference date.
*/

#define YEAR_TO_SECONDS 31557600
#define MONTH_TO_SECONDS 2628000
#define DAY_TO_SECONDS 86400 
#define HOUR_TO_SECONDS 3600
#define MINUTE_TO_SECONDS 60

#define YEAR_ZERO 1980
#define MONTH_ZERO 1
#define DAY_ZERO 1
#define HOUR_ZERO 0
#define MINUTE_ZERO 0
#define SECOND_ZERO 0

/* 
   Each struct Calendar variable will be defined by this struct.
*/

struct Calendar
{
  int year;
  int month;
  int day;
  int hour;
  int minute;
  int second;

};

/* 
   Function prototypes for each user-written function.
*/

void GetTime(struct Calendar *);
long int SecondsFromZero(struct Calendar);
void ConvertToCalendar(long int , struct Calendar *);


int main()
{
    printf("************************************************\n");
    printf("*  Name:  Tory Yang       Date:  11/14/22      *\n");
    printf("*  Seat:  C12   File:  APP_W12B_3.cpp          *\n");
    printf("*  Instructor:  Amy Kramer 10:20 AM            *\n");
    printf("************************************************\n\n");
	
/* 
   Declare three instances of "struct Calendar".

   Declare three long integer variables to hold the seconds from zero until birth, the seconds from zero until now, and the difference in seconds between the two.

   zBirth and zNow will be for user input, while zAge will be the output of ConvertToCalendar (). 
*/ 

  struct Calendar zBirth, zNow, zAge;
  long int secondsNow, secondsBirth, secondsDifference;

/* 
   Fill zBirth and zNow with input from the user
*/

  printf("\n\nTime of Birth:\n");
  GetTime(&zBirth);
  
  printf("\n\nTime Now:\n");
  GetTime(&zNow);


/* 
   Calculate the difference of the two times, in seconds, and use the ConvertToCalendar () function to get this in terms of all "struct Calendar" variables.
*/

  secondsNow = SecondsFromZero (zNow);
  secondsBirth = SecondsFromZero (zBirth);
  secondsDifference = secondsNow - secondsBirth;

  ConvertToCalendar(secondsDifference, &zAge);


/* 
   Print the results of the calculations to the screen.
*/ 

  printf("\n\n\nIt has been %ld seconds since you were born.\n", secondsDifference);
  printf("You have been alive %d years, %d months, %d days, %d hours, %d minutes, and %d seconds.\n\n", zAge.year, zAge.month, zAge.day, zAge.hour, zAge.minute, zAge.second);
}

/* 
   GetTime () is used to fill the instance of "struct Calendar" with user input.  It returns data through the pointer to a variable of type "struct Calendar". 
*/

void GetTime(struct Calendar *pTime)
{

/* 
   Print and scan statements, requiring a particular input format
*/

  
  printf("Enter Date (mm-dd-yyyy): ");
  getchar();
  getchar();
  scanf("%2d%*c%2d%*c%4d", &(*pTime).month, &(*pTime).day, &(*pTime).year);
  getchar();
  getchar();

  printf("\nEnter 24-Hour Clock Time (hh:mm:ss): ");
  getchar();
  getchar();
  scanf(" %2d%*c%2d%*c%2d", &(*pTime).hour, &(*pTime).minute, &(*pTime).second);
  getchar();
  getchar();

}

/* 
   SecondsFromZero () returns the number of seconds a variable of type "struct Calendar" is from the reference time. According to current settings, this reference time is Jan 1, 1980 at 00:00:00. The year (1980) can be modified, but the other elements of the date may not be changed in this code. 
*/

long int SecondsFromZero(struct Calendar t)
{
  long int year_seconds, month_seconds, day_seconds, hour_seconds, minute_seconds, second_seconds, total_seconds;

/*
  Convert each parts of the date and time to seconds
*/

  year_seconds = (t.year - YEAR_ZERO) * YEAR_TO_SECONDS;
  month_seconds = (t.month - MONTH_ZERO) * MONTH_TO_SECONDS;
  day_seconds = (t.day - DAY_ZERO) * DAY_TO_SECONDS;
  hour_seconds = (t.hour - HOUR_ZERO) * HOUR_TO_SECONDS;
  minute_seconds = (t.minute - MINUTE_ZERO) * MINUTE_TO_SECONDS;
  second_seconds = (t.second - SECOND_ZERO);

/*
  Once everything is converted to seconds, add them all up and return the total seconds.
*/

  total_seconds = year_seconds + month_seconds + day_seconds + hour_seconds + minute_seconds + second_seconds;

  return (total_seconds);
}

/* 
   ConvertToCalendar () requires a number of seconds and the address of a "struct Calendar" variable. It utilizes integer division to determine how many years, months, days, etc. can be created from a number of seconds.
*/

void ConvertToCalendar(long int sec, struct Calendar *pz)
{

/* 
   remainder will be reused to store the remaining seconds available after integer division.
*/

  long int remainder;
  
  remainder = sec;

  (*pz).year = remainder / YEAR_TO_SECONDS;
  remainder = remainder - (*pz).year * YEAR_TO_SECONDS;
  (*pz).month = remainder / MONTH_TO_SECONDS;
  remainder = remainder - (*pz).month * MONTH_TO_SECONDS;
  (*pz).day = remainder / DAY_TO_SECONDS;
  remainder = remainder - (*pz).day * DAY_TO_SECONDS;
  (*pz).hour = remainder / HOUR_TO_SECONDS;
  remainder = remainder - (*pz).hour * HOUR_TO_SECONDS;
  (*pz).minute = remainder / MINUTE_TO_SECONDS;
  remainder = remainder - (*pz).minute * MINUTE_TO_SECONDS;
  (*pz).second = remainder;

}

