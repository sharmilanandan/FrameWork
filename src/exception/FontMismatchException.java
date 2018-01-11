package exception;

public class FontMismatchException extends RuntimeException {
	public FontMismatchException(String msg)
	{
		System.err.println(msg);
	}

}
