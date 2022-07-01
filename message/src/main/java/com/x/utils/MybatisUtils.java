package com.x.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl=new ThreadLocal<>();
    static {
        try{
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取Session
    public static SqlSession getSession(){
        SqlSession session=tl.get();
        if(session==null){
            session=factory.openSession();
            tl.set(session);
        }
        return session;
    }
    //关闭Session
    public static void closeSession(){
        SqlSession session=tl.get();
        if(session!=null){
            session.close();
            tl.remove();
        }
    }
}
