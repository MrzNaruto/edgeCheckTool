package compatitability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * chengtiantianyfzx
 */
public enum CSSCompatRuleObject {
    /***
     * 设置规则包括属性名、当前的版本号集、对应的支持情况、部分支持时的原因
     */
    RZindex_T("z-index",Arrays.asList("12-100","101"),"supported"),
    RWebkituserdrag_P("-Webkit-user-drag",Arrays.asList("79-100","101"),"partial","when value is element does not appear to have an effect"),
    RWebkituserdrag_F("-Webkit-user-drag",Arrays.asList("12-18"),"not supported"),
    ROverflow_T("overflow",Arrays.asList("90-100","101"),"supported"),
    ROverflow_P_89("overflow",Arrays.asList("79-89"),"partial","does not support the clip value"),
    ROverflow_P_18("overflow",Arrays.asList("12-18"),"partial","1.does not support the clip value.2.does not support the two value overflow shorthand."),
    ;

    private static Map<String, List<Node>> ruleMap;

    static {
        ruleMap = new HashMap<String, List<Node>>();
        for ( CSSCompatRuleObject ele  : CSSCompatRuleObject.values()) {
            String min = null;
            String max = null;
            for (Object version:ele.getVersions()) {
                if(((String)version).contains("-")){
                    min = ((String)version).substring(0,((String)version).indexOf("-"));
                    max = ((String)version).substring(((String)version).indexOf("-")+1,((String)version).length());
                }else{
                    max = (String)version;
                    min = max;
                }
                if (ele.getIsSupport().equals("supported") || ele.getIsSupport().equals("not supported")){
                    Node tmp = new Node(min,max,ele.getIsSupport());
                    if(ruleMap.get(ele.getName()) == null){
                        List newlist = new ArrayList<Node>();
                        newlist.add(tmp);
                        ruleMap.put(ele.getName(),newlist);
                    }else {
                        List newlist = ruleMap.get(ele.getName());
                        newlist.add(tmp);
                        ruleMap.put(ele.getName(),newlist);
                    }
                }else if (ele.getIsSupport().equals("partial")){
                    Node tmp = new Node(min,max,ele.getIsSupport(),ele.getCause());
                    if(ruleMap.get(ele.getName()) == null){
                        List newlist = new ArrayList<Node>();
                        newlist.add(tmp);
                        ruleMap.put(ele.getName(),newlist);
                    }else {
                        List newlist = ruleMap.get(ele.getName());
                        newlist.add(tmp);
                        ruleMap.put(ele.getName(),newlist);
                    }
                }
            }

        }
    }

    /**属性名*/
    private String name;
    /**命中的版本号列表*/
    private List versions;
    /**是否支持*/
    private String isSupport;
    /**部分支持的情况说明*/
    private String cause;

    private CSSCompatRuleObject(String name, List versions,String isSupport) {
        this.name = name;
        this.versions = versions;
        this.isSupport = isSupport;

    }

    private CSSCompatRuleObject(String name, List versions,String isSupport,String cause) {
        this.name = name;
        this.versions = versions;
        this.isSupport = isSupport;
        this.cause = cause;
    }

    public static Map attributeCheck(String name, String version){
        Map res = new HashMap<String,String>();
        if (ruleMap.get(name) == null){
            res.put(name,"当前属性暂不支持检测！");
            return res;
        }
        List<Node> nodeList = ruleMap.get(name);
        for (int i = 0; i < nodeList.size(); i++) {
            if ( nodeList.get(i).isContain(version) ) {
                res.put(name,nodeList.get(i).checkResult());
                return res;
            }
        }
        return res;
    }

    public List getVersions(){
        return versions;
    }

    public String getIsSupport(){
        return isSupport;
    }

    public String getCause(){
        return cause;
    }

    public String getName(){
        return name;
    }

    private static class Node{
        String max;
        String min;
        String isSupport;
        String cause;
        private Node(String min, String max,String isSupport){
            this.max = max;
            this.min = min;
            this.isSupport = isSupport;
        }

        private Node(String min, String max,String isSupport,String cause){
            this.max = max;
            this.min = min;
            this.isSupport = isSupport;
            this.cause = cause;
        }

        private boolean isContain(String versioNum){
            if(versioNum.compareToIgnoreCase(min)>=0 && versioNum.compareToIgnoreCase(max)<=0) {
                return true;
            }else return false;
        }

        private String checkResult(){
            if (cause != null){
                return isSupport+"|"+cause;
            }else return isSupport;
        }
    }
}
