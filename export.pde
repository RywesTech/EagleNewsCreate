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

void export() {
  //First move the old file out
  JSONObject news_imp = loadJSONObject("/Users/ryan/Desktop/EAGLE NEWS/latest.eaglenews");
  String dop = news_imp.getString("dop");// Date Of Publication
  File news = new File("/Users/ryan/Desktop/EAGLE NEWS/latest.eaglenews");
  if (news.renameTo(new File("/Users/ryan/Desktop/EAGLE NEWS/Old news/" + dop))) {
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

  println("well, at least we got here... :) ID:1");
  dates = new String [6];
  id_texts = new String [6];
  println("well, at least we got here... :) ID:2");
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
  println("id_cnt: " + id_cnt);
  text.setInt("id_cnt", id_cnt);
  /*
  for (int i = 0; i < id_cnt; i++) {
   JSONObject important_date = new JSONObject();
   important_date.setString("date", dates[i]);
   important_date.setString("text", id_texts[i]);
   important_dates.setJSONObject(i, important_date);
   }
   */
  important_dates = null;
  text.setJSONArray("important_dates", important_dates);

  //---Date Of Publication---\\

  dop = dateOP1b.getText() + "," + dateOP2b.getText() + dateOP3b.getText() + "," + dateOP4b.getText(); 
  text.setString("dop", dop);

  //---SAVE FILE---\\
  //saveJSONObject(text, "Z:\\IDD-SHARE\\Student Council\\EAGLE NEWS\\latest.eaglenews");
  saveJSONObject(text, "/Users/ryan/Desktop/EAGLE NEWS/latest.eaglenews"); 

  //---LEAVE---\\
  view = 6;
}

