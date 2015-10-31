package ctrix_4;

public abstract interface CtrixDisplay {
	
	default void display()	//METHOD TO DISPLAY A MATRIX
	{
		System.out.println();
		for(int count_0=0;count_0<((Ctrix)this).getNumberofRows();count_0++)
		{
			for(int count_1=0;count_1<((Ctrix)this).getNumberofColumns();count_1++)
			{
				//System.out.print("<["+count_0+", "+count_1+"]> ");
				System.out.print(((Ctrix)this).getElement(count_0,count_1)+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	default void display(int width,int precision)
	{
		String format="%0"+width+"."+precision+"f ";
		System.out.println();
		for(int count_0=0;count_0<((Ctrix)this).getNumberofRows();count_0++)
		{
			for(int count_1=0;count_1<((Ctrix)this).getNumberofColumns();count_1++)
			{
				//System.out.print("<["+count_0+", "+count_1+"]> ");
				System.out.printf(format,((Ctrix)this).getElement(count_0,count_1));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	default void displayNumberOfRows()
	{
		System.out.println("Number of Rows: "+((Ctrix)this).getNumberofRows());
	}
	
	default void displayNumberOfColumns()
	{
		System.out.println("Number of Columns: "+((Ctrix)this).getNumberofColumns());
	}	
}
