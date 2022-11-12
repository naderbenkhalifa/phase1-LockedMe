
public class ExceptionHandler extends Exception {
	public static final long serialVersionUID = 1L;
	public  int code;
	public String message;
	public ExceptionHandler(int code, String message) {
		super();
		this.code = code;
		this.message = message;

	}

}
