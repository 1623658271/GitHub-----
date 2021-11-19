package THE4;

import java.io.*;
import java.util.Scanner;

public class lv2 {
    public static void main(String[] args) throws Exception{
        File f = new File("C:\\Users\\浪客飞\\Desktop\\TXT2.txt");
        MyFileTools.Reader read1 = new MyFileTools.Reader(f);
        MyFileTools.Writer write1 = new MyFileTools.Writer(f);
        Scanner ac = new Scanner(System.in);
        //向文件中写入数据
        System.out.println("请输入新写入内容");
        String w = ac.next();
        write1.Write(w,true);
        //读取文件中的数据并打印
        System.out.println("请输入读取长度");
        int r = ac.nextInt();
        read1.read(r);
    }
}
class MyFileTools {
    //创建读文件的静态内部类
    static class Reader{
        private final File f1;
        public Reader(File f1) {
            this.f1=f1;
        }
        public void read(int len) throws Exception {
            int l = 0,temp;
            InputStream input = new FileInputStream(f1);
            byte[] f3 = new byte[len];
            while(l<len && (temp = input.read())!=-1){
                f3[l] = (byte)temp;
                l++;
            }
            input.close();
            System.out.print(new String(f3,0,l));
        }

    }
    //创建写文件的静态内部类
    static class Writer{
        private final File f1;
        public Writer(File f1){
            this.f1=f1;
        }
        public void Write(String f2,boolean s) throws Exception{
            OutputStream out = new FileOutputStream(f1,s);
            byte[] f3 = f2.getBytes();
            out.write(f3);
            out.close();
        }
    }
}