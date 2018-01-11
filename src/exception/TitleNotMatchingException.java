package exception;

public class TitleNotMatchingException extends RuntimeException {
	public TitleNotMatchingException(String msg){
		System.err.println(msg);//err for red colour msg
	}
	

}
