package com.niit.supportclasses;

import java.util.Date;

public class BetweenDays {
	public static int days(Date date1,Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

}
