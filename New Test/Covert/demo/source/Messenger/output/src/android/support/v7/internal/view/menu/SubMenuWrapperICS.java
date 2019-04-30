package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS
  extends MenuWrapperICS
  implements SupportSubMenu
{
  SubMenuWrapperICS(SubMenu paramSubMenu)
  {
    super(paramSubMenu);
  }
  
  public void clearHeader()
  {
    ((SubMenu)mWrappedObject).clearHeader();
  }
  
  public MenuItem getItem()
  {
    return getMenuItemWrapper(((SubMenu)mWrappedObject).getItem());
  }
  
  public SubMenu getWrappedObject()
  {
    return (SubMenu)mWrappedObject;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    ((SubMenu)mWrappedObject).setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((SubMenu)mWrappedObject).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    ((SubMenu)mWrappedObject).setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((SubMenu)mWrappedObject).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    ((SubMenu)mWrappedObject).setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    ((SubMenu)mWrappedObject).setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    ((SubMenu)mWrappedObject).setIcon(paramDrawable);
    return this;
  }
}
