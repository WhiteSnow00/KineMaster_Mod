// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.time.Clock;
import android.content.Context;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CreationContext
{
    public static CreationContext a(final Context context, final Clock clock, final Clock clock2, final String s) {
        return new c(context, clock, clock2, s);
    }
    
    public abstract Context b();
    
    public abstract String c();
    
    public abstract Clock d();
    
    public abstract Clock e();
}
