package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ActionModeWrapper
  extends android.support.v7.view.ActionMode
{
  final MenuInflater mInflater;
  final android.view.ActionMode mWrappedObject;
  
  public ActionModeWrapper(Context paramContext, android.view.ActionMode paramActionMode)
  {
    mWrappedObject = paramActionMode;
    mInflater = new SupportMenuInflater(paramContext);
  }
  
  public void finish()
  {
    mWrappedObject.finish();
  }
  
  public View getCustomView()
  {
    return mWrappedObject.getCustomView();
  }
  
  public Menu getMenu()
  {
    return MenuWrapperFactory.createMenuWrapper(mWrappedObject.getMenu());
  }
  
  public MenuInflater getMenuInflater()
  {
    return mInflater;
  }
  
  public CharSequence getSubtitle()
  {
    return mWrappedObject.getSubtitle();
  }
  
  public Object getTag()
  {
    return mWrappedObject.getTag();
  }
  
  public CharSequence getTitle()
  {
    return mWrappedObject.getTitle();
  }
  
  public void invalidate()
  {
    mWrappedObject.invalidate();
  }
  
  public void setCustomView(View paramView)
  {
    mWrappedObject.setCustomView(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    mWrappedObject.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setSubtitle(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    mWrappedObject.setTag(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    mWrappedObject.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mWrappedObject.setTitle(paramCharSequence);
  }
  
  public static class CallbackWrapper
    implements android.view.ActionMode.Callback
  {
    final Context mContext;
    private ActionModeWrapper mLastStartedActionMode;
    final android.support.v7.view.ActionMode.Callback mWrappedCallback;
    
    public CallbackWrapper(Context paramContext, android.support.v7.view.ActionMode.Callback paramCallback)
    {
      mContext = paramContext;
      mWrappedCallback = paramCallback;
    }
    
    private android.support.v7.view.ActionMode getActionModeWrapper(android.view.ActionMode paramActionMode)
    {
      if ((mLastStartedActionMode != null) && (mLastStartedActionMode.mWrappedObject == paramActionMode)) {
        return mLastStartedActionMode;
      }
      return createActionModeWrapper(mContext, paramActionMode);
    }
    
    protected ActionModeWrapper createActionModeWrapper(Context paramContext, android.view.ActionMode paramActionMode)
    {
      return new ActionModeWrapper(paramContext, paramActionMode);
    }
    
    public boolean onActionItemClicked(android.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return mWrappedCallback.onActionItemClicked(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuItemWrapper(paramMenuItem));
    }
    
    public boolean onCreateActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onCreateActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
    }
    
    public void onDestroyActionMode(android.view.ActionMode paramActionMode)
    {
      mWrappedCallback.onDestroyActionMode(getActionModeWrapper(paramActionMode));
    }
    
    public boolean onPrepareActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return mWrappedCallback.onPrepareActionMode(getActionModeWrapper(paramActionMode), MenuWrapperFactory.createMenuWrapper(paramMenu));
    }
    
    public void setLastStartedActionMode(ActionModeWrapper paramActionModeWrapper)
    {
      mLastStartedActionMode = paramActionModeWrapper;
    }
  }
}
