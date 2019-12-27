package org.szh.result;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = -7564756185960774910L;

	private String msg = "success";
	
	private String code = "200";
	
	private Date today = Calendar.getInstance().getTime();
	
	private T data;
	
	public Result(StatusCode status ) {
		code = status.getCode();
		msg = status.getMsg();
	}
	
	public boolean isSuccess() {
		return code.equals("200");
	}

}
