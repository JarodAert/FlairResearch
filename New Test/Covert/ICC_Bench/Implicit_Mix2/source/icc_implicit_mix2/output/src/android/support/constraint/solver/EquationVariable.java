package android.support.constraint.solver;

class EquationVariable
{
  private Amount mAmount = null;
  private SolverVariable mVariable = null;
  
  public EquationVariable(Amount paramAmount)
  {
    mAmount = paramAmount;
  }
  
  public EquationVariable(Amount paramAmount, EquationVariable paramEquationVariable)
  {
    mAmount = new Amount(paramAmount);
    mAmount.multiply(mAmount);
    mVariable = paramEquationVariable.getSolverVariable();
  }
  
  public EquationVariable(EquationVariable paramEquationVariable)
  {
    mAmount = new Amount(mAmount);
    mVariable = paramEquationVariable.getSolverVariable();
  }
  
  public EquationVariable(LinearSystem paramLinearSystem, int paramInt)
  {
    mAmount = new Amount(paramInt);
  }
  
  public EquationVariable(LinearSystem paramLinearSystem, int paramInt, String paramString, SolverVariable.Type paramType)
  {
    mAmount = new Amount(paramInt);
    mVariable = paramLinearSystem.getVariable(paramString, paramType);
  }
  
  public EquationVariable(LinearSystem paramLinearSystem, Amount paramAmount, String paramString, SolverVariable.Type paramType)
  {
    mAmount = paramAmount;
    mVariable = paramLinearSystem.getVariable(paramString, paramType);
  }
  
  public EquationVariable(LinearSystem paramLinearSystem, String paramString, SolverVariable.Type paramType)
  {
    mAmount = new Amount(1);
    mVariable = paramLinearSystem.getVariable(paramString, paramType);
  }
  
  public void add(EquationVariable paramEquationVariable)
  {
    if (paramEquationVariable.isCompatible(this)) {
      mAmount.add(mAmount);
    }
  }
  
  public void divide(EquationVariable paramEquationVariable)
  {
    mAmount.divide(mAmount);
  }
  
  public Amount getAmount()
  {
    return mAmount;
  }
  
  public String getName()
  {
    if (mVariable == null) {
      return null;
    }
    return mVariable.getName();
  }
  
  public SolverVariable getSolverVariable()
  {
    return mVariable;
  }
  
  public SolverVariable.Type getType()
  {
    if (mVariable == null) {
      return SolverVariable.Type.CONSTANT;
    }
    return mVariable.mType;
  }
  
  public EquationVariable inverse()
  {
    mAmount.inverse();
    return this;
  }
  
  public boolean isCompatible(EquationVariable paramEquationVariable)
  {
    boolean bool2;
    if (isConstant()) {
      bool2 = paramEquationVariable.isConstant();
    }
    SolverVariable localSolverVariable1;
    SolverVariable localSolverVariable2;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramEquationVariable.isConstant();
        bool2 = false;
      } while (bool1);
      localSolverVariable1 = paramEquationVariable.getSolverVariable();
      localSolverVariable2 = getSolverVariable();
      bool2 = false;
    } while (localSolverVariable1 != localSolverVariable2);
    return true;
  }
  
  public boolean isConstant()
  {
    return mVariable == null;
  }
  
  public void multiply(Amount paramAmount)
  {
    mAmount.multiply(paramAmount);
  }
  
  public void multiply(EquationVariable paramEquationVariable)
  {
    multiply(paramEquationVariable.getAmount());
  }
  
  public void setAmount(Amount paramAmount)
  {
    mAmount = paramAmount;
  }
  
  public String signString()
  {
    if (mAmount.isPositive()) {
      return "+";
    }
    return "-";
  }
  
  public void substract(EquationVariable paramEquationVariable)
  {
    if (paramEquationVariable.isCompatible(this)) {
      mAmount.substract(mAmount);
    }
  }
  
  public String toString()
  {
    if (isConstant()) {
      return "" + mAmount;
    }
    if ((mAmount.isOne()) || (mAmount.isMinusOne())) {
      return "" + mVariable;
    }
    return "" + mAmount + " " + mVariable;
  }
}
