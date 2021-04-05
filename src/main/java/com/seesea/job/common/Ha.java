package com.seesea.job.common;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xie
 * @description
 * @createTime 2020/3/11 10:04
 * @since JDK1.8
 */
public class Ha {
    public static void main(String[] arg) {

//        questionOne(10);
//        questionThree("F:\\文件");
        questionSix();
    }

    public static void questionOne(int n) {

        int a, b;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a = (int) (Math.random() * 7);
            b = (int) (Math.random() * 7);
            list.add(a + b);
        }

        for (int y = 0; y <= 18; y++) {
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (y == list.get(i)) {
                    k++;
                }
            }
            System.out.println(y + "出现的概率是" + k + "/" + n);
        }

    }


    static int count = 0;

    public static void questionThree(String fileName) {

        File file = new File(fileName);

        if (file.isFile()) {
            return;
        }
//        List<String> list = Arrays.asList(file.list());
        List<File> list = Arrays.asList(file.listFiles());

        for (File a : list) {
            System.out.println(a);
            if (a.isFile()) {
                count++;
            }
            questionThree(a.getAbsolutePath());
        }
        System.out.println(count);
    }

    //    questionSix
    public static void questionSix() {

        String a = "main-action-holder";
        String[] k = a.split("-");
        String newStr = "";
        for(int i = 0 ;i < k.length ;i++){
            if(i == 0){
                newStr = k[i];
                continue;
            }
            newStr = newStr + k[i].substring(0,1).toUpperCase()+ k[i].substring(1,k[i].length());
        }
        System.out.println(newStr);

    }
//    questionSeven
//    redis 递增方法 控制 有序抢座
//    questionEight
//    select * from student LEFT JOIN exam where exam.user_id = student.id
//    questionNine
//    SELECT age , count(1) as num from USER GROUP BY age HAVING num > 2 ORDER BY num DESC

}
