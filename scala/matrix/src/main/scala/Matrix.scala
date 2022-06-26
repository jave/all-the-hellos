
case class Matrix(matrixstring:String) {


  def f1(matrisxrowstring:String):Vector[Int]=matrisxrowstring.split(' ').map(_.toInt).toVector
  def parsematrixstring(m:String):Vector[Vector[Int]]=  m.split('\n').map(f1).toVector

  val rows: Vector[Vector[Int]] = parsematrixstring(matrixstring)
  val columns: Vector[Vector[Int]] = rows.transpose

  // //these are the interface function being tested by the test code
  def row(i: Int) = rows(i)

  def column(i: Int) = columns(i)
}

//val m="1 2 3\n4 5 6\n7 8 9"
//m.lines.map(_.split(' ')).foreach{_.map{println}}
//"1 2 3".split(' ').map(_.toInt).toVector
