// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.heartbeatinfo.HeartBeatConsumerComponent;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.firebase.inject.Provider;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.android.gms.common.annotation.KeepForSdk;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;

@Keep
@KeepForSdk
public class FirebaseAuthRegistrar implements ComponentRegistrar
{
    static FirebaseAuth lambda$getComponents$0(final ComponentContainer componentContainer) {
        return new zzv(componentContainer.a(FirebaseApp.class), componentContainer.d(HeartBeatController.class));
    }
    
    @Keep
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.d(FirebaseAuth.class, InternalAuthProvider.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.k(HeartBeatController.class)).f((ComponentFactory<Object>)com.google.firebase.auth.zzv.a).e().d(), HeartBeatConsumerComponent.a(), LibraryVersionComponent.b("fire-auth", "21.0.6"));
    }
}
