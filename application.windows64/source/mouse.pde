void mouseReleased() {
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
