// 
// Decompiled by Procyon v0.6.0
// 

package n0;

import android.content.pm.ActivityInfo;
import java.util.List;
import android.util.Log;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.ComponentName;
import android.content.Context;
import android.content.BroadcastReceiver;

public class a extends BroadcastReceiver
{
    public static ComponentName a(final Context context) {
        final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        final List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            final ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        }
        if (queryBroadcastReceivers.size() > 1) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        }
        return null;
    }
}
