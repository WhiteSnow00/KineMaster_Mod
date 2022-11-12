// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;

@Keep
public class DatabaseRegistrar implements ComponentRegistrar
{
    public static a a(final ComponentContainer componentContainer) {
        return lambda$getComponents$0(componentContainer);
    }
    
    private static a lambda$getComponents$0(final ComponentContainer componentContainer) {
        return new a(componentContainer.a(FirebaseApp.class), componentContainer.e(InternalAuthProvider.class), componentContainer.e(InternalAppCheckTokenProvider.class));
    }
    
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.c(a.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.a(InternalAuthProvider.class)).b(Dependency.a(InternalAppCheckTokenProvider.class)).f((ComponentFactory<a>)o4.a.a).d(), LibraryVersionComponent.b("fire-rtdb", "20.0.5"));
    }
}
