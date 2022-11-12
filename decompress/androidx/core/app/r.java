// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.graphics.drawable.Icon;
import android.app.Person$Builder;
import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public class r
{
    CharSequence a;
    IconCompat b;
    String c;
    String d;
    boolean e;
    boolean f;
    
    r(final b b) {
        this.a = b.a;
        this.b = b.b;
        this.c = b.c;
        this.d = b.d;
        this.e = b.e;
        this.f = b.f;
    }
    
    public IconCompat a() {
        return this.b;
    }
    
    public String b() {
        return this.d;
    }
    
    public CharSequence c() {
        return this.a;
    }
    
    public String d() {
        return this.c;
    }
    
    public boolean e() {
        return this.e;
    }
    
    public boolean f() {
        return this.f;
    }
    
    public String g() {
        final String c = this.c;
        if (c != null) {
            return c;
        }
        if (this.a != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("name:");
            sb.append((Object)this.a);
            return sb.toString();
        }
        return "";
    }
    
    public Person h() {
        return r.a.b(this);
    }
    
    static class a
    {
        static r a(final Person person) {
            final b f = new b().f(person.getName());
            IconCompat b;
            if (person.getIcon() != null) {
                b = IconCompat.b(person.getIcon());
            }
            else {
                b = null;
            }
            return f.c(b).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }
        
        static Person b(final r r) {
            final Person$Builder setName = new Person$Builder().setName(r.c());
            Icon p;
            if (r.a() != null) {
                p = r.a().p();
            }
            else {
                p = null;
            }
            return setName.setIcon(p).setUri(r.d()).setKey(r.b()).setBot(r.e()).setImportant(r.f()).build();
        }
    }
    
    public static class b
    {
        CharSequence a;
        IconCompat b;
        String c;
        String d;
        boolean e;
        boolean f;
        
        public r a() {
            return new r(this);
        }
        
        public b b(final boolean e) {
            this.e = e;
            return this;
        }
        
        public b c(final IconCompat b) {
            this.b = b;
            return this;
        }
        
        public b d(final boolean f) {
            this.f = f;
            return this;
        }
        
        public b e(final String d) {
            this.d = d;
            return this;
        }
        
        public b f(final CharSequence a) {
            this.a = a;
            return this;
        }
        
        public b g(final String c) {
            this.c = c;
            return this;
        }
    }
}
