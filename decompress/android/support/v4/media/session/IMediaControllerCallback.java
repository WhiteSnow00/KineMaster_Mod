// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media.session;

import android.os.Parcelable$Creator;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.Binder;
import android.os.IBinder;
import java.util.List;
import android.support.v4.media.MediaMetadataCompat;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IInterface;

public interface IMediaControllerCallback extends IInterface
{
    void onCaptioningEnabledChanged(final boolean p0) throws RemoteException;
    
    void onEvent(final String p0, final Bundle p1) throws RemoteException;
    
    void onExtrasChanged(final Bundle p0) throws RemoteException;
    
    void onMetadataChanged(final MediaMetadataCompat p0) throws RemoteException;
    
    void onPlaybackStateChanged(final PlaybackStateCompat p0) throws RemoteException;
    
    void onQueueChanged(final List<MediaSessionCompat.QueueItem> p0) throws RemoteException;
    
    void onQueueTitleChanged(final CharSequence p0) throws RemoteException;
    
    void onRepeatModeChanged(final int p0) throws RemoteException;
    
    void onSessionDestroyed() throws RemoteException;
    
    void onSessionReady() throws RemoteException;
    
    void onShuffleModeChanged(final int p0) throws RemoteException;
    
    void onShuffleModeChangedRemoved(final boolean p0) throws RemoteException;
    
    void onVolumeInfoChanged(final ParcelableVolumeInfo p0) throws RemoteException;
    
    public static class Default implements IMediaControllerCallback
    {
        public IBinder asBinder() {
            return null;
        }
        
        @Override
        public void onCaptioningEnabledChanged(final boolean b) throws RemoteException {
        }
        
        @Override
        public void onEvent(final String s, final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void onExtrasChanged(final Bundle bundle) throws RemoteException {
        }
        
        @Override
        public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        }
        
        @Override
        public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) throws RemoteException {
        }
        
        @Override
        public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) throws RemoteException {
        }
        
        @Override
        public void onQueueTitleChanged(final CharSequence charSequence) throws RemoteException {
        }
        
        @Override
        public void onRepeatModeChanged(final int n) throws RemoteException {
        }
        
        @Override
        public void onSessionDestroyed() throws RemoteException {
        }
        
        @Override
        public void onSessionReady() throws RemoteException {
        }
        
        @Override
        public void onShuffleModeChanged(final int n) throws RemoteException {
        }
        
        @Override
        public void onShuffleModeChangedRemoved(final boolean b) throws RemoteException {
        }
        
        @Override
        public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        }
    }
    
    public abstract static class Stub extends Binder implements IMediaControllerCallback
    {
        public Stub() {
            this.attachInterface((IInterface)this, "android.support.v4.media.session.IMediaControllerCallback");
        }
        
        public static IMediaControllerCallback asInterface(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface != null && queryLocalInterface instanceof IMediaControllerCallback) {
                return (IMediaControllerCallback)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public static IMediaControllerCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
        
        public static boolean setDefaultImpl(final IMediaControllerCallback sDefaultImpl) {
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
        
        public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            boolean b = false;
            final boolean b2 = false;
            final Bundle bundle = null;
            final CharSequence charSequence = null;
            final MediaMetadataCompat mediaMetadataCompat = null;
            final PlaybackStateCompat playbackStateCompat = null;
            final Bundle bundle2 = null;
            final ParcelableVolumeInfo parcelableVolumeInfo = null;
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 13: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onSessionReady();
                    return true;
                }
                case 12: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onShuffleModeChanged(parcel.readInt());
                    return true;
                }
                case 11: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    boolean b3 = b2;
                    if (parcel.readInt() != 0) {
                        b3 = true;
                    }
                    this.onCaptioningEnabledChanged(b3);
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        b = true;
                    }
                    this.onShuffleModeChangedRemoved(b);
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onRepeatModeChanged(parcel.readInt());
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
                    if (parcel.readInt() != 0) {
                        parcelableVolumeInfo2 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                    }
                    this.onVolumeInfoChanged(parcelableVolumeInfo2);
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    Bundle bundle3 = bundle;
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.onExtrasChanged(bundle3);
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    CharSequence charSequence2 = charSequence;
                    if (parcel.readInt() != 0) {
                        charSequence2 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    }
                    this.onQueueTitleChanged(charSequence2);
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onQueueChanged(parcel.createTypedArrayList((Parcelable$Creator)MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    MediaMetadataCompat mediaMetadataCompat2 = mediaMetadataCompat;
                    if (parcel.readInt() != 0) {
                        mediaMetadataCompat2 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.onMetadataChanged(mediaMetadataCompat2);
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
                    if (parcel.readInt() != 0) {
                        playbackStateCompat2 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                    }
                    this.onPlaybackStateChanged(playbackStateCompat2);
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    this.onSessionDestroyed();
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    final String string = parcel.readString();
                    Bundle bundle4 = bundle2;
                    if (parcel.readInt() != 0) {
                        bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.onEvent(string, bundle4);
                    return true;
                }
            }
        }
        
        private static class Proxy implements IMediaControllerCallback
        {
            public static IMediaControllerCallback sDefaultImpl;
            private IBinder a;
            
            Proxy(final IBinder a) {
                this.a = a;
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaControllerCallback";
            }
            
            @Override
            public void onCaptioningEnabledChanged(final boolean b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    int n;
                    if (b) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    obtain.writeInt(n);
                    if (!this.a.transact(11, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onCaptioningEnabledChanged(b);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onEvent(final String s, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeString(s);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onEvent(s, bundle);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onExtrasChanged(final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(7, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onExtrasChanged(bundle);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onMetadataChanged(final MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(4, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMetadataChanged(mediaMetadataCompat);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onPlaybackStateChanged(final PlaybackStateCompat playbackStateCompat) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(3, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPlaybackStateChanged(playbackStateCompat);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onQueueChanged(final List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList((List)list);
                    if (!this.a.transact(5, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onQueueChanged(list);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onQueueTitleChanged(final CharSequence charSequence) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(6, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onQueueTitleChanged(charSequence);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onRepeatModeChanged(final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(n);
                    if (!this.a.transact(9, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRepeatModeChanged(n);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onSessionDestroyed() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (!this.a.transact(2, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSessionDestroyed();
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onSessionReady() throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (!this.a.transact(13, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSessionReady();
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onShuffleModeChanged(final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(n);
                    if (!this.a.transact(12, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onShuffleModeChanged(n);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onShuffleModeChangedRemoved(final boolean b) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    int n;
                    if (b) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    obtain.writeInt(n);
                    if (!this.a.transact(10, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onShuffleModeChangedRemoved(b);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void onVolumeInfoChanged(final ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        obtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(8, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVolumeInfoChanged(parcelableVolumeInfo);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
        }
    }
}
