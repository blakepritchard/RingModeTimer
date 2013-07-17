package com.blake.RingModeTimer;



import com.blake.RingModeTimer.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.AudioManager;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RingModeTimer extends Activity 
{
    /** Called when the activity is first created. */
	public static AudioManager managerAudio;
	//public static RingSetter setterRing;
	//private static ScheduledThreadPoolExecutor executor;
	private static Intent service;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	     	    
	    String strAudio = Context.AUDIO_SERVICE;
	    managerAudio = (AudioManager)getSystemService(strAudio);
    
	    //executor = new ScheduledThreadPoolExecutor(1);
	    service = new Intent("com.blake.RingModeTimer.RingSetterService.SERVICE");
	    
	    ((Button) findViewById(R.id.btnNormal)).setOnClickListener
	    (
            new Button.OnClickListener() 
            {
                @Override public void onClick(View arg0) 
                {	
                	/*
                	if(0 < executor.getQueue().size())
                	{
                		executor.shutdown();
                	}
                	*/
                	managerAudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
            }
    	);
	    
	    ((Button) findViewById(R.id.btnMovie)).setOnClickListener
	    (
            new Button.OnClickListener() 
            {
                @Override public void onClick(View arg0) 
                {	                	
                	SetRingTimer(10000);
                }
            }
    	);
	    ((Button) findViewById(R.id.btnSchool)).setOnClickListener
	    (
            new Button.OnClickListener() 
            {
                @Override public void onClick(View arg0) 
                {	                	
                	SetRingTimer(10000);
                }
            }
    	);
	    

    	      
    }
    
    void SetRingTimer(int Milliseconds)
    {
    	try
    	{
	    	managerAudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	    		    	
	    	service.putExtra("DelayTime", Milliseconds);
	    	startService(service);
    	}
    	catch(Exception e)
    	{
    		String strMsg = e.getMessage();
    	}

    	/*
    	if(0 < executor.getQueue().size())
    	{
    		executor.shutdown();
    	}
    	
    	executor.schedule(setterRing, Milliseconds, TimeUnit.MILLISECONDS);
    	*/
    }
    
    
    
}





