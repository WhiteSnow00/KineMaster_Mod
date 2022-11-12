// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;

public final class ParsedUrl
{
    public RepoInfo a;
    public Path b;
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && ParsedUrl.class == o.getClass()) {
            final ParsedUrl parsedUrl = (ParsedUrl)o;
            return this.a.equals(parsedUrl.a) && this.b.equals(parsedUrl.b);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode() * 31 + this.b.hashCode();
    }
}
