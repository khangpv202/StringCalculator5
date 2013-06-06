package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: khangpv
 * Date: 6/6/13
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public int add(String s) {
        if(s.isEmpty())
            return 0;
        else{
            String regex = "";
            int result = 0;
            if(s.contains("//")){
                regex=""+s.charAt(2);
                Pattern p = Pattern.compile("\\d");
                Matcher m = p.matcher(s);
                m.find();
                s = s.substring(m.start(),s.length());
            }
            String []tmp = s.split("[\n,;]");
            for(String i:tmp){
                if(Integer.parseInt(i)<0) throw  new IllegalArgumentException("negatives not allowed");
                result +=Integer.parseInt(i);
            }
            return result;
        }
    }
}
