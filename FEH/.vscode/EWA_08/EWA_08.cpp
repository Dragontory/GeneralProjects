/************************************************/
/*  Name:  Tory Yang       Date:  11/13/22      */
/*  Seat:  C12    File:  EWA_08.cpp             */
/*  Instructor:  Amy Kramer 10:20 AM            */
/************************************************/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
  Create a few constants to define the number of rows and columns
  as well as setting up TRUE and FALSE
*/

#define ROWS 5
#define COLUMNS 5
#define ELEMENTS 10
#define FALSE 0
#define TRUE 1
#define MAX_BUFFER 256

/*
  Function prototypes - these are the "fingerprints" or "signatures"
  of the functions.  They provide the function's return type, its
  name, and the data types of each argument passed into or out of
  the function (variable names are optional and are merely
  "dummy" names).

  You will want to look at these closely, comparing them to the 
  function calls and function definitions below.

  It's probably a good idea to look at the printarray () examples
  in lecture 15.
*/
void VectorRowDisplay (int *, int, FILE *);
void VectorColDisplay (int d1[], int d2, FILE *);
void VectorFill (int *, int, int, FILE *);
void MatrixDisplay (float [][COLUMNS], int, FILE *);
void MatrixFill (float *, float, int, int, FILE *);

int main ()
{
  FILE *output_file_ptr;
 
  char filename_array[100];
  char flush[MAX_BUFFER];
  char quit = FALSE;
  char response;

  int vector[ELEMENTS];
  int i;
  int j;
  int row;
  int ivalue;

  float fvalue;
  float matrix[ROWS][COLUMNS];

  /*
    Copy the filename into the filename_array.  We'll open the file using what's
    stored in the array, rather than the filename directly.
  */
  strcpy (filename_array, "ewa05.txt");

  /*
    Open the file
  */
  output_file_ptr = fopen (filename_array, "w");

  /*
    Check to see if the file opened successfully.  If it did not, let the user know
    and exit the program.

    Otherwise, let the user know the file opened and let them know you'll be thinking
    about them.
  */
  if (output_file_ptr == NULL)
    {
      printf ("\n\n***\t%s did not open.  We're going to quit now *** \n\n", filename_array);
      exit (0);
    }
  else
    {
      printf ("\n***\t%s opened.  Have fun...but not too much fun  *** \n", filename_array);      
    }
  
  /*
    Let the world know who did the work.  Write it to the file, too.  Modify the
    print statements with your information.
  */
  printf ("\n\n");
  printf ("\t**************************************************\n");
  printf ("\t*** Tory Yang                                  ***\n");
  printf ("\t*** Seat C12  Date: 11/13/22                   ***\n");
  printf ("\t*** Instructor:  Amy Kramer  Assignment: ewa08 ***\n");
  printf ("\t*** File:  EWA_08.cpp                          ***\n");
  printf ("\t**************************************************\n");
  printf ("\n\n");

  fprintf (output_file_ptr, "\n\n");
  fprintf (output_file_ptr, "\t**************************************************\n");
  fprintf (output_file_ptr, "\t*** Tory Yang                                  ***\n");
  fprintf (output_file_ptr, "\t*** Seat C12  Date: 11/13/22                   ***\n");
  fprintf (output_file_ptr, "\t*** Instructor:  Amy Kramer  Assignment: ewa08 ***\n");
  fprintf (output_file_ptr, "\t*** File:  EWA_08.cpp                          ***\n");
  fprintf (output_file_ptr, "\t**************************************************\n");
  fprintf (output_file_ptr, "\n\n");

  /*
    Fill the 1D and 2D matrices with zeroes to start.
  */
  for (i = 0; i < ELEMENTS; i++)
    {
      vector[i] = 0;
    }

  for (i = 0; i < ROWS; i++)
    {
      for (j = 0; j < COLUMNS; j++)
	{
	  matrix[i][j] = 0.0;
	}
    }
  /*
    This is the big loop.  Do it until the user wants to quit.
  */
  while (quit == FALSE)
    {
      /*
	Print out all the choices for commands.  Write them to the
	output file, too.
      */
      printf ("\n");
      printf ("\n\ta, A\t-\tDisplay the one dimensional matrix as a row");
      printf ("\n\tb, B\t-\tDisplay the one dimensional matrix as a column");
      printf ("\n\tc, C\t-\tFill the one dimensional matrix with an int");
      printf ("\n\td, D\t-\tDisplay the two dimensional matrix");
      printf ("\n\te, E\t-\tFill the two dimensional matrix");
      printf ("\n\tq, Q\t-\tQuit");

      fprintf (output_file_ptr, "\n");
      fprintf (output_file_ptr, "\n\ta, A\t-\tDisplay the one dimensional matrix as a row");
      fprintf (output_file_ptr, "\n\tb, B\t-\tDisplay the one dimensional matrix as a column");
      fprintf (output_file_ptr, "\n\tc, C\t-\tFill the one dimensional matrix with an int");
      fprintf (output_file_ptr, "\n\td, D\t-\tDisplay the two dimensional matrix");
      fprintf (output_file_ptr, "\n\te, E\t-\tFill the two dimensional matrix");
      fprintf (output_file_ptr, "\n\tq, Q\t-\tQuit");

      /*
	Prompt user for their choice, read the choice into "response", 
	and then make sure the input buffer is cleared.  As usual, 
	everything that goes to the screen also goes to the output file
      */
      printf ("\n\n\tOperation:  ");
      fprintf (output_file_ptr, "\n\n\tOperation:  ");
      scanf ("%c", &response);
      fprintf (output_file_ptr, "%c\n", response);
      fgets (flush, MAX_BUFFER-1, stdin);

      /*
	Switch on "response" to decide what to do.

	The user should be able to do each choice using either the upper or
	lower case letter that goes with the command.
      */
      switch (response)
	{
	  /*
	    The ' ' and '\n' cases allow empty lines or spaces
	    to be ignored without an error message.
	  */
	case ' ':
	case '\n':

	  break;

	  /*
	    The a/A case calls the function that displays the
	    1D vector as a row vector.

	    This function is passed the address of the beginning
	    of the vector, the number of elements in the vector, and
	    the file pointer.
	  */
	case 'a':
	case 'A':
	  VectorRowDisplay (vector, ELEMENTS, output_file_ptr);

	  break;

	  /*
	    The b/B case calls the function that displays the
	    1D vector as a column vector.

	    This function is passed the address of the beginning
	    of the vector, the number of elements in the vector, and
	    the file pointer.
	  */
	case 'b':
	case 'B':
	  VectorColDisplay (vector, ELEMENTS, output_file_ptr);

	  break;

	  /*
	    The c/C case asks the user for an integer and then
	    calls the function to fill the 1D vector with integers
	    starting with the value entered by the user and 
	    incrementing by 1.

	    This function is passed the address of the beginning of
	    the vector, the number of elements in the vector, and
	    the file pointer.

	    The value read in from the user is stored in ivalue.
	  */
	case 'c':
	case 'C':
	  printf ("\nInteger: ");
	  fprintf (output_file_ptr, "\nInteger: ");
	  scanf ("%d", &ivalue);
	  fprintf (output_file_ptr, "%d\n", ivalue);
	  fgets (flush, MAX_BUFFER-1, stdin);
	  VectorFill (vector, ELEMENTS, ivalue, output_file_ptr);

	  break;

	  /*
	    The d/D case calls the function that displays the
	    2D matrix. 

	    This function is passed the address of the beginning
	    of the matrix, the number of columns in the matrix, and
	    the file pointer
	  */
	case 'd':
	case 'D':
	  MatrixDisplay (matrix, COLUMNS, output_file_ptr);

	  break;

	  /*
	    The e/E case asks the user for a floating point value
	    and then calls the function to fill the 2D matrix with
	    values starting with the value entered by the user and
	    incrementing by 0.5.

	    This function is passed the address of the beginning of
	    the matrix, the value entered by the user, the number of
	    rows, the number of columns, and the file pointer
	  */
	case 'e':
	case 'E':
	  printf ("\nFloat: ");
	  fprintf (output_file_ptr, "\nFloat: ");
	  scanf ("%f", &fvalue);
	  fprintf (output_file_ptr, "%f\n", fvalue);
	  fgets (flush, MAX_BUFFER-1, stdin);
	  MatrixFill (&matrix[0][0], fvalue, ROWS, COLUMNS, output_file_ptr);

	  break;

	  /*
	    Uhh...quit, I guess.

	    Set the quit variable's value to TRUE so that when it gets to the while
	    statement again, the condition will no longer be valid and the while
	    loop will quit.

	    Let the user know you've quit.

	    This seems like a good place to close the file you opened, too.
	  */
	case 'q':
	case 'Q':

	  printf ("\n\n\t*** Quitting Matrix Manipulation ***\n\n");
	  fprintf (output_file_ptr, "\n\n\t*** Quitting Matrix Manipulation ***\n\n");

	  quit = TRUE;

	  fclose (output_file_ptr);

	  break;

	  /*
	    Let the user know they've entered invalid input.  Also a good idea
	    for catching extraneous characters from the input buffer during
	    early debugging of the program.

	    Always a good idea to use default for invalid cases, NOT for the last
	    choice of valid ones.
	  */
	default:

	  printf ("\n\t*** Error:  Invalid operation ***\n\n");
	  fprintf (output_file_ptr, "\n\t*** Error:  Invalid operation ***\n\n");
	}
    }
}

/*
  VectorRowDisplay

  v - the address of the array being passed in being used as a pointer to int
  n - an int (the number of elements in the array)
  fp - a pointer to FILE 

  You may want to look at the printarray () examples from lecture 15
  if you've got questions on this one.
*/
void VectorRowDisplay (int *v, int n, FILE *fp)
{
  int i;

  printf ("\n***\tBegin VectorRowDisplay\t***\n\n");
  fprintf (fp, "\n***\tBegin VectorRowDisplay\t***\n\n");

  for (i = 0; i < n; i++)
    {
      printf ("%d  ", *v);
      fprintf (fp, "%d  ", *v);
      v++;
    }
  printf ("\n\n***\tEnd VectorRowDisplay\t***\n");
  fprintf (fp, "\n\n***\tEnd VectorRowDisplay\t***\n");
}

/*
  VectorColDisplay
  
  w - the address of the array being passed in being used as an int array
  m - an int (the number of elements in the array)
  fp - a pointer to FILE

  You may want to look at the printarray () examples from lecture 15
  if you've got questions on this one.
*/
void VectorColDisplay (int w[], int m, FILE *fp)
{
  int i;

  printf ("\n***\tBegin VectorColDisplay\t***\n\n");
  fprintf (fp, "\n***\tBegin VectorColDisplay\t***\n\n");

  for (i = 0; i < m; i++)
    {
      printf ("\t\t\t%d\n", w[i]);
      fprintf (fp, "\t\t\t%d\n", w[i]);
    }
  printf ("\n\n***\tEnd VectorColDisplay\t***\n");
  fprintf (fp, "\n\n***\tEnd VectorColDisplay\t***\n");
}
/*
  VectorFill

  v - the address of the array being passed in being used as a pointer to int
  n - an int (the number of elements in the array)e
  value - an int (the starting value to be assigned to the elements of the array
  fp - a pointer to FILE

  You may want to look at the printarray () examples from lecture 15
  if you've got questions on this one.
*/
void VectorFill (int *v, int n, int value, FILE *fp)
{
  int i;

  printf ("\n***\tBegin VectorFill\t***\n\n");
  fprintf (fp, "\n***\tBegin VectorFill\t***\n\n");

  for (i = 0; i < n; i++)
    {
      *v = value + i;
      v++;
    }
  printf ("\n\n***\tEnd VectorFill\t***\n");
  fprintf (fp, "\n\n***\tEnd VectorFill\t***\n");
}

/*
  MatrixDisplay

  x - the address of the beginning of the 2D float array being passed
  in.  x will act as a 2D array in this function
  columns - an int (the number of columns in the array
  fp - a pointer to FILE

  You may want to look at the printarray () examples from lecture 15
  if you've got questions on this one.
*/
void MatrixDisplay (float x[][COLUMNS], int columns, FILE *fp)
{
  int i, j;

  printf ("\n***\tBegin MatrixDisplay\t***\n\n");
  fprintf (fp, "\n***\tBegin MatrixDisplay\t***\n\n");

  for (i = 0; i < ROWS; i++)
    {
      for (j = 0; j < columns; j++)
	{
	  printf ("%10.3f", x[i][j]);
	  fprintf (fp, "%10.3f", x[i][j]);
	}
      printf ("\n");
      fprintf (fp, "\n");
    }

  printf ("\n***\tEnd MatrixDisplay\t***\n\n");
  fprintf (fp, "\n***\tEnd MatrixDisplay\t***\n\n");

}

/*
  MatrixFill

  pf - the address of the beginning of the 2D float array being passed
  in.  pf will be used as a pointer in this function
  x - a float, the initial value being assigned to the elements of the
  2D float array.  each element will be incremented by 0.5
  rows - an int (the number of rows in the matrix)
  column - an int (the number of columns in the matrix)
  fp - a pointer to FILE

  You may want to look at the printarray () examples from lecture 15
  if you've got questions on this one.
*/
void MatrixFill (float *pf, float x, int rows, int columns, FILE *fp)
{
  int i, j;

  printf ("\n***\tBegin MatrixFill\t***\n\n");
  fprintf (fp, "\n***\tBegin MatrixFill\t***\n\n");

  for (i = 0; i < rows; i++)
    {
      for (j = 0; j < columns; j++)
	{
	  *(pf + i * columns + j) = x;
	  x += 0.5;
	}
    }

  printf ("\n***\tEnd MatrixFill\t***\n\n");
  fprintf (fp, "\n***\tEnd MatrixFill\t***\n\n");
}