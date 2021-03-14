package com.sys.order.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MybatisUtils {
    /**
     * 通过反射的方式动态拼接sql(
     */
    public static <T> QueryWrapper<T> conditionSql(T object) {
        if (object == null) {
            return null;
        }
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                // 判断是不是常量（常量不加与条件）
                if (!Modifier.isFinal(f.getModifiers())) {
                    if (f.get(object) != null && !"".equals(f.get(object))) {
                        wrapper.eq(f.getAnnotation(TableField.class).value(), f.get(object));
                    }
                }
            } catch (IllegalAccessException e) {
                System.out.println("动态sql拼接异常！！！");
                e.printStackTrace();
            }
        }
        return wrapper;
    }
}
