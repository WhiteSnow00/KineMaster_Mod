// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector.internal;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.firebase.analytics.connector.AnalyticsConnectorImpl;
import com.google.firebase.events.Subscriber;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.android.gms.common.annotation.KeepForSdk;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;

@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar
{
    static AnalyticsConnector lambda$getComponents$0(final ComponentContainer componentContainer) {
        return AnalyticsConnectorImpl.h(componentContainer.a(FirebaseApp.class), componentContainer.a(Context.class), componentContainer.a(Subscriber.class));
    }
    
    @Keep
    @KeepForSdk
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.c(AnalyticsConnector.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.j(Context.class)).b(Dependency.j(Subscriber.class)).f(zzb.a).e().d(), LibraryVersionComponent.b("fire-analytics", "21.1.0"));
    }
}
