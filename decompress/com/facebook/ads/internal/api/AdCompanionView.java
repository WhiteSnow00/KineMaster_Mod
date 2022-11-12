// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.util.AttributeSet;
import android.content.Context;

public class AdCompanionView extends AdComponentFrameLayout
{
    private AdCompanionViewApi mAdCompanionViewApi;
    
    public AdCompanionView(final Context context) {
        super(context);
        this.initializeSelf(context);
    }
    
    public AdCompanionView(final Context context, final AttributeSet set) {
        super(context, set);
        this.initializeSelf(context);
    }
    
    public AdCompanionView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initializeSelf(context);
    }
    
    private void initializeSelf(final Context context) {
        this.attachAdComponentViewApi(this.mAdCompanionViewApi = DynamicLoaderFactory.makeLoader(context).createAdCompanionViewApi());
        this.mAdCompanionViewApi.initialize(this);
    }
    
    public AdCompanionViewApi getAdCompanionViewApi() {
        return this.mAdCompanionViewApi;
    }
}
