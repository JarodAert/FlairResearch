package android.support.v7.app;

import android.support.v7.appcompat.R.id;
import android.support.v7.internal.widget.NativeActionModeAwareLayout;
import android.support.v7.internal.widget.NativeActionModeAwareLayout.OnActionModeForChildListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class ActionBarImplHC
  extends ActionBarImplBase
  implements NativeActionModeAwareLayout.OnActionModeForChildListener
{
  private ActionMode mCurActionMode;
  final NativeActionModeAwareLayout mNativeActionModeAwareLayout;
  
  public ActionBarImplHC(ActionBarActivity paramActionBarActivity, ActionBar.Callback paramCallback)
  {
    super(paramActionBarActivity, paramCallback);
    mNativeActionModeAwareLayout = ((NativeActionModeAwareLayout)paramActionBarActivity.findViewById(R.id.action_bar_root));
    if (mNativeActionModeAwareLayout != null) {
      mNativeActionModeAwareLayout.setActionModeForChildListener(this);
    }
  }
  
  public void hide()
  {
    super.hide();
    if (mCurActionMode != null) {
      mCurActionMode.finish();
    }
  }
  
  boolean isShowHideAnimationEnabled()
  {
    return (mCurActionMode == null) && (super.isShowHideAnimationEnabled());
  }
  
  public ActionMode.Callback onActionModeForChild(ActionMode.Callback paramCallback)
  {
    return new CallbackWrapper(paramCallback);
  }
  
  public void show()
  {
    super.show();
    if (mCurActionMode != null) {
      mCurActionMode.finish();
    }
  }
  
  private class CallbackWrapper
    implements ActionMode.Callback
  {
    private final ActionMode.Callback mWrappedCallback;
    
    CallbackWrapper(ActionMode.Callback paramCallback)
    {
      mWrappedCallback = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrappedCallback.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      boolean bool = mWrappedCallback.onCreateActionMode(paramActionMode, paramMenu);
      if (bool)
      {
        ActionBarImplHC.access$002(ActionBarImplHC.this, paramActionMode);
        showForActionMode();
      }
      return bool;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      mWrappedCallback.onDestroyActionMode(paramActionMode);
      hideForActionMode();
      ActionBarImplHC.access$002(ActionBarImplHC.this, null);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}
