package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class ActionBarDrawerToggle
  implements DrawerLayout.DrawerListener
{
  private static final int ID_HOME = 16908332;
  private static final ActionBarDrawerToggleImpl IMPL = new ActionBarDrawerToggleImplBase(null);
  private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334F;
  private final Activity mActivity;
  private final Delegate mActivityImpl;
  private final int mCloseDrawerContentDescRes;
  private Drawable mDrawerImage;
  private final int mDrawerImageResource;
  private boolean mDrawerIndicatorEnabled = true;
  private final DrawerLayout mDrawerLayout;
  private final int mOpenDrawerContentDescRes;
  private Object mSetIndicatorInfo;
  private SlideDrawable mSlider;
  private Drawable mThemeImage;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new ActionBarDrawerToggleImplHC(null);
      return;
    }
  }
  
  public ActionBarDrawerToggle(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    mActivity = paramActivity;
    if ((paramActivity instanceof DelegateProvider)) {}
    for (mActivityImpl = ((DelegateProvider)paramActivity).getDrawerToggleDelegate();; mActivityImpl = null)
    {
      mDrawerLayout = paramDrawerLayout;
      mDrawerImageResource = paramInt1;
      mOpenDrawerContentDescRes = paramInt2;
      mCloseDrawerContentDescRes = paramInt3;
      mThemeImage = getThemeUpIndicator();
      mDrawerImage = paramActivity.getResources().getDrawable(paramInt1);
      mSlider = new SlideDrawable(mDrawerImage, null);
      mSlider.setOffset(0.33333334F);
      return;
    }
  }
  
  Drawable getThemeUpIndicator()
  {
    if (mActivityImpl != null) {
      return mActivityImpl.getThemeUpIndicator();
    }
    return IMPL.getThemeUpIndicator(mActivity);
  }
  
  public boolean isDrawerIndicatorEnabled()
  {
    return mDrawerIndicatorEnabled;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    mThemeImage = getThemeUpIndicator();
    mDrawerImage = mActivity.getResources().getDrawable(mDrawerImageResource);
    syncState();
  }
  
  public void onDrawerClosed(View paramView)
  {
    mSlider.setPosition(0.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mOpenDrawerContentDescRes);
    }
  }
  
  public void onDrawerOpened(View paramView)
  {
    mSlider.setPosition(1.0F);
    if (mDrawerIndicatorEnabled) {
      setActionBarDescription(mCloseDrawerContentDescRes);
    }
  }
  
  public void onDrawerSlide(View paramView, float paramFloat)
  {
    float f1 = mSlider.getPosition();
    if (paramFloat > 0.5F) {}
    for (float f2 = Math.max(f1, 2.0F * Math.max(0.0F, paramFloat - 0.5F));; f2 = Math.min(f1, paramFloat * 2.0F))
    {
      mSlider.setPosition(f2);
      return;
    }
  }
  
  public void onDrawerStateChanged(int paramInt) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem != null) && (paramMenuItem.getItemId() == 16908332) && (mDrawerIndicatorEnabled))
    {
      if (mDrawerLayout.isDrawerVisible(8388611)) {
        mDrawerLayout.closeDrawer(8388611);
      }
      for (;;)
      {
        return true;
        mDrawerLayout.openDrawer(8388611);
      }
    }
    return false;
  }
  
  void setActionBarDescription(int paramInt)
  {
    if (mActivityImpl != null)
    {
      mActivityImpl.setActionBarDescription(paramInt);
      return;
    }
    mSetIndicatorInfo = IMPL.setActionBarDescription(mSetIndicatorInfo, mActivity, paramInt);
  }
  
  void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
  {
    if (mActivityImpl != null)
    {
      mActivityImpl.setActionBarUpIndicator(paramDrawable, paramInt);
      return;
    }
    mSetIndicatorInfo = IMPL.setActionBarUpIndicator(mSetIndicatorInfo, mActivity, paramDrawable, paramInt);
  }
  
  public void setDrawerIndicatorEnabled(boolean paramBoolean)
  {
    int i;
    if (paramBoolean != mDrawerIndicatorEnabled)
    {
      if (!paramBoolean) {
        break label54;
      }
      SlideDrawable localSlideDrawable = mSlider;
      if (!mDrawerLayout.isDrawerOpen(8388611)) {
        break label46;
      }
      i = mCloseDrawerContentDescRes;
      setActionBarUpIndicator(localSlideDrawable, i);
    }
    for (;;)
    {
      mDrawerIndicatorEnabled = paramBoolean;
      return;
      label46:
      i = mOpenDrawerContentDescRes;
      break;
      label54:
      setActionBarUpIndicator(mThemeImage, 0);
    }
  }
  
  public void syncState()
  {
    SlideDrawable localSlideDrawable;
    if (mDrawerLayout.isDrawerOpen(8388611))
    {
      mSlider.setPosition(1.0F);
      if (mDrawerIndicatorEnabled)
      {
        localSlideDrawable = mSlider;
        if (!mDrawerLayout.isDrawerOpen(8388611)) {
          break label67;
        }
      }
    }
    label67:
    for (int i = mCloseDrawerContentDescRes;; i = mOpenDrawerContentDescRes)
    {
      setActionBarUpIndicator(localSlideDrawable, i);
      return;
      mSlider.setPosition(0.0F);
      break;
    }
  }
  
  private static abstract interface ActionBarDrawerToggleImpl
  {
    public abstract Drawable getThemeUpIndicator(Activity paramActivity);
    
    public abstract Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt);
    
    public abstract Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt);
  }
  
  private static class ActionBarDrawerToggleImplBase
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    private ActionBarDrawerToggleImplBase() {}
    
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return null;
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return paramObject;
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return paramObject;
    }
  }
  
  private static class ActionBarDrawerToggleImplHC
    implements ActionBarDrawerToggle.ActionBarDrawerToggleImpl
  {
    private ActionBarDrawerToggleImplHC() {}
    
    public Drawable getThemeUpIndicator(Activity paramActivity)
    {
      return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(paramActivity);
    }
    
    public Object setActionBarDescription(Object paramObject, Activity paramActivity, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarDescription(paramObject, paramActivity, paramInt);
    }
    
    public Object setActionBarUpIndicator(Object paramObject, Activity paramActivity, Drawable paramDrawable, int paramInt)
    {
      return ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(paramObject, paramActivity, paramDrawable, paramInt);
    }
  }
  
  public static abstract interface Delegate
  {
    public abstract Drawable getThemeUpIndicator();
    
    public abstract void setActionBarDescription(int paramInt);
    
    public abstract void setActionBarUpIndicator(Drawable paramDrawable, int paramInt);
  }
  
  public static abstract interface DelegateProvider
  {
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  }
  
  private class SlideDrawable
    extends InsetDrawable
    implements Drawable.Callback
  {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    
    private SlideDrawable(Drawable paramDrawable)
    {
      super(0);
      int i = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i > 18) {
        bool = true;
      }
      mHasMirroring = bool;
      mTmpRect = new Rect();
    }
    
    public void draw(Canvas paramCanvas)
    {
      int i = 1;
      copyBounds(mTmpRect);
      paramCanvas.save();
      if (ViewCompat.getLayoutDirection(mActivity.getWindow().getDecorView()) == i) {}
      for (int j = i;; j = 0)
      {
        if (j != 0) {
          i = -1;
        }
        int k = mTmpRect.width();
        paramCanvas.translate(-mOffset * k * mPosition * i, 0.0F);
        if ((j != 0) && (!mHasMirroring))
        {
          paramCanvas.translate(k, 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        super.draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
    }
    
    public float getPosition()
    {
      return mPosition;
    }
    
    public void setOffset(float paramFloat)
    {
      mOffset = paramFloat;
      invalidateSelf();
    }
    
    public void setPosition(float paramFloat)
    {
      mPosition = paramFloat;
      invalidateSelf();
    }
  }
}
