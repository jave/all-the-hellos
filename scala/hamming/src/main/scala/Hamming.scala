object Hamming {
  //should return a number, or None, if the strings are of different
  //lengths

  //("abca".toList zip "defa".toList ).map{case(a1,a2)=>a1==a2}.reduce(_ & _)

  
  def distance(s1:String, s2:String): Option[Int] = {
    if (s1.size != s2.size)
      None   // return int, or None if strings are not of same length
    else
      Some((s1.toList zip s2.toList ). //zip string lists together, to a list of tuples
        map{case(a1,a2)=>a1==a2}.  //map over the tuples, see if each tuple entry is the same
        filter(_==false).size) //keep only false entries. the number of false entries is the hamming distance
  }
  
}
