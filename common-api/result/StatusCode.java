package org.szh.result;

public enum StatusCode {
	_200("200","success");
	
	
	private String code;

	private String msg;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private StatusCode(String code,String msg) {
		this.code= code;
		this.msg = msg;
	}
}
