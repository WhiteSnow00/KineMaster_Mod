// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import java.util.Set;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.Bundle;
import androidx.loader.content.b;
import androidx.loader.app.a;

final class h implements a
{
    final SignInHubActivity a;
    
    h(final SignInHubActivity a, final zbv zbv) {
        this.a = a;
    }
    
    @Override
    public final /* bridge */ void a(final b b, final Object o) {
        final Void void1 = (Void)o;
        final SignInHubActivity a = this.a;
        a.setResult(SignInHubActivity.q(a), SignInHubActivity.r(a));
        this.a.finish();
    }
    
    @Override
    public final b b(final int n, final Bundle bundle) {
        return new zbc((Context)this.a, GoogleApiClient.j());
    }
    
    @Override
    public final void c(final b b) {
    }
}
