// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media.session;

import android.os.Parcelable$Creator;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.Binder;
import android.os.IBinder;
import android.view.KeyEvent;
import android.support.v4.media.RatingCompat;
import android.net.Uri;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.os.IInterface;

public interface IMediaSession extends IInterface
{
    void addQueueItem(final MediaDescriptionCompat p0) throws RemoteException;
    
    void addQueueItemAt(final MediaDescriptionCompat p0, final int p1) throws RemoteException;
    
    void adjustVolume(final int p0, final int p1, final String p2) throws RemoteException;
    
    void fastForward() throws RemoteException;
    
    Bundle getExtras() throws RemoteException;
    
    long getFlags() throws RemoteException;
    
    PendingIntent getLaunchPendingIntent() throws RemoteException;
    
    MediaMetadataCompat getMetadata() throws RemoteException;
    
    String getPackageName() throws RemoteException;
    
    PlaybackStateCompat getPlaybackState() throws RemoteException;
    
    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;
    
    CharSequence getQueueTitle() throws RemoteException;
    
    int getRatingType() throws RemoteException;
    
    int getRepeatMode() throws RemoteException;
    
    Bundle getSessionInfo() throws RemoteException;
    
    int getShuffleMode() throws RemoteException;
    
    String getTag() throws RemoteException;
    
    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;
    
    boolean isCaptioningEnabled() throws RemoteException;
    
    boolean isShuffleModeEnabledRemoved() throws RemoteException;
    
    boolean isTransportControlEnabled() throws RemoteException;
    
    void next() throws RemoteException;
    
    void pause() throws RemoteException;
    
    void play() throws RemoteException;
    
    void playFromMediaId(final String p0, final Bundle p1) throws RemoteException;
    
    void playFromSearch(final String p0, final Bundle p1) throws RemoteException;
    
    void playFromUri(final Uri p0, final Bundle p1) throws RemoteException;
    
    void prepare() throws RemoteException;
    
    void prepareFromMediaId(final String p0, final Bundle p1) throws RemoteException;
    
    void prepareFromSearch(final String p0, final Bundle p1) throws RemoteException;
    
    void prepareFromUri(final Uri p0, final Bundle p1) throws RemoteException;
    
    void previous() throws RemoteException;
    
    void rate(final RatingCompat p0) throws RemoteException;
    
    void rateWithExtras(final RatingCompat p0, final Bundle p1) throws RemoteException;
    
    void registerCallbackListener(final IMediaControllerCallback p0) throws RemoteException;
    
    void removeQueueItem(final MediaDescriptionCompat p0) throws RemoteException;
    
    void removeQueueItemAt(final int p0) throws RemoteException;
    
    void rewind() throws RemoteException;
    
    void seekTo(final long p0) throws RemoteException;
    
    void sendCommand(final String p0, final Bundle p1, final MediaSessionCompat.ResultReceiverWrapper p2) throws RemoteException;
    
    void sendCustomAction(final String p0, final Bundle p1) throws RemoteException;
    
    boolean sendMediaButton(final KeyEvent p0) throws RemoteException;
    
    void setCaptioningEnabled(final boolean p0) throws RemoteException;
    
    void setPlaybackSpeed(final float p0) throws RemoteException;
    
    void setRepeatMode(final int p0) throws RemoteException;
    
    void setShuffleMode(final int p0) throws RemoteException;
    
    void setShuffleModeEnabledRemoved(final boolean p0) throws RemoteException;
    
    void setVolumeTo(final int p0, final int p1, final String p2) throws RemoteException;
    
    void skipToQueueItem(final long p0) throws RemoteException;
    
    void stop() throws RemoteException;
    
    void unregisterCallbackListener(final IMediaControllerCallback p0) throws RemoteException;
    
    public static class Default implements IMediaSession
    {
        @Override
        public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }
        
        @Override
        public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) throws RemoteException {
        }
        
        @Override
        public void adjustVolume(final int n, final int n2, final String s) throws RemoteException {
        }
        
        public IBinder asBinder() {
            return null;
        }
        
        @Override
        public void fastForward() throws RemoteException {
        }
        
        @Override
        public Bundle getExtras() throws RemoteException {
            return null;
        }
        
        @Override
        public long getFlags() throws RemoteException {
            return 0L;
        }
        
        @Override
        public PendingIntent getLaunchPendingIntent() throws RemoteException {
            return null;
        }
        
        @Override
        public MediaMetadataCompat getMetadata() throws RemoteException {
            return null;
        }
        
        @Override
        public String getPackageName() throws RemoteException {
            return null;
        }
        
        @Override
        public PlaybackStateCompat getPlaybackState() throws RemoteException {
            return null;
        }
        
        @Override
        public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
            return null;
        }
        
        @Override
        public CharSequence getQueueTitle() throws RemoteException {
            return null;
        }
        
        @Override
        public int getRatingType() throws RemoteException {
            return 0;
        }
        
        @Override
        public int getRepeatMode() throws RemoteException {
            return 0;
        }
        
        @Override
        public Bundle getSessionInfo() throws RemoteException {
            return null;
        }
        
        @Override
        public int getShuffleMode() throws RemoteException {
            return 0;
        }
        
        @Override
        public String getTag() throws RemoteException {
            return null;
        }
        
        @Override
        public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
            return null;
        }
        
        @Override
        public boolean isCaptioningEnabled() throws RemoteException {
            return false;
        }
        
        @Override
        public boolean isShuffleModeEnabledRemoved() throws RemoteException {
            return false;
        }
        
        @Override
        public boolean isTransportControlEnabled() throws RemoteException {
            return false;
        }
        
        @Override
        public void next() throws RemoteException {
        }
        
        @Override
        public void pause() throws RemoteException {
        }
        
        @Override
        public void play() throws RemoteException {
        }
        
        @Override
        public void playFromMediaId(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void playFromSearch(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void playFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void prepare() throws RemoteException {
        }
        
        @Override
        public void prepareFromMediaId(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void prepareFromSearch(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void prepareFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void previous() throws RemoteException {
        }
        
        @Override
        public void rate(final RatingCompat ratingCompat) throws RemoteException {
        }
        
        @Override
        public void rateWithExtras(final RatingCompat ratingCompat, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) throws RemoteException {
        }
        
        @Override
        public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
        }
        
        @Override
        public void removeQueueItemAt(final int n) throws RemoteException {
        }
        
        @Override
        public void rewind() throws RemoteException {
        }
        
        @Override
        public void seekTo(final long n) throws RemoteException {
        }
        
        @Override
        public void sendCommand(final String s, final Bundle bundle, final MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
        }
        
        @Override
        public void sendCustomAction(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public boolean sendMediaButton(final KeyEvent keyEvent) throws RemoteException {
            return false;
        }
        
        @Override
        public void setCaptioningEnabled(final boolean b) throws RemoteException {
        }
        
        @Override
        public void setPlaybackSpeed(final float n) throws RemoteException {
        }
        
        @Override
        public void setRepeatMode(final int n) throws RemoteException {
        }
        
        @Override
        public void setShuffleMode(final int n) throws RemoteException {
        }
        
        @Override
        public void setShuffleModeEnabledRemoved(final boolean b) throws RemoteException {
        }
        
        @Override
        public void setVolumeTo(final int n, final int n2, final String s) throws RemoteException {
        }
        
        @Override
        public void skipToQueueItem(final long n) throws RemoteException {
        }
        
        @Override
        public void stop() throws RemoteException {
        }
        
        @Override
        public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) throws RemoteException {
        }
    }
    
    public abstract static class Stub extends Binder implements IMediaSession
    {
        public Stub() {
            this.attachInterface((IInterface)this, "android.support.v4.media.session.IMediaSession");
        }
        
        public static IMediaSession asInterface(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && queryLocalInterface instanceof IMediaSession) {
                return (IMediaSession)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
        
        public static boolean setDefaultImpl(final IMediaSession sDefaultImpl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (sDefaultImpl != null) {
                Proxy.sDefaultImpl = sDefaultImpl;
                return true;
            }
            return false;
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            final boolean b = false;
            boolean captioningEnabled = false;
            final MediaDescriptionCompat mediaDescriptionCompat = null;
            final MediaDescriptionCompat mediaDescriptionCompat2 = null;
            final MediaDescriptionCompat mediaDescriptionCompat3 = null;
            final Bundle bundle = null;
            Bundle bundle2 = null;
            final Bundle bundle3 = null;
            final Bundle bundle4 = null;
            final RatingCompat ratingCompat = null;
            final Bundle bundle5 = null;
            final Bundle bundle6 = null;
            final Bundle bundle7 = null;
            final KeyEvent keyEvent = null;
            MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper = null;
            final Bundle bundle8 = null;
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 51: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    RatingCompat ratingCompat2;
                    if (parcel.readInt() != 0) {
                        ratingCompat2 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        ratingCompat2 = null;
                    }
                    Bundle bundle9 = bundle8;
                    if (parcel.readInt() != 0) {
                        bundle9 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.rateWithExtras(ratingCompat2, bundle9);
                    parcel2.writeNoException();
                    return true;
                }
                case 50: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final Bundle sessionInfo = this.getSessionInfo();
                    parcel2.writeNoException();
                    if (sessionInfo != null) {
                        parcel2.writeInt(1);
                        sessionInfo.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 49: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setPlaybackSpeed(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                }
                case 48: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setShuffleMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 47: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = this.getShuffleMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 46: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    if (parcel.readInt() != 0) {
                        captioningEnabled = true;
                    }
                    this.setCaptioningEnabled(captioningEnabled);
                    parcel2.writeNoException();
                    return true;
                }
                case 45: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = (this.isCaptioningEnabled() ? 1 : 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 44: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.removeQueueItemAt(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 43: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaDescriptionCompat mediaDescriptionCompat4 = mediaDescriptionCompat;
                    if (parcel.readInt() != 0) {
                        mediaDescriptionCompat4 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.removeQueueItem(mediaDescriptionCompat4);
                    parcel2.writeNoException();
                    return true;
                }
                case 42: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaDescriptionCompat mediaDescriptionCompat5 = mediaDescriptionCompat2;
                    if (parcel.readInt() != 0) {
                        mediaDescriptionCompat5 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.addQueueItemAt(mediaDescriptionCompat5, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 41: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    MediaDescriptionCompat mediaDescriptionCompat6 = mediaDescriptionCompat3;
                    if (parcel.readInt() != 0) {
                        mediaDescriptionCompat6 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.addQueueItem(mediaDescriptionCompat6);
                    parcel2.writeNoException();
                    return true;
                }
                case 40: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    boolean shuffleModeEnabledRemoved = b;
                    if (parcel.readInt() != 0) {
                        shuffleModeEnabledRemoved = true;
                    }
                    this.setShuffleModeEnabledRemoved(shuffleModeEnabledRemoved);
                    parcel2.writeNoException();
                    return true;
                }
                case 39: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setRepeatMode(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 38: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = (this.isShuffleModeEnabledRemoved() ? 1 : 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 37: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = this.getRepeatMode();
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 36: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Uri uri;
                    if (parcel.readInt() != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        uri = null;
                    }
                    Bundle bundle10 = bundle;
                    if (parcel.readInt() != 0) {
                        bundle10 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.prepareFromUri(uri, bundle10);
                    parcel2.writeNoException();
                    return true;
                }
                case 35: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.prepareFromSearch(string, bundle2);
                    parcel2.writeNoException();
                    return true;
                }
                case 34: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string2 = parcel.readString();
                    Bundle bundle11 = bundle3;
                    if (parcel.readInt() != 0) {
                        bundle11 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.prepareFromMediaId(string2, bundle11);
                    parcel2.writeNoException();
                    return true;
                }
                case 33: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.prepare();
                    parcel2.writeNoException();
                    return true;
                }
                case 32: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = this.getRatingType();
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 31: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final Bundle extras = this.getExtras();
                    parcel2.writeNoException();
                    if (extras != null) {
                        parcel2.writeInt(1);
                        extras.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 30: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final CharSequence queueTitle = this.getQueueTitle();
                    parcel2.writeNoException();
                    if (queueTitle != null) {
                        parcel2.writeInt(1);
                        TextUtils.writeToParcel(queueTitle, parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 29: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final List<MediaSessionCompat.QueueItem> queue = this.getQueue();
                    parcel2.writeNoException();
                    parcel2.writeTypedList((List)queue);
                    return true;
                }
                case 28: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final PlaybackStateCompat playbackState = this.getPlaybackState();
                    parcel2.writeNoException();
                    if (playbackState != null) {
                        parcel2.writeInt(1);
                        playbackState.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 27: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final MediaMetadataCompat metadata = this.getMetadata();
                    parcel2.writeNoException();
                    if (metadata != null) {
                        parcel2.writeInt(1);
                        metadata.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 26: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string3 = parcel.readString();
                    Bundle bundle12 = bundle4;
                    if (parcel.readInt() != 0) {
                        bundle12 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.sendCustomAction(string3, bundle12);
                    parcel2.writeNoException();
                    return true;
                }
                case 25: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    RatingCompat ratingCompat3 = ratingCompat;
                    if (parcel.readInt() != 0) {
                        ratingCompat3 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.rate(ratingCompat3);
                    parcel2.writeNoException();
                    return true;
                }
                case 24: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.seekTo(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                }
                case 23: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.rewind();
                    parcel2.writeNoException();
                    return true;
                }
                case 22: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.fastForward();
                    parcel2.writeNoException();
                    return true;
                }
                case 21: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.previous();
                    parcel2.writeNoException();
                    return true;
                }
                case 20: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.next();
                    parcel2.writeNoException();
                    return true;
                }
                case 19: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.stop();
                    parcel2.writeNoException();
                    return true;
                }
                case 18: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.pause();
                    parcel2.writeNoException();
                    return true;
                }
                case 17: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.skipToQueueItem(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                }
                case 16: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    Uri uri2;
                    if (parcel.readInt() != 0) {
                        uri2 = (Uri)Uri.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        uri2 = null;
                    }
                    Bundle bundle13 = bundle5;
                    if (parcel.readInt() != 0) {
                        bundle13 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.playFromUri(uri2, bundle13);
                    parcel2.writeNoException();
                    return true;
                }
                case 15: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string4 = parcel.readString();
                    Bundle bundle14 = bundle6;
                    if (parcel.readInt() != 0) {
                        bundle14 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.playFromSearch(string4, bundle14);
                    parcel2.writeNoException();
                    return true;
                }
                case 14: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string5 = parcel.readString();
                    Bundle bundle15 = bundle7;
                    if (parcel.readInt() != 0) {
                        bundle15 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.playFromMediaId(string5, bundle15);
                    parcel2.writeNoException();
                    return true;
                }
                case 13: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.play();
                    parcel2.writeNoException();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.setVolumeTo(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.adjustVolume(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final ParcelableVolumeInfo volumeAttributes = this.getVolumeAttributes();
                    parcel2.writeNoException();
                    if (volumeAttributes != null) {
                        parcel2.writeInt(1);
                        volumeAttributes.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final long flags = this.getFlags();
                    parcel2.writeNoException();
                    parcel2.writeLong(flags);
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final PendingIntent launchPendingIntent = this.getLaunchPendingIntent();
                    parcel2.writeNoException();
                    if (launchPendingIntent != null) {
                        parcel2.writeInt(1);
                        launchPendingIntent.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String tag = this.getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String packageName = this.getPackageName();
                    parcel2.writeNoException();
                    parcel2.writeString(packageName);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    n = (this.isTransportControlEnabled() ? 1 : 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    this.registerCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    KeyEvent keyEvent2 = keyEvent;
                    if (parcel.readInt() != 0) {
                        keyEvent2 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
                    }
                    n = (this.sendMediaButton(keyEvent2) ? 1 : 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                    final String string6 = parcel.readString();
                    Bundle bundle16;
                    if (parcel.readInt() != 0) {
                        bundle16 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        bundle16 = null;
                    }
                    if (parcel.readInt() != 0) {
                        resultReceiverWrapper = (MediaSessionCompat.ResultReceiverWrapper)MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel);
                    }
                    this.sendCommand(string6, bundle16, resultReceiverWrapper);
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
        
        private static class Proxy implements IMediaSession
        {
            public static IMediaSession sDefaultImpl;
            private IBinder a;
            
            Proxy(final IBinder a) {
                this.a = a;
            }
            
            @Override
            public void addQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(41, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addQueueItem(mediaDescriptionCompat);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void addQueueItemAt(final MediaDescriptionCompat mediaDescriptionCompat, final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(n);
                    if (!this.a.transact(42, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addQueueItemAt(mediaDescriptionCompat, n);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void adjustVolume(final int n, final int n2, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(n);
                    obtain.writeInt(n2);
                    obtain.writeString(s);
                    if (!this.a.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().adjustVolume(n, n2, s);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            @Override
            public void fastForward() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().fastForward();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public Bundle getExtras() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getExtras();
                    }
                    obtain2.readException();
                    Bundle bundle;
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle)Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        bundle = null;
                    }
                    return bundle;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public long getFlags() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getFlags();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaSession";
            }
            
            @Override
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLaunchPendingIntent();
                    }
                    obtain2.readException();
                    PendingIntent pendingIntent;
                    if (obtain2.readInt() != 0) {
                        pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        pendingIntent = null;
                    }
                    return pendingIntent;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public MediaMetadataCompat getMetadata() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getMetadata();
                    }
                    obtain2.readException();
                    MediaMetadataCompat mediaMetadataCompat;
                    if (obtain2.readInt() != 0) {
                        mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        mediaMetadataCompat = null;
                    }
                    return mediaMetadataCompat;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String getPackageName() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPackageName();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlaybackState();
                    }
                    obtain2.readException();
                    PlaybackStateCompat playbackStateCompat;
                    if (obtain2.readInt() != 0) {
                        playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        playbackStateCompat = null;
                    }
                    return playbackStateCompat;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getQueue();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList((Parcelable$Creator)MediaSessionCompat.QueueItem.CREATOR);
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public CharSequence getQueueTitle() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getQueueTitle();
                    }
                    obtain2.readException();
                    CharSequence charSequence;
                    if (obtain2.readInt() != 0) {
                        charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        charSequence = null;
                    }
                    return charSequence;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public int getRatingType() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRatingType();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public int getRepeatMode() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getRepeatMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public Bundle getSessionInfo() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(50, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSessionInfo();
                    }
                    obtain2.readException();
                    Bundle bundle;
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle)Bundle.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        bundle = null;
                    }
                    return bundle;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public int getShuffleMode() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(47, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getShuffleMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public String getTag() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getTag();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVolumeAttributes();
                    }
                    obtain2.readException();
                    ParcelableVolumeInfo parcelableVolumeInfo;
                    if (obtain2.readInt() != 0) {
                        parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2);
                    }
                    else {
                        parcelableVolumeInfo = null;
                    }
                    return parcelableVolumeInfo;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean isCaptioningEnabled() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    final IBinder a = this.a;
                    boolean b = false;
                    if (!a.transact(45, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCaptioningEnabled();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    final IBinder a = this.a;
                    boolean b = false;
                    if (!a.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isShuffleModeEnabledRemoved();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean isTransportControlEnabled() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    final IBinder a = this.a;
                    boolean b = false;
                    if (!a.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isTransportControlEnabled();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void next() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().next();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void pause() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pause();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void play() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().play();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void playFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().playFromMediaId(s, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void playFromSearch(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().playFromSearch(s, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void playFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().playFromUri(uri, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void prepare() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepare();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void prepareFromMediaId(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepareFromMediaId(s, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void prepareFromSearch(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepareFromSearch(s, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void prepareFromUri(final Uri uri, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepareFromUri(uri, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void previous() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().previous();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void rate(final RatingCompat ratingCompat) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().rate(ratingCompat);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void rateWithExtras(final RatingCompat ratingCompat, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (ratingCompat != null) {
                        obtain.writeInt(1);
                        ratingCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(51, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().rateWithExtras(ratingCompat, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void registerCallbackListener(final IMediaControllerCallback mediaControllerCallback) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    IBinder binder;
                    if (mediaControllerCallback != null) {
                        binder = ((IInterface)mediaControllerCallback).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    if (!this.a.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerCallbackListener(mediaControllerCallback);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void removeQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (mediaDescriptionCompat != null) {
                        obtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(43, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeQueueItem(mediaDescriptionCompat);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void removeQueueItemAt(final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(n);
                    if (!this.a.transact(44, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeQueueItemAt(n);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void rewind() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().rewind();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void seekTo(final long n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeLong(n);
                    if (!this.a.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().seekTo(n);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void sendCommand(final String s, final Bundle bundle, final MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiverWrapper != null) {
                        obtain.writeInt(1);
                        resultReceiverWrapper.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCommand(s, bundle, resultReceiverWrapper);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void sendCustomAction(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCustomAction(s, bundle);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean sendMediaButton(final KeyEvent keyEvent) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean b = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().sendMediaButton(keyEvent);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        b = false;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setCaptioningEnabled(final boolean captioningEnabled) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    int n;
                    if (captioningEnabled) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    obtain.writeInt(n);
                    if (!this.a.transact(46, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setCaptioningEnabled(captioningEnabled);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setPlaybackSpeed(final float playbackSpeed) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeFloat(playbackSpeed);
                    if (!this.a.transact(49, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPlaybackSpeed(playbackSpeed);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setRepeatMode(final int repeatMode) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(repeatMode);
                    if (!this.a.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setRepeatMode(repeatMode);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setShuffleMode(final int shuffleMode) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(shuffleMode);
                    if (!this.a.transact(48, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setShuffleMode(shuffleMode);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setShuffleModeEnabledRemoved(final boolean shuffleModeEnabledRemoved) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    int n;
                    if (shuffleModeEnabledRemoved) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    obtain.writeInt(n);
                    if (!this.a.transact(40, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setShuffleModeEnabledRemoved(shuffleModeEnabledRemoved);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void setVolumeTo(final int n, final int n2, final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeInt(n);
                    obtain.writeInt(n2);
                    obtain.writeString(s);
                    if (!this.a.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setVolumeTo(n, n2, s);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void skipToQueueItem(final long n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeLong(n);
                    if (!this.a.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().skipToQueueItem(n);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void stop() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.a.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stop();
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public void unregisterCallbackListener(final IMediaControllerCallback mediaControllerCallback) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    IBinder binder;
                    if (mediaControllerCallback != null) {
                        binder = ((IInterface)mediaControllerCallback).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    if (!this.a.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().unregisterCallbackListener(mediaControllerCallback);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
