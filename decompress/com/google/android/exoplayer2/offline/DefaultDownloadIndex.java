// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.offline;

public final class DefaultDownloadIndex implements WritableDownloadIndex
{
    private static final String a;
    private static final String[] b;
    
    static {
        a = a(3, 4);
        b = new String[] { "id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id" };
    }
    
    private static String a(final int... array) {
        if (array.length == 0) {
            return "1";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("state");
        sb.append(" IN (");
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(array[i]);
        }
        sb.append(')');
        return sb.toString();
    }
}
