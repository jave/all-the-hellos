object Darts {
  def score(x:Double,y:Double): Int = {
    val r=Math.sqrt(Math.pow(x,2) + Math.pow(y,2))
    if(r<=1) 10
    else if(r<=5) 5
    else if(r<=10) 1
    else 0

  }
}
