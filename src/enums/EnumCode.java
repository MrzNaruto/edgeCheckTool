package enums;

/**
 * 
 * @author zwg
 *
 */
public enum EnumCode {
	E0("0","核对文件失败"),
	E1("1","打开文件或读取文件失败");
	private String code;
	private String name;
	private EnumCode(String code,String name) {
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "错误码:"+this.getCode()+","+this.getName();
	}
}
