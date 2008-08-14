package net

trait Sequify {

  val stringList: List[String]

  def length = stringList.length
  
  def elements = stringList.elements
  
  def apply(index: Int) = stringList.apply(index)
  
}
