package com.llayjun.millet.common.annotation;

import java.lang.annotation.*;

/**
 * @author zyl
 * @date 2018-07-08 20:38
 */
@Target({ElementType.PARAMETER}) // Annotation所修饰的对象范围:方法参数
@Retention(RetentionPolicy.RUNTIME) // Annotation被保留时间:运行时保留(有效)
@Documented
public @interface CurrentUser {

}
