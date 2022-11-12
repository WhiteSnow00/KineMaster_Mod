// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity.result;

import android.os.Parcel;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class IntentSenderRequest implements Parcelable
{
    public static final Parcelable$Creator<IntentSenderRequest> CREATOR;
    private final IntentSender a;
    private final Intent b;
    private final int c;
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<IntentSenderRequest>() {
            public IntentSenderRequest a(final Parcel parcel) {
                return new IntentSenderRequest(parcel);
            }
            
            public IntentSenderRequest[] b(final int n) {
                return new IntentSenderRequest[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    IntentSenderRequest(final IntentSender a, final Intent b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    IntentSenderRequest(final Parcel parcel) {
        this.a = (IntentSender)parcel.readParcelable(IntentSender.class.getClassLoader());
        this.b = (Intent)parcel.readParcelable(Intent.class.getClassLoader());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
    
    public Intent a() {
        return this.b;
    }
    
    public int b() {
        return this.c;
    }
    
    public int c() {
        return this.d;
    }
    
    public IntentSender d() {
        return this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeParcelable((Parcelable)this.a, n);
        parcel.writeParcelable((Parcelable)this.b, n);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
    
    public static final class b
    {
        private IntentSender a;
        private Intent b;
        private int c;
        private int d;
        
        public b(final IntentSender a) {
            this.a = a;
        }
        
        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.a, this.b, this.c, this.d);
        }
        
        public b b(final Intent b) {
            this.b = b;
            return this;
        }
        
        public b c(final int d, final int c) {
            this.d = d;
            this.c = c;
            return this;
        }
    }
}
