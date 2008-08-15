package net

abstract class HTTPMethod private[net](private[net] val domain: String, private val p: String, private[net] val port: Int) {

  private val pathRegex = """/?(.*)""".r
  
  private val path = p match {
    case pathRegex(actual) => "/" + actual
    case null => "/"
  }

  val method: String
  
  override def toString = {
          """<method> <path> HTTP/1.1
             |Host: <host>
             |Connection: close
             |
             |""".stripMargin.replaceFirst("<method>", method)
                             .replaceFirst("<host>", domain)
                             .replaceFirst("<path>", path)
  }
  
}
object HTTPMethod {
  val defaultPort = 80
}

class GET(domain: String, path: String, port: Int) extends HTTPMethod(domain, path, port) {
  val method = "GET"
}

object GET {
  def apply(domain: String, path: String, port: Int) = new GET(domain, path, port)
  def apply(domain: String, path: String) = new GET(domain, path, HTTPMethod.defaultPort)
  def apply(domain: String) = new GET(domain, null, HTTPMethod.defaultPort)
  def apply(domain: String, port: Int) = new GET(domain, null, port)
}

class HEAD(domain: String, path: String, port: Int) extends HTTPMethod(domain, path, port) {
  val method = "HEAD"
}

object HEAD {
  def apply(domain: String, path: String, port: Int) = new HEAD(domain, path, port)
  def apply(domain: String, path: String) = new HEAD(domain, path, HTTPMethod.defaultPort)
  def apply(domain: String, port: Int) = new HEAD(domain, null, port)
  def apply(domain: String) = new HEAD(domain, null, HTTPMethod.defaultPort)
}

class POST(domain: String, path: String, port: Int) extends HTTPMethod(domain, path, port) {
  val method = "POST"
}