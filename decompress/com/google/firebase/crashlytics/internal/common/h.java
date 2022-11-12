// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import java.io.IOException;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import com.google.firebase.crashlytics.internal.persistence.FileStore;

class h
{
    private final String a;
    private final FileStore b;
    
    public h(final String a, final FileStore b) {
        this.a = a;
        this.b = b;
    }
    
    private File b() {
        return this.b.e(this.a);
    }
    
    public boolean a() {
        boolean newFile;
        try {
            newFile = this.b().createNewFile();
        }
        catch (final IOException ex) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Error creating marker: ");
            sb.append(this.a);
            f.e(sb.toString(), ex);
            newFile = false;
        }
        return newFile;
    }
    
    public boolean c() {
        return this.b().exists();
    }
    
    public boolean d() {
        return this.b().delete();
    }
}
