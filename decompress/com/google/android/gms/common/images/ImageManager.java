// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import android.os.ParcelFileDescriptor;
import android.os.Bundle;
import java.util.ArrayList;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepName;
import android.os.ResultReceiver;
import java.util.Map;
import com.google.android.gms.internal.base.zam;
import java.util.concurrent.ExecutorService;
import android.os.Handler;
import android.content.Context;
import java.util.HashSet;

public final class ImageManager
{
    private static final Object h;
    private static HashSet i;
    private final Context a;
    private final Handler b;
    private final ExecutorService c;
    private final zam d;
    private final Map e;
    private final Map f;
    private final Map g;
    
    static {
        h = new Object();
        ImageManager.i = new HashSet();
    }
    
    static /* bridge */ Context a(final ImageManager imageManager) {
        return imageManager.a;
    }
    
    static /* bridge */ Handler b(final ImageManager imageManager) {
        return imageManager.b;
    }
    
    static /* bridge */ zam c(final ImageManager imageManager) {
        return imageManager.d;
    }
    
    static /* bridge */ Object d() {
        return ImageManager.h;
    }
    
    static /* bridge */ HashSet e() {
        return ImageManager.i;
    }
    
    static /* bridge */ Map f(final ImageManager imageManager) {
        return imageManager.g;
    }
    
    static /* bridge */ Map g(final ImageManager imageManager) {
        return imageManager.e;
    }
    
    static /* bridge */ Map h(final ImageManager imageManager) {
        return imageManager.f;
    }
    
    static /* bridge */ ExecutorService i(final ImageManager imageManager) {
        return imageManager.c;
    }
    
    @KeepName
    private final class ImageReceiver extends ResultReceiver
    {
        private final Uri a;
        private final ArrayList b;
        final ImageManager c;
        
        static /* bridge */ ArrayList a(final ImageReceiver imageReceiver) {
            return imageReceiver.b;
        }
        
        public final void onReceiveResult(final int n, final Bundle bundle) {
            final ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            final ImageManager c = this.c;
            ImageManager.i(c).execute(new a(c, this.a, parcelFileDescriptor));
        }
    }
    
    public interface OnImageLoadedListener
    {
    }
}
