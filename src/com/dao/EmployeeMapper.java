package com.dao;

import com.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @outhor Mr.Huang
 * @create 2019:04:28 14:58
 */
public interface EmployeeMapper {
    //根据id来查询员工
    /*@Select("select * from employee where id=#{id}")*/
    public Employee getEmpById(Employee e);

    //验证托等命名规则
    public Employee getEmpById2(Employee e);

    @Select("select id,last_Name lastName,gender,email from employee where id=#{id}")
    public Employee getEmpById1(int id);

    //添加
    @Insert("insert into employee values(#{id},#{lastName},#{gender},#{email})")
    public boolean addEmp1(Employee e);

    //修改
    @Update("update employee set last_Name=#{lastName} where id=#{id}")
    public boolean updateEmp1(Employee e);

    //删除
    @Delete("delete from employee where id=#{id}")
    public boolean delEmp1(int id);

    public Employee getEmpByIdOracle(Employee e);
}
