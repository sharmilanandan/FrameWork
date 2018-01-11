package exception;

public class InvalidKeywordException extends RuntimeException{

	public  InvalidKeywordException(String msg) {
		System.err.println(msg);

	}

}
