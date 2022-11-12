// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity.result;

import android.os.Parcel;
import android.content.Intent;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class ActivityResult implements Parcelable
{
    public static final Parcelable$Creator<ActivityResult> CREATOR;
    private final int a;
    private final Intent b;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ActivityResult>() {
            public ActivityResult a(final Parcel parcel) {
                return new ActivityResult(parcel);
            }
            
            public ActivityResult[] b(final int n) {
                return new ActivityResult[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public ActivityResult(final int a, final Intent b) {
        this.a = a;
        this.b = b;
    }
    
    ActivityResult(final Parcel parcel) {
        this.a = parcel.readInt();
        Intent b;
        if (parcel.readInt() == 0) {
            b = null;
        }
        else {
            b = (Intent)Intent.CREATOR.createFromParcel(parcel);
        }
        this.b = b;
    }
    
    public static String c(final int n) {
        if (n == -1) {
            return "RESULT_OK";
        }
        if (n != 0) {
            return String.valueOf(n);
        }
        return "RESULT_CANCELED";
    }
    
    public Intent a() {
        return this.b;
    }
    
    public int b() {
        return this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ActivityResult{resultCode=");
        sb.append(c(this.a));
        sb.append(", data=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        int n2;
        if (this.b == null) {
            n2 = 0;
        }
        else {
            n2 = 1;
        }
        parcel.writeInt(n2);
        final Intent b = this.b;
        if (b != null) {
            b.writeToParcel(parcel, n);
        }
    }
}
