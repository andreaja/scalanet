package bla

object TestFunc {

  def main(args: Array[String]) = {

       //mustFail
    
    val twoWords = """([^ ]+) ([^ ]+)""".r
   
    val twoWords(one, two) = "hei hå\n"
    println(one)
    println(two)
    
  }
  
  def := = {
    "wef"
  }
  
  def mustFail = {
    val x = new Sub
     x.asInstanceOf[String]
  }
  
  val func: String = {
     "jiweofj"
  }
  
}

abstract class Super {
  
  def mySuper: String
  
}

class Sub extends Super {
  
  var mySuper = "jwefo"
}
