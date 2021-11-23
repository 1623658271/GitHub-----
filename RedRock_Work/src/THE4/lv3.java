package THE4;

import java.util.Scanner;

public class lv3 {
    public static void main(String[] args){
        try {
            Calculator calculator = new Calculator();
            System.out.println("请输入算式(例：-1.1 + 1.1 =)");
            Scanner ac = new Scanner(System.in);
            String p = ac.nextLine();
            calculator.equation(p);
            if(calculator.is(calculator.kk)){
                System.out.println(p+" "+calculator.equation(p));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Calculator{
    public String[] kk;
    public float equation(String s){
        this.kk = s.split(" ");
        //判断算式是否符合要求，若不符合则抛出自定义异常，若符合则分情况讨论。
            if(is(kk)){
                switch (kk[1]){
                    case "+":return Float.parseFloat(kk[0])+Float.parseFloat((kk[2]));
                    case "*": case "x": case "X":return Float.parseFloat(kk[0])*Float.parseFloat((kk[2]));
                    case "-":return Float.parseFloat(kk[0])-Float.parseFloat((kk[2]));
                    case "/":return Float.parseFloat(kk[0])/Float.parseFloat((kk[2]));
                }
            } else {
                try {
                    throw new MyExpection("算式格式错误！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return 0;
    }
    //正则表达式判断输入的算式是否符合要求。
    boolean is(String[] kk) {
        if(kk.length == 4){
            return kk[0].matches("-*\\d+\\.*\\d*") && kk[1].matches("[xX*\\-+/]")
                    && kk[2].matches("-*\\d+\\.*\\d*") && kk[3].matches("[=]");
        } else {
            try {
                throw new MyExpection("算式格式错误！");
            } catch (MyExpection myExpection) {
                myExpection.printStackTrace();
            }
            return false;
        }
    }
    static class MyExpection extends Exception{
        public MyExpection(String msg){
            super(msg);
        }
    }
}