package THE3;

import java.util.*;

public class Third_lv3 {
    public static void main(String[] args) {
        //实例化波吉对象
        KingBoJi kingBoJi = new KingBoJi();

        //实例化士兵群对象，将波吉作为参数加入
        Soldiers soldiers = new Soldiers(kingBoJi);

        //添加十个士兵
        kingBoJi.bigadd(0,10);

        //从第十个士兵开始添加，添加到20个士兵
        kingBoJi.bigadd(10,20);

        //删除第2个士兵
        kingBoJi.soldiers.remove(2);

        //开始阅兵
        kingBoJi.review();

        //士兵群回复
        soldiers.response();
    }
}

//设置士兵接口
interface Soldier{
    void response();
}

//设置国王抽象类
abstract class King{
    List<String> soldiers = new ArrayList<>();
    abstract void review();
}

//国王波吉类,继承国王类
class KingBoJi extends King {
    public void review(){
        System.out.println("国王: 士兵们好");
    }

    //通过国王波吉类在目标点添加士兵至指定数值
    public void bigadd(int k,int n){
        for(int i=k;i<n;i++){
            soldiers.add("士兵"+(i+1));
        }
    }
}

//设置士兵群类,实现士兵类接口
class Soldiers implements Soldier{
    private KingBoJi kingBoJi;
    public Soldiers(KingBoJi kingBoJi){
        this.setKingBoJi(kingBoJi);
    }
    public void setKingBoJi(KingBoJi kingBoJi){
        this.kingBoJi=kingBoJi;
    }
    public void response(){
        for(int k=0;k<kingBoJi.soldiers.size();k++){
            try{
                Thread.sleep(400);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(kingBoJi.soldiers.get(k)+":国王好！");
        }
    }
}