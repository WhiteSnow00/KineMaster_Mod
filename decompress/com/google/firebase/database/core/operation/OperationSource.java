// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;

public class OperationSource
{
    public static final OperationSource d;
    public static final OperationSource e;
    private final Source a;
    private final QueryParams b;
    private final boolean c;
    
    static {
        d = new OperationSource(Source.User, null, false);
        e = new OperationSource(Source.Server, null, false);
    }
    
    public OperationSource(final Source a, final QueryParams b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
        Utilities.f(!c || this.c());
    }
    
    public static OperationSource a(final QueryParams queryParams) {
        return new OperationSource(Source.Server, queryParams, true);
    }
    
    public QueryParams b() {
        return this.b;
    }
    
    public boolean c() {
        return this.a == Source.Server;
    }
    
    public boolean d() {
        return this.a == Source.User;
    }
    
    public boolean e() {
        return this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OperationSource{source=");
        sb.append(this.a);
        sb.append(", queryParams=");
        sb.append(this.b);
        sb.append(", tagged=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
    
    private enum Source
    {
        private static final Source[] $VALUES;
        
        Server, 
        User;
    }
}
