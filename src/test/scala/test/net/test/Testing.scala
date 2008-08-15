package net.test

import _root_.net._

object Testing {
  def main(args : Array[String]) : Unit = {
  
    val x = args apply 0
    
    val req = GET("www.google.com")
  println(req)
  val resp = HTTP req req
  val head = resp.getHead
  println(resp)
  println(head)
  println(resp.getBody)
  println(head.statusLine)
  println(head.statusInt)
  println(head.getValue("Set-Cookie"))
  println(head.getValue("no-value"))

  }
}
