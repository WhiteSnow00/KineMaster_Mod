// 
// Decompiled by Procyon v0.6.0
// 

package b7;

import com.kinemaster.module.network.kinemaster.service.notice.NoticeServiceImpl;
import com.kinemaster.module.network.kinemaster.service.notice.NoticeService$OnFailure;
import ba.e;

public final class a implements e
{
    public final NoticeService$OnFailure a;
    public final NoticeServiceImpl b;
    
    public a(final NoticeService$OnFailure a, final NoticeServiceImpl b) {
        this.a = a;
        this.b = b;
    }
    
    public final void accept(final Object o) {
        NoticeServiceImpl.a(this.a, this.b, (Throwable)o);
    }
}
