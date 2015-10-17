package com.afssurani.mycounterapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener
{


    int MAX_VALUE= 100;
    int value;
    TextView textView;
    SeekBar seekBar;
    Button increaseButton;
    Button decreaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = (TextView)findViewById(R.id.textView);
       seekBar = (SeekBar) findViewById(R.id.seekBar);
        increaseButton = (Button)findViewById(R.id.buttonI);
       decreaseButton = (Button) findViewById(R.id.buttonD);
        seekBar.setMax(MAX_VALUE);

        seekBar.setOnSeekBarChangeListener(this);
        displayValue();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   public void displayValue()
   {
       textView.setText(Integer.toString(value));
       seekBar.setProgress(value);
   }

    // Increases the value by 1
    public void increaseValue(View view)
    {
        value++;
        if (value>MAX_VALUE)
        {
            value = 0;
        }
        displayValue();
    }

    // Decreases the value by 1
    public void decreaseValue(View view)
    {
        value--;
        if (value<0)
        {
            value=MAX_VALUE;
        }
        displayValue();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if(fromUser = true)
        {
            value=progress;
        }
        displayValue();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

    }
}
