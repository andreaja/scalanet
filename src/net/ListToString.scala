package net

trait ListToString {

  val stringList: List[String]
  
  override def toString = stringIfy(stringList)
  
  def stringIfy(l: List[String]) = l.mkString("\n")
  
}
