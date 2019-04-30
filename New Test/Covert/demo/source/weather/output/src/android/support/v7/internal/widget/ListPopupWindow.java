package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class ListPopupWindow
{
  private static final boolean DEBUG = false;
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int FILL_PARENT = -1;
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private static final String TAG = "ListPopupWindow";
  public static final int WRAP_CONTENT = -2;
  private ListAdapter mAdapter;
  private Context mContext;
  private boolean mDropDownAlwaysVisible = false;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private boolean mForceIgnoreOutsideTouch = false;
  private Handler mHandler = new Handler();
  private final ListSelectorHider mHideSelector = new ListSelectorHider(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mLayoutDirection;
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(null);
  private final PopupScrollListener mScrollListener = new PopupScrollListener(null);
  private Runnable mShowDropDownRunnable;
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(null);
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    mContext = paramContext;
    mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    mPopup.setInputMethodMode(1);
  }
  
  private int buildDropDown()
  {
    boolean bool2;
    Object localObject;
    View localView2;
    int i;
    LinearLayout localLinearLayout;
    LinearLayout.LayoutParams localLayoutParams2;
    label252:
    label309:
    int j;
    if (mDropDownList == null)
    {
      Context localContext = mContext;
      mShowDropDownRunnable = new Runnable()
      {
        public void run()
        {
          View localView = getAnchorView();
          if ((localView != null) && (localView.getWindowToken() != null)) {
            show();
          }
        }
      };
      if (!mModal)
      {
        bool2 = true;
        mDropDownList = new DropDownListView(localContext, bool2);
        if (mDropDownListHighlight != null) {
          mDropDownList.setSelector(mDropDownListHighlight);
        }
        mDropDownList.setAdapter(mAdapter);
        mDropDownList.setOnItemClickListener(mItemClickListener);
        mDropDownList.setFocusable(true);
        mDropDownList.setFocusableInTouchMode(true);
        mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (paramAnonymousInt != -1)
            {
              ListPopupWindow.DropDownListView localDropDownListView = mDropDownList;
              if (localDropDownListView != null) {
                ListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
              }
            }
          }
          
          public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
        });
        mDropDownList.setOnScrollListener(mScrollListener);
        if (mItemSelectedListener != null) {
          mDropDownList.setOnItemSelectedListener(mItemSelectedListener);
        }
        localObject = mDropDownList;
        localView2 = mPromptView;
        i = 0;
        if (localView2 != null)
        {
          localLinearLayout = new LinearLayout(localContext);
          localLinearLayout.setOrientation(1);
          localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        }
        switch (mPromptPosition)
        {
        default: 
          Log.e("ListPopupWindow", "Invalid hint position " + mPromptPosition);
          localView2.measure(View.MeasureSpec.makeMeasureSpec(mDropDownWidth, Integer.MIN_VALUE), 0);
          LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
          i = localView2.getMeasuredHeight() + topMargin + bottomMargin;
          localObject = localLinearLayout;
          mPopup.setContentView((View)localObject);
          Drawable localDrawable = mPopup.getBackground();
          if (localDrawable != null)
          {
            localDrawable.getPadding(mTempRect);
            j = mTempRect.top + mTempRect.bottom;
            if (!mDropDownVerticalOffsetSet) {
              mDropDownVerticalOffset = (-mTempRect.top);
            }
            label369:
            if (mPopup.getInputMethodMode() != 2) {
              break label528;
            }
          }
          break;
        }
      }
    }
    int k;
    label528:
    for (boolean bool1 = true;; bool1 = false)
    {
      k = getMaxAvailableHeight(getAnchorView(), mDropDownVerticalOffset, bool1);
      if ((!mDropDownAlwaysVisible) && (mDropDownHeight != -1)) {
        break label534;
      }
      return k + j;
      bool2 = false;
      break;
      localLinearLayout.addView((View)localObject, localLayoutParams2);
      localLinearLayout.addView(localView2);
      break label252;
      localLinearLayout.addView(localView2);
      localLinearLayout.addView((View)localObject, localLayoutParams2);
      break label252;
      ((ViewGroup)mPopup.getContentView());
      View localView1 = mPromptView;
      i = 0;
      if (localView1 == null) {
        break label309;
      }
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
      i = localView1.getMeasuredHeight() + topMargin + bottomMargin;
      break label309;
      mTempRect.setEmpty();
      j = 0;
      break label369;
    }
    label534:
    int m;
    switch (mDropDownWidth)
    {
    default: 
      m = View.MeasureSpec.makeMeasureSpec(mDropDownWidth, 1073741824);
    }
    for (;;)
    {
      int n = mDropDownList.measureHeightOfChildrenCompat(m, 0, -1, k - i, -1);
      if (n > 0) {
        i += j;
      }
      return n + i;
      m = View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), Integer.MIN_VALUE);
      continue;
      m = View.MeasureSpec.makeMeasureSpec(mContext.getResources().getDisplayMetrics().widthPixels - (mTempRect.left + mTempRect.right), 1073741824);
    }
  }
  
  private void removePromptView()
  {
    if (mPromptView != null)
    {
      ViewParent localViewParent = mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(mPromptView);
      }
    }
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = mDropDownList;
    if (localDropDownListView != null)
    {
      DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public void dismiss()
  {
    mPopup.dismiss();
    removePromptView();
    mPopup.setContentView(null);
    mDropDownList = null;
    mHandler.removeCallbacks(mResizePopupRunnable);
  }
  
  public View getAnchorView()
  {
    return mDropDownAnchorView;
  }
  
  public int getAnimationStyle()
  {
    return mPopup.getAnimationStyle();
  }
  
  public Drawable getBackground()
  {
    return mPopup.getBackground();
  }
  
  public int getHeight()
  {
    return mDropDownHeight;
  }
  
  public int getHorizontalOffset()
  {
    return mDropDownHorizontalOffset;
  }
  
  public int getInputMethodMode()
  {
    return mPopup.getInputMethodMode();
  }
  
  public ListView getListView()
  {
    return mDropDownList;
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = bottom;
    if (paramBoolean) {
      i = getContextgetResourcesgetDisplayMetricsheightPixels;
    }
    int j = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, paramInt + (arrayOfInt[1] - top));
    if (mPopup.getBackground() != null)
    {
      mPopup.getBackground().getPadding(mTempRect);
      j -= mTempRect.top + mTempRect.bottom;
    }
    return j;
  }
  
  public int getPromptPosition()
  {
    return mPromptPosition;
  }
  
  public Object getSelectedItem()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedItem();
  }
  
  public long getSelectedItemId()
  {
    if (!isShowing()) {
      return Long.MIN_VALUE;
    }
    return mDropDownList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    if (!isShowing()) {
      return -1;
    }
    return mDropDownList.getSelectedItemPosition();
  }
  
  public View getSelectedView()
  {
    if (!isShowing()) {
      return null;
    }
    return mDropDownList.getSelectedView();
  }
  
  public int getSoftInputMode()
  {
    return mPopup.getSoftInputMode();
  }
  
  public int getVerticalOffset()
  {
    if (!mDropDownVerticalOffsetSet) {
      return 0;
    }
    return mDropDownVerticalOffset;
  }
  
  public int getWidth()
  {
    return mDropDownWidth;
  }
  
  public boolean isDropDownAlwaysVisible()
  {
    return mDropDownAlwaysVisible;
  }
  
  public boolean isInputMethodNotNeeded()
  {
    return mPopup.getInputMethodMode() == 2;
  }
  
  public boolean isModal()
  {
    return mModal;
  }
  
  public boolean isShowing()
  {
    return mPopup.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i;
    int j;
    int k;
    int m;
    if ((isShowing()) && (paramInt != 62) && ((mDropDownList.getSelectedItemPosition() >= 0) || ((paramInt != 66) && (paramInt != 23))))
    {
      i = mDropDownList.getSelectedItemPosition();
      ListAdapter localListAdapter;
      if (!mPopup.isAboveAnchor())
      {
        j = 1;
        localListAdapter = mAdapter;
        k = Integer.MAX_VALUE;
        m = Integer.MIN_VALUE;
        if (localListAdapter != null)
        {
          boolean bool = localListAdapter.areAllItemsEnabled();
          if (!bool) {
            break label167;
          }
          k = 0;
          label93:
          if (!bool) {
            break label181;
          }
        }
      }
      label167:
      label181:
      for (m = -1 + localListAdapter.getCount();; m = mDropDownList.lookForSelectablePosition(-1 + localListAdapter.getCount(), false))
      {
        if (((j == 0) || (paramInt != 19) || (i > k)) && ((j != 0) || (paramInt != 20) || (i < m))) {
          break label203;
        }
        clearListSelection();
        mPopup.setInputMethodMode(1);
        show();
        return true;
        j = 0;
        break;
        k = mDropDownList.lookForSelectablePosition(0, true);
        break label93;
      }
      label203:
      DropDownListView.access$502(mDropDownList, false);
      if (!mDropDownList.onKeyDown(paramInt, paramKeyEvent)) {
        break label290;
      }
      mPopup.setInputMethodMode(2);
      mDropDownList.requestFocusFromTouch();
      show();
      switch (paramInt)
      {
      }
    }
    label290:
    do
    {
      do
      {
        return false;
        if ((j == 0) || (paramInt != 20)) {
          break;
        }
      } while (i != m);
      return true;
    } while ((j != 0) || (paramInt != 19) || (i != k));
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((isShowing()) && (mDropDownList.getSelectedItemPosition() >= 0))
    {
      boolean bool = mDropDownList.onKeyUp(paramInt, paramKeyEvent);
      if (bool) {}
      switch (paramInt)
      {
      default: 
        return bool;
      }
      dismiss();
      return bool;
    }
    return false;
  }
  
  public boolean performItemClick(int paramInt)
  {
    if (isShowing())
    {
      if (mItemClickListener != null)
      {
        DropDownListView localDropDownListView = mDropDownList;
        View localView = localDropDownListView.getChildAt(paramInt - localDropDownListView.getFirstVisiblePosition());
        ListAdapter localListAdapter = localDropDownListView.getAdapter();
        mItemClickListener.onItemClick(localDropDownListView, localView, paramInt, localListAdapter.getItemId(paramInt));
      }
      return true;
    }
    return false;
  }
  
  public void postShow()
  {
    mHandler.post(mShowDropDownRunnable);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (mObserver == null) {
      mObserver = new PopupDataSetObserver(null);
    }
    for (;;)
    {
      mAdapter = paramListAdapter;
      if (mAdapter != null) {
        paramListAdapter.registerDataSetObserver(mObserver);
      }
      if (mDropDownList != null) {
        mDropDownList.setAdapter(mAdapter);
      }
      return;
      if (mAdapter != null) {
        mAdapter.unregisterDataSetObserver(mObserver);
      }
    }
  }
  
  public void setAnchorView(View paramView)
  {
    mDropDownAnchorView = paramView;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    mPopup.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = mPopup.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(mTempRect);
      mDropDownWidth = (paramInt + (mTempRect.left + mTempRect.right));
      return;
    }
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean)
  {
    mDropDownAlwaysVisible = paramBoolean;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean)
  {
    mForceIgnoreOutsideTouch = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    mDropDownHeight = paramInt;
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    mPopup.setInputMethodMode(paramInt);
  }
  
  void setListItemExpandMax(int paramInt)
  {
    mListItemExpandMaximum = paramInt;
  }
  
  public void setListSelector(Drawable paramDrawable)
  {
    mDropDownListHighlight = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean)
  {
    mModal = true;
    mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    mItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    mItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    mPromptPosition = paramInt;
  }
  
  public void setPromptView(View paramView)
  {
    boolean bool = isShowing();
    if (bool) {
      removePromptView();
    }
    mPromptView = paramView;
    if (bool) {
      show();
    }
  }
  
  public void setSelection(int paramInt)
  {
    DropDownListView localDropDownListView = mDropDownList;
    if ((isShowing()) && (localDropDownListView != null))
    {
      DropDownListView.access$502(localDropDownListView, false);
      localDropDownListView.setSelection(paramInt);
      if (localDropDownListView.getChoiceMode() != 0) {
        localDropDownListView.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void setSoftInputMode(int paramInt)
  {
    mPopup.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt)
  {
    mDropDownVerticalOffset = paramInt;
    mDropDownVerticalOffsetSet = true;
  }
  
  public void setWidth(int paramInt)
  {
    mDropDownWidth = paramInt;
  }
  
  public void show()
  {
    boolean bool1 = true;
    int i = -1;
    int j = buildDropDown();
    boolean bool2 = isInputMethodNotNeeded();
    if (mPopup.isShowing())
    {
      int n;
      int i1;
      if (mDropDownWidth == i)
      {
        n = -1;
        if (mDropDownHeight != i) {
          break label221;
        }
        if (!bool2) {
          break label176;
        }
        i1 = j;
        label52:
        if (!bool2) {
          break label187;
        }
        PopupWindow localPopupWindow4 = mPopup;
        if (mDropDownWidth != i) {
          break label182;
        }
        label71:
        localPopupWindow4.setWindowLayoutMode(i, 0);
      }
      for (;;)
      {
        PopupWindow localPopupWindow2 = mPopup;
        boolean bool3 = mForceIgnoreOutsideTouch;
        boolean bool4 = false;
        if (!bool3)
        {
          boolean bool5 = mDropDownAlwaysVisible;
          bool4 = false;
          if (!bool5) {
            bool4 = bool1;
          }
        }
        localPopupWindow2.setOutsideTouchable(bool4);
        mPopup.update(getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset, n, i1);
        return;
        if (mDropDownWidth == -2)
        {
          n = getAnchorView().getWidth();
          break;
        }
        n = mDropDownWidth;
        break;
        label176:
        i1 = i;
        break label52;
        label182:
        i = 0;
        break label71;
        label187:
        PopupWindow localPopupWindow3 = mPopup;
        if (mDropDownWidth == i) {}
        for (int i2 = i;; i2 = 0)
        {
          localPopupWindow3.setWindowLayoutMode(i2, i);
          break;
        }
        label221:
        if (mDropDownHeight == -2) {
          i1 = j;
        } else {
          i1 = mDropDownHeight;
        }
      }
    }
    int k;
    label256:
    int m;
    label267:
    PopupWindow localPopupWindow1;
    if (mDropDownWidth == i)
    {
      k = -1;
      if (mDropDownHeight != i) {
        break label429;
      }
      m = -1;
      mPopup.setWindowLayoutMode(k, m);
      localPopupWindow1 = mPopup;
      if ((mForceIgnoreOutsideTouch) || (mDropDownAlwaysVisible)) {
        break label469;
      }
    }
    for (;;)
    {
      localPopupWindow1.setOutsideTouchable(bool1);
      mPopup.setTouchInterceptor(mTouchInterceptor);
      mPopup.showAsDropDown(getAnchorView(), mDropDownHorizontalOffset, mDropDownVerticalOffset);
      mDropDownList.setSelection(i);
      if ((!mModal) || (mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (mModal) {
        break;
      }
      mHandler.post(mHideSelector);
      return;
      if (mDropDownWidth == -2)
      {
        mPopup.setWidth(getAnchorView().getWidth());
        k = 0;
        break label256;
      }
      mPopup.setWidth(mDropDownWidth);
      k = 0;
      break label256;
      label429:
      if (mDropDownHeight == -2)
      {
        mPopup.setHeight(j);
        m = 0;
        break label267;
      }
      mPopup.setHeight(mDropDownHeight);
      m = 0;
      break label267;
      label469:
      bool1 = false;
    }
  }
  
  private static class DropDownListView
    extends ListView
  {
    public static final int INVALID_POSITION = -1;
    static final int NO_POSITION = -1;
    private static final String TAG = "ListPopupWindow.DropDownListView";
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    
    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }
    
    private int lookForSelectablePosition(int paramInt, boolean paramBoolean)
    {
      ListAdapter localListAdapter = getAdapter();
      if ((localListAdapter == null) || (isInTouchMode())) {}
      int i;
      do
      {
        int j;
        do
        {
          return -1;
          i = localListAdapter.getCount();
          if (getAdapter().areAllItemsEnabled()) {
            break;
          }
          if (paramBoolean) {
            for (j = Math.max(0, paramInt); (j < i) && (!localListAdapter.isEnabled(j)); j++) {}
          }
          for (j = Math.min(paramInt, i - 1); (j >= 0) && (!localListAdapter.isEnabled(j)); j--) {}
        } while ((j < 0) || (j >= i));
        return j;
      } while ((paramInt < 0) || (paramInt >= i));
      return paramInt;
    }
    
    public boolean hasFocus()
    {
      return (mHijackFocus) || (super.hasFocus());
    }
    
    public boolean hasWindowFocus()
    {
      return (mHijackFocus) || (super.hasWindowFocus());
    }
    
    public boolean isFocused()
    {
      return (mHijackFocus) || (super.isFocused());
    }
    
    public boolean isInTouchMode()
    {
      return ((mHijackFocus) && (mListSelectionHidden)) || (super.isInTouchMode());
    }
    
    final int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      int i = getListPaddingTop();
      int j = getListPaddingBottom();
      getListPaddingLeft();
      getListPaddingRight();
      int k = getDividerHeight();
      Drawable localDrawable = getDivider();
      ListAdapter localListAdapter = getAdapter();
      int i1;
      if (localListAdapter == null)
      {
        i1 = i + j;
        return i1;
      }
      int m = i + j;
      int n;
      label76:
      View localView;
      int i2;
      int i3;
      if ((k > 0) && (localDrawable != null))
      {
        n = k;
        i1 = 0;
        localView = null;
        i2 = 0;
        i3 = localListAdapter.getCount();
      }
      for (int i4 = 0;; i4++)
      {
        if (i4 >= i3) {
          break label277;
        }
        int i5 = localListAdapter.getItemViewType(i4);
        if (i5 != i2)
        {
          localView = null;
          i2 = i5;
        }
        localView = localListAdapter.getView(i4, localView, this);
        ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
        if ((localLayoutParams != null) && (height > 0)) {}
        for (int i6 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);; i6 = View.MeasureSpec.makeMeasureSpec(0, 0))
        {
          localView.measure(paramInt1, i6);
          if (i4 > 0) {
            m += n;
          }
          m += localView.getMeasuredHeight();
          if (m < paramInt4) {
            break label255;
          }
          if ((paramInt5 >= 0) && (i4 > paramInt5) && (i1 > 0) && (m != paramInt4)) {
            break;
          }
          return paramInt4;
          n = 0;
          break label76;
        }
        label255:
        if ((paramInt5 >= 0) && (i4 >= paramInt5)) {
          i1 = m;
        }
      }
      label277:
      return m;
    }
  }
  
  private class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider() {}
    
    public void run()
    {
      clearListSelection();
    }
  }
  
  private class PopupDataSetObserver
    extends DataSetObserver
  {
    private PopupDataSetObserver() {}
    
    public void onChanged()
    {
      if (isShowing()) {
        show();
      }
    }
    
    public void onInvalidated()
    {
      dismiss();
    }
  }
  
  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!isInputMethodNotNeeded()) && (mPopup.getContentView() != null))
      {
        mHandler.removeCallbacks(mResizePopupRunnable);
        mResizePopupRunnable.run();
      }
    }
  }
  
  private class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    private PopupTouchInterceptor() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if ((i == 0) && (mPopup != null) && (mPopup.isShowing()) && (j >= 0) && (j < mPopup.getWidth()) && (k >= 0) && (k < mPopup.getHeight())) {
        mHandler.postDelayed(mResizePopupRunnable, 250L);
      }
      for (;;)
      {
        return false;
        if (i == 1) {
          mHandler.removeCallbacks(mResizePopupRunnable);
        }
      }
    }
  }
  
  private class ResizePopupRunnable
    implements Runnable
  {
    private ResizePopupRunnable() {}
    
    public void run()
    {
      if ((mDropDownList != null) && (mDropDownList.getCount() > mDropDownList.getChildCount()) && (mDropDownList.getChildCount() <= mListItemExpandMaximum))
      {
        mPopup.setInputMethodMode(2);
        show();
      }
    }
  }
}
