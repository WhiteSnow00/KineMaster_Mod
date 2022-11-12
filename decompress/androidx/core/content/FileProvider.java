// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.content;

import android.text.TextUtils;
import java.util.Iterator;
import android.net.Uri$Builder;
import java.util.Map;
import android.database.MatrixCursor;
import android.database.Cursor;
import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import android.content.ContentValues;
import android.webkit.MimeTypeMap;
import android.os.Environment;
import android.net.Uri;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.os.Bundle;
import android.content.res.XmlResourceParser;
import android.content.pm.ProviderInfo;
import android.content.Context;
import java.util.HashMap;
import java.io.File;
import android.content.ContentProvider;

public class FileProvider extends ContentProvider
{
    private static final String[] c;
    private static final File d;
    private static final HashMap<String, b> e;
    private b a;
    private int b;
    
    static {
        c = new String[] { "_display_name", "_size" };
        d = new File("/");
        e = new HashMap<String, b>();
    }
    
    public FileProvider() {
        this.b = 0;
    }
    
    private static File a(final File file, final String... array) {
        final int length = array.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            final String s = array[i];
            File file3 = file2;
            if (s != null) {
                file3 = new File(file2, s);
            }
            ++i;
            file2 = file3;
        }
        return file2;
    }
    
    private static Object[] b(final Object[] array, final int n) {
        final Object[] array2 = new Object[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    private static String[] c(final String[] array, final int n) {
        final String[] array2 = new String[n];
        System.arraycopy(array, 0, array2, 0, n);
        return array2;
    }
    
    static XmlResourceParser d(final Context context, final String s, final ProviderInfo providerInfo, final int n) {
        if (providerInfo == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Couldn't find meta-data for provider with authority ");
            sb.append(s);
            throw new IllegalArgumentException(sb.toString());
        }
        if (providerInfo.metaData == null && n != 0) {
            (providerInfo.metaData = new Bundle(1)).putInt("android.support.FILE_PROVIDER_PATHS", n);
        }
        final XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    
    private static b e(final Context context, final String s, final int n) {
        final HashMap<String, b> e = FileProvider.e;
        synchronized (e) {
            b h;
            if ((h = e.get(s)) == null) {
                try {
                    h = h(context, s, n);
                    e.put(s, h);
                }
                catch (final XmlPullParserException ex) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", (Throwable)ex);
                }
                catch (final IOException ex2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ex2);
                }
            }
            return h;
        }
    }
    
    public static Uri f(final Context context, final String s, final File file) {
        return e(context, s, 0).a(file);
    }
    
    private static int g(final String s) {
        int n;
        if ("r".equals(s)) {
            n = 268435456;
        }
        else if (!"w".equals(s) && !"wt".equals(s)) {
            if ("wa".equals(s)) {
                n = 704643072;
            }
            else if ("rw".equals(s)) {
                n = 939524096;
            }
            else {
                if (!"rwt".equals(s)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid mode: ");
                    sb.append(s);
                    throw new IllegalArgumentException(sb.toString());
                }
                n = 1006632960;
            }
        }
        else {
            n = 738197504;
        }
        return n;
    }
    
    private static b h(final Context context, final String s, int next) throws IOException, XmlPullParserException {
        final c c = new c(s);
        final XmlResourceParser d = d(context, s, context.getPackageManager().resolveContentProvider(s, 128), next);
        while (true) {
            next = d.next();
            if (next == 1) {
                break;
            }
            if (next != 2) {
                continue;
            }
            final String name = d.getName();
            final File file = null;
            final String attributeValue = d.getAttributeValue((String)null, "name");
            final String attributeValue2 = d.getAttributeValue((String)null, "path");
            File file2;
            if ("root-path".equals(name)) {
                file2 = FileProvider.d;
            }
            else if ("files-path".equals(name)) {
                file2 = context.getFilesDir();
            }
            else if ("cache-path".equals(name)) {
                file2 = context.getCacheDir();
            }
            else if ("external-path".equals(name)) {
                file2 = Environment.getExternalStorageDirectory();
            }
            else if ("external-files-path".equals(name)) {
                final File[] externalFilesDirs = androidx.core.content.a.getExternalFilesDirs(context, null);
                file2 = file;
                if (externalFilesDirs.length > 0) {
                    file2 = externalFilesDirs[0];
                }
            }
            else if ("external-cache-path".equals(name)) {
                final File[] externalCacheDirs = androidx.core.content.a.getExternalCacheDirs(context);
                file2 = file;
                if (externalCacheDirs.length > 0) {
                    file2 = externalCacheDirs[0];
                }
            }
            else {
                file2 = file;
                if ("external-media-path".equals(name)) {
                    final File[] a = FileProvider.a.a(context);
                    file2 = file;
                    if (a.length > 0) {
                        file2 = a[0];
                    }
                }
            }
            if (file2 == null) {
                continue;
            }
            c.c(attributeValue, a(file2, attributeValue2));
        }
        return (b)c;
    }
    
    public void attachInfo(final Context context, ProviderInfo e) {
        super.attachInfo(context, e);
        if (!e.exported) {
            if (e.grantUriPermissions) {
                final String s = e.authority.split(";")[0];
                e = (ProviderInfo)FileProvider.e;
                synchronized (e) {
                    ((HashMap<Object, Object>)e).remove(s);
                    monitorexit(e);
                    this.a = e(context, s, this.b);
                    return;
                }
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return this.a.b(uri).delete() ? 1 : 0;
    }
    
    public String getType(final Uri uri) {
        final File b = this.a.b(uri);
        final int lastIndex = b.getName().lastIndexOf(46);
        if (lastIndex >= 0) {
            final String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(b.getName().substring(lastIndex + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }
    
    public boolean onCreate() {
        return true;
    }
    
    public ParcelFileDescriptor openFile(final Uri uri, final String s) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.a.b(uri), g(s));
    }
    
    public Cursor query(final Uri uri, final String[] array, String queryParameter, final String[] array2, final String s) {
        final File b = this.a.b(uri);
        queryParameter = uri.getQueryParameter("displayName");
        String[] c = array;
        if (array == null) {
            c = FileProvider.c;
        }
        final String[] array3 = new String[c.length];
        final Object[] array4 = new Object[c.length];
        final int length = c.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final String s2 = c[i];
            int n4 = 0;
            Label_0163: {
                int n3;
                if ("_display_name".equals(s2)) {
                    array3[n] = "_display_name";
                    final int n2 = n + 1;
                    String name;
                    if (queryParameter == null) {
                        name = b.getName();
                    }
                    else {
                        name = queryParameter;
                    }
                    array4[n] = name;
                    n3 = n2;
                }
                else {
                    n4 = n;
                    if (!"_size".equals(s2)) {
                        break Label_0163;
                    }
                    array3[n] = "_size";
                    final int n5 = n + 1;
                    array4[n] = b.length();
                    n3 = n5;
                }
                n4 = n3;
            }
            ++i;
            n = n4;
        }
        final String[] c2 = c(array3, n);
        final Object[] b2 = b(array4, n);
        final MatrixCursor matrixCursor = new MatrixCursor(c2, 1);
        matrixCursor.addRow(b2);
        return (Cursor)matrixCursor;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        throw new UnsupportedOperationException("No external updates");
    }
    
    static class a
    {
        static File[] a(final Context context) {
            return context.getExternalMediaDirs();
        }
    }
    
    interface b
    {
        Uri a(final File p0);
        
        File b(final Uri p0);
    }
    
    static class c implements b
    {
        private final String a;
        private final HashMap<String, File> b;
        
        c(final String a) {
            this.b = new HashMap<String, File>();
            this.a = a;
        }
        
        @Override
        public Uri a(File string) {
            try {
                final String canonicalPath = string.getCanonicalPath();
                string = null;
                for (final Map.Entry<?, File> entry : this.b.entrySet()) {
                    final String path = entry.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (string == null || path.length() > ((Map.Entry<K, File>)string).getValue().getPath().length())) {
                        string = (File)entry;
                    }
                }
                if (string != null) {
                    final String path2 = ((Map.Entry<K, File>)string).getValue().getPath();
                    String s;
                    if (path2.endsWith("/")) {
                        s = canonicalPath.substring(path2.length());
                    }
                    else {
                        s = canonicalPath.substring(path2.length() + 1);
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append(Uri.encode((String)((Map.Entry<String, V>)string).getKey()));
                    sb.append('/');
                    sb.append(Uri.encode(s, "/"));
                    string = (File)sb.toString();
                    return new Uri$Builder().scheme("content").authority(this.a).encodedPath((String)string).build();
                }
                string = (File)new StringBuilder();
                ((StringBuilder)string).append("Failed to find configured root that contains ");
                ((StringBuilder)string).append(canonicalPath);
                throw new IllegalArgumentException(((StringBuilder)string).toString());
            }
            catch (final IOException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to resolve canonical path for ");
                sb2.append(string);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        
        @Override
        public File b(Uri uri) {
            final String encodedPath = uri.getEncodedPath();
            final int index = encodedPath.indexOf(47, 1);
            final String decode = Uri.decode(encodedPath.substring(1, index));
            final String decode2 = Uri.decode(encodedPath.substring(index + 1));
            final File file = this.b.get(decode);
            if (file != null) {
                uri = (Uri)new File(file, decode2);
                try {
                    final File canonicalFile = ((File)uri).getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                }
                catch (final IOException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(uri);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to find configured root for ");
            sb2.append(uri);
            throw new IllegalArgumentException(sb2.toString());
        }
        
        void c(final String s, final File file) {
            if (!TextUtils.isEmpty((CharSequence)s)) {
                try {
                    this.b.put(s, file.getCanonicalFile());
                    return;
                }
                catch (final IOException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to resolve canonical path for ");
                    sb.append(file);
                    throw new IllegalArgumentException(sb.toString(), ex);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }
    }
}
