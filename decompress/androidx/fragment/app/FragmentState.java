// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentState implements Parcelable
{
    public static final Parcelable$Creator<FragmentState> CREATOR;
    final String a;
    final String b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean p;
    final int w;
    Bundle x;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<FragmentState>() {
            public FragmentState a(final Parcel parcel) {
                return new FragmentState(parcel);
            }
            
            public FragmentState[] b(final int n) {
                return new FragmentState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    FragmentState(final Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        final int int1 = parcel.readInt();
        final boolean b = true;
        this.c = (int1 != 0);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = (parcel.readInt() != 0);
        this.h = (parcel.readInt() != 0);
        this.i = (parcel.readInt() != 0);
        this.j = parcel.readBundle();
        this.p = (parcel.readInt() != 0 && b);
        this.x = parcel.readBundle();
        this.w = parcel.readInt();
    }
    
    FragmentState(final Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.mWho;
        this.c = fragment.mFromLayout;
        this.d = fragment.mFragmentId;
        this.e = fragment.mContainerId;
        this.f = fragment.mTag;
        this.g = fragment.mRetainInstance;
        this.h = fragment.mRemoving;
        this.i = fragment.mDetached;
        this.j = fragment.mArguments;
        this.p = fragment.mHidden;
        this.w = fragment.mMaxState.ordinal();
    }
    
    Fragment a(final l l, final ClassLoader classLoader) {
        final Fragment a = l.a(classLoader, this.a);
        final Bundle j = this.j;
        if (j != null) {
            j.setClassLoader(classLoader);
        }
        a.setArguments(this.j);
        a.mWho = this.b;
        a.mFromLayout = this.c;
        a.mRestored = true;
        a.mFragmentId = this.d;
        a.mContainerId = this.e;
        a.mTag = this.f;
        a.mRetainInstance = this.g;
        a.mRemoving = this.h;
        a.mDetached = this.i;
        a.mHidden = this.p;
        a.mMaxState = Lifecycle.State.values()[this.w];
        final Bundle x = this.x;
        if (x != null) {
            a.mSavedFragmentState = x;
        }
        else {
            a.mSavedFragmentState = new Bundle();
        }
        return a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.b);
        sb.append(")}:");
        if (this.c) {
            sb.append(" fromLayout");
        }
        if (this.e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.e));
        }
        final String f = this.f;
        if (f != null && !f.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f);
        }
        if (this.g) {
            sb.append(" retainInstance");
        }
        if (this.h) {
            sb.append(" removing");
        }
        if (this.i) {
            sb.append(" detached");
        }
        if (this.p) {
            sb.append(" hidden");
        }
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt((int)(this.c ? 1 : 0));
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt((int)(this.g ? 1 : 0));
        parcel.writeInt((int)(this.h ? 1 : 0));
        parcel.writeInt((int)(this.i ? 1 : 0));
        parcel.writeBundle(this.j);
        parcel.writeInt((int)(this.p ? 1 : 0));
        parcel.writeBundle(this.x);
        parcel.writeInt(this.w);
    }
}
