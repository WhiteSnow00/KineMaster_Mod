// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

@Deprecated
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface b0 {
    Lifecycle.Event value();
}
