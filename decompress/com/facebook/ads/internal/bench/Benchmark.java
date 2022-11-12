// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.bench;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.CLASS)
public @interface Benchmark {
    int failAtMillis() default Integer.MAX_VALUE;
    
    int warnAtMillis() default Integer.MAX_VALUE;
}
