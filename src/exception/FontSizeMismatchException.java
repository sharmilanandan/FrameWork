package exception;

public class FontSizeMismatchException extends RuntimeException {
	public FontSizeMismatchException(String msg)
	{
		System.err.println(msg);
	}

}
