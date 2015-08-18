/*
 Java Based Linear Algebra Library
 Ctrix v1_1
 Alex
 12/11/2014
*/

package Ctrix_1_1;	//PACKAGE NAME

public class Ctrix {	//CLASS NAME
	
	private int Number_of_Rows;	//NUMBER OF ROWS IN 2D ARRAY
	private int Number_of_Columns;	//NUMBER OF COLUMNS IN 2D ARRAY
	private double Elements[][];	//2D ARRAY OF DOUBLE WHICH STORES THE ELEMENTS OF THE MATRIX
		
	public Ctrix()	//CONSTRUCTOR
	{
		Number_of_Rows=-1;	//SET INITIALLY TO -1 TO INDICATE EMPTY 2D ARRAY(MATRIX)
		Number_of_Columns=-1;
	}
	
	public Ctrix(int Number_of_Rows,int Number_of_Columns)	//CONSTRUCTOR
	{
		try{
			if((Number_of_Rows==0)||(Number_of_Columns==0))	//IF ANY VALUE ZERO THROW EXCEPTION
			{
				throw new CtrixException("Array dimensions can't be zero. One of the array dimension is zero.");	//THROW EXCEPTION SPECIFYING THE ERROR
			}
				
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(1);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return;	//OR RETURN BACK
		}
		
		this.Number_of_Rows=Number_of_Rows;	//SET VALUE BASED ON INPUT
		this.Number_of_Columns=Number_of_Columns;	
		Elements=new double[Number_of_Rows][Number_of_Columns];	//INITIALISE THE 2D ARRAY
	}
	
	public Ctrix(double Elements[][])	//CONSTRUCTOR
	{
		int Number_of_Columns_temp=Elements[0].length;	//CHECK IF NUMBER OF COUMNS OF 2D ARRAY ARE SAME FOR ALL ROWS.
		
		try{
			for(int count_0=0;count_0<Elements.length;count_0++)
			{
				if(Number_of_Columns_temp != Elements[count_0].length)
				{
					throw new CtrixException("All rows should contain equal number of columns.");	//IF NOT THROW EXCEPTION
				}
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(2);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return;	//OR RETURN BACK
		}
		
		this.Number_of_Rows=Elements.length;	//SET VALUE BASED ON INPUT
		this.Number_of_Columns=Elements[0].length;
		this.Elements=Elements;	//SET VALUE BASED ON INPUT
	}
	
	public void setElement(int RowValue,int ColumnValue,double ElementValue)	//SET VALUE OF A PARTICULAR ELEMENT
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))	//CHECK IF REQUIRED ELEMENT LOCATION IS PRESENT
			{
				throw new CtrixException("Array index out of Bounds.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(3);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return;	//OR RETURN BACK
		}
		
		Elements[RowValue][ColumnValue]=ElementValue;	//SET VALUE BASED ON INPUT
	}
	
	public void setEntireRow(int RowValue,double[] ElementValue)	//SET VALUE OF A PARTICULAR ROW OF ELEMENTS
	{
		try{
			if(ElementValue.length>=Number_of_Columns)		//CHECK IF REQUIRED ROW OF ELEMENT IS PRESENT
			{
				throw new CtrixException("Number of Columns exceeds required value.");		//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(4);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return;	//OR RETURN BACK
		}
		
		Elements[RowValue]=ElementValue;	//SET VALUE BASED ON INPUT
	}
	
	public void setEntireColumn(int ColumnValue,double[][] ElementValue)		//SET VALUE OF A PARTICULAR COLUMN OF ELEMENTS
	{
		try{
			if(ElementValue.length >= Number_of_Rows)	//CHECK IF REQUIRED ROW OF ELEMENT IS PRESENT
			{
				throw new CtrixException("Number of Rows exceeds required value.");	//IF NOT THROW EXCEPTION
			}
			
			for(int count_0=0;count_0 < Number_of_Rows; count_0++)
			{
				if(ElementValue[count_0].length != 1)	//CHECK IF THE INPUT IS A COLUMN VECTOR
				{
					throw new CtrixException("Input	not a Column Vector");	//IF NOT THROW EXCEPTION
				}			
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(5);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return;	//OR RETURN BACK
		}
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			Elements[count_0][ColumnValue]=ElementValue[count_0][1];	//SET VALUE BASED ON INPUT
		}
	}
	
	public double getElement(int RowValue,int ColumnValue)	//RETURN THE REQUIRED ELEMENT FROM THE 2D ARRAY
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))	//CHECK IF REQUIRED ELEMENT IS PRESENT
			{
				throw new CtrixException("Array index out of Bounds.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(6);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return 0;	//OR RETURN ZERO
		}
		
		return Elements[RowValue][ColumnValue];	//RETURN VALUE
	}
	
	public double[] getEntireRow(int RowValue)	//RETURN THE REQUIRED ROW OF ELEMENTS FROM THE 2D ARRAY
	{
		try{
			if(RowValue>=this.Number_of_Rows)	//CHECK IF REQUIRED ROW OF ELEMENT IS PRESENT
			{
				throw new CtrixException("Can't Fetch Row. Array index out of Bounds.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(7);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Ctrix.Zeros(1, this.Number_of_Columns).getEntireRow(0);	//OR RETURN A ZERO ROW VECTOR 
		}
		
		return Elements[RowValue];	//RETURN VALUE
	}
	
	public double[][] getEntireColumn(int ColumnValue)	//RETURN THE REQUIRED COLUMN OF ELEMENTS FROM THE 2D ARRAY
	{
		try{
			if(ColumnValue >= Number_of_Columns)	//CHECK IF REQUIRED COLUMN OF ELEMENTS IS PRESENT
			{
				throw new CtrixException("Can't Fetch Column. Array index out of Bounds.");	//IF NOT THROW EXCEPTION
			}
			
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(8);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Ctrix.Zeros(this.Number_of_Rows(), 1).getEntireColumn(0);		//OR RETURN A ZERO COLUMN VECTOR
		}
		
		double return_value[][]=new double[this.Number_of_Rows][1];
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			return_value[count_0][1]=Elements[count_0][ColumnValue];		//RETURN VALUE
		}
		
		return return_value;		//RETURN VALUE
	}
	
	public int getNumberofRows()	//GET NUMBER OF ROWS IN THE 2D ARRAY
	{
		return this.Number_of_Rows;
	}
	
	public int getNumberofColumns()	//GET NUMBER OF COLMUNS IN THE 2D ARRAY
	{
		return this.Number_of_Columns;
	}

	public static Ctrix Sum(Ctrix A,Ctrix B )	//CALCULATE THE SUM OF 2 MATRICES
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))	//CHECK IF THE 2 MATRICES MATCH IN DIMENSIONS
			{
				throw new CtrixException("Array Dimension mismatch.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(9);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);	//OR RETURN A ZERO MATRIX OF THE SAME DIMENSIONS AS THE FIRST MATRIX(A)
		}	
		
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]+B.Elements[count_0][count_1];	//COMPUTE THE SUM OF INDIVIDUAL ELEMENTS OF THE 2 MATRICES
			}
		}
		
		return new Ctrix(return_value);	//RETURN SUM OF INPUT MATRICES AS ANOTHER MATRIX
		
	}
	
	public static Ctrix Difference(Ctrix A,Ctrix B )	//CALCULATE THE DIFFERENCE OF 2 MATRICES
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))	//CHECK IF THE 2 MATRICES MATCH IN DIMENSIONS
			{
				throw new CtrixException("Array Dimension mismatch.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(10);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);	//OR RETURN A ZERO MATRIX OF THE SAME DIMENSIONS AS THE FIRST MATRIX(A)
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]-B.Elements[count_0][count_1];	//COMPUTE THE DIFFERENCE OF INDIVIDUAL ELEMENTS OF THE 2 MATRICES
			}
		}
		
		return new Ctrix(return_value);	//RETURN DIFFERENCE OF INPUT MATRICES AS ANOTHER MATRIX
		
	}
	
	public static Ctrix Product(Ctrix A,Ctrix B)	//CALCULATE THE PRODUCT OF 2 MATRICES
	{
		try{
			if(A.Number_of_Columns!=B.Number_of_Rows)	//CHECK IF THE 2 MATRICES MATCH IN DIMENSIONS
			{
				throw new CtrixException("Matrices can't be multiplied as there is a dimension mismatch.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(11);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);	//OR RETURN A ZERO MATRIX OF THE SAME DIMENSIONS AS THE FIRST MATRIX(A)
		}
		
		double return_value[][]=new double[A.Number_of_Rows][B.Number_of_Columns];
		double temp_sum;
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)	//COMPUTE THE PRODUCT OF THE 2 MATRICES
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
		
		return new Ctrix(return_value);	//RETURN PRODUCT OF INPUT MATRICES AS ANOTHER MATRIX
	}
	
	public static Ctrix MultiplyElementByElement(Ctrix A,Ctrix B )	//CALCULATE THE PRODUCT OF INDIVIDUAL ELEMENTS OF 2 MATRICES
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))	//CHECK IF THE 2 MATRICES MATCH IN DIMENSIONS
			{
				throw new CtrixException("Array Dimension mismatch.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(11);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(A.Number_of_Rows,A.Number_of_Columns);	//OR RETURN A ZERO MATRIX OF THE SAME DIMENSIONS AS THE FIRST MATRIX(A)
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]*B.Elements[count_0][count_1];	//COMPUTE THE PRODUCT OF INDIVIDUAL ELEMENTS OF THE 2 MATRICES
			}
		}
		
		return new Ctrix(return_value);	//RETURN PRODUCT OF INDIVIDUAL ELEMENTS OF INPUT MATRICES AS ANOTHER MATRIX
		
	}
	
	public Ctrix ScalarMultiply(double MultiplyValue)	//MULTIPLY A MATRIX BY A SCALAR
	{
		double return_value[][]=new double[this.Number_of_Rows][this.Number_of_Columns];
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=this.Elements[count_0][count_1]*MultiplyValue;	//COMPUTE THE PRODUCT OF INPUT SCALAR AND INPUT MATRIX 
			}
		}
		
		return new Ctrix(return_value);	//RETURN PRODUCT OF INPUT SCALAR AND INPUT MATRIX AS ANOTHER MATRIX
	}
	
	public Ctrix Transpose()	//FIND TRANSPOSE OF THE MATRIX
	{
		double return_value[][]=new double[this.Number_of_Columns][this.Number_of_Rows];
		
		for(int count_0=0;count_0<this.Number_of_Columns;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Rows;count_1++)
			{
				return_value[count_0][count_1]=this.Elements[count_1][count_0];	//FIND TRANSPOSE OF THE MATRIX ELEMENT BY ELEMENT
			}
		}
		
		return new Ctrix(return_value);	//RETURN TRANPOSE OF THE MATRIX AS ANOTHER MATRIX
	}
	
	public Ctrix SubCtrix(int LeaveOutRowNumber, int LeaveOutColumnNumber)	//RETURNS A SUB MATRIX OF THE MATRIX LEAVING OUT THE MENTIONED ROW AND COLUMN
	{
		try{
			if((LeaveOutRowNumber>=Number_of_Rows)||(LeaveOutColumnNumber>=Number_of_Columns))	//CHECK IF THE REQUIRED ROW AND COLUMN IS PRESENT
			{
				throw new CtrixException("Array index out of Bounds.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(11);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros((this.Number_of_Rows-1),(this.Number_of_Columns-1));	//OR RETURN A ZERO MATRIX OF THE SAME DIMENSIONS AS THE MATRIX
		}
		
		double return_value[][] = new double[(this.Number_of_Columns-1)][(this.Number_of_Rows-1)];
		int count_3,count_4;
		
		count_3=0;
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			if(count_0 != LeaveOutRowNumber)	//LEAVE OUT REQUIRED ROW
			{
				count_4=0;
				
				for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
				{
					
					if(count_1 != LeaveOutColumnNumber)	//LEAVE OUT REQUIRED COLUMN
					{
						return_value[count_3][count_4]=this.Elements[count_0][count_1];	//COMPUTE THE NEW MATRIX	
						count_4++;
					}
				}
				
				count_3++;
			}
		}
		
		return new Ctrix(return_value);	//RETURN REQUIRED MATRIX AS A MATRIX
	}
	
	public double Det()	//COMPUTE THE DETERMINANT OF THE MATRIX
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)	//CHECK IF THE MATRIX IS A SQUARE MATRIX
			{
				throw new CtrixException("Matrix is not a square Matrix.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(12);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return 0;	//OR RETURN ZERO
		}
		
		double return_value=0;
		
		if(this.Number_of_Columns == 1)	//MATRIX HAS SINGLE ELEMENT
		{
			return_value=this.Elements[0][0];
		}
		if(this.Number_of_Columns == 2)	//IF MATRIX IS A 2x2 SQUARE MATRIX
		{
			return_value=this.Elements[0][0]*this.Elements[1][1]-this.Elements[0][1]*this.Elements[1][0];
		}
		else	//FOR ANY OTHER SIZE MATRIX
		{	
			for (int count_0=0;count_0<this.Number_of_Columns;count_0++) 
			{
				return_value += Math.pow(-1,count_0)*this.getElement(0,count_0)*this.SubCtrix(0,count_0).Det();	//COMPUTE DETERMINANT BASED ON RECURSION
			}
		}
		
		return return_value;	//RETURN COMPUTED VALUE AS A DOUBLE
	}

	protected Ctrix Minor()	//CALCULATE THE MINOR OF THE MATRIX
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)	//CHECK IF THE MATRIX IS A SQUARE MATRIX
			{
				throw new CtrixException("Matrix is not a square Matrix.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(13);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(this.Number_of_Rows,this.Number_of_Columns);	//OR RETURN ZERO MATRIX OF THE SAME DIMENSION AS MATRIX
		}
		
		double return_value[][]=new double[this.Number_of_Rows][this.Number_of_Columns];
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=this.SubCtrix(count_0,count_1).Det();	//COMPUTE THE MINOR OF THE MATRIX ELEMENT BY ELEMENT	
			}
		}
		
		return new Ctrix(return_value);	//RETURN COMPUTED MINOR OF THE MATRIX AS ANOTHER MATRIX
	}
	
	protected Ctrix CoFactor()	//CALCULATE THE COFACTOR OF THE MATRIX
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)	//CHECK IF THE MATRIX IS A SQUARE MATRIX
			{
				throw new CtrixException("Matrix is not a square Matrix.");	//IF NOT THROW EXCEPTION
			}
		}
		catch(CtrixException me)	//CATCH EXCEPTIONS OF THE TYPE CtrixException 
		{
			me.printStackTrace();	//PRINT EXCEPTION CAUSE(MESSAGE)
			System.exit(14);	//END PROGRAM WITH NON-ZERO VALUE TO INDICATE ERROR
			//return Zeros(this.Number_of_Rows,this.Number_of_Columns);	//OR RETURN ZERO MATRIX OF THE SAME DIMENSION AS MATRIX
		}
		
		double return_value[][]= this.Minor().Elements;
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=Math.pow(-1,(count_0+count_1+2))*return_value[count_0][count_1];		//COMPUTE THE COFACTOR OF THE MATRIX ELEMENT BY ELEMENT
			}
		}
		
		return new Ctrix(return_value);	//RETURN COMPUTED COFACTOR OF THE MATRIX AS ANOTHER MATRIX
	}
	
	public Ctrix Inverse()	//CALCULATE THE INVERSE OF THE MATRIX
	{
		return this.CoFactor().Transpose().ScalarMultiply(1/(this.Det()));	//RETURN THE INVERSE OF THE MATRIX AS ANOTHER MATRIX
	}
	
	public static Ctrix Identity(int OrderOfMatrix)	//RETURNS AN IDENTITY MATRIX OF THE REQUIRED ORDER
	{
		double return_value[][]=new double[OrderOfMatrix][OrderOfMatrix];
		
		for(int count_0=0;count_0<OrderOfMatrix;count_0++)
		{
			for(int count_1=0;count_1<OrderOfMatrix;count_1++)
			{
				if(count_0==count_1)	//IF DIAGONAL ELEMENT 
				{
					return_value[count_0][count_1]=1;	//SET ELEMENT VALUE AS ONE 
				}
				else	//IF NON-DIAGONAL ELEMENT 
				{
					return_value[count_0][count_1]=0;	//SET ELEMENT VALUE AS ZERO
				}
			}
		}
		
		return new Ctrix(return_value);	//RETURN THE IDENTITY MATRIX AS MATRIX
	}
	
	public static Ctrix Zeros(int Number_of_Rows,int Number_of_Columns)	//RETURNS A MATRIX WITH ALL ELEMENTS HAVING VALUE ZERO OF THE REQUIRED DIMENSIONS
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=0;	//SET VALUE OF ALL ELEMENT AS ZERO
			}
		}
		
		return new Ctrix(return_value);	//RETURN A MATRIX OF ZEROS
	}
	
	public static Ctrix Ones(int Number_of_Rows,int Number_of_Columns)	//RETURNS A MATRIX WITH ALL ELEMENTS HAVING VALUE ONE OF THE REQUIRED DIMENSIONS
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=1;	//SET VALUE OF ALL ELEMENT AS ZERO
			}
		}
		
		return new Ctrix(return_value);	//RETURN A MATRIX OF ONES	
	}
	
	public void display()	//METHOD TO DISPLAY A MATRIX
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
	public static Ctrix Add(Ctrix A,Ctrix B )	//ALTERNATE NAME TO Ctrix.Sum() 
	{
		return Ctrix.Sum(A,B);
	}
	
	public static Ctrix Subtract(Ctrix A,Ctrix B )	//ALTERNATE NAME TO Ctrix.Difference()
	{
		return Ctrix.Difference(A,B);
	}
	
	public static Ctrix Multiply(Ctrix A,Ctrix B)	//ALTERNATE NAME TO Ctrix.Product()
	{
		return Ctrix.Product(A, B);
	}
		
	public static Ctrix Eye(int OrderOfMatrix)	//ALTERNATE NAME TO Ctrix.Identity()
	{
		return Identity(OrderOfMatrix);
	}
	//*/
	
}

@SuppressWarnings("serial")
class CtrixException extends Exception	//CUSTOM EXCEPTION CLASS FOR Ctrix
{
	/*
	CtrixException()	//CONSTRUCTOR
	{
		super();
		//DO NOTHING;
	}
	//*/
	
	CtrixException(String name)	//CONSTRUCTOR
	{
		super(name);
	}
}


