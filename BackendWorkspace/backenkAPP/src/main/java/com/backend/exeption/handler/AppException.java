package com.backend.exeption.handler;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class AppException /* extends Exception */{
	@NonNull
	String msg;
	@NonNull
	Date time;
	
	@NonNull
	String defaultmsg;
	


}