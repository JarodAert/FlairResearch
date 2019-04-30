package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator()
  {
    public FragmentState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FragmentState(paramAnonymousParcel);
    }
    
    public FragmentState[] newArray(int paramAnonymousInt)
    {
      return new FragmentState[paramAnonymousInt];
    }
  };
  final Bundle mArguments;
  final String mClassName;
  final int mContainerId;
  final boolean mDetached;
  final int mFragmentId;
  final boolean mFromLayout;
  final int mIndex;
  Fragment mInstance;
  final boolean mRetainInstance;
  Bundle mSavedFragmentState;
  final String mTag;
  
  public FragmentState(Parcel paramParcel)
  {
    mClassName = paramParcel.readString();
    mIndex = paramParcel.readInt();
    boolean bool2;
    boolean bool3;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      mFromLayout = bool2;
      mFragmentId = paramParcel.readInt();
      mContainerId = paramParcel.readInt();
      mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label110;
      }
      bool3 = bool1;
      label70:
      mRetainInstance = bool3;
      if (paramParcel.readInt() == 0) {
        break label116;
      }
    }
    for (;;)
    {
      mDetached = bool1;
      mArguments = paramParcel.readBundle();
      mSavedFragmentState = paramParcel.readBundle();
      return;
      bool2 = false;
      break;
      label110:
      bool3 = false;
      break label70;
      label116:
      bool1 = false;
    }
  }
  
  public FragmentState(Fragment paramFragment)
  {
    mClassName = paramFragment.getClass().getName();
    mIndex = mIndex;
    mFromLayout = mFromLayout;
    mFragmentId = mFragmentId;
    mContainerId = mContainerId;
    mTag = mTag;
    mRetainInstance = mRetainInstance;
    mDetached = mDetached;
    mArguments = mArguments;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Fragment instantiate(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    if (mInstance != null) {
      return mInstance;
    }
    if (mArguments != null) {
      mArguments.setClassLoader(paramFragmentActivity.getClassLoader());
    }
    mInstance = Fragment.instantiate(paramFragmentActivity, mClassName, mArguments);
    if (mSavedFragmentState != null)
    {
      mSavedFragmentState.setClassLoader(paramFragmentActivity.getClassLoader());
      mInstance.mSavedFragmentState = mSavedFragmentState;
    }
    mInstance.setIndex(mIndex, paramFragment);
    mInstance.mFromLayout = mFromLayout;
    mInstance.mRestored = true;
    mInstance.mFragmentId = mFragmentId;
    mInstance.mContainerId = mContainerId;
    mInstance.mTag = mTag;
    mInstance.mRetainInstance = mRetainInstance;
    mInstance.mDetached = mDetached;
    mInstance.mFragmentManager = mFragments;
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Instantiated fragment " + mInstance);
    }
    return mInstance;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(mClassName);
    paramParcel.writeInt(mIndex);
    int j;
    int k;
    if (mFromLayout)
    {
      j = i;
      paramParcel.writeInt(j);
      paramParcel.writeInt(mFragmentId);
      paramParcel.writeInt(mContainerId);
      paramParcel.writeString(mTag);
      if (!mRetainInstance) {
        break label109;
      }
      k = i;
      label68:
      paramParcel.writeInt(k);
      if (!mDetached) {
        break label115;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(i);
      paramParcel.writeBundle(mArguments);
      paramParcel.writeBundle(mSavedFragmentState);
      return;
      j = 0;
      break;
      label109:
      k = 0;
      break label68;
      label115:
      i = 0;
    }
  }
}
