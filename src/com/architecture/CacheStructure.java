package com.architecture;

import java.applet.Applet;
import java.awt.*;
import com.architecture.Brace;

public class CacheStructure extends Applet{

  int xBase = 50;
  int yBase = 40;
  int width = 300;
  int height= 250;
  
  int Offset_width = 100;
  int Index_width = 120;
  
  Color fillColor =
  new Color ((float)0.625,(float)0.8125,(float)0.8125);
  Color drawColor = Color.black;
  Color bkgColor = new Color((float)0.9444,(float)0.9444,(float)0.9444);
  Font font = new Font("TimesRoman", Font.BOLD, 14);
  FontMetrics font_m;

  //*********************************************************
  public void init(){
    setFont(font);
    font_m = getFontMetrics(font);
    setBackground (bkgColor);
    resize(width, height);
  }
  
  //*********************************************************
  public void paint(Graphics g){
    int tag_width = 100;
    int tag_height = 20;
    
    int fr_width = 120;
    int fr_height = 40;
    
    int rxBase = xBase+tag_width;
    int ryBase = yBase;
    
    int Num_bl = 4;
    
    //RAM
    g.setColor(fillColor);
    g.fillRect(rxBase, ryBase, fr_width, fr_height*Num_bl);
    g.setColor(Color.black);
    g.drawRect(rxBase, ryBase, fr_width, fr_height*Num_bl);
    int shift = 0;
    int j;
    for (int i = 1; i <= Num_bl; i++){
      j = i-1;
      shift = fr_height*i;
      g.drawLine(rxBase,ryBase+shift,
		 rxBase+fr_width, ryBase+shift);
      g.drawString("Block Frame "+j, 
		   rxBase+10, ryBase+shift-fr_height/2+5);
    }
    
    //tags
    int step = 0;
    for (int i = 0; i< Num_bl; i++){
      step = i*fr_height;
      
      g.setColor(Color.lightGray);
      g.fillRect(xBase, yBase+step, tag_width, tag_height);
      
      g.setColor(Color.gray);
      g.fillRect(xBase, yBase+step, 20,20);
      
      g.setColor(Color.black);
      g.drawRect(xBase, yBase+step, tag_width, tag_height);
      
      g.drawLine(xBase+20, yBase+step, xBase+20, yBase+step+tag_height);
      
      g.drawString ("tag", xBase+40, yBase+step+tag_height-5);
    }
    Brace br = new Brace(g);    
    br.DrawCurBr(font_m, xBase, yBase-5,tag_width,true, "Directory");
    br.DrawCurBr(font_m, xBase+tag_width, yBase-5,fr_width,true, "RAM");
    
    g.setColor(Color.gray);
    g.fillRect(xBase,yBase+ Num_bl*fr_height+20, 20,20);
    g.setColor(Color.black);
    g.drawRect(xBase,yBase+ Num_bl*fr_height+20, 20,20);
    g.drawString(" - Control Bit",xBase+25,yBase+ Num_bl*fr_height+40);
  }
}