/*
 Alex
 12/11/2014
*/

package MatrixExample_3;

import ctrix_3.*;
import ctrix_d_0.*;

public class MatrixExample_3_main {

	public static void main(String[] args) {
		
		//double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		//Ctrix a= new Ctrix(w);
		//w=null;	//Security Loop Hole
		
		//Ctrix a= new Ctrix(new double[][]{{8,6},{5,3}});	//Alternate way
		//Ctrix a= new Ctrix(2,2,2,6,1,3);	//Safest approach
		
		Ctrix a= new Ctrix(3,3,1,2,4,4,5,6,7,8,9);
		
		System.out.print("\n A:");
		Ctrix_D.display(a);
		
		System.out.print("\n A Transpose:");
		Ctrix_D.display(a.Transpose());
		
		System.out.print("\n A SubMat:");
		Ctrix_D.display(a.SubCtrix(1,1));
		
		System.out.println("\n A.Det:"+a.Det());
		
		System.out.print("\n A Inverse:");
		Ctrix_D.display(a.Inverse());
		//*/
		System.out.print("\n A*(A Inverse):");
		Ctrix_D.display(Ctrix.Product(a,a.Inverse()));
		
		//*/
		System.out.print("\n The End.");
		
	}

}
