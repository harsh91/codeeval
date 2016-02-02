package com.architecture;

import java.awt.*;

public class Brace{
  private Graphics g; 

  //************************************************************
  public Brace(Graphics G){
    g=G;
  }

  //*************************************************************
  public void DrawCurBr( FontMetrics font_m,
			int x,        // base coordinates defined
			int y,        // as very left point of brace
			int width,    //width of the brace
			boolean up,    //true if brace pointed up
			String label){ 
    
    int w=15;            //width and height of the rectangle
    int h=10;            //an arcs are bounded by.
    int height = h;      //height of the whole brace
    
    double Y_step, Y_raise;                //to combine up/down cases
    int angle_1,angle_2 ,angle_3 ,angle_4 ;
    
    if (up){
      Y_step = -0.5;
      Y_raise = -1.5;
      angle_1 = 90;
      angle_2 = 270;
      angle_3 = 180;
      angle_4 = 0;
    }
    else {
      Y_step = 0.5;
      Y_raise = 0.5;
      angle_1 = 180;
      angle_2 = 0;
      angle_3 = 90;
      angle_4 = 270;
    }
    
    g.drawArc(x, y-h/2, w, h, angle_1,90);
    g.drawArc(x+width/2-w, (int)(y+height*Y_raise), w, h,angle_2,90);
    g.drawArc(x+width/2, (int)(y+height*Y_raise), w,h,angle_3,90);
    g.drawArc(x+width-w, y-h/2, w,h,angle_4,90);
    
    g.drawLine(x+w/2,(int)(y+h*Y_step),  x+width/2-w/2, 
               (int)(y+h*Y_step));
    g.drawLine(x+width/2+w/2,(int)(y+h*Y_step), x+width-w/2,
               (int)(y+h*Y_step));

    int strLength = font_m.stringWidth(label);

    int xLabel = x+(width-strLength)/2;
    int yLabel;
    if (up) 
      yLabel= y-height-5;
    else 
      yLabel= y+height+10;
    g.drawString(label, xLabel, yLabel);
  }//end DrawCurBr
}
//********************** end **************************************

