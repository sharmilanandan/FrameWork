package exception;

public class UrlNotMatchingException  extends RuntimeException{
	public UrlNotMatchingException(String msg)
	{
		System.err.println(msg);
	}

}
