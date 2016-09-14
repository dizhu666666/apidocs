package com.doc.util;

public class HttpMethodUtil {
	 
	public static String codeToMethod(int type){
		String method="POST";
		switch (type) {
		case 1:
			method="GET";
			break;
		case 2:
			method="POST";
			break;
		case 3:
			method="PUT";
			break;
		case 4:
			method="DELETE";
			break;

		default:
			break;
		}
		return method;
	}
	
}
