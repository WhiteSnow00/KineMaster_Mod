// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

public final class g implements BreadcrumbHandler
{
    public final CrashlyticsCore a;
    
    public g(final CrashlyticsCore a) {
        this.a = a;
    }
    
    @Override
    public final void a(final String s) {
        this.a.k(s);
    }
}
