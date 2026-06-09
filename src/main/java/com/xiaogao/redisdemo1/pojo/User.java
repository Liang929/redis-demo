package com.xiaogao.redisdemo1.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//自动生成所有的get、set、toString等方法
@Data
//生成一个无参构造器
@NoArgsConstructor
//生成一个包含所有字段的生成器
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
