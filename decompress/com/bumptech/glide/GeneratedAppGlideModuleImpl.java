// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide;

import p2.p;
import java.util.Collections;
import java.util.Set;
import android.util.Log;
import android.content.Context;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetIconGlideModule;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule
{
    private final AssetIconGlideModule a;
    
    public GeneratedAppGlideModuleImpl(final Context context) {
        this.a = new AssetIconGlideModule();
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.nexstreaming.app.general.nexasset.assetpackage.AssetIconGlideModule");
        }
    }
    
    @Override
    public void a(final Context context, final com.bumptech.glide.c c, final Registry registry) {
        this.a.a(context, c, registry);
    }
    
    @Override
    public void b(final Context context, final d d) {
        this.a.b(context, d);
    }
    
    @Override
    public boolean c() {
        return this.a.c();
    }
    
    public Set<Class<?>> d() {
        return Collections.emptySet();
    }
    
    @Override
    /* bridge */ p.b e() {
        return this.f();
    }
    
    com.bumptech.glide.a f() {
        return new com.bumptech.glide.a();
    }
}
