package com.example.zoom;
 
import javamorph.CFrame;
import javamorph.CLine;
import javamorph.CMain;
import javamorph.CMeshDecorator;
import javamorph.CMorphOperator;
import javamorph.CPopupMenuDecorator;
import javamorph.CProgress;
import javamorph.CTriangulation;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
 
public class Test extends Activity implements OnTouchListener {
 
    Bitmap b1,b2,b3,normalImage;
    Context context;
    AppConfig config;
    RelativeLayout abjustbackground;
    ImageView test1;
    Button done,reset;
    
    CTriangulation ct;
	CLine cl;
	CMain cmain;
	CMeshDecorator cmesh;
	CMorphOperator cmeshoperator;
	CPopupMenuDecorator cpopup;
	CFrame cframe;
	CProgress cp;
	
	GestureDetector gest;
	
	  Canvas canvas;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setContentView(R.layout.test);
        
        done = (Button) findViewById(R.id.btn_ok);
        done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent done = new Intent(getApplicationContext(),Calculator.class);
				startActivity(done);
			finish();	
			}
		});
        reset=(Button) findViewById(R.id.btn_reset);
        reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				oncreate();
			}
		});
        context=getApplicationContext();
        config=new AppConfig(context);

        
        ImageView img = (ImageView) findViewById(R.id.test);
        abjustbackground=(RelativeLayout) findViewById(R.id.linear_abjust_background);
        
		b1 = BitmapFactory.decodeResource(getResources(),
                config.haircolour1[config.gallery_position]);
        b3=b1;
        
        b2= config.abjustbitmap;
      
        Drawable dr = new BitmapDrawable(b2);
		abjustbackground.setBackgroundDrawable(dr);
       
        img.setImageBitmap(b3);
      // img.setOnTouchListener((OnTouchListener) ct);
        img.setOnTouchListener(new Touch());
        
        
       //img=cmain.morph();
        /*float[] mVerts = {
        	       topLeftX, topLeftY, 
        	       topRightX, topRightY, 
        	       bottomLeftX, bottomLeftY, 
        	       bottomRightX, bottomRightY
        	       };

        	canvas.drawBitmapMesh(b3, 1, 1, mVerts, 0, null, 0, null);*/
    }

    private void oncreate() {
		// TODO Auto-generated method stub

        setContentView(R.layout.test);
        
        done = (Button) findViewById(R.id.btn_ok);
        done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			finish();	
			}
		});
        reset=(Button) findViewById(R.id.btn_reset);
        reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				oncreate();
			}
		});
        context=getApplicationContext();
        config=new AppConfig(context);

        
        ImageView img = (ImageView) findViewById(R.id.test);
        abjustbackground=(RelativeLayout) findViewById(R.id.linear_abjust_background);
        
	/*	b1 = BitmapFactory.decodeResource(getResources(),
				config.gallery_grid_Images[config.gallery_position]);
        b3=b1;
        */
        b2= config.abjustbitmap;
      
        Drawable dr = new BitmapDrawable(b2);
		abjustbackground.setBackgroundDrawable(dr);
       
        img.setImageBitmap(b3);
        img.setOnTouchListener(new Touch());
        
    
	}
    
    class MyView extends View { // or some other View-based class
    	   public MyView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		boolean drawRectangle = false;
    	   PointF beginCoordinate;
    	   PointF endCoordinate;

    	   public boolean onTouch(View v, MotionEvent event) {
    	      switch(event.getAction()) {
    	         case MotionEvent.ACTION_DOWN:
    	            drawRectangle = true; // Start drawing the rectangle
    	            beginCoordinate.x = event.getX();
    	            beginCoordinate.y = event.getY();
    	            endCoordinate.x = event.getX();
    	            endCoordinate.y = event.getY();
    	            invalidate(); // Tell View that the canvas needs to be redrawn
    	            break;
    	         case MotionEvent.ACTION_MOVE:
    	            endCoordinate.x = event.getX();
    	            endCoordinate.y = event.getY();
    	            invalidate(); // Tell View that the canvas needs to be redrawn
    	            break;
    	         case MotionEvent.ACTION_UP:
    	            // Do something with the beginCoordinate and endCoordinate, like creating the 'final' object
    	            drawRectangle = false; // Stop drawing the rectangle
    	            invalidate(); // Tell View that the canvas needs to be redrawn
    	            break;
    	      }
			return drawRectangle;
    	   }

    	   protected void onDraw(Canvas canvas) {
    	      if(drawRectangle) {
    	         Paint paint = null;
				// Note: I assume you have the paint object defined in your class
    	         canvas.drawRect(beginCoordinate.x, beginCoordinate.y, endCoordinate.x, endCoordinate.y, paint);
    	      }
    	   }
    	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}