// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics;

import java.util.Arrays;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.components.ComponentFactory;
import k4.d;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Component;
import java.util.List;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;

public class CrashlyticsRegistrar implements ComponentRegistrar
{
    public static FirebaseCrashlytics a(final CrashlyticsRegistrar crashlyticsRegistrar, final ComponentContainer componentContainer) {
        return crashlyticsRegistrar.b(componentContainer);
    }
    
    private FirebaseCrashlytics b(final ComponentContainer componentContainer) {
        return FirebaseCrashlytics.b(componentContainer.a(FirebaseApp.class), componentContainer.a(FirebaseInstallationsApi.class), componentContainer.e(CrashlyticsNativeComponent.class), componentContainer.e(AnalyticsConnector.class));
    }
    
    @Override
    public List<Component<?>> getComponents() {
        return (List<Component<?>>)Arrays.asList(Component.c(FirebaseCrashlytics.class).b(Dependency.j(FirebaseApp.class)).b(Dependency.j(FirebaseInstallationsApi.class)).b(Dependency.a(CrashlyticsNativeComponent.class)).b(Dependency.a(AnalyticsConnector.class)).f((ComponentFactory<FirebaseCrashlytics>)new d(this)).e().d(), LibraryVersionComponent.b("fire-cls", "18.2.12"));
    }
}
