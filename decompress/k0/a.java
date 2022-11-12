// 
// Decompiled by Procyon v0.6.0
// 

package k0;

import kotlin.jvm.internal.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0002\u0005\nB\t\b\u0000¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006R,\u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e" }, d2 = { "Lk0/a;", "", "T", "Lk0/a$b;", "key", "a", "(Lk0/a$b;)Ljava/lang/Object;", "", "map", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class a
{
    private final Map<b<?>, Object> a;
    
    public a() {
        this.a = new LinkedHashMap<b<?>, Object>();
    }
    
    public abstract <T> T a(final b<T> p0);
    
    public final Map<b<?>, Object> b() {
        return this.a;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t" }, d2 = { "Lk0/a$a;", "Lk0/a;", "T", "Lk0/a$b;", "key", "a", "(Lk0/a$b;)Ljava/lang/Object;", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a extends k0.a
    {
        public static final a b;
        
        static {
            b = new a();
        }
        
        private a() {
        }
        
        @Override
        public <T> T a(final b<T> b) {
            o.g((Object)b, "key");
            return null;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003\u00c0\u0006\u0001" }, d2 = { "Lk0/a$b;", "T", "", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public interface b<T>
    {
    }
}
