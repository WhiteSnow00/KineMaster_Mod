// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.emulators.EmulatedServiceSettings;

public final class RepoInfo
{
    public String a;
    public boolean b;
    public String c;
    public String d;
    
    public void a(@Nullable final EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(emulatedServiceSettings.a());
        sb.append(":");
        sb.append(emulatedServiceSettings.b());
        final String string = sb.toString();
        this.a = string;
        this.d = string;
        this.b = false;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && RepoInfo.class == o.getClass()) {
            final RepoInfo repoInfo = (RepoInfo)o;
            return this.b == repoInfo.b && this.a.equals(repoInfo.a) && this.c.equals(repoInfo.c);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a.hashCode() * 31 + (this.b ? 1 : 0)) * 31 + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("http");
        String s;
        if (this.b) {
            s = "s";
        }
        else {
            s = "";
        }
        sb.append(s);
        sb.append("://");
        sb.append(this.a);
        return sb.toString();
    }
}
