// 
// Decompiled by Procyon v0.6.0
// 

package t0;

import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.io.File;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import v0.j;
import androidx.room.RoomDatabase;
import java.util.Iterator;
import java.util.ArrayList;
import v0.g;
import v0.b;
import android.os.CancellationSignal;

public class c
{
    public static CancellationSignal a() {
        return b.b();
    }
    
    public static void b(final g g) {
        final ArrayList list = new ArrayList();
        Object z0 = g.Z0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            while (((Cursor)z0).moveToNext()) {
                list.add(((Cursor)z0).getString(0));
            }
            ((Cursor)z0).close();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                z0 = iterator.next();
                if (((String)z0).startsWith("room_fts_content_sync_")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("DROP TRIGGER IF EXISTS ");
                    sb.append((String)z0);
                    g.z(sb.toString());
                }
            }
        }
        finally {
            ((Cursor)z0).close();
        }
    }
    
    public static Cursor c(final RoomDatabase roomDatabase, final j j, final boolean b, final CancellationSignal cancellationSignal) {
        Cursor cursor2;
        final Cursor cursor = cursor2 = roomDatabase.query(j, cancellationSignal);
        if (b) {
            cursor2 = cursor;
            if (cursor instanceof AbstractWindowedCursor) {
                final AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor)cursor;
                final int count = abstractWindowedCursor.getCount();
                int numRows;
                if (abstractWindowedCursor.hasWindow()) {
                    numRows = abstractWindowedCursor.getWindow().getNumRows();
                }
                else {
                    numRows = count;
                }
                cursor2 = cursor;
                if (numRows < count) {
                    cursor2 = b.a((Cursor)abstractWindowedCursor);
                }
            }
        }
        return cursor2;
    }
    
    public static int d(final File file) throws IOException {
        AbstractInterruptibleChannel channel;
        final AbstractInterruptibleChannel abstractInterruptibleChannel = channel = null;
        try {
            final ByteBuffer allocate = ByteBuffer.allocate(4);
            channel = abstractInterruptibleChannel;
            channel = abstractInterruptibleChannel;
            final FileInputStream fileInputStream = new FileInputStream(file);
            channel = abstractInterruptibleChannel;
            final FileChannel fileChannel = (FileChannel)(channel = fileInputStream.getChannel());
            fileChannel.tryLock(60L, 4L, true);
            channel = fileChannel;
            fileChannel.position(60L);
            channel = fileChannel;
            if (fileChannel.read(allocate) == 4) {
                channel = fileChannel;
                allocate.rewind();
                channel = fileChannel;
                final int int1 = allocate.getInt();
                fileChannel.close();
                return int1;
            }
            channel = fileChannel;
            channel = fileChannel;
            final IOException ex = new IOException("Bad database header, unable to read 4 bytes at offset 60");
            channel = fileChannel;
            throw ex;
        }
        finally {
            if (channel != null) {
                channel.close();
            }
        }
    }
}
