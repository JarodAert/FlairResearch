package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.view.CollapsibleActionView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.util.List;

public class ActionBarView
  extends AbsActionBarView
{
  private static final int DEFAULT_CUSTOM_GRAVITY = 19;
  public static final int DISPLAY_DEFAULT = 0;
  private static final int DISPLAY_RELAYOUT_MASK = 31;
  private static final String TAG = "ActionBarView";
  private ActionBar.OnNavigationListener mCallback;
  private Context mContext;
  private ActionBarContextView mContextView;
  private View mCustomNavView;
  private int mDisplayOptions = -1;
  View mExpandedActionView;
  private final View.OnClickListener mExpandedActionViewUpListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      MenuItemImpl localMenuItemImpl = mExpandedMenuPresenter.mCurrentExpandedItem;
      if (localMenuItemImpl != null) {
        localMenuItemImpl.collapseActionView();
      }
    }
  };
  private HomeView mExpandedHomeLayout;
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private HomeView mHomeLayout;
  private Drawable mIcon;
  private boolean mIncludeTabs;
  private int mIndeterminateProgressStyle;
  private ProgressBarICS mIndeterminateProgressView;
  private boolean mIsCollapsable;
  private boolean mIsCollapsed;
  private int mItemPadding;
  private LinearLayout mListNavLayout;
  private Drawable mLogo;
  private ActionMenuItem mLogoNavItem;
  private final AdapterViewICS.OnItemSelectedListener mNavItemSelectedListener = new AdapterViewICS.OnItemSelectedListener()
  {
    public void onItemSelected(AdapterViewICS<?> paramAnonymousAdapterViewICS, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (mCallback != null) {
        mCallback.onNavigationItemSelected(paramAnonymousInt, paramAnonymousLong);
      }
    }
    
    public void onNothingSelected(AdapterViewICS<?> paramAnonymousAdapterViewICS) {}
  };
  private int mNavigationMode;
  private MenuBuilder mOptionsMenu;
  private int mProgressBarPadding;
  private int mProgressStyle;
  private ProgressBarICS mProgressView;
  private SpinnerICS mSpinner;
  private SpinnerAdapter mSpinnerAdapter;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private ScrollingTabContainerView mTabScrollView;
  private Runnable mTabSelector;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private int mTitleStyleRes;
  private View mTitleUpView;
  private TextView mTitleView;
  private final View.OnClickListener mUpClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      mWindowCallback.onMenuItemSelected(0, mLogoNavItem);
    }
  };
  private boolean mUserTitle;
  Window.Callback mWindowCallback;
  
  public ActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mContext = paramContext;
    setBackgroundResource(0);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    PackageManager localPackageManager = paramContext.getPackageManager();
    mNavigationMode = localTypedArray.getInt(2, 0);
    mTitle = localTypedArray.getText(0);
    mSubtitle = localTypedArray.getText(4);
    mLogo = localTypedArray.getDrawable(8);
    if ((mLogo != null) || (Build.VERSION.SDK_INT < 9) || ((paramContext instanceof Activity))) {}
    try
    {
      mLogo = localPackageManager.getActivityLogo(((Activity)paramContext).getComponentName());
      if (mLogo == null) {
        mLogo = localApplicationInfo.loadLogo(localPackageManager);
      }
      mIcon = localTypedArray.getDrawable(7);
      if (mIcon == null) {
        if (!(paramContext instanceof Activity)) {}
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      try
      {
        mIcon = localPackageManager.getActivityIcon(((Activity)paramContext).getComponentName());
        if (mIcon == null) {
          mIcon = localApplicationInfo.loadIcon(localPackageManager);
        }
        LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
        int i = localTypedArray.getResourceId(14, R.layout.abc_action_bar_home);
        mHomeLayout = ((HomeView)localLayoutInflater.inflate(i, this, false));
        mExpandedHomeLayout = ((HomeView)localLayoutInflater.inflate(i, this, false));
        mExpandedHomeLayout.setUp(true);
        mExpandedHomeLayout.setOnClickListener(mExpandedActionViewUpListener);
        mExpandedHomeLayout.setContentDescription(getResources().getText(R.string.abc_action_bar_up_description));
        mTitleStyleRes = localTypedArray.getResourceId(5, 0);
        mSubtitleStyleRes = localTypedArray.getResourceId(6, 0);
        mProgressStyle = localTypedArray.getResourceId(15, 0);
        mIndeterminateProgressStyle = localTypedArray.getResourceId(16, 0);
        mProgressBarPadding = localTypedArray.getDimensionPixelOffset(17, 0);
        mItemPadding = localTypedArray.getDimensionPixelOffset(18, 0);
        setDisplayOptions(localTypedArray.getInt(3, 0));
        int j = localTypedArray.getResourceId(13, 0);
        if (j != 0)
        {
          mCustomNavView = localLayoutInflater.inflate(j, this, false);
          mNavigationMode = 0;
          setDisplayOptions(0x10 | mDisplayOptions);
        }
        mContentHeight = localTypedArray.getLayoutDimension(1, 0);
        localTypedArray.recycle();
        mLogoNavItem = new ActionMenuItem(paramContext, 0, 16908332, 0, 0, mTitle);
        mHomeLayout.setOnClickListener(mUpClickListener);
        mHomeLayout.setClickable(true);
        mHomeLayout.setFocusable(true);
        return;
        localNameNotFoundException2 = localNameNotFoundException2;
        Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException2);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        for (;;)
        {
          Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException1);
        }
      }
    }
  }
  
  private void configPresenters(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.addMenuPresenter(mActionMenuPresenter);
      paramMenuBuilder.addMenuPresenter(mExpandedMenuPresenter);
    }
    for (;;)
    {
      mActionMenuPresenter.updateMenuView(true);
      mExpandedMenuPresenter.updateMenuView(true);
      return;
      mActionMenuPresenter.initForMenu(mContext, null);
      mExpandedMenuPresenter.initForMenu(mContext, null);
    }
  }
  
  private void initTitle()
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label200:
    int i;
    label217:
    LinearLayout localLinearLayout;
    if (mTitleLayout == null)
    {
      mTitleLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this, false));
      mTitleView = ((TextView)mTitleLayout.findViewById(R.id.action_bar_title));
      mSubtitleView = ((TextView)mTitleLayout.findViewById(R.id.action_bar_subtitle));
      mTitleUpView = mTitleLayout.findViewById(R.id.up);
      mTitleLayout.setOnClickListener(mUpClickListener);
      if (mTitleStyleRes != 0) {
        mTitleView.setTextAppearance(mContext, mTitleStyleRes);
      }
      if (mTitle != null) {
        mTitleView.setText(mTitle);
      }
      if (mSubtitleStyleRes != 0) {
        mSubtitleView.setTextAppearance(mContext, mSubtitleStyleRes);
      }
      if (mSubtitle != null)
      {
        mSubtitleView.setText(mSubtitle);
        mSubtitleView.setVisibility(0);
      }
      if ((0x4 & mDisplayOptions) == 0) {
        break label289;
      }
      bool2 = bool1;
      if ((0x2 & mDisplayOptions) == 0) {
        break label294;
      }
      bool3 = bool1;
      View localView = mTitleUpView;
      if (bool3) {
        break label305;
      }
      if (!bool2) {
        break label299;
      }
      i = 0;
      localView.setVisibility(i);
      localLinearLayout = mTitleLayout;
      if ((!bool2) || (bool3)) {
        break label312;
      }
    }
    for (;;)
    {
      localLinearLayout.setEnabled(bool1);
      addView(mTitleLayout);
      if ((mExpandedActionView != null) || ((TextUtils.isEmpty(mTitle)) && (TextUtils.isEmpty(mSubtitle)))) {
        mTitleLayout.setVisibility(8);
      }
      return;
      label289:
      bool2 = false;
      break;
      label294:
      bool3 = false;
      break label200;
      label299:
      i = 4;
      break label217;
      label305:
      i = 8;
      break label217;
      label312:
      bool1 = false;
    }
  }
  
  private void setTitleImpl(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    int i;
    LinearLayout localLinearLayout;
    int j;
    if (mTitleView != null)
    {
      mTitleView.setText(paramCharSequence);
      if ((mExpandedActionView != null) || ((0x8 & mDisplayOptions) == 0) || ((TextUtils.isEmpty(mTitle)) && (TextUtils.isEmpty(mSubtitle)))) {
        break label96;
      }
      i = 1;
      localLinearLayout = mTitleLayout;
      j = 0;
      if (i == 0) {
        break label101;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(j);
      if (mLogoNavItem != null) {
        mLogoNavItem.setTitle(paramCharSequence);
      }
      return;
      label96:
      i = 0;
      break;
      label101:
      j = 8;
    }
  }
  
  public void collapseActionView()
  {
    if (mExpandedMenuPresenter == null) {}
    for (MenuItemImpl localMenuItemImpl = null;; localMenuItemImpl = mExpandedMenuPresenter.mCurrentExpandedItem)
    {
      if (localMenuItemImpl != null) {
        localMenuItemImpl.collapseActionView();
      }
      return;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ActionBar.LayoutParams(19);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionBar.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      paramLayoutParams = generateDefaultLayoutParams();
    }
    return paramLayoutParams;
  }
  
  public View getCustomNavigationView()
  {
    return mCustomNavView;
  }
  
  public int getDisplayOptions()
  {
    return mDisplayOptions;
  }
  
  public SpinnerAdapter getDropdownAdapter()
  {
    return mSpinnerAdapter;
  }
  
  public int getDropdownSelectedPosition()
  {
    return mSpinner.getSelectedItemPosition();
  }
  
  public int getNavigationMode()
  {
    return mNavigationMode;
  }
  
  public CharSequence getSubtitle()
  {
    return mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public boolean hasEmbeddedTabs()
  {
    return mIncludeTabs;
  }
  
  public boolean hasExpandedActionView()
  {
    return (mExpandedMenuPresenter != null) && (mExpandedMenuPresenter.mCurrentExpandedItem != null);
  }
  
  public void initIndeterminateProgress()
  {
    mIndeterminateProgressView = new ProgressBarICS(mContext, null, 0, mIndeterminateProgressStyle);
    mIndeterminateProgressView.setId(R.id.progress_circular);
    mIndeterminateProgressView.setVisibility(8);
    addView(mIndeterminateProgressView);
  }
  
  public void initProgress()
  {
    mProgressView = new ProgressBarICS(mContext, null, 0, mProgressStyle);
    mProgressView.setId(R.id.progress_horizontal);
    mProgressView.setMax(10000);
    mProgressView.setVisibility(8);
    addView(mProgressView);
  }
  
  public boolean isCollapsed()
  {
    return mIsCollapsed;
  }
  
  public boolean isSplitActionBar()
  {
    return mSplitActionBar;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    mTitleView = null;
    mSubtitleView = null;
    mTitleUpView = null;
    if ((mTitleLayout != null) && (mTitleLayout.getParent() == this)) {
      removeView(mTitleLayout);
    }
    mTitleLayout = null;
    if ((0x8 & mDisplayOptions) != 0) {
      initTitle();
    }
    if ((mTabScrollView != null) && (mIncludeTabs))
    {
      ViewGroup.LayoutParams localLayoutParams = mTabScrollView.getLayoutParams();
      if (localLayoutParams != null)
      {
        width = -2;
        height = -1;
      }
      mTabScrollView.setAllowCollapse(true);
    }
    if (mProgressView != null)
    {
      removeView(mProgressView);
      initProgress();
    }
    if (mIndeterminateProgressView != null)
    {
      removeView(mIndeterminateProgressView);
      initIndeterminateProgress();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(mTabSelector);
    if (mActionMenuPresenter != null)
    {
      mActionMenuPresenter.hideOverflowMenu();
      mActionMenuPresenter.hideSubMenus();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    addView(mHomeLayout);
    if ((mCustomNavView != null) && ((0x10 & mDisplayOptions) != 0))
    {
      ViewParent localViewParent = mCustomNavView.getParent();
      if (localViewParent != this)
      {
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(mCustomNavView);
        }
        addView(mCustomNavView);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    if (k <= 0) {
      return;
    }
    HomeView localHomeView;
    label47:
    int i15;
    label126:
    label180:
    int m;
    View localView1;
    label295:
    ActionBar.LayoutParams localLayoutParams1;
    label322:
    int i2;
    label334:
    int i3;
    int i4;
    int i5;
    int i6;
    int i14;
    label420:
    int i7;
    label460:
    int i9;
    if (mExpandedActionView != null)
    {
      localHomeView = mExpandedHomeLayout;
      if (localHomeView.getVisibility() != 8)
      {
        int i16 = localHomeView.getLeftOffset();
        i += i16 + positionChild(localHomeView, i + i16, j, k);
      }
      if (mExpandedActionView == null)
      {
        if ((mTitleLayout == null) || (mTitleLayout.getVisibility() == 8) || ((0x8 & mDisplayOptions) == 0)) {
          break label622;
        }
        i15 = 1;
        if (i15 != 0) {
          i += positionChild(mTitleLayout, i, j, k);
        }
      }
      switch (mNavigationMode)
      {
      case 0: 
      default: 
        m = paramInt3 - paramInt1 - getPaddingRight();
        if ((mMenuView != null) && (mMenuView.getParent() == this))
        {
          positionChildInverse(mMenuView, m, j, k);
          m -= mMenuView.getMeasuredWidth();
        }
        if ((mIndeterminateProgressView != null) && (mIndeterminateProgressView.getVisibility() != 8))
        {
          positionChildInverse(mIndeterminateProgressView, m, j, k);
          m -= mIndeterminateProgressView.getMeasuredWidth();
        }
        if (mExpandedActionView != null)
        {
          localView1 = mExpandedActionView;
          if (localView1 != null)
          {
            ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
            if (!(localLayoutParams instanceof ActionBar.LayoutParams)) {
              break label764;
            }
            localLayoutParams1 = (ActionBar.LayoutParams)localLayoutParams;
            if (localLayoutParams1 == null) {
              break label770;
            }
            i2 = gravity;
            i3 = localView1.getMeasuredWidth();
            i4 = 0;
            i5 = 0;
            if (localLayoutParams1 != null)
            {
              i += leftMargin;
              m -= rightMargin;
              i5 = topMargin;
              i4 = bottomMargin;
            }
            i6 = i2 & 0x7;
            if (i6 != 1) {
              break label793;
            }
            i14 = (getWidth() - i3) / 2;
            if (i14 >= i) {
              break label777;
            }
            i6 = 3;
            i7 = 0;
            switch (i6)
            {
            case 2: 
            case 4: 
            default: 
              int i8 = i2 & 0x70;
              if (i2 == -1) {
                i8 = 16;
              }
              i9 = 0;
              switch (i8)
              {
              }
              break;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      int i10 = localView1.getMeasuredWidth();
      int i11 = i7 + i10;
      int i12 = i9 + localView1.getMeasuredHeight();
      localView1.layout(i7, i9, i11, i12);
      (i + i10);
      if (mProgressView == null) {
        break;
      }
      mProgressView.bringToFront();
      int i1 = mProgressView.getMeasuredHeight() / 2;
      mProgressView.layout(mProgressBarPadding, -i1, mProgressBarPadding + mProgressView.getMeasuredWidth(), i1);
      return;
      localHomeView = mHomeLayout;
      break label47;
      label622:
      i15 = 0;
      break label126;
      if (mListNavLayout == null) {
        break label180;
      }
      if (i15 != 0) {
        i += mItemPadding;
      }
      i += positionChild(mListNavLayout, i, j, k) + mItemPadding;
      break label180;
      if (mTabScrollView == null) {
        break label180;
      }
      if (i15 != 0) {
        i += mItemPadding;
      }
      i += positionChild(mTabScrollView, i, j, k) + mItemPadding;
      break label180;
      int n = 0x10 & mDisplayOptions;
      localView1 = null;
      if (n == 0) {
        break label295;
      }
      View localView2 = mCustomNavView;
      localView1 = null;
      if (localView2 == null) {
        break label295;
      }
      localView1 = mCustomNavView;
      break label295;
      label764:
      localLayoutParams1 = null;
      break label322;
      label770:
      i2 = 19;
      break label334;
      label777:
      if (i14 + i3 <= m) {
        break label420;
      }
      i6 = 5;
      break label420;
      label793:
      if (i2 != -1) {
        break label420;
      }
      i6 = 3;
      break label420;
      i7 = (getWidth() - i3) / 2;
      break label460;
      i7 = i;
      break label460;
      i7 = m - i3;
      break label460;
      int i13 = getPaddingTop();
      i9 = (getHeight() - getPaddingBottom() - i13 - localView1.getMeasuredHeight()) / 2;
      continue;
      i9 = i5 + getPaddingTop();
      continue;
      i9 = getHeight() - getPaddingBottom() - localView1.getMeasuredHeight() - i4;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (mIsCollapsable)
    {
      int i31 = 0;
      for (int i32 = 0; i32 < i; i32++)
      {
        View localView3 = getChildAt(i32);
        if ((localView3.getVisibility() != 8) && ((localView3 != mMenuView) || (mMenuView.getChildCount() != 0))) {
          i31++;
        }
      }
      if (i31 == 0)
      {
        setMeasuredDimension(0, 0);
        mIsCollapsed = true;
        return;
      }
    }
    mIsCollapsed = false;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) != Integer.MIN_VALUE) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    int j = View.MeasureSpec.getSize(paramInt1);
    int k;
    int m;
    int i2;
    int i4;
    int i5;
    int i6;
    HomeView localHomeView;
    label284:
    ViewGroup.LayoutParams localLayoutParams2;
    int i28;
    label319:
    int i7;
    label504:
    label536:
    View localView1;
    label549:
    ViewGroup.LayoutParams localLayoutParams1;
    ActionBar.LayoutParams localLayoutParams;
    label580:
    int i12;
    int i14;
    int i15;
    int i16;
    label675:
    int i17;
    label695:
    int i18;
    if (mContentHeight > 0)
    {
      k = mContentHeight;
      m = getPaddingTop() + getPaddingBottom();
      int n = getPaddingLeft();
      int i1 = getPaddingRight();
      i2 = k - m;
      int i3 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
      i4 = j - n - i1;
      i5 = i4 / 2;
      i6 = i5;
      if (mExpandedActionView == null) {
        break label887;
      }
      localHomeView = mExpandedHomeLayout;
      if (localHomeView.getVisibility() != 8)
      {
        localLayoutParams2 = localHomeView.getLayoutParams();
        if (width >= 0) {
          break label896;
        }
        i28 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        int i29 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        localHomeView.measure(i28, i29);
        int i30 = localHomeView.getMeasuredWidth() + localHomeView.getLeftOffset();
        i4 = Math.max(0, i4 - i30);
        i5 = Math.max(0, i4 - i30);
      }
      if ((mMenuView != null) && (mMenuView.getParent() == this))
      {
        i4 = measureChildView(mMenuView, i4, i3, 0);
        i6 = Math.max(0, i6 - mMenuView.getMeasuredWidth());
      }
      if ((mIndeterminateProgressView != null) && (mIndeterminateProgressView.getVisibility() != 8))
      {
        i4 = measureChildView(mIndeterminateProgressView, i4, i3, 0);
        i6 = Math.max(0, i6 - mIndeterminateProgressView.getMeasuredWidth());
      }
      if ((mTitleLayout == null) || (mTitleLayout.getVisibility() == 8) || ((0x8 & mDisplayOptions) == 0)) {
        break label912;
      }
      i7 = 1;
      if (mExpandedActionView == null) {}
      switch (mNavigationMode)
      {
      default: 
        if (mExpandedActionView != null)
        {
          localView1 = mExpandedActionView;
          if (localView1 != null)
          {
            localLayoutParams1 = generateLayoutParams(localView1.getLayoutParams());
            if (!(localLayoutParams1 instanceof ActionBar.LayoutParams)) {
              break label1174;
            }
            localLayoutParams = (ActionBar.LayoutParams)localLayoutParams1;
            i12 = 0;
            int i13 = 0;
            if (localLayoutParams != null)
            {
              i12 = leftMargin + rightMargin;
              i13 = topMargin + bottomMargin;
            }
            if (mContentHeight > 0) {
              break label1180;
            }
            i14 = Integer.MIN_VALUE;
            if (height >= 0) {
              i2 = Math.min(height, i2);
            }
            i15 = Math.max(0, i2 - i13);
            if (width == -2) {
              break label1206;
            }
            i16 = 1073741824;
            if (width < 0) {
              break label1214;
            }
            i17 = Math.min(width, i4);
            i18 = Math.max(0, i17 - i12);
            if (localLayoutParams == null) {
              break label1221;
            }
          }
        }
        break;
      }
    }
    int i9;
    label887:
    label896:
    label912:
    label1174:
    label1180:
    label1206:
    label1214:
    label1221:
    for (int i19 = gravity;; i19 = 19)
    {
      if (((i19 & 0x7) == 1) && (width == -1)) {
        i18 = 2 * Math.min(i5, i6);
      }
      localView1.measure(View.MeasureSpec.makeMeasureSpec(i18, i16), View.MeasureSpec.makeMeasureSpec(i15, i14));
      i4 -= i12 + localView1.getMeasuredWidth();
      if ((mExpandedActionView == null) && (i7 != 0))
      {
        measureChildView(mTitleLayout, i4, View.MeasureSpec.makeMeasureSpec(mContentHeight, 1073741824), 0);
        Math.max(0, i5 - mTitleLayout.getMeasuredWidth());
      }
      if (mContentHeight > 0) {
        break label1306;
      }
      i9 = 0;
      for (int i10 = 0; i10 < i; i10++)
      {
        int i11 = m + getChildAt(i10).getMeasuredHeight();
        if (i11 > i9) {
          i9 = i11;
        }
      }
      k = View.MeasureSpec.getSize(paramInt2);
      break;
      localHomeView = mHomeLayout;
      break label284;
      i28 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
      break label319;
      i7 = 0;
      break label504;
      if (mListNavLayout == null) {
        break label536;
      }
      if (i7 != 0) {}
      for (int i24 = 2 * mItemPadding;; i24 = mItemPadding)
      {
        int i25 = Math.max(0, i4 - i24);
        int i26 = Math.max(0, i5 - i24);
        mListNavLayout.measure(View.MeasureSpec.makeMeasureSpec(i25, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        int i27 = mListNavLayout.getMeasuredWidth();
        i4 = Math.max(0, i25 - i27);
        i5 = Math.max(0, i26 - i27);
        break;
      }
      if (mTabScrollView == null) {
        break label536;
      }
      if (i7 != 0) {}
      for (int i20 = 2 * mItemPadding;; i20 = mItemPadding)
      {
        int i21 = Math.max(0, i4 - i20);
        int i22 = Math.max(0, i5 - i20);
        mTabScrollView.measure(View.MeasureSpec.makeMeasureSpec(i21, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        int i23 = mTabScrollView.getMeasuredWidth();
        i4 = Math.max(0, i21 - i23);
        i5 = Math.max(0, i22 - i23);
        break;
      }
      int i8 = 0x10 & mDisplayOptions;
      localView1 = null;
      if (i8 == 0) {
        break label549;
      }
      View localView2 = mCustomNavView;
      localView1 = null;
      if (localView2 == null) {
        break label549;
      }
      localView1 = mCustomNavView;
      break label549;
      localLayoutParams = null;
      break label580;
      if (height != -2) {}
      for (i14 = 1073741824;; i14 = Integer.MIN_VALUE) {
        break;
      }
      i16 = Integer.MIN_VALUE;
      break label675;
      i17 = i4;
      break label695;
    }
    setMeasuredDimension(j, i9);
    for (;;)
    {
      if (mContextView != null) {
        mContextView.setContentHeight(getMeasuredHeight());
      }
      if ((mProgressView == null) || (mProgressView.getVisibility() == 8)) {
        break;
      }
      mProgressView.measure(View.MeasureSpec.makeMeasureSpec(j - 2 * mProgressBarPadding, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
      return;
      label1306:
      setMeasuredDimension(j, k);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if ((expandedMenuItemId != 0) && (mExpandedMenuPresenter != null) && (mOptionsMenu != null))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)mOptionsMenu.findItem(expandedMenuItemId);
      if (localSupportMenuItem != null) {
        localSupportMenuItem.expandActionView();
      }
    }
    if (isOverflowOpen) {
      postShowOverflowMenu();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((mExpandedMenuPresenter != null) && (mExpandedMenuPresenter.mCurrentExpandedItem != null)) {
      expandedMenuItemId = mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
    }
    isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public void setCallback(ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    mCallback = paramOnNavigationListener;
  }
  
  public void setCollapsable(boolean paramBoolean)
  {
    mIsCollapsable = paramBoolean;
  }
  
  public void setContextView(ActionBarContextView paramActionBarContextView)
  {
    mContextView = paramActionBarContextView;
  }
  
  public void setCustomNavigationView(View paramView)
  {
    if ((0x10 & mDisplayOptions) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((mCustomNavView != null) && (i != 0)) {
        removeView(mCustomNavView);
      }
      mCustomNavView = paramView;
      if ((mCustomNavView != null) && (i != 0)) {
        addView(mCustomNavView);
      }
      return;
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int i = 8;
    int j = -1;
    boolean bool1 = true;
    boolean bool2;
    label38:
    int k;
    label53:
    boolean bool5;
    label78:
    boolean bool4;
    label121:
    Drawable localDrawable;
    label138:
    label163:
    boolean bool3;
    if (mDisplayOptions == j)
    {
      mDisplayOptions = paramInt;
      if ((j & 0x1F) == 0) {
        break label371;
      }
      if ((paramInt & 0x2) == 0) {
        break label299;
      }
      bool2 = bool1;
      if ((!bool2) || (mExpandedActionView != null)) {
        break label305;
      }
      k = 0;
      mHomeLayout.setVisibility(k);
      if ((j & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          break label311;
        }
        bool5 = bool1;
        mHomeLayout.setUp(bool5);
        if (bool5) {
          setHomeButtonEnabled(bool1);
        }
      }
      if ((j & 0x1) != 0)
      {
        if ((mLogo == null) || ((paramInt & 0x1) == 0)) {
          break label317;
        }
        bool4 = bool1;
        HomeView localHomeView = mHomeLayout;
        if (!bool4) {
          break label323;
        }
        localDrawable = mLogo;
        localHomeView.setIcon(localDrawable);
      }
      if ((j & 0x8) != 0)
      {
        if ((paramInt & 0x8) == 0) {
          break label332;
        }
        initTitle();
      }
      if ((mTitleLayout != null) && ((j & 0x6) != 0))
      {
        if ((0x4 & mDisplayOptions) == 0) {
          break label343;
        }
        bool3 = bool1;
        label190:
        View localView = mTitleUpView;
        if (!bool2)
        {
          if (!bool3) {
            break label349;
          }
          i = 0;
        }
        label208:
        localView.setVisibility(i);
        LinearLayout localLinearLayout = mTitleLayout;
        if ((bool2) || (!bool3)) {
          break label354;
        }
        label230:
        localLinearLayout.setEnabled(bool1);
      }
      if (((j & 0x10) != 0) && (mCustomNavView != null))
      {
        if ((paramInt & 0x10) == 0) {
          break label360;
        }
        addView(mCustomNavView);
      }
      label266:
      requestLayout();
    }
    for (;;)
    {
      if (mHomeLayout.isEnabled()) {
        break label378;
      }
      mHomeLayout.setContentDescription(null);
      return;
      j = paramInt ^ mDisplayOptions;
      break;
      label299:
      bool2 = false;
      break label38;
      label305:
      k = i;
      break label53;
      label311:
      bool5 = false;
      break label78;
      label317:
      bool4 = false;
      break label121;
      label323:
      localDrawable = mIcon;
      break label138;
      label332:
      removeView(mTitleLayout);
      break label163;
      label343:
      bool3 = false;
      break label190;
      label349:
      i = 4;
      break label208;
      label354:
      bool1 = false;
      break label230;
      label360:
      removeView(mCustomNavView);
      break label266;
      label371:
      invalidate();
    }
    label378:
    if ((paramInt & 0x4) != 0)
    {
      mHomeLayout.setContentDescription(mContext.getResources().getText(R.string.abc_action_bar_up_description));
      return;
    }
    mHomeLayout.setContentDescription(mContext.getResources().getText(R.string.abc_action_bar_home_description));
  }
  
  public void setDropdownAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    mSpinnerAdapter = paramSpinnerAdapter;
    if (mSpinner != null) {
      mSpinner.setAdapter(paramSpinnerAdapter);
    }
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    mSpinner.setSelection(paramInt);
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (mTabScrollView != null) {
      removeView(mTabScrollView);
    }
    mTabScrollView = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null) {}
    for (boolean bool = true;; bool = false)
    {
      mIncludeTabs = bool;
      if ((mIncludeTabs) && (mNavigationMode == 2))
      {
        addView(mTabScrollView);
        ViewGroup.LayoutParams localLayoutParams = mTabScrollView.getLayoutParams();
        width = -2;
        height = -1;
        paramScrollingTabContainerView.setAllowCollapse(true);
      }
      return;
    }
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    mHomeLayout.setUpIndicator(paramInt);
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    mHomeLayout.setUpIndicator(paramDrawable);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    mHomeLayout.setEnabled(paramBoolean);
    mHomeLayout.setFocusable(paramBoolean);
    if (!paramBoolean)
    {
      mHomeLayout.setContentDescription(null);
      return;
    }
    if ((0x4 & mDisplayOptions) != 0)
    {
      mHomeLayout.setContentDescription(mContext.getResources().getText(R.string.abc_action_bar_up_description));
      return;
    }
    mHomeLayout.setContentDescription(mContext.getResources().getText(R.string.abc_action_bar_home_description));
  }
  
  public void setIcon(int paramInt)
  {
    setIcon(mContext.getResources().getDrawable(paramInt));
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    mIcon = paramDrawable;
    if ((paramDrawable != null) && (((0x1 & mDisplayOptions) == 0) || (mLogo == null))) {
      mHomeLayout.setIcon(paramDrawable);
    }
    if (mExpandedActionView != null) {
      mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(mContext.getResources().getDrawable(paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    mLogo = paramDrawable;
    if ((paramDrawable != null) && ((0x1 & mDisplayOptions) != 0)) {
      mHomeLayout.setIcon(paramDrawable);
    }
  }
  
  public void setMenu(SupportMenu paramSupportMenu, MenuPresenter.Callback paramCallback)
  {
    if (paramSupportMenu == mOptionsMenu) {
      return;
    }
    if (mOptionsMenu != null)
    {
      mOptionsMenu.removeMenuPresenter(mActionMenuPresenter);
      mOptionsMenu.removeMenuPresenter(mExpandedMenuPresenter);
    }
    MenuBuilder localMenuBuilder = (MenuBuilder)paramSupportMenu;
    mOptionsMenu = localMenuBuilder;
    if (mMenuView != null)
    {
      ViewGroup localViewGroup3 = (ViewGroup)mMenuView.getParent();
      if (localViewGroup3 != null) {
        localViewGroup3.removeView(mMenuView);
      }
    }
    if (mActionMenuPresenter == null)
    {
      mActionMenuPresenter = new ActionMenuPresenter(mContext);
      mActionMenuPresenter.setCallback(paramCallback);
      mActionMenuPresenter.setId(R.id.action_menu_presenter);
      mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    ActionMenuView localActionMenuView;
    if (!mSplitActionBar)
    {
      mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive));
      configPresenters(localMenuBuilder);
      localActionMenuView = (ActionMenuView)mActionMenuPresenter.getMenuView(this);
      localActionMenuView.initialize(localMenuBuilder);
      ViewGroup localViewGroup2 = (ViewGroup)localActionMenuView.getParent();
      if ((localViewGroup2 != null) && (localViewGroup2 != this)) {
        localViewGroup2.removeView(localActionMenuView);
      }
      addView(localActionMenuView, localLayoutParams);
    }
    for (;;)
    {
      mMenuView = localActionMenuView;
      return;
      mActionMenuPresenter.setExpandedActionViewsExclusive(false);
      mActionMenuPresenter.setWidthLimit(getContextgetResourcesgetDisplayMetricswidthPixels, true);
      mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
      width = -1;
      configPresenters(localMenuBuilder);
      localActionMenuView = (ActionMenuView)mActionMenuPresenter.getMenuView(this);
      if (mSplitView != null)
      {
        ViewGroup localViewGroup1 = (ViewGroup)localActionMenuView.getParent();
        if ((localViewGroup1 != null) && (localViewGroup1 != mSplitView)) {
          localViewGroup1.removeView(localActionMenuView);
        }
        localActionMenuView.setVisibility(getAnimatedVisibility());
        mSplitView.addView(localActionMenuView, localLayoutParams);
      }
      else
      {
        localActionMenuView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i = mNavigationMode;
    if (paramInt != i) {
      switch (i)
      {
      default: 
        switch (paramInt)
        {
        }
        break;
      }
    }
    for (;;)
    {
      mNavigationMode = paramInt;
      requestLayout();
      return;
      if (mListNavLayout == null) {
        break;
      }
      removeView(mListNavLayout);
      break;
      if ((mTabScrollView == null) || (!mIncludeTabs)) {
        break;
      }
      removeView(mTabScrollView);
      break;
      if (mSpinner == null)
      {
        mSpinner = new SpinnerICS(mContext, null, R.attr.actionDropDownStyle);
        mListNavLayout = ((LinearLayout)LayoutInflater.from(mContext).inflate(R.layout.abc_action_bar_view_list_nav_layout, null));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        gravity = 17;
        mListNavLayout.addView(mSpinner, localLayoutParams);
      }
      if (mSpinner.getAdapter() != mSpinnerAdapter) {
        mSpinner.setAdapter(mSpinnerAdapter);
      }
      mSpinner.setOnItemSelectedListener(mNavItemSelectedListener);
      addView(mListNavLayout);
      continue;
      if ((mTabScrollView != null) && (mIncludeTabs)) {
        addView(mTabScrollView);
      }
    }
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    int i;
    if (mSplitActionBar != paramBoolean)
    {
      if (mMenuView != null)
      {
        ViewGroup localViewGroup = (ViewGroup)mMenuView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(mMenuView);
        }
        if (!paramBoolean) {
          break label138;
        }
        if (mSplitView != null) {
          mSplitView.addView(mMenuView);
        }
        mMenuView.getLayoutParams().width = -1;
        mMenuView.requestLayout();
      }
      if (mSplitView != null)
      {
        ActionBarContainer localActionBarContainer = mSplitView;
        if (!paramBoolean) {
          break label161;
        }
        i = 0;
        label99:
        localActionBarContainer.setVisibility(i);
      }
      if (mActionMenuPresenter != null)
      {
        if (paramBoolean) {
          break label167;
        }
        mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive));
      }
    }
    for (;;)
    {
      super.setSplitActionBar(paramBoolean);
      return;
      label138:
      addView(mMenuView);
      mMenuView.getLayoutParams().width = -2;
      break;
      label161:
      i = 8;
      break label99;
      label167:
      mActionMenuPresenter.setExpandedActionViewsExclusive(false);
      mActionMenuPresenter.setWidthLimit(getContextgetResourcesgetDisplayMetricswidthPixels, true);
      mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mSubtitle = paramCharSequence;
    int i;
    int j;
    label76:
    LinearLayout localLinearLayout;
    int k;
    if (mSubtitleView != null)
    {
      mSubtitleView.setText(paramCharSequence);
      TextView localTextView = mSubtitleView;
      if (paramCharSequence == null) {
        break label98;
      }
      i = 0;
      localTextView.setVisibility(i);
      if ((mExpandedActionView != null) || ((0x8 & mDisplayOptions) == 0) || ((TextUtils.isEmpty(mTitle)) && (TextUtils.isEmpty(mSubtitle)))) {
        break label104;
      }
      j = 1;
      localLinearLayout = mTitleLayout;
      k = 0;
      if (j == 0) {
        break label110;
      }
    }
    for (;;)
    {
      localLinearLayout.setVisibility(k);
      return;
      label98:
      i = 8;
      break;
      label104:
      j = 0;
      break label76;
      label110:
      k = 8;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mUserTitle = true;
    setTitleImpl(paramCharSequence);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    mWindowCallback = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!mUserTitle) {
      setTitleImpl(paramCharSequence);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  private class ExpandedActionViewMenuPresenter
    implements MenuPresenter
  {
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    
    private ExpandedActionViewMenuPresenter() {}
    
    public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      if ((mExpandedActionView instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)mExpandedActionView).onActionViewCollapsed();
      }
      removeView(mExpandedActionView);
      removeView(mExpandedHomeLayout);
      mExpandedActionView = null;
      if ((0x2 & mDisplayOptions) != 0) {
        mHomeLayout.setVisibility(0);
      }
      if ((0x8 & mDisplayOptions) != 0)
      {
        if (mTitleLayout != null) {
          break label245;
        }
        ActionBarView.this.initTitle();
      }
      for (;;)
      {
        if ((mTabScrollView != null) && (mNavigationMode == 2)) {
          mTabScrollView.setVisibility(0);
        }
        if ((mSpinner != null) && (mNavigationMode == 1)) {
          mSpinner.setVisibility(0);
        }
        if ((mCustomNavView != null) && ((0x10 & mDisplayOptions) != 0)) {
          mCustomNavView.setVisibility(0);
        }
        mExpandedHomeLayout.setIcon(null);
        mCurrentExpandedItem = null;
        requestLayout();
        paramMenuItemImpl.setActionViewExpanded(false);
        return true;
        label245:
        mTitleLayout.setVisibility(0);
      }
    }
    
    public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      mExpandedActionView = paramMenuItemImpl.getActionView();
      mExpandedHomeLayout.setIcon(mIcon.getConstantState().newDrawable(getResources()));
      mCurrentExpandedItem = paramMenuItemImpl;
      if (mExpandedActionView.getParent() != ActionBarView.this) {
        addView(mExpandedActionView);
      }
      if (mExpandedHomeLayout.getParent() != ActionBarView.this) {
        addView(mExpandedHomeLayout);
      }
      mHomeLayout.setVisibility(8);
      if (mTitleLayout != null) {
        mTitleLayout.setVisibility(8);
      }
      if (mTabScrollView != null) {
        mTabScrollView.setVisibility(8);
      }
      if (mSpinner != null) {
        mSpinner.setVisibility(8);
      }
      if (mCustomNavView != null) {
        mCustomNavView.setVisibility(8);
      }
      requestLayout();
      paramMenuItemImpl.setActionViewExpanded(true);
      if ((mExpandedActionView instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)mExpandedActionView).onActionViewExpanded();
      }
      return true;
    }
    
    public boolean flagActionItems()
    {
      return false;
    }
    
    public int getId()
    {
      return 0;
    }
    
    public MenuView getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
    {
      if ((mMenu != null) && (mCurrentExpandedItem != null)) {
        mMenu.collapseItemActionView(mCurrentExpandedItem);
      }
      mMenu = paramMenuBuilder;
    }
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
    {
      return false;
    }
    
    public void setCallback(MenuPresenter.Callback paramCallback) {}
    
    public void updateMenuView(boolean paramBoolean)
    {
      int i;
      int j;
      if (mCurrentExpandedItem != null)
      {
        MenuBuilder localMenuBuilder = mMenu;
        i = 0;
        if (localMenuBuilder != null) {
          j = mMenu.size();
        }
      }
      for (int k = 0;; k++)
      {
        i = 0;
        if (k < j)
        {
          if ((SupportMenuItem)mMenu.getItem(k) == mCurrentExpandedItem) {
            i = 1;
          }
        }
        else
        {
          if (i == 0) {
            collapseItemActionView(mMenu, mCurrentExpandedItem);
          }
          return;
        }
      }
    }
  }
  
  private static class HomeView
    extends FrameLayout
  {
    private Drawable mDefaultUpIndicator;
    private ImageView mIconView;
    private int mUpIndicatorRes;
    private ImageView mUpView;
    private int mUpWidth;
    
    public HomeView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public HomeView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      CharSequence localCharSequence = getContentDescription();
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return true;
    }
    
    public int getLeftOffset()
    {
      if (mUpView.getVisibility() == 8) {
        return mUpWidth;
      }
      return 0;
    }
    
    protected void onConfigurationChanged(Configuration paramConfiguration)
    {
      super.onConfigurationChanged(paramConfiguration);
      if (mUpIndicatorRes != 0) {
        setUpIndicator(mUpIndicatorRes);
      }
    }
    
    protected void onFinishInflate()
    {
      mUpView = ((ImageView)findViewById(R.id.up));
      mIconView = ((ImageView)findViewById(R.id.home));
      mDefaultUpIndicator = mUpView.getDrawable();
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = (paramInt4 - paramInt2) / 2;
      int j = paramInt3 - paramInt1;
      int k = mUpView.getVisibility();
      int m = 0;
      if (k != 8)
      {
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)mUpView.getLayoutParams();
        int i5 = mUpView.getMeasuredHeight();
        int i6 = mUpView.getMeasuredWidth();
        int i7 = i - i5 / 2;
        mUpView.layout(0, i7, i6, i7 + i5);
        m = i6 + leftMargin + rightMargin;
        (j - m);
        paramInt1 += m;
      }
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)mIconView.getLayoutParams();
      int n = mIconView.getMeasuredHeight();
      int i1 = mIconView.getMeasuredWidth();
      int i2 = (paramInt3 - paramInt1) / 2;
      int i3 = m + Math.max(leftMargin, i2 - i1 / 2);
      int i4 = Math.max(topMargin, i - n / 2);
      mIconView.layout(i3, i4, i3 + i1, i4 + n);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      measureChildWithMargins(mUpView, paramInt1, 0, paramInt2, 0);
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)mUpView.getLayoutParams();
      mUpWidth = (leftMargin + mUpView.getMeasuredWidth() + rightMargin);
      int i;
      int k;
      int m;
      int i2;
      int i3;
      if (mUpView.getVisibility() == 8)
      {
        i = 0;
        int j = topMargin + mUpView.getMeasuredHeight() + bottomMargin;
        measureChildWithMargins(mIconView, paramInt1, i, paramInt2, 0);
        FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)mIconView.getLayoutParams();
        k = i + (leftMargin + mIconView.getMeasuredWidth() + rightMargin);
        m = Math.max(j, topMargin + mIconView.getMeasuredHeight() + bottomMargin);
        int n = View.MeasureSpec.getMode(paramInt1);
        int i1 = View.MeasureSpec.getMode(paramInt2);
        i2 = View.MeasureSpec.getSize(paramInt1);
        i3 = View.MeasureSpec.getSize(paramInt2);
        switch (n)
        {
        default: 
          label204:
          switch (i1)
          {
          }
          break;
        }
      }
      for (;;)
      {
        setMeasuredDimension(k, m);
        return;
        i = mUpWidth;
        break;
        k = Math.min(k, i2);
        break label204;
        k = i2;
        break label204;
        m = Math.min(m, i3);
        continue;
        m = i3;
      }
    }
    
    public void setIcon(Drawable paramDrawable)
    {
      mIconView.setImageDrawable(paramDrawable);
    }
    
    public void setUp(boolean paramBoolean)
    {
      ImageView localImageView = mUpView;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
    
    public void setUpIndicator(int paramInt)
    {
      mUpIndicatorRes = paramInt;
      ImageView localImageView = mUpView;
      if (paramInt != 0) {}
      for (Drawable localDrawable = getResources().getDrawable(paramInt);; localDrawable = mDefaultUpIndicator)
      {
        localImageView.setImageDrawable(localDrawable);
        return;
      }
    }
    
    public void setUpIndicator(Drawable paramDrawable)
    {
      ImageView localImageView = mUpView;
      if (paramDrawable != null) {}
      for (;;)
      {
        localImageView.setImageDrawable(paramDrawable);
        mUpIndicatorRes = 0;
        return;
        paramDrawable = mDefaultUpIndicator;
      }
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionBarView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionBarView.SavedState(paramAnonymousParcel, null);
      }
      
      public ActionBarView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionBarView.SavedState[paramAnonymousInt];
      }
    };
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      expandedMenuItemId = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        isOverflowOpen = bool;
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(expandedMenuItemId);
      if (isOverflowOpen) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}
