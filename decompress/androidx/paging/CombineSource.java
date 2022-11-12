// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import kotlin.Metadata;

@Metadata(d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Landroidx/paging/CombineSource;", "", "(Ljava/lang/String;I)V", "INITIAL", "RECEIVER", "OTHER", "paging-common" }, k = 1, mv = { 1, 5, 1 }, xi = 48)
public enum CombineSource
{
    private static final CombineSource[] $VALUES;
    
    INITIAL, 
    OTHER, 
    RECEIVER;
    
    static {
        $VALUES = a();
    }
    
    private static final CombineSource[] a() {
        return new CombineSource[] { CombineSource.INITIAL, CombineSource.RECEIVER, CombineSource.OTHER };
    }
}
