/**Created	by	chenshi  at	2017年12月17日 下午1:19:18*/
package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:	AnnotationTest.java
 * @packageName:	annotations
 * @projectName:	quanhu-web
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//运行时
public @interface AnnotationTest {
	
	String name() default "xujiali";
	String value();
	
}
