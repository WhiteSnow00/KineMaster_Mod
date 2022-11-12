// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.abt.component;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.ComponentFactory;
import j4.a;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;

@Keep
public class AbtRegistrar implements ComponentRegistrar
{
    public static AbtComponent a(final ComponentContainer componentContainer) {
        return lambda$getComponents$0(componentContainer);
    }
    
    private static AbtComponent lambda$getComponents$0(final ComponentContainer componentContainer) {
        return new AbtComponent(componentContainer.a(Context.class), componentContainer.d(AnalyticsConnector.class));
    }
    
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.c(AbtComponent.class).b(Dependency.j(Context.class)).b(Dependency.i(AnalyticsConnector.class)).f((ComponentFactory<AbtComponent>)a.a).d(), LibraryVersionComponent.b("fire-abt", "21.0.1"));
    }
}
