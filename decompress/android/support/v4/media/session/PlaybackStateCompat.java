// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media.session;

import android.media.session.PlaybackState$CustomAction$Builder;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.media.session.PlaybackState$Builder;
import android.os.SystemClock;
import java.util.Iterator;
import android.media.session.PlaybackState$CustomAction;
import android.text.TextUtils;
import java.util.Collection;
import java.util.ArrayList;
import android.os.Parcel;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class PlaybackStateCompat implements Parcelable
{
    public static final long ACTION_FAST_FORWARD = 64L;
    public static final long ACTION_PAUSE = 2L;
    public static final long ACTION_PLAY = 4L;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024L;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048L;
    public static final long ACTION_PLAY_FROM_URI = 8192L;
    public static final long ACTION_PLAY_PAUSE = 512L;
    public static final long ACTION_PREPARE = 16384L;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768L;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536L;
    public static final long ACTION_PREPARE_FROM_URI = 131072L;
    public static final long ACTION_REWIND = 8L;
    public static final long ACTION_SEEK_TO = 256L;
    public static final long ACTION_SET_CAPTIONING_ENABLED = 1048576L;
    public static final long ACTION_SET_PLAYBACK_SPEED = 4194304L;
    public static final long ACTION_SET_RATING = 128L;
    public static final long ACTION_SET_REPEAT_MODE = 262144L;
    public static final long ACTION_SET_SHUFFLE_MODE = 2097152L;
    @Deprecated
    public static final long ACTION_SET_SHUFFLE_MODE_ENABLED = 524288L;
    public static final long ACTION_SKIP_TO_NEXT = 32L;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16L;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096L;
    public static final long ACTION_STOP = 1L;
    public static final Parcelable$Creator<PlaybackStateCompat> CREATOR;
    public static final int ERROR_CODE_ACTION_ABORTED = 10;
    public static final int ERROR_CODE_APP_ERROR = 1;
    public static final int ERROR_CODE_AUTHENTICATION_EXPIRED = 3;
    public static final int ERROR_CODE_CONCURRENT_STREAM_LIMIT = 5;
    public static final int ERROR_CODE_CONTENT_ALREADY_PLAYING = 8;
    public static final int ERROR_CODE_END_OF_QUEUE = 11;
    public static final int ERROR_CODE_NOT_AVAILABLE_IN_REGION = 7;
    public static final int ERROR_CODE_NOT_SUPPORTED = 2;
    public static final int ERROR_CODE_PARENTAL_CONTROL_RESTRICTED = 6;
    public static final int ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED = 4;
    public static final int ERROR_CODE_SKIP_LIMIT_REACHED = 9;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1L;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_GROUP = 3;
    public static final int REPEAT_MODE_INVALID = -1;
    public static final int REPEAT_MODE_NONE = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int SHUFFLE_MODE_ALL = 1;
    public static final int SHUFFLE_MODE_GROUP = 2;
    public static final int SHUFFLE_MODE_INVALID = -1;
    public static final int SHUFFLE_MODE_NONE = 0;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    final int a;
    final long b;
    final long c;
    final float d;
    final long e;
    final int f;
    final CharSequence g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle p;
    private PlaybackState w;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<PlaybackStateCompat>() {
            public PlaybackStateCompat createFromParcel(final Parcel parcel) {
                return new PlaybackStateCompat(parcel);
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.createFromParcel(parcel);
            }
            
            public PlaybackStateCompat[] newArray(final int n) {
                return new PlaybackStateCompat[n];
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.newArray(n);
            }
        };
    }
    
    PlaybackStateCompat(final int a, final long b, final long c, final float d, final long e, final int f, final CharSequence g, final long h, final List<CustomAction> list, final long j, final Bundle p11) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = new ArrayList<CustomAction>(list);
        this.j = j;
        this.p = p11;
    }
    
    PlaybackStateCompat(final Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readLong();
        this.d = parcel.readFloat();
        this.h = parcel.readLong();
        this.c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList((Parcelable$Creator)CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.p = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f = parcel.readInt();
    }
    
    public static PlaybackStateCompat fromPlaybackState(final Object o) {
        PlaybackStateCompat playbackStateCompat = null;
        final List<CustomAction> list = null;
        if (o != null) {
            final PlaybackState w = (PlaybackState)o;
            final List<PlaybackState$CustomAction> j = Api21Impl.j(w);
            List<CustomAction> list2 = list;
            if (j != null) {
                final ArrayList list3 = new ArrayList<CustomAction>(j.size());
                final Iterator iterator = j.iterator();
                while (true) {
                    list2 = (List<CustomAction>)list3;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    list3.add((Object)CustomAction.fromCustomAction(iterator.next()));
                }
            }
            final Bundle a = Api22Impl.a(w);
            MediaSessionCompat.ensureClassLoader(a);
            playbackStateCompat = new PlaybackStateCompat(Api21Impl.r(w), Api21Impl.q(w), Api21Impl.i(w), Api21Impl.p(w), Api21Impl.g(w), 0, Api21Impl.k(w), Api21Impl.n(w), list2, Api21Impl.h(w), a);
            playbackStateCompat.w = w;
        }
        return playbackStateCompat;
    }
    
    public static int toKeyCode(final long n) {
        if (n == 4L) {
            return 126;
        }
        if (n == 2L) {
            return 127;
        }
        if (n == 32L) {
            return 87;
        }
        if (n == 16L) {
            return 88;
        }
        if (n == 1L) {
            return 86;
        }
        if (n == 64L) {
            return 90;
        }
        if (n == 8L) {
            return 89;
        }
        if (n == 512L) {
            return 85;
        }
        return 0;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public long getActions() {
        return this.e;
    }
    
    public long getActiveQueueItemId() {
        return this.j;
    }
    
    public long getBufferedPosition() {
        return this.c;
    }
    
    public long getCurrentPosition(final Long n) {
        final long b = this.b;
        final float d = this.d;
        long longValue;
        if (n != null) {
            longValue = n;
        }
        else {
            longValue = SystemClock.elapsedRealtime() - this.h;
        }
        return Math.max(0L, b + (long)(d * longValue));
    }
    
    public List<CustomAction> getCustomActions() {
        return this.i;
    }
    
    public int getErrorCode() {
        return this.f;
    }
    
    public CharSequence getErrorMessage() {
        return this.g;
    }
    
    public Bundle getExtras() {
        return this.p;
    }
    
    public long getLastPositionUpdateTime() {
        return this.h;
    }
    
    public float getPlaybackSpeed() {
        return this.d;
    }
    
    public Object getPlaybackState() {
        if (this.w == null) {
            final PlaybackState$Builder d = Api21Impl.d();
            Api21Impl.x(d, this.a, this.b, this.d, this.h);
            Api21Impl.u(d, this.c);
            Api21Impl.s(d, this.e);
            Api21Impl.v(d, this.g);
            final Iterator<CustomAction> iterator = this.i.iterator();
            while (iterator.hasNext()) {
                Api21Impl.a(d, (PlaybackState$CustomAction)iterator.next().getCustomAction());
            }
            Api21Impl.t(d, this.j);
            Api22Impl.b(d, this.p);
            this.w = Api21Impl.c(d);
        }
        return this.w;
    }
    
    public long getPosition() {
        return this.b;
    }
    
    public int getState() {
        return this.a;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.a);
        sb.append(", position=");
        sb.append(this.b);
        sb.append(", buffered position=");
        sb.append(this.c);
        sb.append(", speed=");
        sb.append(this.d);
        sb.append(", updated=");
        sb.append(this.h);
        sb.append(", actions=");
        sb.append(this.e);
        sb.append(", error code=");
        sb.append(this.f);
        sb.append(", error message=");
        sb.append(this.g);
        sb.append(", custom actions=");
        sb.append(this.i);
        sb.append(", active item id=");
        sb.append(this.j);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
        parcel.writeLong(this.b);
        parcel.writeFloat(this.d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel, n);
        parcel.writeTypedList((List)this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.f);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Actions {
    }
    
    private static class Api21Impl
    {
        static void a(final PlaybackState$Builder playbackState$Builder, final PlaybackState$CustomAction playbackState$CustomAction) {
            playbackState$Builder.addCustomAction(playbackState$CustomAction);
        }
        
        static PlaybackState$CustomAction b(final PlaybackState$CustomAction$Builder playbackState$CustomAction$Builder) {
            return playbackState$CustomAction$Builder.build();
        }
        
        static PlaybackState c(final PlaybackState$Builder playbackState$Builder) {
            return playbackState$Builder.build();
        }
        
        static PlaybackState$Builder d() {
            return new PlaybackState$Builder();
        }
        
        static PlaybackState$CustomAction$Builder e(final String s, final CharSequence charSequence, final int n) {
            return new PlaybackState$CustomAction$Builder(s, charSequence, n);
        }
        
        static String f(final PlaybackState$CustomAction playbackState$CustomAction) {
            return playbackState$CustomAction.getAction();
        }
        
        static long g(final PlaybackState playbackState) {
            return playbackState.getActions();
        }
        
        static long h(final PlaybackState playbackState) {
            return playbackState.getActiveQueueItemId();
        }
        
        static long i(final PlaybackState playbackState) {
            return playbackState.getBufferedPosition();
        }
        
        static List<PlaybackState$CustomAction> j(final PlaybackState playbackState) {
            return playbackState.getCustomActions();
        }
        
        static CharSequence k(final PlaybackState playbackState) {
            return playbackState.getErrorMessage();
        }
        
        static Bundle l(final PlaybackState$CustomAction playbackState$CustomAction) {
            return playbackState$CustomAction.getExtras();
        }
        
        static int m(final PlaybackState$CustomAction playbackState$CustomAction) {
            return playbackState$CustomAction.getIcon();
        }
        
        static long n(final PlaybackState playbackState) {
            return playbackState.getLastPositionUpdateTime();
        }
        
        static CharSequence o(final PlaybackState$CustomAction playbackState$CustomAction) {
            return playbackState$CustomAction.getName();
        }
        
        static float p(final PlaybackState playbackState) {
            return playbackState.getPlaybackSpeed();
        }
        
        static long q(final PlaybackState playbackState) {
            return playbackState.getPosition();
        }
        
        static int r(final PlaybackState playbackState) {
            return playbackState.getState();
        }
        
        static void s(final PlaybackState$Builder playbackState$Builder, final long actions) {
            playbackState$Builder.setActions(actions);
        }
        
        static void t(final PlaybackState$Builder playbackState$Builder, final long activeQueueItemId) {
            playbackState$Builder.setActiveQueueItemId(activeQueueItemId);
        }
        
        static void u(final PlaybackState$Builder playbackState$Builder, final long bufferedPosition) {
            playbackState$Builder.setBufferedPosition(bufferedPosition);
        }
        
        static void v(final PlaybackState$Builder playbackState$Builder, final CharSequence errorMessage) {
            playbackState$Builder.setErrorMessage(errorMessage);
        }
        
        static void w(final PlaybackState$CustomAction$Builder playbackState$CustomAction$Builder, final Bundle extras) {
            playbackState$CustomAction$Builder.setExtras(extras);
        }
        
        static void x(final PlaybackState$Builder playbackState$Builder, final int n, final long n2, final float n3, final long n4) {
            playbackState$Builder.setState(n, n2, n3, n4);
        }
    }
    
    private static class Api22Impl
    {
        static Bundle a(final PlaybackState playbackState) {
            return playbackState.getExtras();
        }
        
        static void b(final PlaybackState$Builder playbackState$Builder, final Bundle extras) {
            playbackState$Builder.setExtras(extras);
        }
    }
    
    public static final class Builder
    {
        private final List<CustomAction> a;
        private int b;
        private long c;
        private long d;
        private float e;
        private long f;
        private int g;
        private CharSequence h;
        private long i;
        private long j;
        private Bundle k;
        
        public Builder() {
            this.a = new ArrayList<CustomAction>();
            this.j = -1L;
        }
        
        public Builder(final PlaybackStateCompat playbackStateCompat) {
            final ArrayList a = new ArrayList();
            this.a = a;
            this.j = -1L;
            this.b = playbackStateCompat.a;
            this.c = playbackStateCompat.b;
            this.e = playbackStateCompat.d;
            this.i = playbackStateCompat.h;
            this.d = playbackStateCompat.c;
            this.f = playbackStateCompat.e;
            this.g = playbackStateCompat.f;
            this.h = playbackStateCompat.g;
            final List<CustomAction> i = playbackStateCompat.i;
            if (i != null) {
                a.addAll(i);
            }
            this.j = playbackStateCompat.j;
            this.k = playbackStateCompat.p;
        }
        
        public Builder addCustomAction(final CustomAction customAction) {
            if (customAction != null) {
                this.a.add(customAction);
                return this;
            }
            throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat");
        }
        
        public Builder addCustomAction(final String s, final String s2, final int n) {
            return this.addCustomAction(new CustomAction(s, s2, n, null));
        }
        
        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.a, this.j, this.k);
        }
        
        public Builder setActions(final long f) {
            this.f = f;
            return this;
        }
        
        public Builder setActiveQueueItemId(final long j) {
            this.j = j;
            return this;
        }
        
        public Builder setBufferedPosition(final long d) {
            this.d = d;
            return this;
        }
        
        public Builder setErrorMessage(final int g, final CharSequence h) {
            this.g = g;
            this.h = h;
            return this;
        }
        
        @Deprecated
        public Builder setErrorMessage(final CharSequence h) {
            this.h = h;
            return this;
        }
        
        public Builder setExtras(final Bundle k) {
            this.k = k;
            return this;
        }
        
        public Builder setState(final int n, final long n2, final float n3) {
            return this.setState(n, n2, n3, SystemClock.elapsedRealtime());
        }
        
        public Builder setState(final int b, final long c, final float e, final long i) {
            this.b = b;
            this.c = c;
            this.i = i;
            this.e = e;
            return this;
        }
    }
    
    public static final class CustomAction implements Parcelable
    {
        public static final Parcelable$Creator<CustomAction> CREATOR;
        private final String a;
        private final CharSequence b;
        private final int c;
        private final Bundle d;
        private PlaybackState$CustomAction e;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$Creator<CustomAction>() {
                public CustomAction createFromParcel(final Parcel parcel) {
                    return new CustomAction(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.createFromParcel(parcel);
                }
                
                public CustomAction[] newArray(final int n) {
                    return new CustomAction[n];
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.newArray(n);
                }
            };
        }
        
        CustomAction(final Parcel parcel) {
            this.a = parcel.readString();
            this.b = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.c = parcel.readInt();
            this.d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
        
        CustomAction(final String a, final CharSequence b, final int c, final Bundle d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public static CustomAction fromCustomAction(final Object o) {
            if (o != null) {
                final PlaybackState$CustomAction e = (PlaybackState$CustomAction)o;
                final Bundle l = Api21Impl.l(e);
                MediaSessionCompat.ensureClassLoader(l);
                final CustomAction customAction = new CustomAction(Api21Impl.f(e), Api21Impl.o(e), Api21Impl.m(e), l);
                customAction.e = e;
                return customAction;
            }
            return null;
        }
        
        public int describeContents() {
            return 0;
        }
        
        public String getAction() {
            return this.a;
        }
        
        public Object getCustomAction() {
            PlaybackState$CustomAction playbackState$CustomAction;
            if ((playbackState$CustomAction = this.e) == null) {
                final PlaybackState$CustomAction$Builder e = Api21Impl.e(this.a, this.b, this.c);
                Api21Impl.w(e, this.d);
                playbackState$CustomAction = Api21Impl.b(e);
            }
            return playbackState$CustomAction;
        }
        
        public Bundle getExtras() {
            return this.d;
        }
        
        public int getIcon() {
            return this.c;
        }
        
        public CharSequence getName() {
            return this.b;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Action:mName='");
            sb.append((Object)this.b);
            sb.append(", mIcon=");
            sb.append(this.c);
            sb.append(", mExtras=");
            sb.append(this.d);
            return sb.toString();
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, n);
            parcel.writeInt(this.c);
            parcel.writeBundle(this.d);
        }
        
        public static final class Builder
        {
            private final String a;
            private final CharSequence b;
            private final int c;
            private Bundle d;
            
            public Builder(final String a, final CharSequence b, final int c) {
                if (TextUtils.isEmpty((CharSequence)a)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction");
                }
                if (TextUtils.isEmpty(b)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction");
                }
                if (c != 0) {
                    this.a = a;
                    this.b = b;
                    this.c = c;
                    return;
                }
                throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction");
            }
            
            public CustomAction build() {
                return new CustomAction(this.a, this.b, this.c, this.d);
            }
            
            public Builder setExtras(final Bundle d) {
                this.d = d;
                return this;
            }
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaKeyAction {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShuffleMode {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }
}
