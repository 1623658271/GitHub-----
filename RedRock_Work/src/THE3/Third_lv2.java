package THE3;

import java.util.Scanner;
public class Third_lv2{
    public static void main(String[] args) throws Exception{

        int atk;
        do {
            System.out.println("波斯王子的防御力为1000，请输入敌方攻击力(输入0时结束)");

            //设置敌人的攻击力
            Scanner ac = new Scanner(System.in);
            atk = ac.nextInt();

            //实例化enermy对象并通过构造方法为敌人攻击力赋值
            Enermy enermy = new Enermy(atk);

            //实例化一堆Dodge对象
            Dodge dodge[] = {new Dodgelv1(),new Dodgelv2(),new Dodgelv3(),new Dodgelv4()};

            //链式调用四个等级闪避系统
            dodge[0].setNext(dodge[1]);
            dodge[1].setNext(dodge[2]);
            dodge[2].setNext(dodge[3]);

            //敌方攻击
            enermy.attack(dodge[0]);
        }while (atk!=0);
    }
}