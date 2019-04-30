package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

abstract class AdapterViewICS<T extends Adapter>
  extends ViewGroup
{
  public static final int INVALID_POSITION = -1;
  public static final long INVALID_ROW_ID = Long.MIN_VALUE;
  static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
  static final int ITEM_VIEW_TYPE_IGNORE = -1;
  static final int SYNC_FIRST_POSITION = 1;
  static final int SYNC_MAX_DURATION_MILLIS = 100;
  static final int SYNC_SELECTED_POSITION;
  boolean mBlockLayoutRequests = false;
  boolean mDataChanged;
  private boolean mDesiredFocusableInTouchModeState;
  private boolean mDesiredFocusableState;
  private View mEmptyView;
  @ViewDebug.ExportedProperty(category="scrolling")
  int mFirstPosition = 0;
  boolean mInLayout = false;
  @ViewDebug.ExportedProperty(category="list")
  int mItemCount;
  private int mLayoutHeight;
  boolean mNeedSync = false;
  @ViewDebug.ExportedProperty(category="list")
  int mNextSelectedPosition = -1;
  long mNextSelectedRowId = Long.MIN_VALUE;
  int mOldItemCount;
  int mOldSelectedPosition = -1;
  long mOldSelectedRowId = Long.MIN_VALUE;
  OnItemClickListener mOnItemClickListener;
  OnItemLongClickListener mOnItemLongClickListener;
  OnItemSelectedListener mOnItemSelectedListener;
  @ViewDebug.ExportedProperty(category="list")
  int mSelectedPosition = -1;
  long mSelectedRowId = Long.MIN_VALUE;
  private AdapterViewICS<T>.SelectionNotifier mSelectionNotifier;
  int mSpecificTop;
  long mSyncHeight;
  int mSyncMode;
  int mSyncPosition;
  long mSyncRowId = Long.MIN_VALUE;
  
  AdapterViewICS(Context paramContext)
  {
    super(paramContext);
  }
  
  AdapterViewICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  AdapterViewICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fireOnSelected()
  {
    if (mOnItemSelectedListener == null) {
      return;
    }
    int i = getSelectedItemPosition();
    if (i >= 0)
    {
      View localView = getSelectedView();
      mOnItemSelectedListener.onItemSelected(this, localView, i, getAdapter().getItemId(i));
      return;
    }
    mOnItemSelectedListener.onNothingSelected(this);
  }
  
  private void updateEmptyStatus(boolean paramBoolean)
  {
    if (isInFilterMode()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (mEmptyView != null)
      {
        mEmptyView.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (mDataChanged) {
          onLayout(false, getLeft(), getTop(), getRight(), getBottom());
        }
        return;
        setVisibility(0);
      }
    }
    if (mEmptyView != null) {
      mEmptyView.setVisibility(8);
    }
    setVisibility(0);
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (mItemCount > 0);
  }
  
  void checkFocus()
  {
    Adapter localAdapter = getAdapter();
    int i;
    int j;
    label33:
    boolean bool1;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!isInFilterMode())) {
        break label115;
      }
      j = 1;
      if ((j == 0) || (!mDesiredFocusableInTouchModeState)) {
        break label120;
      }
      bool1 = true;
      label47:
      super.setFocusableInTouchMode(bool1);
      if ((j == 0) || (!mDesiredFocusableState)) {
        break label126;
      }
    }
    label115:
    label120:
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      super.setFocusable(bool2);
      if (mEmptyView != null)
      {
        boolean bool3;
        if (localAdapter != null)
        {
          boolean bool4 = localAdapter.isEmpty();
          bool3 = false;
          if (!bool4) {}
        }
        else
        {
          bool3 = true;
        }
        updateEmptyStatus(bool3);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label33;
      bool1 = false;
      break label47;
    }
  }
  
  void checkSelectionChanged()
  {
    if ((mSelectedPosition != mOldSelectedPosition) || (mSelectedRowId != mOldSelectedRowId))
    {
      selectionChanged();
      mOldSelectedPosition = mSelectedPosition;
      mOldSelectedRowId = mSelectedRowId;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = getSelectedView();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  int findSyncPosition()
  {
    int i = mItemCount;
    if (i == 0)
    {
      m = -1;
      return m;
    }
    long l1 = mSyncRowId;
    int j = mSyncPosition;
    if (l1 == Long.MIN_VALUE) {
      return -1;
    }
    int k = Math.max(0, j);
    int m = Math.min(i - 1, k);
    long l2 = 100L + SystemClock.uptimeMillis();
    int n = m;
    int i1 = m;
    Adapter localAdapter = getAdapter();
    int i2 = 0;
    label87:
    int i4;
    int i3;
    if (localAdapter == null)
    {
      return -1;
      if ((i4 == 0) && ((i2 == 0) || (i3 != 0))) {
        break label178;
      }
      i1++;
      m = i1;
    }
    for (i2 = 0;; i2 = 1)
    {
      label166:
      label172:
      label176:
      label178:
      do
      {
        if (SystemClock.uptimeMillis() <= l2)
        {
          if (localAdapter.getItemId(m) == l1) {
            break;
          }
          if (i1 != i - 1) {
            break label166;
          }
          i3 = 1;
          if (n != 0) {
            break label172;
          }
        }
        for (i4 = 1;; i4 = 0)
        {
          if ((i3 == 0) || (i4 == 0)) {
            break label176;
          }
          return -1;
          i3 = 0;
          break;
        }
        break label87;
      } while ((i3 == 0) && ((i2 != 0) || (i4 != 0)));
      n--;
      m = n;
    }
  }
  
  public abstract T getAdapter();
  
  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return mItemCount;
  }
  
  public View getEmptyView()
  {
    return mEmptyView;
  }
  
  public int getFirstVisiblePosition()
  {
    return mFirstPosition;
  }
  
  public Object getItemAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (paramInt < 0)) {
      return null;
    }
    return localAdapter.getItem(paramInt);
  }
  
  public long getItemIdAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (paramInt < 0)) {
      return Long.MIN_VALUE;
    }
    return localAdapter.getItemId(paramInt);
  }
  
  public int getLastVisiblePosition()
  {
    return -1 + (mFirstPosition + getChildCount());
  }
  
  public final OnItemClickListener getOnItemClickListener()
  {
    return mOnItemClickListener;
  }
  
  public final OnItemLongClickListener getOnItemLongClickListener()
  {
    return mOnItemLongClickListener;
  }
  
  public final OnItemSelectedListener getOnItemSelectedListener()
  {
    return mOnItemSelectedListener;
  }
  
  public int getPositionForView(View paramView)
  {
    Object localObject = paramView;
    try
    {
      for (;;)
      {
        View localView = (View)((View)localObject).getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        localObject = localView;
      }
      return -1;
    }
    catch (ClassCastException localClassCastException) {}
    for (;;)
    {
      int i = getChildCount();
      for (int j = 0; j < i; j++) {
        if (getChildAt(j).equals(localObject)) {
          return j + mFirstPosition;
        }
      }
    }
  }
  
  public Object getSelectedItem()
  {
    Adapter localAdapter = getAdapter();
    int i = getSelectedItemPosition();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return mNextSelectedRowId;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return mNextSelectedPosition;
  }
  
  public abstract View getSelectedView();
  
  void handleDataChanged()
  {
    int i = mItemCount;
    int j = 0;
    if (i > 0)
    {
      boolean bool = mNeedSync;
      j = 0;
      if (bool)
      {
        mNeedSync = false;
        int n = findSyncPosition();
        j = 0;
        if (n >= 0)
        {
          int i1 = lookForSelectablePosition(n, true);
          j = 0;
          if (i1 == n)
          {
            setNextSelectedPositionInt(n);
            j = 1;
          }
        }
      }
      if (j == 0)
      {
        int k = getSelectedItemPosition();
        if (k >= i) {
          k = i - 1;
        }
        if (k < 0) {
          k = 0;
        }
        int m = lookForSelectablePosition(k, true);
        if (m < 0) {
          m = lookForSelectablePosition(k, false);
        }
        if (m >= 0)
        {
          setNextSelectedPositionInt(m);
          checkSelectionChanged();
          j = 1;
        }
      }
    }
    if (j == 0)
    {
      mSelectedPosition = -1;
      mSelectedRowId = Long.MIN_VALUE;
      mNextSelectedPosition = -1;
      mNextSelectedRowId = Long.MIN_VALUE;
      mNeedSync = false;
      checkSelectionChanged();
    }
  }
  
  boolean isInFilterMode()
  {
    return false;
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(mSelectionNotifier);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mLayoutHeight = getHeight();
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    OnItemClickListener localOnItemClickListener = mOnItemClickListener;
    boolean bool = false;
    if (localOnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      mOnItemClickListener.onItemClick(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  void rememberSyncState()
  {
    if (getChildCount() > 0)
    {
      mNeedSync = true;
      mSyncHeight = mLayoutHeight;
      if (mSelectedPosition >= 0)
      {
        View localView2 = getChildAt(mSelectedPosition - mFirstPosition);
        mSyncRowId = mNextSelectedRowId;
        mSyncPosition = mNextSelectedPosition;
        if (localView2 != null) {
          mSpecificTop = localView2.getTop();
        }
        mSyncMode = 0;
      }
    }
    else
    {
      return;
    }
    View localView1 = getChildAt(0);
    Adapter localAdapter = getAdapter();
    if ((mFirstPosition >= 0) && (mFirstPosition < localAdapter.getCount())) {}
    for (mSyncRowId = localAdapter.getItemId(mFirstPosition);; mSyncRowId = -1L)
    {
      mSyncPosition = mFirstPosition;
      if (localView1 != null) {
        mSpecificTop = localView1.getTop();
      }
      mSyncMode = 1;
      return;
    }
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  void selectionChanged()
  {
    if (mOnItemSelectedListener != null)
    {
      if ((!mInLayout) && (!mBlockLayoutRequests)) {
        break label78;
      }
      if (mSelectionNotifier == null) {
        mSelectionNotifier = new SelectionNotifier(null);
      }
      post(mSelectionNotifier);
    }
    for (;;)
    {
      if ((mSelectedPosition != -1) && (isShown()) && (!isInTouchMode())) {
        sendAccessibilityEvent(4);
      }
      return;
      label78:
      fireOnSelected();
    }
  }
  
  public abstract void setAdapter(T paramT);
  
  public void setEmptyView(View paramView)
  {
    mEmptyView = paramView;
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      updateEmptyStatus(bool);
      return;
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      mDesiredFocusableState = paramBoolean;
      if (!paramBoolean) {
        mDesiredFocusableInTouchModeState = false;
      }
      if ((!paramBoolean) || ((bool2) && (!isInFilterMode()))) {
        break label65;
      }
    }
    for (;;)
    {
      super.setFocusable(bool1);
      return;
      bool2 = false;
      break;
      label65:
      bool1 = false;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool1 = true;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      bool2 = bool1;
      mDesiredFocusableInTouchModeState = paramBoolean;
      if (paramBoolean) {
        mDesiredFocusableState = bool1;
      }
      if ((!paramBoolean) || ((bool2) && (!isInFilterMode()))) {
        break label65;
      }
    }
    for (;;)
    {
      super.setFocusableInTouchMode(bool1);
      return;
      bool2 = false;
      break;
      label65:
      bool1 = false;
    }
  }
  
  void setNextSelectedPositionInt(int paramInt)
  {
    mNextSelectedPosition = paramInt;
    mNextSelectedRowId = getItemIdAtPosition(paramInt);
    if ((mNeedSync) && (mSyncMode == 0) && (paramInt >= 0))
    {
      mSyncPosition = paramInt;
      mSyncRowId = mNextSelectedRowId;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    mOnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(OnItemSelectedListener paramOnItemSelectedListener)
  {
    mOnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    mSelectedPosition = paramInt;
    mSelectedRowId = getItemIdAtPosition(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
  
  public static class AdapterContextMenuInfo
    implements ContextMenu.ContextMenuInfo
  {
    public long id;
    public int position;
    public View targetView;
    
    public AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
    {
      targetView = paramView;
      position = paramInt;
      id = paramLong;
    }
  }
  
  class AdapterDataSetObserver
    extends DataSetObserver
  {
    private Parcelable mInstanceState = null;
    
    AdapterDataSetObserver() {}
    
    public void clearSavedState()
    {
      mInstanceState = null;
    }
    
    public void onChanged()
    {
      mDataChanged = true;
      mOldItemCount = mItemCount;
      mItemCount = getAdapter().getCount();
      if ((getAdapter().hasStableIds()) && (mInstanceState != null) && (mOldItemCount == 0) && (mItemCount > 0))
      {
        onRestoreInstanceState(mInstanceState);
        mInstanceState = null;
      }
      for (;;)
      {
        checkFocus();
        requestLayout();
        return;
        rememberSyncState();
      }
    }
    
    public void onInvalidated()
    {
      mDataChanged = true;
      if (getAdapter().hasStableIds()) {
        mInstanceState = onSaveInstanceState();
      }
      mOldItemCount = mItemCount;
      mItemCount = 0;
      mSelectedPosition = -1;
      mSelectedRowId = Long.MIN_VALUE;
      mNextSelectedPosition = -1;
      mNextSelectedRowId = Long.MIN_VALUE;
      mNeedSync = false;
      checkFocus();
      requestLayout();
    }
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(AdapterViewICS<?> paramAdapterViewICS, View paramView, int paramInt, long paramLong);
  }
  
  class OnItemClickListenerWrapper
    implements AdapterView.OnItemClickListener
  {
    private final AdapterViewICS.OnItemClickListener mWrappedListener;
    
    public OnItemClickListenerWrapper(AdapterViewICS.OnItemClickListener paramOnItemClickListener)
    {
      mWrappedListener = paramOnItemClickListener;
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      mWrappedListener.onItemClick(AdapterViewICS.this, paramView, paramInt, paramLong);
    }
  }
  
  public static abstract interface OnItemLongClickListener
  {
    public abstract boolean onItemLongClick(AdapterViewICS<?> paramAdapterViewICS, View paramView, int paramInt, long paramLong);
  }
  
  public static abstract interface OnItemSelectedListener
  {
    public abstract void onItemSelected(AdapterViewICS<?> paramAdapterViewICS, View paramView, int paramInt, long paramLong);
    
    public abstract void onNothingSelected(AdapterViewICS<?> paramAdapterViewICS);
  }
  
  private class SelectionNotifier
    implements Runnable
  {
    private SelectionNotifier() {}
    
    public void run()
    {
      if (mDataChanged)
      {
        if (getAdapter() != null) {
          post(this);
        }
        return;
      }
      AdapterViewICS.this.fireOnSelected();
    }
  }
}
