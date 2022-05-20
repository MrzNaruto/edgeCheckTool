package main;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;



public class Star
{
    public static void main(String args[]) throws BadLocationException
    {
    	//初始化界面
        Windowm windowm = new Windowm();
        
        //属性设置
        SimpleAttributeSet attrset = new SimpleAttributeSet();
        //字体大小
        StyleConstants.setFontSize(attrset,16);
        //获取JTextPane对象
        Document docs1=windowm.text1.getDocument();
        //设置初次显示文本
        docs1.insertString(docs1.getLength(), "选择待兼容的Edge浏览器版本,并上传需检测的文件,上传成功后,该区域将展示文件内容", attrset);        
        Document docs2=windowm.text2.getDocument();
        docs2.insertString(docs2.getLength(), "点击核对按钮将进行兼容性检测\n检测结果中红色表示该语法不兼容\n蓝色表示部分兼容\n该区域将展示比对后的文件内容", attrset);
    }
}