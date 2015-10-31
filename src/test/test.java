/*
 Alex
 12/11/2014
 */

package test;

import ctrix_4.*;
import ctrix_4.callback.*;

public class test {

	public static void main(String[] args) {
		
		//double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		//Ctrix a= new Ctrix(w);
		//w=null;	//Security Loop Hole
				
		//Ctrix a= new Ctrix(new double[][]{{8,6},{5,3}});	//Alternate way
		//Ctrix a= new Ctrix(2,2,2,6,1,3);	//Safest approach
		
		double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		Ctrix a= new Ctrix(w);
		
		Ctrix b=Ctrix.Ones(3,3);
		
		System.out.print(" A:");
		a.display();
		
		System.out.print(" B:");
		b.display();
		
		System.out.print(" A+B:");
		Ctrix.Sum(a, b).display();
		
		System.out.print(" A-B:");
		Ctrix.Difference(a, b).display();
		
		System.out.print(" A*B:");
		Ctrix.Product(a, b).display();
		
		System.out.print(" A Transpose:");
		a.Transpose().display();
		
		System.out.print(" A Inverse:");
		a.Inverse().display();
		
		System.out.print(" A*(A Inverse):");
		Ctrix.Product(a,a.Inverse()).display();
		
		System.out.print(" CallBackMethod:");
		a.CallBack(new addone()).display();
		
		System.out.print(" Random:");
		Ctrix.Random(3, 3).display(4,2);
		
		System.out.println(new addone() instanceof CallBackAbsolute);
		System.out.println(new addone() instanceof CallBackRelative);
		
		Ctrix.AddCallBackListener(new addone());
		Ctrix.AddCallBackListener(new givemeindentity());
		a.CallBack(0).display();
		a.CallBack(1).display();
		
		System.out.print(" The End.");
	}

}

class addone implements CallBackAbsolute{
	
	@Override
	public double CallBackMethod(double InputValue)
	{
		return (InputValue+1);
	}
}

class givemeindentity implements CallBackRelative{
	
	@Override
	public Ctrix CallBackMethod(Ctrix InputValue) 
	{
		return Ctrix.Identity(3);
	}
}
