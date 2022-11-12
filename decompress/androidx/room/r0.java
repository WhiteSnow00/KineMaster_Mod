// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

public class r0
{
    public static String a(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
        sb.append(s);
        sb.append("')");
        return sb.toString();
    }
}
