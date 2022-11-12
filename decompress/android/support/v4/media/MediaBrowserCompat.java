// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import java.util.Collections;
import android.os.Binder;
import android.media.browse.MediaBrowser$SubscriptionCallback;
import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import java.util.Iterator;
import java.util.Map;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.session.IMediaSession;
import androidx.core.app.f;
import android.os.RemoteException;
import android.os.Process;
import androidx.collection.a;
import android.media.browse.MediaBrowser;
import android.os.Parcelable;
import android.media.browse.MediaBrowser$ItemCallback;
import android.support.v4.os.ResultReceiver;
import android.media.browse.MediaBrowser$ConnectionCallback;
import android.os.BadParcelableException;
import java.util.List;
import android.os.Message;
import android.os.Messenger;
import java.lang.ref.WeakReference;
import android.os.Handler;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser$MediaItem;
import android.text.TextUtils;
import android.support.v4.media.session.MediaSessionCompat;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

public final class MediaBrowserCompat
{
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final boolean b;
    private final MediaBrowserImpl a;
    
    static {
        b = Log.isLoggable("MediaBrowserCompat", 3);
    }
    
    public MediaBrowserCompat(final Context context, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
        this.a = (MediaBrowserImpl)new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
    }
    
    public void connect() {
        Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.a.connect();
    }
    
    public void disconnect() {
        this.a.disconnect();
    }
    
    public Bundle getExtras() {
        return this.a.getExtras();
    }
    
    public void getItem(final String s, final ItemCallback itemCallback) {
        this.a.getItem(s, itemCallback);
    }
    
    public Bundle getNotifyChildrenChangedOptions() {
        return this.a.getNotifyChildrenChangedOptions();
    }
    
    public String getRoot() {
        return this.a.getRoot();
    }
    
    public ComponentName getServiceComponent() {
        return this.a.getServiceComponent();
    }
    
    public MediaSessionCompat.Token getSessionToken() {
        return this.a.getSessionToken();
    }
    
    public boolean isConnected() {
        return this.a.isConnected();
    }
    
    public void search(final String s, final Bundle bundle, final SearchCallback searchCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback != null) {
            this.a.search(s, bundle, searchCallback);
            return;
        }
        throw new IllegalArgumentException("callback cannot be null");
    }
    
    public void sendCustomAction(final String s, final Bundle bundle, final CustomActionCallback customActionCallback) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.a.sendCustomAction(s, bundle, customActionCallback);
            return;
        }
        throw new IllegalArgumentException("action cannot be empty");
    }
    
    public void subscribe(final String s, final Bundle bundle, final SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle != null) {
            this.a.subscribe(s, bundle, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }
    
    public void subscribe(final String s, final SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.a.subscribe(s, null, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }
    
    public void unsubscribe(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            this.a.unsubscribe(s, null);
            return;
        }
        throw new IllegalArgumentException("parentId is empty");
    }
    
    public void unsubscribe(final String s, final SubscriptionCallback subscriptionCallback) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback != null) {
            this.a.unsubscribe(s, subscriptionCallback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }
    
    private static class Api21Impl
    {
        static MediaDescription a(final MediaBrowser$MediaItem mediaBrowser$MediaItem) {
            return mediaBrowser$MediaItem.getDescription();
        }
        
        static int b(final MediaBrowser$MediaItem mediaBrowser$MediaItem) {
            return mediaBrowser$MediaItem.getFlags();
        }
    }
    
    private static class CallbackHandler extends Handler
    {
        private final WeakReference<MediaBrowserServiceCallbackImpl> a;
        private WeakReference<Messenger> b;
        
        CallbackHandler(final MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.a = new WeakReference<MediaBrowserServiceCallbackImpl>(mediaBrowserServiceCallbackImpl);
        }
        
        void a(final Messenger messenger) {
            this.b = new WeakReference<Messenger>(messenger);
        }
        
        public void handleMessage(final Message message) {
            final WeakReference<Messenger> b = this.b;
            if (b != null && b.get() != null) {
                if (this.a.get() != null) {
                    final Bundle data = message.getData();
                    MediaSessionCompat.ensureClassLoader(data);
                    final MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.a.get();
                    final Messenger messenger = this.b.get();
                    try {
                        final int what = message.what;
                        if (what != 1) {
                            if (what != 2) {
                                if (what != 3) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Unhandled message: ");
                                    sb.append(message);
                                    sb.append("\n  Client version: ");
                                    sb.append(1);
                                    sb.append("\n  Service version: ");
                                    sb.append(message.arg1);
                                    Log.w("MediaBrowserCompat", sb.toString());
                                }
                                else {
                                    final Bundle bundle = data.getBundle("data_options");
                                    MediaSessionCompat.ensureClassLoader(bundle);
                                    final Bundle bundle2 = data.getBundle("data_notify_children_changed_options");
                                    MediaSessionCompat.ensureClassLoader(bundle2);
                                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle, bundle2);
                                }
                            }
                            else {
                                mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                            }
                        }
                        else {
                            final Bundle bundle3 = data.getBundle("data_root_hints");
                            MediaSessionCompat.ensureClassLoader(bundle3);
                            mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token)data.getParcelable("data_media_session_token"), bundle3);
                        }
                    }
                    catch (final BadParcelableException ex) {
                        Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                        if (message.what == 1) {
                            mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                        }
                    }
                }
            }
        }
    }
    
    public static class ConnectionCallback
    {
        final MediaBrowser$ConnectionCallback a;
        ConnectionCallbackInternal b;
        
        public ConnectionCallback() {
            this.a = new ConnectionCallbackApi21();
        }
        
        void a(final ConnectionCallbackInternal b) {
            this.b = b;
        }
        
        public void onConnected() {
        }
        
        public void onConnectionFailed() {
        }
        
        public void onConnectionSuspended() {
        }
        
        private class ConnectionCallbackApi21 extends MediaBrowser$ConnectionCallback
        {
            final ConnectionCallback a;
            
            ConnectionCallbackApi21(final ConnectionCallback a) {
                this.a = a;
            }
            
            public void onConnected() {
                final ConnectionCallbackInternal b = this.a.b;
                if (b != null) {
                    b.onConnected();
                }
                this.a.onConnected();
            }
            
            public void onConnectionFailed() {
                final ConnectionCallbackInternal b = this.a.b;
                if (b != null) {
                    b.onConnectionFailed();
                }
                this.a.onConnectionFailed();
            }
            
            public void onConnectionSuspended() {
                final ConnectionCallbackInternal b = this.a.b;
                if (b != null) {
                    b.onConnectionSuspended();
                }
                this.a.onConnectionSuspended();
            }
        }
        
        interface ConnectionCallbackInternal
        {
            void onConnected();
            
            void onConnectionFailed();
            
            void onConnectionSuspended();
        }
    }
    
    public abstract static class CustomActionCallback
    {
        public void onError(final String s, final Bundle bundle, final Bundle bundle2) {
        }
        
        public void onProgressUpdate(final String s, final Bundle bundle, final Bundle bundle2) {
        }
        
        public void onResult(final String s, final Bundle bundle, final Bundle bundle2) {
        }
    }
    
    private static class CustomActionResultReceiver extends ResultReceiver
    {
        private final String d;
        private final Bundle e;
        private final CustomActionCallback f;
        
        CustomActionResultReceiver(final String d, final Bundle e, final CustomActionCallback f, final Handler handler) {
            super(handler);
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        @Override
        protected void a(final int n, final Bundle bundle) {
            if (this.f == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (n != -1) {
                if (n != 0) {
                    if (n != 1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown result code: ");
                        sb.append(n);
                        sb.append(" (extras=");
                        sb.append(this.e);
                        sb.append(", resultData=");
                        sb.append(bundle);
                        sb.append(")");
                        Log.w("MediaBrowserCompat", sb.toString());
                    }
                    else {
                        this.f.onProgressUpdate(this.d, this.e, bundle);
                    }
                }
                else {
                    this.f.onResult(this.d, this.e, bundle);
                }
            }
            else {
                this.f.onError(this.d, this.e, bundle);
            }
        }
    }
    
    public abstract static class ItemCallback
    {
        final MediaBrowser$ItemCallback a;
        
        public ItemCallback() {
            this.a = new ItemCallbackApi23();
        }
        
        public void onError(final String s) {
        }
        
        public void onItemLoaded(final MediaItem mediaItem) {
        }
        
        private class ItemCallbackApi23 extends MediaBrowser$ItemCallback
        {
            final ItemCallback a;
            
            ItemCallbackApi23(final ItemCallback a) {
                this.a = a;
            }
            
            public void onError(final String s) {
                this.a.onError(s);
            }
            
            public void onItemLoaded(final MediaBrowser$MediaItem mediaBrowser$MediaItem) {
                this.a.onItemLoaded(MediaItem.fromMediaItem(mediaBrowser$MediaItem));
            }
        }
    }
    
    private static class ItemReceiver extends ResultReceiver
    {
        private final String d;
        private final ItemCallback e;
        
        ItemReceiver(final String d, final ItemCallback e, final Handler handler) {
            super(handler);
            this.d = d;
            this.e = e;
        }
        
        @Override
        protected void a(final int n, final Bundle bundle) {
            Bundle unparcelWithClassLoader = bundle;
            if (bundle != null) {
                unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (n == 0 && unparcelWithClassLoader != null && unparcelWithClassLoader.containsKey("media_item")) {
                final Parcelable parcelable = unparcelWithClassLoader.getParcelable("media_item");
                if (parcelable != null && !(parcelable instanceof MediaItem)) {
                    this.e.onError(this.d);
                }
                else {
                    this.e.onItemLoaded((MediaItem)parcelable);
                }
                return;
            }
            this.e.onError(this.d);
        }
    }
    
    interface MediaBrowserImpl
    {
        void connect();
        
        void disconnect();
        
        Bundle getExtras();
        
        void getItem(final String p0, final ItemCallback p1);
        
        Bundle getNotifyChildrenChangedOptions();
        
        String getRoot();
        
        ComponentName getServiceComponent();
        
        MediaSessionCompat.Token getSessionToken();
        
        boolean isConnected();
        
        void search(final String p0, final Bundle p1, final SearchCallback p2);
        
        void sendCustomAction(final String p0, final Bundle p1, final CustomActionCallback p2);
        
        void subscribe(final String p0, final Bundle p1, final SubscriptionCallback p2);
        
        void unsubscribe(final String p0, final SubscriptionCallback p1);
    }
    
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallbackInternal
    {
        final Context a;
        protected final MediaBrowser b;
        protected final Bundle c;
        protected final CallbackHandler d;
        private final a<String, Subscription> e;
        protected int f;
        protected ServiceBinderWrapper g;
        protected Messenger h;
        private MediaSessionCompat.Token i;
        private Bundle j;
        
        MediaBrowserImplApi21(final Context a, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
            this.d = new CallbackHandler(this);
            this.e = new a<String, Subscription>();
            this.a = a;
            Bundle c;
            if (bundle != null) {
                c = new Bundle(bundle);
            }
            else {
                c = new Bundle();
            }
            (this.c = c).putInt("extra_client_version", 1);
            c.putInt("extra_calling_pid", Process.myPid());
            connectionCallback.a((ConnectionCallbackInternal)this);
            this.b = new MediaBrowser(a, componentName, connectionCallback.a, c);
        }
        
        @Override
        public void connect() {
            this.b.connect();
        }
        
        @Override
        public void disconnect() {
            final ServiceBinderWrapper g = this.g;
            if (g != null) {
                final Messenger h = this.h;
                if (h != null) {
                    try {
                        g.j(h);
                    }
                    catch (final RemoteException ex) {
                        Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                    }
                }
            }
            this.b.disconnect();
        }
        
        @Override
        public Bundle getExtras() {
            return this.b.getExtras();
        }
        
        @Override
        public void getItem(final String s, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty((CharSequence)s)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.b.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.d.post((Runnable)new Runnable(this, itemCallback, s) {
                    final ItemCallback a;
                    final String b;
                    final MediaBrowserImplApi21 c;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b);
                    }
                });
                return;
            }
            if (this.g == null) {
                this.d.post((Runnable)new Runnable(this, itemCallback, s) {
                    final ItemCallback a;
                    final String b;
                    final MediaBrowserImplApi21 c;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b);
                    }
                });
                return;
            }
            final ItemReceiver itemReceiver = new ItemReceiver(s, itemCallback, this.d);
            try {
                this.g.d(s, itemReceiver, this.h);
            }
            catch (final RemoteException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Remote error getting media item: ");
                sb.append(s);
                Log.i("MediaBrowserCompat", sb.toString());
                this.d.post((Runnable)new Runnable(this, itemCallback, s) {
                    final ItemCallback a;
                    final String b;
                    final MediaBrowserImplApi21 c;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b);
                    }
                });
            }
        }
        
        @Override
        public Bundle getNotifyChildrenChangedOptions() {
            return this.j;
        }
        
        @Override
        public String getRoot() {
            return this.b.getRoot();
        }
        
        @Override
        public ComponentName getServiceComponent() {
            return this.b.getServiceComponent();
        }
        
        @Override
        public MediaSessionCompat.Token getSessionToken() {
            if (this.i == null) {
                this.i = MediaSessionCompat.Token.fromToken(this.b.getSessionToken());
            }
            return this.i;
        }
        
        @Override
        public boolean isConnected() {
            return this.b.isConnected();
        }
        
        @Override
        public void onConnected() {
            try {
                final Bundle extras = this.b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f = extras.getInt("extra_service_version", 0);
                final IBinder a = androidx.core.app.f.a(extras, "extra_messenger");
                if (a != null) {
                    this.g = new ServiceBinderWrapper(a, this.c);
                    final Messenger h = new Messenger((Handler)this.d);
                    this.h = h;
                    this.d.a(h);
                    try {
                        this.g.e(this.a, this.h);
                    }
                    catch (final RemoteException ex) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                final IMediaSession interface1 = IMediaSession.Stub.asInterface(androidx.core.app.f.a(extras, "extra_session_binder"));
                if (interface1 != null) {
                    this.i = MediaSessionCompat.Token.fromToken(this.b.getSessionToken(), interface1);
                }
            }
            catch (final IllegalStateException ex2) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", (Throwable)ex2);
            }
        }
        
        @Override
        public void onConnectionFailed() {
        }
        
        @Override
        public void onConnectionFailed(final Messenger messenger) {
        }
        
        @Override
        public void onConnectionSuspended() {
            this.g = null;
            this.h = null;
            this.i = null;
            this.d.a(null);
        }
        
        @Override
        public void onLoadChildren(final Messenger messenger, final String s, final List<MediaItem> list, final Bundle bundle, final Bundle bundle2) {
            if (this.h != messenger) {
                return;
            }
            final Subscription subscription = this.e.get(s);
            if (subscription == null) {
                if (MediaBrowserCompat.b) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("onLoadChildren for id that isn't subscribed id=");
                    sb.append(s);
                    Log.d("MediaBrowserCompat", sb.toString());
                }
                return;
            }
            final SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(s);
                    }
                    else {
                        this.j = bundle2;
                        callback.onChildrenLoaded(s, list);
                        this.j = null;
                    }
                }
                else if (list == null) {
                    callback.onError(s, bundle);
                }
                else {
                    this.j = bundle2;
                    callback.onChildrenLoaded(s, list, bundle);
                    this.j = null;
                }
            }
        }
        
        @Override
        public void onServiceConnected(final Messenger messenger, final String s, final MediaSessionCompat.Token token, final Bundle bundle) {
        }
        
        @Override
        public void search(final String s, final Bundle bundle, final SearchCallback searchCallback) {
            if (!this.isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.g == null) {
                Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
                this.d.post((Runnable)new Runnable(this, searchCallback, s, bundle) {
                    final SearchCallback a;
                    final String b;
                    final Bundle c;
                    final MediaBrowserImplApi21 d;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b, this.c);
                    }
                });
                return;
            }
            final SearchResultReceiver searchResultReceiver = new SearchResultReceiver(s, bundle, searchCallback, this.d);
            try {
                this.g.g(s, bundle, searchResultReceiver, this.h);
            }
            catch (final RemoteException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Remote error searching items with query: ");
                sb.append(s);
                Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                this.d.post((Runnable)new Runnable(this, searchCallback, s, bundle) {
                    final SearchCallback a;
                    final String b;
                    final Bundle c;
                    final MediaBrowserImplApi21 d;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b, this.c);
                    }
                });
            }
        }
        
        @Override
        public void sendCustomAction(final String s, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (this.isConnected()) {
                if (this.g == null) {
                    Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
                    if (customActionCallback != null) {
                        this.d.post((Runnable)new Runnable(this, customActionCallback, s, bundle) {
                            final CustomActionCallback a;
                            final String b;
                            final Bundle c;
                            final MediaBrowserImplApi21 d;
                            
                            @Override
                            public void run() {
                                this.a.onError(this.b, this.c, null);
                            }
                        });
                    }
                }
                final CustomActionResultReceiver customActionResultReceiver = new CustomActionResultReceiver(s, bundle, customActionCallback, this.d);
                try {
                    this.g.h(s, bundle, customActionResultReceiver, this.h);
                }
                catch (final RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error sending a custom action: action=");
                    sb.append(s);
                    sb.append(", extras=");
                    sb.append(bundle);
                    Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                    if (customActionCallback != null) {
                        this.d.post((Runnable)new Runnable(this, customActionCallback, s, bundle) {
                            final CustomActionCallback a;
                            final String b;
                            final Bundle c;
                            final MediaBrowserImplApi21 d;
                            
                            @Override
                            public void run() {
                                this.a.onError(this.b, this.c, null);
                            }
                        });
                    }
                }
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot send a custom action (");
            sb2.append(s);
            sb2.append(") with extras ");
            sb2.append(bundle);
            sb2.append(" because the browser is not connected to the service.");
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public void subscribe(final String s, final Bundle bundle, final SubscriptionCallback subscriptionCallback) {
            Subscription subscription;
            if ((subscription = this.e.get(s)) == null) {
                subscription = new Subscription();
                this.e.put(s, subscription);
            }
            subscriptionCallback.a(subscription);
            Bundle bundle2;
            if (bundle == null) {
                bundle2 = null;
            }
            else {
                bundle2 = new Bundle(bundle);
            }
            subscription.putCallback(bundle2, subscriptionCallback);
            final ServiceBinderWrapper g = this.g;
            if (g == null) {
                this.b.subscribe(s, subscriptionCallback.a);
            }
            else {
                try {
                    g.a(s, subscriptionCallback.b, bundle2, this.h);
                }
                catch (final RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error subscribing media item: ");
                    sb.append(s);
                    Log.i("MediaBrowserCompat", sb.toString());
                }
            }
        }
        
        @Override
        public void unsubscribe(final String s, final SubscriptionCallback subscriptionCallback) {
            final Subscription subscription = this.e.get(s);
            if (subscription == null) {
                return;
            }
            final ServiceBinderWrapper g = this.g;
            Label_0266: {
                if (g == null) {
                    if (subscriptionCallback == null) {
                        this.b.unsubscribe(s);
                    }
                    else {
                        final List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                        final List<Bundle> optionsList = subscription.getOptionsList();
                        for (int i = callbacks.size() - 1; i >= 0; --i) {
                            if (callbacks.get(i) == subscriptionCallback) {
                                callbacks.remove(i);
                                optionsList.remove(i);
                            }
                        }
                        if (callbacks.size() == 0) {
                            this.b.unsubscribe(s);
                        }
                    }
                }
                else {
                    Label_0148: {
                        if (subscriptionCallback != null) {
                            break Label_0148;
                        }
                        try {
                            g.f(s, null, this.h);
                            break Label_0266;
                            while (true) {
                                int n = 0;
                                List<SubscriptionCallback> callbacks2 = null;
                            Label_0172:
                                while (true) {
                                    while (true) {
                                        --n;
                                        break Label_0172;
                                        this.g.f(s, subscriptionCallback.b, this.h);
                                        callbacks2.remove(n);
                                        final List<Bundle> optionsList2;
                                        optionsList2.remove(n);
                                        continue;
                                    }
                                    iftrue(Label_0266:)(n < 0);
                                    break Label_0172;
                                    callbacks2 = subscription.getCallbacks();
                                    final List<Bundle> optionsList2 = subscription.getOptionsList();
                                    n = callbacks2.size() - 1;
                                    continue Label_0172;
                                }
                                iftrue(Label_0222:)(callbacks2.get(n) != subscriptionCallback);
                                continue;
                            }
                        }
                        catch (final RemoteException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("removeSubscription failed with RemoteException parentId=");
                            sb.append(s);
                            Log.d("MediaBrowserCompat", sb.toString());
                        }
                    }
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.e.remove(s);
            }
        }
    }
    
    interface MediaBrowserServiceCallbackImpl
    {
        void onConnectionFailed(final Messenger p0);
        
        void onLoadChildren(final Messenger p0, final String p1, final List<MediaItem> p2, final Bundle p3, final Bundle p4);
        
        void onServiceConnected(final Messenger p0, final String p1, final MediaSessionCompat.Token p2, final Bundle p3);
    }
    
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21
    {
        MediaBrowserImplApi23(final Context context, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
        
        @Override
        public void getItem(final String s, final ItemCallback itemCallback) {
            if (super.g == null) {
                super.b.getItem(s, itemCallback.a);
            }
            else {
                super.getItem(s, itemCallback);
            }
        }
    }
    
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23
    {
        MediaBrowserImplApi26(final Context context, final ComponentName componentName, final ConnectionCallback connectionCallback, final Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
        
        @Override
        public void subscribe(final String s, final Bundle bundle, final SubscriptionCallback subscriptionCallback) {
            if (super.g != null && super.f >= 2) {
                super.subscribe(s, bundle, subscriptionCallback);
            }
            else if (bundle == null) {
                super.b.subscribe(s, subscriptionCallback.a);
            }
            else {
                super.b.subscribe(s, bundle, subscriptionCallback.a);
            }
        }
        
        @Override
        public void unsubscribe(final String s, final SubscriptionCallback subscriptionCallback) {
            if (super.g != null && super.f >= 2) {
                super.unsubscribe(s, subscriptionCallback);
            }
            else if (subscriptionCallback == null) {
                super.b.unsubscribe(s);
            }
            else {
                super.b.unsubscribe(s, subscriptionCallback.a);
            }
        }
    }
    
    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl
    {
        final Context a;
        final ComponentName b;
        final ConnectionCallback c;
        final Bundle d;
        final CallbackHandler e;
        private final a<String, Subscription> f;
        int g;
        MediaServiceConnection h;
        ServiceBinderWrapper i;
        Messenger j;
        private String k;
        private MediaSessionCompat.Token l;
        private Bundle m;
        private Bundle n;
        
        public MediaBrowserImplBase(final Context a, final ComponentName b, final ConnectionCallback c, final Bundle bundle) {
            this.e = new CallbackHandler(this);
            this.f = new a<String, Subscription>();
            this.g = 1;
            if (a == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (b == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (c != null) {
                this.a = a;
                this.b = b;
                this.c = c;
                Bundle d;
                if (bundle == null) {
                    d = null;
                }
                else {
                    d = new Bundle(bundle);
                }
                this.d = d;
                return;
            }
            throw new IllegalArgumentException("connection callback must not be null");
        }
        
        private static String c(final int n) {
            if (n == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (n == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (n == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (n == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (n != 4) {
                final StringBuilder sb = new StringBuilder();
                sb.append("UNKNOWN/");
                sb.append(n);
                return sb.toString();
            }
            return "CONNECT_STATE_SUSPENDED";
        }
        
        private boolean d(final Messenger messenger, final String s) {
            if (this.j == messenger) {
                final int g = this.g;
                if (g != 0) {
                    if (g != 1) {
                        return true;
                    }
                }
            }
            final int g2 = this.g;
            if (g2 != 0 && g2 != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(" for ");
                sb.append(this.b);
                sb.append(" with mCallbacksMessenger=");
                sb.append(this.j);
                sb.append(" this=");
                sb.append(this);
                Log.i("MediaBrowserCompat", sb.toString());
            }
            return false;
        }
        
        void a() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            final StringBuilder sb = new StringBuilder();
            sb.append("  mServiceComponent=");
            sb.append(this.b);
            Log.d("MediaBrowserCompat", sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("  mCallback=");
            sb2.append(this.c);
            Log.d("MediaBrowserCompat", sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("  mRootHints=");
            sb3.append(this.d);
            Log.d("MediaBrowserCompat", sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("  mState=");
            sb4.append(c(this.g));
            Log.d("MediaBrowserCompat", sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append("  mServiceConnection=");
            sb5.append(this.h);
            Log.d("MediaBrowserCompat", sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append("  mServiceBinderWrapper=");
            sb6.append(this.i);
            Log.d("MediaBrowserCompat", sb6.toString());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append("  mCallbacksMessenger=");
            sb7.append(this.j);
            Log.d("MediaBrowserCompat", sb7.toString());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append("  mRootId=");
            sb8.append(this.k);
            Log.d("MediaBrowserCompat", sb8.toString());
            final StringBuilder sb9 = new StringBuilder();
            sb9.append("  mMediaSessionToken=");
            sb9.append(this.l);
            Log.d("MediaBrowserCompat", sb9.toString());
        }
        
        void b() {
            final MediaServiceConnection h = this.h;
            if (h != null) {
                this.a.unbindService((ServiceConnection)h);
            }
            this.g = 1;
            this.h = null;
            this.i = null;
            this.j = null;
            this.e.a(null);
            this.k = null;
            this.l = null;
        }
        
        @Override
        public void connect() {
            final int g = this.g;
            if (g != 0 && g != 1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("connect() called while neigther disconnecting nor disconnected (state=");
                sb.append(c(this.g));
                sb.append(")");
                throw new IllegalStateException(sb.toString());
            }
            this.g = 2;
            this.e.post((Runnable)new Runnable(this) {
                final MediaBrowserImplBase a;
                
                @Override
                public void run() {
                    final MediaBrowserImplBase a = this.a;
                    if (a.g == 0) {
                        return;
                    }
                    a.g = 2;
                    if (MediaBrowserCompat.b && a.h != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("mServiceConnection should be null. Instead it is ");
                        sb.append(this.a.h);
                        throw new RuntimeException(sb.toString());
                    }
                    if (a.i != null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("mServiceBinderWrapper should be null. Instead it is ");
                        sb2.append(this.a.i);
                        throw new RuntimeException(sb2.toString());
                    }
                    if (a.j == null) {
                        final Intent intent = new Intent("android.media.browse.MediaBrowserService");
                        intent.setComponent(this.a.b);
                        final MediaBrowserImplBase a2 = this.a;
                        a2.h = a2.new MediaServiceConnection();
                        final int n = 0;
                        int bindService;
                        try {
                            final MediaBrowserImplBase a3 = this.a;
                            bindService = (a3.a.bindService(intent, (ServiceConnection)a3.h, 1) ? 1 : 0);
                        }
                        catch (final Exception ex) {
                            final StringBuilder sb3 = new StringBuilder();
                            sb3.append("Failed binding to service ");
                            sb3.append(this.a.b);
                            Log.e("MediaBrowserCompat", sb3.toString());
                            bindService = n;
                        }
                        if (bindService == 0) {
                            this.a.b();
                            this.a.c.onConnectionFailed();
                        }
                        if (MediaBrowserCompat.b) {
                            Log.d("MediaBrowserCompat", "connect...");
                            this.a.a();
                        }
                        return;
                    }
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("mCallbacksMessenger should be null. Instead it is ");
                    sb4.append(this.a.j);
                    throw new RuntimeException(sb4.toString());
                }
            });
        }
        
        @Override
        public void disconnect() {
            this.g = 0;
            this.e.post((Runnable)new Runnable(this) {
                final MediaBrowserImplBase a;
                
                @Override
                public void run() {
                    final MediaBrowserImplBase a = this.a;
                    final Messenger j = a.j;
                    if (j != null) {
                        try {
                            a.i.c(j);
                        }
                        catch (final RemoteException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("RemoteException during connect for ");
                            sb.append(this.a.b);
                            Log.w("MediaBrowserCompat", sb.toString());
                        }
                    }
                    final MediaBrowserImplBase a2 = this.a;
                    final int g = a2.g;
                    a2.b();
                    if (g != 0) {
                        this.a.g = g;
                    }
                    if (MediaBrowserCompat.b) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        this.a.a();
                    }
                }
            });
        }
        
        @Override
        public Bundle getExtras() {
            if (this.isConnected()) {
                return this.m;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("getExtras() called while not connected (state=");
            sb.append(c(this.g));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
        
        @Override
        public void getItem(final String s, final ItemCallback itemCallback) {
            if (TextUtils.isEmpty((CharSequence)s)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.isConnected()) {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                this.e.post((Runnable)new Runnable(this, itemCallback, s) {
                    final ItemCallback a;
                    final String b;
                    final MediaBrowserImplBase c;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b);
                    }
                });
                return;
            }
            final ItemReceiver itemReceiver = new ItemReceiver(s, itemCallback, this.e);
            try {
                this.i.d(s, itemReceiver, this.j);
            }
            catch (final RemoteException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Remote error getting media item: ");
                sb.append(s);
                Log.i("MediaBrowserCompat", sb.toString());
                this.e.post((Runnable)new Runnable(this, itemCallback, s) {
                    final ItemCallback a;
                    final String b;
                    final MediaBrowserImplBase c;
                    
                    @Override
                    public void run() {
                        this.a.onError(this.b);
                    }
                });
            }
        }
        
        @Override
        public Bundle getNotifyChildrenChangedOptions() {
            return this.n;
        }
        
        @Override
        public String getRoot() {
            if (this.isConnected()) {
                return this.k;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("getRoot() called while not connected(state=");
            sb.append(c(this.g));
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
        
        @Override
        public ComponentName getServiceComponent() {
            if (this.isConnected()) {
                return this.b;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("getServiceComponent() called while not connected (state=");
            sb.append(this.g);
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
        
        @Override
        public MediaSessionCompat.Token getSessionToken() {
            if (this.isConnected()) {
                return this.l;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("getSessionToken() called while not connected(state=");
            sb.append(this.g);
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
        
        @Override
        public boolean isConnected() {
            return this.g == 3;
        }
        
        @Override
        public void onConnectionFailed(final Messenger messenger) {
            final StringBuilder sb = new StringBuilder();
            sb.append("onConnectFailed for ");
            sb.append(this.b);
            Log.e("MediaBrowserCompat", sb.toString());
            if (!this.d(messenger, "onConnectFailed")) {
                return;
            }
            if (this.g != 2) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("onConnect from service while mState=");
                sb2.append(c(this.g));
                sb2.append("... ignoring");
                Log.w("MediaBrowserCompat", sb2.toString());
                return;
            }
            this.b();
            this.c.onConnectionFailed();
        }
        
        @Override
        public void onLoadChildren(final Messenger messenger, final String s, final List<MediaItem> list, final Bundle bundle, final Bundle bundle2) {
            if (!this.d(messenger, "onLoadChildren")) {
                return;
            }
            final boolean b = MediaBrowserCompat.b;
            if (b) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onLoadChildren for ");
                sb.append(this.b);
                sb.append(" id=");
                sb.append(s);
                Log.d("MediaBrowserCompat", sb.toString());
            }
            final Subscription subscription = this.f.get(s);
            if (subscription == null) {
                if (b) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("onLoadChildren for id that isn't subscribed id=");
                    sb2.append(s);
                    Log.d("MediaBrowserCompat", sb2.toString());
                }
                return;
            }
            final SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(s);
                    }
                    else {
                        this.n = bundle2;
                        callback.onChildrenLoaded(s, list);
                        this.n = null;
                    }
                }
                else if (list == null) {
                    callback.onError(s, bundle);
                }
                else {
                    this.n = bundle2;
                    callback.onChildrenLoaded(s, list, bundle);
                    this.n = null;
                }
            }
        }
        
        @Override
        public void onServiceConnected(final Messenger messenger, final String k, final MediaSessionCompat.Token l, final Bundle m) {
            if (!this.d(messenger, "onConnect")) {
                return;
            }
            if (this.g != 2) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onConnect from service while mState=");
                sb.append(c(this.g));
                sb.append("... ignoring");
                Log.w("MediaBrowserCompat", sb.toString());
                return;
            }
            this.k = k;
            this.l = l;
            this.m = m;
            this.g = 3;
            if (MediaBrowserCompat.b) {
                Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                this.a();
            }
            this.c.onConnected();
            try {
                for (final Map.Entry<String, V> entry : this.f.entrySet()) {
                    final String s = entry.getKey();
                    final Subscription subscription = (Subscription)entry.getValue();
                    final List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    final List<Bundle> optionsList = subscription.getOptionsList();
                    for (int i = 0; i < callbacks.size(); ++i) {
                        this.i.a(s, ((SubscriptionCallback)callbacks.get(i)).b, optionsList.get(i), this.j);
                    }
                }
            }
            catch (final RemoteException ex) {
                Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
            }
        }
        
        @Override
        public void search(final String s, final Bundle bundle, final SearchCallback searchCallback) {
            if (this.isConnected()) {
                final SearchResultReceiver searchResultReceiver = new SearchResultReceiver(s, bundle, searchCallback, this.e);
                try {
                    this.i.g(s, bundle, searchResultReceiver, this.j);
                }
                catch (final RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error searching items with query: ");
                    sb.append(s);
                    Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                    this.e.post((Runnable)new Runnable(this, searchCallback, s, bundle) {
                        final SearchCallback a;
                        final String b;
                        final Bundle c;
                        final MediaBrowserImplBase d;
                        
                        @Override
                        public void run() {
                            this.a.onError(this.b, this.c);
                        }
                    });
                }
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("search() called while not connected (state=");
            sb2.append(c(this.g));
            sb2.append(")");
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public void sendCustomAction(final String s, final Bundle bundle, final CustomActionCallback customActionCallback) {
            if (this.isConnected()) {
                final CustomActionResultReceiver customActionResultReceiver = new CustomActionResultReceiver(s, bundle, customActionCallback, this.e);
                try {
                    this.i.h(s, bundle, customActionResultReceiver, this.j);
                }
                catch (final RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Remote error sending a custom action: action=");
                    sb.append(s);
                    sb.append(", extras=");
                    sb.append(bundle);
                    Log.i("MediaBrowserCompat", sb.toString(), (Throwable)ex);
                    if (customActionCallback != null) {
                        this.e.post((Runnable)new Runnable(this, customActionCallback, s, bundle) {
                            final CustomActionCallback a;
                            final String b;
                            final Bundle c;
                            final MediaBrowserImplBase d;
                            
                            @Override
                            public void run() {
                                this.a.onError(this.b, this.c, null);
                            }
                        });
                    }
                }
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot send a custom action (");
            sb2.append(s);
            sb2.append(") with extras ");
            sb2.append(bundle);
            sb2.append(" because the browser is not connected to the service.");
            throw new IllegalStateException(sb2.toString());
        }
        
        @Override
        public void subscribe(final String s, final Bundle bundle, final SubscriptionCallback subscriptionCallback) {
            Subscription subscription;
            if ((subscription = this.f.get(s)) == null) {
                subscription = new Subscription();
                this.f.put(s, subscription);
            }
            Bundle bundle2;
            if (bundle == null) {
                bundle2 = null;
            }
            else {
                bundle2 = new Bundle(bundle);
            }
            subscription.putCallback(bundle2, subscriptionCallback);
            if (this.isConnected()) {
                try {
                    this.i.a(s, subscriptionCallback.b, bundle2, this.j);
                }
                catch (final RemoteException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("addSubscription failed with RemoteException parentId=");
                    sb.append(s);
                    Log.d("MediaBrowserCompat", sb.toString());
                }
            }
        }
        
        @Override
        public void unsubscribe(final String s, final SubscriptionCallback subscriptionCallback) {
            final Subscription subscription = this.f.get(s);
            if (subscription == null) {
                return;
            }
        Label_0109_Outer:
            while (true) {
                if (subscriptionCallback == null) {
                    Label_0171: {
                        try {
                            if (this.isConnected()) {
                                this.i.f(s, null, this.j);
                            }
                            break Label_0171;
                            final List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                            final List<Bundle> optionsList = subscription.getOptionsList();
                            int n = callbacks.size() - 1;
                            while (true) {
                            Block_7_Outer:
                                while (true) {
                                    iftrue(Label_0171:)(n < 0);
                                Label_0127:
                                    while (true) {
                                        Block_6: {
                                            break Block_6;
                                            iftrue(Label_0109:)(!this.isConnected());
                                            break Block_7_Outer;
                                            callbacks.remove(n);
                                            optionsList.remove(n);
                                            break Label_0127;
                                        }
                                        iftrue(Label_0127:)(callbacks.get(n) != subscriptionCallback);
                                        continue Label_0109_Outer;
                                    }
                                    --n;
                                    continue Block_7_Outer;
                                }
                                this.i.f(s, subscriptionCallback.b, this.j);
                                continue;
                            }
                        }
                        catch (final RemoteException ex) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("removeSubscription failed with RemoteException parentId=");
                            sb.append(s);
                            Log.d("MediaBrowserCompat", sb.toString());
                        }
                    }
                    if (subscription.isEmpty() || subscriptionCallback == null) {
                        this.f.remove(s);
                    }
                    return;
                }
                continue;
            }
        }
        
        private class MediaServiceConnection implements ServiceConnection
        {
            final MediaBrowserImplBase a;
            
            MediaServiceConnection(final MediaBrowserImplBase a) {
                this.a = a;
            }
            
            private void b(final Runnable runnable) {
                if (Thread.currentThread() == this.a.e.getLooper().getThread()) {
                    runnable.run();
                }
                else {
                    this.a.e.post(runnable);
                }
            }
            
            boolean a(final String s) {
                final MediaBrowserImplBase a = this.a;
                if (a.h == this) {
                    final int g = a.g;
                    if (g != 0) {
                        if (g != 1) {
                            return true;
                        }
                    }
                }
                final int g2 = a.g;
                if (g2 != 0 && g2 != 1) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s);
                    sb.append(" for ");
                    sb.append(this.a.b);
                    sb.append(" with mServiceConnection=");
                    sb.append(this.a.h);
                    sb.append(" this=");
                    sb.append(this);
                    Log.i("MediaBrowserCompat", sb.toString());
                }
                return false;
            }
            
            public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                this.b(new Runnable(this, componentName, binder) {
                    final ComponentName a;
                    final IBinder b;
                    final MediaServiceConnection c;
                    
                    @Override
                    public void run() {
                        final boolean b = MediaBrowserCompat.b;
                        if (b) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceConnected name=");
                            sb.append(this.a);
                            sb.append(" binder=");
                            sb.append(this.b);
                            Log.d("MediaBrowserCompat", sb.toString());
                            this.c.a.a();
                        }
                        if (!this.c.a("onServiceConnected")) {
                            return;
                        }
                        final MediaBrowserImplBase a = this.c.a;
                        a.i = new ServiceBinderWrapper(this.b, a.d);
                        this.c.a.j = new Messenger((Handler)this.c.a.e);
                        final MediaBrowserImplBase a2 = this.c.a;
                        a2.e.a(a2.j);
                        this.c.a.g = 2;
                        while (true) {
                            if (b) {
                                try {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    this.c.a.a();
                                    final MediaBrowserImplBase a3 = this.c.a;
                                    a3.i.b(a3.a, a3.j);
                                }
                                catch (final RemoteException ex) {
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append("RemoteException during connect for ");
                                    sb2.append(this.c.a.b);
                                    Log.w("MediaBrowserCompat", sb2.toString());
                                    if (MediaBrowserCompat.b) {
                                        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                        this.c.a.a();
                                    }
                                }
                                return;
                            }
                            continue;
                        }
                    }
                });
            }
            
            public void onServiceDisconnected(final ComponentName componentName) {
                this.b(new Runnable(this, componentName) {
                    final ComponentName a;
                    final MediaServiceConnection b;
                    
                    @Override
                    public void run() {
                        if (MediaBrowserCompat.b) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceDisconnected name=");
                            sb.append(this.a);
                            sb.append(" this=");
                            sb.append(this);
                            sb.append(" mServiceConnection=");
                            sb.append(this.b.a.h);
                            Log.d("MediaBrowserCompat", sb.toString());
                            this.b.a.a();
                        }
                        if (!this.b.a("onServiceDisconnected")) {
                            return;
                        }
                        final MediaBrowserImplBase a = this.b.a;
                        a.i = null;
                        a.j = null;
                        a.e.a(null);
                        final MediaBrowserImplBase a2 = this.b.a;
                        a2.g = 4;
                        a2.c.onConnectionSuspended();
                    }
                });
            }
        }
    }
    
    public static class MediaItem implements Parcelable
    {
        public static final Parcelable$Creator<MediaItem> CREATOR;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final int a;
        private final MediaDescriptionCompat b;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<MediaItem>() {
                public MediaItem createFromParcel(final Parcel parcel) {
                    return new MediaItem(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public MediaItem[] newArray(final int n) {
                    return new MediaItem[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        MediaItem(final Parcel parcel) {
            this.a = parcel.readInt();
            this.b = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
        
        public MediaItem(final MediaDescriptionCompat b, final int a) {
            if (b == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (!TextUtils.isEmpty((CharSequence)b.getMediaId())) {
                this.a = a;
                this.b = b;
                return;
            }
            throw new IllegalArgumentException("description must have a non-empty media id");
        }
        
        public static MediaItem fromMediaItem(final Object o) {
            if (o != null) {
                final MediaBrowser$MediaItem mediaBrowser$MediaItem = (MediaBrowser$MediaItem)o;
                return new MediaItem(MediaDescriptionCompat.fromMediaDescription(Api21Impl.a(mediaBrowser$MediaItem)), Api21Impl.b(mediaBrowser$MediaItem));
            }
            return null;
        }
        
        public static List<MediaItem> fromMediaItemList(final List<?> list) {
            if (list != null) {
                final ArrayList list2 = new ArrayList(list.size());
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    list2.add(fromMediaItem(iterator.next()));
                }
                return list2;
            }
            return null;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public MediaDescriptionCompat getDescription() {
            return this.b;
        }
        
        public int getFlags() {
            return this.a;
        }
        
        public String getMediaId() {
            return this.b.getMediaId();
        }
        
        public boolean isBrowsable() {
            final int a = this.a;
            boolean b = true;
            if ((a & 0x1) == 0x0) {
                b = false;
            }
            return b;
        }
        
        public boolean isPlayable() {
            return (this.a & 0x2) != 0x0;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=");
            sb.append(this.a);
            sb.append(", mDescription=");
            sb.append(this.b);
            sb.append('}');
            return sb.toString();
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeInt(this.a);
            this.b.writeToParcel(parcel, n);
        }
    }
    
    public abstract static class SearchCallback
    {
        public void onError(final String s, final Bundle bundle) {
        }
        
        public void onSearchResult(final String s, final Bundle bundle, final List<MediaItem> list) {
        }
    }
    
    private static class SearchResultReceiver extends ResultReceiver
    {
        private final String d;
        private final Bundle e;
        private final SearchCallback f;
        
        SearchResultReceiver(final String d, final Bundle e, final SearchCallback f, final Handler handler) {
            super(handler);
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        @Override
        protected void a(int i, final Bundle bundle) {
            Bundle unparcelWithClassLoader = bundle;
            if (bundle != null) {
                unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i == 0 && unparcelWithClassLoader != null && unparcelWithClassLoader.containsKey("search_results")) {
                final Parcelable[] parcelableArray = unparcelWithClassLoader.getParcelableArray("search_results");
                if (parcelableArray != null) {
                    final ArrayList list = new ArrayList();
                    int length;
                    for (length = parcelableArray.length, i = 0; i < length; ++i) {
                        list.add(parcelableArray[i]);
                    }
                    this.f.onSearchResult(this.d, this.e, list);
                }
                else {
                    this.f.onError(this.d, this.e);
                }
                return;
            }
            this.f.onError(this.d, this.e);
        }
    }
    
    private static class ServiceBinderWrapper
    {
        private Messenger a;
        private Bundle b;
        
        public ServiceBinderWrapper(final IBinder binder, final Bundle b) {
            this.a = new Messenger(binder);
            this.b = b;
        }
        
        private void i(final int what, final Bundle data, final Messenger replyTo) throws RemoteException {
            final Message obtain = Message.obtain();
            obtain.what = what;
            obtain.arg1 = 1;
            obtain.setData(data);
            obtain.replyTo = replyTo;
            this.a.send(obtain);
        }
        
        void a(final String s, final IBinder binder, final Bundle bundle, final Messenger messenger) throws RemoteException {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", s);
            f.b(bundle2, "data_callback_token", binder);
            bundle2.putBundle("data_options", bundle);
            this.i(3, bundle2, messenger);
        }
        
        void b(final Context context, final Messenger messenger) throws RemoteException {
            final Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.b);
            this.i(1, bundle, messenger);
        }
        
        void c(final Messenger messenger) throws RemoteException {
            this.i(2, null, messenger);
        }
        
        void d(final String s, final ResultReceiver resultReceiver, final Messenger messenger) throws RemoteException {
            final Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", s);
            bundle.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
            this.i(5, bundle, messenger);
        }
        
        void e(final Context context, final Messenger messenger) throws RemoteException {
            final Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.b);
            this.i(6, bundle, messenger);
        }
        
        void f(final String s, final IBinder binder, final Messenger messenger) throws RemoteException {
            final Bundle bundle = new Bundle();
            bundle.putString("data_media_item_id", s);
            f.b(bundle, "data_callback_token", binder);
            this.i(4, bundle, messenger);
        }
        
        void g(final String s, final Bundle bundle, final ResultReceiver resultReceiver, final Messenger messenger) throws RemoteException {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("data_search_query", s);
            bundle2.putBundle("data_search_extras", bundle);
            bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
            this.i(8, bundle2, messenger);
        }
        
        void h(final String s, final Bundle bundle, final ResultReceiver resultReceiver, final Messenger messenger) throws RemoteException {
            final Bundle bundle2 = new Bundle();
            bundle2.putString("data_custom_action", s);
            bundle2.putBundle("data_custom_action_extras", bundle);
            bundle2.putParcelable("data_result_receiver", (Parcelable)resultReceiver);
            this.i(9, bundle2, messenger);
        }
        
        void j(final Messenger messenger) throws RemoteException {
            this.i(7, null, messenger);
        }
    }
    
    private static class Subscription
    {
        private final List<SubscriptionCallback> a;
        private final List<Bundle> b;
        
        public Subscription() {
            this.a = new ArrayList<SubscriptionCallback>();
            this.b = new ArrayList<Bundle>();
        }
        
        public SubscriptionCallback getCallback(final Bundle bundle) {
            for (int i = 0; i < this.b.size(); ++i) {
                if (m0.a.a(this.b.get(i), bundle)) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        
        public List<SubscriptionCallback> getCallbacks() {
            return this.a;
        }
        
        public List<Bundle> getOptionsList() {
            return this.b;
        }
        
        public boolean isEmpty() {
            return this.a.isEmpty();
        }
        
        public void putCallback(final Bundle bundle, final SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.b.size(); ++i) {
                if (m0.a.a(this.b.get(i), bundle)) {
                    this.a.set(i, subscriptionCallback);
                    return;
                }
            }
            this.a.add(subscriptionCallback);
            this.b.add(bundle);
        }
    }
    
    public abstract static class SubscriptionCallback
    {
        final MediaBrowser$SubscriptionCallback a;
        final IBinder b;
        WeakReference<Subscription> c;
        
        public SubscriptionCallback() {
            this.b = (IBinder)new Binder();
            this.a = new SubscriptionCallbackApi26();
        }
        
        void a(final Subscription subscription) {
            this.c = new WeakReference<Subscription>(subscription);
        }
        
        public void onChildrenLoaded(final String s, final List<MediaItem> list) {
        }
        
        public void onChildrenLoaded(final String s, final List<MediaItem> list, final Bundle bundle) {
        }
        
        public void onError(final String s) {
        }
        
        public void onError(final String s, final Bundle bundle) {
        }
        
        private class SubscriptionCallbackApi21 extends MediaBrowser$SubscriptionCallback
        {
            final SubscriptionCallback a;
            
            SubscriptionCallbackApi21(final SubscriptionCallback a) {
                this.a = a;
            }
            
            List<MediaItem> a(final List<MediaItem> list, final Bundle bundle) {
                if (list == null) {
                    return null;
                }
                final int int1 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                final int int2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (int1 == -1 && int2 == -1) {
                    return list;
                }
                final int n = int2 * int1;
                final int n2 = n + int2;
                if (int1 >= 0 && int2 >= 1 && n < list.size()) {
                    int size;
                    if ((size = n2) > list.size()) {
                        size = list.size();
                    }
                    return list.subList(n, size);
                }
                return Collections.emptyList();
            }
            
            public void onChildrenLoaded(final String s, final List<MediaBrowser$MediaItem> list) {
                final WeakReference<Subscription> c = this.a.c;
                Object o;
                if (c == null) {
                    o = null;
                }
                else {
                    o = c.get();
                }
                if (o == null) {
                    this.a.onChildrenLoaded(s, MediaItem.fromMediaItemList(list));
                }
                else {
                    final List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                    final List<SubscriptionCallback> callbacks = ((Subscription)o).getCallbacks();
                    final List<Bundle> optionsList = ((Subscription)o).getOptionsList();
                    for (int i = 0; i < callbacks.size(); ++i) {
                        final Bundle bundle = optionsList.get(i);
                        if (bundle == null) {
                            this.a.onChildrenLoaded(s, fromMediaItemList);
                        }
                        else {
                            this.a.onChildrenLoaded(s, this.a(fromMediaItemList, bundle), bundle);
                        }
                    }
                }
            }
            
            public void onError(final String s) {
                this.a.onError(s);
            }
        }
        
        private class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21
        {
            final SubscriptionCallback b;
            
            SubscriptionCallbackApi26(final SubscriptionCallback b) {
                this.b = b.super();
            }
            
            public void onChildrenLoaded(final String s, final List<MediaBrowser$MediaItem> list, final Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.b.onChildrenLoaded(s, MediaItem.fromMediaItemList(list), bundle);
            }
            
            public void onError(final String s, final Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                this.b.onError(s, bundle);
            }
        }
    }
}
