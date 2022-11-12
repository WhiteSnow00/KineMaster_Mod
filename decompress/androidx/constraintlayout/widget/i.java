// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.widget;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.HashMap;
import android.util.SparseIntArray;

public class i
{
    private SparseIntArray a;
    private HashMap<Integer, HashSet<WeakReference<a>>> b;
    
    public i() {
        this.a = new SparseIntArray();
        this.b = new HashMap<Integer, HashSet<WeakReference<a>>>();
    }
    
    public void a(final int n, final a a) {
        HashSet set;
        if ((set = this.b.get(n)) == null) {
            set = new HashSet();
            this.b.put(n, set);
        }
        set.add(new WeakReference(a));
    }
    
    public interface a
    {
    }
}
