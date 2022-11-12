// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

public class PlayerNotificationManager
{
    public final class BitmapCallback
    {
    }
    
    public static class Builder
    {
    }
    
    public interface CustomActionReceiver
    {
    }
    
    public interface MediaDescriptionAdapter
    {
    }
    
    public interface NotificationListener
    {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Priority {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Visibility {
    }
}
