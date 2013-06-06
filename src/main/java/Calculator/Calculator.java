package Calculator;

import java.util.ArrayList;
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
                if(checkFinalTest(s)>=2){
                    s =moreDeli(s);
                }else{
                    if(s.contains("[")){
                        s= oneDeli(s);
                    }else{
                        regex=""+s.charAt(2);
                        Pattern p = Pattern.compile("\\d");
                        Matcher m = p.matcher(s);
                        m.find();
                        s = s.substring(m.start(),s.length());
                    }
                }
            }
            String []tmp = s.split("[\n,;]");
            for(String i:tmp){
                if(Integer.parseInt(i)<0) throw  new IllegalArgumentException("negatives not allowed");
                if(Integer.parseInt(i)<=1000)
                    result +=Integer.parseInt(i);
            }
            return result;
        }
    }

    public int checkFinalTest(String s){
        Pattern p = Pattern.compile("\\[");      // the expression
        Matcher m = p.matcher(s);
        int count = 0;
        while(m.find())
            count++;
        return count;
    }
    public String moreDeli(String input){
        Pattern p = Pattern.compile(".*?]");      // the expression
        input = input.substring(2,input.length());
        Matcher m = p.matcher(input);

        ArrayList<String> list = new ArrayList<String>();
        int count = 0;
        while(m.find()) {
            String string = input.substring(m.start()+1, m.end()-1);
            list.add(string);
        }
        System.out.println(list);
        String re= "[";
        for(String i:list)
            re+=i;
        re+="]";
        Pattern p1 = Pattern.compile("\\d");
        Matcher m1 = p1.matcher(input);
        m1.find();

        input = input.substring(m1.start(),input.length());
        for(String i:list)
            input=input.replaceAll(Pattern.quote(i), ",");
        System.out.println(input);
        return input;
    }
    public String oneDeli(String s){
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(s);
        m.find();
        String regex = s.substring(3, m.start()-2);
        s = s.substring(m.start(),s.length());
        s = s.replace(regex, ",");
        return  s;
    }
}
