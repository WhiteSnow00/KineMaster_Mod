// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import java.util.Objects;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;

public class DatabaseReference extends Query
{
    DatabaseReference(final Repo repo, final Path path) {
        super(repo, path);
    }
    
    private Task<Void> l(final Map<String, Object> map, final CompletionListener completionListener) {
        Objects.requireNonNull(map, "Can't pass null for argument 'update' in updateChildren()");
        final Map<String, Object> j = CustomClassMapper.j(map);
        final CompoundWrite o = CompoundWrite.o(Validation.c(this.d(), j));
        final Pair<Task<Void>, CompletionListener> l = Utilities.l(completionListener);
        super.a.U(new Runnable(this, o, l, j) {
            final CompoundWrite a;
            final Pair b;
            final Map c;
            final DatabaseReference d;
            
            @Override
            public void run() {
                final DatabaseReference d = this.d;
                d.a.Y(d.d(), this.a, this.b.b(), this.c);
            }
        });
        return l.a();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof DatabaseReference && this.toString().equals(o.toString());
    }
    
    public DatabaseReference h(final String s) {
        Objects.requireNonNull(s, "Can't pass null for argument 'pathString' in child()");
        if (this.d().isEmpty()) {
            Validation.f(s);
        }
        else {
            Validation.e(s);
        }
        return new DatabaseReference(super.a, this.d().m(new Path(s)));
    }
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    public String i() {
        if (this.d().isEmpty()) {
            return null;
        }
        return this.d().q().c();
    }
    
    public DatabaseReference j() {
        final Path w = this.d().w();
        if (w != null) {
            return new DatabaseReference(super.a, w);
        }
        return null;
    }
    
    public Task<Void> k(final Map<String, Object> map) {
        return this.l(map, null);
    }
    
    @Override
    public String toString() {
        final DatabaseReference j = this.j();
        if (j == null) {
            return super.a.toString();
        }
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append(j.toString());
            sb.append("/");
            sb.append(URLEncoder.encode(this.i(), "UTF-8").replace("+", "%20"));
            return sb.toString();
        }
        catch (final UnsupportedEncodingException ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to URLEncode key: ");
            sb2.append(this.i());
            throw new DatabaseException(sb2.toString(), ex);
        }
    }
    
    public interface CompletionListener
    {
        void a(final DatabaseError p0, final DatabaseReference p1);
    }
}
