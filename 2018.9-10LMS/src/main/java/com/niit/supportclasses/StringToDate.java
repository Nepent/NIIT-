package com.niit.supportclasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static Date StringtoDate(String date) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dd = null;
		
		       try {
				dd = sf.parse(date);
			} catch (ParseException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	
		return dd;
	}

}
