// 
// Decompiled by Procyon v0.6.0
// 

package b7;

import com.kinemaster.module.network.kinemaster.service.notice.NoticeServiceImpl;
import com.kinemaster.module.network.kinemaster.service.notice.data.Notice;
import com.kinemaster.module.network.kinemaster.service.notice.NoticeService$OnSuccess;
import ba.e;

public final class b implements e
{
    public final NoticeService$OnSuccess a;
    
    public b(final NoticeService$OnSuccess a) {
        this.a = a;
    }
    
    public final void accept(final Object o) {
        NoticeServiceImpl.b(this.a, (Notice)o);
    }
}
