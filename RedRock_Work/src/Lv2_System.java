//设计闪避类
abstract class Dodge {
    private Dodge next;
    static int defense = 1000;
    abstract void dodgeEnermy(Enermy enermy);
    public Dodge getNext() {
        return next;
    }
    public void setNext(Dodge next) {
        this.next = next;
    }
}
//设计闪避系统1，继承闪避类
class Dodgelv1 extends Dodge {
    public void dodgeEnermy(Enermy enermy) {
        if (enermy.getATK() > 3 * this.defense) {
            System.out.println("波斯王子逃跑了");
        }
        else
        {
            this.getNext().dodgeEnermy(enermy);
        }
    }
}
//设计闪避系统2，继承闪避类
class Dodgelv2 extends Dodge{
    public void dodgeEnermy(Enermy enermy) {
        if(enermy.getATK()>2*this.defense){
            System.out.println("波斯王子挡下了一次攻击，并逃跑了");
        }
        else
        {
            this.getNext().dodgeEnermy(enermy);
        }
    }
}
//设计闪避系统3，继承闪避类
class Dodgelv3 extends Dodge{
    public void dodgeEnermy(Enermy enermy){
        if(enermy.getATK()>this.defense){
            System.out.println("波斯王子挡下了攻击");
            enermy.attacked();
        }
        else
        {
            this.getNext().dodgeEnermy(enermy);
        }
    }
}
//设计闪避系统4，继承闪避类
class Dodgelv4 extends Dodge{
    public void dodgeEnermy(Enermy enermy){
        if(enermy.getATK()<=this.defense){
            enermy.attacked();
        }
    }
}
//设计敌人类
class Enermy{
    private int ATK;
    public Enermy(int atk){
        this.setATK(atk);
    }
    public int getATK() {
        return ATK;
    }
    public void setATK(int ATK) {
        this.ATK=ATK;
    }
    public void attack(Dodge dodge){
        dodge.dodgeEnermy(this);
    }
    public void attacked(){
        System.out.println("波斯王子发起反击，反击成功");
    }
}