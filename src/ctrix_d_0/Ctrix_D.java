/*
 Class with method to display a matrix on console
 ctrix_d v0
 Alex
 12/11/2014
*/

package ctrix_d_0;

import ctrix_3.*;

public class Ctrix_D {	//CLASS WITH METHOD TO DISPLAY A MATRIX ON CONSOLE

	public static void display(Ctrix A)	//METHOD TO DISPLAY A MATRIX
	{
		//System.out.print("Number of Rows:"+A.getNumberofRows()+" Number of Columns:"+A.getNumberofColumns());
		System.out.println();
		for(int count_0=0;count_0<A.getNumberofRows();count_0++)
		{
			for(int count_1=0;count_1<A.getNumberofColumns();count_1++)
			{
				//System.out.print("<["+count_0+", "+count_1+"]> ");
				System.out.print(A.getElement(count_0,count_1)+" ");
			}
			System.out.println();
		}
	}
	
}
