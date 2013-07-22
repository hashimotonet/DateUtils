package hashimotonet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author hashimotonet
 * @version 1.0.0
 */

public class TimeLineClock {

	private final String STANDARD_TIME_FORMAT="YYYY/MM/dd HH:mm";
	private final SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_TIME_FORMAT);
	
	private final String CONVERT_TIME_FORMAT = "YYYY年MM月dd日";
	private final SimpleDateFormat convFormat = new SimpleDateFormat(CONVERT_TIME_FORMAT);
	
	private final static String separater = "-----------------------------";
	
	/**
	 * 
	 * @param date　指定日付
	 * @return　フォーマットされた年月日
	 */
	public String getFormmatedDateAndTime(Date date) {
		return sdf.format(date).toString();
	}
	
	/** 
	 * クラス内部で必要となった、フォーマットにてStringを返却する
	 * @param Date
	 * @return フォーマット化された日付文字列
	 */
	public String convertTimeFormat(Date date) {
		return convFormat.format(date).toString();
	}
	
	/**
	 * 現在時刻を無条件に返却する。
	 * @return　フォーマット化された年月日時刻
	 */
	public static synchronized String getCurrentDateAndTime() {
		TimeLineClock clock = new TimeLineClock();
		String time = clock.getFormmatedDateAndTime(new Date());
		clock = null;
		return time;
	}
	
	/**
	 * 
	 * @return Formatted Japanese Date String.
	 */
	public static String getCurrentJapaneseDateAndTime() {
		return getJapaneseDateAndTime(new Date());
	}
	
	/**
	 * 
	 * @return Formatted Japanese Date String.
	 */
	public static String getCurrentJapaneseDateAndTime(Date date) {
		return getJapaneseDateAndTime(date);
	}
	
	/**
	 * 
	 * @TODO Implementation.
	 * @return Formatted Japanese Date String.
	 */
	public static synchronized String getJapaneseDateAndTime(Date date) {
	    
		Locale.setDefault(new Locale("ja","JP","JP"));
        SimpleDateFormat fmt =  new SimpleDateFormat("GGGG yyyy'年'MM'月'dd'日' EEEE");
        
        //フォーマットを指定してSimpleDateFormatクラスのオブジェクトを生成
        SimpleDateFormat sdf1 = new SimpleDateFormat("yy'年'MM'月'dd'日'"); 

        
        //変換する文字列を生成 
        Date date1=null;
        String str1 = new String(new TimeLineClock().convertTimeFormat(date)); 
        try { 
           date1 = sdf1.parse(str1); //parseメソッドでDate型に変換
            //変換できない場合例外がスローされます。
        } catch (ParseException e) { 
                System.out.println("変換できないフォーマットです。"); 
        }
        
        String time1 = fmt.format(date);
        String time2 = fmt.format(date1);
        
	    return time1;
	}

	public static void main(String args[]) {
		
		TimeLineClock clock = new TimeLineClock();

		System.out.println(separater);
		System.out.println(TimeLineClock.getCurrentDateAndTime());
		System.out.println("Usage : call Class Method shown below.\nTimeLineClock.getCurrentDateAndTime() \nmethod from your source.\n");
		
		System.out.println(separater);
		System.out.println(TimeLineClock.getJapaneseDateAndTime(new Date()));
		System.out.println("Usage : call Class Method shown below.\nTimeLineClock.getJapaneseDateAndTime(java.util.Date) \nmethod from your source.\n");
		
		System.out.println(separater);
		System.out.println(TimeLineClock.getCurrentJapaneseDateAndTime());
		System.out.println("Usage : call Class Method shown below.\nTimeLineClock.getCurrentJapaneseDateAndTime() \nmethod from your source.\n");
		System.out.println(separater);
	}
}
