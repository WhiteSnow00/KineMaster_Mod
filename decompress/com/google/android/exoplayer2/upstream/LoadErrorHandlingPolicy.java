// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.LoadEventInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.util.Assertions;

public interface LoadErrorHandlingPolicy
{
    long a(final LoadErrorInfo p0);
    
    int b(final int p0);
    
    FallbackSelection c(final FallbackOptions p0, final LoadErrorInfo p1);
    
    default void d(final long n) {
    }
    
    public static final class FallbackOptions
    {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        
        public FallbackOptions(final int a, final int b, final int c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public boolean a(final int n) {
            boolean b = false;
            if (n == 1) {
                if (this.a - this.b <= 1) {
                    return b;
                }
            }
            else if (this.c - this.d <= 1) {
                return b;
            }
            b = true;
            return b;
        }
    }
    
    public static final class FallbackSelection
    {
        public final int a;
        public final long b;
        
        public FallbackSelection(final int a, final long b) {
            Assertions.a(b >= 0L);
            this.a = a;
            this.b = b;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface FallbackType {
    }
    
    public static final class LoadErrorInfo
    {
        public final LoadEventInfo a;
        public final MediaLoadData b;
        public final IOException c;
        public final int d;
        
        public LoadErrorInfo(final LoadEventInfo a, final MediaLoadData b, final IOException c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
}
