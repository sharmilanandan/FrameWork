package exception;

public class ElementNotSelectedException extends RuntimeException {
	public ElementNotSelectedException(String msg) {
		System.err.println(msg);
	}

}
