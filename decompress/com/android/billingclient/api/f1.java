// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.Arrays;
import org.json.JSONObject;

public final class f1
{
    private final String a;
    private final String b;
    
    f1(final JSONObject jsonObject, final e1 e1) {
        this.a = jsonObject.optString("productId");
        this.b = jsonObject.optString("productType");
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof f1)) {
            return false;
        }
        final f1 f1 = (f1)o;
        return this.a.equals(f1.a) && this.b.equals(f1.b);
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.a, this.b });
    }
    
    @Override
    public final String toString() {
        return String.format("{id: %s, type: %s}", this.a, this.b);
    }
}
