package Tests.junitCalismalari.Conditions;

import org.junit.jupiter.api.condition.EnabledIf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@EnabledIf("Tests.junitCalismalari.Conditions.Conditions#isSafari")
public @interface Safari {
}
