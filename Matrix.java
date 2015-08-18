package Matrix;

class Matrix {
	
	int Number_of_Rows;
	int Number_of_Columns;
	double Elements[][];
	
	Matrix()
	{
		Number_of_Rows=0;
		Number_of_Columns=0;
	}
	
	Matrix(int Number_of_Rows,int Number_of_Columns)
	{
		try{
			if((Number_of_Rows==0)||(Number_of_Columns==0))
			{
				throw new MatrixException("Array dimensions can't be zero. One of the array dimension is zero.");
			}
				
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		this.Number_of_Rows=Number_of_Rows;
		this.Number_of_Columns=Number_of_Columns;
		Elements=new double[Number_of_Rows][Number_of_Columns];
	}
	
	Matrix(double Elements[][])
	{
		int Number_of_Columns_temp=Elements[0].length;
		
		try{
			for(int count_0=0;count_0<Elements.length;count_0++)
			{
				if(Number_of_Columns_temp != Elements[count_0].length)
				{
					throw new MatrixException("All rows should contain equal number of columns.");
				}
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		this.Number_of_Rows=Elements.length;
		this.Number_of_Columns=Elements[0].length;
		this.Elements=Elements;
	}
	
	void setElement(int RowValue,int ColumnValue,double ElementValue)
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))
			{
				throw new MatrixException("Array index out of Bounds.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		Elements[RowValue][ColumnValue]=ElementValue;
	}
	
	void setEntireRow(int RowValue,double[] ElementValue)
	{
		try{
			if(ElementValue.length>=Number_of_Columns)
			{
				throw new MatrixException("Number of Columns exceeds required value.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		Elements[RowValue]=ElementValue;
	}
	
	void setEntireColumn(int ColumnValue,double[][] ElementValue)
	{
		try{
			if(ElementValue.length >= Number_of_Rows)
			{
				throw new MatrixException("Number of Rows exceeds required value.");
			}
			
			for(int count_0=0;count_0 < Number_of_Rows; count_0++)
			{
				if(ElementValue[count_0].length != 1)
				{
					throw new MatrixException("Not a Column Vector");
				}			
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return;
		}
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			Elements[count_0][ColumnValue]=ElementValue[count_0][1];
		}
	}
	
	double getElement(int RowValue,int ColumnValue)
	{
		try{
			if((RowValue>=Number_of_Rows)||(ColumnValue>=Number_of_Columns))
			{
				throw new MatrixException("Array index out of Bounds.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return 0;
		}
		
		return Elements[RowValue][ColumnValue];
	}
	
	double[] getEntireRow(int RowValue)
	{
		try{
			if(RowValue>=this.Number_of_Rows)
			{
				throw new MatrixException("Can't Fetch Row. Array index out of Bounds.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Matrix.Zeros(1, 2).Elements[0];
		}
		
		return Elements[RowValue];
	}
	
	double[][] getEntireColumn(int ColumnValue)
	{
		try{
			if(ColumnValue >= Number_of_Columns)
			{
				throw new MatrixException("Can't Fetch Column. Array index out of Bounds.");
			}
			
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Matrix.Zeros(2,1).Elements;
		}
		
		double return_value[][]=new double[this.Number_of_Rows][1];
		
		for(int count_0=0;count_0 < Number_of_Rows; count_0++)
		{
			return_value[count_0][1]=Elements[count_0][ColumnValue];
		}
		
		return return_value;
	}
	
	static Matrix Sum(Matrix A,Matrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new MatrixException("Array Dimension mismatch.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]+B.Elements[count_0][count_1];
			}
		}
		
		return new Matrix(return_value);
		
	}
	
	static Matrix Difference(Matrix A,Matrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new MatrixException("Array Dimension mismatch.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]-B.Elements[count_0][count_1];
			}
		}
		
		return new Matrix(return_value);
		
	}
	
	static Matrix Product(Matrix A,Matrix B)
	{
		try{
			if(A.Number_of_Columns!=B.Number_of_Rows)
			{
				throw new MatrixException("Matrices can't be multiplied as there is a dimension mismatch.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(A.Number_of_Rows,A.Number_of_Columns);
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
		
		return new Matrix(return_value);
	}

	static Matrix ScalarMultiply(Matrix A,double MultiplyValue )
	{
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]*MultiplyValue;
			}
		}
		
		return new Matrix(return_value);
	}
	
	static Matrix MultiplyElementByElement(Matrix A,Matrix B )
	{
		try{
			if((A.Number_of_Rows!=B.Number_of_Rows)||(A.Number_of_Columns!=B.Number_of_Columns))
			{
				throw new MatrixException("Array Dimension mismatch.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(A.Number_of_Rows,A.Number_of_Columns);
		}
		
		double return_value[][]=new double[A.Number_of_Rows][A.Number_of_Columns];
		
		for(int count_0=0;count_0<A.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_0][count_1]*B.Elements[count_0][count_1];
			}
		}
		
		return new Matrix(return_value);
		
	}
	
	static Matrix Identity(int OrderOfMatrix)
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
		
		return new Matrix(return_value);
	}
	
	static Matrix Transpose(Matrix A)
	{
		double return_value[][]=new double[A.Number_of_Columns][A.Number_of_Rows];
		
		for(int count_0=0;count_0<A.Number_of_Columns;count_0++)
		{
			for(int count_1=0;count_1<A.Number_of_Rows;count_1++)
			{
				return_value[count_0][count_1]=A.Elements[count_1][count_0];
			}
		}
		
		return new Matrix(return_value);
	}
	
	static Matrix Zeros(int Number_of_Rows,int Number_of_Columns)
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=0;
			}
		}
		
		return new Matrix(return_value);		
	}
	
	static Matrix Ones(int Number_of_Rows,int Number_of_Columns)
	{
		double return_value[][]=new double[Number_of_Rows][Number_of_Columns];
		
		for(int count_0=0;count_0<Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=1;
			}
		}
		
		return new Matrix(return_value);		
	}
	
	Matrix SubMatrix(int LeaveOutRowNumber, int LeaveOutColumnNumber)
	{
		try{
			if((LeaveOutRowNumber>=Number_of_Rows)||(LeaveOutColumnNumber>=Number_of_Columns))
			{
				throw new MatrixException("Array index out of Bounds.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Matrix.Zeros(2, 2);
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
		
		return new Matrix(return_value);
	}
	
	static double Det(Matrix A)
	{
		try{
			if(A.Number_of_Columns!=A.Number_of_Rows)
			{
				throw new MatrixException("Matrix is not a square Matrix.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return 0;
		}
		
		double return_value=0;
		
		if(A.Number_of_Columns == 1)
		{
			return_value=A.Elements[0][0];
		}
		if(A.Number_of_Columns == 2)
		{
			return_value=A.Elements[0][0]*A.Elements[1][1]-A.Elements[0][1]*A.Elements[1][0];
		}
		else
		{	
			for (int count_0=0;count_0<A.Number_of_Columns;count_0++) 
			{
				return_value += Math.pow(-1,count_0)*A.getElement(0,count_0)*Matrix.Det(A.SubMatrix(0,count_0));
			}
		}
		
		return return_value;
	}

	protected Matrix Minor()
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)
			{
				throw new MatrixException("Matrix is not a square Matrix.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(2,2);
		}
		
		double return_value[][]=new double[this.Number_of_Rows][this.Number_of_Columns];
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=Matrix.Det(this.SubMatrix(count_0,count_1));
			}
		}
		
		return new Matrix(return_value);
	}
	
	protected Matrix CoFactor()
	{
		try{
			if(this.Number_of_Columns!=this.Number_of_Rows)
			{
				throw new MatrixException("Matrix is not a square Matrix.");
			}
		}
		catch(MatrixException me)
		{
			me.printStackTrace();
			return Zeros(2,2);
		}
		
		double return_value[][]= this.Minor().Elements;
		
		for(int count_0=0;count_0<this.Number_of_Rows;count_0++)
		{
			for(int count_1=0;count_1<this.Number_of_Columns;count_1++)
			{
				return_value[count_0][count_1]=Math.pow(-1,(count_0+count_1+2))*return_value[count_0][count_1];
			}
		}
		
		return new Matrix(return_value);
	}
	
	static Matrix Inverse(Matrix A)
	{
		return Matrix.ScalarMultiply(Matrix.Transpose(A.CoFactor()), (1/(Matrix.Det(A))));
	}
	
}

class MatriX extends Matrix{
	
	MatriX(double Elements[][])
	{
		super(Elements);
	}
	
	static Matrix Add(Matrix A,Matrix B )
	{
		return Matrix.Sum(A,B);
	}
	
	static Matrix Subtract(Matrix A,Matrix B )
	{
		return Matrix.Difference(A,B);
	}
	
	static Matrix Multiply(Matrix A,Matrix B)
	{
		return Matrix.Product(A, B);
	}
	
	Matrix ScalarMultiply(double MultiplyValue )
	{	
		return super.ScalarMultiply(this,MultiplyValue);
	}
	
	static Matrix Eye(int OrderOfMatrix)
	{
		return Identity(OrderOfMatrix);
	}
	
	Matrix Transpose()
	{
		return Matrix.Transpose(this);
	}
	
	void display()
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

	public static void main(String[] arg)
	{
		double w[][]={{1,2,4},{4,5,6},{7,8,9}};
		MatriX a= new MatriX(w);
		//Matrix b=Matrix.Ones(2,2);
		
		a.display();
		
		//a.ScalarMultiply(2);
		//a.TransposeOnSelf();
		//a=Matrix.Transpose(a);
		Matrix c=MatriX.Multiply(a, Matrix.Inverse(a));
		//Matrix c=  Matrix.Inverse(a);
		//a.SubMatrix(0,0).display();
		a.display();
		c.display();
		
		//System.out.print(Matrix.Det(a));
	}
}

@SuppressWarnings("serial")
class MatrixException extends Exception
{
	MatrixException(String name)
	{
		super(name);
	}
}


