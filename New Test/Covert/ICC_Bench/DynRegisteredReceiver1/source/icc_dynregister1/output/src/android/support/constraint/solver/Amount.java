package android.support.constraint.solver;

class Amount
{
  private int mDenominator = 1;
  private int mNumerator = 0;
  
  public Amount(int paramInt)
  {
    mNumerator = paramInt;
    mDenominator = 1;
  }
  
  public Amount(int paramInt1, int paramInt2)
  {
    mNumerator = paramInt1;
    mDenominator = paramInt2;
    simplify();
  }
  
  public Amount(Amount paramAmount)
  {
    mNumerator = mNumerator;
    mDenominator = mDenominator;
    simplify();
  }
  
  private static int gcd(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 *= -1;
    }
    if (paramInt2 < 0) {
      paramInt2 *= -1;
    }
    if (paramInt1 == 0) {
      paramInt1 = paramInt2;
    }
    while (paramInt2 == 0) {
      return paramInt1;
    }
    for (int i = 0; (0x1 & (paramInt1 | paramInt2)) == 0; i++)
    {
      paramInt1 >>= 1;
      paramInt2 >>= 1;
    }
    while ((paramInt1 & 0x1) == 0) {
      paramInt1 >>= 1;
    }
    do
    {
      while ((paramInt2 & 0x1) == 0) {
        paramInt2 >>= 1;
      }
      if (paramInt1 > paramInt2)
      {
        int j = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = j;
      }
      paramInt2 -= paramInt1;
    } while (paramInt2 != 0);
    return paramInt1 << i;
  }
  
  private void simplify()
  {
    if ((mNumerator < 0) && (mDenominator < 0))
    {
      mNumerator = (-1 * mNumerator);
      mDenominator = (-1 * mDenominator);
      if (mDenominator > 1) {
        if ((mDenominator != 2) || (mNumerator % 2 != 0)) {
          break label119;
        }
      }
    }
    label119:
    for (int i = 2;; i = gcd(mNumerator, mDenominator))
    {
      mNumerator /= i;
      mDenominator /= i;
      return;
      if ((mNumerator < 0) || (mDenominator >= 0)) {
        break;
      }
      mNumerator = (-1 * mNumerator);
      mDenominator = (-1 * mDenominator);
      break;
    }
  }
  
  public Amount add(int paramInt)
  {
    mNumerator += paramInt * mDenominator;
    return this;
  }
  
  public Amount add(Amount paramAmount)
  {
    if (mDenominator == mDenominator) {
      mNumerator += mNumerator;
    }
    for (;;)
    {
      simplify();
      return this;
      mNumerator = (mNumerator * mDenominator + mNumerator * mDenominator);
      mDenominator *= mDenominator;
    }
  }
  
  public Amount divide(Amount paramAmount)
  {
    mNumerator *= mDenominator;
    mDenominator *= mNumerator;
    simplify();
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    Amount localAmount;
    do
    {
      return true;
      if (!(paramObject instanceof Amount)) {
        return false;
      }
      localAmount = (Amount)paramObject;
    } while ((mNumerator == mNumerator) && (mDenominator == mDenominator));
    return false;
  }
  
  public int getDenominator()
  {
    return mDenominator;
  }
  
  public int getNumerator()
  {
    return mNumerator;
  }
  
  public Amount inverse()
  {
    mNumerator = (-1 * mNumerator);
    simplify();
    return this;
  }
  
  public Amount inverseFraction()
  {
    int i = mNumerator;
    mNumerator = mDenominator;
    mDenominator = i;
    simplify();
    return this;
  }
  
  public boolean isMinusOne()
  {
    return (mNumerator == -1) && (mDenominator == 1);
  }
  
  public boolean isNegative()
  {
    return mNumerator < 0;
  }
  
  public boolean isNull()
  {
    return mNumerator == 0;
  }
  
  public boolean isOne()
  {
    return (mNumerator == 1) && (mDenominator == 1);
  }
  
  public boolean isPositive()
  {
    return (mNumerator >= 0) && (mDenominator >= 0);
  }
  
  public Amount multiply(Amount paramAmount)
  {
    mNumerator *= mNumerator;
    mDenominator *= mDenominator;
    simplify();
    return this;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    mNumerator = paramInt1;
    mDenominator = paramInt2;
    simplify();
  }
  
  public void setToZero()
  {
    mNumerator = 0;
    mDenominator = 1;
  }
  
  public Amount substract(Amount paramAmount)
  {
    if (mDenominator == mDenominator) {
      mNumerator -= mNumerator;
    }
    for (;;)
    {
      simplify();
      return this;
      mNumerator = (mNumerator * mDenominator - mNumerator * mDenominator);
      mDenominator *= mDenominator;
    }
  }
  
  public float toFloat()
  {
    if (mDenominator >= 1) {
      return mNumerator / mDenominator;
    }
    return 0.0F;
  }
  
  public String toString()
  {
    if (mDenominator == 1)
    {
      if ((mNumerator == 1) || (mNumerator == -1)) {
        return "";
      }
      if (mNumerator < 0) {
        return "" + -1 * mNumerator;
      }
      return "" + mNumerator;
    }
    if (mNumerator < 0) {
      return "" + -1 * mNumerator + "/" + mDenominator;
    }
    return "" + mNumerator + "/" + mDenominator;
  }
  
  public String valueString()
  {
    if (mDenominator == 1) {
      return "" + mNumerator;
    }
    return "" + mNumerator + "/" + mDenominator;
  }
}
