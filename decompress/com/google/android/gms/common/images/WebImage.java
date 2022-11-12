// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import java.util.Locale;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.annotation.KeepForSdk;
import org.json.JSONException;
import org.json.JSONObject;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class WebImage extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<WebImage> CREATOR;
    @VersionField
    final int a;
    @Field
    private final Uri b;
    @Field
    private final int c;
    @Field
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new zah();
    }
    
    @Constructor
    WebImage(@Param final int a, @Param final Uri b, @Param final int c, @Param final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public WebImage(final Uri uri, final int n, final int n2) throws IllegalArgumentException {
        this(1, uri, n, n2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (n >= 0 && n2 >= 0) {
            return;
        }
        throw new IllegalArgumentException("width and height must not be negative");
    }
    
    @KeepForSdk
    public WebImage(final JSONObject jsonObject) throws IllegalArgumentException {
        Uri uri = Uri.EMPTY;
        while (true) {
            if (!jsonObject.has("url")) {
                break Label_0025;
            }
            try {
                uri = Uri.parse(jsonObject.getString("url"));
                this(uri, jsonObject.optInt("width", 0), jsonObject.optInt("height", 0));
            }
            catch (final JSONException ex) {
                uri = uri;
                continue;
            }
            break;
        }
    }
    
    public int K1() {
        return this.d;
    }
    
    public Uri L1() {
        return this.b;
    }
    
    public int M1() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null) {
            if (o instanceof WebImage) {
                final WebImage webImage = (WebImage)o;
                if (Objects.b(this.b, webImage.b) && this.c == webImage.c && this.d == webImage.d) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.b, this.c, this.d);
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", this.c, this.d, this.b.toString());
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.L1(), n, false);
        SafeParcelWriter.s(parcel, 3, this.M1());
        SafeParcelWriter.s(parcel, 4, this.K1());
        SafeParcelWriter.b(parcel, a);
    }
}
