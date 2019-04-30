package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.SolverVariable.Type;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor
{
  private static final boolean ALLOW_BINARY = false;
  public static final int ANY_GROUP = Integer.MAX_VALUE;
  public static final int APPLY_GROUP_RESULTS = -2;
  public static final int AUTO_CONSTRAINT_CREATOR = 2;
  public static final int SCOUT_CREATOR = 1;
  private static final int UNSET_GONE_MARGIN = -1;
  public static final int USER_CREATOR;
  public static final boolean USE_CENTER_ANCHOR;
  private int mConnectionCreator = 0;
  private ConnectionType mConnectionType = ConnectionType.RELAXED;
  int mGoneMargin = -1;
  int mGroup = Integer.MAX_VALUE;
  int mMargin = 0;
  final ConstraintWidget mOwner;
  SolverVariable mSolverVariable;
  private Strength mStrength = Strength.NONE;
  ConstraintAnchor mTarget;
  final Type mType;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, Type paramType)
  {
    mOwner = paramConstraintWidget;
    mType = paramType;
  }
  
  private boolean isConnectionToMe(ConstraintWidget paramConstraintWidget, HashSet<ConstraintWidget> paramHashSet)
  {
    if (paramHashSet.contains(paramConstraintWidget)) {}
    for (;;)
    {
      return false;
      paramHashSet.add(paramConstraintWidget);
      if (paramConstraintWidget == getOwner()) {
        return true;
      }
      ArrayList localArrayList = paramConstraintWidget.getAnchors();
      int i = 0;
      int j = localArrayList.size();
      while (i < j)
      {
        ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(i);
        if ((localConstraintAnchor.isSimilarDimensionConnection(this)) && (localConstraintAnchor.isConnected()) && (isConnectionToMe(localConstraintAnchor.getTarget().getOwner(), paramHashSet))) {
          return true;
        }
        i++;
      }
    }
  }
  
  private String toString(HashSet<ConstraintAnchor> paramHashSet)
  {
    if (paramHashSet.add(this))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(mOwner.getDebugName()).append(":").append(mType.toString());
      if (mTarget != null) {}
      for (String str = " connected to " + mTarget.toString(paramHashSet);; str = "") {
        return str;
      }
    }
    return "<-";
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    return connect(paramConstraintAnchor, paramInt, -1, Strength.STRONG, 0, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, Strength.STRONG, paramInt2, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, Strength paramStrength, int paramInt3, boolean paramBoolean)
  {
    if (paramConstraintAnchor == null)
    {
      mTarget = null;
      mMargin = 0;
      mGoneMargin = -1;
      mStrength = Strength.NONE;
      mConnectionCreator = 2;
      return true;
    }
    if ((!paramBoolean) && (!isValidConnection(paramConstraintAnchor))) {
      return false;
    }
    mTarget = paramConstraintAnchor;
    if (paramInt1 > 0) {}
    for (mMargin = paramInt1;; mMargin = 0)
    {
      mGoneMargin = paramInt2;
      mStrength = paramStrength;
      mConnectionCreator = paramInt3;
      return true;
    }
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, Strength paramStrength, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, paramStrength, paramInt2, false);
  }
  
  public int getConnectionCreator()
  {
    return mConnectionCreator;
  }
  
  public ConnectionType getConnectionType()
  {
    return mConnectionType;
  }
  
  public int getGroup()
  {
    return mGroup;
  }
  
  public int getMargin()
  {
    if (mOwner.getVisibility() == 8) {
      return 0;
    }
    if ((mGoneMargin > -1) && (mTarget != null) && (mTarget.mOwner.getVisibility() == 8)) {
      return mGoneMargin;
    }
    return mMargin;
  }
  
  public final ConstraintAnchor getOpposite()
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    default: 
      return null;
    case 2: 
      return mOwner.mRight;
    case 3: 
      return mOwner.mLeft;
    case 4: 
      return mOwner.mBottom;
    }
    return mOwner.mTop;
  }
  
  public ConstraintWidget getOwner()
  {
    return mOwner;
  }
  
  public int getPriorityLevel()
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    case 6: 
    case 7: 
    default: 
      return 0;
    case 8: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 2;
    case 4: 
      return 2;
    case 5: 
      return 2;
    }
    return 2;
  }
  
  public int getSnapPriorityLevel()
  {
    int i = 1;
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    default: 
      i = 0;
    case 2: 
    case 3: 
    case 7: 
      return i;
    case 6: 
      return 0;
    case 4: 
      return 0;
    case 5: 
      return 0;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  public SolverVariable getSolverVariable()
  {
    return mSolverVariable;
  }
  
  public Strength getStrength()
  {
    return mStrength;
  }
  
  public ConstraintAnchor getTarget()
  {
    return mTarget;
  }
  
  public Type getType()
  {
    return mType;
  }
  
  public boolean isConnected()
  {
    return mTarget != null;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget)
  {
    if (isConnectionToMe(paramConstraintWidget, new HashSet())) {}
    ConstraintWidget localConstraintWidget;
    do
    {
      return false;
      localConstraintWidget = getOwner().getParent();
      if (localConstraintWidget == paramConstraintWidget) {
        return true;
      }
    } while (paramConstraintWidget.getParent() != localConstraintWidget);
    return true;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget, ConstraintAnchor paramConstraintAnchor)
  {
    return isConnectionAllowed(paramConstraintWidget);
  }
  
  public boolean isSideAnchor()
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean isSimilarDimensionConnection(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool1 = true;
    Type localType1 = paramConstraintAnchor.getType();
    boolean bool2;
    if (localType1 == mType) {
      bool2 = bool1;
    }
    label124:
    Type localType2;
    do
    {
      Type localType3;
      do
      {
        return bool2;
        switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
        {
        default: 
          return false;
        case 1: 
          if (localType1 != Type.BASELINE) {}
          for (;;)
          {
            return bool1;
            bool1 = false;
          }
        case 2: 
        case 3: 
        case 6: 
          if ((localType1 == Type.LEFT) || (localType1 == Type.RIGHT)) {
            break label124;
          }
          localType3 = Type.CENTER_X;
          bool2 = false;
        }
      } while (localType1 != localType3);
      return bool1;
      if ((localType1 == Type.TOP) || (localType1 == Type.BOTTOM) || (localType1 == Type.CENTER_Y)) {
        break;
      }
      localType2 = Type.BASELINE;
      bool2 = false;
    } while (localType1 != localType2);
    return bool1;
  }
  
  public boolean isSnapCompatibleWith(ConstraintAnchor paramConstraintAnchor)
  {
    if (mType == Type.CENTER) {
      return false;
    }
    if (mType == paramConstraintAnchor.getType()) {
      return true;
    }
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    default: 
      return false;
    case 2: 
      switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
      {
      case 4: 
      case 5: 
      default: 
        return false;
      case 3: 
        return true;
      }
      return true;
    case 3: 
      switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
      {
      default: 
        return false;
      case 2: 
        return true;
      }
      return true;
    case 6: 
      switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
      {
      default: 
        return false;
      case 2: 
        return true;
      }
      return true;
    case 4: 
      switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
      {
      case 6: 
      default: 
        return false;
      case 5: 
        return true;
      }
      return true;
    case 5: 
      switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
      {
      case 5: 
      case 6: 
      default: 
        return false;
      case 4: 
        return true;
      }
      return true;
    }
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramConstraintAnchor.getType().ordinal()])
    {
    default: 
      return false;
    case 4: 
      return true;
    }
    return true;
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool1 = true;
    if (paramConstraintAnchor == null) {}
    Type localType;
    do
    {
      return false;
      localType = paramConstraintAnchor.getType();
      if (localType != mType) {
        break;
      }
    } while ((mType == Type.CENTER) || ((mType == Type.BASELINE) && ((!paramConstraintAnchor.getOwner().hasBaseline()) || (!getOwner().hasBaseline()))));
    return bool1;
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    default: 
      return false;
    case 1: 
      if ((localType != Type.BASELINE) && (localType != Type.CENTER_X) && (localType != Type.CENTER_Y)) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    case 2: 
    case 3: 
      if ((localType == Type.LEFT) || (localType == Type.RIGHT))
      {
        bool3 = bool1;
        if ((paramConstraintAnchor.getOwner() instanceof Guideline)) {
          if ((!bool3) && (localType != Type.CENTER_X)) {
            break label189;
          }
        }
      }
      label189:
      for (boolean bool3 = bool1;; bool3 = false)
      {
        return bool3;
        bool3 = false;
        break;
      }
    }
    if ((localType == Type.TOP) || (localType == Type.BOTTOM))
    {
      bool2 = bool1;
      if ((paramConstraintAnchor.getOwner() instanceof Guideline)) {
        if ((!bool2) && (localType != Type.CENTER_Y)) {
          break label246;
        }
      }
    }
    label246:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      return bool2;
      bool2 = false;
      break;
    }
  }
  
  public boolean isVerticalAnchor()
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[mType.ordinal()])
    {
    case 4: 
    case 5: 
    default: 
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    mTarget = null;
    mMargin = 0;
    mGoneMargin = -1;
    mStrength = Strength.STRONG;
    mConnectionCreator = 0;
    mConnectionType = ConnectionType.RELAXED;
  }
  
  public void resetSolverVariable(Cache paramCache)
  {
    if (mSolverVariable == null)
    {
      mSolverVariable = new SolverVariable(paramCache, SolverVariable.Type.UNRESTRICTED);
      return;
    }
    mSolverVariable.reset();
  }
  
  public void setConnectionCreator(int paramInt)
  {
    mConnectionCreator = paramInt;
  }
  
  public void setConnectionType(ConnectionType paramConnectionType)
  {
    mConnectionType = paramConnectionType;
  }
  
  public void setGoneMargin(int paramInt)
  {
    if (isConnected()) {
      mGoneMargin = paramInt;
    }
  }
  
  public void setGroup(int paramInt)
  {
    mGroup = paramInt;
  }
  
  public void setMargin(int paramInt)
  {
    if (isConnected()) {
      mMargin = paramInt;
    }
  }
  
  public void setStrength(Strength paramStrength)
  {
    if (isConnected()) {
      mStrength = paramStrength;
    }
  }
  
  public String toString()
  {
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder().append(mOwner.getDebugName()).append(":").append(mType.toString());
    if (mTarget != null) {}
    for (String str = " connected to " + mTarget.toString(localHashSet);; str = "") {
      return str;
    }
  }
  
  public static enum ConnectionType
  {
    static
    {
      ConnectionType[] arrayOfConnectionType = new ConnectionType[2];
      arrayOfConnectionType[0] = RELAXED;
      arrayOfConnectionType[1] = STRICT;
      $VALUES = arrayOfConnectionType;
    }
    
    private ConnectionType() {}
  }
  
  public static enum Strength
  {
    static
    {
      Strength[] arrayOfStrength = new Strength[3];
      arrayOfStrength[0] = NONE;
      arrayOfStrength[1] = STRONG;
      arrayOfStrength[2] = WEAK;
      $VALUES = arrayOfStrength;
    }
    
    private Strength() {}
  }
  
  public static enum Type
  {
    static
    {
      LEFT = new Type("LEFT", 1);
      TOP = new Type("TOP", 2);
      RIGHT = new Type("RIGHT", 3);
      BOTTOM = new Type("BOTTOM", 4);
      BASELINE = new Type("BASELINE", 5);
      CENTER = new Type("CENTER", 6);
      CENTER_X = new Type("CENTER_X", 7);
      CENTER_Y = new Type("CENTER_Y", 8);
      Type[] arrayOfType = new Type[9];
      arrayOfType[0] = NONE;
      arrayOfType[1] = LEFT;
      arrayOfType[2] = TOP;
      arrayOfType[3] = RIGHT;
      arrayOfType[4] = BOTTOM;
      arrayOfType[5] = BASELINE;
      arrayOfType[6] = CENTER;
      arrayOfType[7] = CENTER_X;
      arrayOfType[8] = CENTER_Y;
      $VALUES = arrayOfType;
    }
    
    private Type() {}
  }
}
