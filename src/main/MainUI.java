package main;

import algorithm.GetAttri;
import compatitability.CSSCompatRuleObject;
import enums.EnumCode;
import exception.ToolException;
import open_file.Read_File;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

class Windowm extends JFrame
{
	String path1;//第一个文件目录
	String File1;//第一个文件
	int point;//保存当前活动窗口
	
	private static final long serialVersionUID = 1L;
	JPanel myPanel1 = new JPanel();//面板1.1
    JPanel myPanel2 =new JPanel();//面板2.1
    JPanel myPanel3 =new JPanel();//面板3
    JPanel myPanel4 =new JPanel();//面板4
    JTextPane text1=new JTextPane();
    JTextPane text2=new JTextPane();
    
	JLabel lblNewLabel = new JLabel("请选择Edge版本");	
	JComboBox<String> comboBox1 = new JComboBox<>();
	JLabel lblNewLabel_1 = new JLabel("请选择文件");
	
	JButton btnNewButton = new JButton("打开文件");
    JButton bt1 = new JButton("打开文档1");
    JButton bt3 = new JButton("核对");
   
    JPopupMenu jm = new JPopupMenu();//右键菜单
    JMenuItem copy = new JMenuItem("复制");//菜单项
    JMenuItem path = new JMenuItem("粘贴");  
    JMenuItem cut = new JMenuItem("剪切");
    JMenuItem help = new JMenuItem("帮助");
    JMenuItem about = new JMenuItem("关于");
    
    JScrollPane scro1=new JScrollPane(text1);//添加滚动条
    JScrollPane scro2=new JScrollPane(text2);//添加滚动条
    
    JSplitPane jSplitPane =new JSplitPane();//设定为拆分布局
    JSplitPane jSplitPane2 =new JSplitPane();//设定为拆分布局
    JSplitPane jSplitPane3 =new JSplitPane();//设定为拆分布局
    
    
    Set<String> set;//截取出来的css属性
    String cssContent ="";//截取出来的css内容
    String version="";//版本
    public Windowm()
    {
    	jm.add(copy);
        jm.add(path);
        jm.add(cut);
        jm.add(help);
        jm.add(about);
        comboBox1.addItem("95");
        comboBox1.addItem("96");
        comboBox1.addItem("97");
        comboBox1.addItem("98");
        comboBox1.addItem("99");
        comboBox1.addItem("100");
        comboBox1.addItem("101");
        comboBox1.addItem("102");
        myPanel3.add(lblNewLabel);
        myPanel3.add(comboBox1);
        myPanel3.add(lblNewLabel_1);
        myPanel3.add(btnNewButton);
        myPanel4.add(bt3);
         
    	this.setTitle("欢迎使用文本比较软件");
    	this.setBounds(100, 100, 600, 500);
        jSplitPane.setContinuousLayout(true);//操作箭头，重绘图形
        jSplitPane2.setContinuousLayout(true);//操作箭头，重绘图形
        jSplitPane3.setContinuousLayout(true);//操作箭头，重绘图形
        
        jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);//垂直方向
        jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//水平方向
        jSplitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);//垂直方向
        
        myPanel1.setBorder(BorderFactory.createLineBorder(Color.green));
        myPanel2.setBorder(BorderFactory.createLineBorder(Color.red));
        myPanel3.setBorder(BorderFactory.createLineBorder(Color.yellow));
        myPanel4.setBorder(BorderFactory.createLineBorder(Color.blue));

        jSplitPane.setLeftComponent(scro1);//左右布局中添加组件 ，面板1
        jSplitPane.setRightComponent(scro2);//左右布局中添加组件 ，面板2

        jSplitPane2.setTopComponent(myPanel3);//上下布局中添加组件 ，面板1
        jSplitPane2.setBottomComponent(jSplitPane);//上下布局中添加组件 ，面板1
        
        jSplitPane3.setTopComponent(jSplitPane2);
        jSplitPane3.setBottomComponent(myPanel4);
        
        jSplitPane.setDividerSize(5);//设置分割线的宽度
        jSplitPane2.setDividerSize(5);//设置分割线的宽度
        jSplitPane3.setDividerSize(5);//设置分割线的宽度
        setContentPane(jSplitPane3);//设置为父模块
  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        copy.addActionListener(new ActionListener()//窗口监听
    		{
    			public void actionPerformed(ActionEvent e4)//菜单项
    			{
   					try{	
    					text1.copy();
    					text2.copy();
    				}catch(Exception e1){
    				}
    			}
   			}
    	);
        path.addActionListener(new ActionListener()//窗口监听
    		{
    			public void actionPerformed(ActionEvent e4)//菜单项
    			{
   					try{	
   						if(point==1)//由于有两个窗口，因此设计point来确定粘贴在某个窗口
   							text1.paste();
   						else
    						text2.paste();
    				}catch(Exception e1){
    				}
    			}
   			}
    	);
        comboBox1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				version=(String)comboBox1.getSelectedItem();
				//System.out.println(version);
			}
        	
        });
        cut.addActionListener(new ActionListener()//窗口监听
    		{
    			public void actionPerformed(ActionEvent e4)//菜单项
    			{
    				try{	
   						text1.cut();
   						text2.cut();
    				}catch(Exception e1){
    				}
    			}
    		}
    	);
        help.addActionListener(new ActionListener()//窗口监听
    		{
    			public void actionPerformed(ActionEvent e4)//菜单项
    			{
    				JOptionPane.showMessageDialog(null,"使用方法：输入待检测的文件进行检测\n红色表示匹配失败，蓝色表示多余，黑色为正常匹配文本","使用指南",JOptionPane.PLAIN_MESSAGE); 			
    			}
    		}
    	);
        about.addActionListener(new ActionListener()//窗口监听
    		{
    			public void actionPerformed(ActionEvent e4)//菜单项
    			{
    				JOptionPane.showMessageDialog(null,"前端语法兼容Edge浏览器检测工具\nVersion 1.1 \n","欢迎使用",JOptionPane.PLAIN_MESSAGE); 			
    			}
    		}
    	);
        
        text1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {      
                    jm.show(text1, e.getX(), e.getY()); // 弹出菜单
                    point=1;
                }
            }
        });
        
        text2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {      
                    jm.show(text2, e.getX(), e.getY()); // 弹出菜单
                    point=2;
                }
            }
        });
        
        jSplitPane.addComponentListener(new ComponentAdapter() {//拖动窗口监听
            public void componentResized(ComponentEvent e) {  
            	jSplitPane.setDividerLocation(jSplitPane3.getWidth()/2-7);//设置第一条宽度  
            }  
        }); 
       jSplitPane2.setDividerLocation(50);//设定分割线的距离左边的位置
       jSplitPane3.addComponentListener(new ComponentAdapter() {//拖动窗口监听 
           public void componentResized(ComponentEvent e) {  
           	jSplitPane3.setDividerLocation(jSplitPane3.getHeight()-50);//设置第三条高度 
           }  
       }); 
       
      btnNewButton.addActionListener(new ActionListener()//窗口监听
		{
			public void actionPerformed(ActionEvent e4)//菜单项
			{
				try{	
					text1.setText("");
				    JFileChooser jfc=new JFileChooser();
				    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
				    jfc.showDialog(new JLabel(), "选择");
				    File file=jfc.getSelectedFile();
				    path1=file.getAbsolutePath();//获取文件绝对地址	
				    new Read_File(path1);
				    File1= Read_File.getFile();
				    SimpleAttributeSet attrset = new SimpleAttributeSet();
				    StyleConstants.setFontSize(attrset,16);//设置字号
			        Document docs=text1.getDocument();
			        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
			        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			        Matcher m_style = p_style.matcher(File1);
			        docs.insertString(docs.getLength(), File1, attrset);
			        cssContent = "";
			        if(m_style.find()) {
			        	cssContent = m_style.group();
			        }
			        set=GetAttri.getAttri(cssContent);
//	                for(String s1: set){
//	                    System.out.println(s1);
//	                 }
			        //String version=(String)comboBox1.getSelectedItem();
			        version=(String)comboBox1.getSelectedItem();
			        System.out.println(version);
				}catch(Exception e1){
					throw new ToolException(EnumCode.E1,e1);
				}
			}
		}
	);
	bt3.addActionListener(new ActionListener()//窗口监听
		{
			public void actionPerformed(ActionEvent e4)//菜单项
			{
				try{
					//System.out.println(path1);
					//JTextpane的内容2
					String jtp2;
					//清空text2的内容
					text2.setText("");
					//获取文档对象
					Document docs2=text2.getDocument();      
					//获取文件完整字符串信息
					String fileInfo = Read_File.getFile();
					int len=fileInfo.length();
					//获取所有的属性
					set = GetAttri.getAttri(cssContent);
					//设置一个属性
					SimpleAttributeSet set2 = new SimpleAttributeSet();
					//设置字号
					StyleConstants.setFontSize(set2,16);
					
					//设置文字颜色
					StyleConstants.setForeground(set2,Color.black);
					//先将文本插入文档对象
					docs2.insertString(0,fileInfo,set2);
					//具体处理需要染色的字符串
					for(String str:set) {
						//System.out.println(str);
						//str:当前属性
						//判断是否合规
						Map<String,String> resMap = CSSCompatRuleObject.attributeCheck(str,version);
						//合规信息
						String keyValue=resMap.get(str);
						//System.out.println("keyValue:"+keyValue);
						String []res=keyValue.split("\\|");
						int index;
						if(res.length==2) {
							//部分支持   
							/**
							 * 在fileInfo中定位到当前属性的所有位置,然后依次做处理
							 */
							List<Integer> indexes = new ArrayList<>();
							Pattern p = Pattern.compile(str);
					        Matcher m = p.matcher(fileInfo);
					        while (m.find()) {
					            index=m.start();
					            indexes.add(index);
					        }
					        for(Integer cur:indexes) {
					        	//System.out.println("cur"+cur);
					        	docs2.remove(cur, str.length());
					        	//设置颜色
					        	StyleConstants.setForeground(set2,Color.BLUE);
					        	docs2.insertString(cur, str, set2);
					        }
						}else {
							if(res[0].equals("not supported")) {
								//不支持
								/**
								 * 在fileInfo中定位到当前属性的所有位置,然后依次做处理
								 */
								List<Integer> indexes = new ArrayList<>();
								Pattern p = Pattern.compile(str);
						        Matcher m = p.matcher(fileInfo);
						        while (m.find()) {
						            index=m.start();
						            indexes.add(index);
						        }
						        for(Integer cur:indexes) {
						        	docs2.remove(cur, str.length());
						        	//设置颜色
						        	StyleConstants.setForeground(set2,Color.RED);
						        	docs2.insertString(cur, str, set2);
						        }
							}
						}
					}
				}catch(Exception e1){
					throw new ToolException(EnumCode.E0,e1);
				}
			}
		}
	);  
	setVisible(true);
    }

}

