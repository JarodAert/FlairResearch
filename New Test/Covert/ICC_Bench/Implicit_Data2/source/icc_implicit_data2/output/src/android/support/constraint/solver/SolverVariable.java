package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable
{
  private static final boolean INTERNAL_DEBUG;
  public static final boolean USE_LIST;
  static int uniqueId = 1;
  public float computedValue;
  public int definitionId = -1;
  public int id = -1;
  private final Cache mCache;
  ArrayRow[] mClientEquations = new ArrayRow[8];
  int mClientEquationsCount = 0;
  private String mName;
  Strength mStrength = Strength.WEAK;
  Type mType;
  public int strength = 0;
  
  public SolverVariable(Cache paramCache, Type paramType)
  {
    mCache = paramCache;
    mType = paramType;
  }
  
  public SolverVariable(Cache paramCache, String paramString, Type paramType)
  {
    mCache = paramCache;
    mName = paramString;
    mType = paramType;
  }
  
  public static String getUniqueName()
  {
    uniqueId = 1 + uniqueId;
    return "V" + uniqueId;
  }
  
  public static String getUniqueName(Type paramType, Strength paramStrength)
  {
    uniqueId = 1 + uniqueId;
    switch (1.$SwitchMap$android$support$constraint$solver$SolverVariable$Type[paramType.ordinal()])
    {
    default: 
      return "V" + uniqueId;
    case 1: 
      return "U" + uniqueId;
    case 2: 
      return "C" + uniqueId;
    case 3: 
      return "S" + uniqueId;
    }
    if (paramStrength == Strength.STRONG) {
      return "E" + uniqueId;
    }
    return "e" + uniqueId;
  }
  
  public void addClientEquation(ArrayRow paramArrayRow)
  {
    for (int i = 0; i < mClientEquationsCount; i++) {
      if (mClientEquations[i] == paramArrayRow) {
        return;
      }
    }
    if (mClientEquationsCount >= mClientEquations.length) {
      mClientEquations = ((ArrayRow[])Arrays.copyOf(mClientEquations, 2 * mClientEquations.length));
    }
    mClientEquations[mClientEquationsCount] = paramArrayRow;
    mClientEquationsCount = (1 + mClientEquationsCount);
  }
  
  public String getName()
  {
    return mName;
  }
  
  public void removeClientEquation(ArrayRow paramArrayRow)
  {
    for (int i = 0;; i++) {
      if (i < mClientEquationsCount)
      {
        if (mClientEquations[i] == paramArrayRow)
        {
          for (int j = 0; j < -1 + (mClientEquationsCount - i); j++) {
            mClientEquations[(i + j)] = mClientEquations[(1 + (i + j))];
          }
          mClientEquationsCount = (-1 + mClientEquationsCount);
        }
      }
      else {
        return;
      }
    }
  }
  
  public void reset()
  {
    mName = null;
    mType = Type.UNKNOWN;
    mStrength = Strength.STRONG;
    strength = 0;
    id = -1;
    definitionId = -1;
    computedValue = 0.0F;
    mClientEquationsCount = 0;
  }
  
  public void setName(String paramString)
  {
    mName = paramString;
  }
  
  public void setStrength(Strength paramStrength)
  {
    mStrength = paramStrength;
  }
  
  public void setType(Type paramType)
  {
    mType = paramType;
  }
  
  public String toString()
  {
    return "" + mName;
  }
  
  final class Link
  {
    Link next;
    ArrayRow row;
    
    Link() {}
  }
  
  public static enum Strength
  {
    static
    {
      UNKNOWN = new Strength("UNKNOWN", 2);
      Strength[] arrayOfStrength = new Strength[3];
      arrayOfStrength[0] = STRONG;
      arrayOfStrength[1] = WEAK;
      arrayOfStrength[2] = UNKNOWN;
      $VALUES = arrayOfStrength;
    }
    
    private Strength() {}
  }
  
  public static enum Type
  {
    static
    {
      CONSTANT = new Type("CONSTANT", 1);
      SLACK = new Type("SLACK", 2);
      ERROR = new Type("ERROR", 3);
      UNKNOWN = new Type("UNKNOWN", 4);
      Type[] arrayOfType = new Type[5];
      arrayOfType[0] = UNRESTRICTED;
      arrayOfType[1] = CONSTANT;
      arrayOfType[2] = SLACK;
      arrayOfType[3] = ERROR;
      arrayOfType[4] = UNKNOWN;
      $VALUES = arrayOfType;
    }
    
    private Type() {}
  }
}
