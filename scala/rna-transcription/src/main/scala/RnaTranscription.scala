import scala.collection.mutable.HashMap
object RnaTranscription {
  //"CGTA".map{c=>m.get(c)}
  //"CGTAs".map{c=>m.getOrElse(c,'-')}.mkString
  val m :HashMap[Char,Char]=HashMap(('C','G'),('G','C'),('T','A'),('A','U'))
  def toRna(s:String): Option[String] = {
    //this works, but if unexpected char, - is used as replacement
    //theres no tests for the case of unexpected input
    Some(s.map{c=>m.getOrElse(c,'-')}.mkString)
    
  }
}
