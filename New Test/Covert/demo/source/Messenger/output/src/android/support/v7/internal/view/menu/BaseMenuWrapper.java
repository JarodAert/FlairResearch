package android.support.v7.internal.view.menu;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  private HashMap<MenuItem, SupportMenuItem> mMenuItems;
  private HashMap<SubMenu, SubMenu> mSubMenus;
  
  BaseMenuWrapper(T paramT)
  {
    super(paramT);
  }
  
  final SupportMenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
    {
      if (mMenuItems == null) {
        mMenuItems = new HashMap();
      }
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)mMenuItems.get(paramMenuItem);
      if (localSupportMenuItem == null)
      {
        localSupportMenuItem = MenuWrapperFactory.createSupportMenuItemWrapper(paramMenuItem);
        mMenuItems.put(paramMenuItem, localSupportMenuItem);
      }
      return localSupportMenuItem;
    }
    return null;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    if (paramSubMenu != null)
    {
      if (mSubMenus == null) {
        mSubMenus = new HashMap();
      }
      Object localObject = (SubMenu)mSubMenus.get(paramSubMenu);
      if (localObject == null)
      {
        localObject = MenuWrapperFactory.createSupportSubMenuWrapper(paramSubMenu);
        mSubMenus.put(paramSubMenu, localObject);
      }
      return localObject;
    }
    return null;
  }
  
  final void internalClear()
  {
    if (mMenuItems != null) {
      mMenuItems.clear();
    }
    if (mSubMenus != null) {
      mSubMenus.clear();
    }
  }
  
  final void internalRemoveGroup(int paramInt)
  {
    if (mMenuItems == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = mMenuItems.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final void internalRemoveItem(int paramInt)
  {
    if (mMenuItems == null) {}
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = mMenuItems.keySet().iterator();
      }
    } while (paramInt != ((MenuItem)localIterator.next()).getItemId());
    localIterator.remove();
  }
}
