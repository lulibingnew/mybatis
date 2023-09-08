package com.tcrcb.dao;

import com.tcrcb.pojo.User;
import com.tcrcb.utils.MybatisUtils;
import info.monitorenter.cpdetector.io.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

public class UserTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        for (User user : mapper.getUserList()) {
            System.out.println(user.toString());
        }
        sqlSession.close();
        System.out.println("23");
    }
    @Test
    public void test2(){
        List<String> ls = new ArrayList<>();
        ls.add("20230101");
        ls.add("20230301");
        ls.add("20230201");
        Collections.sort(ls);
        System.out.println(ls);
    }

    @Test
    public void test3(){
        File file = new File("C:\\Users\\86153\\Desktop\\temp\\adf.txt");
        try{
            System.out.println(getCharsetName(file));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getCharsetName(File file) throws IOException {
        String charsetName = "UTF-8";
        // 获取 CodepageDetectorProxy 实例
        CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
        // 添加解析器，会使用到添加的后 2 个 ext 里的 jar 包
        detector.add(new ParsingDetector(false));
        detector.add(JChardetFacade.getInstance());
        detector.add(ASCIIDetector.getInstance());
        detector.add(UnicodeDetector.getInstance());
        Charset charset = detector.detectCodepage(file.toURI().toURL());
        if (charset != null) charsetName = charset.name();
        return charsetName;
    }



}
