package net

import java.net._
import java.io._

object HTTP {

  def req(x: HTTPMethod): Response = req(x, (resp: Response) => resp)
  
  def req[A](x: HTTPMethod, resultHandler: Response => A): A = { 
	  val s = new Socket(x.domain, x.port)
	  try {
	    val out = new PrintWriter(new BufferedOutputStream(s.getOutputStream), true)
	    out write (x toString)
	    out flush
	    
	    val in =  new BufferedReader(new InputStreamReader(s.getInputStream))
	    val res = new Response(readInput(in))
	    resultHandler(res)
	  }
	  finally {
	    s close()
	  }
	}
  /*
  def req[A](x: HTTPMethod, resultHandler: String => A): A = { 
	  val s = new Socket(x.domain, x.port)
	  try {
	    val out = new PrintWriter(new BufferedOutputStream(s.getOutputStream), true)
	    out write (x toString)
	    out flush
	    
	    val in =  new BufferedReader(new InputStreamReader(s.getInputStream))
	    readInput(in, resultHandler)
	    
	  }
	  finally {
	    s close()
	  }
	}
  */
  
    private def readInput(in: BufferedReader): List[String] = {
      in.readLine() match {
        case null => Nil
        case s: String => s :: readInput(in)
      }
    }
  /*  private def readInput[A](in: BufferedReader, resultHandler: String => A): A = {
      in.readLine() match {
        case null => Nil
        case s: String => s :: readInput(in)
      }
  } */

    
  private val urlPattern = """(?:http://)?([^/]+)/?(.*)""".r
  private val domainPort = """([^:]+):(\d*)""".r
  
  def -> (url: String): Response = {
    url match {
      case urlPattern(domain, path) => domain match { case domainPort(dom, p) => HTTP.req(GET(dom, path, p.toInt))
                                                      case _ => HTTP.req(GET(domain, path))
                                                    }
      case _ => error("Not a valid url pattern")
    }
  }
}

