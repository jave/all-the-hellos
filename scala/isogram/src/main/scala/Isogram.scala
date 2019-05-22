
object Isogram {

  // check if set of chars in s is same as list of chars in s. that
  // means no duplicate chars, and so, it is an isogram.
  //also when comparing lists, sort them
  //also lowercase

  //"aabc".toSet.toList.sorted == "aabc".toList.sorted ; is false
  def isIsogram (sin:String): Boolean = {
    val s=sin.replaceAll("[^a-zA-Z]","").toLowerCase()
    s.toSet.toList.sorted == s.toList.sorted
    
  }
}
