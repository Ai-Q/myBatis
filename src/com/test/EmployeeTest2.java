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
public class EmployeeTest2 {

    public static SqlSessionFactory getSqlSessionFactory()throws Exception{
        String resource = "myBatis.xml";
        Reader reader = Resources.getResourceAsReader(resource);
       return new SqlSessionFactoryBuilder().build(reader);
    }

    public static void main(String[] args) throws Exception {
     SqlSession session=getSqlSessionFactory().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        System.out.println("MApper==="+mapper);
        Employee employee = new Employee();
        employee.setId(22);
        Employee e= mapper.getEmpByIdOracle(employee);
        System.out.println(e);
        /*
        Employee e=new Employee();
        e.setId(3);
        Employee emp = mapper.getEmpById2(e);
        System.out.println(emp);
        */
    }
}
