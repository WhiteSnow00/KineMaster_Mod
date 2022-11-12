// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.os;

import android.os.IInterface;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Handler;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public class ResultReceiver implements Parcelable
{
    public static final Parcelable$Creator<ResultReceiver> CREATOR;
    final boolean a;
    final Handler b;
    IResultReceiver c;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ResultReceiver>() {
            public ResultReceiver createFromParcel(final Parcel parcel) {
                return new ResultReceiver(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public ResultReceiver[] newArray(final int n) {
                return new ResultReceiver[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    public ResultReceiver(final Handler b) {
        this.a = true;
        this.b = b;
    }
    
    ResultReceiver(final Parcel parcel) {
        this.a = false;
        this.b = null;
        this.c = IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }
    
    protected void a(final int n, final Bundle bundle) {
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void send(final int n, final Bundle bundle) {
        if (this.a) {
            final Handler b = this.b;
            if (b != null) {
                b.post((Runnable)new MyRunnable(n, bundle));
            }
            else {
                this.a(n, bundle);
            }
            return;
        }
        final IResultReceiver c = this.c;
        if (c == null) {
            return;
        }
        try {
            c.send(n, bundle);
        }
        catch (final RemoteException ex) {}
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new MyResultReceiver();
            }
            parcel.writeStrongBinder(((IInterface)this.c).asBinder());
        }
    }
    
    class MyResultReceiver extends Stub
    {
        final ResultReceiver a;
        
        MyResultReceiver(final ResultReceiver a) {
            this.a = a;
        }
        
        public void send(final int n, final Bundle bundle) {
            final ResultReceiver a = this.a;
            final Handler b = a.b;
            if (b != null) {
                b.post((Runnable)a.new MyRunnable(n, bundle));
            }
            else {
                a.a(n, bundle);
            }
        }
    }
    
    class MyRunnable implements Runnable
    {
        final int a;
        final Bundle b;
        final ResultReceiver c;
        
        MyRunnable(final ResultReceiver c, final int a, final Bundle b) {
            this.c = c;
            this.a = a;
            this.b = b;
        }
        
        @Override
        public void run() {
            this.c.a(this.a, this.b);
        }
    }
}
