// 
// Decompiled by Procyon v0.6.0
// 

package c0;

import android.provider.DocumentsContract;
import android.net.Uri;
import android.content.Context;

public abstract class a
{
    private final a a;
    
    a(final a a) {
        this.a = a;
    }
    
    public static a f(final Context context, final Uri uri) {
        return new c(null, context, DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri)));
    }
    
    public abstract boolean a();
    
    public abstract a b(final String p0, final String p1);
    
    public abstract boolean c();
    
    public abstract boolean d();
    
    public a e(final String s) {
        for (final a a : this.m()) {
            if (s.equals(a.g())) {
                return a;
            }
        }
        return null;
    }
    
    public abstract String g();
    
    public a h() {
        return this.a;
    }
    
    public abstract Uri i();
    
    public abstract boolean j();
    
    public abstract boolean k();
    
    public abstract long l();
    
    public abstract a[] m();
}
