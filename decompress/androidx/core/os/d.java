// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.os;

import android.util.SizeF;
import android.util.Size;
import android.os.IBinder;
import java.io.Serializable;
import android.os.Parcelable;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import kotlin.Pair;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b" }, d2 = { "", "Lkotlin/Pair;", "", "", "pairs", "Landroid/os/Bundle;", "a", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release" }, k = 2, mv = { 1, 6, 0 })
public final class d
{
    public static final Bundle a(final Pair<String, ?>... array) {
        o.g((Object)array, "pairs");
        final Bundle bundle = new Bundle(array.length);
        for (final Pair<String, ?> pair : array) {
            final String s = (String)pair.component1();
            final Object component2 = pair.component2();
            if (component2 == null) {
                bundle.putString(s, (String)null);
            }
            else if (component2 instanceof Boolean) {
                bundle.putBoolean(s, (boolean)component2);
            }
            else if (component2 instanceof Byte) {
                bundle.putByte(s, ((Number)component2).byteValue());
            }
            else if (component2 instanceof Character) {
                bundle.putChar(s, (char)component2);
            }
            else if (component2 instanceof Double) {
                bundle.putDouble(s, ((Number)component2).doubleValue());
            }
            else if (component2 instanceof Float) {
                bundle.putFloat(s, ((Number)component2).floatValue());
            }
            else if (component2 instanceof Integer) {
                bundle.putInt(s, ((Number)component2).intValue());
            }
            else if (component2 instanceof Long) {
                bundle.putLong(s, ((Number)component2).longValue());
            }
            else if (component2 instanceof Short) {
                bundle.putShort(s, ((Number)component2).shortValue());
            }
            else if (component2 instanceof Bundle) {
                bundle.putBundle(s, (Bundle)component2);
            }
            else if (component2 instanceof CharSequence) {
                bundle.putCharSequence(s, (CharSequence)component2);
            }
            else if (component2 instanceof Parcelable) {
                bundle.putParcelable(s, (Parcelable)component2);
            }
            else if (component2 instanceof boolean[]) {
                bundle.putBooleanArray(s, (boolean[])component2);
            }
            else if (component2 instanceof byte[]) {
                bundle.putByteArray(s, (byte[])component2);
            }
            else if (component2 instanceof char[]) {
                bundle.putCharArray(s, (char[])component2);
            }
            else if (component2 instanceof double[]) {
                bundle.putDoubleArray(s, (double[])component2);
            }
            else if (component2 instanceof float[]) {
                bundle.putFloatArray(s, (float[])component2);
            }
            else if (component2 instanceof int[]) {
                bundle.putIntArray(s, (int[])component2);
            }
            else if (component2 instanceof long[]) {
                bundle.putLongArray(s, (long[])component2);
            }
            else if (component2 instanceof short[]) {
                bundle.putShortArray(s, (short[])component2);
            }
            else if (component2 instanceof Object[]) {
                final Class<?> componentType = ((short[])component2).getClass().getComponentType();
                o.d((Object)componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(s, (Parcelable[])component2);
                }
                else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(s, (String[])component2);
                }
                else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(s, (CharSequence[])component2);
                }
                else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        final String canonicalName = componentType.getCanonicalName();
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Illegal value array type ");
                        sb.append(canonicalName);
                        sb.append(" for key \"");
                        sb.append(s);
                        sb.append('\"');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    bundle.putSerializable(s, (Serializable)component2);
                }
            }
            else if (component2 instanceof Serializable) {
                bundle.putSerializable(s, (Serializable)component2);
            }
            else if (component2 instanceof IBinder) {
                b.a(bundle, s, (IBinder)component2);
            }
            else if (component2 instanceof Size) {
                c.a(bundle, s, (Size)component2);
            }
            else {
                if (!(component2 instanceof SizeF)) {
                    final String canonicalName2 = ((SizeF)component2).getClass().getCanonicalName();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal value type ");
                    sb2.append(canonicalName2);
                    sb2.append(" for key \"");
                    sb2.append(s);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString());
                }
                c.b(bundle, s, (SizeF)component2);
            }
        }
        return bundle;
    }
}
