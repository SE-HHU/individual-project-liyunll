import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Homework_01 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        operations(number);
        // 利用参数number控制生成题目的个数；
    }
    public static void operations(int number) throws IOException {
            Map<Integer, String> map = new HashMap<>();
            //定义集合map存储运算题目；
            ArrayList<Integer> arr = new ArrayList<Integer>();
            // 定定义数组arr存储答案
           BufferedWriter w1 = new BufferedWriter(new FileWriter("EXercises.txt"));
            BufferedWriter w2 = new BufferedWriter(new FileWriter("Answers.txt"));
            Character[] operator = new Character[2];
            operator[0] = '+';
            operator[1] = '-';
            // 创建一个字符数组，存储运算符；
            Random r = new Random();
            for (int i = 1; i < number + 1; i++) {
                // 循环生成题目
                Boolean B=false;
                // 设置一个布尔值，判断生出的题目答案是否小于0；
                while (!B) {
                    int ochoice = r.nextInt(2) + 1;
                    //随机生成运算符个数；
                    StringBuilder s =new StringBuilder("");
                    //定义s字符串存储题目；
                    int num=0;
                    //定义num存储答案；
                    switch (ochoice) {
                        //用switch语句进行选择；
                        case 1:
                            s.append(i + ". ");
                            int a = r.nextInt(100);
                            //随机生成数字；
                            s.append(a);
                            int o = r.nextInt(2);
                            //随机生成运算符；
                            s.append(operator[o]);
                            int b = r.nextInt(100);
                            s.append(b);
                            s.append('=');
                            if (!map.containsValue(s)) {
                                // 判断生成的题目是否存在；
                                if (o == 0) {
                                    num = a + b;
                                } else {
                                    num = a - b;
                                }
                                if (num >= 0) {
                                    // 判断结构是否小于0；
                                    map.put(i, s.toString());
                                    Wirter(w1,w2,i,s.toString(),num);
                                    // 添加题目与答案；
                                    B=true;
                                    //如果是，退出循环；
                                }
                            }
                            break;
                        case 2:
                            s.append(i + ". ");
                            int a1 = r.nextInt(100);
                            s.append(a1);
                            int o1 = r.nextInt(2);
                            s.append(operator[o1]);
                            int b1 = r.nextInt(100);
                            s.append(b1);
                            int o2 = r.nextInt(2);
                            s.append(operator[o2]);
                            int c1 = r.nextInt(100);
                            s.append(c1);
                            s.append('=');
                            if (!map.containsValue(s)) {

                                if (o1 == 0 && o2 == 0) {
                                    num = a1 + b1 + c1;
                                }
                                if (o1 == 1 && o2 == 0) {
                                    num = a1 - b1 + c1;
                                }
                                if (o1 == 1 && o2 == 1) {
                                    num = a1 - b1 - c1;
                                }
                                if (o1 == 0 && o2 == 1) {
                                    num = a1 + b1 - c1;
                                }

                                if (num >= 0) {
                                    map.put(i, s.toString());
                                    Wirter(w1,w2,i,s.toString(),num);
                                    B=true;
                                }
                            }
                            break;
                    }
                }
            }

        w1.close();
        w2.close();
        // 关闭输入流；

        }
        public  static  void Wirter(BufferedWriter w1,BufferedWriter w2,int i,String s,int num) throws IOException {
            w1.write(s);
            w1.newLine();
            w2.write(i+". ");
            w2.write(String.valueOf(num));
            w2.newLine();
            w1.flush();
            w2.flush();
            // 分别将答案与题目写入相应文件夹；
        }

}
