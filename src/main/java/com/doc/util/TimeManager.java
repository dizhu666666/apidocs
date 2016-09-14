package com.doc.util;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 **************************************************** 
 * 类名称： Time<br>
 * 类功能： 时间操作<br>
 * 
 **************************************************** 
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TimeManager {
	private Date time, timem;
	private String strtime;
	private SimpleDateFormat format;
	private SimpleDateFormat format1;
	private static TimeManager timemgr;

	/**
	 * 初始化
	 */
	public TimeManager() {

		strtime = "";
		format = null;
	}

	public static TimeManager getInstance() {
		if (timemgr == null) {
			timemgr = new TimeManager();
		}
		return timemgr;
	}

	/***************************************************
	 * 函数名称： getYear()<br>
	 * 函数功能： 取得年份<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 
	 * 最后修改： 无
	 ****************************************************/
	public int getYear() {
		time = new Date();
		format = new SimpleDateFormat("yyyy", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}
	
	
	public static int getYear(long time) {
		if(time!=0){
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			String strtime = format.format(new Date(time));
			return Integer.parseInt(strtime);
		}
		return 0;
	}

	/***************************************************
	 * 函数名称： getMonth()<br>
	 * 函数功能： 取得月份<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getMonth() {
		time = new Date();
		format = new SimpleDateFormat("MM", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}

	/***************************************************
	 * 函数名称： getSunr()<br>
	 * 函数功能： 取得日份<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getSun() {
		time = new Date();
		format = new SimpleDateFormat("dd", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}
 /*************************************************** 函数名称： getHour()<br>
	 * 函数功能： 取得小时<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getHour() {
		time = new Date();
		format = new SimpleDateFormat("HH", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}

	/***************************************************
	 * 函数名称： getMinu()<br>
	 * 函数功能： 取得分钟<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getMinu() {
		time = new Date();
		format = new SimpleDateFormat("mm", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}

	/***************************************************
	 * 函数名称： getSecond()<br>
	 * 函数功能： 取得秒数<br>
	 * 返回值： String<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getSecond() {
		time = new Date();
		format = new SimpleDateFormat("ss", Locale.getDefault());
		strtime = format.format(time);
		return Integer.parseInt(strtime);
	}

	/***************************************************
	 * 函数名称： getYMD()<br>
	 * 函数功能： 取得年-月-日<br>
	 * 返回值： String<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public String getYMD() {
		time = new Date();
		format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		strtime = format.format(time);
		return strtime;
	}

	/***************************************************
	 * 函数名称： getHMS()<br>
	 * 函数功能： 取得时:分:秒<br>
	 * 返回值： String<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public String getHMS() {
		time = new Date();
		format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		strtime = format.format(time);
		return strtime;
	}

	/***************************************************
	 * 函数名称： getYMDHMS()<br>
	 * 函数功能： 取得年-月-日 时:分:秒<br>
	 * 返回值： String<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public String getYMDHMS() {
		time = new Date();
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		strtime = format.format(time);
		return strtime;
	}
	public String getMDHMS() {
		time = new Date();
		format = new SimpleDateFormat("MMddHHmmss",
				Locale.getDefault());
		strtime = format.format(time);
		return strtime;
	}

	/***************************************************
	 * 函数名称： getMinH<br>
	 * 函数功能： 获小时间差,输入的时间减现在的时间<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getMinH(String in) {
		format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		format1 = new SimpleDateFormat("HH", Locale.getDefault());
		try {
			timem = format.parse(in);
			strtime = format1.format(timem);
			System.err.print(strtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(strtime) - this.getHour();
	}

	/***************************************************
	 * 函数名称： getMinM<br>
	 * 函数功能： 获分钟差,输入的时间减现在的时间<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getMinM(String in) {
		format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		format1 = new SimpleDateFormat("mm", Locale.getDefault());
		try {
			timem = format.parse(in);
			strtime = format1.format(timem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(strtime) - this.getMinu();
	}

	public long getYMDHMSp(String in) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = null;
		;
		try {
			now = df.parse(this.getYMDHMS());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.util.Date date = null;
		try {
			date = df.parse(in);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		// long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		// System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");

		return min;

	}

	/***************************************************
	 * 函数名称： getMinS<br>
	 * 函数功能： 获秒差,输入的时间减现在的时间<br>
	 * 返回值： int<br>
	 * 参数说明： 无<br>
	 * 最后修改： 无
	 ****************************************************/
	public int getMinS(String in) {
		format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
		format1 = new SimpleDateFormat("ss", Locale.getDefault());
		try {
			timem = format.parse(in);
			strtime = format1.format(timem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(strtime) - this.getSecond();
	}

	public String calDate(int days) {
		GregorianCalendar gCal = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		gCal.add(Calendar.DATE, days);
		String sDate = sFormat.format(gCal.getTime());

		return sDate;
	}

	public String calDatemin(int days) {
		GregorianCalendar gCal = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gCal.add(Calendar.DATE, days);
		String sDate = sFormat.format(gCal.getTime());

		return sDate;
	}

	public static long getQuot(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}

	public static long getNowhour(String time1, String time2)
			throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = df.parse(time1);
		java.util.Date date = df.parse(time2);
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		// long min=((l/(60*1000))-day*24*60-hour*60);
		// long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		return hour;

	}

	public String calDate1(int days) {

		GregorianCalendar gCal = new GregorianCalendar(2003, 5, 27);
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		gCal.add(Calendar.DATE, 5);
		String sDate = sFormat.format(gCal.getTime());
		return sDate;
	}

	public static int dateTime(String dateString)  {
		if(StringUtils.isEmpty(dateString)){
			return 0;
		}
		int time = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = df.parse(dateString);
			time =(int) (date.getTime()/1000);
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String TimeStamp2Date(long timestampString) {
		String formats = "yyyy-MM-dd";
		Long timestamp = timestampString * 1000;
		String date = new java.text.SimpleDateFormat(formats)
				.format(new java.util.Date(timestamp));
		return date;
	}

	
	
	public static String TimeToString(int time) {
		int currentTime=currentTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(time*1000L);
		String result="";
		if(time>=currentTime){
			result="1分钟前";
		}else{
			int timeInterval=currentTime-time;//时间差
			if(timeInterval<60*60){
				result=timeInterval/60+"分钟前";
			}else if(timeInterval<60*60*24){
				result=timeInterval/(60*60)+"小时前";
			}else if(timeInterval<60*60*24*30){
				result=timeInterval/(60*60*24)+"天前";
			}else if(timeInterval<60*60*24*30*12){
				result=timeInterval/(60*60*24*30)+"个月前";
			}else {
				result=dateFormat.format(date);
			}
		}
		return result;
	}
	
	 
	public static String TimeToFormatString(Integer time,String format) {
		if(time==null||time==0){
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date(time*1000L);
		return dateFormat.format(date);
	}
	
	public static int currentYearMouthTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String str=dateFormat.format(new Date());
		try {
			return (int) (dateFormat.parse(str).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int currentTime(){
		int now=(int) (System.currentTimeMillis()/1000);
		return now;
	}
	
	public static int StringToTime(String time,String format) {
		if(StringUtils.isEmpty(time)){
			return 0;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date;
		try {
			date = dateFormat.parse(time);
			return (int) (date.getTime()/1000);
		} catch (ParseException e) {
			return 0;
		}
	}
	
	
	public static int currentdayTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String str=dateFormat.format(new Date());
		try {
			return (int) (dateFormat.parse(str).getTime()/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int currentmouthTime() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		String str=dateFormat.format(new Date());
		return (int) (dateFormat.parse(str).getTime()/1000);
	}

	public static Integer dateyearTime(String startime) {
		if(startime.equals("")){
			return 0;
		}
		int time = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		Date date;
		try {
			date = df.parse(startime);
			time =(int) (date.getTime()/1000);
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	 
	public static void main(String[] args) {
		System.out.println(dateTime("2012-10-19"));
		System.out.println(getYear(dateTime("2012-10-19")*1000L));
		System.out.println(getYear(dateTime("2015-10-19")*1000L) );
		System.out.println(getYear(dateTime("2015-10-19")*1000L)- getYear(dateTime("2012-10-19")*1000L));
		System.out.println(getAgeFromBirthday(1350576000));
		System.out.println(TimeManager.getInstance().getMDHMS());
	}

	public static Integer getAgeFromBirthday(int birthday) {
		return getYear(new Date().getTime())- getYear(birthday*1000L);
	}
}
