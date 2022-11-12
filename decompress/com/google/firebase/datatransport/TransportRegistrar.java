// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.datatransport;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.ComponentFactory;
import s4.a;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.ComponentContainer;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;

@Keep
public class TransportRegistrar implements ComponentRegistrar
{
    public static TransportFactory a(final ComponentContainer componentContainer) {
        return lambda$getComponents$0(componentContainer);
    }
    
    private static TransportFactory lambda$getComponents$0(final ComponentContainer componentContainer) {
        TransportRuntime.f(componentContainer.a(Context.class));
        return TransportRuntime.c().g(CCTDestination.h);
    }
    
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.c(TransportFactory.class).b(Dependency.j(Context.class)).f((ComponentFactory<TransportFactory>)a.a).d(), LibraryVersionComponent.b("fire-transport", "18.1.5"));
    }
}
