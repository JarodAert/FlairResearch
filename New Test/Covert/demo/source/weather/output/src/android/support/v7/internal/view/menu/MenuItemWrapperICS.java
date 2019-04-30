package android.support.v7.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class MenuItemWrapperICS
  extends BaseMenuWrapper<MenuItem>
  implements SupportMenuItem
{
  static final String LOG_TAG = "MenuItemWrapper";
  private final boolean mEmulateProviderVisibilityOverride;
  private boolean mLastRequestVisible;
  private Method mSetExclusiveCheckableMethod;
  
  MenuItemWrapperICS(MenuItem paramMenuItem)
  {
    this(paramMenuItem, true);
  }
  
  MenuItemWrapperICS(MenuItem paramMenuItem, boolean paramBoolean)
  {
    super(paramMenuItem);
    mLastRequestVisible = paramMenuItem.isVisible();
    mEmulateProviderVisibilityOverride = paramBoolean;
  }
  
  final boolean checkActionProviderOverrideVisibility()
  {
    boolean bool1 = mLastRequestVisible;
    boolean bool2 = false;
    if (bool1)
    {
      android.support.v4.view.ActionProvider localActionProvider = getSupportActionProvider();
      bool2 = false;
      if (localActionProvider != null)
      {
        boolean bool3 = localActionProvider.overridesItemVisibility();
        bool2 = false;
        if (bool3)
        {
          boolean bool4 = localActionProvider.isVisible();
          bool2 = false;
          if (!bool4)
          {
            wrappedSetVisible(false);
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean collapseActionView()
  {
    return ((MenuItem)mWrappedObject).collapseActionView();
  }
  
  ActionProviderWrapper createActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider)
  {
    return new ActionProviderWrapper(paramActionProvider);
  }
  
  public boolean expandActionView()
  {
    return ((MenuItem)mWrappedObject).expandActionView();
  }
  
  public android.view.ActionProvider getActionProvider()
  {
    return ((MenuItem)mWrappedObject).getActionProvider();
  }
  
  public View getActionView()
  {
    View localView = ((MenuItem)mWrappedObject).getActionView();
    if ((localView instanceof CollapsibleActionViewWrapper)) {
      localView = ((CollapsibleActionViewWrapper)localView).getWrappedView();
    }
    return localView;
  }
  
  public char getAlphabeticShortcut()
  {
    return ((MenuItem)mWrappedObject).getAlphabeticShortcut();
  }
  
  public int getGroupId()
  {
    return ((MenuItem)mWrappedObject).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((MenuItem)mWrappedObject).getIcon();
  }
  
  public Intent getIntent()
  {
    return ((MenuItem)mWrappedObject).getIntent();
  }
  
  public int getItemId()
  {
    return ((MenuItem)mWrappedObject).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((MenuItem)mWrappedObject).getMenuInfo();
  }
  
  public char getNumericShortcut()
  {
    return ((MenuItem)mWrappedObject).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((MenuItem)mWrappedObject).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return getSubMenuWrapper(((MenuItem)mWrappedObject).getSubMenu());
  }
  
  public android.support.v4.view.ActionProvider getSupportActionProvider()
  {
    ActionProviderWrapper localActionProviderWrapper = (ActionProviderWrapper)((MenuItem)mWrappedObject).getActionProvider();
    if (localActionProviderWrapper != null) {
      return mInner;
    }
    return null;
  }
  
  public CharSequence getTitle()
  {
    return ((MenuItem)mWrappedObject).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((MenuItem)mWrappedObject).getTitleCondensed();
  }
  
  public boolean hasSubMenu()
  {
    return ((MenuItem)mWrappedObject).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((MenuItem)mWrappedObject).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((MenuItem)mWrappedObject).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((MenuItem)mWrappedObject).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((MenuItem)mWrappedObject).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((MenuItem)mWrappedObject).isVisible();
  }
  
  public MenuItem setActionProvider(android.view.ActionProvider paramActionProvider)
  {
    ((MenuItem)mWrappedObject).setActionProvider(paramActionProvider);
    if ((paramActionProvider != null) && (mEmulateProviderVisibilityOverride)) {
      checkActionProviderOverrideVisibility();
    }
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((MenuItem)mWrappedObject).setActionView(paramInt);
    View localView = ((MenuItem)mWrappedObject).getActionView();
    if ((localView instanceof android.support.v7.view.CollapsibleActionView)) {
      ((MenuItem)mWrappedObject).setActionView(new CollapsibleActionViewWrapper(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    if ((paramView instanceof android.support.v7.view.CollapsibleActionView)) {
      paramView = new CollapsibleActionViewWrapper(paramView);
    }
    ((MenuItem)mWrappedObject).setActionView(paramView);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((MenuItem)mWrappedObject).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((MenuItem)mWrappedObject).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((MenuItem)mWrappedObject).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((MenuItem)mWrappedObject).setEnabled(paramBoolean);
    return this;
  }
  
  public void setExclusiveCheckable(boolean paramBoolean)
  {
    try
    {
      if (mSetExclusiveCheckableMethod == null)
      {
        Class localClass = ((MenuItem)mWrappedObject).getClass();
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        mSetExclusiveCheckableMethod = localClass.getDeclaredMethod("setExclusiveCheckable", arrayOfClass);
      }
      Method localMethod = mSetExclusiveCheckableMethod;
      Object localObject = mWrappedObject;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(localObject, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((MenuItem)mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((MenuItem)mWrappedObject).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((MenuItem)mWrappedObject).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((MenuItem)mWrappedObject).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ((MenuItem)mWrappedObject).setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    MenuItem localMenuItem = (MenuItem)mWrappedObject;
    if (paramOnMenuItemClickListener != null) {}
    for (OnMenuItemClickListenerWrapper localOnMenuItemClickListenerWrapper = new OnMenuItemClickListenerWrapper(paramOnMenuItemClickListener);; localOnMenuItemClickListenerWrapper = null)
    {
      localMenuItem.setOnMenuItemClickListener(localOnMenuItemClickListenerWrapper);
      return this;
    }
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((MenuItem)mWrappedObject).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((MenuItem)mWrappedObject).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((MenuItem)mWrappedObject).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public SupportMenuItem setSupportActionProvider(android.support.v4.view.ActionProvider paramActionProvider)
  {
    MenuItem localMenuItem = (MenuItem)mWrappedObject;
    if (paramActionProvider != null) {}
    for (ActionProviderWrapper localActionProviderWrapper = createActionProviderWrapper(paramActionProvider);; localActionProviderWrapper = null)
    {
      localMenuItem.setActionProvider(localActionProviderWrapper);
      return this;
    }
  }
  
  public SupportMenuItem setSupportOnActionExpandListener(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
  {
    MenuItem localMenuItem = (MenuItem)mWrappedObject;
    if (paramOnActionExpandListener != null) {}
    for (OnActionExpandListenerWrapper localOnActionExpandListenerWrapper = new OnActionExpandListenerWrapper(paramOnActionExpandListener);; localOnActionExpandListenerWrapper = null)
    {
      localMenuItem.setOnActionExpandListener(localOnActionExpandListenerWrapper);
      return null;
    }
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((MenuItem)mWrappedObject).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((MenuItem)mWrappedObject).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((MenuItem)mWrappedObject).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (mEmulateProviderVisibilityOverride)
    {
      mLastRequestVisible = paramBoolean;
      if (checkActionProviderOverrideVisibility()) {
        return this;
      }
    }
    return wrappedSetVisible(paramBoolean);
  }
  
  final MenuItem wrappedSetVisible(boolean paramBoolean)
  {
    return ((MenuItem)mWrappedObject).setVisible(paramBoolean);
  }
  
  class ActionProviderWrapper
    extends android.view.ActionProvider
  {
    final android.support.v4.view.ActionProvider mInner;
    
    public ActionProviderWrapper(android.support.v4.view.ActionProvider paramActionProvider)
    {
      super();
      mInner = paramActionProvider;
      if (mEmulateProviderVisibilityOverride) {
        mInner.setVisibilityListener(new ActionProvider.VisibilityListener()
        {
          public void onActionProviderVisibilityChanged(boolean paramAnonymousBoolean)
          {
            if ((mInner.overridesItemVisibility()) && (mLastRequestVisible)) {
              wrappedSetVisible(paramAnonymousBoolean);
            }
          }
        });
      }
    }
    
    public boolean hasSubMenu()
    {
      return mInner.hasSubMenu();
    }
    
    public View onCreateActionView()
    {
      if (mEmulateProviderVisibilityOverride) {
        checkActionProviderOverrideVisibility();
      }
      return mInner.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction()
    {
      return mInner.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(SubMenu paramSubMenu)
    {
      mInner.onPrepareSubMenu(getSubMenuWrapper(paramSubMenu));
    }
  }
  
  static class CollapsibleActionViewWrapper
    extends FrameLayout
    implements android.view.CollapsibleActionView
  {
    final android.support.v7.view.CollapsibleActionView mWrappedView;
    
    CollapsibleActionViewWrapper(View paramView)
    {
      super();
      mWrappedView = ((android.support.v7.view.CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    View getWrappedView()
    {
      return (View)mWrappedView;
    }
    
    public void onActionViewCollapsed()
    {
      mWrappedView.onActionViewCollapsed();
    }
    
    public void onActionViewExpanded()
    {
      mWrappedView.onActionViewExpanded();
    }
  }
  
  private class OnActionExpandListenerWrapper
    extends BaseWrapper<MenuItemCompat.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    OnActionExpandListenerWrapper(MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItemCompat.OnActionExpandListener)mWrappedObject).onMenuItemActionCollapse(getMenuItemWrapper(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItemCompat.OnActionExpandListener)mWrappedObject).onMenuItemActionExpand(getMenuItemWrapper(paramMenuItem));
    }
  }
  
  private class OnMenuItemClickListenerWrapper
    extends BaseWrapper<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)mWrappedObject).onMenuItemClick(getMenuItemWrapper(paramMenuItem));
    }
  }
}
