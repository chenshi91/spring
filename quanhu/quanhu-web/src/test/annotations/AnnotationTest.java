/**Created	by	chenshi  at	2017年12月17日 下午1:19:18*/
package annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
/**
 * @description:	AnnotationTest.java
 * @packageName:	annotations
 * @projectName:	quanhu-web
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public @interface AnnotationTest {
	
//	private String name() default "sdsd";
}
