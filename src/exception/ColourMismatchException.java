package exception;

public class ColourMismatchException extends RuntimeException{
	public ColourMismatchException(String msg)
	{
		System.err.println(msg);
	}

}
