// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;

public class DisabledBreadcrumbSource implements BreadcrumbSource
{
    @Override
    public void a(final BreadcrumbHandler breadcrumbHandler) {
        Logger.f().b("Could not register handler for breadcrumbs events.");
    }
}
