package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.StyleConstants;

/**
 * 工具类
 * @author zwg
 *
 */
public class Util {
	/**
     * 截取待检测属性
     * @param fileInfo:文件信息字符串
     * @param fileKind:文件类型
     */
    public static List<String> subAttribute(String fileInfo,String fileKind) {
    	String cssContent="";
    	String jsContent="";
    	List<String> res = new ArrayList<>();
    	String regEx_style_css = "<style[^>]*?>[\\s\\S]*?<\\/style>";
    	String regEx_style_js = "<script[^>]*?>[\\s\\S]*?<\\/script>";
    	Pattern css_style = Pattern.compile(regEx_style_css, Pattern.CASE_INSENSITIVE);
    	Pattern js_style = Pattern.compile(regEx_style_js, Pattern.CASE_INSENSITIVE);
    	if(fileKind.equals("css")) {//纯css文件,只需匹配regEx_style_css
            Matcher m_style = css_style.matcher(fileInfo);
            if(m_style.find()) {
            	cssContent = m_style.group();
            	res.add(cssContent);
            }
    	}else if(fileKind.equals("js")) {//纯js文件
    		
    	}else if(fileKind.equals("jsp")) {
    		
    	}else if(fileKind.equals("vue")) {
    		
    	}else if(fileKind.equals("html")) {//html文件,匹配regEx_style_css和regEx_style_js
            Matcher m_style = css_style.matcher(fileInfo);
            if(m_style.find()) {
            	cssContent = m_style.group();
            	res.add(cssContent);
            }
            Matcher m2_style = js_style.matcher(fileInfo);
            if(m2_style.find()) {
            	jsContent = m2_style.group();
            	res.add(jsContent);
            }
    	}else {
    		System.out.println("暂不支持检测该类型文件");
    		res.add("NN");
    	}
    	return res;
    }
    
    /**
     * 获取文件的后缀名
     * @param 文件路径
     */
    public static String getFileKind(String filePath) {
    	int pos=filePath.lastIndexOf(".");
		return filePath.substring(pos+1,filePath.length());
    }
    
    /**
     * 文件夹,构造输出字符串
     * @param fileInfo:文件信息字符串
     * @param attribute:属性
     */
    public static String consOutput(String fileInfo,String attribute) {
    	String res="Location: line ";
    	List<Integer> indexes = new ArrayList<>();
		Pattern p = Pattern.compile(attribute);
        Matcher m = p.matcher(fileInfo);
        int index;
        int ans=0;
        int count=0;
        String number="";
        while (m.find()) {
            index=m.start();
            indexes.add(index);
        }
        for(Integer cur:indexes) {
        	
        	ans=0;
        	//从当前位置,往前找到行数
        	int j;
        	for(j=cur;j>=0;j--) {
        		if(fileInfo.charAt(j)=='\n') {
        			break;
        		}else {
        			if(j==0) {
        				j=-1;
        				break;
        			}
        		}
        	}
        	while(j<fileInfo.length()) {
        		if(fileInfo.charAt(j)==' ') {
        			break;
        		}else {
        			if(fileInfo.charAt(j)>='0'&&fileInfo.charAt(j)<='9')
        			ans+=ans*10+(fileInfo.charAt(j)-'0');
        		}
        		j++;
        	}
        	if(count==indexes.size()-1)
            	number=number+ans+"|";
        	else
        	    number=number+ans+",";
            count++;
        }
        res+=number;
        res+="Specific Attribute: "+attribute+"|"+"Reason: Partial support\r\n";
    	return res;
    }
}
