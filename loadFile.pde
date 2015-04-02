void loadFile() {
  String Ticker;

  String[] art_title;
  String[] art_text;
  String[] id_title;

  int id_cnt;
  int art_cnt;

  JSONArray art_list, id_list;
  JSONObject art_article;
  String art_articles;

  println(filePath);
  text = loadJSONObject(filePath);

  art_cnt = text.getInt("art_cnt");
  id_cnt = text.getInt("id_cnt");

  art_list = text.getJSONArray("articles");
  id_list = text.getJSONArray("important_dates");
  
  art_title = new String[8];
  art_text = new String[8];
  
  for(int i = 0; i < 8; i++){
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

  MRval = 7;
}

void fileSelected(File selection) {
  if (selection == null) {
    view = 0;
    loaded = true;
  } else {
    println("User selected " + selection.getAbsolutePath());
    filePath = selection.getAbsolutePath();
  }
  loadingFile = false;
}

