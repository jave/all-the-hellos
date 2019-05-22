

object Pangrams {

  //"aabcdef".toLowerCase.toSet == "abcdef".toSet
  def isPangram(input: String): Boolean = {
    val s=input.replaceAll("[^a-zA-Z]","").toLowerCase()
    s.toLowerCase.toSet == "abcdefghijklmnopqrstuvwxyz".toSet
  }
}

