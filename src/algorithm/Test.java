package algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		 String seq_1 = "CATTAATTACACTCTCGCACTCACCAAACCCAGACAGGCCTCGACTCC";
		 String seq_2 = "ACTAAACAAGACTCGCCTGTCTAACTAGGGAGTTTATAATGAACCGTGGCGTAGACCA";

		DNASequence dna=new DNASequence(seq_1,seq_2);
		dna.runAnalysis();
		dna.traceback();
		System.out.println(dna.getString1());
		System.out.println(dna.getString2());
/*		String str=".c{color:#77c}\n" + 
//				".f14{font-size:14px}\n" + 
				".f10{font-size:10.5pt}\n" + 
				".f16{font-size:16px}\n" + 
				".f13{font-size:13px}\n" + 
				".bg{background-image:url(https://pss.bdstatic.com/r/www/cache/static/protocol/https/global/img/icons_441e82f.png);_background-image:url(https://pss.bdstatic.com/r/www/cache/static/protocol/https/global/img/icons_d5b04cc.gif);background-repeat:no-repeat}\n" + 
				"#u,#head,#tool,#search,#foot{font-size:12px}\n" + 
				".logo{width:117px;height:38px;cursor:pointer}\n" + 
				".p1{line-height:120%;margin-left:-12pt}\n" + 
				".p2{width:100%;line-height:120%;margin-left:-12pt}\n" + 
				"#wrapper{_zoom:1}\n" + 
				"#container{word-break:break-all;word-wrap:break-word;position:relative}\n" + 
				".container_s{width:1002px}\n" + 
				".container_l{width:1222px}\n" + 
				"#content_left{width:636px;float:left;padding-left:35px}\n" + 
				"#content_right{border-left:1px solid #e1e1e1;float:right}\n" + 
				".container_s #content_right{width:271px}\n" + 
				".container_l #content_right{width:434px}\n" + 
				".content_none{padding-left:35px}\n" + 
				"#u{color:#999;white-space:nowrap;position:absolute;right:10px;top:4px;z-index:299}\n" + 
				"#u a{color:#00c;margin:0 5px}\n" + 
				"#u .reg{margin:0}\n" + 
				"#u .last{margin-right:0}\n" + 
				"#u .un{font-weight:700;margin-right:5px}\n" + 
				"#u ul{width:100%;background:#fff;border:1px solid #9b9b9b}\n" + 
				"#u li{height:25px}\n" + 
				"#u li a{width:100%;height:25px;line-height:25px;display:block;text-align:left;text-decoration:none;text-indent:6px;margin:0;filter:none\\9}\n" ;
                Set<String> s=GetAttri.getAttri(str);
                for(String s1: s){
                    System.out.println(s1);
                 }*/
		
	}
}



