// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final class a implements ThreadFactory
{
    public final String a;
    
    public a(final String a) {
        this.a = a;
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        return b.a(this.a, runnable);
    }
}
