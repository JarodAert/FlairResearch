package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter
  extends ResourceCursorAdapter
{
  private CursorToStringConverter mCursorToStringConverter;
  protected int[] mFrom;
  String[] mOriginalFrom;
  private int mStringConversionColumn = -1;
  protected int[] mTo;
  private ViewBinder mViewBinder;
  
  @Deprecated
  public SimpleCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramInt, paramCursor);
    mTo = paramArrayOfInt;
    mOriginalFrom = paramArrayOfString;
    findColumns(paramArrayOfString);
  }
  
  public SimpleCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramContext, paramInt1, paramCursor, paramInt2);
    mTo = paramArrayOfInt;
    mOriginalFrom = paramArrayOfString;
    findColumns(paramArrayOfString);
  }
  
  private void findColumns(String[] paramArrayOfString)
  {
    if (mCursor != null)
    {
      int i = paramArrayOfString.length;
      if ((mFrom == null) || (mFrom.length != i)) {
        mFrom = new int[i];
      }
      for (int j = 0; j < i; j++) {
        mFrom[j] = mCursor.getColumnIndexOrThrow(paramArrayOfString[j]);
      }
    }
    mFrom = null;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ViewBinder localViewBinder = mViewBinder;
    int i = mTo.length;
    int[] arrayOfInt1 = mFrom;
    int[] arrayOfInt2 = mTo;
    int j = 0;
    if (j < i)
    {
      View localView = paramView.findViewById(arrayOfInt2[j]);
      String str;
      if (localView != null)
      {
        boolean bool = false;
        if (localViewBinder != null) {
          bool = localViewBinder.setViewValue(localView, paramCursor, arrayOfInt1[j]);
        }
        if (!bool)
        {
          str = paramCursor.getString(arrayOfInt1[j]);
          if (str == null) {
            str = "";
          }
          if (!(localView instanceof TextView)) {
            break label128;
          }
          setViewText((TextView)localView, str);
        }
      }
      for (;;)
      {
        j++;
        break;
        label128:
        if (!(localView instanceof ImageView)) {
          break label150;
        }
        setViewImage((ImageView)localView, str);
      }
      label150:
      throw new IllegalStateException(localView.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
    }
  }
  
  public void changeCursorAndColumns(Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    mOriginalFrom = paramArrayOfString;
    mTo = paramArrayOfInt;
    super.changeCursor(paramCursor);
    findColumns(mOriginalFrom);
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (mCursorToStringConverter != null) {
      return mCursorToStringConverter.convertToString(paramCursor);
    }
    if (mStringConversionColumn > -1) {
      return paramCursor.getString(mStringConversionColumn);
    }
    return super.convertToString(paramCursor);
  }
  
  public CursorToStringConverter getCursorToStringConverter()
  {
    return mCursorToStringConverter;
  }
  
  public int getStringConversionColumn()
  {
    return mStringConversionColumn;
  }
  
  public ViewBinder getViewBinder()
  {
    return mViewBinder;
  }
  
  public void setCursorToStringConverter(CursorToStringConverter paramCursorToStringConverter)
  {
    mCursorToStringConverter = paramCursorToStringConverter;
  }
  
  public void setStringConversionColumn(int paramInt)
  {
    mStringConversionColumn = paramInt;
  }
  
  public void setViewBinder(ViewBinder paramViewBinder)
  {
    mViewBinder = paramViewBinder;
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    try
    {
      paramImageView.setImageResource(Integer.parseInt(paramString));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramImageView.setImageURI(Uri.parse(paramString));
    }
  }
  
  public void setViewText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  public Cursor swapCursor(Cursor paramCursor)
  {
    Cursor localCursor = super.swapCursor(paramCursor);
    findColumns(mOriginalFrom);
    return localCursor;
  }
  
  public static abstract interface CursorToStringConverter
  {
    public abstract CharSequence convertToString(Cursor paramCursor);
  }
  
  public static abstract interface ViewBinder
  {
    public abstract boolean setViewValue(View paramView, Cursor paramCursor, int paramInt);
  }
}
