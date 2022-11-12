// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media.session;

import android.os.IInterface;
import android.media.Rating;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import b1.a;
import android.media.session.MediaController$TransportControls;
import java.util.Iterator;
import android.os.Parcelable;
import android.media.session.MediaSession$Token;
import java.util.ArrayList;
import java.util.HashMap;
import android.media.session.MediaController;
import android.os.RemoteException;
import android.os.Looper;
import android.media.session.MediaSession$QueueItem;
import android.media.session.PlaybackState;
import android.media.MediaMetadata;
import androidx.media.AudioAttributesCompat;
import android.media.session.MediaController$PlaybackInfo;
import java.lang.ref.WeakReference;
import android.os.Message;
import android.media.session.MediaController$Callback;
import android.os.IBinder$DeathRecipient;
import android.text.TextUtils;
import android.os.ResultReceiver;
import android.util.Log;
import android.os.Handler;
import android.app.PendingIntent;
import b1.b;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.view.KeyEvent;
import android.support.v4.media.MediaDescriptionCompat;
import m0.f;
import android.app.Activity;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

public final class MediaControllerCompat
{
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    private final MediaControllerImpl a;
    private final MediaSessionCompat.Token b;
    private final ConcurrentHashMap<Callback, Boolean> c;
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat.Token b) {
        this.c = new ConcurrentHashMap<Callback, Boolean>();
        if (b != null) {
            this.b = b;
            this.a = (MediaControllerImpl)new MediaControllerImplApi21(context, b);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
    
    public MediaControllerCompat(final Context context, final MediaSessionCompat mediaSessionCompat) {
        this.c = new ConcurrentHashMap<Callback, Boolean>();
        if (mediaSessionCompat != null) {
            final MediaSessionCompat.Token sessionToken = mediaSessionCompat.getSessionToken();
            this.b = sessionToken;
            if (Build$VERSION.SDK_INT >= 29) {
                this.a = (MediaControllerImpl)new MediaControllerImplApi29(context, sessionToken);
            }
            else {
                this.a = (MediaControllerImpl)new MediaControllerImplApi21(context, sessionToken);
            }
            return;
        }
        throw new IllegalArgumentException("session must not be null");
    }
    
    static void a(final String s, final Bundle bundle) {
        if (s == null) {
            return;
        }
        if (s.equals("android.support.v4.media.session.action.FOLLOW") || s.equals("android.support.v4.media.session.action.UNFOLLOW")) {
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                final StringBuilder sb = new StringBuilder();
                sb.append("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action ");
                sb.append(s);
                sb.append(".");
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }
    
    public static MediaControllerCompat getMediaController(final Activity activity) {
        final Object tag = activity.getWindow().getDecorView().getTag(f.a);
        if (tag instanceof MediaControllerCompat) {
            return (MediaControllerCompat)tag;
        }
        return MediaControllerImplApi21.a(activity);
    }
    
    public static void setMediaController(final Activity activity, final MediaControllerCompat mediaControllerCompat) {
        activity.getWindow().getDecorView().setTag(f.a, (Object)mediaControllerCompat);
        MediaControllerImplApi21.d(activity, mediaControllerCompat);
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.a.addQueueItem(mediaDescriptionCompat);
    }
    
    public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
        this.a.addQueueItem(mediaDescriptionCompat, n);
    }
    
    public void adjustVolume(final int n, final int n2) {
        this.a.adjustVolume(n, n2);
    }
    
    public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.a.dispatchMediaButtonEvent(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
    
    public Bundle getExtras() {
        return this.a.getExtras();
    }
    
    public long getFlags() {
        return this.a.getFlags();
    }
    
    public Object getMediaController() {
        return this.a.getMediaController();
    }
    
    public MediaMetadataCompat getMetadata() {
        return this.a.getMetadata();
    }
    
    public String getPackageName() {
        return this.a.getPackageName();
    }
    
    public PlaybackInfo getPlaybackInfo() {
        return this.a.getPlaybackInfo();
    }
    
    public PlaybackStateCompat getPlaybackState() {
        return this.a.getPlaybackState();
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.a.getQueue();
    }
    
    public CharSequence getQueueTitle() {
        return this.a.getQueueTitle();
    }
    
    public int getRatingType() {
        return this.a.getRatingType();
    }
    
    public int getRepeatMode() {
        return this.a.getRepeatMode();
    }
    
    public b getSession2Token() {
        return this.b.getSession2Token();
    }
    
    public PendingIntent getSessionActivity() {
        return this.a.getSessionActivity();
    }
    
    public Bundle getSessionInfo() {
        return this.a.getSessionInfo();
    }
    
    public MediaSessionCompat.Token getSessionToken() {
        return this.b;
    }
    
    public int getShuffleMode() {
        return this.a.getShuffleMode();
    }
    
    public TransportControls getTransportControls() {
        return this.a.getTransportControls();
    }
    
    public boolean isCaptioningEnabled() {
        return this.a.isCaptioningEnabled();
    }
    
    public boolean isSessionReady() {
        return this.a.isSessionReady();
    }
    
    public void registerCallback(final Callback callback) {
        this.registerCallback(callback, null);
    }
    
    public void registerCallback(final Callback callback, final Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.c.putIfAbsent(callback, Boolean.TRUE) != null) {
            Log.w("MediaControllerCompat", "the callback has already been registered");
            return;
        }
        Handler handler2;
        if ((handler2 = handler) == null) {
            handler2 = new Handler();
        }
        callback.b(handler2);
        this.a.registerCallback(callback, handler2);
    }
    
    public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        this.a.removeQueueItem(mediaDescriptionCompat);
    }
    
    @Deprecated
    public void removeQueueItemAt(final int n) {
        final List<MediaSessionCompat.QueueItem> queue = this.getQueue();
        if (queue != null && n >= 0 && n < queue.size()) {
            final MediaSessionCompat.QueueItem queueItem = queue.get(n);
            if (queueItem != null) {
                this.removeQueueItem(queueItem.getDescription());
            }
        }
    }
    
    public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.a.sendCommand(s, bundle, resultReceiver);
            return;
        }
        throw new IllegalArgumentException("command must neither be null nor empty");
    }
    
    public void setVolumeTo(final int n, final int n2) {
        this.a.setVolumeTo(n, n2);
    }
    
    public void unregisterCallback(final Callback callback) {
        if (callback != null) {
            if (this.c.remove(callback) == null) {
                Log.w("MediaControllerCompat", "the callback has never been registered");
                return;
            }
            try {
                this.a.unregisterCallback(callback);
                return;
            }
            finally {
                callback.b(null);
            }
        }
        throw new IllegalArgumentException("callback must not be null");
    }
    
    public abstract static class Callback implements IBinder$DeathRecipient
    {
        final MediaController$Callback a;
        MessageHandler b;
        IMediaControllerCallback c;
        
        public Callback() {
            this.a = new MediaControllerCallbackApi21(this);
        }
        
        void a(final int n, final Object o, final Bundle data) {
            final MessageHandler b = this.b;
            if (b != null) {
                final Message obtainMessage = b.obtainMessage(n, o);
                obtainMessage.setData(data);
                obtainMessage.sendToTarget();
            }
        }
        
        void b(final Handler handler) {
            if (handler == null) {
                final MessageHandler b = this.b;
                if (b != null) {
                    b.a = false;
                    b.removeCallbacksAndMessages((Object)null);
                    this.b = null;
                }
            }
            else {
                final MessageHandler b2 = new MessageHandler(handler.getLooper());
                this.b = b2;
                b2.a = true;
            }
        }
        
        public void binderDied() {
            this.a(8, null, null);
        }
        
        public IMediaControllerCallback getIControllerCallback() {
            return this.c;
        }
        
        public void onAudioInfoChanged(final PlaybackInfo playbackInfo) {
        }
        
        public void onCaptioningEnabledChanged(final boolean b) {
        }
        
        public void onExtrasChanged(final Bundle bundle) {
        }
        
        public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) {
        }
        
        public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) {
        }
        
        public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) {
        }
        
        public void onQueueTitleChanged(final CharSequence charSequence) {
        }
        
        public void onRepeatModeChanged(final int n) {
        }
        
        public void onSessionDestroyed() {
        }
        
        public void onSessionEvent(final String s, final Bundle bundle) {
        }
        
        public void onSessionReady() {
        }
        
        public void onShuffleModeChanged(final int n) {
        }
        
        private static class MediaControllerCallbackApi21 extends MediaController$Callback
        {
            private final WeakReference<Callback> a;
            
            MediaControllerCallbackApi21(final Callback callback) {
                this.a = new WeakReference<Callback>(callback);
            }
            
            public void onAudioInfoChanged(final MediaController$PlaybackInfo mediaController$PlaybackInfo) {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onAudioInfoChanged(new PlaybackInfo(mediaController$PlaybackInfo.getPlaybackType(), AudioAttributesCompat.d(mediaController$PlaybackInfo.getAudioAttributes()), mediaController$PlaybackInfo.getVolumeControl(), mediaController$PlaybackInfo.getMaxVolume(), mediaController$PlaybackInfo.getCurrentVolume()));
                }
            }
            
            public void onExtrasChanged(final Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onExtrasChanged(bundle);
                }
            }
            
            public void onMetadataChanged(final MediaMetadata mediaMetadata) {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(mediaMetadata));
                }
            }
            
            public void onPlaybackStateChanged(final PlaybackState playbackState) {
                final Callback callback = this.a.get();
                if (callback != null) {
                    if (callback.c == null) {
                        callback.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(playbackState));
                    }
                }
            }
            
            public void onQueueChanged(final List<MediaSession$QueueItem> list) {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(list));
                }
            }
            
            public void onQueueTitleChanged(final CharSequence charSequence) {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onQueueTitleChanged(charSequence);
                }
            }
            
            public void onSessionDestroyed() {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.onSessionDestroyed();
                }
            }
            
            public void onSessionEvent(final String s, final Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                final Callback callback = this.a.get();
                if (callback != null) {
                    final IMediaControllerCallback c = callback.c;
                    callback.onSessionEvent(s, bundle);
                }
            }
        }
        
        private class MessageHandler extends Handler
        {
            boolean a;
            final Callback b;
            
            MessageHandler(final Callback b, final Looper looper) {
                this.b = b;
                super(looper);
                this.a = false;
            }
            
            public void handleMessage(final Message message) {
                if (!this.a) {
                    return;
                }
                switch (message.what) {
                    case 13: {
                        this.b.onSessionReady();
                        break;
                    }
                    case 12: {
                        this.b.onShuffleModeChanged((int)message.obj);
                        break;
                    }
                    case 11: {
                        this.b.onCaptioningEnabledChanged((boolean)message.obj);
                        break;
                    }
                    case 9: {
                        this.b.onRepeatModeChanged((int)message.obj);
                        break;
                    }
                    case 8: {
                        this.b.onSessionDestroyed();
                        break;
                    }
                    case 7: {
                        final Bundle bundle = (Bundle)message.obj;
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.b.onExtrasChanged(bundle);
                        break;
                    }
                    case 6: {
                        this.b.onQueueTitleChanged((CharSequence)message.obj);
                        break;
                    }
                    case 5: {
                        this.b.onQueueChanged((List<MediaSessionCompat.QueueItem>)message.obj);
                        break;
                    }
                    case 4: {
                        this.b.onAudioInfoChanged((PlaybackInfo)message.obj);
                        break;
                    }
                    case 3: {
                        this.b.onMetadataChanged((MediaMetadataCompat)message.obj);
                        break;
                    }
                    case 2: {
                        this.b.onPlaybackStateChanged((PlaybackStateCompat)message.obj);
                        break;
                    }
                    case 1: {
                        final Bundle data = message.getData();
                        MediaSessionCompat.ensureClassLoader(data);
                        this.b.onSessionEvent((String)message.obj, data);
                        break;
                    }
                }
            }
        }
        
        private static class StubCompat extends Stub
        {
            private final WeakReference<Callback> a;
            
            StubCompat(final Callback callback) {
                this.a = new WeakReference<Callback>(callback);
            }
            
            public void onCaptioningEnabledChanged(final boolean b) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(11, b, null);
                }
            }
            
            public void onEvent(final String s, final Bundle bundle) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(1, s, bundle);
                }
            }
            
            public void onExtrasChanged(final Bundle bundle) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(7, bundle, null);
                }
            }
            
            public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(3, mediaMetadataCompat, null);
                }
            }
            
            public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(2, playbackStateCompat, null);
                }
            }
            
            public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(5, list, null);
                }
            }
            
            public void onQueueTitleChanged(final CharSequence charSequence) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(6, charSequence, null);
                }
            }
            
            public void onRepeatModeChanged(final int n) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(9, n, null);
                }
            }
            
            public void onSessionDestroyed() throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(8, null, null);
                }
            }
            
            public void onSessionReady() throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(13, null, null);
                }
            }
            
            public void onShuffleModeChanged(final int n) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    callback.a(12, n, null);
                }
            }
            
            public void onShuffleModeChangedRemoved(final boolean b) throws RemoteException {
            }
            
            public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                final Callback callback = this.a.get();
                if (callback != null) {
                    PlaybackInfo playbackInfo;
                    if (parcelableVolumeInfo != null) {
                        playbackInfo = new PlaybackInfo(parcelableVolumeInfo.volumeType, parcelableVolumeInfo.audioStream, parcelableVolumeInfo.controlType, parcelableVolumeInfo.maxVolume, parcelableVolumeInfo.currentVolume);
                    }
                    else {
                        playbackInfo = null;
                    }
                    callback.a(4, playbackInfo, null);
                }
            }
        }
    }
    
    interface MediaControllerImpl
    {
        void addQueueItem(final MediaDescriptionCompat p0);
        
        void addQueueItem(final MediaDescriptionCompat p0, final int p1);
        
        void adjustVolume(final int p0, final int p1);
        
        boolean dispatchMediaButtonEvent(final KeyEvent p0);
        
        Bundle getExtras();
        
        long getFlags();
        
        Object getMediaController();
        
        MediaMetadataCompat getMetadata();
        
        String getPackageName();
        
        PlaybackInfo getPlaybackInfo();
        
        PlaybackStateCompat getPlaybackState();
        
        List<MediaSessionCompat.QueueItem> getQueue();
        
        CharSequence getQueueTitle();
        
        int getRatingType();
        
        int getRepeatMode();
        
        PendingIntent getSessionActivity();
        
        Bundle getSessionInfo();
        
        int getShuffleMode();
        
        TransportControls getTransportControls();
        
        boolean isCaptioningEnabled();
        
        boolean isSessionReady();
        
        void registerCallback(final Callback p0, final Handler p1);
        
        void removeQueueItem(final MediaDescriptionCompat p0);
        
        void sendCommand(final String p0, final Bundle p1, final ResultReceiver p2);
        
        void setVolumeTo(final int p0, final int p1);
        
        void unregisterCallback(final Callback p0);
    }
    
    static class MediaControllerImplApi21 implements MediaControllerImpl
    {
        protected final MediaController a;
        final Object b;
        private final List<Callback> c;
        private HashMap<Callback, ExtraCallback> d;
        protected Bundle e;
        final MediaSessionCompat.Token f;
        
        MediaControllerImplApi21(final Context context, final MediaSessionCompat.Token f) {
            this.b = new Object();
            this.c = new ArrayList<Callback>();
            this.d = new HashMap<Callback, ExtraCallback>();
            this.f = f;
            this.a = new MediaController(context, (MediaSession$Token)f.getToken());
            if (f.getExtraBinder() == null) {
                this.c();
            }
        }
        
        static MediaControllerCompat a(final Activity activity) {
            final MediaController mediaController = activity.getMediaController();
            if (mediaController == null) {
                return null;
            }
            return new MediaControllerCompat((Context)activity, MediaSessionCompat.Token.fromToken(mediaController.getSessionToken()));
        }
        
        private void c() {
            this.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }
        
        static void d(final Activity activity, final MediaControllerCompat mediaControllerCompat) {
            MediaController mediaController;
            if (mediaControllerCompat != null) {
                mediaController = new MediaController((Context)activity, (MediaSession$Token)mediaControllerCompat.getSessionToken().getToken());
            }
            else {
                mediaController = null;
            }
            activity.setMediaController(mediaController);
        }
        
        @Override
        public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
            if ((this.getFlags() & 0x4L) != 0x0L) {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
                this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
        
        @Override
        public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
            if ((this.getFlags() & 0x4L) != 0x0L) {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
                bundle.putInt("android.support.v4.media.session.command.ARGUMENT_INDEX", n);
                this.sendCommand("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
        
        @Override
        public void adjustVolume(final int n, final int n2) {
            this.a.adjustVolume(n, n2);
        }
        
        void b() {
            if (this.f.getExtraBinder() == null) {
                return;
            }
            for (final Callback callback : this.c) {
                final ExtraCallback c = new ExtraCallback(callback);
                this.d.put(callback, c);
                callback.c = c;
                try {
                    this.f.getExtraBinder().registerCallbackListener(c);
                    callback.a(13, null, null);
                    continue;
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
                }
                break;
            }
            this.c.clear();
        }
        
        @Override
        public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
            return this.a.dispatchMediaButtonEvent(keyEvent);
        }
        
        @Override
        public Bundle getExtras() {
            return this.a.getExtras();
        }
        
        @Override
        public long getFlags() {
            return this.a.getFlags();
        }
        
        @Override
        public Object getMediaController() {
            return this.a;
        }
        
        @Override
        public MediaMetadataCompat getMetadata() {
            final MediaMetadata metadata = this.a.getMetadata();
            MediaMetadataCompat fromMediaMetadata;
            if (metadata != null) {
                fromMediaMetadata = MediaMetadataCompat.fromMediaMetadata(metadata);
            }
            else {
                fromMediaMetadata = null;
            }
            return fromMediaMetadata;
        }
        
        @Override
        public String getPackageName() {
            return this.a.getPackageName();
        }
        
        @Override
        public PlaybackInfo getPlaybackInfo() {
            final MediaController$PlaybackInfo playbackInfo = this.a.getPlaybackInfo();
            Object o;
            if (playbackInfo != null) {
                o = new PlaybackInfo(playbackInfo.getPlaybackType(), AudioAttributesCompat.d(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            }
            else {
                o = null;
            }
            return (PlaybackInfo)o;
        }
        
        @Override
        public PlaybackStateCompat getPlaybackState() {
            if (this.f.getExtraBinder() != null) {
                try {
                    return this.f.getExtraBinder().getPlaybackState();
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", (Throwable)ex);
                }
            }
            final PlaybackState playbackState = this.a.getPlaybackState();
            PlaybackStateCompat fromPlaybackState;
            if (playbackState != null) {
                fromPlaybackState = PlaybackStateCompat.fromPlaybackState(playbackState);
            }
            else {
                fromPlaybackState = null;
            }
            return fromPlaybackState;
        }
        
        @Override
        public List<MediaSessionCompat.QueueItem> getQueue() {
            final List queue = this.a.getQueue();
            List<MediaSessionCompat.QueueItem> fromQueueItemList;
            if (queue != null) {
                fromQueueItemList = MediaSessionCompat.QueueItem.fromQueueItemList(queue);
            }
            else {
                fromQueueItemList = null;
            }
            return fromQueueItemList;
        }
        
        @Override
        public CharSequence getQueueTitle() {
            return this.a.getQueueTitle();
        }
        
        @Override
        public int getRatingType() {
            return this.a.getRatingType();
        }
        
        @Override
        public int getRepeatMode() {
            if (this.f.getExtraBinder() != null) {
                try {
                    return this.f.getExtraBinder().getRepeatMode();
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", (Throwable)ex);
                }
            }
            return -1;
        }
        
        @Override
        public PendingIntent getSessionActivity() {
            return this.a.getSessionActivity();
        }
        
        @Override
        public Bundle getSessionInfo() {
            if (this.e != null) {
                return new Bundle(this.e);
            }
            if (this.f.getExtraBinder() != null) {
                try {
                    this.e = this.f.getExtraBinder().getSessionInfo();
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getSessionInfo.", (Throwable)ex);
                    this.e = Bundle.EMPTY;
                }
            }
            Bundle empty;
            if ((this.e = MediaSessionCompat.unparcelWithClassLoader(this.e)) == null) {
                empty = Bundle.EMPTY;
            }
            else {
                empty = new Bundle(this.e);
            }
            return empty;
        }
        
        @Override
        public int getShuffleMode() {
            if (this.f.getExtraBinder() != null) {
                try {
                    return this.f.getExtraBinder().getShuffleMode();
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", (Throwable)ex);
                }
            }
            return -1;
        }
        
        @Override
        public TransportControls getTransportControls() {
            final MediaController$TransportControls transportControls = this.a.getTransportControls();
            if (Build$VERSION.SDK_INT >= 29) {
                return new TransportControlsApi29(transportControls);
            }
            return new TransportControlsApi24(transportControls);
        }
        
        @Override
        public boolean isCaptioningEnabled() {
            if (this.f.getExtraBinder() != null) {
                try {
                    return this.f.getExtraBinder().isCaptioningEnabled();
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", (Throwable)ex);
                }
            }
            return false;
        }
        
        @Override
        public boolean isSessionReady() {
            return this.f.getExtraBinder() != null;
        }
        
        @Override
        public final void registerCallback(final Callback callback, final Handler handler) {
            this.a.registerCallback(callback.a, handler);
            synchronized (this.b) {
                if (this.f.getExtraBinder() != null) {
                    final ExtraCallback c = new ExtraCallback(callback);
                    this.d.put(callback, c);
                    callback.c = c;
                    try {
                        this.f.getExtraBinder().registerCallbackListener(c);
                        callback.a(13, null, null);
                    }
                    catch (final RemoteException ex) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
                    }
                }
                else {
                    callback.c = null;
                    this.c.add(callback);
                }
            }
        }
        
        @Override
        public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
            if ((this.getFlags() & 0x4L) != 0x0L) {
                final Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION", (Parcelable)mediaDescriptionCompat);
                this.sendCommand("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM", bundle, null);
                return;
            }
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }
        
        @Override
        public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
            this.a.sendCommand(s, bundle, resultReceiver);
        }
        
        @Override
        public void setVolumeTo(final int n, final int n2) {
            this.a.setVolumeTo(n, n2);
        }
        
        @Override
        public final void unregisterCallback(final Callback callback) {
            this.a.unregisterCallback(callback.a);
            synchronized (this.b) {
                if (this.f.getExtraBinder() != null) {
                    try {
                        final ExtraCallback extraCallback = this.d.remove(callback);
                        if (extraCallback != null) {
                            callback.c = null;
                            this.f.getExtraBinder().unregisterCallbackListener(extraCallback);
                        }
                    }
                    catch (final RemoteException ex) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", (Throwable)ex);
                    }
                }
                else {
                    this.c.remove(callback);
                }
            }
        }
        
        private static class ExtraBinderRequestResultReceiver extends ResultReceiver
        {
            private WeakReference<MediaControllerImplApi21> a;
            
            ExtraBinderRequestResultReceiver(final MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler)null);
                this.a = new WeakReference<MediaControllerImplApi21>(mediaControllerImplApi21);
            }
            
            protected void onReceiveResult(final int n, final Bundle bundle) {
                final MediaControllerImplApi21 mediaControllerImplApi21 = this.a.get();
                if (mediaControllerImplApi21 != null) {
                    if (bundle != null) {
                        synchronized (mediaControllerImplApi21.b) {
                            mediaControllerImplApi21.f.setExtraBinder(IMediaSession.Stub.asInterface(androidx.core.app.f.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                            mediaControllerImplApi21.f.setSession2Token(b1.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                            mediaControllerImplApi21.b();
                        }
                    }
                }
            }
        }
        
        private static class ExtraCallback extends StubCompat
        {
            ExtraCallback(final Callback callback) {
                super(callback);
            }
            
            @Override
            public void onExtrasChanged(final Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
            
            @Override
            public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }
            
            @Override
            public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }
            
            @Override
            public void onQueueTitleChanged(final CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }
            
            @Override
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }
            
            @Override
            public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }
    
    static class MediaControllerImplApi29 extends MediaControllerImplApi21
    {
        MediaControllerImplApi29(final Context context, final MediaSessionCompat.Token token) {
            super(context, token);
        }
        
        @Override
        public Bundle getSessionInfo() {
            if (super.e != null) {
                return new Bundle(super.e);
            }
            final Bundle sessionInfo = super.a.getSessionInfo();
            super.e = sessionInfo;
            Bundle empty;
            if ((super.e = MediaSessionCompat.unparcelWithClassLoader(sessionInfo)) == null) {
                empty = Bundle.EMPTY;
            }
            else {
                empty = new Bundle(super.e);
            }
            return empty;
        }
    }
    
    static class MediaControllerImplBase implements MediaControllerImpl
    {
        private IMediaSession a;
        private TransportControls b;
        private Bundle c;
        
        @Override
        public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.a.getFlags() & 0x4L) == 0x0L) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.a.addQueueItem(mediaDescriptionCompat);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItem.", (Throwable)ex);
            }
        }
        
        @Override
        public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int n) {
            try {
                if ((this.a.getFlags() & 0x4L) == 0x0L) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.a.addQueueItemAt(mediaDescriptionCompat, n);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in addQueueItemAt.", (Throwable)ex);
            }
        }
        
        @Override
        public void adjustVolume(final int n, final int n2) {
            try {
                this.a.adjustVolume(n, n2, null);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in adjustVolume.", (Throwable)ex);
            }
        }
        
        @Override
        public boolean dispatchMediaButtonEvent(final KeyEvent keyEvent) {
            if (keyEvent != null) {
                try {
                    this.a.sendMediaButton(keyEvent);
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", (Throwable)ex);
                }
                return false;
            }
            throw new IllegalArgumentException("event may not be null.");
        }
        
        @Override
        public Bundle getExtras() {
            try {
                return this.a.getExtras();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getExtras.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public long getFlags() {
            try {
                return this.a.getFlags();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getFlags.", (Throwable)ex);
                return 0L;
            }
        }
        
        @Override
        public Object getMediaController() {
            return null;
        }
        
        @Override
        public MediaMetadataCompat getMetadata() {
            try {
                return this.a.getMetadata();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public String getPackageName() {
            try {
                return this.a.getPackageName();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPackageName.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public PlaybackInfo getPlaybackInfo() {
            try {
                final ParcelableVolumeInfo volumeAttributes = this.a.getVolumeAttributes();
                return new PlaybackInfo(volumeAttributes.volumeType, volumeAttributes.audioStream, volumeAttributes.controlType, volumeAttributes.maxVolume, volumeAttributes.currentVolume);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public PlaybackStateCompat getPlaybackState() {
            try {
                return this.a.getPlaybackState();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public List<MediaSessionCompat.QueueItem> getQueue() {
            try {
                return this.a.getQueue();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getQueue.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public CharSequence getQueueTitle() {
            try {
                return this.a.getQueueTitle();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getQueueTitle.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public int getRatingType() {
            try {
                return this.a.getRatingType();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getRatingType.", (Throwable)ex);
                return 0;
            }
        }
        
        @Override
        public int getRepeatMode() {
            try {
                return this.a.getRepeatMode();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getRepeatMode.", (Throwable)ex);
                return -1;
            }
        }
        
        @Override
        public PendingIntent getSessionActivity() {
            try {
                return this.a.getLaunchPendingIntent();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", (Throwable)ex);
                return null;
            }
        }
        
        @Override
        public Bundle getSessionInfo() {
            try {
                this.c = this.a.getSessionInfo();
            }
            catch (final RemoteException ex) {
                Log.d("MediaControllerCompat", "Dead object in getSessionInfo.", (Throwable)ex);
            }
            final Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(this.c);
            this.c = unparcelWithClassLoader;
            Bundle empty;
            if (unparcelWithClassLoader == null) {
                empty = Bundle.EMPTY;
            }
            else {
                empty = new Bundle(this.c);
            }
            return empty;
        }
        
        @Override
        public int getShuffleMode() {
            try {
                return this.a.getShuffleMode();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in getShuffleMode.", (Throwable)ex);
                return -1;
            }
        }
        
        @Override
        public TransportControls getTransportControls() {
            if (this.b == null) {
                this.b = new TransportControlsBase(this.a);
            }
            return this.b;
        }
        
        @Override
        public boolean isCaptioningEnabled() {
            try {
                return this.a.isCaptioningEnabled();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in isCaptioningEnabled.", (Throwable)ex);
                return false;
            }
        }
        
        @Override
        public boolean isSessionReady() {
            return true;
        }
        
        @Override
        public void registerCallback(final Callback callback, final Handler handler) {
            if (callback != null) {
                try {
                    ((IInterface)this.a).asBinder().linkToDeath((IBinder$DeathRecipient)callback, 0);
                    this.a.registerCallbackListener(callback.c);
                    callback.a(13, null, null);
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)ex);
                    callback.a(8, null, null);
                }
                return;
            }
            throw new IllegalArgumentException("callback may not be null.");
        }
        
        @Override
        public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.a.getFlags() & 0x4L) == 0x0L) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.a.removeQueueItem(mediaDescriptionCompat);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in removeQueueItem.", (Throwable)ex);
            }
        }
        
        @Override
        public void sendCommand(final String s, final Bundle bundle, final ResultReceiver resultReceiver) {
            try {
                final IMediaSession a = this.a;
                MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper;
                if (resultReceiver == null) {
                    resultReceiverWrapper = null;
                }
                else {
                    resultReceiverWrapper = new MediaSessionCompat.ResultReceiverWrapper(resultReceiver);
                }
                a.sendCommand(s, bundle, resultReceiverWrapper);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in sendCommand.", (Throwable)ex);
            }
        }
        
        @Override
        public void setVolumeTo(final int n, final int n2) {
            try {
                this.a.setVolumeTo(n, n2, null);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setVolumeTo.", (Throwable)ex);
            }
        }
        
        @Override
        public void unregisterCallback(final Callback callback) {
            if (callback != null) {
                try {
                    this.a.unregisterCallbackListener(callback.c);
                    ((IInterface)this.a).asBinder().unlinkToDeath((IBinder$DeathRecipient)callback, 0);
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", (Throwable)ex);
                }
                return;
            }
            throw new IllegalArgumentException("callback may not be null.");
        }
    }
    
    public static final class PlaybackInfo
    {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int a;
        private final AudioAttributesCompat b;
        private final int c;
        private final int d;
        private final int e;
        
        PlaybackInfo(final int n, final int n2, final int n3, final int n4, final int n5) {
            this(n, new AudioAttributesCompat.a().b(n2).a(), n3, n4, n5);
        }
        
        PlaybackInfo(final int a, final AudioAttributesCompat b, final int c, final int d, final int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        public AudioAttributesCompat getAudioAttributes() {
            return this.b;
        }
        
        @Deprecated
        public int getAudioStream() {
            return this.b.a();
        }
        
        public int getCurrentVolume() {
            return this.e;
        }
        
        public int getMaxVolume() {
            return this.d;
        }
        
        public int getPlaybackType() {
            return this.a;
        }
        
        public int getVolumeControl() {
            return this.c;
        }
    }
    
    public abstract static class TransportControls
    {
        @Deprecated
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";
        
        TransportControls() {
        }
        
        public abstract void fastForward();
        
        public abstract void pause();
        
        public abstract void play();
        
        public abstract void playFromMediaId(final String p0, final Bundle p1);
        
        public abstract void playFromSearch(final String p0, final Bundle p1);
        
        public abstract void playFromUri(final Uri p0, final Bundle p1);
        
        public abstract void prepare();
        
        public abstract void prepareFromMediaId(final String p0, final Bundle p1);
        
        public abstract void prepareFromSearch(final String p0, final Bundle p1);
        
        public abstract void prepareFromUri(final Uri p0, final Bundle p1);
        
        public abstract void rewind();
        
        public abstract void seekTo(final long p0);
        
        public abstract void sendCustomAction(final PlaybackStateCompat.CustomAction p0, final Bundle p1);
        
        public abstract void sendCustomAction(final String p0, final Bundle p1);
        
        public abstract void setCaptioningEnabled(final boolean p0);
        
        public void setPlaybackSpeed(final float n) {
        }
        
        public abstract void setRating(final RatingCompat p0);
        
        public abstract void setRating(final RatingCompat p0, final Bundle p1);
        
        public abstract void setRepeatMode(final int p0);
        
        public abstract void setShuffleMode(final int p0);
        
        public abstract void skipToNext();
        
        public abstract void skipToPrevious();
        
        public abstract void skipToQueueItem(final long p0);
        
        public abstract void stop();
    }
    
    static class TransportControlsApi21 extends TransportControls
    {
        protected final MediaController$TransportControls a;
        
        TransportControlsApi21(final MediaController$TransportControls a) {
            this.a = a;
        }
        
        @Override
        public void fastForward() {
            this.a.fastForward();
        }
        
        @Override
        public void pause() {
            this.a.pause();
        }
        
        @Override
        public void play() {
            this.a.play();
        }
        
        @Override
        public void playFromMediaId(final String s, final Bundle bundle) {
            this.a.playFromMediaId(s, bundle);
        }
        
        @Override
        public void playFromSearch(final String s, final Bundle bundle) {
            this.a.playFromSearch(s, bundle);
        }
        
        @Override
        public void playFromUri(final Uri uri, final Bundle bundle) {
            if (uri != null && !Uri.EMPTY.equals((Object)uri)) {
                final Bundle bundle2 = new Bundle();
                bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
                bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
                this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", bundle2);
                return;
            }
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }
        
        @Override
        public void prepare() {
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE", null);
        }
        
        @Override
        public void prepareFromMediaId(final String s, final Bundle bundle) {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID", s);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID", bundle2);
        }
        
        @Override
        public void prepareFromSearch(final String s, final Bundle bundle) {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.v4.media.session.action.ARGUMENT_QUERY", s);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_SEARCH", bundle2);
        }
        
        @Override
        public void prepareFromUri(final Uri uri, final Bundle bundle) {
            final Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", (Parcelable)uri);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            this.sendCustomAction("android.support.v4.media.session.action.PREPARE_FROM_URI", bundle2);
        }
        
        @Override
        public void rewind() {
            this.a.rewind();
        }
        
        @Override
        public void seekTo(final long n) {
            this.a.seekTo(n);
        }
        
        @Override
        public void sendCustomAction(final PlaybackStateCompat.CustomAction customAction, final Bundle bundle) {
            MediaControllerCompat.a(customAction.getAction(), bundle);
            this.a.sendCustomAction(customAction.getAction(), bundle);
        }
        
        @Override
        public void sendCustomAction(final String s, final Bundle bundle) {
            MediaControllerCompat.a(s, bundle);
            this.a.sendCustomAction(s, bundle);
        }
        
        @Override
        public void setCaptioningEnabled(final boolean b) {
            final Bundle bundle = new Bundle();
            bundle.putBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED", b);
            this.sendCustomAction("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED", bundle);
        }
        
        @Override
        public void setPlaybackSpeed(final float n) {
            if (n != 0.0f) {
                final Bundle bundle = new Bundle();
                bundle.putFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", n);
                this.sendCustomAction("android.support.v4.media.session.action.SET_PLAYBACK_SPEED", bundle);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
        
        @Override
        public void setRating(final RatingCompat ratingCompat) {
            final MediaController$TransportControls a = this.a;
            Rating rating;
            if (ratingCompat != null) {
                rating = (Rating)ratingCompat.getRating();
            }
            else {
                rating = null;
            }
            a.setRating(rating);
        }
        
        @Override
        public void setRating(final RatingCompat ratingCompat, final Bundle bundle) {
            final Bundle bundle2 = new Bundle();
            bundle2.putParcelable("android.support.v4.media.session.action.ARGUMENT_RATING", (Parcelable)ratingCompat);
            bundle2.putBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS", bundle);
            this.sendCustomAction("android.support.v4.media.session.action.SET_RATING", bundle2);
        }
        
        @Override
        public void setRepeatMode(final int n) {
            final Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", n);
            this.sendCustomAction("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }
        
        @Override
        public void setShuffleMode(final int n) {
            final Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", n);
            this.sendCustomAction("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }
        
        @Override
        public void skipToNext() {
            this.a.skipToNext();
        }
        
        @Override
        public void skipToPrevious() {
            this.a.skipToPrevious();
        }
        
        @Override
        public void skipToQueueItem(final long n) {
            this.a.skipToQueueItem(n);
        }
        
        @Override
        public void stop() {
            this.a.stop();
        }
    }
    
    static class TransportControlsApi23 extends TransportControlsApi21
    {
        TransportControlsApi23(final MediaController$TransportControls mediaController$TransportControls) {
            super(mediaController$TransportControls);
        }
        
        @Override
        public void playFromUri(final Uri uri, final Bundle bundle) {
            super.a.playFromUri(uri, bundle);
        }
    }
    
    static class TransportControlsApi24 extends TransportControlsApi23
    {
        TransportControlsApi24(final MediaController$TransportControls mediaController$TransportControls) {
            super(mediaController$TransportControls);
        }
        
        @Override
        public void prepare() {
            super.a.prepare();
        }
        
        @Override
        public void prepareFromMediaId(final String s, final Bundle bundle) {
            super.a.prepareFromMediaId(s, bundle);
        }
        
        @Override
        public void prepareFromSearch(final String s, final Bundle bundle) {
            super.a.prepareFromSearch(s, bundle);
        }
        
        @Override
        public void prepareFromUri(final Uri uri, final Bundle bundle) {
            super.a.prepareFromUri(uri, bundle);
        }
    }
    
    static class TransportControlsApi29 extends TransportControlsApi24
    {
        TransportControlsApi29(final MediaController$TransportControls mediaController$TransportControls) {
            super(mediaController$TransportControls);
        }
        
        @Override
        public void setPlaybackSpeed(final float playbackSpeed) {
            if (playbackSpeed != 0.0f) {
                super.a.setPlaybackSpeed(playbackSpeed);
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
    }
    
    static class TransportControlsBase extends TransportControls
    {
        private IMediaSession a;
        
        public TransportControlsBase(final IMediaSession a) {
            this.a = a;
        }
        
        @Override
        public void fastForward() {
            try {
                this.a.fastForward();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in fastForward.", (Throwable)ex);
            }
        }
        
        @Override
        public void pause() {
            try {
                this.a.pause();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in pause.", (Throwable)ex);
            }
        }
        
        @Override
        public void play() {
            try {
                this.a.play();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in play.", (Throwable)ex);
            }
        }
        
        @Override
        public void playFromMediaId(final String s, final Bundle bundle) {
            try {
                this.a.playFromMediaId(s, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in playFromMediaId.", (Throwable)ex);
            }
        }
        
        @Override
        public void playFromSearch(final String s, final Bundle bundle) {
            try {
                this.a.playFromSearch(s, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in playFromSearch.", (Throwable)ex);
            }
        }
        
        @Override
        public void playFromUri(final Uri uri, final Bundle bundle) {
            try {
                this.a.playFromUri(uri, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in playFromUri.", (Throwable)ex);
            }
        }
        
        @Override
        public void prepare() {
            try {
                this.a.prepare();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in prepare.", (Throwable)ex);
            }
        }
        
        @Override
        public void prepareFromMediaId(final String s, final Bundle bundle) {
            try {
                this.a.prepareFromMediaId(s, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromMediaId.", (Throwable)ex);
            }
        }
        
        @Override
        public void prepareFromSearch(final String s, final Bundle bundle) {
            try {
                this.a.prepareFromSearch(s, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromSearch.", (Throwable)ex);
            }
        }
        
        @Override
        public void prepareFromUri(final Uri uri, final Bundle bundle) {
            try {
                this.a.prepareFromUri(uri, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in prepareFromUri.", (Throwable)ex);
            }
        }
        
        @Override
        public void rewind() {
            try {
                this.a.rewind();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in rewind.", (Throwable)ex);
            }
        }
        
        @Override
        public void seekTo(final long n) {
            try {
                this.a.seekTo(n);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in seekTo.", (Throwable)ex);
            }
        }
        
        @Override
        public void sendCustomAction(final PlaybackStateCompat.CustomAction customAction, final Bundle bundle) {
            this.sendCustomAction(customAction.getAction(), bundle);
        }
        
        @Override
        public void sendCustomAction(final String s, final Bundle bundle) {
            MediaControllerCompat.a(s, bundle);
            try {
                this.a.sendCustomAction(s, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in sendCustomAction.", (Throwable)ex);
            }
        }
        
        @Override
        public void setCaptioningEnabled(final boolean captioningEnabled) {
            try {
                this.a.setCaptioningEnabled(captioningEnabled);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setCaptioningEnabled.", (Throwable)ex);
            }
        }
        
        @Override
        public void setPlaybackSpeed(final float playbackSpeed) {
            if (playbackSpeed != 0.0f) {
                try {
                    this.a.setPlaybackSpeed(playbackSpeed);
                }
                catch (final RemoteException ex) {
                    Log.e("MediaControllerCompat", "Dead object in setPlaybackSpeed.", (Throwable)ex);
                }
                return;
            }
            throw new IllegalArgumentException("speed must not be zero");
        }
        
        @Override
        public void setRating(final RatingCompat ratingCompat) {
            try {
                this.a.rate(ratingCompat);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", (Throwable)ex);
            }
        }
        
        @Override
        public void setRating(final RatingCompat ratingCompat, final Bundle bundle) {
            try {
                this.a.rateWithExtras(ratingCompat, bundle);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setRating.", (Throwable)ex);
            }
        }
        
        @Override
        public void setRepeatMode(final int repeatMode) {
            try {
                this.a.setRepeatMode(repeatMode);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setRepeatMode.", (Throwable)ex);
            }
        }
        
        @Override
        public void setShuffleMode(final int shuffleMode) {
            try {
                this.a.setShuffleMode(shuffleMode);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in setShuffleMode.", (Throwable)ex);
            }
        }
        
        @Override
        public void skipToNext() {
            try {
                this.a.next();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in skipToNext.", (Throwable)ex);
            }
        }
        
        @Override
        public void skipToPrevious() {
            try {
                this.a.previous();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in skipToPrevious.", (Throwable)ex);
            }
        }
        
        @Override
        public void skipToQueueItem(final long n) {
            try {
                this.a.skipToQueueItem(n);
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in skipToQueueItem.", (Throwable)ex);
            }
        }
        
        @Override
        public void stop() {
            try {
                this.a.stop();
            }
            catch (final RemoteException ex) {
                Log.e("MediaControllerCompat", "Dead object in stop.", (Throwable)ex);
            }
        }
    }
}
