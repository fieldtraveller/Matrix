/*
 Alex
 Ctrix v1
 12/11/2014
 */

package Ctrix_1;

public class Ctrix {
	
	private int Number_of_Rows;
	private int Number_of_Columns;
	private double Elements[][];
		
	public Ctrix()
	{
		Number_of_Rows=-1;
		Number_of_Columns=-1;
	}
	
	public Ctrix(int Number_of_Rows,int Number_of_Columns)
	{
		try{
			if((Number_of_Rows==0)||(Number_of_Columns==0))
			{
				throw new CtrixException("Array dimensions can't be zero. One of the array dimension is zero.");
			}
				
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		this.Number_of_Rows=Number_of_Rows;
		this.Number_of_Columns=Number_of_Columns;
		Elements=new double[Number_of_Rows][Number_of_Columns];
	}
	
	public Ctrix(double Elements[][])
	{
		int Number_of_Columns_temp=Elements[0].length;
		
		try{
			for(int count_0=0;count_0<Elements.length;count_0++)
			{
				if(Number_of_Columns_temp != Elements[count_0].length)
				{
					throw new CtrixException("All rows should contain equal number of columns.");
				}
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		this.Number_of_Rows=Elements.length;
		this.Number_of_Columns=Elements[0].length;
		this.Elements=Elements;
	}
	
	public void setElement(int RowValue,int ColumnValue,double ElementValue)
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))
			{
				throw new CtrixException("Array index out of Bounds.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		Elements[RowValue][ColumnValue]=ElementValue;
	}
	
	public void setEntireRow(int RowValue,double[] ElementValue)
	{
		try{
			if(ElementValue.length>=Number_of_Columns)
			{
				throw new CtrixException("Number of Columns exceeds required value.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return;
		}
		
		Elements[RowValue]=ElementValue;
	}
	
	public void setEntireColumn(int ColumnValue,double[][] ElementValue)
	{
		try{
			if(ElementValue.length >= Number_of_Rows)
			{
				throw new CtrixException("Number of Rows exceeds required value.");
			}
			
			for(int count_0=0;count_0 < Number_of_Rows; count_0++)
			{
				if(ElementValue[count_0].length != 1)
				{
					throw new CtrixException("Not a Column Vector");
				}			
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return;
		}
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			Elements[count_0][ColumnValue]=ElementValue[count_0][1];
		}
	}
	
	public double getElement(int RowValue,int ColumnValue)
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))
			{
				throw new CtrixException("Array index out of Bounds.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return 0;
		}
		
		return Elements[RowValue][ColumnValue];
	}
	
	public double[] getEntireRow(int RowValue)
	{
		try{
			if(RowValue>=this.Number_of_Rows)
			{
				throw new CtrixException("Can't Fetch Row. Array index out of Bounds.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Ctrix.Zeros(1, 2).Elements[0];
		}
		
		return Elements[RowValue];
	}
	
	public double[][] getEntireColumn(int ColumnValue)
	{
		try{
			if(ColumnValue >= Number_of_Columns)
			{
				throw new CtrixException("Can't Fetch Column. Array index out of Bounds.");
			}
			
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Ctrix.Zeros(2,1).Elements;
		}
		
		double return_value[][]=new double[this.Number_of_Rows][1];
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			return_value[count_0][1]=Elements[count_0][ColumnValue];
		}
		
		return return_value;
	}
	
	public int getNumberofRows()
	{
		return this.Number_of_Rows;
	}
	
	public int getNumberofColumns()
	{
		return this.Number_of_Columns;
	}

	public static Ctrix Sum(Ctrix A,Ctrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new CtrixException("Array Dimension mismatch.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]+B.Elements[count_0][count_1];
			}
		}
		
		return new Ctrix(return_value);
		
	}
	
	public static Ctrix Difference(Ctrix A,Ctrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new CtrixException("Array Dimension mismatch.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]-B.Elements[count_0][count_1];
			}
		}
		
		return new Ctrix(return_value);
		
	}
	
	public static Ctrix Product(Ctrix A,Ctrix B)
	{
		try{
			if(A.Number_of_Columns!=B.Number_of_Rows)
			{
				throw new CtrixException("Matrices can't be multiplied as there is a dimension mismatch.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][B.Number_of_Columns];
		double temp_sum;
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<B.Number_of_Columns;count_1++)
			{
				temp_sum=0;
				for(int count_2=0;count_2<A.Number_of_Columns;count_2++)
				{
					temp_sum=temp_sum+A.Elements[count_0][count_2]*B.Elements[count_2][count_1];
				}
				
				return_value[count_0][count_1]=temp_sum;
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public static Ctrix MultiplyElementByElement(Ctrix A,Ctrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new CtrixException("Array Dimension mismatch.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]*B.Elements[count_0][count_1];
			}
		}
		
		return new Ctrix(return_value);
		
	}
	
	public Ctrix ScalarMultiply(double MultiplyValue)
	{
		double return_value[][]=new double[this.Number_of_Rows][this.Number_of_Columns];
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=this.Elements[count_0][count_1]*MultiplyValue;
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public Ctrix Transpose()
	{
		double return_value[][]=new double[this.Number_of_Columns][this.Number_of_Rows];
		
		for(int count_0=0;count_0<this.Number_of_Columns;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Rows;count_1++)
			{
				return_value[count_0][count_1]=this.Elements[count_1][count_0];
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public Ctrix SubCtrix(int LeaveOutRowNumber, int LeaveOutColumnNumber)
	{
		try{
			if((LeaveOutRowNumber>=Number_of_Rows)||(LeaveOutColumnNumber>=Number_of_Columns))
			{
				throw new CtrixException("Array index out of Bounds.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Ctrix.Zeros(2, 2);
		}
		
		double return_value[][] = new double[(this.Number_of_Columns-1)][(this.Number_of_Rows-1)];
		int count_3,count_4;
		
		count_3=0;
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			if(count_0 != LeaveOutRowNumber)
			{
				count_4=0;
				
				for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
				{
					
					if(count_1 != LeaveOutColumnNumber)
					{
						return_value[count_3][count_4]=this.Elements[count_0][count_1];
						count_4++;
					}
				}
				
				count_3++;
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public double Det()
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)
			{
				throw new CtrixException("Matrix is not a square Matrix.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return 0;
		}
		
		double return_value=0;
		
		if(this.Number_of_Columns == 1)
		{
			return_value=this.Elements[0][0];
		}
		if(this.Number_of_Columns == 2)
		{
			return_value=this.Elements[0][0]*this.Elements[1][1]-this.Elements[0][1]*this.Elements[1][0];
		}
		else
		{	
			for (int count_0=0;count_0<this.Number_of_Columns;count_0++) 
			{
				return_value += Math.pow(-1,count_0)*this.getElement(0,count_0)*this.SubCtrix(0,count_0).Det();
			}
		}
		
		return return_value;
	}

	protected Ctrix Minor()
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)
			{
				throw new CtrixException("Matrix is not a square Matrix.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(2,2);
		}
		
		double return_value[][]=new double[this.Number_of_Rows][this.Number_of_Columns];
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=this.SubCtrix(count_0,count_1).Det();
			}
		}
		
		return new Ctrix(return_value);
	}
	
	protected Ctrix CoFactor()
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)
			{
				throw new CtrixException("Matrix is not a square Matrix.");
			}
		}
		catch(CtrixException me)
		{
			me.printStackTrace();
			System.exit(1);
			//return Zeros(2,2);
		}
		
		double return_value[][]= this.Minor().Elements;
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=Math.pow(-1,(count_0+count_1+2))*return_value[count_0][count_1];
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public Ctrix Inverse()
	{
		return this.CoFactor().Transpose().ScalarMultiply(1/(this.Det()));
	}
	
	public static Ctrix Identity(int OrderOfMatrix)
	{
		double return_value[][]=new double[OrderOfMatrix][OrderOfMatrix];
		
		for(int count_0=0;count_0<OrderOfMatrix;count_0++)
		{
			for(int count_1=0;count_1<OrderOfMatrix;count_1++)
			{
				if(count_0==count_1)
				{
					return_value[count_0][count_1]=1;
				}
				else
				{
					return_value[count_0][count_1]=0;
				}
			}
		}
		
		return new Ctrix(return_value);
	}
	
	public static Ctrix Zeros(int Number_of_Rows,int Number_of_Columns)
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=0;
			}
		}
		
		return new Ctrix(return_value);		
	}
	
	public static Ctrix Ones(int Number_of_Rows,int Number_of_Columns)
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=1;
			}
		}
		
		return new Ctrix(return_value);		
	}
	
	public void display()
	{
		//System.out.print("Number of Rows:"+Number_of_Rows+" Number of Columns:"+Number_of_Columns);
		System.out.println();
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				//System.out.print("<["+count_0+", "+count_1+"]> ");
				System.out.print(Elements[count_0][count_1]+" ");
			}
			System.out.println();
		}
	}
	
	/*
	public static Ctrix Add(Ctrix A,Ctrix B )
	{
		return Ctrix.Sum(A,B);
	}
	
	public static Ctrix Subtract(Ctrix A,Ctrix B )
	{
		return Ctrix.Difference(A,B);
	}
	
	public static Ctrix Multiply(Ctrix A,Ctrix B)
	{
		return Ctrix.Product(A, B);
	}
		
	public static Ctrix Eye(int OrderOfMatrix)
	{
		return Identity(OrderOfMatrix);
	}
	//*/
	
}

@SuppressWarnings("serial")
class CtrixException extends Exception
{
	CtrixException(String name)
	{
		super(name);
	}
}


