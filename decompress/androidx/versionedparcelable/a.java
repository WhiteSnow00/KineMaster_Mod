// 
// Decompiled by Procyon v0.6.0
// 

package androidx.versionedparcelable;

import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;
import android.os.Parcel;
import android.util.SparseIntArray;

class a extends VersionedParcel
{
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;
    
    a(final Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a<String, Method>(), new androidx.collection.a<String, Method>(), new androidx.collection.a<String, Class>());
    }
    
    private a(final Parcel e, final int n, final int g, final String h, final androidx.collection.a<String, Method> a, final androidx.collection.a<String, Method> a2, final androidx.collection.a<String, Class> a3) {
        super(a, a2, a3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.k = -1;
        this.e = e;
        this.f = n;
        this.g = g;
        this.j = n;
        this.h = h;
    }
    
    public void A(final byte[] array) {
        if (array != null) {
            this.e.writeInt(array.length);
            this.e.writeByteArray(array);
        }
        else {
            this.e.writeInt(-1);
        }
    }
    
    @Override
    protected void C(final CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }
    
    public void E(final int n) {
        this.e.writeInt(n);
    }
    
    public void G(final Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }
    
    public void I(final String s) {
        this.e.writeString(s);
    }
    
    public void a() {
        final int i = this.i;
        if (i >= 0) {
            final int value = this.d.get(i);
            final int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(value);
            this.e.writeInt(dataPosition - value);
            this.e.setDataPosition(dataPosition);
        }
    }
    
    @Override
    protected VersionedParcel b() {
        final Parcel e = this.e;
        final int dataPosition = e.dataPosition();
        int n;
        if ((n = this.j) == this.f) {
            n = this.g;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.h);
        sb.append("  ");
        return new a(e, dataPosition, n, sb.toString(), super.a, super.b, super.c);
    }
    
    public boolean g() {
        return this.e.readInt() != 0;
    }
    
    public byte[] i() {
        final int int1 = this.e.readInt();
        if (int1 < 0) {
            return null;
        }
        final byte[] array = new byte[int1];
        this.e.readByteArray(array);
        return array;
    }
    
    @Override
    protected CharSequence k() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }
    
    public boolean m(final int n) {
        while (true) {
            final int j = this.j;
            final int g = this.g;
            boolean b = true;
            if (j >= g) {
                if (this.k != n) {
                    b = false;
                }
                return b;
            }
            final int k = this.k;
            if (k == n) {
                return true;
            }
            if (String.valueOf(k).compareTo(String.valueOf(n)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            final int int1 = this.e.readInt();
            this.k = this.e.readInt();
            this.j += int1;
        }
    }
    
    public int o() {
        return this.e.readInt();
    }
    
    public <T extends Parcelable> T q() {
        return (T)this.e.readParcelable(this.getClass().getClassLoader());
    }
    
    public String s() {
        return this.e.readString();
    }
    
    public void w(final int i) {
        this.a();
        this.i = i;
        this.d.put(i, this.e.dataPosition());
        this.E(0);
        this.E(i);
    }
    
    public void y(final boolean b) {
        this.e.writeInt((int)(b ? 1 : 0));
    }
}
