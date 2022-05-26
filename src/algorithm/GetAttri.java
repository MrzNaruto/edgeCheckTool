package algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	  // String regEx_style1 = "([{;\\s][a-z]+:)|(-[a-z]+-[a-z]+-[a-z]+:)";
	   String regEx_style1 = "[{;\\s][a-z-]+:";
       Pattern p_style1 = Pattern.compile(regEx_style1, Pattern.CASE_INSENSITIVE);
       Matcher m_style1 = p_style1.matcher(str);
       HashSet<String> attriset = new HashSet<String>();
       while(m_style1.find()) {
    	 String group=m_style1.group();
    	 group=group.replaceAll("\\{", "");
    	 group=group.replaceAll(";", "");
    	 group=group.replaceAll(":", "");
    	 group=group.trim();
    	 attriset.add(group);  	
       }
       return attriset;
   }
   public static List filesDirs( List<String> fileNameList,File file){
       //File对象是文件或文件夹的路径，第一层判断路径是否为空
       if(file!=null){
           //第二层路径不为空，判断是文件夹还是文件
           if(file.isDirectory()){
               //进入这里说明为文件夹，此时需要获得当前文件夹下所有文件，包括目录
               File[] files=file.listFiles();//注意:这里只能用listFiles()，不能使用list()
               //files下的所有内容，可能是文件夹，也可能是文件，那么需要一个个去判断是文件还是文件夹，这个判断过程就是这里封装的方法
               //因此可以调用自己来判断，实现递归
               for (File flies2:files) {
                   filesDirs(fileNameList,flies2);
               }
           }else{
        	   if(file.getName().endsWith(".html") ||file.getName().endsWith(".js")||file.getName().endsWith(".css")||file.getName().endsWith(".vue")||file.getName().endsWith(".jsp"))
        	   {
        		   fileNameList.add(file.toString());
        	   }
           }
       }
       return fileNameList;
   }
}
