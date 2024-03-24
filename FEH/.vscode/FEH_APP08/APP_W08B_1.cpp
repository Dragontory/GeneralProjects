/*  Name:  Tory	Yang					                 */
/*  Date:  10/17/2022     						         */
/*  Assignment:  APP W08B-1						         */
/*  Seat:  C12		Instructor:  Kramer		Time:  10:20 */

#include  <stdio.h>
#include  <math.h>
int main ( )
{

    printf ("**************************************************\n");
    printf ("*  Name:  Tory Yang   Date:  10/17/22            *\n");
    printf ("*  Seat:  C12    File:  APP_W08B_1.cpp           *\n");
    printf ("*  Instructor: Kramer  ABC 10:20:MM              *\n");
    printf ("************************************************\n\n");

	int a, b, c ;
	float w, x, y = 2, z ;
	
	int e = 8, f = 0.50, g = 1, h = 10.999 ;
	float q = 6, r = .75, s = 7, t = 9/4 ;

	w = g / e - 110 * f;	   	 	/* w = ____0______*/
    printf("w=%f\n",w);

	w += h;					        /* w = ____10______*/
    printf("w=%f\n",w);

	a = t + pow (g, q);			    /* a = ____3______*/
    printf("a=%d\n",a);

	b = --w + t;					/* b = ____11______*/
    printf("b=%d\n",b);

	x = h % e++;					/* x = ____2______*/
    printf("x=%f\n",x);

	y = (e + w) * y;				/* y = ____38______*/
    printf("y=%f\n",y);

	c = (++s);					    /* c = _____8_____*/
    printf("c=%d\n",c);

	z = r * s + h / e + q;			/* z = ____13______*/
    printf("z=%f\n",z);

    h = pow (c,2);                  /* h = ____64______*/
    printf("h=%d\n",h);

}
