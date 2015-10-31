package ctrix_4;

class CtrixException extends Exception	//CUSTOM EXCEPTION CLASS FOR Ctrix
{
	private static final long serialVersionUID = 2650545933427810497L;

	CtrixException()	//CONSTRUCTOR
	{
		super();
		//DO NOTHING;
	}
	
	CtrixException(String name)	//CONSTRUCTOR
	{
		super(name);
	}
}