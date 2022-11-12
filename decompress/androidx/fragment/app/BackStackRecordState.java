// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import java.util.List;
import java.util.Map;
import androidx.lifecycle.Lifecycle;
import android.util.Log;
import android.text.TextUtils;
import android.os.Parcel;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class BackStackRecordState implements Parcelable
{
    public static final Parcelable$Creator<BackStackRecordState> CREATOR;
    final int[] a;
    final ArrayList<String> b;
    final int[] c;
    final int[] d;
    final int e;
    final String f;
    final int g;
    final int h;
    final CharSequence i;
    final int j;
    final CharSequence p;
    final ArrayList<String> w;
    final ArrayList<String> x;
    final boolean y;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<BackStackRecordState>() {
            public BackStackRecordState a(final Parcel parcel) {
                return new BackStackRecordState(parcel);
            }
            
            public BackStackRecordState[] b(final int n) {
                return new BackStackRecordState[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    BackStackRecordState(final Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createIntArray();
        this.d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.readInt();
        this.p = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.w = parcel.createStringArrayList();
        this.x = parcel.createStringArrayList();
        this.y = (parcel.readInt() != 0);
    }
    
    BackStackRecordState(final a a) {
        final int size = a.c.size();
        this.a = new int[size * 6];
        if (a.i) {
            this.b = new ArrayList<String>(size);
            this.c = new int[size];
            this.d = new int[size];
            for (int i = 0, n = 0; i < size; ++i, ++n) {
                final c0.a a2 = a.c.get(i);
                final int[] a3 = this.a;
                final int n2 = n + 1;
                a3[n] = a2.a;
                final ArrayList<String> b = this.b;
                final Fragment b2 = a2.b;
                String mWho;
                if (b2 != null) {
                    mWho = b2.mWho;
                }
                else {
                    mWho = null;
                }
                b.add(mWho);
                final int[] a4 = this.a;
                final int n3 = n2 + 1;
                a4[n2] = (a2.c ? 1 : 0);
                final int n4 = n3 + 1;
                a4[n3] = a2.d;
                final int n5 = n4 + 1;
                a4[n4] = a2.e;
                n = n5 + 1;
                a4[n5] = a2.f;
                a4[n] = a2.g;
                this.c[i] = a2.h.ordinal();
                this.d[i] = a2.i.ordinal();
            }
            this.e = a.h;
            this.f = a.k;
            this.g = a.v;
            this.h = a.l;
            this.i = a.m;
            this.j = a.n;
            this.p = a.o;
            this.w = a.p;
            this.x = a.q;
            this.y = a.r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }
    
    private void a(final a a) {
        int n = 0;
        int n2 = 0;
        while (true) {
            final int length = this.a.length;
            boolean c = true;
            if (n >= length) {
                break;
            }
            final c0.a a2 = new c0.a();
            final int[] a3 = this.a;
            final int n3 = n + 1;
            a2.a = a3[n];
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(a);
                sb.append(" op #");
                sb.append(n2);
                sb.append(" base fragment #");
                sb.append(this.a[n3]);
                Log.v("FragmentManager", sb.toString());
            }
            a2.h = Lifecycle.State.values()[this.c[n2]];
            a2.i = Lifecycle.State.values()[this.d[n2]];
            final int[] a4 = this.a;
            final int n4 = n3 + 1;
            if (a4[n3] == 0) {
                c = false;
            }
            a2.c = c;
            final int n5 = n4 + 1;
            final int n6 = a4[n4];
            a2.d = n6;
            final int n7 = n5 + 1;
            final int n8 = a4[n5];
            a2.e = n8;
            n = n7 + 1;
            final int n9 = a4[n7];
            a2.f = n9;
            final int n10 = a4[n];
            a2.g = n10;
            a.d = n6;
            a.e = n8;
            a.f = n9;
            a.g = n10;
            a.f(a2);
            ++n2;
            ++n;
        }
        a.h = this.e;
        a.k = this.f;
        a.i = true;
        a.l = this.h;
        a.m = this.i;
        a.n = this.j;
        a.o = this.p;
        a.p = this.w;
        a.q = this.x;
        a.r = this.y;
    }
    
    public a b(final FragmentManager fragmentManager) {
        final a a = new a(fragmentManager);
        this.a(a);
        a.v = this.g;
        for (int i = 0; i < this.b.size(); ++i) {
            final String s = this.b.get(i);
            if (s != null) {
                ((c0.a)a.c.get(i)).b = fragmentManager.h0(s);
            }
        }
        a.y(1);
        return a;
    }
    
    public a c(final FragmentManager fragmentManager, final Map<String, Fragment> map) {
        final a a = new a(fragmentManager);
        this.a(a);
        for (int i = 0; i < this.b.size(); ++i) {
            final String s = this.b.get(i);
            if (s != null) {
                final Fragment b = map.get(s);
                if (b == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Restoring FragmentTransaction ");
                    sb.append(this.f);
                    sb.append(" failed due to missing saved state for Fragment (");
                    sb.append(s);
                    sb.append(")");
                    throw new IllegalStateException(sb.toString());
                }
                ((c0.a)a.c.get(i)).b = b;
            }
        }
        return a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList((List)this.b);
        parcel.writeIntArray(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList((List)this.w);
        parcel.writeStringList((List)this.x);
        parcel.writeInt((int)(this.y ? 1 : 0));
    }
}
