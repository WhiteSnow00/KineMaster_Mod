// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.util.concurrent.ThreadFactory;
import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zat;
import java.util.concurrent.ExecutorService;

public final class zabj
{
    private static final ExecutorService a;
    
    static {
        a = zat.zaa().zac(2, (ThreadFactory)new NumberedThreadFactory("GAC_Executor"), 2);
    }
    
    public static ExecutorService a() {
        return zabj.a;
    }
}
