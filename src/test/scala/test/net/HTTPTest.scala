package net

//import org.scalatest.Suite

object HTTPTest extends Application {
  
  val resp = HTTP -> "http://www.google.no:80/search?hl=en&q=scala+lang&btnG=Google+Search&meta="
  //val resp = HTTP -> "http://localhost:8040/web/securitybreach.do"

  //val resp = HTTP -> "http://www.google/dsb-innmelding"
  resp.foreach(skrivUt)
  
  def skrivUt(s: String) {
    println(s)
  }
  //println(resp.getHead.getValue("Date"))
  //val resp = HTTP req get
  //val head = resp.getHead
  //println(resp)
//  println(head)
//  println(resp.getBody)
//  println(head.statusLine)
//  println(head.statusInt)
//  println(head.getValue("Content-Type"))
//  println(head.getValue("no-value"))
}
