// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media.session;

import android.media.MediaMetadataEditor;
import android.media.session.MediaSession$Token;
import android.media.MediaDescription;
import android.os.Parcel;
import android.media.session.MediaSession$QueueItem;
import android.os.Parcelable$Creator;
import android.media.AudioAttributes$Builder;
import android.media.session.PlaybackState;
import android.media.MediaMetadata;
import java.lang.reflect.Field;
import android.media.session.MediaSession;
import android.media.RemoteControlClient$OnMetadataUpdateListener;
import android.os.Parcelable;
import android.os.IInterface;
import android.os.Binder;
import android.graphics.Bitmap;
import android.media.RemoteControlClient$MetadataEditor;
import android.os.RemoteException;
import java.util.Objects;
import android.os.RemoteCallbackList;
import android.media.RemoteControlClient;
import android.media.AudioManager;
import android.media.RemoteControlClient$OnPlaybackPositionUpdateListener;
import android.media.Rating;
import android.os.IBinder;
import androidx.core.app.f;
import android.os.Message;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import android.view.ViewConfiguration;
import android.view.KeyEvent;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.lang.ref.WeakReference;
import android.media.session.MediaSession$Callback;
import java.util.HashSet;
import java.util.List;
import m0.g;
import java.util.Iterator;
import android.os.BadParcelableException;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.util.TypedValue;
import android.os.Handler;
import android.os.Looper;
import android.os.Build$VERSION;
import android.content.Intent;
import android.util.Log;
import android.text.TextUtils;
import b1.b;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import androidx.core.os.a;
import java.util.ArrayList;

public class MediaSessionCompat
{
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_PLAYBACK_SPEED = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_PLAYBACK_SPEED = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    @Deprecated
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    @Deprecated
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION2_TOKEN = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    public static final int PENDING_INTENT_FLAG_MUTABLE;
    static int d;
    private final MediaSessionImpl a;
    private final MediaControllerCompat b;
    private final ArrayList<OnActiveChangeListener> c;
    
    static {
        int pending_INTENT_FLAG_MUTABLE;
        if (a.c()) {
            pending_INTENT_FLAG_MUTABLE = 33554432;
        }
        else {
            pending_INTENT_FLAG_MUTABLE = 0;
        }
        PENDING_INTENT_FLAG_MUTABLE = pending_INTENT_FLAG_MUTABLE;
    }
    
    private MediaSessionCompat(final Context context, final MediaSessionImpl a) {
        this.c = new ArrayList<OnActiveChangeListener>();
        this.a = a;
        this.b = new MediaControllerCompat(context, this);
    }
    
    public MediaSessionCompat(final Context context, final String s) {
        this(context, s, null, null);
    }
    
    public MediaSessionCompat(final Context context, final String s, final ComponentName componentName, final PendingIntent pendingIntent) {
        this(context, s, componentName, pendingIntent, null);
    }
    
    public MediaSessionCompat(final Context context, final String s, final ComponentName componentName, final PendingIntent pendingIntent, final Bundle bundle) {
        this(context, s, componentName, pendingIntent, bundle, null);
    }
    
    public MediaSessionCompat(final Context context, final String s, ComponentName a, final PendingIntent pendingIntent, final Bundle bundle, final b b) {
        this.c = new ArrayList<OnActiveChangeListener>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (!TextUtils.isEmpty((CharSequence)s)) {
            ComponentName component;
            if ((component = a) == null) {
                a = n0.a.a(context);
                if ((component = a) == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                    component = a;
                }
            }
            PendingIntent broadcast = pendingIntent;
            if (component != null && (broadcast = pendingIntent) == null) {
                final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(component);
                broadcast = PendingIntent.getBroadcast(context, 0, intent, MediaSessionCompat.PENDING_INTENT_FLAG_MUTABLE);
            }
            final int sdk_INT = Build$VERSION.SDK_INT;
            if (sdk_INT >= 29) {
                this.a = (MediaSessionImpl)new MediaSessionImplApi29(context, s, b, bundle);
            }
            else if (sdk_INT >= 28) {
                this.a = (MediaSessionImpl)new MediaSessionImplApi28(context, s, b, bundle);
            }
            else {
                this.a = (MediaSessionImpl)new MediaSessionImplApi22(context, s, b, bundle);
            }
            Looper looper;
            if (Looper.myLooper() != null) {
                looper = Looper.myLooper();
            }
            else {
                looper = Looper.getMainLooper();
            }
            this.setCallback((Callback)new Callback(this) {
                final MediaSessionCompat f;
            }, new Handler(looper));
            this.a.setMediaButtonReceiver(broadcast);
            this.b = new MediaControllerCompat(context, this);
            if (MediaSessionCompat.d == 0) {
                MediaSessionCompat.d = (int)(TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
            return;
        }
        throw new IllegalArgumentException("tag must not be null or empty");
    }
    
    static PlaybackStateCompat a(final PlaybackStateCompat playbackStateCompat, final MediaMetadataCompat mediaMetadataCompat) {
        PlaybackStateCompat build = playbackStateCompat;
        if (playbackStateCompat != null) {
            final long position = playbackStateCompat.getPosition();
            final long n = -1L;
            if (position == -1L) {
                build = playbackStateCompat;
            }
            else {
                if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4) {
                    build = playbackStateCompat;
                    if (playbackStateCompat.getState() != 5) {
                        return build;
                    }
                }
                final long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
                build = playbackStateCompat;
                if (lastPositionUpdateTime > 0L) {
                    final long elapsedRealtime = SystemClock.elapsedRealtime();
                    final long n2 = (long)(playbackStateCompat.getPlaybackSpeed() * (elapsedRealtime - lastPositionUpdateTime)) + playbackStateCompat.getPosition();
                    long long1 = n;
                    if (mediaMetadataCompat != null) {
                        long1 = n;
                        if (mediaMetadataCompat.containsKey("android.media.metadata.DURATION")) {
                            long1 = mediaMetadataCompat.getLong("android.media.metadata.DURATION");
                        }
                    }
                    if (long1 < 0L || n2 <= long1) {
                        if (n2 < 0L) {
                            long1 = 0L;
                        }
                        else {
                            long1 = n2;
                        }
                    }
                    build = new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), long1, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
                }
            }
        }
        return build;
    }
    
    public static void ensureClassLoader(final Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
    
    public static MediaSessionCompat fromMediaSession(final Context context, final Object o) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (context != null && o != null) {
            MediaSessionImpl mediaSessionImpl;
            if (sdk_INT >= 29) {
                mediaSessionImpl = new MediaSessionImplApi29(o);
            }
            else if (sdk_INT >= 28) {
                mediaSessionImpl = new MediaSessionImplApi28(o);
            }
            else {
                mediaSessionImpl = new MediaSessionImplApi21(o);
            }
            return new MediaSessionCompat(context, mediaSessionImpl);
        }
        return null;
    }
    
    public static Bundle unparcelWithClassLoader(final Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ensureClassLoader(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        }
        catch (final BadParcelableException ex) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }
    
    public void addOnActiveChangeListener(final OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.c.add(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }
    
    public String getCallingPackage() {
        return this.a.getCallingPackage();
    }
    
    public MediaControllerCompat getController() {
        return this.b;
    }
    
    public final m0.b getCurrentControllerInfo() {
        return this.a.getCurrentControllerInfo();
    }
    
    public Object getMediaSession() {
        return this.a.getMediaSession();
    }
    
    public Object getRemoteControlClient() {
        return this.a.getRemoteControlClient();
    }
    
    public Token getSessionToken() {
        return this.a.getSessionToken();
    }
    
    public boolean isActive() {
        return this.a.isActive();
    }
    
    public void release() {
        this.a.release();
    }
    
    public void removeOnActiveChangeListener(final OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener != null) {
            this.c.remove(onActiveChangeListener);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }
    
    public void sendSessionEvent(final String s, final Bundle bundle) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.a.sendSessionEvent(s, bundle);
            return;
        }
        throw new IllegalArgumentException("event cannot be null or empty");
    }
    
    public void setActive(final boolean active) {
        this.a.setActive(active);
        final Iterator<OnActiveChangeListener> iterator = this.c.iterator();
        while (iterator.hasNext()) {
            iterator.next().onActiveChanged();
        }
    }
    
    public void setCallback(final Callback callback) {
        this.setCallback(callback, null);
    }
    
    public void setCallback(final Callback callback, Handler handler) {
        if (callback == null) {
            this.a.setCallback(null, null);
        }
        else {
            final MediaSessionImpl a = this.a;
            if (handler == null) {
                handler = new Handler();
            }
            a.setCallback(callback, handler);
        }
    }
    
    public void setCaptioningEnabled(final boolean captioningEnabled) {
        this.a.setCaptioningEnabled(captioningEnabled);
    }
    
    public void setExtras(final Bundle extras) {
        this.a.setExtras(extras);
    }
    
    public void setFlags(final int flags) {
        this.a.setFlags(flags);
    }
    
    public void setMediaButtonReceiver(final PendingIntent mediaButtonReceiver) {
        this.a.setMediaButtonReceiver(mediaButtonReceiver);
    }
    
    public void setMetadata(final MediaMetadataCompat metadata) {
        this.a.setMetadata(metadata);
    }
    
    public void setPlaybackState(final PlaybackStateCompat playbackState) {
        this.a.setPlaybackState(playbackState);
    }
    
    public void setPlaybackToLocal(final int playbackToLocal) {
        this.a.setPlaybackToLocal(playbackToLocal);
    }
    
    public void setPlaybackToRemote(final g g) {
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }
    
    public void setQueue(final List<QueueItem> queue) {
        if (queue != null) {
            final HashSet set = new HashSet();
            for (final QueueItem queueItem : queue) {
                if (queueItem == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                if (set.contains(queueItem.getQueueId())) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Found duplicate queue id: ");
                    sb.append(queueItem.getQueueId());
                    Log.e("MediaSessionCompat", sb.toString(), (Throwable)new IllegalArgumentException("id of each queue item should be unique"));
                }
                set.add(queueItem.getQueueId());
            }
        }
        this.a.setQueue(queue);
    }
    
    public void setQueueTitle(final CharSequence queueTitle) {
        this.a.setQueueTitle(queueTitle);
    }
    
    public void setRatingType(final int ratingType) {
        this.a.setRatingType(ratingType);
    }
    
    public void setRepeatMode(final int repeatMode) {
        this.a.setRepeatMode(repeatMode);
    }
    
    public void setSessionActivity(final PendingIntent sessionActivity) {
        this.a.setSessionActivity(sessionActivity);
    }
    
    public void setShuffleMode(final int shuffleMode) {
        this.a.setShuffleMode(shuffleMode);
    }
    
    public abstract static class Callback
    {
        final Object a;
        final MediaSession$Callback b;
        private boolean c;
        WeakReference<MediaSessionImpl> d;
        CallbackHandler e;
        
        public Callback() {
            this.a = new Object();
            this.b = new MediaSessionCallbackApi21();
            this.d = new WeakReference<MediaSessionImpl>(null);
        }
        
        void a(final MediaSessionImpl mediaSessionImpl, final Handler handler) {
            if (!this.c) {
                return;
            }
            boolean b = false;
            this.c = false;
            handler.removeMessages(1);
            final PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
            long actions;
            if (playbackState == null) {
                actions = 0L;
            }
            else {
                actions = playbackState.getActions();
            }
            final boolean b2 = playbackState != null && playbackState.getState() == 3;
            final boolean b3 = (0x204L & actions) != 0x0L;
            if ((actions & 0x202L) != 0x0L) {
                b = true;
            }
            if (b2 && b) {
                this.onPause();
            }
            else if (!b2 && b3) {
                this.onPlay();
            }
        }
        
        void b(final MediaSessionImpl mediaSessionImpl, final Handler handler) {
            synchronized (this.a) {
                this.d = new WeakReference<MediaSessionImpl>(mediaSessionImpl);
                final CallbackHandler e = this.e;
                final CallbackHandler callbackHandler = null;
                if (e != null) {
                    e.removeCallbacksAndMessages((Object)null);
                }
                CallbackHandler e2 = callbackHandler;
                if (mediaSessionImpl != null) {
                    if (handler == null) {
                        e2 = callbackHandler;
                    }
                    else {
                        e2 = new CallbackHandler(handler.getLooper());
                    }
                }
                this.e = e2;
            }
        }
        
        public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        }
        
        public void onAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        }
        
        public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        }
        
        public void onCustomAction(final String s, final Bundle bundle) {
        }
        
        public void onFastForward() {
        }
        
        public boolean onMediaButtonEvent(final Intent intent) {
            if (Build$VERSION.SDK_INT >= 27) {
                return false;
            }
            Object a = this.a;
            synchronized (a) {
                final MediaSessionImpl mediaSessionImpl = this.d.get();
                final CallbackHandler e = this.e;
                monitorexit(a);
                if (mediaSessionImpl != null) {
                    if (e != null) {
                        a = intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                        if (a != null) {
                            if (((KeyEvent)a).getAction() == 0) {
                                final m0.b currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
                                final int keyCode = ((KeyEvent)a).getKeyCode();
                                if (keyCode != 79 && keyCode != 85) {
                                    this.a(mediaSessionImpl, e);
                                    return false;
                                }
                                if (((KeyEvent)a).getRepeatCount() == 0) {
                                    if (this.c) {
                                        e.removeMessages(1);
                                        this.c = false;
                                        final PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                                        long actions;
                                        if (playbackState == null) {
                                            actions = 0L;
                                        }
                                        else {
                                            actions = playbackState.getActions();
                                        }
                                        if ((actions & 0x20L) != 0x0L) {
                                            this.onSkipToNext();
                                        }
                                    }
                                    else {
                                        this.c = true;
                                        e.sendMessageDelayed(e.obtainMessage(1, (Object)currentControllerInfo), (long)ViewConfiguration.getDoubleTapTimeout());
                                    }
                                }
                                else {
                                    this.a(mediaSessionImpl, e);
                                }
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
        
        public void onPause() {
        }
        
        public void onPlay() {
        }
        
        public void onPlayFromMediaId(final String s, final Bundle bundle) {
        }
        
        public void onPlayFromSearch(final String s, final Bundle bundle) {
        }
        
        public void onPlayFromUri(final Uri uri, final Bundle bundle) {
        }
        
        public void onPrepare() {
        }
        
        public void onPrepareFromMediaId(final String s, final Bundle bundle) {
        }
        
        public void onPrepareFromSearch(final String s, final Bundle bundle) {
        }
        
        public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
        }
        
        public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        }
        
        @Deprecated
        public void onRemoveQueueItemAt(final int n) {
        }
        
        public void onRewind() {
        }
        
        public void onSeekTo(final long n) {
        }
        
        public void onSetCaptioningEnabled(final boolean b) {
        }
        
        public void onSetPlaybackSpeed(final float n) {
        }
        
        public void onSetRating(final RatingCompat ratingCompat) {
        }
        
        public void onSetRating(final RatingCompat ratingCompat, final Bundle bundle) {
        }
        
        public void onSetRepeatMode(final int n) {
        }
        
        public void onSetShuffleMode(final int n) {
        }
        
        public void onSkipToNext() {
        }
        
        public void onSkipToPrevious() {
        }
        
        public void onSkipToQueueItem(final long n) {
        }
        
        public void onStop() {
        }
        
        private class CallbackHandler extends Handler
        {
            final Callback a;
            
            CallbackHandler(final Callback a, final Looper looper) {
                this.a = a;
                super(looper);
            }
            
            public void handleMessage(final Message message) {
                if (message.what == 1) {
                    synchronized (this.a.a) {
                        final MediaSessionImpl mediaSessionImpl = this.a.d.get();
                        final Callback a = this.a;
                        final CallbackHandler e = a.e;
                        monitorexit(this.a.a);
                        if (mediaSessionImpl == null || a != mediaSessionImpl.getCallback() || e == null) {
                            return;
                        }
                        mediaSessionImpl.setCurrentControllerInfo((m0.b)message.obj);
                        this.a.a(mediaSessionImpl, e);
                        mediaSessionImpl.setCurrentControllerInfo(null);
                    }
                }
            }
        }
        
        private class MediaSessionCallbackApi21 extends MediaSession$Callback
        {
            final Callback a;
            
            MediaSessionCallbackApi21(final Callback a) {
                this.a = a;
            }
            
            private void a(final MediaSessionImpl mediaSessionImpl) {
                mediaSessionImpl.setCurrentControllerInfo(null);
            }
            
            private MediaSessionImplApi21 b() {
                synchronized (this.a.a) {
                    MediaSessionImpl mediaSessionImpl = this.a.d.get();
                    monitorexit(this.a.a);
                    if (mediaSessionImpl == null || this.a != ((MediaSessionImplApi21)mediaSessionImpl).getCallback()) {
                        mediaSessionImpl = null;
                    }
                    return (MediaSessionImplApi21)mediaSessionImpl;
                }
            }
            
            private void c(final MediaSessionImpl mediaSessionImpl) {
                if (Build$VERSION.SDK_INT >= 28) {
                    return;
                }
                String callingPackage;
                if (TextUtils.isEmpty((CharSequence)(callingPackage = mediaSessionImpl.getCallingPackage()))) {
                    callingPackage = "android.media.session.MediaController";
                }
                mediaSessionImpl.setCurrentControllerInfo(new m0.b(callingPackage, -1, -1));
            }
            
            public void onCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                try {
                    final boolean equals = s.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER");
                    final QueueItem queueItem = null;
                    final IBinder binder = null;
                    if (equals) {
                        final Bundle bundle2 = new Bundle();
                        final Token sessionToken = b.getSessionToken();
                        final IMediaSession extraBinder = sessionToken.getExtraBinder();
                        IBinder binder2;
                        if (extraBinder == null) {
                            binder2 = binder;
                        }
                        else {
                            binder2 = ((IInterface)extraBinder).asBinder();
                        }
                        f.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", binder2);
                        b1.a.c(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", sessionToken.getSession2Token());
                        resultReceiver.send(0, bundle2);
                    }
                    else if (s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        this.a.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    }
                    else if (s.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        this.a.onAddQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    }
                    else if (s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        this.a.onRemoveQueueItem((MediaDescriptionCompat)bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    }
                    else if (s.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        if (b.h != null) {
                            final int int1 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            Object o = queueItem;
                            if (int1 >= 0) {
                                o = queueItem;
                                if (int1 < b.h.size()) {
                                    o = b.h.get(int1);
                                }
                            }
                            if (o != null) {
                                this.a.onRemoveQueueItem(((QueueItem)o).getDescription());
                            }
                        }
                    }
                    else {
                        this.a.onCommand(s, bundle, resultReceiver);
                    }
                }
                catch (final BadParcelableException ex) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                this.a(b);
            }
            
            public void onCustomAction(String s, Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                try {
                    if (s.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        final Uri uri = (Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        bundle = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.a.onPlayFromUri(uri, bundle);
                    }
                    else if (s.equals("android.support.v4.media.session.action.PREPARE")) {
                        this.a.onPrepare();
                    }
                    else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        s = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        bundle = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.a.onPrepareFromMediaId(s, bundle);
                    }
                    else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        s = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        bundle = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.a.onPrepareFromSearch(s, bundle);
                    }
                    else if (s.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        final Uri uri2 = (Uri)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                        bundle = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.a.onPrepareFromUri(uri2, bundle);
                    }
                    else if (s.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        this.a.onSetCaptioningEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    }
                    else if (s.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        this.a.onSetRepeatMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    }
                    else if (s.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        this.a.onSetShuffleMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    }
                    else if (s.equals("android.support.v4.media.session.action.SET_RATING")) {
                        final RatingCompat ratingCompat = (RatingCompat)bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING");
                        bundle = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.a.onSetRating(ratingCompat, bundle);
                    }
                    else if (s.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        this.a.onSetPlaybackSpeed(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    }
                    else {
                        this.a.onCustomAction(s, bundle);
                    }
                }
                catch (final BadParcelableException ex) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                this.a(b);
            }
            
            public void onFastForward() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onFastForward();
                this.a(b);
            }
            
            public boolean onMediaButtonEvent(final Intent intent) {
                final MediaSessionImplApi21 b = this.b();
                boolean b2 = false;
                if (b == null) {
                    return false;
                }
                this.c(b);
                final boolean onMediaButtonEvent = this.a.onMediaButtonEvent(intent);
                this.a(b);
                if (onMediaButtonEvent || super.onMediaButtonEvent(intent)) {
                    b2 = true;
                }
                return b2;
            }
            
            public void onPause() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onPause();
                this.a(b);
            }
            
            public void onPlay() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onPlay();
                this.a(b);
            }
            
            public void onPlayFromMediaId(final String s, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPlayFromMediaId(s, bundle);
                this.a(b);
            }
            
            public void onPlayFromSearch(final String s, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPlayFromSearch(s, bundle);
                this.a(b);
            }
            
            public void onPlayFromUri(final Uri uri, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPlayFromUri(uri, bundle);
                this.a(b);
            }
            
            public void onPrepare() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onPrepare();
                this.a(b);
            }
            
            public void onPrepareFromMediaId(final String s, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPrepareFromMediaId(s, bundle);
                this.a(b);
            }
            
            public void onPrepareFromSearch(final String s, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPrepareFromSearch(s, bundle);
                this.a(b);
            }
            
            public void onPrepareFromUri(final Uri uri, final Bundle bundle) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                MediaSessionCompat.ensureClassLoader(bundle);
                this.c(b);
                this.a.onPrepareFromUri(uri, bundle);
                this.a(b);
            }
            
            public void onRewind() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onRewind();
                this.a(b);
            }
            
            public void onSeekTo(final long n) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSeekTo(n);
                this.a(b);
            }
            
            public void onSetPlaybackSpeed(final float n) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSetPlaybackSpeed(n);
                this.a(b);
            }
            
            public void onSetRating(final Rating rating) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSetRating(RatingCompat.fromRating(rating));
                this.a(b);
            }
            
            public void onSetRating(final Rating rating, final Bundle bundle) {
            }
            
            public void onSkipToNext() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSkipToNext();
                this.a(b);
            }
            
            public void onSkipToPrevious() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSkipToPrevious();
                this.a(b);
            }
            
            public void onSkipToQueueItem(final long n) {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onSkipToQueueItem(n);
                this.a(b);
            }
            
            public void onStop() {
                final MediaSessionImplApi21 b = this.b();
                if (b == null) {
                    return;
                }
                this.c(b);
                this.a.onStop();
                this.a(b);
            }
        }
    }
    
    interface MediaSessionImpl
    {
        Callback getCallback();
        
        String getCallingPackage();
        
        m0.b getCurrentControllerInfo();
        
        Object getMediaSession();
        
        PlaybackStateCompat getPlaybackState();
        
        Object getRemoteControlClient();
        
        Token getSessionToken();
        
        boolean isActive();
        
        void release();
        
        void sendSessionEvent(final String p0, final Bundle p1);
        
        void setActive(final boolean p0);
        
        void setCallback(final Callback p0, final Handler p1);
        
        void setCaptioningEnabled(final boolean p0);
        
        void setCurrentControllerInfo(final m0.b p0);
        
        void setExtras(final Bundle p0);
        
        void setFlags(final int p0);
        
        void setMediaButtonReceiver(final PendingIntent p0);
        
        void setMetadata(final MediaMetadataCompat p0);
        
        void setPlaybackState(final PlaybackStateCompat p0);
        
        void setPlaybackToLocal(final int p0);
        
        void setPlaybackToRemote(final g p0);
        
        void setQueue(final List<QueueItem> p0);
        
        void setQueueTitle(final CharSequence p0);
        
        void setRatingType(final int p0);
        
        void setRepeatMode(final int p0);
        
        void setSessionActivity(final PendingIntent p0);
        
        void setShuffleMode(final int p0);
    }
    
    static class MediaSessionImplApi18 extends MediaSessionImplBase
    {
        private static boolean F = true;
        
        @Override
        int e(final long n) {
            int e = super.e(n);
            if ((n & 0x100L) != 0x0L) {
                e |= 0x100;
            }
            return e;
        }
        
        @Override
        void g(final PendingIntent pendingIntent, final ComponentName componentName) {
            if (MediaSessionImplApi18.F) {
                try {
                    super.i.registerMediaButtonEventReceiver(pendingIntent);
                }
                catch (final NullPointerException ex) {
                    Log.w("MediaSessionCompat", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
                    MediaSessionImplApi18.F = false;
                }
            }
            if (!MediaSessionImplApi18.F) {
                super.g(pendingIntent, componentName);
            }
        }
        
        @Override
        void s(final PlaybackStateCompat playbackStateCompat) {
            final long position = playbackStateCompat.getPosition();
            final float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            final long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            long n = position;
            if (playbackStateCompat.getState() == 3) {
                final long n2 = 0L;
                n = position;
                if (position > 0L) {
                    long n3 = n2;
                    if (lastPositionUpdateTime > 0L) {
                        final long n4 = n3 = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f) {
                            n3 = n4;
                            if (playbackSpeed != 1.0f) {
                                n3 = (long)(n4 * playbackSpeed);
                            }
                        }
                    }
                    n = position + n3;
                }
            }
            super.j.setPlaybackState(((MediaSessionImplBase)this).d(playbackStateCompat.getState()), n, playbackSpeed);
        }
        
        @Override
        public void setCallback(final Callback callback, final Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                super.j.setPlaybackPositionUpdateListener((RemoteControlClient$OnPlaybackPositionUpdateListener)null);
            }
            else {
                super.j.setPlaybackPositionUpdateListener((RemoteControlClient$OnPlaybackPositionUpdateListener)new RemoteControlClient$OnPlaybackPositionUpdateListener(this) {
                    final MediaSessionImplApi18 a;
                    
                    public void onPlaybackPositionUpdate(final long n) {
                        ((MediaSessionImplBase)this.a).f(18, -1, -1, n, null);
                    }
                });
            }
        }
        
        @Override
        void u(final PendingIntent pendingIntent, final ComponentName componentName) {
            if (MediaSessionImplApi18.F) {
                super.i.unregisterMediaButtonEventReceiver(pendingIntent);
            }
            else {
                super.u(pendingIntent, componentName);
            }
        }
    }
    
    static class MediaSessionImplBase implements MediaSessionImpl
    {
        int A;
        Bundle B;
        int C;
        int D;
        private g.a E;
        private final Context a;
        private final ComponentName b;
        private final PendingIntent c;
        private final MediaSessionStub d;
        private final Token e;
        final String f;
        final Bundle g;
        final String h;
        final AudioManager i;
        final RemoteControlClient j;
        final Object k;
        final RemoteCallbackList<IMediaControllerCallback> l;
        private MessageHandler m;
        boolean n;
        boolean o;
        volatile Callback p;
        private m0.b q;
        int r;
        MediaMetadataCompat s;
        PlaybackStateCompat t;
        PendingIntent u;
        List<QueueItem> v;
        CharSequence w;
        int x;
        boolean y;
        int z;
        
        public MediaSessionImplBase(final Context a, final String h, final ComponentName b, final PendingIntent c, final b b2, final Bundle g) {
            this.k = new Object();
            this.l = (RemoteCallbackList<IMediaControllerCallback>)new RemoteCallbackList();
            this.n = false;
            this.o = false;
            this.r = 3;
            this.E = new g.a() {
                final MediaSessionImplBase a;
                
                @Override
                public void onVolumeChanged(final g g) {
                    Objects.requireNonNull(this.a);
                    new(android.support.v4.media.session.ParcelableVolumeInfo.class)();
                    final MediaSessionImplBase a = this.a;
                    final int c = a.C;
                    final int d = a.D;
                    throw null;
                }
            };
            if (b != null) {
                this.a = a;
                this.f = a.getPackageName();
                this.g = g;
                this.i = (AudioManager)a.getSystemService("audio");
                this.h = h;
                this.b = b;
                this.c = c;
                final MediaSessionStub d = new MediaSessionStub();
                this.d = d;
                this.e = new Token(d, null, b2);
                this.x = 0;
                this.C = 1;
                this.D = 3;
                this.j = new RemoteControlClient(c);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }
        
        private void h(final boolean b) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onCaptioningEnabledChanged(b);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void i(final String s, final Bundle bundle) {
            int n = this.l.beginBroadcast() - 1;
        Label_0036_Outer:
            while (true) {
                Label_0042: {
                    if (n < 0) {
                        break Label_0042;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onEvent(s, bundle);
                            --n;
                            continue Label_0036_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void j(final Bundle bundle) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onExtrasChanged(bundle);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void k(final MediaMetadataCompat mediaMetadataCompat) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onMetadataChanged(mediaMetadataCompat);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void l(final List<QueueItem> list) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onQueueChanged(list);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void m(final CharSequence charSequence) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onQueueTitleChanged(charSequence);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void n(final int n) {
            int n2 = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n2 < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n2);
                    while (true) {
                        try {
                            mediaControllerCallback.onRepeatModeChanged(n);
                            --n2;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void o() {
            int n = this.l.beginBroadcast() - 1;
        Label_0032_Outer:
            while (true) {
                Label_0038: {
                    if (n < 0) {
                        break Label_0038;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onSessionDestroyed();
                            --n;
                            continue Label_0032_Outer;
                            this.l.finishBroadcast();
                            this.l.kill();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void p(final int n) {
            int n2 = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n2 < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n2);
                    while (true) {
                        try {
                            mediaControllerCallback.onShuffleModeChanged(n);
                            --n2;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        private void q(final PlaybackStateCompat playbackStateCompat) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        void a(final int n, final int n2) {
            if (this.C != 2) {
                this.i.adjustStreamVolume(this.D, n, n2);
            }
        }
        
        RemoteControlClient$MetadataEditor b(final Bundle bundle) {
            final RemoteControlClient$MetadataEditor editMetadata = this.j.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey("android.media.metadata.ART")) {
                final Bitmap bitmap = (Bitmap)bundle.getParcelable("android.media.metadata.ART");
                Bitmap copy;
                if ((copy = bitmap) != null) {
                    copy = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, copy);
            }
            else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
                final Bitmap bitmap2 = (Bitmap)bundle.getParcelable("android.media.metadata.ALBUM_ART");
                Bitmap copy2;
                if ((copy2 = bitmap2) != null) {
                    copy2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, copy2);
            }
            if (bundle.containsKey("android.media.metadata.ALBUM")) {
                editMetadata.putString(1, bundle.getString("android.media.metadata.ALBUM"));
            }
            if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                editMetadata.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.ARTIST")) {
                editMetadata.putString(2, bundle.getString("android.media.metadata.ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.AUTHOR")) {
                editMetadata.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
            }
            if (bundle.containsKey("android.media.metadata.COMPILATION")) {
                editMetadata.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
            }
            if (bundle.containsKey("android.media.metadata.COMPOSER")) {
                editMetadata.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
            }
            if (bundle.containsKey("android.media.metadata.DATE")) {
                editMetadata.putString(5, bundle.getString("android.media.metadata.DATE"));
            }
            if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
                editMetadata.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.DURATION")) {
                editMetadata.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
            }
            if (bundle.containsKey("android.media.metadata.GENRE")) {
                editMetadata.putString(6, bundle.getString("android.media.metadata.GENRE"));
            }
            if (bundle.containsKey("android.media.metadata.TITLE")) {
                editMetadata.putString(7, bundle.getString("android.media.metadata.TITLE"));
            }
            if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
                editMetadata.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.WRITER")) {
                editMetadata.putString(11, bundle.getString("android.media.metadata.WRITER"));
            }
            return editMetadata;
        }
        
        String c(final int n) {
            String nameForUid;
            if (TextUtils.isEmpty((CharSequence)(nameForUid = this.a.getPackageManager().getNameForUid(n)))) {
                nameForUid = "android.media.session.MediaController";
            }
            return nameForUid;
        }
        
        int d(final int n) {
            switch (n) {
                default: {
                    return -1;
                }
                case 10:
                case 11: {
                    return 6;
                }
                case 9: {
                    return 7;
                }
                case 7: {
                    return 9;
                }
                case 6:
                case 8: {
                    return 8;
                }
                case 5: {
                    return 5;
                }
                case 4: {
                    return 4;
                }
                case 3: {
                    return 3;
                }
                case 2: {
                    return 2;
                }
                case 1: {
                    return 1;
                }
                case 0: {
                    return 0;
                }
            }
        }
        
        int e(final long n) {
            int n2;
            if ((0x1L & n) != 0x0L) {
                n2 = 32;
            }
            else {
                n2 = 0;
            }
            int n3 = n2;
            if ((0x2L & n) != 0x0L) {
                n3 = (n2 | 0x10);
            }
            int n4 = n3;
            if ((0x4L & n) != 0x0L) {
                n4 = (n3 | 0x4);
            }
            int n5 = n4;
            if ((0x8L & n) != 0x0L) {
                n5 = (n4 | 0x2);
            }
            int n6 = n5;
            if ((0x10L & n) != 0x0L) {
                n6 = (n5 | 0x1);
            }
            int n7 = n6;
            if ((0x20L & n) != 0x0L) {
                n7 = (n6 | 0x80);
            }
            int n8 = n7;
            if ((0x40L & n) != 0x0L) {
                n8 = (n7 | 0x40);
            }
            int n9 = n8;
            if ((n & 0x200L) != 0x0L) {
                n9 = (n8 | 0x8);
            }
            return n9;
        }
        
        void f(int n, final int n2, final int n3, final Object o, final Bundle bundle) {
            synchronized (this.k) {
                final MessageHandler m = this.m;
                if (m != null) {
                    final Message obtainMessage = m.obtainMessage(n, n2, n3, o);
                    final Bundle data = new Bundle();
                    n = Binder.getCallingUid();
                    data.putInt("data_calling_uid", n);
                    data.putString("data_calling_pkg", this.c(n));
                    n = Binder.getCallingPid();
                    if (n > 0) {
                        data.putInt("data_calling_pid", n);
                    }
                    else {
                        data.putInt("data_calling_pid", -1);
                    }
                    if (bundle != null) {
                        data.putBundle("data_extras", bundle);
                    }
                    obtainMessage.setData(data);
                    obtainMessage.sendToTarget();
                }
            }
        }
        
        void g(final PendingIntent pendingIntent, final ComponentName componentName) {
            this.i.registerMediaButtonEventReceiver(componentName);
        }
        
        @Override
        public Callback getCallback() {
            synchronized (this.k) {
                return this.p;
            }
        }
        
        @Override
        public String getCallingPackage() {
            return null;
        }
        
        @Override
        public m0.b getCurrentControllerInfo() {
            synchronized (this.k) {
                return this.q;
            }
        }
        
        @Override
        public Object getMediaSession() {
            return null;
        }
        
        @Override
        public PlaybackStateCompat getPlaybackState() {
            synchronized (this.k) {
                return this.t;
            }
        }
        
        @Override
        public Object getRemoteControlClient() {
            return null;
        }
        
        @Override
        public Token getSessionToken() {
            return this.e;
        }
        
        @Override
        public boolean isActive() {
            return this.o;
        }
        
        void r(final ParcelableVolumeInfo parcelableVolumeInfo) {
            int n = this.l.beginBroadcast() - 1;
        Label_0033_Outer:
            while (true) {
                Label_0039: {
                    if (n < 0) {
                        break Label_0039;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.l.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onVolumeInfoChanged(parcelableVolumeInfo);
                            --n;
                            continue Label_0033_Outer;
                            this.l.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        @Override
        public void release() {
            this.o = false;
            this.n = true;
            this.v();
            this.o();
            this.setCallback(null, null);
        }
        
        void s(final PlaybackStateCompat playbackStateCompat) {
            this.j.setPlaybackState(this.d(playbackStateCompat.getState()));
        }
        
        @Override
        public void sendSessionEvent(final String s, final Bundle bundle) {
            this.i(s, bundle);
        }
        
        @Override
        public void setActive(final boolean o) {
            if (o == this.o) {
                return;
            }
            this.o = o;
            this.v();
        }
        
        @Override
        public void setCallback(final Callback p2, final Handler handler) {
            synchronized (this.k) {
                final MessageHandler m = this.m;
                if (m != null) {
                    m.removeCallbacksAndMessages((Object)null);
                }
                MessageHandler i;
                if (p2 != null && handler != null) {
                    i = new MessageHandler(handler.getLooper());
                }
                else {
                    i = null;
                }
                this.m = i;
                if (this.p != p2 && this.p != null) {
                    this.p.b(null, null);
                }
                this.p = p2;
                if (this.p != null) {
                    this.p.b(this, handler);
                }
            }
        }
        
        @Override
        public void setCaptioningEnabled(final boolean y) {
            if (this.y != y) {
                this.h(this.y = y);
            }
        }
        
        @Override
        public void setCurrentControllerInfo(final m0.b q) {
            synchronized (this.k) {
                this.q = q;
            }
        }
        
        @Override
        public void setExtras(final Bundle b) {
            this.j(this.B = b);
        }
        
        @Override
        public void setFlags(final int n) {
            synchronized (this.k) {
                this.r = (n | 0x1 | 0x2);
            }
        }
        
        @Override
        public void setMediaButtonReceiver(final PendingIntent pendingIntent) {
        }
        
        @Override
        public void setMetadata(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadataCompat build = mediaMetadataCompat;
            if (mediaMetadataCompat != null) {
                build = new MediaMetadataCompat.Builder(mediaMetadataCompat, MediaSessionCompat.d).build();
            }
            mediaMetadataCompat = (MediaMetadataCompat)this.k;
            synchronized (mediaMetadataCompat) {
                this.s = build;
                monitorexit(mediaMetadataCompat);
                this.k(build);
                if (!this.o) {
                    return;
                }
                if (build == null) {
                    mediaMetadataCompat = null;
                }
                else {
                    mediaMetadataCompat = (MediaMetadataCompat)build.getBundle();
                }
                this.b((Bundle)mediaMetadataCompat).apply();
            }
        }
        
        @Override
        public void setPlaybackState(final PlaybackStateCompat t) {
            synchronized (this.k) {
                this.t = t;
                monitorexit(this.k);
                this.q(t);
                if (!this.o) {
                    return;
                }
                if (t == null) {
                    this.j.setPlaybackState(0);
                    this.j.setTransportControlFlags(0);
                }
                else {
                    this.s(t);
                    this.j.setTransportControlFlags(this.e(t.getActions()));
                }
            }
        }
        
        @Override
        public void setPlaybackToLocal(int c) {
            this.D = c;
            this.C = 1;
            c = this.C;
            final int d = this.D;
            this.r(new ParcelableVolumeInfo(c, d, 2, this.i.getStreamMaxVolume(d), this.i.getStreamVolume(this.D)));
        }
        
        @Override
        public void setPlaybackToRemote(final g g) {
            throw new IllegalArgumentException("volumeProvider may not be null");
        }
        
        @Override
        public void setQueue(final List<QueueItem> v) {
            this.l(this.v = v);
        }
        
        @Override
        public void setQueueTitle(final CharSequence w) {
            this.m(this.w = w);
        }
        
        @Override
        public void setRatingType(final int x) {
            this.x = x;
        }
        
        @Override
        public void setRepeatMode(final int z) {
            if (this.z != z) {
                this.n(this.z = z);
            }
        }
        
        @Override
        public void setSessionActivity(final PendingIntent u) {
            synchronized (this.k) {
                this.u = u;
            }
        }
        
        @Override
        public void setShuffleMode(final int a) {
            if (this.A != a) {
                this.p(this.A = a);
            }
        }
        
        void t(final int n, final int n2) {
            if (this.C != 2) {
                this.i.setStreamVolume(this.D, n, n2);
            }
        }
        
        void u(final PendingIntent pendingIntent, final ComponentName componentName) {
            this.i.unregisterMediaButtonEventReceiver(componentName);
        }
        
        void v() {
            if (this.o) {
                this.g(this.c, this.b);
                this.i.registerRemoteControlClient(this.j);
                this.setMetadata(this.s);
                this.setPlaybackState(this.t);
            }
            else {
                this.u(this.c, this.b);
                this.j.setPlaybackState(0);
                this.i.unregisterRemoteControlClient(this.j);
            }
        }
        
        private static final class Command
        {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;
            
            public Command(final String command, final Bundle extras, final ResultReceiver stub) {
                this.command = command;
                this.extras = extras;
                this.stub = stub;
            }
        }
        
        class MediaSessionStub extends Stub
        {
            final MediaSessionImplBase a;
            
            MediaSessionStub(final MediaSessionImplBase a) {
                this.a = a;
            }
            
            void M0(final int n) {
                this.a.f(n, 0, 0, null, null);
            }
            
            public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
                this.q1(25, mediaDescriptionCompat);
            }
            
            public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
                this.r1(26, mediaDescriptionCompat, n);
            }
            
            public void adjustVolume(final int n, final int n2, final String s) {
                this.a.a(n, n2);
            }
            
            public void fastForward() throws RemoteException {
                this.M0(16);
            }
            
            public Bundle getExtras() {
                synchronized (this.a.k) {
                    return this.a.B;
                }
            }
            
            public long getFlags() {
                synchronized (this.a.k) {
                    return this.a.r;
                }
            }
            
            public PendingIntent getLaunchPendingIntent() {
                synchronized (this.a.k) {
                    return this.a.u;
                }
            }
            
            public MediaMetadataCompat getMetadata() {
                return this.a.s;
            }
            
            public String getPackageName() {
                return this.a.f;
            }
            
            public PlaybackStateCompat getPlaybackState() {
                synchronized (this.a.k) {
                    final MediaSessionImplBase a = this.a;
                    final PlaybackStateCompat t = a.t;
                    final MediaMetadataCompat s = a.s;
                    monitorexit(this.a.k);
                    return MediaSessionCompat.a(t, s);
                }
            }
            
            public List<QueueItem> getQueue() {
                synchronized (this.a.k) {
                    return this.a.v;
                }
            }
            
            public CharSequence getQueueTitle() {
                return this.a.w;
            }
            
            public int getRatingType() {
                return this.a.x;
            }
            
            public int getRepeatMode() {
                return this.a.z;
            }
            
            public Bundle getSessionInfo() {
                Bundle bundle;
                if (this.a.g == null) {
                    bundle = null;
                }
                else {
                    bundle = new Bundle(this.a.g);
                }
                return bundle;
            }
            
            public int getShuffleMode() {
                return this.a.A;
            }
            
            public String getTag() {
                return this.a.h;
            }
            
            public ParcelableVolumeInfo getVolumeAttributes() {
                synchronized (this.a.k) {
                    final MediaSessionImplBase a = this.a;
                    final int c = a.C;
                    final int d = a.D;
                    Objects.requireNonNull(a);
                    if (c != 2) {
                        final int streamMaxVolume = this.a.i.getStreamMaxVolume(d);
                        final int streamVolume = this.a.i.getStreamVolume(d);
                        monitorexit(this.a.k);
                        return new ParcelableVolumeInfo(c, d, 2, streamMaxVolume, streamVolume);
                    }
                    throw null;
                }
            }
            
            public boolean isCaptioningEnabled() {
                return this.a.y;
            }
            
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }
            
            public boolean isTransportControlEnabled() {
                return true;
            }
            
            public void next() throws RemoteException {
                this.M0(14);
            }
            
            void p1(final int n, final int n2) {
                this.a.f(n, n2, 0, null, null);
            }
            
            public void pause() throws RemoteException {
                this.M0(12);
            }
            
            public void play() throws RemoteException {
                this.M0(7);
            }
            
            public void playFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                this.s1(8, s, bundle);
            }
            
            public void playFromSearch(final String s, final Bundle bundle) throws RemoteException {
                this.s1(9, s, bundle);
            }
            
            public void playFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                this.s1(10, uri, bundle);
            }
            
            public void prepare() throws RemoteException {
                this.M0(3);
            }
            
            public void prepareFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                this.s1(4, s, bundle);
            }
            
            public void prepareFromSearch(final String s, final Bundle bundle) throws RemoteException {
                this.s1(5, s, bundle);
            }
            
            public void prepareFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                this.s1(6, uri, bundle);
            }
            
            public void previous() throws RemoteException {
                this.M0(15);
            }
            
            void q1(final int n, final Object o) {
                this.a.f(n, 0, 0, o, null);
            }
            
            void r1(final int n, final Object o, final int n2) {
                this.a.f(n, n2, 0, o, null);
            }
            
            public void rate(final RatingCompat ratingCompat) throws RemoteException {
                this.q1(19, ratingCompat);
            }
            
            public void rateWithExtras(final RatingCompat ratingCompat, final Bundle bundle) throws RemoteException {
                this.s1(31, ratingCompat, bundle);
            }
            
            public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
                Label_0017: {
                    if (!this.a.n) {
                        break Label_0017;
                    }
                    try {
                        mediaControllerCallback.onSessionDestroyed();
                        return;
                        this.a.l.register((IInterface)mediaControllerCallback, (Object)new m0.b(this.a.c(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                    }
                    catch (final Exception ex) {}
                }
            }
            
            public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
                this.q1(27, mediaDescriptionCompat);
            }
            
            public void removeQueueItemAt(final int n) {
                this.p1(28, n);
            }
            
            public void rewind() throws RemoteException {
                this.M0(17);
            }
            
            void s1(final int n, final Object o, final Bundle bundle) {
                this.a.f(n, 0, 0, o, bundle);
            }
            
            public void seekTo(final long n) throws RemoteException {
                this.q1(18, n);
            }
            
            public void sendCommand(final String s, final Bundle bundle, final ResultReceiverWrapper resultReceiverWrapper) {
                ResultReceiver a;
                if (resultReceiverWrapper == null) {
                    a = null;
                }
                else {
                    a = resultReceiverWrapper.a;
                }
                this.q1(1, new Command(s, bundle, a));
            }
            
            public void sendCustomAction(final String s, final Bundle bundle) throws RemoteException {
                this.s1(20, s, bundle);
            }
            
            public boolean sendMediaButton(final KeyEvent keyEvent) {
                this.q1(21, keyEvent);
                return true;
            }
            
            public void setCaptioningEnabled(final boolean b) throws RemoteException {
                this.q1(29, b);
            }
            
            public void setPlaybackSpeed(final float n) throws RemoteException {
                this.q1(32, n);
            }
            
            public void setRepeatMode(final int n) throws RemoteException {
                this.p1(23, n);
            }
            
            public void setShuffleMode(final int n) throws RemoteException {
                this.p1(30, n);
            }
            
            public void setShuffleModeEnabledRemoved(final boolean b) throws RemoteException {
            }
            
            public void setVolumeTo(final int n, final int n2, final String s) {
                this.a.t(n, n2);
            }
            
            public void skipToQueueItem(final long n) {
                this.q1(11, n);
            }
            
            public void stop() throws RemoteException {
                this.M0(13);
            }
            
            public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
                this.a.l.unregister((IInterface)mediaControllerCallback);
            }
        }
        
        class MessageHandler extends Handler
        {
            final MediaSessionImplBase a;
            
            public MessageHandler(final MediaSessionImplBase a, final Looper looper) {
                this.a = a;
                super(looper);
            }
            
            private void a(final KeyEvent keyEvent, final Callback callback) {
                if (keyEvent != null) {
                    if (keyEvent.getAction() == 0) {
                        final PlaybackStateCompat t = this.a.t;
                        long actions;
                        if (t == null) {
                            actions = 0L;
                        }
                        else {
                            actions = t.getActions();
                        }
                        final int keyCode = keyEvent.getKeyCode();
                        if (keyCode != 79) {
                            if (keyCode != 126) {
                                if (keyCode != 127) {
                                    switch (keyCode) {
                                        default: {
                                            return;
                                        }
                                        case 90: {
                                            if ((actions & 0x40L) != 0x0L) {
                                                callback.onFastForward();
                                            }
                                            return;
                                        }
                                        case 89: {
                                            if ((actions & 0x8L) != 0x0L) {
                                                callback.onRewind();
                                            }
                                            return;
                                        }
                                        case 88: {
                                            if ((actions & 0x10L) != 0x0L) {
                                                callback.onSkipToPrevious();
                                            }
                                            return;
                                        }
                                        case 87: {
                                            if ((actions & 0x20L) != 0x0L) {
                                                callback.onSkipToNext();
                                            }
                                            return;
                                        }
                                        case 86: {
                                            if ((actions & 0x1L) != 0x0L) {
                                                callback.onStop();
                                            }
                                            return;
                                        }
                                        case 85: {
                                            break;
                                        }
                                    }
                                }
                                else {
                                    if ((actions & 0x2L) != 0x0L) {
                                        callback.onPause();
                                    }
                                    return;
                                }
                            }
                            else {
                                if ((actions & 0x4L) != 0x0L) {
                                    callback.onPlay();
                                }
                                return;
                            }
                        }
                        Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                    }
                }
            }
            
            public void handleMessage(final Message message) {
                final Callback p = this.a.p;
                if (p == null) {
                    return;
                }
                final Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                this.a.setCurrentControllerInfo(new m0.b(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                final Bundle bundle = data.getBundle("data_extras");
                MediaSessionCompat.ensureClassLoader(bundle);
                try {
                    switch (message.what) {
                        case 32: {
                            p.onSetPlaybackSpeed((float)message.obj);
                            break;
                        }
                        case 31: {
                            p.onSetRating((RatingCompat)message.obj, bundle);
                            break;
                        }
                        case 30: {
                            p.onSetShuffleMode(message.arg1);
                            break;
                        }
                        case 29: {
                            p.onSetCaptioningEnabled((boolean)message.obj);
                            break;
                        }
                        case 28: {
                            final List<QueueItem> v = this.a.v;
                            if (v == null) {
                                break;
                            }
                            final int arg1 = message.arg1;
                            QueueItem queueItem;
                            if (arg1 >= 0 && arg1 < v.size()) {
                                queueItem = this.a.v.get(message.arg1);
                            }
                            else {
                                queueItem = null;
                            }
                            if (queueItem != null) {
                                p.onRemoveQueueItem(queueItem.getDescription());
                                break;
                            }
                            break;
                        }
                        case 27: {
                            p.onRemoveQueueItem((MediaDescriptionCompat)message.obj);
                            break;
                        }
                        case 26: {
                            p.onAddQueueItem((MediaDescriptionCompat)message.obj, message.arg1);
                            break;
                        }
                        case 25: {
                            p.onAddQueueItem((MediaDescriptionCompat)message.obj);
                            break;
                        }
                        case 23: {
                            p.onSetRepeatMode(message.arg1);
                            break;
                        }
                        case 22: {
                            this.a.t(message.arg1, 0);
                            break;
                        }
                        case 21: {
                            final KeyEvent keyEvent = (KeyEvent)message.obj;
                            final Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)keyEvent);
                            if (!p.onMediaButtonEvent(intent)) {
                                this.a(keyEvent, p);
                                break;
                            }
                            break;
                        }
                        case 20: {
                            p.onCustomAction((String)message.obj, bundle);
                            break;
                        }
                        case 19: {
                            p.onSetRating((RatingCompat)message.obj);
                            break;
                        }
                        case 18: {
                            p.onSeekTo((long)message.obj);
                            break;
                        }
                        case 17: {
                            p.onRewind();
                            break;
                        }
                        case 16: {
                            p.onFastForward();
                            break;
                        }
                        case 15: {
                            p.onSkipToPrevious();
                            break;
                        }
                        case 14: {
                            p.onSkipToNext();
                            break;
                        }
                        case 13: {
                            p.onStop();
                            break;
                        }
                        case 12: {
                            p.onPause();
                            break;
                        }
                        case 11: {
                            p.onSkipToQueueItem((long)message.obj);
                            break;
                        }
                        case 10: {
                            p.onPlayFromUri((Uri)message.obj, bundle);
                            break;
                        }
                        case 9: {
                            p.onPlayFromSearch((String)message.obj, bundle);
                            break;
                        }
                        case 8: {
                            p.onPlayFromMediaId((String)message.obj, bundle);
                            break;
                        }
                        case 7: {
                            p.onPlay();
                            break;
                        }
                        case 6: {
                            p.onPrepareFromUri((Uri)message.obj, bundle);
                            break;
                        }
                        case 5: {
                            p.onPrepareFromSearch((String)message.obj, bundle);
                            break;
                        }
                        case 4: {
                            p.onPrepareFromMediaId((String)message.obj, bundle);
                            break;
                        }
                        case 3: {
                            p.onPrepare();
                            break;
                        }
                        case 2: {
                            this.a.a(message.arg1, 0);
                            break;
                        }
                        case 1: {
                            final Command command = (Command)message.obj;
                            p.onCommand(command.command, command.extras, command.stub);
                            break;
                        }
                    }
                }
                finally {
                    this.a.setCurrentControllerInfo(null);
                }
            }
        }
    }
    
    static class MediaSessionImplApi19 extends MediaSessionImplApi18
    {
        @Override
        RemoteControlClient$MetadataEditor b(final Bundle bundle) {
            final RemoteControlClient$MetadataEditor b = super.b(bundle);
            final PlaybackStateCompat t = super.t;
            long actions;
            if (t == null) {
                actions = 0L;
            }
            else {
                actions = t.getActions();
            }
            if ((actions & 0x80L) != 0x0L) {
                b.addEditableKey(268435457);
            }
            if (bundle == null) {
                return b;
            }
            if (bundle.containsKey("android.media.metadata.YEAR")) {
                b.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
            }
            if (bundle.containsKey("android.media.metadata.RATING")) {
                ((MediaMetadataEditor)b).putObject(101, (Object)bundle.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                ((MediaMetadataEditor)b).putObject(268435457, (Object)bundle.getParcelable("android.media.metadata.USER_RATING"));
            }
            return b;
        }
        
        @Override
        int e(final long n) {
            int e = super.e(n);
            if ((n & 0x80L) != 0x0L) {
                e |= 0x200;
            }
            return e;
        }
        
        @Override
        public void setCallback(final Callback callback, final Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                super.j.setMetadataUpdateListener((RemoteControlClient$OnMetadataUpdateListener)null);
            }
            else {
                super.j.setMetadataUpdateListener((RemoteControlClient$OnMetadataUpdateListener)new RemoteControlClient$OnMetadataUpdateListener(this) {
                    final MediaSessionImplApi19 a;
                    
                    public void onMetadataUpdate(final int n, final Object o) {
                        if (n == 268435457 && o instanceof Rating) {
                            ((MediaSessionImplBase)this.a).f(19, -1, -1, RatingCompat.fromRating(o), null);
                        }
                    }
                });
            }
        }
    }
    
    static class MediaSessionImplApi21 implements MediaSessionImpl
    {
        final MediaSession a;
        final Token b;
        final Object c;
        Bundle d;
        boolean e;
        final RemoteCallbackList<IMediaControllerCallback> f;
        PlaybackStateCompat g;
        List<QueueItem> h;
        MediaMetadataCompat i;
        int j;
        boolean k;
        int l;
        int m;
        Callback n;
        m0.b o;
        
        MediaSessionImplApi21(final Context context, final String s, final b b, final Bundle d) {
            this.c = new Object();
            this.e = false;
            this.f = (RemoteCallbackList<IMediaControllerCallback>)new RemoteCallbackList();
            final MediaSession fwkMediaSession = this.createFwkMediaSession(context, s, d);
            this.a = fwkMediaSession;
            this.b = new Token(fwkMediaSession.getSessionToken(), new ExtraSession(), b);
            this.d = d;
            this.setFlags(3);
        }
        
        MediaSessionImplApi21(final Object o) {
            this.c = new Object();
            this.e = false;
            this.f = (RemoteCallbackList<IMediaControllerCallback>)new RemoteCallbackList();
            if (o instanceof MediaSession) {
                final MediaSession a = (MediaSession)o;
                this.a = a;
                this.b = new Token(a.getSessionToken(), new ExtraSession());
                this.d = null;
                this.setFlags(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
        
        public MediaSession createFwkMediaSession(final Context context, final String s, final Bundle bundle) {
            return new MediaSession(context, s);
        }
        
        @Override
        public Callback getCallback() {
            synchronized (this.c) {
                return this.n;
            }
        }
        
        @Override
        public String getCallingPackage() {
            try {
                return (String)this.a.getClass().getMethod("getCallingPackage", (Class<?>[])new Class[0]).invoke(this.a, new Object[0]);
            }
            catch (final Exception ex) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public m0.b getCurrentControllerInfo() {
            synchronized (this.c) {
                return this.o;
            }
        }
        
        @Override
        public Object getMediaSession() {
            return this.a;
        }
        
        @Override
        public PlaybackStateCompat getPlaybackState() {
            return this.g;
        }
        
        @Override
        public Object getRemoteControlClient() {
            return null;
        }
        
        @Override
        public Token getSessionToken() {
            return this.b;
        }
        
        @Override
        public boolean isActive() {
            return this.a.isActive();
        }
        
        @Override
        public void release() {
            this.e = true;
            this.f.kill();
            if (Build$VERSION.SDK_INT == 27) {
                try {
                    final Field declaredField = this.a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    final Handler handler = (Handler)declaredField.get(this.a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages((Object)null);
                    }
                }
                catch (final Exception ex) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", (Throwable)ex);
                }
            }
            this.a.setCallback((MediaSession$Callback)null);
            this.a.release();
        }
        
        @Override
        public void sendSessionEvent(final String s, final Bundle bundle) {
            this.a.sendSessionEvent(s, bundle);
        }
        
        @Override
        public void setActive(final boolean active) {
            this.a.setActive(active);
        }
        
        @Override
        public void setCallback(final Callback n, final Handler handler) {
            synchronized (this.c) {
                this.n = n;
                final MediaSession a = this.a;
                MediaSession$Callback b;
                if (n == null) {
                    b = null;
                }
                else {
                    b = n.b;
                }
                a.setCallback(b, handler);
                if (n != null) {
                    n.b(this, handler);
                }
            }
        }
        
        @Override
        public void setCaptioningEnabled(final boolean k) {
            if (this.k == k) {
                return;
            }
            this.k = k;
            int n = this.f.beginBroadcast() - 1;
        Label_0046_Outer:
            while (true) {
                Label_0052: {
                    if (n < 0) {
                        break Label_0052;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.f.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onCaptioningEnabledChanged(k);
                            --n;
                            continue Label_0046_Outer;
                            this.f.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
        
        @Override
        public void setCurrentControllerInfo(final m0.b o) {
            synchronized (this.c) {
                this.o = o;
            }
        }
        
        @Override
        public void setExtras(final Bundle extras) {
            this.a.setExtras(extras);
        }
        
        @Override
        public void setFlags(final int n) {
            this.a.setFlags(n | 0x1 | 0x2);
        }
        
        @Override
        public void setMediaButtonReceiver(final PendingIntent mediaButtonReceiver) {
            this.a.setMediaButtonReceiver(mediaButtonReceiver);
        }
        
        @Override
        public void setMetadata(final MediaMetadataCompat i) {
            this.i = i;
            final MediaSession a = this.a;
            MediaMetadata metadata;
            if (i == null) {
                metadata = null;
            }
            else {
                metadata = (MediaMetadata)i.getMediaMetadata();
            }
            a.setMetadata(metadata);
        }
        
        @Override
        public void setPlaybackState(PlaybackStateCompat playbackStateCompat) {
            this.g = playbackStateCompat;
            int n = this.f.beginBroadcast() - 1;
        Label_0038_Outer:
            while (true) {
                Label_0044: {
                    if (n < 0) {
                        break Label_0044;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.f.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onPlaybackStateChanged(playbackStateCompat);
                            --n;
                            continue Label_0038_Outer;
                            Label_0065: {
                                playbackStateCompat = (PlaybackStateCompat)playbackStateCompat.getPlaybackState();
                            }
                            while (true) {
                                final MediaSession a;
                                a.setPlaybackState((PlaybackState)playbackStateCompat);
                                return;
                                this.f.finishBroadcast();
                                a = this.a;
                                iftrue(Label_0065:)(playbackStateCompat != null);
                                playbackStateCompat = null;
                                continue;
                            }
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        @Override
        public void setPlaybackToLocal(final int legacyStreamType) {
            final AudioAttributes$Builder audioAttributes$Builder = new AudioAttributes$Builder();
            audioAttributes$Builder.setLegacyStreamType(legacyStreamType);
            this.a.setPlaybackToLocal(audioAttributes$Builder.build());
        }
        
        @Override
        public void setPlaybackToRemote(final g g) {
            throw null;
        }
        
        @Override
        public void setQueue(final List<QueueItem> h) {
            this.h = h;
            if (h == null) {
                this.a.setQueue((List)null);
                return;
            }
            final ArrayList queue = new ArrayList();
            final Iterator<QueueItem> iterator = h.iterator();
            while (iterator.hasNext()) {
                queue.add(iterator.next().getQueueItem());
            }
            this.a.setQueue((List)queue);
        }
        
        @Override
        public void setQueueTitle(final CharSequence queueTitle) {
            this.a.setQueueTitle(queueTitle);
        }
        
        @Override
        public void setRatingType(final int j) {
            this.j = j;
        }
        
        @Override
        public void setRepeatMode(final int l) {
            if (this.l == l) {
                return;
            }
            this.l = l;
            int n = this.f.beginBroadcast() - 1;
        Label_0046_Outer:
            while (true) {
                Label_0052: {
                    if (n < 0) {
                        break Label_0052;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.f.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onRepeatModeChanged(l);
                            --n;
                            continue Label_0046_Outer;
                            this.f.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
        
        @Override
        public void setSessionActivity(final PendingIntent sessionActivity) {
            this.a.setSessionActivity(sessionActivity);
        }
        
        @Override
        public void setShuffleMode(final int m) {
            if (this.m == m) {
                return;
            }
            this.m = m;
            int n = this.f.beginBroadcast() - 1;
        Label_0046_Outer:
            while (true) {
                Label_0052: {
                    if (n < 0) {
                        break Label_0052;
                    }
                    final IMediaControllerCallback mediaControllerCallback = (IMediaControllerCallback)this.f.getBroadcastItem(n);
                    while (true) {
                        try {
                            mediaControllerCallback.onShuffleModeChanged(m);
                            --n;
                            continue Label_0046_Outer;
                            this.f.finishBroadcast();
                        }
                        catch (final RemoteException ex) {
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
        
        class ExtraSession extends Stub
        {
            final MediaSessionImplApi21 a;
            
            ExtraSession(final MediaSessionImplApi21 a) {
                this.a = a;
            }
            
            public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }
            
            public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
                throw new AssertionError();
            }
            
            public void adjustVolume(final int n, final int n2, final String s) {
                throw new AssertionError();
            }
            
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }
            
            public Bundle getExtras() {
                throw new AssertionError();
            }
            
            public long getFlags() {
                throw new AssertionError();
            }
            
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }
            
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }
            
            public String getPackageName() {
                throw new AssertionError();
            }
            
            public PlaybackStateCompat getPlaybackState() {
                final MediaSessionImplApi21 a = this.a;
                return MediaSessionCompat.a(a.g, a.i);
            }
            
            public List<QueueItem> getQueue() {
                return null;
            }
            
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }
            
            public int getRatingType() {
                return this.a.j;
            }
            
            public int getRepeatMode() {
                return this.a.l;
            }
            
            public Bundle getSessionInfo() {
                Bundle bundle;
                if (this.a.d == null) {
                    bundle = null;
                }
                else {
                    bundle = new Bundle(this.a.d);
                }
                return bundle;
            }
            
            public int getShuffleMode() {
                return this.a.m;
            }
            
            public String getTag() {
                throw new AssertionError();
            }
            
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }
            
            public boolean isCaptioningEnabled() {
                return this.a.k;
            }
            
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }
            
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
            
            public void next() throws RemoteException {
                throw new AssertionError();
            }
            
            public void pause() throws RemoteException {
                throw new AssertionError();
            }
            
            public void play() throws RemoteException {
                throw new AssertionError();
            }
            
            public void playFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void playFromSearch(final String s, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void playFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }
            
            public void prepareFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void prepareFromSearch(final String s, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void prepareFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void previous() throws RemoteException {
                throw new AssertionError();
            }
            
            public void rate(final RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }
            
            public void rateWithExtras(final RatingCompat ratingCompat, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
                if (!this.a.e) {
                    this.a.f.register((IInterface)mediaControllerCallback, (Object)new m0.b("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }
            
            public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }
            
            public void removeQueueItemAt(final int n) {
                throw new AssertionError();
            }
            
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }
            
            public void seekTo(final long n) throws RemoteException {
                throw new AssertionError();
            }
            
            public void sendCommand(final String s, final Bundle bundle, final ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }
            
            public void sendCustomAction(final String s, final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            public boolean sendMediaButton(final KeyEvent keyEvent) {
                throw new AssertionError();
            }
            
            public void setCaptioningEnabled(final boolean b) throws RemoteException {
                throw new AssertionError();
            }
            
            public void setPlaybackSpeed(final float n) throws RemoteException {
                throw new AssertionError();
            }
            
            public void setRepeatMode(final int n) throws RemoteException {
                throw new AssertionError();
            }
            
            public void setShuffleMode(final int n) throws RemoteException {
                throw new AssertionError();
            }
            
            public void setShuffleModeEnabledRemoved(final boolean b) throws RemoteException {
            }
            
            public void setVolumeTo(final int n, final int n2, final String s) {
                throw new AssertionError();
            }
            
            public void skipToQueueItem(final long n) {
                throw new AssertionError();
            }
            
            public void stop() throws RemoteException {
                throw new AssertionError();
            }
            
            public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) {
                this.a.f.unregister((IInterface)mediaControllerCallback);
            }
        }
    }
    
    static class MediaSessionImplApi22 extends MediaSessionImplApi21
    {
        MediaSessionImplApi22(final Context context, final String s, final b b, final Bundle bundle) {
            super(context, s, b, bundle);
        }
        
        MediaSessionImplApi22(final Object o) {
            super(o);
        }
        
        @Override
        public void setRatingType(final int ratingType) {
            super.a.setRatingType(ratingType);
        }
    }
    
    static class MediaSessionImplApi28 extends MediaSessionImplApi22
    {
        MediaSessionImplApi28(final Context context, final String s, final b b, final Bundle bundle) {
            super(context, s, b, bundle);
        }
        
        MediaSessionImplApi28(final Object o) {
            super(o);
        }
        
        @Override
        public final m0.b getCurrentControllerInfo() {
            return new m0.b(super.a.getCurrentControllerInfo());
        }
        
        @Override
        public void setCurrentControllerInfo(final m0.b b) {
        }
    }
    
    static class MediaSessionImplApi29 extends MediaSessionImplApi28
    {
        MediaSessionImplApi29(final Context context, final String s, final b b, final Bundle bundle) {
            super(context, s, b, bundle);
        }
        
        MediaSessionImplApi29(final Object o) {
            super(o);
            super.d = ((MediaSession)o).getController().getSessionInfo();
        }
        
        @Override
        public MediaSession createFwkMediaSession(final Context context, final String s, final Bundle bundle) {
            return new MediaSession(context, s, bundle);
        }
    }
    
    public interface OnActiveChangeListener
    {
        void onActiveChanged();
    }
    
    public static final class QueueItem implements Parcelable
    {
        public static final Parcelable$Creator<QueueItem> CREATOR;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat a;
        private final long b;
        private MediaSession$QueueItem c;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<QueueItem>() {
                public QueueItem createFromParcel(final Parcel parcel) {
                    return new QueueItem(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public QueueItem[] newArray(final int n) {
                    return new QueueItem[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        private QueueItem(final MediaSession$QueueItem c, final MediaDescriptionCompat a, final long b) {
            if (a == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (b != -1L) {
                this.a = a;
                this.b = b;
                this.c = c;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        
        QueueItem(final Parcel parcel) {
            this.a = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }
        
        public QueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final long n) {
            this(null, mediaDescriptionCompat, n);
        }
        
        public static QueueItem fromQueueItem(final Object o) {
            if (o != null) {
                final MediaSession$QueueItem mediaSession$QueueItem = (MediaSession$QueueItem)o;
                return new QueueItem(mediaSession$QueueItem, MediaDescriptionCompat.fromMediaDescription(Api21Impl.b(mediaSession$QueueItem)), Api21Impl.c(mediaSession$QueueItem));
            }
            return null;
        }
        
        public static List<QueueItem> fromQueueItemList(final List<?> list) {
            if (list != null) {
                final ArrayList list2 = new ArrayList();
                final Iterator<?> iterator = list.iterator();
                while (iterator.hasNext()) {
                    list2.add(fromQueueItem(iterator.next()));
                }
                return list2;
            }
            return null;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public MediaDescriptionCompat getDescription() {
            return this.a;
        }
        
        public long getQueueId() {
            return this.b;
        }
        
        public Object getQueueItem() {
            MediaSession$QueueItem c;
            if ((c = this.c) == null) {
                c = Api21Impl.a((MediaDescription)this.a.getMediaDescription(), this.b);
                this.c = c;
            }
            return c;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("MediaSession.QueueItem {Description=");
            sb.append(this.a);
            sb.append(", Id=");
            sb.append(this.b);
            sb.append(" }");
            return sb.toString();
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            this.a.writeToParcel(parcel, n);
            parcel.writeLong(this.b);
        }
        
        private static class Api21Impl
        {
            static MediaSession$QueueItem a(final MediaDescription mediaDescription, final long n) {
                return new MediaSession$QueueItem(mediaDescription, n);
            }
            
            static MediaDescription b(final MediaSession$QueueItem mediaSession$QueueItem) {
                return mediaSession$QueueItem.getDescription();
            }
            
            static long c(final MediaSession$QueueItem mediaSession$QueueItem) {
                return mediaSession$QueueItem.getQueueId();
            }
        }
    }
    
    static final class ResultReceiverWrapper implements Parcelable
    {
        public static final Parcelable$Creator<ResultReceiverWrapper> CREATOR;
        ResultReceiver a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<ResultReceiverWrapper>() {
                public ResultReceiverWrapper createFromParcel(final Parcel parcel) {
                    return new ResultReceiverWrapper(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public ResultReceiverWrapper[] newArray(final int n) {
                    return new ResultReceiverWrapper[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        ResultReceiverWrapper(final Parcel parcel) {
            this.a = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
        }
        
        public ResultReceiverWrapper(final ResultReceiver a) {
            this.a = a;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            this.a.writeToParcel(parcel, n);
        }
    }
    
    public static final class Token implements Parcelable
    {
        public static final Parcelable$Creator<Token> CREATOR;
        private final Object a;
        private final Object b;
        private IMediaSession c;
        private b d;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<Token>() {
                public Token createFromParcel(final Parcel parcel) {
                    return new Token(parcel.readParcelable((ClassLoader)null));
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public Token[] newArray(final int n) {
                    return new Token[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        Token(final Object o) {
            this(o, null, null);
        }
        
        Token(final Object o, final IMediaSession mediaSession) {
            this(o, mediaSession, null);
        }
        
        Token(final Object b, final IMediaSession c, final b d) {
            this.a = new Object();
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public static Token fromBundle(final Bundle bundle) {
            final Token token = null;
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(Token.class.getClassLoader());
            final IMediaSession interface1 = IMediaSession.Stub.asInterface(f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
            final b b = b1.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
            final Token token2 = (Token)bundle.getParcelable("android.support.v4.media.session.TOKEN");
            Token token3;
            if (token2 == null) {
                token3 = token;
            }
            else {
                token3 = new Token(token2.b, interface1, b);
            }
            return token3;
        }
        
        public static Token fromToken(final Object o) {
            return fromToken(o, null);
        }
        
        public static Token fromToken(final Object o, final IMediaSession mediaSession) {
            if (o == null) {
                return null;
            }
            if (o instanceof MediaSession$Token) {
                return new Token(o, mediaSession);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }
        
        public int describeContents() {
            return 0;
        }
        
        @Override
        public boolean equals(Object b) {
            boolean b2 = true;
            if (this == b) {
                return true;
            }
            if (!(b instanceof Token)) {
                return false;
            }
            final Token token = (Token)b;
            b = this.b;
            if (b == null) {
                if (token.b != null) {
                    b2 = false;
                }
                return b2;
            }
            final Object b3 = token.b;
            return b3 != null && b.equals(b3);
        }
        
        public IMediaSession getExtraBinder() {
            synchronized (this.a) {
                return this.c;
            }
        }
        
        public b getSession2Token() {
            synchronized (this.a) {
                return this.d;
            }
        }
        
        public Object getToken() {
            return this.b;
        }
        
        @Override
        public int hashCode() {
            final Object b = this.b;
            if (b == null) {
                return 0;
            }
            return b.hashCode();
        }
        
        public void setExtraBinder(final IMediaSession c) {
            synchronized (this.a) {
                this.c = c;
            }
        }
        
        public void setSession2Token(final b d) {
            synchronized (this.a) {
                this.d = d;
            }
        }
        
        public Bundle toBundle() {
            final Bundle bundle = new Bundle();
            bundle.putParcelable("android.support.v4.media.session.TOKEN", (Parcelable)this);
            synchronized (this.a) {
                final IMediaSession c = this.c;
                if (c != null) {
                    f.b(bundle, "android.support.v4.media.session.EXTRA_BINDER", ((IInterface)c).asBinder());
                }
                final b d = this.d;
                if (d != null) {
                    b1.a.c(bundle, "android.support.v4.media.session.SESSION_TOKEN2", d);
                }
                return bundle;
            }
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeParcelable((Parcelable)this.b, n);
        }
    }
}
