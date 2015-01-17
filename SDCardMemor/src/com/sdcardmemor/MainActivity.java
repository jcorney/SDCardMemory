package com.sdcardmemor;
import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;


public class MainActivity extends Activity{
	
	int photosNumber = 0;
	int myNumber = 0;
	String myString;
	String mySDState;
	String myTotalSize;
	String myTotalRemainingSize;
	StatFs myStats;
	double size = 0.0;
	double remainingSize = 0.0;
	double gigs = 1073741824;
	
	private TextView mySDCard;
	private TextView mySize;
	private TextView myRemainingSize;
	

   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mySDCard = (TextView)this.findViewById(R.id.textSDCard);
        mySize = (TextView)this.findViewById(R.id.textSize);
        myRemainingSize = (TextView)this.findViewById(R.id.textRemainingSize);
        
        myStats = new StatFs(Environment.getExternalStorageDirectory().getPath());
        
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getAvailableBlocks();
        long megAvailable = bytesAvailable / (1024 * 1024);
        
        
        //size = (myStats.getBlockSize() * myStats.getBlockCount() / (gigs));
        //remainingSize = (myStats.getBlockSize() * myStats.getAvailableBlocks()) / (gigs);
        
        myTotalSize = Long.toString(bytesAvailable);
        myTotalRemainingSize = Long.toString(megAvailable);      
        
        mySize.setText(myTotalSize);
        myRemainingSize.setText(myTotalRemainingSize);       
        
        File mySD = new File(Environment.getExternalStorageDirectory() + "/");
        File[] myFile = mySD.listFiles();
        
        if (myFile != null){
        	myNumber = myFile.length;
        }
        else
        	myNumber = 0; 
        
        
        myString = Integer.toString(myNumber);
        mySDCard.setText(myString);
        
        
        
        
    }


}
