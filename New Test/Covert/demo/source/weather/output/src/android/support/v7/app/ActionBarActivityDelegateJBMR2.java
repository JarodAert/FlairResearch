package android.support.v7.app;

class ActionBarActivityDelegateJBMR2
  extends ActionBarActivityDelegateJB
{
  ActionBarActivityDelegateJBMR2(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplJBMR2(mActivity, mActivity);
  }
}
