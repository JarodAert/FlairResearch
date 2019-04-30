package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerICS
  extends AdapterViewICS<SpinnerAdapter>
{
  SpinnerAdapter mAdapter;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  final RecycleBin mRecycler = new RecycleBin();
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  AbsSpinnerICS(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  AbsSpinnerICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsSpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return mAdapter;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int getChildWidth(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getCount()
  {
    return mItemCount;
  }
  
  public View getSelectedView()
  {
    if ((mItemCount > 0) && (mSelectedPosition >= 0)) {
      return getChildAt(mSelectedPosition - mFirstPosition);
    }
    return null;
  }
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    int m = getPaddingRight();
    int n = getPaddingBottom();
    Rect localRect1 = mSpinnerPadding;
    label66:
    label88:
    Rect localRect4;
    if (j > mSelectionLeftPadding)
    {
      left = j;
      Rect localRect2 = mSpinnerPadding;
      if (k <= mSelectionTopPadding) {
        break label438;
      }
      top = k;
      Rect localRect3 = mSpinnerPadding;
      if (m <= mSelectionRightPadding) {
        break label447;
      }
      right = m;
      localRect4 = mSpinnerPadding;
      if (n <= mSelectionBottomPadding) {
        break label456;
      }
    }
    for (;;)
    {
      bottom = n;
      if (mDataChanged) {
        handleDataChanged();
      }
      int i1 = 1;
      int i2 = getSelectedItemPosition();
      int i3 = 0;
      int i4 = 0;
      if (i2 >= 0)
      {
        SpinnerAdapter localSpinnerAdapter = mAdapter;
        i3 = 0;
        i4 = 0;
        if (localSpinnerAdapter != null)
        {
          int i8 = mAdapter.getCount();
          i3 = 0;
          i4 = 0;
          if (i2 < i8)
          {
            View localView = mRecycler.get(i2);
            if (localView == null) {
              localView = mAdapter.getView(i2, null, this);
            }
            if (localView != null) {
              mRecycler.put(i2, localView);
            }
            i3 = 0;
            i4 = 0;
            if (localView != null)
            {
              if (localView.getLayoutParams() == null)
              {
                mBlockLayoutRequests = true;
                localView.setLayoutParams(generateDefaultLayoutParams());
                mBlockLayoutRequests = false;
              }
              measureChild(localView, paramInt1, paramInt2);
              i3 = getChildHeight(localView) + mSpinnerPadding.top + mSpinnerPadding.bottom;
              i4 = getChildWidth(localView) + mSpinnerPadding.left + mSpinnerPadding.right;
              i1 = 0;
            }
          }
        }
      }
      if (i1 != 0)
      {
        i3 = mSpinnerPadding.top + mSpinnerPadding.bottom;
        if (i == 0) {
          i4 = mSpinnerPadding.left + mSpinnerPadding.right;
        }
      }
      int i5 = Math.max(i3, getSuggestedMinimumHeight());
      int i6 = Math.max(i4, getSuggestedMinimumWidth());
      int i7 = resolveSize(i5, paramInt2);
      setMeasuredDimension(resolveSize(i6, paramInt1), i7);
      mHeightMeasureSpec = paramInt2;
      mWidthMeasureSpec = paramInt1;
      return;
      j = mSelectionLeftPadding;
      break;
      label438:
      k = mSelectionTopPadding;
      break label66;
      label447:
      m = mSelectionRightPadding;
      break label88;
      label456:
      n = mSelectionBottomPadding;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (selectedId >= 0L)
    {
      mDataChanged = true;
      mNeedSync = true;
      mSyncRowId = selectedId;
      mSyncPosition = position;
      mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    selectedId = getSelectedItemId();
    if (selectedId >= 0L)
    {
      position = getSelectedItemPosition();
      return localSavedState;
    }
    position = -1;
    return localSavedState;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Rect localRect = mTouchFrame;
    if (localRect == null)
    {
      mTouchFrame = new Rect();
      localRect = mTouchFrame;
    }
    for (int i = -1 + getChildCount(); i >= 0; i--)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        localView.getHitRect(localRect);
        if (localRect.contains(paramInt1, paramInt2)) {
          return i + mFirstPosition;
        }
      }
    }
    return -1;
  }
  
  void recycleAllViews()
  {
    int i = getChildCount();
    RecycleBin localRecycleBin = mRecycler;
    int j = mFirstPosition;
    for (int k = 0; k < i; k++)
    {
      View localView = getChildAt(k);
      localRecycleBin.put(j + k, localView);
    }
  }
  
  public void requestLayout()
  {
    if (!mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  void resetList()
  {
    mDataChanged = false;
    mNeedSync = false;
    removeAllViewsInLayout();
    mOldSelectedPosition = -1;
    mOldSelectedRowId = Long.MIN_VALUE;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (mAdapter != null)
    {
      mAdapter.unregisterDataSetObserver(mDataSetObserver);
      resetList();
    }
    mAdapter = paramSpinnerAdapter;
    mOldSelectedPosition = i;
    mOldSelectedRowId = Long.MIN_VALUE;
    if (mAdapter != null)
    {
      mOldItemCount = mItemCount;
      mItemCount = mAdapter.getCount();
      checkFocus();
      mDataSetObserver = new AdapterViewICS.AdapterDataSetObserver(this);
      mAdapter.registerDataSetObserver(mDataSetObserver);
      if (mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      checkFocus();
      resetList();
      checkSelectionChanged();
    }
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (mFirstPosition <= paramInt) && (paramInt <= -1 + (mFirstPosition + getChildCount()))) {}
    for (boolean bool = true;; bool = false)
    {
      setSelectionInt(paramInt, bool);
      return;
    }
  }
  
  void setSelectionInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt != mOldSelectedPosition)
    {
      mBlockLayoutRequests = true;
      int i = paramInt - mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      layout(i, paramBoolean);
      mBlockLayoutRequests = false;
    }
  }
  
  class RecycleBin
  {
    private final SparseArray<View> mScrapHeap = new SparseArray();
    
    RecycleBin() {}
    
    void clear()
    {
      SparseArray localSparseArray = mScrapHeap;
      int i = localSparseArray.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)localSparseArray.valueAt(j);
        if (localView != null) {
          removeDetachedView(localView, true);
        }
      }
      localSparseArray.clear();
    }
    
    View get(int paramInt)
    {
      View localView = (View)mScrapHeap.get(paramInt);
      if (localView != null) {
        mScrapHeap.delete(paramInt);
      }
      return localView;
    }
    
    public void put(int paramInt, View paramView)
    {
      mScrapHeap.put(paramInt, paramView);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public AbsSpinnerICS.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new AbsSpinnerICS.SavedState(paramAnonymousParcel, null);
      }
      
      public AbsSpinnerICS.SavedState[] newArray(int paramAnonymousInt)
      {
        return new AbsSpinnerICS.SavedState[paramAnonymousInt];
      }
    };
    int position;
    long selectedId;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      selectedId = paramParcel.readLong();
      position = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + selectedId + " position=" + position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(selectedId);
      paramParcel.writeInt(position);
    }
  }
}
