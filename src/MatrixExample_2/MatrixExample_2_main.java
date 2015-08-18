/*
 Alex
 12/11/2014
*/

package MatrixExample_2;

import ctrix_3.*;
import ctrix_d_0.*;

public class MatrixExample_2_main {

	public static void main(String[] args) {
		
		double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		Ctrix a= new Ctrix(w);
		w=null;	//Security Loop Hole
		
		//Ctrix a= new Ctrix(new double[][]{{1,2,4},{4,5,7},{7,8,9}});	//Alternate way
		
		Ctrix b=Ctrix.Ones(3,3);
		
		System.out.print("\n A:");
		Ctrix_D.display(a);
				
		System.out.print("\n B:");
		Ctrix_D.display(b);
		
		System.out.print("\n A+B:");
		Ctrix_D.display(Ctrix.Sum(a, b));
		
		System.out.print("\n A-B:");
		Ctrix_D.display(Ctrix.Difference(a, b));
		
		System.out.print("\n A*B:");
		Ctrix_D.display(Ctrix.Product(a, b));
		
		System.out.print("\n A Transpose:");
		Ctrix_D.display(a.Transpose());
		
		System.out.print("\n A Inverse:");
		Ctrix_D.display(a.Inverse());
		
		System.out.print("\n A*(A Inverse):");
		Ctrix_D.display(Ctrix.Product(a,a.Inverse()));
		
		//*/
		System.out.print("\n The End.");
		
	}

}
