package com.seesea.job.util;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
* @description
* @since JDK1.8
* @createTime 2021/4/5 20:13
* @author xie
*/
public class Pinyin {

    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        //拼音小写
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        //不带声调
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//        //要转换的中文，格式，转换之后的拼音的分隔符，遇到不能转换的是否保留   wo,shi,zhong,guo,ren,，hello
//        System.out.println(PinyinHelper.toHanYuPinyinString("我是中国人，hello", format, ",", true));
        System.out.println(HanziToPinyin("浦东"));

    }


    public static String HanziToPinyin(String hanzi) throws BadHanyuPinyinOutputFormatCombination {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //拼音小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //不带声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        return PinyinHelper.toHanYuPinyinString(hanzi,format,"",true);

    }

}
