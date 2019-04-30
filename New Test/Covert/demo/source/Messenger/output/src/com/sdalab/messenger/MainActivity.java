package com.sdalab.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity
  extends Activity
{
  EditText from;
  EditText to;
  
  public MainActivity() {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    to = ((EditText)findViewById(2131034175));
    from = ((EditText)findViewById(2131034173));
    from.requestFocus();
    ((Button)findViewById(2131034179)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(getBaseContext(), SendSmsService.class);
        EditText localEditText = (EditText)findViewById(2131034178);
        localIntent.putExtra("message", localEditText.getText().toString());
        localIntent.putExtra("destinationAddress", to.getText().toString());
        startService(localIntent);
        to.setText("");
        to.requestFocus();
        localEditText.setText("");
        Toast.makeText(getApplicationContext(), "Message is sent!", 1).show();
      }
    });
    ((Button)findViewById(2131034180)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(getBaseContext(), PublishDataService.class);
        EditText localEditText = (EditText)findViewById(2131034178);
        localIntent.putExtra("message", localEditText.getText().toString());
        localIntent.putExtra("sender", from.getText().toString());
        startService(localIntent);
        from.setText("");
        from.requestFocus();
        localEditText.setText("");
        Toast.makeText(getApplicationContext(), "Message is shared!", 1).show();
      }
    });
  }
}
