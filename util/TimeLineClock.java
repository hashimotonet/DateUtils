package hashimotonet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hashimotonet
 * @version 0.0.8
 */

// This class is under the test phase.
public class TimeLineClock {

	private final String STANDARD_TIME_FORMAT="YYYY/MM/dd HH:mm";
	private final SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_TIME_FORMAT);
	
	public String getFormmatedDateAndTime(Date date) {
		return sdf.format(date).toString();
	}
	
	public static synchronized String getCurrentDateAndTime() {
		TimeLineClock clock = new TimeLineClock();
		String time = clock.getFormmatedDateAndTime(new Date());
		clock = null;
		return time;
	}
	
	// debug.
	public static void main(String args[]) {
		
		TimeLineClock clock = new TimeLineClock();
		System.out.println(clock.getCurrentDateAndTime());
		System.gc();
		System.out.println(new TimeLineClock().getCurrentDateAndTime());
		System.out.println(TimeLineClock.getCurrentDateAndTime());
		
		System.out.println("Usage : call Class Method shown below.\nTimeLineClock.getCurrentDateAndTime() \nmethod from your source.");
		
	}
}
