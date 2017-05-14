package com.toolsmi.util;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Format {

	public static <T> Set<T> changeToSet(List<T> list){
		Set<T> set=new HashSet<T>();
		for(T t:list){
			if(t!=null){
				set.add(t);
			}
		}
		return set;
	}
	
	public static Timestamp toTimesStamp(String text) {
		String reg="^\\d{4}-(([0]?[1-9])|(1[0-2]))-([1-9]|([0-2]\\d)|(3[0-1])) (([0-1]?[0-9])|(2[0-4])):([0-5][0-9]):([0-5][0-9])(\\.\\d+)?$";
		String reg2="^\\d{4}-(([0]?[1-9])|(1[0-2]))-([0]?[1-9]|([0-2]\\d)|(3[0-1]))$";
		if(text!=null && text.matches(reg)){
			return Timestamp.valueOf(text);
		}else if(text!=null && text.matches(reg2)){
			text+=" 00:00:00";
			return Timestamp.valueOf(text);
		}
		return null;
	}
	
	public static Boolean isEmpty(Object o){
		if(o==null){
			return true;
		}else if(o.getClass().equals(String.class) && o.equals("")){
			return true;
		}else if(o.getClass().equals(Integer.class) && o.equals(0)){
			return true;
		}else if(o.getClass().isInstance(List.class) && o.equals(new java.util.ArrayList())){
			return true;
		}else{
			return false;
		}
	}
	
	public static String praseCondition(Object o){
		if(!isEmpty(o)){
			return "%"+o+"%";
		}
		return null;
	}
}
