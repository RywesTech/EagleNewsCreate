void loadFile() {
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

