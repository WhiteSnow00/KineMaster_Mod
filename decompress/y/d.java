// 
// Decompiled by Procyon v0.6.0
// 

package y;

import android.view.inputmethod.InputContentInfo;
import android.content.ClipDescription;
import android.net.Uri;

public final class d
{
    private final b a;
    
    private d(final b a) {
        this.a = a;
    }
    
    public static d f(final Object o) {
        if (o == null) {
            return null;
        }
        return new d((b)new a(o));
    }
    
    public Uri a() {
        return this.a.b();
    }
    
    public ClipDescription b() {
        return this.a.getDescription();
    }
    
    public Uri c() {
        return this.a.d();
    }
    
    public void d() {
        this.a.c();
    }
    
    public Object e() {
        return this.a.a();
    }
    
    private static final class a implements b
    {
        final InputContentInfo a;
        
        a(final Object o) {
            this.a = (InputContentInfo)o;
        }
        
        @Override
        public Object a() {
            return this.a;
        }
        
        @Override
        public Uri b() {
            return this.a.getContentUri();
        }
        
        @Override
        public void c() {
            this.a.requestPermission();
        }
        
        @Override
        public Uri d() {
            return this.a.getLinkUri();
        }
        
        @Override
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }
    }
    
    private interface b
    {
        Object a();
        
        Uri b();
        
        void c();
        
        Uri d();
        
        ClipDescription getDescription();
    }
}
