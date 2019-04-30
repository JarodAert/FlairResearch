package android.support.constraint.solver.widgets;

public class Animator
{
  private static final boolean DEBUG = false;
  private static final boolean USE_EASE_IN_OUT = true;
  private static boolean sAllowsAnimation = false;
  private Frame animCurrent = new Frame();
  private long animDuration = 350L;
  private Frame animStart = new Frame();
  private long animStartTime = 0L;
  private Frame animTarget = new Frame();
  private boolean mAnimating = false;
  private final ConstraintWidget mWidget;
  
  public Animator(ConstraintWidget paramConstraintWidget)
  {
    mWidget = paramConstraintWidget;
  }
  
  public static double EaseInOutinterpolator(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d1 = (paramDouble3 - paramDouble2) / 2.0D;
    double d2 = paramDouble1 * 2.0D;
    if (d2 < 1.0D) {
      return paramDouble2 + d2 * (d1 * d2);
    }
    double d3 = d2 - 1.0D;
    return paramDouble2 + -d1 * (d3 * (d3 - 2.0D) - 1.0D);
  }
  
  public static boolean doAnimation()
  {
    return sAllowsAnimation;
  }
  
  private static int interpolator(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (int)EaseInOutinterpolator(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static boolean isAnimationEnabled()
  {
    return sAllowsAnimation;
  }
  
  private static float linearInterpolator(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat3 * paramFloat1 + paramFloat2 * (1.0F - paramFloat1);
  }
  
  public static void setAnimationEnabled(boolean paramBoolean)
  {
    sAllowsAnimation = paramBoolean;
  }
  
  public void animate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    animCurrent.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!isAnimating()) && ((paramInt1 != mWidget.getInternalDrawX()) || (paramInt2 != mWidget.getInternalDrawY()) || (paramInt3 != mWidget.getInternalDrawRight()) || (paramInt4 != mWidget.getInternalDrawBottom())))
    {
      animStart.set(mWidget.getInternalDrawX(), mWidget.getInternalDrawY(), mWidget.getInternalDrawRight(), mWidget.getInternalDrawBottom());
      start();
    }
    if (isAnimating())
    {
      animTarget.set(paramInt1, paramInt2, paramInt3, paramInt4);
      step();
    }
  }
  
  public int getCurrentBottom()
  {
    return animCurrent.bottom;
  }
  
  public int getCurrentLeft()
  {
    return animCurrent.left;
  }
  
  public int getCurrentRight()
  {
    return animCurrent.right;
  }
  
  public int getCurrentTop()
  {
    return animCurrent.top;
  }
  
  public boolean isAnimating()
  {
    return mAnimating;
  }
  
  public void start()
  {
    animStartTime = System.currentTimeMillis();
    mAnimating = true;
  }
  
  public void step()
  {
    long l = System.currentTimeMillis();
    if ((l <= animStartTime + animDuration) && (l >= animStartTime))
    {
      float f = (float)(l - animStartTime) / (float)animDuration;
      animCurrent.left = interpolator(f, animStart.left, animTarget.left);
      animCurrent.right = interpolator(f, animStart.right, animTarget.right);
      animCurrent.top = interpolator(f, animStart.top, animTarget.top);
      animCurrent.bottom = interpolator(f, animStart.bottom, animTarget.bottom);
      return;
    }
    animCurrent.left = animTarget.left;
    animCurrent.top = animTarget.top;
    animCurrent.right = animTarget.right;
    animCurrent.bottom = animTarget.bottom;
    mAnimating = false;
  }
  
  static class Frame
  {
    int bottom;
    int left;
    int right;
    int top;
    
    Frame() {}
    
    public int getBottom()
    {
      return bottom;
    }
    
    public int getLeft()
    {
      return left;
    }
    
    public int getRight()
    {
      return right;
    }
    
    public int getTop()
    {
      return top;
    }
    
    void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      left = paramInt1;
      top = paramInt2;
      right = paramInt3;
      bottom = paramInt4;
    }
  }
}
