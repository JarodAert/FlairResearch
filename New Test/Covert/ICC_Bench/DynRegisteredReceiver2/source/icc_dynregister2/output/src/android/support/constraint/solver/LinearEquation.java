package android.support.constraint.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class LinearEquation
{
  private static int artificialIndex = 0;
  private static int errorIndex = 0;
  private static int slackIndex = 0;
  private ArrayList<EquationVariable> mCurrentSide = null;
  private ArrayList<EquationVariable> mLeftSide = new ArrayList();
  private ArrayList<EquationVariable> mRightSide = new ArrayList();
  private LinearSystem mSystem = null;
  private Type mType = Type.EQUALS;
  
  public LinearEquation()
  {
    mCurrentSide = mLeftSide;
  }
  
  public LinearEquation(LinearEquation paramLinearEquation)
  {
    ArrayList localArrayList1 = mLeftSide;
    int i = 0;
    int j = localArrayList1.size();
    while (i < j)
    {
      EquationVariable localEquationVariable1 = new EquationVariable((EquationVariable)localArrayList1.get(i));
      mLeftSide.add(localEquationVariable1);
      i++;
    }
    ArrayList localArrayList2 = mRightSide;
    int k = 0;
    int m = localArrayList2.size();
    while (k < m)
    {
      EquationVariable localEquationVariable2 = new EquationVariable((EquationVariable)localArrayList2.get(k));
      mRightSide.add(localEquationVariable2);
      k++;
    }
    mCurrentSide = mRightSide;
  }
  
  public LinearEquation(LinearSystem paramLinearSystem)
  {
    mCurrentSide = mLeftSide;
    mSystem = paramLinearSystem;
  }
  
  private EquationVariable find(SolverVariable paramSolverVariable, ArrayList<EquationVariable> paramArrayList)
  {
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      EquationVariable localEquationVariable = (EquationVariable)paramArrayList.get(i);
      if (localEquationVariable.getSolverVariable() == paramSolverVariable) {
        return localEquationVariable;
      }
      i++;
    }
    return null;
  }
  
  static String getNextArtificialVariableName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("a");
    int i = 1 + artificialIndex;
    artificialIndex = i;
    return i;
  }
  
  static String getNextErrorVariableName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("e");
    int i = 1 + errorIndex;
    errorIndex = i;
    return i;
  }
  
  static String getNextSlackVariableName()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("s");
    int i = 1 + slackIndex;
    slackIndex = i;
    return i;
  }
  
  private void removeNullTerms(ArrayList<EquationVariable> paramArrayList)
  {
    int i = 0;
    int j = paramArrayList.size();
    ArrayList localArrayList;
    for (;;)
    {
      int k = 0;
      if (i < j)
      {
        if (((EquationVariable)paramArrayList.get(i)).getAmount().isNull()) {
          k = 1;
        }
      }
      else
      {
        if (k == 0) {
          return;
        }
        localArrayList = new ArrayList();
        int m = 0;
        int n = paramArrayList.size();
        while (m < n)
        {
          EquationVariable localEquationVariable = (EquationVariable)paramArrayList.get(m);
          if (!localEquationVariable.getAmount().isNull()) {
            localArrayList.add(localEquationVariable);
          }
          m++;
        }
      }
      i++;
    }
    paramArrayList.clear();
    paramArrayList.addAll(localArrayList);
  }
  
  private void replace(SolverVariable paramSolverVariable, LinearEquation paramLinearEquation, ArrayList<EquationVariable> paramArrayList)
  {
    EquationVariable localEquationVariable = find(paramSolverVariable, paramArrayList);
    if (localEquationVariable != null)
    {
      paramArrayList.remove(localEquationVariable);
      Amount localAmount = localEquationVariable.getAmount();
      ArrayList localArrayList = mRightSide;
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        paramArrayList.add(new EquationVariable(localAmount, (EquationVariable)localArrayList.get(i)));
        i++;
      }
    }
  }
  
  public static void resetNaming()
  {
    artificialIndex = 0;
    slackIndex = 0;
    errorIndex = 0;
  }
  
  private String sideToString(ArrayList<EquationVariable> paramArrayList)
  {
    String str = "";
    int i = 1;
    int j = 0;
    int k = paramArrayList.size();
    if (j < k)
    {
      EquationVariable localEquationVariable = (EquationVariable)paramArrayList.get(j);
      if (i != 0) {
        if (localEquationVariable.getAmount().isPositive())
        {
          str = str + localEquationVariable + " ";
          label72:
          i = 0;
        }
      }
      for (;;)
      {
        j++;
        break;
        str = str + localEquationVariable.signString() + " " + localEquationVariable + " ";
        break label72;
        str = str + localEquationVariable.signString() + " " + localEquationVariable + " ";
      }
    }
    if (paramArrayList.size() == 0) {
      str = "0";
    }
    return str;
  }
  
  private void simplifySide(ArrayList<EquationVariable> paramArrayList)
  {
    Object localObject = null;
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramArrayList.size();
    if (i < j)
    {
      EquationVariable localEquationVariable = (EquationVariable)paramArrayList.get(i);
      if (localEquationVariable.isConstant()) {
        if (localObject == null) {
          localObject = localEquationVariable;
        }
      }
      for (;;)
      {
        i++;
        break;
        localObject.add(localEquationVariable);
        continue;
        if (localHashMap.containsKey(localEquationVariable.getName()))
        {
          ((EquationVariable)localHashMap.get(localEquationVariable.getName())).add(localEquationVariable);
        }
        else
        {
          localHashMap.put(localEquationVariable.getName(), localEquationVariable);
          localArrayList.add(localEquationVariable.getName());
        }
      }
    }
    paramArrayList.clear();
    if (localObject != null) {
      paramArrayList.add(localObject);
    }
    Collections.sort(localArrayList);
    int k = 0;
    int m = localArrayList.size();
    while (k < m)
    {
      paramArrayList.add((EquationVariable)localHashMap.get((String)localArrayList.get(k)));
      k++;
    }
    removeNullTerms(paramArrayList);
  }
  
  public EquationVariable addArtificialVar()
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, 1, getNextArtificialVariableName(), SolverVariable.Type.ERROR);
    mCurrentSide.add(localEquationVariable);
    return localEquationVariable;
  }
  
  public void balance()
  {
    if ((mLeftSide.size() == 0) && (mRightSide.size() == 0)) {
      return;
    }
    mCurrentSide = mLeftSide;
    int i = 0;
    int j = mLeftSide.size();
    while (i < j)
    {
      EquationVariable localEquationVariable4 = (EquationVariable)mLeftSide.get(i);
      mRightSide.add(localEquationVariable4.inverse());
      i++;
    }
    mLeftSide.clear();
    simplifySide(mRightSide);
    int k = 0;
    int m = mRightSide.size();
    label102:
    Object localObject = null;
    int i4;
    label156:
    int i2;
    int i3;
    if (k < m)
    {
      EquationVariable localEquationVariable3 = (EquationVariable)mRightSide.get(k);
      if (localEquationVariable3.getType() == SolverVariable.Type.UNRESTRICTED) {
        localObject = localEquationVariable3;
      }
    }
    else
    {
      if (localObject == null)
      {
        i4 = 0;
        int i5 = mRightSide.size();
        if (i4 < i5)
        {
          EquationVariable localEquationVariable2 = (EquationVariable)mRightSide.get(i4);
          if (localEquationVariable2.getType() != SolverVariable.Type.SLACK) {
            break label336;
          }
          localObject = localEquationVariable2;
        }
      }
      if (localObject == null)
      {
        i2 = 0;
        i3 = mRightSide.size();
      }
    }
    for (;;)
    {
      if (i2 < i3)
      {
        EquationVariable localEquationVariable1 = (EquationVariable)mRightSide.get(i2);
        if (localEquationVariable1.getType() == SolverVariable.Type.ERROR) {
          localObject = localEquationVariable1;
        }
      }
      else
      {
        if (localObject == null) {
          break;
        }
        mRightSide.remove(localObject);
        localObject.inverse();
        if (localObject.getAmount().isOne()) {
          break label361;
        }
        Amount localAmount = localObject.getAmount();
        int n = 0;
        int i1 = mRightSide.size();
        while (n < i1)
        {
          ((EquationVariable)mRightSide.get(n)).getAmount().divide(localAmount);
          n++;
        }
        k++;
        break label102;
        label336:
        i4++;
        break label156;
      }
      i2++;
    }
    localObject.setAmount(new Amount(1));
    label361:
    simplifySide(mRightSide);
    mLeftSide.add(localObject);
  }
  
  public void clearLeftSide()
  {
    mLeftSide.clear();
  }
  
  public boolean contains(SolverVariable paramSolverVariable)
  {
    if (find(paramSolverVariable, mLeftSide) != null) {}
    while (find(paramSolverVariable, mRightSide) != null) {
      return true;
    }
    return false;
  }
  
  public LinearEquation equalsTo()
  {
    mCurrentSide = mRightSide;
    return this;
  }
  
  public Amount getConstant()
  {
    int i = 0;
    int j = mRightSide.size();
    while (i < j)
    {
      EquationVariable localEquationVariable = (EquationVariable)mRightSide.get(i);
      if (localEquationVariable.isConstant()) {
        return localEquationVariable.getAmount();
      }
      i++;
    }
    return null;
  }
  
  public EquationVariable getFirstUnconstrainedVariable()
  {
    int i = 0;
    int j = mLeftSide.size();
    EquationVariable localEquationVariable;
    while (i < j)
    {
      localEquationVariable = (EquationVariable)mLeftSide.get(i);
      if (localEquationVariable.getType() == SolverVariable.Type.UNRESTRICTED) {
        return localEquationVariable;
      }
      i++;
    }
    int k = 0;
    int m = mRightSide.size();
    for (;;)
    {
      if (k >= m) {
        break label95;
      }
      localEquationVariable = (EquationVariable)mRightSide.get(k);
      if (localEquationVariable.getType() == SolverVariable.Type.UNRESTRICTED) {
        break;
      }
      k++;
    }
    label95:
    return null;
  }
  
  public EquationVariable getLeftVariable()
  {
    if (mLeftSide.size() == 1) {
      return (EquationVariable)mLeftSide.get(0);
    }
    return null;
  }
  
  public ArrayList<EquationVariable> getRightSide()
  {
    return mRightSide;
  }
  
  public EquationVariable getVariable(SolverVariable paramSolverVariable)
  {
    EquationVariable localEquationVariable = find(paramSolverVariable, mRightSide);
    if (localEquationVariable != null) {
      return localEquationVariable;
    }
    return find(paramSolverVariable, mLeftSide);
  }
  
  public LinearEquation greaterThan()
  {
    mCurrentSide = mRightSide;
    mType = Type.GREATER_THAN;
    return this;
  }
  
  public boolean hasNegativeConstant()
  {
    int i = 0;
    int j = mRightSide.size();
    while (i < j)
    {
      EquationVariable localEquationVariable = (EquationVariable)mRightSide.get(i);
      if ((localEquationVariable.isConstant()) && (localEquationVariable.getAmount().isNegative())) {
        return true;
      }
      i++;
    }
    return false;
  }
  
  public void i()
  {
    if (mSystem == null) {
      return;
    }
    mSystem.addConstraint(this);
  }
  
  public void inverse()
  {
    Amount localAmount = new Amount(-1);
    int i = 0;
    int j = mLeftSide.size();
    while (i < j)
    {
      ((EquationVariable)mLeftSide.get(i)).multiply(localAmount);
      i++;
    }
    int k = 0;
    int m = mRightSide.size();
    while (k < m)
    {
      ((EquationVariable)mRightSide.get(k)).multiply(localAmount);
      k++;
    }
  }
  
  public boolean isNull()
  {
    if ((mLeftSide.size() == 0) && (mRightSide.size() == 0)) {}
    EquationVariable localEquationVariable1;
    EquationVariable localEquationVariable2;
    do
    {
      return true;
      if ((mLeftSide.size() != 1) || (mRightSide.size() != 1)) {
        break;
      }
      localEquationVariable1 = (EquationVariable)mLeftSide.get(0);
      localEquationVariable2 = (EquationVariable)mRightSide.get(0);
    } while ((localEquationVariable1.isConstant()) && (localEquationVariable2.isConstant()) && (localEquationVariable1.getAmount().isNull()) && (localEquationVariable2.getAmount().isNull()));
    return false;
  }
  
  public LinearEquation lowerThan()
  {
    mCurrentSide = mRightSide;
    mType = Type.LOWER_THAN;
    return this;
  }
  
  public LinearEquation minus(int paramInt)
  {
    var(paramInt * -1);
    return this;
  }
  
  public LinearEquation minus(int paramInt1, int paramInt2)
  {
    var(paramInt1 * -1, paramInt2);
    return this;
  }
  
  public LinearEquation minus(int paramInt, String paramString)
  {
    var(paramInt * -1, paramString);
    return this;
  }
  
  public LinearEquation minus(String paramString)
  {
    var(-1, paramString);
    return this;
  }
  
  public void moveAllToTheRight()
  {
    int i = 0;
    int j = mLeftSide.size();
    while (i < j)
    {
      EquationVariable localEquationVariable = (EquationVariable)mLeftSide.get(i);
      mRightSide.add(localEquationVariable.inverse());
      i++;
    }
    mLeftSide.clear();
  }
  
  public void normalize()
  {
    if (mType == Type.EQUALS) {
      return;
    }
    mCurrentSide = mLeftSide;
    if (mType == Type.LOWER_THAN) {
      withSlack(1);
    }
    for (;;)
    {
      mType = Type.EQUALS;
      mCurrentSide = mRightSide;
      return;
      if (mType == Type.GREATER_THAN) {
        withSlack(-1);
      }
    }
  }
  
  public void pivot(SolverVariable paramSolverVariable)
  {
    if ((mLeftSide.size() == 1) && (((EquationVariable)mLeftSide.get(0)).getSolverVariable() == paramSolverVariable)) {
      return;
    }
    int i = 0;
    int j = mLeftSide.size();
    while (i < j)
    {
      EquationVariable localEquationVariable2 = (EquationVariable)mLeftSide.get(i);
      mRightSide.add(localEquationVariable2.inverse());
      i++;
    }
    mLeftSide.clear();
    simplifySide(mRightSide);
    int k = 0;
    int m = mRightSide.size();
    Object localObject;
    for (;;)
    {
      localObject = null;
      if (k < m)
      {
        EquationVariable localEquationVariable1 = (EquationVariable)mRightSide.get(k);
        if (localEquationVariable1.getSolverVariable() == paramSolverVariable) {
          localObject = localEquationVariable1;
        }
      }
      else
      {
        if (localObject == null) {
          break;
        }
        mRightSide.remove(localObject);
        localObject.inverse();
        if (localObject.getAmount().isOne()) {
          break label245;
        }
        Amount localAmount = localObject.getAmount();
        int n = 0;
        int i1 = mRightSide.size();
        while (n < i1)
        {
          ((EquationVariable)mRightSide.get(n)).getAmount().divide(localAmount);
          n++;
        }
      }
      k++;
    }
    localObject.setAmount(new Amount(1));
    label245:
    mLeftSide.add(localObject);
  }
  
  public LinearEquation plus(int paramInt)
  {
    var(paramInt);
    return this;
  }
  
  public LinearEquation plus(int paramInt1, int paramInt2)
  {
    var(paramInt1, paramInt2);
    return this;
  }
  
  public LinearEquation plus(int paramInt, String paramString)
  {
    var(paramInt, paramString);
    return this;
  }
  
  public LinearEquation plus(String paramString)
  {
    var(paramString);
    return this;
  }
  
  public void remove(SolverVariable paramSolverVariable)
  {
    EquationVariable localEquationVariable1 = find(paramSolverVariable, mLeftSide);
    if (localEquationVariable1 != null) {
      mLeftSide.remove(localEquationVariable1);
    }
    EquationVariable localEquationVariable2 = find(paramSolverVariable, mRightSide);
    if (localEquationVariable2 != null) {
      mRightSide.remove(localEquationVariable2);
    }
  }
  
  public void replace(SolverVariable paramSolverVariable, LinearEquation paramLinearEquation)
  {
    replace(paramSolverVariable, paramLinearEquation, mLeftSide);
    replace(paramSolverVariable, paramLinearEquation, mRightSide);
  }
  
  public void setLeftSide()
  {
    mCurrentSide = mLeftSide;
  }
  
  public void setSystem(LinearSystem paramLinearSystem)
  {
    mSystem = paramLinearSystem;
  }
  
  public void simplify()
  {
    simplifySide(mLeftSide);
    simplifySide(mRightSide);
  }
  
  public String toString()
  {
    String str = sideToString(mLeftSide);
    switch (1.$SwitchMap$android$support$constraint$solver$LinearEquation$Type[mType.ordinal()])
    {
    }
    for (;;)
    {
      return (str + sideToString(mRightSide)).trim();
      str = str + "= ";
      continue;
      str = str + "<= ";
      continue;
      str = str + ">= ";
    }
  }
  
  public LinearEquation var(int paramInt)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramInt);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation var(int paramInt1, int paramInt2)
  {
    EquationVariable localEquationVariable = new EquationVariable(new Amount(paramInt1, paramInt2));
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation var(int paramInt1, int paramInt2, String paramString)
  {
    Amount localAmount = new Amount(paramInt1, paramInt2);
    EquationVariable localEquationVariable = new EquationVariable(mSystem, localAmount, paramString, SolverVariable.Type.UNRESTRICTED);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation var(int paramInt, String paramString)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramInt, paramString, SolverVariable.Type.UNRESTRICTED);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation var(String paramString)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramString, SolverVariable.Type.UNRESTRICTED);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation withError()
  {
    String str = getNextErrorVariableName();
    withError(str + "+", 1);
    withError(str + "-", -1);
    return this;
  }
  
  public LinearEquation withError(int paramInt)
  {
    withError(getNextErrorVariableName(), paramInt);
    return this;
  }
  
  public LinearEquation withError(Amount paramAmount, String paramString)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramAmount, paramString, SolverVariable.Type.ERROR);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation withError(String paramString, int paramInt)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramInt, paramString, SolverVariable.Type.ERROR);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation withPositiveError()
  {
    String str = getNextErrorVariableName();
    withError(str + "+", 1);
    return this;
  }
  
  public LinearEquation withSlack()
  {
    withSlack(getNextSlackVariableName(), 1);
    return this;
  }
  
  public LinearEquation withSlack(int paramInt)
  {
    withSlack(getNextSlackVariableName(), paramInt);
    return this;
  }
  
  public LinearEquation withSlack(Amount paramAmount, String paramString)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramAmount, paramString, SolverVariable.Type.SLACK);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation withSlack(String paramString, int paramInt)
  {
    EquationVariable localEquationVariable = new EquationVariable(mSystem, paramInt, paramString, SolverVariable.Type.SLACK);
    mCurrentSide.add(localEquationVariable);
    return this;
  }
  
  public LinearEquation withStrongError()
  {
    String str = getNextErrorVariableName();
    EquationVariable localEquationVariable1 = new EquationVariable(mSystem, 1, str + "+", SolverVariable.Type.ERROR);
    localEquationVariable1.getSolverVariable().setStrength(SolverVariable.Strength.STRONG);
    mCurrentSide.add(localEquationVariable1);
    EquationVariable localEquationVariable2 = new EquationVariable(mSystem, -1, str + "-", SolverVariable.Type.ERROR);
    localEquationVariable2.getSolverVariable().setStrength(SolverVariable.Strength.STRONG);
    mCurrentSide.add(localEquationVariable2);
    return this;
  }
  
  private static enum Type
  {
    static
    {
      GREATER_THAN = new Type("GREATER_THAN", 2);
      Type[] arrayOfType = new Type[3];
      arrayOfType[0] = EQUALS;
      arrayOfType[1] = LOWER_THAN;
      arrayOfType[2] = GREATER_THAN;
      $VALUES = arrayOfType;
    }
    
    private Type() {}
  }
}
