// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import java.util.Locale;
import android.os.LocaleList;

final class k implements j
{
    private final LocaleList a;
    
    k(final Object o) {
        this.a = (LocaleList)o;
    }
    
    @Override
    public Object a() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.a.equals(((j)o).a());
    }
    
    @Override
    public Locale get(final int n) {
        return this.a.get(n);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public int size() {
        return this.a.size();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
}
