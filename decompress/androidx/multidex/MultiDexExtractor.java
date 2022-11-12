// 
// Decompiled by Procyon v0.6.0
// 

package androidx.multidex;

import java.io.InputStream;
import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import java.util.ArrayList;
import java.util.List;
import android.content.SharedPreferences;
import android.content.Context;
import java.io.FileNotFoundException;
import java.util.zip.ZipOutputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.io.FileFilter;
import java.io.IOException;
import android.util.Log;
import java.nio.channels.FileLock;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;
import java.io.File;
import java.io.Closeable;

final class MultiDexExtractor implements Closeable
{
    private final File a;
    private final long b;
    private final File c;
    private final RandomAccessFile d;
    private final FileChannel e;
    private final FileLock f;
    
    MultiDexExtractor(File a, final File c) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(((File)a).getPath());
        sb.append(", ");
        sb.append(c.getPath());
        sb.append(")");
        Log.i("MultiDex", sb.toString());
        this.a = (File)a;
        this.c = c;
        this.b = i((File)a);
        a = (Error)new File(c, "MultiDex.lock");
        final RandomAccessFile d = new RandomAccessFile((File)a, "rw");
        this.d = d;
        try {
            final FileChannel channel = d.getChannel();
            this.e = channel;
            try {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Blocking on lock ");
                sb2.append(((File)a).getPath());
                Log.i("MultiDex", sb2.toString());
                this.f = channel.lock();
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(((File)a).getPath());
                sb3.append(" locked");
                Log.i("MultiDex", sb3.toString());
                return;
            }
            catch (final Error a) {}
            catch (final RuntimeException a) {}
            catch (final IOException ex) {}
            c(this.e);
            throw a;
        }
        catch (final Error a) {}
        catch (final RuntimeException a) {}
        catch (final IOException ex2) {}
        c(this.d);
        throw a;
    }
    
    private void a() {
        final File[] listFiles = this.c.listFiles(new FileFilter(this) {
            final MultiDexExtractor a;
            
            @Override
            public boolean accept(final File file) {
                return file.getName().equals("MultiDex.lock") ^ true;
            }
        });
        if (listFiles == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.c.getPath());
            sb.append(").");
            Log.w("MultiDex", sb.toString());
            return;
        }
        for (final File file : listFiles) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            Log.i("MultiDex", sb2.toString());
            if (!file.delete()) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to delete old file ");
                sb3.append(file.getPath());
                Log.w("MultiDex", sb3.toString());
            }
            else {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Deleted old file ");
                sb4.append(file.getPath());
                Log.i("MultiDex", sb4.toString());
            }
        }
    }
    
    private static void c(final Closeable closeable) {
        try {
            closeable.close();
        }
        catch (final IOException ex) {
            Log.w("MultiDex", "Failed to close resource", (Throwable)ex);
        }
    }
    
    private static void d(ZipFile inputStream, final ZipEntry zipEntry, final File file, String tempFile) throws IOException, FileNotFoundException {
        inputStream = (ZipFile)inputStream.getInputStream(zipEntry);
        final StringBuilder sb = new StringBuilder();
        sb.append("tmp-");
        sb.append(tempFile);
        tempFile = (String)File.createTempFile(sb.toString(), ".zip", file.getParentFile());
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Extracting ");
        sb2.append(((File)tempFile).getPath());
        Log.i("MultiDex", sb2.toString());
        try {
            Object o = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream((File)tempFile)));
            try {
                final ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                ((ZipOutputStream)o).putNextEntry(zipEntry2);
                final byte[] array = new byte[16384];
                for (int i = ((InputStream)inputStream).read(array); i != -1; i = ((InputStream)inputStream).read(array)) {
                    ((ZipOutputStream)o).write(array, 0, i);
                }
                ((ZipOutputStream)o).closeEntry();
                ((ZipOutputStream)o).close();
                if (!((File)tempFile).setReadOnly()) {
                    o = new StringBuilder();
                    ((StringBuilder)o).append("Failed to mark readonly \"");
                    ((StringBuilder)o).append(((File)tempFile).getAbsolutePath());
                    ((StringBuilder)o).append("\" (tmp of \"");
                    ((StringBuilder)o).append(file.getAbsolutePath());
                    ((StringBuilder)o).append("\")");
                    throw new IOException(((StringBuilder)o).toString());
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Renaming to ");
                sb3.append(file.getPath());
                Log.i("MultiDex", sb3.toString());
                if (((File)tempFile).renameTo(file)) {
                    return;
                }
                o = new(java.io.IOException.class)();
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to rename \"");
                sb4.append(((File)tempFile).getAbsolutePath());
                sb4.append("\" to \"");
                sb4.append(file.getAbsolutePath());
                sb4.append("\"");
                new IOException(sb4.toString());
                throw o;
            }
            finally {
                ((ZipOutputStream)o).close();
            }
        }
        finally {
            c(inputStream);
            ((File)tempFile).delete();
        }
    }
    
    private static SharedPreferences e(final Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }
    
    private static long h(final File file) {
        long lastModified;
        final long n = lastModified = file.lastModified();
        if (n == -1L) {
            lastModified = n - 1L;
        }
        return lastModified;
    }
    
    private static long i(final File file) throws IOException {
        long c;
        final long n = c = b.c(file);
        if (n == -1L) {
            c = n - 1L;
        }
        return c;
    }
    
    private static boolean j(final Context context, final File file, final long n, final String s) {
        final SharedPreferences e = e(context);
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("timestamp");
        if (e.getLong(sb.toString(), -1L) == h(file)) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append("crc");
            if (e.getLong(sb2.toString(), -1L) == n) {
                return false;
            }
        }
        return true;
    }
    
    private List<ExtractedDex> l(final Context context, final String s) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a.getName());
        sb.append(".classes");
        final String string = sb.toString();
        final SharedPreferences e = e(context);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("dex.number");
        final int int1 = e.getInt(sb2.toString(), 1);
        final ArrayList list = new ArrayList(int1 - 1);
        int i = 2;
        final String s2 = string;
        while (i <= int1) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(s2);
            sb3.append(i);
            sb3.append(".zip");
            final ExtractedDex extractedDex = new ExtractedDex(this.c, sb3.toString());
            if (!extractedDex.isFile()) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Missing extracted secondary dex file '");
                sb4.append(extractedDex.getPath());
                sb4.append("'");
                throw new IOException(sb4.toString());
            }
            extractedDex.crc = i(extractedDex);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(s);
            sb5.append("dex.crc.");
            sb5.append(i);
            final long long1 = e.getLong(sb5.toString(), -1L);
            final StringBuilder sb6 = new StringBuilder();
            sb6.append(s);
            sb6.append("dex.time.");
            sb6.append(i);
            final long long2 = e.getLong(sb6.toString(), -1L);
            final long lastModified = extractedDex.lastModified();
            if (long2 != lastModified || long1 != extractedDex.crc) {
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("Invalid extracted dex: ");
                sb7.append(extractedDex);
                sb7.append(" (key \"");
                sb7.append(s);
                sb7.append("\"), expected modification time: ");
                sb7.append(long2);
                sb7.append(", modification time: ");
                sb7.append(lastModified);
                sb7.append(", expected crc: ");
                sb7.append(long1);
                sb7.append(", file crc: ");
                sb7.append(extractedDex.crc);
                throw new IOException(sb7.toString());
            }
            list.add((Object)extractedDex);
            ++i;
        }
        return (List<ExtractedDex>)list;
    }
    
    private List<ExtractedDex> r() throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a.getName());
        sb.append(".classes");
        final String string = sb.toString();
        this.a();
        final ArrayList list = new ArrayList();
        final ZipFile zipFile = new ZipFile(this.a);
        try {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("classes");
            sb2.append(2);
            sb2.append(".dex");
            ZipEntry zipEntry = zipFile.getEntry(sb2.toString());
            int n = 2;
            while (zipEntry != null) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append(n);
                sb3.append(".zip");
                final ExtractedDex extractedDex = new ExtractedDex(this.c, sb3.toString());
                list.add(extractedDex);
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Extraction is needed for file ");
                sb4.append(extractedDex);
                Log.i("MultiDex", sb4.toString());
                int n2;
                int n3;
                for (n2 = 0, n3 = 0; n2 < 3 && n3 == 0; ++n2) {
                    d(zipFile, zipEntry, extractedDex, string);
                    try {
                        extractedDex.crc = i(extractedDex);
                        n3 = 1;
                    }
                    catch (final IOException ex) {
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("Failed to read crc from ");
                        sb5.append(extractedDex.getAbsolutePath());
                        Log.w("MultiDex", sb5.toString(), (Throwable)ex);
                        n3 = 0;
                    }
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("Extraction ");
                    String s;
                    if (n3 != 0) {
                        s = "succeeded";
                    }
                    else {
                        s = "failed";
                    }
                    sb6.append(s);
                    sb6.append(" '");
                    sb6.append(extractedDex.getAbsolutePath());
                    sb6.append("': length ");
                    sb6.append(extractedDex.length());
                    sb6.append(" - crc: ");
                    sb6.append(extractedDex.crc);
                    Log.i("MultiDex", sb6.toString());
                    if (n3 == 0) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            final StringBuilder sb7 = new StringBuilder();
                            sb7.append("Failed to delete corrupted secondary dex '");
                            sb7.append(extractedDex.getPath());
                            sb7.append("'");
                            Log.w("MultiDex", sb7.toString());
                        }
                    }
                }
                if (n3 == 0) {
                    final StringBuilder sb8 = new StringBuilder();
                    sb8.append("Could not create zip file ");
                    sb8.append(extractedDex.getAbsolutePath());
                    sb8.append(" for secondary dex (");
                    sb8.append(n);
                    sb8.append(")");
                    throw new IOException(sb8.toString());
                }
                ++n;
                final StringBuilder sb9 = new StringBuilder();
                sb9.append("classes");
                sb9.append(n);
                sb9.append(".dex");
                zipEntry = zipFile.getEntry(sb9.toString());
            }
            return list;
        }
        finally {
            try {
                zipFile.close();
            }
            catch (final IOException ex2) {
                Log.w("MultiDex", "Failed to close resource", (Throwable)ex2);
            }
        }
    }
    
    private static void s(final Context context, final String s, final long n, final long n2, final List<ExtractedDex> list) {
        final SharedPreferences$Editor edit = e(context).edit();
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("timestamp");
        edit.putLong(sb.toString(), n);
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("crc");
        edit.putLong(sb2.toString(), n2);
        final StringBuilder sb3 = new StringBuilder();
        sb3.append(s);
        sb3.append("dex.number");
        edit.putInt(sb3.toString(), list.size() + 1);
        final Iterator iterator = list.iterator();
        int n3 = 2;
        while (iterator.hasNext()) {
            final ExtractedDex extractedDex = (ExtractedDex)iterator.next();
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(s);
            sb4.append("dex.crc.");
            sb4.append(n3);
            edit.putLong(sb4.toString(), extractedDex.crc);
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(s);
            sb5.append("dex.time.");
            sb5.append(n3);
            edit.putLong(sb5.toString(), extractedDex.lastModified());
            ++n3;
        }
        edit.commit();
    }
    
    @Override
    public void close() throws IOException {
        this.f.release();
        this.e.close();
        this.d.close();
    }
    
    List<? extends File> k(Context l, final String s, final boolean b) throws IOException {
        final StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.a.getPath());
        sb.append(", ");
        sb.append(b);
        sb.append(", ");
        sb.append(s);
        sb.append(")");
        Log.i("MultiDex", sb.toString());
        if (this.f.isValid()) {
            if (!b && !j(l, this.a, this.b, s)) {
                try {
                    l = (Context)this.l(l, s);
                }
                catch (final IOException ex) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", (Throwable)ex);
                    final Object r = this.r();
                    s(l, s, h(this.a), this.b, (List<ExtractedDex>)r);
                    l = (Context)r;
                }
            }
            else {
                if (b) {
                    Log.i("MultiDex", "Forced extraction must be performed.");
                }
                else {
                    Log.i("MultiDex", "Detected that extraction must be performed.");
                }
                final Object r2 = this.r();
                s(l, s, h(this.a), this.b, (List<ExtractedDex>)r2);
                l = (Context)r2;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("load found ");
            sb2.append(((List)l).size());
            sb2.append(" secondary dex files");
            Log.i("MultiDex", sb2.toString());
            return (List<? extends File>)l;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
    
    private static class ExtractedDex extends File
    {
        public long crc;
        
        public ExtractedDex(final File file, final String s) {
            super(file, s);
            this.crc = -1L;
        }
    }
}
