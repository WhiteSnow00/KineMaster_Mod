// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public final class BidderTokenProvider
{
    public static String getBidderToken(final Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        return DynamicLoaderFactory.makeLoader(context).createBidderTokenProviderApi().getBidderToken(context);
    }
}
