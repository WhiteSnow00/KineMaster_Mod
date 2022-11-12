// 
// Decompiled by Procyon v0.6.0
// 

package a7;

import com.kinemaster.module.network.kinemaster.service.dci.data.remote.DciClientImpl;
import retrofit2.r;
import ba.f;

public final class a implements f
{
    public static final a a;
    
    static {
        a = new a();
    }
    
    private a() {
    }
    
    public final Object apply(final Object o) {
        return DciClientImpl.a((r)o);
    }
}
