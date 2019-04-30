package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

class ActionBarActivityDelegateICS
  extends ActionBarActivityDelegate
{
  Menu mMenu;
  
  ActionBarActivityDelegateICS(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    mActivity.superAddContentView(paramView, paramLayoutParams);
  }
  
  ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context paramContext, android.support.v7.view.ActionMode.Callback paramCallback)
  {
    return new ActionModeWrapper.CallbackWrapper(paramContext, paramCallback);
  }
  
  ActionModeWrapper createActionModeWrapper(Context paramContext, android.view.ActionMode paramActionMode)
  {
    return new ActionModeWrapper(paramContext, paramActionMode);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplICS(mActivity, mActivity);
  }
  
  Window.Callback createWindowCallbackWrapper(Window.Callback paramCallback)
  {
    return new WindowCallbackWrapper(paramCallback);
  }
  
  int getHomeAsUpIndicatorAttrId()
  {
    return 16843531;
  }
  
  public void onActionModeFinished(android.view.ActionMode paramActionMode)
  {
    mActivity.onSupportActionModeFinished(createActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public void onActionModeStarted(android.view.ActionMode paramActionMode)
  {
    mActivity.onSupportActionModeStarted(createActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onContentChanged()
  {
    mActivity.onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ("splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata())) {
      mActivity.getWindow().setUiOptions(1, 1);
    }
    super.onCreate(paramBundle);
    if (mHasActionBar) {
      mActivity.requestWindowFeature(8);
    }
    if (mOverlayActionBar) {
      mActivity.requestWindowFeature(9);
    }
    Window localWindow = mActivity.getWindow();
    localWindow.setCallback(createWindowCallbackWrapper(localWindow.getCallback()));
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8))
    {
      if (mMenu == null) {
        mMenu = MenuWrapperFactory.createMenuWrapper(paramMenu);
      }
      return mActivity.superOnCreatePanelMenu(paramInt, mMenu);
    }
    return mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return null;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (paramInt == 0) {
      paramMenuItem = MenuWrapperFactory.createMenuItemWrapper(paramMenuItem);
    }
    return mActivity.superOnMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void onPostResume() {}
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8)) {
      return mActivity.superOnPreparePanel(paramInt, paramView, mMenu);
    }
    return mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onStop() {}
  
  public void onTitleChanged(CharSequence paramCharSequence) {}
  
  public void setContentView(int paramInt)
  {
    mActivity.superSetContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    mActivity.superSetContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    mActivity.superSetContentView(paramView, paramLayoutParams);
  }
  
  void setSupportProgress(int paramInt)
  {
    mActivity.setProgress(paramInt);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    mActivity.setProgressBarIndeterminate(paramBoolean);
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    mActivity.setProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    mActivity.setProgressBarVisibility(paramBoolean);
  }
  
  public android.support.v7.view.ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    Context localContext = getActionBarThemedContext();
    ActionModeWrapper.CallbackWrapper localCallbackWrapper = createActionModeCallbackWrapper(localContext, paramCallback);
    android.view.ActionMode localActionMode = mActivity.startActionMode(localCallbackWrapper);
    ActionModeWrapper localActionModeWrapper = null;
    if (localActionMode != null)
    {
      localActionModeWrapper = createActionModeWrapper(localContext, localActionMode);
      localCallbackWrapper.setLastStartedActionMode(localActionModeWrapper);
    }
    return localActionModeWrapper;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    mMenu = null;
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return mActivity.requestWindowFeature(paramInt);
  }
  
  class WindowCallbackWrapper
    implements Window.Callback
  {
    final Window.Callback mWrapped;
    
    public WindowCallbackWrapper(Window.Callback paramCallback)
    {
      mWrapped = paramCallback;
    }
    
    public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
    {
      return mWrapped.dispatchGenericMotionEvent(paramMotionEvent);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return mWrapped.dispatchKeyEvent(paramKeyEvent);
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return mWrapped.dispatchKeyShortcutEvent(paramKeyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      return mWrapped.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return mWrapped.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
    {
      return mWrapped.dispatchTrackballEvent(paramMotionEvent);
    }
    
    public void onActionModeFinished(android.view.ActionMode paramActionMode)
    {
      mWrapped.onActionModeFinished(paramActionMode);
      ActionBarActivityDelegateICS.this.onActionModeFinished(paramActionMode);
    }
    
    public void onActionModeStarted(android.view.ActionMode paramActionMode)
    {
      mWrapped.onActionModeStarted(paramActionMode);
      ActionBarActivityDelegateICS.this.onActionModeStarted(paramActionMode);
    }
    
    public void onAttachedToWindow()
    {
      mWrapped.onAttachedToWindow();
    }
    
    public void onContentChanged()
    {
      mWrapped.onContentChanged();
    }
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      return mWrapped.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public View onCreatePanelView(int paramInt)
    {
      return mWrapped.onCreatePanelView(paramInt);
    }
    
    public void onDetachedFromWindow()
    {
      mWrapped.onDetachedFromWindow();
    }
    
    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
    {
      return mWrapped.onMenuItemSelected(paramInt, paramMenuItem);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      return mWrapped.onMenuOpened(paramInt, paramMenu);
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      mWrapped.onPanelClosed(paramInt, paramMenu);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      return mWrapped.onPreparePanel(paramInt, paramView, paramMenu);
    }
    
    public boolean onSearchRequested()
    {
      return mWrapped.onSearchRequested();
    }
    
    public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
    {
      mWrapped.onWindowAttributesChanged(paramLayoutParams);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      mWrapped.onWindowFocusChanged(paramBoolean);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback)
    {
      return mWrapped.onWindowStartingActionMode(paramCallback);
    }
  }
}
