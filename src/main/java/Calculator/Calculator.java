package Calculator;

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
            String []tmp = s.split("[\n,]");
            for(String i:tmp)
                result +=Integer.parseInt(i);
            return result;
        }
    }
}
