package callback;

public interface CallBackInterface{
	public default double CallBackMethod(double InputValue)
	{
		return InputValue;
	}
}

