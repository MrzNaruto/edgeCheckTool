package algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAttri {
   public static Set getAttri(String str) {
	   //String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
       //Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
       //Matcher m_style = p_style.matcher(str);
      // String cssContent = "";
      // if(m_style.find()) {
       	//cssContent=m_style.group();
       //}
	   String regEx_style1 = "[{;\\s][a-z]+:";
       Pattern p_style1 = Pattern.compile(regEx_style1, Pattern.CASE_INSENSITIVE);
       Matcher m_style1 = p_style1.matcher(str);
       HashSet<String> attriset = new HashSet<String>();
       while(m_style1.find()) {
    	 String group=m_style1.group();
    	 group=group.replaceAll("\\{", "");
    	 group=group.replaceAll(";", "");
    	 group=group.replaceAll(" ", "");
    	 group=group.replaceAll(":", "");
    	 attriset.add(group);  	
       }
       return attriset;
   }
}
