// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.ktx;

import kotlin.collections.o;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.Component;
import java.util.List;
import kotlin.Metadata;
import com.google.firebase.components.ComponentRegistrar;

@Metadata(d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005?\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016?\u0006\u0006" }, d2 = { "Lcom/google/firebase/analytics/ktx/FirebaseAnalyticsKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "java.com.google.android.libraries.firebase.firebase_analytics_ktx_granule" }, k = 1, mv = { 1, 7, 1 }, xi = 48)
public final class FirebaseAnalyticsKtxRegistrar implements ComponentRegistrar
{
    @Override
    public final List<Component<?>> getComponents() {
        return o.e((Object)LibraryVersionComponent.b("fire-analytics-ktx", "21.1.0"));
    }
}
