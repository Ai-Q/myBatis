package com.test;

import com.dao.EmployeeMapper;
import com.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @outhor Mr.Huang
 * @create 2019:04:28 15:27
 */
public class EmployeeTest {
    public static void main(String[] args) throws Exception {
        String resource = "myBatis.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //使用openSession()方法的时候，若参数不给，或参数为false，表示事务不自动提交
        //若openSession()参数为true的话，则表示事务会自动提交
        SqlSession session = sqlSessionFactory.openSession(true);
       /* Employee emp = (Employee) session.selectOne("getEmpById", 1);
        System.out.println(emp);*/
      /*  EmployeeMapper mapper = (EmployeeMapper) session.getMapper(EmployeeMapper.class);
        Employee e= new Employee();
        e.setId(1);
        Employee emp = mapper.getEmpById(e);
        System.out.println(emp);*/

        /*注解实现*/
        EmployeeMapper mapper = (EmployeeMapper) session.getMapper(EmployeeMapper.class);
        Employee e = mapper.getEmpById1(3);
        // Employee employee =new Employee(3,"王五",1,"wangwu@qq.com");
        //boolean b = mapper.addEmp1(employee);
        //System.out.println(b);
        e.setLastName("黄毛");
        boolean b = mapper.updateEmp1(e);
        System.out.println("修改========" + b);
        boolean b1 = mapper.delEmp1(1);
        System.out.println("删除========" + b1);

        Employee emp = mapper.getEmpById1(1);

        System.out.println(emp);
        System.out.println(e);
        session.close();
    }
}
