package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

class ActionBarActivityDelegateBase
  extends ActionBarActivityDelegate
  implements MenuPresenter.Callback, MenuBuilder.Callback
{
  private static final int[] ACTION_BAR_DRAWABLE_TOGGLE_ATTRS;
  private static final String TAG = "ActionBarActivityDelegateBase";
  private ActionBarView mActionBarView;
  private ActionMode mActionMode;
  private boolean mClosingActionMenu;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private ListMenuPresenter mListMenuPresenter;
  private MenuBuilder mMenu;
  private Bundle mPanelFrozenActionViewState;
  private boolean mPanelIsPrepared;
  private boolean mPanelRefreshContent;
  private boolean mSubDecorInstalled;
  private CharSequence mTitleToSet;
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = R.attr.homeAsUpIndicator;
    ACTION_BAR_DRAWABLE_TOGGLE_ATTRS = arrayOfInt;
  }
  
  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  private void applyFixedSizeWindow()
  {
    TypedArray localTypedArray = mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);
    boolean bool1 = localTypedArray.hasValue(3);
    TypedValue localTypedValue1 = null;
    if (bool1)
    {
      localTypedValue1 = null;
      if (0 == 0) {
        localTypedValue1 = new TypedValue();
      }
      localTypedArray.getValue(3, localTypedValue1);
    }
    boolean bool2 = localTypedArray.hasValue(5);
    TypedValue localTypedValue2 = null;
    if (bool2)
    {
      localTypedValue2 = null;
      if (0 == 0) {
        localTypedValue2 = new TypedValue();
      }
      localTypedArray.getValue(5, localTypedValue2);
    }
    boolean bool3 = localTypedArray.hasValue(6);
    TypedValue localTypedValue3 = null;
    if (bool3)
    {
      localTypedValue3 = null;
      if (0 == 0) {
        localTypedValue3 = new TypedValue();
      }
      localTypedArray.getValue(6, localTypedValue3);
    }
    boolean bool4 = localTypedArray.hasValue(4);
    TypedValue localTypedValue4 = null;
    if (bool4)
    {
      localTypedValue4 = null;
      if (0 == 0) {
        localTypedValue4 = new TypedValue();
      }
      localTypedArray.getValue(4, localTypedValue4);
    }
    DisplayMetrics localDisplayMetrics = mActivity.getResources().getDisplayMetrics();
    int i;
    int j;
    int k;
    TypedValue localTypedValue5;
    label206:
    label238:
    TypedValue localTypedValue6;
    if (widthPixels < heightPixels)
    {
      i = 1;
      j = -1;
      k = -1;
      if (i == 0) {
        break label316;
      }
      localTypedValue5 = localTypedValue2;
      if ((localTypedValue5 != null) && (type != 0))
      {
        if (type != 5) {
          break label322;
        }
        j = (int)localTypedValue5.getDimension(localDisplayMetrics);
      }
      if (i == 0) {
        break label355;
      }
      localTypedValue6 = localTypedValue3;
      label247:
      if ((localTypedValue6 != null) && (type != 0))
      {
        if (type != 5) {
          break label362;
        }
        k = (int)localTypedValue6.getDimension(localDisplayMetrics);
      }
    }
    for (;;)
    {
      if ((j != -1) || (k != -1)) {
        mActivity.getWindow().setLayout(j, k);
      }
      localTypedArray.recycle();
      return;
      i = 0;
      break;
      label316:
      localTypedValue5 = localTypedValue1;
      break label206;
      label322:
      if (type != 6) {
        break label238;
      }
      j = (int)localTypedValue5.getFraction(widthPixels, widthPixels);
      break label238;
      label355:
      localTypedValue6 = localTypedValue4;
      break label247;
      label362:
      if (type == 6) {
        k = (int)localTypedValue6.getFraction(heightPixels, heightPixels);
      }
    }
  }
  
  private ProgressBarICS getCircularProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)mActionBarView.findViewById(R.id.progress_circular);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private ProgressBarICS getHorizontalProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)mActionBarView.findViewById(R.id.progress_horizontal);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private MenuView getListMenuView(Context paramContext, MenuPresenter.Callback paramCallback)
  {
    if (mMenu == null) {
      return null;
    }
    if (mListMenuPresenter == null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(R.styleable.Theme);
      int i = localTypedArray.getResourceId(4, R.style.Theme_AppCompat_CompactMenu);
      localTypedArray.recycle();
      mListMenuPresenter = new ListMenuPresenter(R.layout.abc_list_menu_item_layout, i);
      mListMenuPresenter.setCallback(paramCallback);
      mMenu.addMenuPresenter(mListMenuPresenter);
    }
    for (;;)
    {
      return mListMenuPresenter.getMenuView(new FrameLayout(paramContext));
      mListMenuPresenter.updateMenuView(false);
    }
  }
  
  private void hideProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 0)) {
      paramProgressBarICS2.setVisibility(4);
    }
    if ((mFeatureProgress) && (paramProgressBarICS1.getVisibility() == 0)) {
      paramProgressBarICS1.setVisibility(4);
    }
  }
  
  private boolean initializePanelMenu()
  {
    mMenu = new MenuBuilder(getActionBarThemedContext());
    mMenu.setCallback(this);
    return true;
  }
  
  private boolean preparePanel()
  {
    if (mPanelIsPrepared) {
      return true;
    }
    if ((mMenu == null) || (mPanelRefreshContent))
    {
      if ((mMenu == null) && ((!initializePanelMenu()) || (mMenu == null))) {
        return false;
      }
      if (mActionBarView != null) {
        mActionBarView.setMenu(mMenu, this);
      }
      mMenu.stopDispatchingItemsChanged();
      if (!mActivity.superOnCreatePanelMenu(0, mMenu))
      {
        mMenu = null;
        if (mActionBarView != null) {
          mActionBarView.setMenu(null, this);
        }
        return false;
      }
      mPanelRefreshContent = false;
    }
    mMenu.stopDispatchingItemsChanged();
    if (mPanelFrozenActionViewState != null)
    {
      mMenu.restoreActionViewStates(mPanelFrozenActionViewState);
      mPanelFrozenActionViewState = null;
    }
    if (!mActivity.superOnPreparePanel(0, null, mMenu))
    {
      if (mActionBarView != null) {
        mActionBarView.setMenu(null, this);
      }
      mMenu.startDispatchingItemsChanged();
      return false;
    }
    mMenu.startDispatchingItemsChanged();
    mPanelIsPrepared = true;
    return true;
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((mActionBarView != null) && (mActionBarView.isOverflowReserved()))
    {
      if ((!mActionBarView.isOverflowMenuShowing()) || (!paramBoolean))
      {
        if (mActionBarView.getVisibility() == 0) {
          mActionBarView.showOverflowMenu();
        }
        return;
      }
      mActionBarView.hideOverflowMenu();
      return;
    }
    paramMenuBuilder.close();
  }
  
  private void showProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 4)) {
      paramProgressBarICS2.setVisibility(0);
    }
    if ((mFeatureProgress) && (paramProgressBarICS1.getProgress() < 10000)) {
      paramProgressBarICS1.setVisibility(0);
    }
  }
  
  private void updateProgressBars(int paramInt)
  {
    ProgressBarICS localProgressBarICS1 = getCircularProgressBar();
    ProgressBarICS localProgressBarICS2 = getHorizontalProgressBar();
    int j;
    if (paramInt == -1) {
      if (mFeatureProgress)
      {
        int i = localProgressBarICS2.getProgress();
        if ((localProgressBarICS2.isIndeterminate()) || (i < 10000))
        {
          j = 0;
          localProgressBarICS2.setVisibility(j);
        }
      }
      else if (mFeatureIndeterminateProgress)
      {
        localProgressBarICS1.setVisibility(0);
      }
    }
    label104:
    do
    {
      do
      {
        return;
        j = 4;
        break;
        if (paramInt != -2) {
          break label104;
        }
        if (mFeatureProgress) {
          localProgressBarICS2.setVisibility(8);
        }
      } while (!mFeatureIndeterminateProgress);
      localProgressBarICS1.setVisibility(8);
      return;
      if (paramInt == -3)
      {
        localProgressBarICS2.setIndeterminate(true);
        return;
      }
      if (paramInt == -4)
      {
        localProgressBarICS2.setIndeterminate(false);
        return;
      }
    } while ((paramInt < 0) || (paramInt > 10000));
    localProgressBarICS2.setProgress(paramInt + 0);
    if (paramInt < 10000)
    {
      showProgressBars(localProgressBarICS2, localProgressBarICS1);
      return;
    }
    hideProgressBars(localProgressBarICS2, localProgressBarICS1);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ((ViewGroup)mActivity.findViewById(16908290)).addView(paramView, paramLayoutParams);
    mActivity.onSupportContentChanged();
  }
  
  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    return new ActionBarImplBase(mActivity, mActivity);
  }
  
  final void ensureSubDecor()
  {
    boolean bool2;
    if (!mSubDecorInstalled)
    {
      if (!mHasActionBar) {
        break label322;
      }
      if (!mOverlayActionBar) {
        break label283;
      }
      mActivity.superSetContentView(R.layout.abc_action_bar_decor_overlay);
      mActionBarView = ((ActionBarView)mActivity.findViewById(R.id.action_bar));
      mActionBarView.setWindowCallback(mActivity);
      if (mFeatureProgress) {
        mActionBarView.initProgress();
      }
      if (mFeatureIndeterminateProgress) {
        mActionBarView.initIndeterminateProgress();
      }
      boolean bool1 = "splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata());
      if (!bool1) {
        break label296;
      }
      bool2 = mActivity.getResources().getBoolean(R.bool.abc_split_action_bar_is_narrow);
      label117:
      ActionBarContainer localActionBarContainer = (ActionBarContainer)mActivity.findViewById(R.id.split_action_bar);
      if (localActionBarContainer != null)
      {
        mActionBarView.setSplitView(localActionBarContainer);
        mActionBarView.setSplitActionBar(bool2);
        mActionBarView.setSplitWhenNarrow(bool1);
        ActionBarContextView localActionBarContextView = (ActionBarContextView)mActivity.findViewById(R.id.action_context_bar);
        localActionBarContextView.setSplitView(localActionBarContainer);
        localActionBarContextView.setSplitActionBar(bool2);
        localActionBarContextView.setSplitWhenNarrow(bool1);
      }
    }
    for (;;)
    {
      mActivity.findViewById(16908290).setId(-1);
      mActivity.findViewById(R.id.action_bar_activity_content).setId(16908290);
      if (mTitleToSet != null)
      {
        mActionBarView.setWindowTitle(mTitleToSet);
        mTitleToSet = null;
      }
      applyFixedSizeWindow();
      mSubDecorInstalled = true;
      mActivity.getWindow().getDecorView().post(new Runnable()
      {
        public void run()
        {
          supportInvalidateOptionsMenu();
        }
      });
      return;
      label283:
      mActivity.superSetContentView(R.layout.abc_action_bar_decor);
      break;
      label296:
      TypedArray localTypedArray = mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);
      bool2 = localTypedArray.getBoolean(2, false);
      localTypedArray.recycle();
      break label117;
      label322:
      mActivity.superSetContentView(R.layout.abc_simple_decor);
    }
  }
  
  int getHomeAsUpIndicatorAttrId()
  {
    return R.attr.homeAsUpIndicator;
  }
  
  public boolean onBackPressed()
  {
    if (mActionMode != null)
    {
      mActionMode.finish();
      return true;
    }
    if ((mActionBarView != null) && (mActionBarView.hasExpandedActionView()))
    {
      mActionBarView.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (mClosingActionMenu) {
      return;
    }
    mClosingActionMenu = true;
    mActivity.closeOptionsMenu();
    mActionBarView.dismissPopupMenus();
    mClosingActionMenu = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((mHasActionBar) && (mSubDecorInstalled)) {
      ((ActionBarImplBase)getSupportActionBar()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {
      return mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
    }
    return false;
  }
  
  public View onCreatePanelView(int paramInt)
  {
    View localView = null;
    if (paramInt == 0)
    {
      boolean bool = preparePanel();
      localView = null;
      if (bool) {
        localView = (View)getListMenuView(mActivity, this);
      }
    }
    return localView;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (paramInt == 0) {
      paramMenuItem = MenuWrapperFactory.createMenuItemWrapper(paramMenuItem);
    }
    return mActivity.superOnMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return mActivity.onMenuItemSelected(0, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    return false;
  }
  
  public void onPostResume()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {
      return mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
    }
    return false;
  }
  
  public void onStop()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(false);
    }
  }
  
  public void onTitleChanged(CharSequence paramCharSequence)
  {
    if (mActionBarView != null)
    {
      mActionBarView.setWindowTitle(paramCharSequence);
      return;
    }
    mTitleToSet = paramCharSequence;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    mActivity.getLayoutInflater().inflate(paramInt, localViewGroup);
    mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    mActivity.onSupportContentChanged();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    ViewGroup localViewGroup = (ViewGroup)mActivity.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    mActivity.onSupportContentChanged();
  }
  
  void setSupportProgress(int paramInt)
  {
    updateProgressBars(paramInt + 0);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -3;; i = -4)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (mActionMode != null) {
      mActionMode.finish();
    }
    ActionModeCallbackWrapper localActionModeCallbackWrapper = new ActionModeCallbackWrapper(paramCallback);
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      mActionMode = localActionBarImplBase.startActionMode(localActionModeCallbackWrapper);
    }
    if (mActionMode != null) {
      mActivity.onSupportActionModeStarted(mActionMode);
    }
    return mActionMode;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (mMenu != null)
    {
      Bundle localBundle = new Bundle();
      mMenu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        mPanelFrozenActionViewState = localBundle;
      }
      mMenu.stopDispatchingItemsChanged();
      mMenu.clear();
    }
    mPanelRefreshContent = true;
    if (mActionBarView != null)
    {
      mPanelIsPrepared = false;
      preparePanel();
    }
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return mActivity.requestWindowFeature(paramInt);
    case 8: 
      mHasActionBar = true;
      return true;
    case 9: 
      mOverlayActionBar = true;
      return true;
    case 2: 
      mFeatureProgress = true;
      return true;
    }
    mFeatureIndeterminateProgress = true;
    return true;
  }
  
  private class ActionModeCallbackWrapper
    implements ActionMode.Callback
  {
    private ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapper(ActionMode.Callback paramCallback)
    {
      mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrapped.onDestroyActionMode(paramActionMode);
      mActivity.onSupportActionModeFinished(paramActionMode);
      ActionBarActivityDelegateBase.access$002(ActionBarActivityDelegateBase.this, null);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}
