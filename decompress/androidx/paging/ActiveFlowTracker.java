// 
// Decompiled by Procyon v0.6.0
// 

package androidx.paging;

import ka.r;
import kotlin.coroutines.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001:\u0001\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@\u00f8\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@\u00f8\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t" }, d2 = { "Landroidx/paging/ActiveFlowTracker;", "", "Landroidx/paging/ActiveFlowTracker$FlowType;", "flowType", "Lka/r;", "b", "(Landroidx/paging/ActiveFlowTracker$FlowType;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "FlowType", "paging-common" }, k = 1, mv = { 1, 5, 1 })
public interface ActiveFlowTracker
{
    Object a(final FlowType p0, final c<? super r> p1);
    
    Object b(final FlowType p0, final c<? super r> p1);
    
    @Metadata(d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005" }, d2 = { "Landroidx/paging/ActiveFlowTracker$FlowType;", "", "(Ljava/lang/String;I)V", "PAGED_DATA_FLOW", "PAGE_EVENT_FLOW", "paging-common" }, k = 1, mv = { 1, 5, 1 }, xi = 48)
    public enum FlowType
    {
        private static final FlowType[] $VALUES;
        
        PAGED_DATA_FLOW, 
        PAGE_EVENT_FLOW;
        
        static {
            $VALUES = a();
        }
        
        private static final FlowType[] a() {
            return new FlowType[] { FlowType.PAGED_DATA_FLOW, FlowType.PAGE_EVENT_FLOW };
        }
    }
}
