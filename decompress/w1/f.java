// 
// Decompiled by Procyon v0.6.0
// 

package w1;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import android.util.Pair;
import java.io.FileNotFoundException;
import java.io.File;
import com.airbnb.lottie.network.FileExtension;

public class f
{
    private final d a;
    
    public f(final d a) {
        this.a = a;
    }
    
    private static String b(String s, final FileExtension fileExtension, final boolean b) {
        final StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(s.replaceAll("\\W+", ""));
        if (b) {
            s = fileExtension.tempExtension();
        }
        else {
            s = fileExtension.extension;
        }
        sb.append(s);
        return sb.toString();
    }
    
    private File c(final String s) throws FileNotFoundException {
        final File file = new File(this.d(), b(s, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        final File file2 = new File(this.d(), b(s, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }
    
    private File d() {
        final File a = this.a.a();
        if (a.isFile()) {
            a.delete();
        }
        if (!a.exists()) {
            a.mkdirs();
        }
        return a;
    }
    
    Pair<FileExtension, InputStream> a(final String s) {
        try {
            final File c = this.c(s);
            if (c == null) {
                return null;
            }
            final FileInputStream fileInputStream = new FileInputStream(c);
            FileExtension fileExtension;
            if (c.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            }
            else {
                fileExtension = FileExtension.JSON;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Cache hit for ");
            sb.append(s);
            sb.append(" at ");
            sb.append(c.getAbsolutePath());
            y1.d.a(sb.toString());
            return (Pair<FileExtension, InputStream>)new Pair((Object)fileExtension, (Object)fileInputStream);
        }
        catch (final FileNotFoundException ex) {
            return null;
        }
    }
    
    void e(String b, final FileExtension fileExtension) {
        b = b(b, fileExtension, true);
        final File file = new File(this.d(), b);
        final File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        final boolean renameTo = file.renameTo(file2);
        final StringBuilder sb = new StringBuilder();
        sb.append("Copying temp file to real file (");
        sb.append(file2);
        sb.append(")");
        y1.d.a(sb.toString());
        if (!renameTo) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to rename cache file ");
            sb2.append(file.getAbsolutePath());
            sb2.append(" to ");
            sb2.append(file2.getAbsolutePath());
            sb2.append(".");
            y1.d.c(sb2.toString());
        }
    }
    
    File f(String b, final InputStream inputStream, final FileExtension fileExtension) throws IOException {
        b = b((String)b, fileExtension, true);
        final File file = new File(this.d(), (String)b);
        try {
            b = new FileOutputStream(file);
            try {
                final byte[] array = new byte[1024];
                while (true) {
                    final int read = inputStream.read(array);
                    if (read == -1) {
                        break;
                    }
                    ((OutputStream)b).write(array, 0, read);
                }
                ((OutputStream)b).flush();
                return file;
            }
            finally {
                ((OutputStream)b).close();
            }
        }
        finally {
            inputStream.close();
        }
    }
}
