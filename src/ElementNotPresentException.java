
//creating exception to fail the script
public class ElementNotPresentException extends RuntimeException {
	public ElementNotPresentException(String msg) {
		System.err.println(msg);
		}
}
