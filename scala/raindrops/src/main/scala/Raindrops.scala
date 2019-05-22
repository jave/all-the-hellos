import scala.collection.mutable.HashMap

object Raindrops {
//  val rainmap:HashMap[Int, String ] = HashMap((3, "Pling"), (5, "Plang"), (7, "plong"))
  val rainlist:List[Tuple2[Int, String]] = List(Tuple2(3, "Pling"), Tuple2(5, "Plang"), Tuple2(7, "Plong"))

//rainlist.foreach{x=>println("num %d : str %s".format( x._1, x._2))}
//rainlist.map{x=>if(15%x._1==0) x._2 else ""}
//rainlist.flatMap{x=>if(15%x._1==0) x._2 else ""}.mkString  
  def convert(n: Int): String = {
    val rv=rainlist.flatMap{x=>if(n%x._1==0) x._2 else ""}.mkString
    if(rv=="") ""+n else rv

  }
}

