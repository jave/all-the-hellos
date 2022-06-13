object Bob {
  def response(dadsays: String): String = {
    //use matching to decide Bobs response this uses case classes that
    //check if the input to the match can be made to create a case
    //class. each case class has an unapply method that is called to
    //make the check. 
    dadsays match {
      case ShoutingQuestion() => "Calm down, I know what I'm doing!"
      case Shouting() => "Whoa, chill out!"
      case Question() => "Sure."
      case Silence() => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  //case classes
  case object Silence {
    //check if input only contains whitespace
    def unapply(dadsays: String) = dadsays.trim.isEmpty
  }

  //check if string is uppercase
  def isOnlyUppercase(s: String) = s == s.toUpperCase

  def endsWithQuestionMark(s:String)=s.trim.endsWith("?")

  def hasLetter(s: String) = s.matches(".*[A-Z].*")


  case object ShoutingQuestion {
    def unapply(dadsays: String) =
      hasLetter(dadsays) && isOnlyUppercase(dadsays) &&
    endsWithQuestionMark(dadsays)

    

    
  }

  //contains letters that are all ucase
  case object Shouting {
    def unapply(dadsays: String) =
      hasLetter(dadsays) && isOnlyUppercase(dadsays)



    
  }

  //ends with a question mark
  case object Question {
    def unapply(dadsays: String) = endsWithQuestionMark(dadsays)
  }

}
