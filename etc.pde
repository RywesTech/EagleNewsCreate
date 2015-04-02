void hideTB() {
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

void loading(int x, int y, int xx, int yy) {
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


void keyPressed() {
  if (key == ESC) {
    key = 0;
  }
}

void exit() {
  println("Program compiled correctialy and ran for " + millis() / 1000.0 + " seconds");
  udp.send("Testing...", "71.193.194.121", 9440);
  println("Diagnostic sent, shuting down...");
  super.exit();
}
