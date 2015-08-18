/*
 Alex
 12/11/2014
 */

package MatrixExample_1;

import ctrix_4.*;
import callback.*;

public class MatrixExample_1_main {

	public static void main(String[] args) {
		
		double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		Ctrix a= new Ctrix(w);
		w=null;	//Security Loop Hole
		
		Ctrix b=Ctrix.Ones(3,3);
		
		System.out.print("\n A:");
		a.display();
		
		System.out.print("\n B:");
		b.display();
		
		System.out.print("\n A+B:");
		Ctrix.Sum(a, b).display();
		
		System.out.print("\n A-B:");
		Ctrix.Difference(a, b).display();
		
		System.out.print("\n A*B:");
		Ctrix.Product(a, b).display();
		
		System.out.print("\n A Transpose:");
		a.Transpose().display();
		
		System.out.print("\n A Inverse:");
		a.Inverse().display();
		
		System.out.print("\n A*(A Inverse):");
		Ctrix.Product(a,a.Inverse()).display();
		//*/
		System.out.print("\n CallBackMethod:");
		a.CallBack(new addone()).display();
		
		System.out.print("\n The End.");
		
	}

}

class addone implements CallBackInterface{
	
	public double CallBackMethod(double InputValue)
	{
		return (InputValue+1);
	}
	
}

