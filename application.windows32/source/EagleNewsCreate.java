import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import g4p_controls.*; 
import java.util.Date; 
import hypermedia.net.*; 
import java.io.File; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class EagleNewsCreate extends PApplet {

/**
 \u2588\u2588\u2588\u2588\u2588\u2588\u2588  \u2588\u2588\u2588\u2588\u2588   \u2588\u2588\u2588\u2588\u2588\u2588  \u2588\u2588      \u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2588\u2588\u2588    \u2588\u2588 \u2588\u2588\u2588\u2588\u2588\u2588\u2588 \u2588\u2588     \u2588\u2588 \u2588\u2588\u2588\u2588\u2588\u2588\u2588
 \u2588\u2588      \u2588\u2588   \u2588\u2588 \u2588\u2588       \u2588\u2588      \u2588\u2588          \u2588\u2588\u2588\u2588   \u2588\u2588 \u2588\u2588      \u2588\u2588     \u2588\u2588 \u2588\u2588
 \u2588\u2588\u2588\u2588\u2588   \u2588\u2588\u2588\u2588\u2588\u2588\u2588 \u2588\u2588   \u2588\u2588\u2588 \u2588\u2588      \u2588\u2588\u2588\u2588\u2588       \u2588\u2588 \u2588\u2588  \u2588\u2588 \u2588\u2588\u2588\u2588\u2588   \u2588\u2588  \u2588  \u2588\u2588 \u2588\u2588\u2588\u2588\u2588\u2588\u2588
 \u2588\u2588      \u2588\u2588   \u2588\u2588 \u2588\u2588    \u2588\u2588 \u2588\u2588      \u2588\u2588          \u2588\u2588  \u2588\u2588 \u2588\u2588 \u2588\u2588      \u2588\u2588 \u2588\u2588\u2588 \u2588\u2588      \u2588\u2588
 \u2588\u2588\u2588\u2588\u2588\u2588\u2588 \u2588\u2588   \u2588\u2588  \u2588\u2588\u2588\u2588\u2588\u2588  \u2588\u2588\u2588\u2588\u2588\u2588\u2588 \u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2588\u2588   \u2588\u2588\u2588\u2588 \u2588\u2588\u2588\u2588\u2588\u2588\u2588  \u2588\u2588\u2588 \u2588\u2588\u2588  \u2588\u2588\u2588\u2588\u2588\u2588\u2588
 ___      ___       _____           ________           ________     
|\  \    /  /|     / __  \         |\   __  \         |\   __  \    
\ \  \  /  / /    |\/_|\  \        \ \  \|\  \        \ \  \|\  \   
 \ \  \/  / /     \|/ \ \  \        \ \  \\\  \        \ \  \\\  \  
  \ \    / /           \ \  \  ___   \ \  \\\  \  ___   \ \  \\\  \ 
   \ \__/ /             \ \__\|\__\   \ \_______\|\__\   \ \_______\
    \|__|/               \|__|\|__|    \|_______|\|__|    \|_______|
  

UPDATE 1.0.0 NEW FEATURES:
  *First relaease
  *Many bugs (to be fixed)
  *Up to 12 articles
  *Up to 6 important dates
  *Ticker can be any length
  *Buttons need to be updated when they are non-active
  *Loading file needs to work
  *Athletics section needs to work
  
 */

//http://patorjk.com/software/taag/#p=display&f=ANSI%20Shadow&t=Type%20Something
//http://patorjk.com/software/taag/#p=display&h=0&v=3&f=3D-ASCII&t=V%201.x.x






GTextArea dateOP1b, dateOP2b, dateOP3b, dateOP4b, date1Tb, date1Bb, date2Tb, date2Bb, date3Tb, date3Bb, date4Tb, date4Bb, date5Tb, date5Bb, date6Tb, date6Bb, art1Tb, art1Bb, art2Tb, art2Bb, art3Tb, art3Bb, art4Tb, art4Bb, art5Tb, art5Bb, art6Tb, art6Bb, art7Tb, art7Bb, art8Tb, art8Bb, ticker;  // The text boxes
UDP udp;

PFont font;

PImage logo, save, check, trash, eye, house;
PImage[] loading = new PImage[12];

int view, viewN, viewNTB, x, y;
int MRval;
int d = day();
int day ;
int m = month();
int year = year();
int currentFrame, loadingFrameRate;

String dayOW   = "";
String monthOY = "";
String filePath;

int bg = color(100, 150, 255);  // Background color

boolean loaded = false, loadingFile = true;

public void setup() {
  println("starting setup");

  //x = displayWidth;
  //y = displayHeight;
  x = 1024;
  y = 720;
  size(x, y);
  background(bg);

  font = createFont("texgyretermes-regular.otf", 32); //Initilise the font
  logo    = loadImage("eagleNews.png");
  save    = loadImage("save.png");
  check   = loadImage("check.png");
  trash   = loadImage("trash.png");
  eye     = loadImage("eye.png");
  house   = loadImage("house.png");
  for (int i = 0; i < 12; i++) {
    loading[i]  = loadImage("loading/loading"+ (i+1) +".gif");
    println(i);
  }

  println("Done loading data, now getting the date, it took " + millis() / 1000.0f + " seconds");
  final int day = new Date().getDay();
  if (day == 1) {
    dayOW = "Monday";
  } else if (day == 2) {
    dayOW = "Tuesday";
  } else if (day == 3) {
    dayOW = "Wednesday";
  } else if (day == 4) {
    dayOW = "Thursday";
  } else if (day == 5) {
    dayOW = "Friday";
  } else if (day == 6) {
    dayOW = "Saturday";
  } else if (day == 0) {
    dayOW = "Sunday";
  }

  if (m == 1) {
    monthOY = "January";
  } else if (m == 2) {
    monthOY = "February";
  } else if (m == 3) {
    monthOY = "March";
  } else if (m == 4) {
    monthOY = "April";
  } else if (m == 5) {
    monthOY = "May";
  } else if (m == 6) {
    monthOY = "June";
  } else if (m == 7) {
    monthOY = "July";
  } else if (m == 8) {
    monthOY = "August";
  } else if (m == 9) {
    monthOY = "September";
  } else if (m == 10) {
    monthOY = "October";
  } else if (m == 11) {
    monthOY = "November";
  } else if (m == 12) {
    monthOY = "December";
  }

  year = year();
  println("Day of the week: " + dayOW);
  println("Month of the year: " + monthOY);
  println("Done getting Dates, it took " + millis() / 1000.0f + " seconds.  Now starting to create the text boxes");

  G4P.setGlobalColorScheme(GCScheme.BLUE_SCHEME);

  date1Tb = new GTextArea(this, 230, 150, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date1Tb.tag = "dat1";
  date1Tb.setPromptText("The date");

  date1Bb = new GTextArea(this, 230, 200, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date1Bb.tag = "dat2";
  date1Bb.setPromptText("What is happening on that date");

  date2Tb = new GTextArea(this, 230, 450, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date2Tb.tag = "dat3";
  date2Tb.setPromptText("The date");

  date2Bb = new GTextArea(this, 230, 500, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date2Bb.tag = "dat4";
  date2Bb.setPromptText("What is happening on that date");

  date3Tb = new GTextArea(this, 490, 150, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date3Tb.tag = "dat5";
  date3Tb.setPromptText("The date");

  date3Bb = new GTextArea(this, 490, 200, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date3Bb.tag = "dat6";
  date3Bb.setPromptText("What is happening on that date");

  date4Tb = new GTextArea(this, 490, 450, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date4Tb.tag = "dat7";
  date4Tb.setPromptText("The date");

  date4Bb = new GTextArea(this, 490, 500, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date4Bb.tag = "dat8";
  date4Bb.setPromptText("What is happening on that date");

  date5Tb = new GTextArea(this, 750, 150, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date5Tb.tag = "dat9";
  date5Tb.setPromptText("The date");

  date5Bb = new GTextArea(this, 750, 200, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date5Bb.tag = "dat10";
  date5Bb.setPromptText("What is happening on that date");

  date6Tb = new GTextArea(this, 750, 450, 250, 40, G4P.SCROLLBARS_AUTOHIDE);
  date6Tb.tag = "dat11";
  date6Tb.setPromptText("The date");

  date6Bb = new GTextArea(this, 750, 500, 250, 180, G4P.SCROLLBARS_AUTOHIDE);
  date6Bb.tag = "dat12";
  date6Bb.setPromptText("What is happening on that date");

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  dateOP1b = new GTextArea(this, 475, 170, 300, 40, G4P.SCROLLBARS_AUTOHIDE);
  dateOP1b.tag = "datOP1";
  dateOP1b.setPromptText("What day of the week? ex: " + dayOW);

  dateOP2b = new GTextArea(this, 475, 230, 300, 40, G4P.SCROLLBARS_AUTOHIDE);
  dateOP2b.tag = "datOP2";
  dateOP2b.setPromptText("What month? ex: " + monthOY);

  dateOP3b = new GTextArea(this, 475, 290, 300, 40, G4P.SCROLLBARS_AUTOHIDE);
  dateOP3b.tag = "datOP3";
  dateOP3b.setPromptText("What day of the month? ex: " + d);

  dateOP4b = new GTextArea(this, 475, 350, 300, 40, G4P.SCROLLBARS_AUTOHIDE);
  dateOP4b.tag = "datOP3";
  dateOP4b.setPromptText("What year? ex: " + year);

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  art1Tb = new GTextArea(this, 225, 110, 250, 40);
  art1Tb.tag = "txa1";
  art1Tb.setPromptText("Article 1 Title");

  art1Bb = new GTextArea(this, 225, 170, 375, 180);
  art1Bb.tag = "txa2";
  art1Bb.setPromptText("Article 1 Body");

  art2Tb = new GTextArea(this, 225, 410, 250, 40);
  art2Tb.tag = "txa3";
  art2Tb.setPromptText("Article 2 Title");

  art2Bb = new GTextArea(this, 225, 470, 375, 180);
  art2Bb.tag = "txa4";
  art2Bb.setPromptText("Article 2 Body");

  art3Tb = new GTextArea(this, 620, 110, 250, 40);
  art3Tb.tag = "txa5";
  art3Tb.setPromptText("Article 3 Title");

  art3Bb = new GTextArea(this, 620, 170, 375, 180);
  art3Bb.tag = "txa6";
  art3Bb.setPromptText("Article 3 Body");

  art4Tb = new GTextArea(this, 620, 410, 250, 40);
  art4Tb.tag = "txa7";
  art4Tb.setPromptText("Article 4 Title");

  art4Bb = new GTextArea(this, 620, 470, 375, 180);
  art4Bb.tag = "txa8";
  art4Bb.setPromptText("Article 4 Body");


  art5Tb = new GTextArea(this, 225, 110, 250, 40);
  art5Tb.tag = "txa9";
  art5Tb.setPromptText("Article 5 Title");

  art5Bb = new GTextArea(this, 225, 170, 375, 180);
  art5Bb.tag = "txa10";
  art5Bb.setPromptText("Article 5 Body");

  art6Tb = new GTextArea(this, 225, 410, 250, 40);
  art6Tb.tag = "txa11";
  art6Tb.setPromptText("Article 6 Title");

  art6Bb = new GTextArea(this, 225, 470, 375, 180);
  art6Bb.tag = "txa12";
  art6Bb.setPromptText("Article 6 Body");

  art7Tb = new GTextArea(this, 620, 110, 250, 40);
  art7Tb.tag = "txa13";
  art7Tb.setPromptText("Article 7 Title");

  art7Bb = new GTextArea(this, 620, 170, 375, 180);
  art7Bb.tag = "txa14";
  art7Bb.setPromptText("Article 7 Body");

  art8Tb = new GTextArea(this, 620, 410, 250, 40);
  art8Tb.tag = "txa15";
  art8Tb.setPromptText("Article 8 Title");

  art8Bb = new GTextArea(this, 620, 470, 375, 180);
  art8Bb.tag = "txa16";
  art8Bb.setPromptText("Article 8 Body");

  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  ticker = new GTextArea(this, 250, 180, 740, 520);
  ticker.tag = "tic1";
  ticker.setPromptText("Ticker Text");

  hideTB();

  println("Done with textboes");
  udp = new UDP( this, 9440 );
  println("===================================================");
  println("   Eagle News V1.0 created by Ryan Westcott");
  println("===================================================");
  println("Setup took " + millis() / 1000.0f + " Second(s)");
}

public void draw() {
  x = width;
  y = height;

  switch(view) {
  case 0:
    frame.setTitle("Eagle News - V1.0 (Beta)");
    hideTB();
    background(bg);
    image(logo, x / 2 - 200, 50);

    loaded = false;
    loadingFile = true;

    stroke(255);
    fill(255);
    textSize(20); 
    text("Ryan Westcott 2015", x - 250, y - 40);
    text("Version 1.0  (beta)", 50, y - 40);

    if (mouseX >= x / 2 - 150 && mouseX <= x / 2 + 150 && mouseY >= 300 && mouseY <= 340) {
      fill(200);
      if (mousePressed) {
        MRval = 1;
      }
    } else {
      fill(150);
    }
    rect(x / 2 - 150, 300, 300, 40, 15);

    if (mouseX >= x / 2 - 150 && mouseX <= x / 2 + 150 && mouseY >= 350 && mouseY <= 390) {
      fill(200);
      if (mousePressed) {
        view = 2;
      }
    } else {
      fill(150);
    }
    rect(x / 2 - 150, 350, 300, 40, 15);

    if (mouseX >= x / 2 - 150 && mouseX <= x / 2 + 150 && mouseY >= 400 && mouseY <= 440) {
      fill(200);
      if (mousePressed) {
        MRval = 5;
      }
    } else {
      fill(150);
    }
    rect(x / 2 - 150, 400, 300, 40, 15);

    if (mouseX >= x / 2 - 150 && mouseX <= x / 2 + 150 && mouseY >= 450 && mouseY <= 490) {
      fill(200);
      if (mousePressed) {
        view = 4;
      }
    } else {
      fill(150);
    }
    rect(x / 2 - 150, 450, 300, 40, 15);

    fill(0);
    textAlign(CENTER);
    text("Create New", x / 2, 325);
    text("Edit File", x / 2, 375);
    text("Options", x / 2, 425);
    text("Quit", x / 2, 475);
    textAlign(LEFT);
    break;
    //-------------------------------------------------CASE1-------------------------------------------------\\
  case 1:
    background(bg);
    frame.setTitle("Eagle News - Create New");

    loaded = false;

    stroke(0);
    strokeWeight(3);
    line(217, 0, 217, y);
    line(217, 60, x, 60);

    strokeWeight(1);
    fill(150);
    stroke(255);
    rect(0, 0, 210, 115, 10);
    image(logo, 10, 10, 200, 100);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 125 && mouseY <= 175) {
      if (mousePressed) {
        //export();
        MRval = 4;
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 125, 210, 50, 10);
    image(check, 5, 140, 30, 30);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 185 && mouseY <= 235) {
      if (mousePressed) {
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 185, 210, 50, 10);
    image(trash, 5, 200, 25, 30);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 245 && mouseY <= 295) {
      if (mousePressed) {
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 245, 210, 50, 10);
    image(save, 5, 260, 30, 30);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 305 && mouseY <= 355) {
      if (mousePressed) {
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 305, 210, 50, 10);
    image(eye, 5, 320, 30, 30);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 365 && mouseY <= 415) {
      if (mousePressed) {
        viewN = 0;
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 365, 210, 50, 10);

    if (mouseX >= 0 && mouseX <= 210 && mouseY >= 425 && mouseY <= 475) {
      if (mousePressed) {
        view = 0;
      }
      fill(200);
    } else {
      fill(150);
    }
    rect(0, 425, 210, 50, 10);
    image(house, 5, 435, 30, 30);

    fill(0);
    stroke(0);
    textSize(18);
    text("Finish & compile", 45, 155);
    text("Discard", 45, 215);
    text("Save", 45, 275);
    text("Preview", 45, 335);
    text("\u2190   Back", 15, 395);
    text("Main Menu", 45, 455);

    switch(viewN) {
    case 0:
      hideTB();
      stroke(255);
      if (mouseX >= 450 && mouseX <= 750 &&mouseY >= 200 && mouseY <= 240) {
        if (mousePressed) {
          viewN = 1;
        }
        fill(200);
      } else {
        fill(150);
      }
      rect(450, 200, 300, 40, 10);

      if (mouseX >= 450 && mouseX <= 750 &&mouseY >= 250 && mouseY <= 290) {
        if (mousePressed) {
          viewN = 2;
        }
        fill(200);
      } else {
        fill(150);
      }
      rect(450, 250, 300, 40, 10);

      if (mouseX >= 450 && mouseX <= 750 &&mouseY >= 300 && mouseY <= 340) {
        if (mousePressed) {
          viewN = 3;
        }
        fill(200);
      } else {
        fill(150);
      }
      rect(450, 300, 300, 40, 10);

      if (mouseX >= 450 && mouseX <= 750 &&mouseY >= 350 && mouseY <= 390) {
        if (mousePressed) {
          viewN = 4;
        }
        fill(200);
      } else {
        fill(150);
      }
      rect(450, 350, 300, 40, 10);

      if (mouseX >= 450 && mouseX <= 750 &&mouseY >= 400 && mouseY <= 440) {
        if (mousePressed) {
          viewN = 5;
        }
        fill(200);
      } else {
        fill(150);
      }
      rect(450, 400, 300, 40, 10);
      textSize(20);
      fill(0);
      stroke(0);
      textAlign(CENTER);
      text("What would you like to edit?", 600, 190);
      text("The main text", 600, 225);
      text("The Important dates", 600, 275);
      text("Athletics Section", 600, 325);
      text("The Ticker", 600, 375);
      text("The date of publication", 600, 425);
      //text("Next", 945, 40);
      //text("Last", 275, 40);
      textAlign(LEFT);

      break;
    case 1:

      switch(viewNTB) {
      case 0:
        textSize(20);
        text("Article 1", 240, 90);
        text("Article 2", 240, 390);
        text("Article 3", 640, 90);
        text("Article 4", 640, 390);

        text("Articles 1 - 4", 530, 40);

        art1Tb.setVisible(true);
        art1Bb.setVisible(true);
        art2Tb.setVisible(true);
        art2Bb.setVisible(true);
        art3Tb.setVisible(true);
        art3Bb.setVisible(true);
        art4Tb.setVisible(true);
        art4Bb.setVisible(true);

        art5Tb.setVisible(false);
        art5Bb.setVisible(false);
        art6Tb.setVisible(false);
        art6Bb.setVisible(false);
        art7Tb.setVisible(false);
        art7Bb.setVisible(false);
        art8Tb.setVisible(false);
        art8Bb.setVisible(false);

        break;
      case 1:
        textSize(20);
        text("Article 5", 240, 90);
        text("Article 6", 240, 390);
        text("Article 7", 640, 90);
        text("Article 8", 640, 390);

        text("Articles 5 - 8", 530, 40);

        art5Tb.setVisible(true);
        art5Bb.setVisible(true);
        art6Tb.setVisible(true);
        art6Bb.setVisible(true);
        art7Tb.setVisible(true);
        art7Bb.setVisible(true);
        art8Tb.setVisible(true);
        art8Bb.setVisible(true);

        art1Tb.setVisible(false);
        art1Bb.setVisible(false);
        art2Tb.setVisible(false);
        art2Bb.setVisible(false);
        art3Tb.setVisible(false);
        art3Bb.setVisible(false);
        art4Tb.setVisible(false);
        art4Bb.setVisible(false);
        break;
      }

      if (viewNTB < 0) {
        viewNTB = 0;
      } else if (viewNTB > 1) {
        viewNTB = 1;
      }
      stroke(0);
      line(217, 360, x, 360);
      line(610, 60, 610, y);

      if (mouseX >= 230 && mouseX <= 330 && mouseY >= 15 && mouseY <= 55) {
        fill(200);
        if (mousePressed) {
          MRval = 2;
        }
      } else {
        fill(150);
      }
      rect(230, 15, 100, 40, 10);

      if (mouseX >= 900 && mouseX <= 1000 && mouseY >= 15 && mouseY <= 55) {
        fill(200);
        if (mousePressed) {
          MRval = 3;
        }
      } else {
        fill(150);
      }
      rect(900, 15, 100, 40, 10);

      textAlign(CENTER);
      fill(0);
      text("Next", 945, 40);
      text("Last", 275, 40);
      textAlign(LEFT);
      break;
    case 2:
      date1Tb.setVisible(true);
      date1Bb.setVisible(true);
      date2Tb.setVisible(true);
      date2Bb.setVisible(true);
      date3Tb.setVisible(true);
      date3Bb.setVisible(true);
      date4Tb.setVisible(true);
      date4Bb.setVisible(true);
      date5Tb.setVisible(true);
      date5Bb.setVisible(true);
      date6Tb.setVisible(true);
      date6Bb.setVisible(true);
      fill(0);
      textSize(17);
      textAlign(CENTER, TOP);
      text("Make sure to format the dates with the day of the week first, folowed by a comma, then the month and finaly the day of the month.  Example:  Monday, November 9", 250, 70, 700, 100);
      textSize(16);
      textAlign(LEFT);
      text("Date 1:", 240, 140);
      text("Date 2:", 240, 440);
      text("Date 3:", 490, 140);
      text("Date 4:", 490, 440);
      text("Date 5:", 740, 140);
      text("Date 6:", 740, 440);
      line(217,120,x,120);
      break;
    case 3:

      break;
    case 4:
      fill(0);
      textSize(23);
      text("Ticker", 250, 100);
      textSize(18);
      text("Sepperate the different parts by dashes, ex: roses are red - pankackes are flat - airplanes fly in the sky", 250, 115, 700, 100);
      ticker.setVisible(true);
      break;
    case 5:
      textSize(23);
      text("Date of publication", 250, 100);
      textSize(18);
      text("Enter the date that this will be read.  It will be either a Tuesday or a Friday.", 250, 115, 700, 100);
      dateOP1b.setVisible(true);
      dateOP2b.setVisible(true);
      dateOP3b.setVisible(true);
      dateOP4b.setVisible(true);
      break;
    }
    break;
  case 2:
    background(bg);
    fill(0);
    textSize(20);
    textAlign(CENTER);
    text("Loading the new file will overwrite any unsaved changes.  If you have not saved the your current work, please do so now before loading the new file.", 100, 100, x - 200, 500);

    if (mouseX >= x / 2 - 150 && mouseX <= x / 2 + 150 && mouseY >= 240 && mouseY <= 280) {
      fill(200);
      if (mousePressed) {
        loadFile();
      }
    } else {
      fill(150);
    }
    rect(x / 2 - 150, 240, 300, 40, 15);

    fill(0);
    textSize(18);
    text("Load File", x / 2, 265);

    if (loadingFile == true) {
      loading(x / 2 - 16, y / 2 - 16, 32, 32);
    }
    if (loaded == false) {
      selectInput("Select a file to process:", "fileSelected");
      loaded = true;
    }
    break;
  case 3:
    background(bg);
    fill(0);
    textSize(30);
    textAlign(CENTER, CENTER);
    text("No current options \n Click anywhere to return", x / 2, y / 2);
    if (mousePressed) {
      MRval = 6;
    }
    break;
  case 4:
    background(bg);
    exit();
    break;
  case 5:
    background(bg);
    loadingFrameRate = loadingFrameRate + 1;
    if (loadingFrameRate == 3) {
      if (currentFrame < 11) {
        currentFrame = currentFrame + 1;
      } else {
        currentFrame = 0;
      }
      loadingFrameRate = 0;
    }
    image(loading[currentFrame], x/2-16, y/2-16);
    break;
    case 6:
    background(bg);
    hideTB();
    text("Done", 200,200);
    break;
  }
}
public void hideTB() {
  date1Tb.setVisible(false);
  date1Bb.setVisible(false);
  date2Tb.setVisible(false);
  date2Bb.setVisible(false);
  date3Tb.setVisible(false);
  date3Bb.setVisible(false);
  date4Tb.setVisible(false);
  date4Bb.setVisible(false);
  date5Tb.setVisible(false);
  date5Bb.setVisible(false);
  date6Tb.setVisible(false);
  date6Bb.setVisible(false);
  dateOP1b.setVisible(false);
  dateOP2b.setVisible(false);
  dateOP3b.setVisible(false);
  dateOP4b.setVisible(false);
  art1Tb.setVisible(false);
  art1Bb.setVisible(false);
  art2Tb.setVisible(false);
  art2Bb.setVisible(false);
  art3Tb.setVisible(false);
  art3Bb.setVisible(false);
  art4Tb.setVisible(false);
  art4Bb.setVisible(false);
  art5Tb.setVisible(false);
  art5Bb.setVisible(false);
  art6Tb.setVisible(false);
  art6Bb.setVisible(false);
  art7Tb.setVisible(false);
  art7Bb.setVisible(false);
  art8Tb.setVisible(false);
  art8Bb.setVisible(false);
  ticker.setVisible(false);
}

public void loading(int x, int y, int xx, int yy) {
  loadingFrameRate = loadingFrameRate + 1;
  if (loadingFrameRate == 3) {
    if (currentFrame < 11) {
      currentFrame = currentFrame + 1;
    } else {
      currentFrame = 0;
    }
    loadingFrameRate = 0;
  }
  image(loading[currentFrame], x, y, xx, yy);
}


public void keyPressed() {
  if (key == ESC) {
    key = 0;
  }
}

public void exit() {
  println("Program compiled correctialy and ran for " + millis() / 1000.0f + " seconds");
  udp.send("Testing...", "71.193.194.121", 9440);
  println("Diagnostic sent, shuting down...");
  super.exit();
}
JSONObject text;
JSONObject[] article;

JSONArray important_dates;
JSONArray articles;

String[] titles;
String[] art_texts;
String[] id_texts;
String[] dates;
String[] tickers;

int art_cnt, id_cnt;

public void export() {
  //First move the old file out
  //JSONObject news_imp = loadJSONObject("/Users/ryan/Desktop/EAGLE NEWS/latest.eaglenews");
  JSONObject news_imp = loadJSONObject("Z:\\IDD-SHARE\\Student Council\\EAGLE NEWS\\latest.eaglenews");
  String dop = news_imp.getString("dop");// Date Of Publication
  File news = new File("Z:\\IDD-SHARE\\Student Council\\EAGLE NEWS\\latest.eaglenews");
  if (news.renameTo(new File("Z:\\IDD-SHARE\\Student Council\\EAGLE NEWS\\Old news\\" + dop))) {
    println("File is moved successful!");
  } else {
    println("File failed to move!");
  }

  //Then create the new file

  text = new JSONObject();

  //---ARTICLES---\\
  titles = new String [8];
  art_texts  = new String [8];
  //prepare:
  titles[0] = art1Tb.getText();
  titles[1] = art2Tb.getText();
  titles[2] = art3Tb.getText();
  titles[3] = art4Tb.getText();
  titles[4] = art5Tb.getText();
  titles[5] = art6Tb.getText();
  titles[6] = art7Tb.getText();
  titles[7] = art8Tb.getText();

  art_texts[0] = art1Bb.getText();
  art_texts[1] = art2Bb.getText();
  art_texts[2] = art3Bb.getText();
  art_texts[3] = art4Bb.getText();
  art_texts[4] = art5Bb.getText();
  art_texts[5] = art6Bb.getText();
  art_texts[6] = art7Bb.getText();
  art_texts[7] = art8Bb.getText();

  for (int i = 0; i < 8; i++) {
    String titlesTemp = titles[i];
    println(titlesTemp);
    println(titlesTemp.length());
    if (titlesTemp.length() > 2) {
      art_cnt = art_cnt + 1;
    }
  }
  println(art_cnt);

  articles = new JSONArray();

  for (int i = 0; i < art_cnt; i++) {
    JSONObject article = new JSONObject();
    article.setString("title", titles[i]);
    article.setString("text", art_texts[i]);
    articles.setJSONObject(i, article);
  }
  text.setJSONArray("articles", articles);
  text.setInt("art_cnt", art_cnt);
  //---TICKER---\\

  tickers = new String [1];
  tickers[0] = ticker.getText();
  text.setString("ticker", tickers[0]);

  //---DATES---\\
  
  dates = new String [6];
  id_texts = new String [6];
  
  dates[0] = date1Tb.getText();
  dates[1] = date2Tb.getText();
  dates[2] = date3Tb.getText();
  dates[3] = date4Tb.getText();
  dates[4] = date5Tb.getText();
  dates[5] = date6Tb.getText();
  
  id_texts[0] = date1Bb.getText();
  id_texts[1] = date2Bb.getText();
  id_texts[2] = date3Bb.getText();
  id_texts[3] = date4Bb.getText();
  id_texts[4] = date5Bb.getText();
  id_texts[5] = date6Bb.getText();
  
  for (int i = 0; i < 6; i++) {
    String datesTemp = dates[i];
    println(datesTemp);
    println(datesTemp.length());
    if (datesTemp.length() > 2) {
      id_cnt = id_cnt + 1;
    }
  }
  text.setInt("id_cnt", id_cnt);
  
  important_dates = new JSONArray();
  
  for (int i = 0; i < id_cnt; i++) {
    println("now: " + i);
    JSONObject important_date = new JSONObject();
    important_date.setString("date", dates[i]);
    important_date.setString("text", id_texts[i]);
    important_dates.setJSONObject(i, important_date);
  }
  
  text.setJSONArray("important_dates", important_dates);
  
  //---Date Of Publication---\\

  dop = dateOP1b.getText() + "," + dateOP2b.getText() + dateOP3b.getText() + "," + dateOP4b.getText(); 
  text.setString("dop", dop);

  //---SAVE FILE---\\
  saveJSONObject(text, "Z:\\IDD-SHARE\\Student Council\\EAGLE NEWS\\latest.eaglenews");
  //saveJSONObject(text, "/Users/ryan/Desktop/EAGLE NEWS/latest.eaglenews"); 

  //---LEAVE---\\
  view = 6;
}

public void loadFile() {
  String Ticker;

  String[] art_title;
  String[] art_text;
  String[] id_title;
  
  String[] date, id_text;

  int id_cnt;
  int art_cnt;

  JSONArray art_list, id_list;
  JSONObject art_article;
  JSONObject id_article;
  String art_articles;

  println(filePath);
  text = loadJSONObject(filePath);

  art_cnt = text.getInt("art_cnt");
  id_cnt = text.getInt("id_cnt");

  art_list = text.getJSONArray("articles");
  id_list = text.getJSONArray("important_dates");

  art_title = new String[8];
  art_text = new String[8];

  for (int i = 0; i < 8; i++) {
    art_title[i] = "";
    art_text[i] = "";
  }

  for (int i = 0; i < art_cnt; i ++) {
    art_article = art_list.getJSONObject(i);

    art_title[i] = art_article.getString("title");
    println(art_title[i]);

    art_text[i] = art_article.getString("text");
    println(art_text[i]);
  }

  art1Tb.setText(art_title[0]);
  art2Tb.setText(art_title[1]);
  art3Tb.setText(art_title[2]);
  art4Tb.setText(art_title[3]);
  art5Tb.setText(art_title[4]);
  art6Tb.setText(art_title[5]);
  art7Tb.setText(art_title[6]);
  art8Tb.setText(art_title[7]);

  art1Bb.setText(art_text[0]);
  art2Bb.setText(art_text[1]);
  art3Bb.setText(art_text[2]);
  art4Bb.setText(art_text[3]);
  art5Bb.setText(art_text[4]);
  art6Bb.setText(art_text[5]);
  art7Bb.setText(art_text[6]);
  art8Bb.setText(art_text[7]);

  Ticker = text.getString("ticker");
  ticker.setText(Ticker);
  
  // -----Important dates----------\\
  
  date = new String[6];
  id_text = new String[6];
  
  for (int i = 0; i < 6; i++) {
    date[i] = "";
    id_text[i] = "";
  }
  
  for(int i = 0; i < id_cnt; i++){
    id_article = id_list.getJSONObject(i);
    
    date[i] = id_article.getString("date");
    id_text[i] = id_article.getString("text");
  }
  date1Tb.setText(date[0]);
  date2Tb.setText(date[1]);
  date3Tb.setText(date[2]);
  date4Tb.setText(date[3]);
  date5Tb.setText(date[4]);
  date6Tb.setText(date[5]);
  
  date1Bb.setText(id_text[0]);
  date2Bb.setText(id_text[1]);
  date3Bb.setText(id_text[2]);
  date4Bb.setText(id_text[3]);
  date5Bb.setText(id_text[4]);
  date6Bb.setText(id_text[5]);
  
  MRval = 7;
}

public void fileSelected(File selection) {
  if (selection == null) {
    view = 0;
    loaded = true;
  } else {
    println("User selected " + selection.getAbsolutePath());
    filePath = selection.getAbsolutePath();
  }
  loadingFile = false;
}

public void mouseReleased() {
  if (MRval == 0) {
  } else if (MRval ==1) {
    view = 1;
  } else if (MRval ==2) {
    viewNTB = viewNTB - 1;
  } else if (MRval ==3) {
    viewNTB = viewNTB + 1;
  } else if (MRval ==4) {
    view = 5;
    thread("export");
    //export();
  } else if (MRval ==5) {
    view = 3;
  } else if (MRval ==6) {
    view = 0;
  } else if (MRval == 7) {
    view = 1;
  }
  MRval = 0;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "EagleNewsCreate" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
