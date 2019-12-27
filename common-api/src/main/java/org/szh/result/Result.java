package org.szh.result;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable{
	
	private static final long serialVersionUID = -7564756185960774910L;

	private String msg = "success";
	
	private String code = "200";
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date today = Calendar.getInstance().getTime();
	
	private T data;
	
	public Result(StatusCode status ) {
		code = status.getCode();
		msg = status.getMsg();
	}
	
	public Result (T data) {
		this.data = data;
	}
	
	public boolean isSuccess() {
		return code.equals("200");
	}

}
