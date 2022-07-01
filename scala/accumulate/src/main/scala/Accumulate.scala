import scala.annotation.tailrec
class Accumulate {
  def accumulate[A, B](f: (A) => B, inputlist : List[A]): List[B] = {
    @tailrec
    def acc_rec[A, B](f: (A) => B, acc:List[B], inputlist : List[A]): List[B] = {
      inputlist match {
        case car::cdr => { acc_rec(f, f(car) ::  acc , cdr)   }
        case _ => acc

      }
    }

    acc_rec(f, List(), inputlist).reverse

  }
}
