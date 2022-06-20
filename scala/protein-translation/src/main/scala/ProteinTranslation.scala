import scala.annotation.tailrec

// scala> val s="AAABBBCCC"
// scala> val rx="([A-Z][A-Z][A-Z])".r
// scala> (rx findAllIn s).mkString(",")
// res1: String = AAA,BBB,CCC
// scala> rx.findAllIn(s).foreach(println)
// rx.findAllIn(s).foreach(println)
// AAA
// BBB
// CCC

// AUG                   | Methionine
// UUU, UUC              | Phenylalanine
// UUA, UUG              | Leucine
// UCU, UCC, UCA, UCG    | Serine
// UAU, UAC              | Tyrosine
// UGU, UGC              | Cysteine
// UGG                   | Tryptophan
// UAA, UAG, UGA         | STOP

//use regexps to find
//"UUU|UUC".r.findFirstIn("UUU")

object ProteinTranslation {
  //this way is kind of boring, but works. i did more interestnig
  //solutions in the other tracks.
  private val codon2protein = Map(
    "AUG" -> "Methionine",
    "UUU" -> "Phenylalanine",
    "UUC" -> "Phenylalanine",
    "UUA" -> "Leucine",
    "UUG" -> "Leucine",
    "UCU" -> "Serine",
    "UCC" -> "Serine",
    "UCA" -> "Serine",
    "UCG" -> "Serine",
    "UAU" -> "Tyrosine",
    "UAC" -> "Tyrosine",
    "UGU" -> "Cysteine",
    "UGC" -> "Cysteine",
    "UGG" -> "Tryptophan",
    "UAA" -> "STOP",
    "UAG" -> "STOP",
    "UGA" -> "STOP")


  def proteins(input:String): Seq[String] = {
    //@tailrec is sort of like clojures rec construct. you get an
    //error if the compiler cant verify tail recursion is possible
    @tailrec
    def proteins_rec(accumulator: Seq[String],
      codons: Seq[String]): Seq[String] = {
      codons match {
        case codon1st::codonrest => codon2protein get codon1st match {
          //there are 2 ways to terminate, either A) on a STOP codon
          case Some(codon) => if ("STOP".equals(codon)) accumulator
          else
            proteins_rec(codon +: accumulator, codonrest)
          case _ => proteins_rec(accumulator, codonrest)
        }
          //or B) stop if were out of codons
        case _ => accumulator
      }
    }

    proteins_rec(Seq(), //empty list for the accumulator, 1st iteration
      input.grouped(3).toList).reverse //the input string is partitioned in groups of strings of lenght 3
    //reverse the return list
    // "123456789".grouped(3).toList
    // res2: List[String] = List(123, 456, 789)

  }
  
}


