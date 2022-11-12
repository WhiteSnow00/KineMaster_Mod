// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import java.io.FileNotFoundException;
import android.os.ParcelFileDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import androidx.core.provider.g;
import java.nio.MappedByteBuffer;
import android.content.ContentResolver;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Process;
import android.content.Context;
import android.os.StrictMode$ThreadPolicy;
import android.util.Log;
import java.io.FileOutputStream;
import android.os.StrictMode;
import java.io.InputStream;
import android.content.res.Resources;
import java.io.File;
import java.io.IOException;
import java.io.Closeable;

public class n
{
    public static void a(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (final IOException ex) {}
    }
    
    public static boolean b(final File file, final Resources resources, final int n) {
        Closeable closeable;
        try {
            final InputStream openRawResource = resources.openRawResource(n);
            try {
                final boolean c = c(file, openRawResource);
                a(openRawResource);
                return c;
            }
            finally {}
        }
        finally {
            closeable = null;
        }
        a(closeable);
    }
    
    public static boolean c(final File file, final InputStream ex) {
        final StrictMode$ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        final Closeable closeable = null;
        Closeable closeable2 = null;
        Closeable closeable3;
        try {
            try {
                closeable2 = closeable2;
                final FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    final byte[] array = new byte[1024];
                    while (true) {
                        final int read = ((InputStream)ex).read(array);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(array, 0, read);
                    }
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
                catch (final IOException ex) {}
                finally {
                    closeable2 = fileOutputStream;
                }
            }
            finally {}
        }
        catch (final IOException ex) {
            closeable3 = closeable;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Error copying resource contents to temp file: ");
        sb.append(ex.getMessage());
        Log.e("TypefaceCompatUtil", sb.toString());
        a(closeable3);
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
        return false;
        a(closeable2);
        StrictMode.setThreadPolicy(allowThreadDiskWrites);
    }
    
    public static File d(Context cacheDir) {
        cacheDir = (Context)cacheDir.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(".font");
        sb.append(Process.myPid());
        sb.append("-");
        sb.append(Process.myTid());
        sb.append("-");
        final String string = sb.toString();
        int n = 0;
    Label_0120_Outer:
        while (true) {
            Label_0126: {
                if (n >= 100) {
                    break Label_0126;
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(n);
                final File file = new File((File)cacheDir, sb2.toString());
                while (true) {
                    try {
                        if (file.createNewFile()) {
                            return file;
                        }
                        ++n;
                        continue Label_0120_Outer;
                        return null;
                    }
                    catch (final IOException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    public static ByteBuffer e(Context a, CancellationSignal cancellationSignal, final Uri uri) {
        final ContentResolver contentResolver = a.getContentResolver();
        try {
            a = (Context)n.a.a(contentResolver, uri, "r", cancellationSignal);
            if (a == null) {
                if (a != null) {
                    ((ParcelFileDescriptor)a).close();
                }
                return null;
            }
            try {
                cancellationSignal = (CancellationSignal)new FileInputStream(((ParcelFileDescriptor)a).getFileDescriptor());
                try {
                    final FileChannel channel = ((FileInputStream)cancellationSignal).getChannel();
                    final MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    ((FileInputStream)cancellationSignal).close();
                    ((ParcelFileDescriptor)a).close();
                    return map;
                }
                finally {
                    try {
                        ((FileInputStream)cancellationSignal).close();
                    }
                    finally {
                        final Throwable t;
                        ((Throwable)uri).addSuppressed(t);
                    }
                }
            }
            finally {
                try {
                    ((ParcelFileDescriptor)a).close();
                }
                finally {
                    final Throwable t2;
                    ((Throwable)cancellationSignal).addSuppressed(t2);
                }
            }
        }
        catch (final IOException ex) {
            return null;
        }
    }
    
    public static Map<Uri, ByteBuffer> f(final Context context, final g.b[] array, final CancellationSignal cancellationSignal) {
        final HashMap hashMap = new HashMap();
        for (final g.b b : array) {
            if (b.b() == 0) {
                final Uri d = b.d();
                if (!hashMap.containsKey(d)) {
                    hashMap.put(d, e(context, cancellationSignal, d));
                }
            }
        }
        return (Map<Uri, ByteBuffer>)Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
    
    static class a
    {
        static ParcelFileDescriptor a(final ContentResolver contentResolver, final Uri uri, final String s, final CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, s, cancellationSignal);
        }
    }
}
