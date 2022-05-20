package exception;

import enums.EnumCode;
/**
 * 
 * @author zwg
 *
 */
public class ToolException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EnumCode enumCode;
	public ToolException() {
		super();
	}
	public ToolException(EnumCode ec) {
		super(ec.toString());
		this.enumCode = ec;
	}
	public ToolException(String message) {
		super(message);
	}
	public ToolException(String message,Throwable cause) {
		super(message,cause);
	}
	public ToolException(EnumCode ec,Throwable cause) {
		super(ec.toString(),cause);
		this.enumCode=ec;
	}
}
