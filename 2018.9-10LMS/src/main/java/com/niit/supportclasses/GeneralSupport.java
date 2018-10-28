package com.niit.supportclasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* created by :-n
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

public class GeneralSupport {

	public static String getDate() {
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	     Date dateobj = new Date();
	     String date=df.format(dateobj).toString();
	     return date;
	}

}
