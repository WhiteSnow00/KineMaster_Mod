// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

public final class i
{
    private static final i b;
    private final j a;
    
    static {
        b = a(new Locale[0]);
    }
    
    private i(final j a) {
        this.a = a;
    }
    
    public static i a(final Locale... array) {
        return d(a.a(array));
    }
    
    public static i d(final LocaleList list) {
        return new i(new k(list));
    }
    
    public Locale b(final int n) {
        return this.a.get(n);
    }
    
    public int c() {
        return this.a.size();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof i && this.a.equals(((i)o).a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    static class a
    {
        static LocaleList a(final Locale... array) {
            return new LocaleList(array);
        }
        
        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }
        
        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }
}
