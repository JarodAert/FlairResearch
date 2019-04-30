package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplICS
  extends ActionBar
{
  final android.app.ActionBar mActionBar;
  android.support.v4.app.FragmentTransaction mActiveTransaction;
  final Activity mActivity;
  private ArrayList<WeakReference<OnMenuVisibilityListenerWrapper>> mAddedMenuVisWrappers = new ArrayList();
  final ActionBar.Callback mCallback;
  private ImageView mHomeActionView;
  
  public ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback)
  {
    this(paramActivity, paramCallback, true);
  }
  
  ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback, boolean paramBoolean)
  {
    mActivity = paramActivity;
    mCallback = paramCallback;
    mActionBar = paramActivity.getActionBar();
    if ((paramBoolean) && ((0x4 & getDisplayOptions()) != 0)) {
      setHomeButtonEnabled(true);
    }
  }
  
  private OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    int i = 0;
    if (i < mAddedMenuVisWrappers.size())
    {
      OnMenuVisibilityListenerWrapper localOnMenuVisibilityListenerWrapper = (OnMenuVisibilityListenerWrapper)((WeakReference)mAddedMenuVisWrappers.get(i)).get();
      if (localOnMenuVisibilityListenerWrapper == null)
      {
        localArrayList = mAddedMenuVisWrappers;
        j = i - 1;
        localArrayList.remove(i);
        i = j;
      }
      while (mWrappedListener != paramOnMenuVisibilityListener)
      {
        ArrayList localArrayList;
        int j;
        i++;
        break;
      }
      mAddedMenuVisWrappers.remove(i);
      return localOnMenuVisibilityListenerWrapper;
    }
    return null;
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    if (paramOnMenuVisibilityListener != null)
    {
      OnMenuVisibilityListenerWrapper localOnMenuVisibilityListenerWrapper = new OnMenuVisibilityListenerWrapper(paramOnMenuVisibilityListener);
      mAddedMenuVisWrappers.add(new WeakReference(localOnMenuVisibilityListenerWrapper));
      mActionBar.addOnMenuVisibilityListener(localOnMenuVisibilityListenerWrapper);
    }
  }
  
  public void addTab(ActionBar.Tab paramTab)
  {
    mActionBar.addTab(mWrappedTab);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt)
  {
    mActionBar.addTab(mWrappedTab, paramInt);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    mActionBar.addTab(mWrappedTab, paramInt, paramBoolean);
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    mActionBar.addTab(mWrappedTab, paramBoolean);
  }
  
  void commitActiveTransaction()
  {
    if ((mActiveTransaction != null) && (!mActiveTransaction.isEmpty())) {
      mActiveTransaction.commit();
    }
    mActiveTransaction = null;
  }
  
  android.support.v4.app.FragmentTransaction getActiveTransaction()
  {
    if (mActiveTransaction == null) {
      mActiveTransaction = mCallback.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
    }
    return mActiveTransaction;
  }
  
  public View getCustomView()
  {
    return mActionBar.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return mActionBar.getDisplayOptions();
  }
  
  public int getHeight()
  {
    return mActionBar.getHeight();
  }
  
  ImageView getHomeActionView()
  {
    View localView2;
    View localView3;
    if (mHomeActionView == null)
    {
      View localView1 = mActivity.findViewById(16908332);
      if (localView1 == null) {}
      ViewGroup localViewGroup;
      do
      {
        return null;
        localViewGroup = (ViewGroup)localView1.getParent();
      } while (localViewGroup.getChildCount() != 2);
      localView2 = localViewGroup.getChildAt(0);
      localView3 = localViewGroup.getChildAt(1);
      if (localView2.getId() != 16908332) {
        break label87;
      }
    }
    label87:
    for (View localView4 = localView3;; localView4 = localView2)
    {
      if ((localView4 instanceof ImageView)) {
        mHomeActionView = ((ImageView)localView4);
      }
      return mHomeActionView;
    }
  }
  
  public int getNavigationItemCount()
  {
    return mActionBar.getNavigationItemCount();
  }
  
  public int getNavigationMode()
  {
    return mActionBar.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    return mActionBar.getSelectedNavigationIndex();
  }
  
  public ActionBar.Tab getSelectedTab()
  {
    return (ActionBar.Tab)mActionBar.getSelectedTab().getTag();
  }
  
  public CharSequence getSubtitle()
  {
    return mActionBar.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt)
  {
    return (ActionBar.Tab)mActionBar.getTabAt(paramInt).getTag();
  }
  
  public int getTabCount()
  {
    return mActionBar.getTabCount();
  }
  
  Drawable getThemeDefaultUpIndicator()
  {
    TypedArray localTypedArray = mActivity.obtainStyledAttributes(new int[] { 16843531 });
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public Context getThemedContext()
  {
    return mActionBar.getThemedContext();
  }
  
  public CharSequence getTitle()
  {
    return mActionBar.getTitle();
  }
  
  public void hide()
  {
    mActionBar.hide();
  }
  
  public boolean isShowing()
  {
    return mActionBar.isShowing();
  }
  
  public ActionBar.Tab newTab()
  {
    android.app.ActionBar.Tab localTab = mActionBar.newTab();
    TabWrapper localTabWrapper = new TabWrapper(localTab);
    localTab.setTag(localTabWrapper);
    return localTabWrapper;
  }
  
  public void removeAllTabs()
  {
    mActionBar.removeAllTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    OnMenuVisibilityListenerWrapper localOnMenuVisibilityListenerWrapper = findAndRemoveMenuVisWrapper(paramOnMenuVisibilityListener);
    mActionBar.removeOnMenuVisibilityListener(localOnMenuVisibilityListenerWrapper);
  }
  
  public void removeTab(ActionBar.Tab paramTab)
  {
    mActionBar.removeTab(mWrappedTab);
  }
  
  public void removeTabAt(int paramInt)
  {
    mActionBar.removeTabAt(paramInt);
  }
  
  public void selectTab(ActionBar.Tab paramTab)
  {
    mActionBar.selectTab(mWrappedTab);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    mActionBar.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    mActionBar.setCustomView(paramInt);
  }
  
  public void setCustomView(View paramView)
  {
    mActionBar.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    android.app.ActionBar.LayoutParams localLayoutParams = new android.app.ActionBar.LayoutParams(paramLayoutParams);
    gravity = gravity;
    mActionBar.setCustomView(paramView, localLayoutParams);
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  public void setDisplayOptions(int paramInt)
  {
    mActionBar.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    mActionBar.setDisplayOptions(paramInt1, paramInt2);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayShowCustomEnabled(paramBoolean);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayShowHomeEnabled(paramBoolean);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayShowTitleEnabled(paramBoolean);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    mActionBar.setDisplayUseLogoEnabled(paramBoolean);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    ImageView localImageView = getHomeActionView();
    if (localImageView != null)
    {
      if (paramInt != 0) {
        localImageView.setImageResource(paramInt);
      }
    }
    else {
      return;
    }
    localImageView.setImageDrawable(getThemeDefaultUpIndicator());
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    ImageView localImageView = getHomeActionView();
    if (localImageView != null)
    {
      if (paramDrawable == null) {
        paramDrawable = getThemeDefaultUpIndicator();
      }
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    mActionBar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    mActionBar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    mActionBar.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    android.app.ActionBar localActionBar = mActionBar;
    if (paramOnNavigationListener != null) {}
    for (OnNavigationListenerWrapper localOnNavigationListenerWrapper = new OnNavigationListenerWrapper(paramOnNavigationListener);; localOnNavigationListenerWrapper = null)
    {
      localActionBar.setListNavigationCallbacks(paramSpinnerAdapter, localOnNavigationListenerWrapper);
      return;
    }
  }
  
  public void setLogo(int paramInt)
  {
    mActionBar.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    mActionBar.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    mActionBar.setNavigationMode(paramInt);
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    mActionBar.setSelectedNavigationItem(paramInt);
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable)
  {
    mActionBar.setSplitBackgroundDrawable(paramDrawable);
  }
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable)
  {
    mActionBar.setStackedBackgroundDrawable(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    mActionBar.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mActionBar.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    mActionBar.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mActionBar.setTitle(paramCharSequence);
  }
  
  public void show()
  {
    mActionBar.show();
  }
  
  static class OnMenuVisibilityListenerWrapper
    implements android.app.ActionBar.OnMenuVisibilityListener
  {
    final ActionBar.OnMenuVisibilityListener mWrappedListener;
    
    public OnMenuVisibilityListenerWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
    {
      mWrappedListener = paramOnMenuVisibilityListener;
    }
    
    public void onMenuVisibilityChanged(boolean paramBoolean)
    {
      mWrappedListener.onMenuVisibilityChanged(paramBoolean);
    }
  }
  
  static class OnNavigationListenerWrapper
    implements android.app.ActionBar.OnNavigationListener
  {
    private final ActionBar.OnNavigationListener mWrappedListener;
    
    public OnNavigationListenerWrapper(ActionBar.OnNavigationListener paramOnNavigationListener)
    {
      mWrappedListener = paramOnNavigationListener;
    }
    
    public boolean onNavigationItemSelected(int paramInt, long paramLong)
    {
      return mWrappedListener.onNavigationItemSelected(paramInt, paramLong);
    }
  }
  
  class TabWrapper
    extends ActionBar.Tab
    implements android.app.ActionBar.TabListener
  {
    private CharSequence mContentDescription;
    private ActionBar.TabListener mTabListener;
    private Object mTag;
    final android.app.ActionBar.Tab mWrappedTab;
    
    public TabWrapper(android.app.ActionBar.Tab paramTab)
    {
      mWrappedTab = paramTab;
    }
    
    public CharSequence getContentDescription()
    {
      return mContentDescription;
    }
    
    public View getCustomView()
    {
      return mWrappedTab.getCustomView();
    }
    
    public Drawable getIcon()
    {
      return mWrappedTab.getIcon();
    }
    
    public int getPosition()
    {
      return mWrappedTab.getPosition();
    }
    
    public Object getTag()
    {
      return mTag;
    }
    
    public CharSequence getText()
    {
      return mWrappedTab.getText();
    }
    
    public void onTabReselected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = mTabListener;
      if (paramFragmentTransaction != null) {}
      for (android.support.v4.app.FragmentTransaction localFragmentTransaction = getActiveTransaction();; localFragmentTransaction = null)
      {
        localTabListener.onTabReselected(this, localFragmentTransaction);
        commitActiveTransaction();
        return;
      }
    }
    
    public void onTabSelected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = mTabListener;
      if (paramFragmentTransaction != null) {}
      for (android.support.v4.app.FragmentTransaction localFragmentTransaction = getActiveTransaction();; localFragmentTransaction = null)
      {
        localTabListener.onTabSelected(this, localFragmentTransaction);
        commitActiveTransaction();
        return;
      }
    }
    
    public void onTabUnselected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = mTabListener;
      if (paramFragmentTransaction != null) {}
      for (android.support.v4.app.FragmentTransaction localFragmentTransaction = getActiveTransaction();; localFragmentTransaction = null)
      {
        localTabListener.onTabUnselected(this, localFragmentTransaction);
        return;
      }
    }
    
    public void select()
    {
      mWrappedTab.select();
    }
    
    public ActionBar.Tab setContentDescription(int paramInt)
    {
      mContentDescription = mActivity.getText(paramInt);
      return this;
    }
    
    public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
    {
      mContentDescription = paramCharSequence;
      return this;
    }
    
    public ActionBar.Tab setCustomView(int paramInt)
    {
      mWrappedTab.setCustomView(paramInt);
      return this;
    }
    
    public ActionBar.Tab setCustomView(View paramView)
    {
      mWrappedTab.setCustomView(paramView);
      return this;
    }
    
    public ActionBar.Tab setIcon(int paramInt)
    {
      mWrappedTab.setIcon(paramInt);
      return this;
    }
    
    public ActionBar.Tab setIcon(Drawable paramDrawable)
    {
      mWrappedTab.setIcon(paramDrawable);
      return this;
    }
    
    public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
    {
      mTabListener = paramTabListener;
      android.app.ActionBar.Tab localTab = mWrappedTab;
      if (paramTabListener != null) {}
      for (TabWrapper localTabWrapper = this;; localTabWrapper = null)
      {
        localTab.setTabListener(localTabWrapper);
        return this;
      }
    }
    
    public ActionBar.Tab setTag(Object paramObject)
    {
      mTag = paramObject;
      return this;
    }
    
    public ActionBar.Tab setText(int paramInt)
    {
      mWrappedTab.setText(paramInt);
      return this;
    }
    
    public ActionBar.Tab setText(CharSequence paramCharSequence)
    {
      mWrappedTab.setText(paramCharSequence);
      return this;
    }
  }
}
