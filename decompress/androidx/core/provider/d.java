// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import android.database.Cursor;
import android.content.ContentResolver;
import android.net.Uri;
import android.content.ContentUris;
import android.net.Uri$Builder;
import java.util.Collection;
import java.util.Collections;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.os.CancellationSignal;
import android.content.Context;
import android.content.res.Resources;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.Signature;
import java.util.Comparator;

class d
{
    private static final Comparator<byte[]> a;
    
    static {
        a = c.a;
    }
    
    public static int a(final byte[] array, final byte[] array2) {
        return g(array, array2);
    }
    
    private static List<byte[]> b(final Signature[] array) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i].toByteArray());
        }
        return list;
    }
    
    private static boolean c(final List<byte[]> list, final List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (!Arrays.equals((byte[])list.get(i), (byte[])list2.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private static List<List<byte[]>> d(final e e, final Resources resources) {
        if (e.b() != null) {
            return e.b();
        }
        return androidx.core.content.res.d.c(resources, e.c());
    }
    
    static g.a e(final Context context, final e e, final CancellationSignal cancellationSignal) throws PackageManager$NameNotFoundException {
        final ProviderInfo f = f(context.getPackageManager(), e, context.getResources());
        if (f == null) {
            return g.a.a(1, null);
        }
        return g.a.a(0, h(context, e, f.authority, cancellationSignal));
    }
    
    static ProviderInfo f(final PackageManager packageManager, final e e, final Resources resources) throws PackageManager$NameNotFoundException {
        final String e2 = e.e();
        int i = 0;
        final ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(e2, 0);
        if (resolveContentProvider == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("No package found for authority: ");
            sb.append(e2);
            throw new PackageManager$NameNotFoundException(sb.toString());
        }
        if (resolveContentProvider.packageName.equals(e.f())) {
            final List<byte[]> b = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort((List<Object>)b, (Comparator<? super Object>)d.a);
            for (List<List<byte[]>> d = d(e, resources); i < d.size(); ++i) {
                final ArrayList list = new ArrayList<byte[]>((Collection<? extends T>)d.get(i));
                Collections.sort((List<E>)list, (Comparator<? super E>)d.a);
                if (c(b, (List<byte[]>)list)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Found content provider ");
        sb2.append(e2);
        sb2.append(", but package was not ");
        sb2.append(e.f());
        throw new PackageManager$NameNotFoundException(sb2.toString());
    }
    
    private static int g(final byte[] array, final byte[] array2) {
        if (array.length == array2.length) {
            for (int i = 0; i < array.length; ++i) {
                if (array[i] != array2[i]) {
                    final byte b = array[i];
                    final int length = array2[i];
                    final int length2 = b;
                    return length2 - length;
                }
            }
            return 0;
        }
        final int length2 = array.length;
        final int length = array2.length;
        return length2 - length;
    }
    
    static g.b[] h(final Context context, final e e, String s, final CancellationSignal cancellationSignal) {
        final ArrayList list = new ArrayList();
        final Uri build = new Uri$Builder().scheme("content").authority(s).build();
        final Uri build2 = new Uri$Builder().scheme("content").authority(s).appendPath("file").build();
        final String s2 = s = null;
        try {
            final ContentResolver contentResolver = context.getContentResolver();
            s = s2;
            final String g = e.g();
            s = s2;
            final Object a = d.a.a(contentResolver, build, new String[] { "_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code" }, "query = ?", new String[] { g }, null, cancellationSignal);
            ArrayList<g.b> list2 = list;
            if (a != null) {
                list2 = list;
                s = (String)a;
                if (((Cursor)a).getCount() > 0) {
                    s = (String)a;
                    final int columnIndex = ((Cursor)a).getColumnIndex("result_code");
                    s = (String)a;
                    s = (String)a;
                    final ArrayList<g.b> list3 = new ArrayList<g.b>();
                    s = (String)a;
                    final int columnIndex2 = ((Cursor)a).getColumnIndex("_id");
                    s = (String)a;
                    final int columnIndex3 = ((Cursor)a).getColumnIndex("file_id");
                    s = (String)a;
                    final int columnIndex4 = ((Cursor)a).getColumnIndex("font_ttc_index");
                    s = (String)a;
                    final int columnIndex5 = ((Cursor)a).getColumnIndex("font_weight");
                    s = (String)a;
                    final int columnIndex6 = ((Cursor)a).getColumnIndex("font_italic");
                    while (true) {
                        s = (String)a;
                        if (!((Cursor)a).moveToNext()) {
                            break;
                        }
                        int int1;
                        if (columnIndex != -1) {
                            s = (String)a;
                            int1 = ((Cursor)a).getInt(columnIndex);
                        }
                        else {
                            int1 = 0;
                        }
                        int int2;
                        if (columnIndex4 != -1) {
                            s = (String)a;
                            int2 = ((Cursor)a).getInt(columnIndex4);
                        }
                        else {
                            int2 = 0;
                        }
                        Uri uri;
                        if (columnIndex3 == -1) {
                            s = (String)a;
                            uri = ContentUris.withAppendedId(build, ((Cursor)a).getLong(columnIndex2));
                        }
                        else {
                            s = (String)a;
                            uri = ContentUris.withAppendedId(build2, ((Cursor)a).getLong(columnIndex3));
                        }
                        int int3;
                        if (columnIndex5 != -1) {
                            s = (String)a;
                            int3 = ((Cursor)a).getInt(columnIndex5);
                        }
                        else {
                            int3 = 400;
                        }
                        boolean b = false;
                        Label_0398: {
                            if (columnIndex6 != -1) {
                                s = (String)a;
                                if (((Cursor)a).getInt(columnIndex6) == 1) {
                                    b = true;
                                    break Label_0398;
                                }
                            }
                            b = false;
                        }
                        s = (String)a;
                        list3.add(androidx.core.provider.g.b.a(uri, int2, int3, b, int1));
                    }
                    list2 = list3;
                }
            }
            if (a != null) {
                ((Cursor)a).close();
            }
            return list2.toArray(new g.b[0]);
        }
        finally {
            if (s != null) {
                ((Cursor)s).close();
            }
        }
    }
    
    static class a
    {
        static Cursor a(final ContentResolver contentResolver, final Uri uri, final String[] array, final String s, final String[] array2, final String s2, final Object o) {
            return contentResolver.query(uri, array, s, array2, s2, (CancellationSignal)o);
        }
    }
}
