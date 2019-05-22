import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalDateTime

object Gigasecond {
  // declare a new type, Seconds
  private type Seconds = Long

  //there are supposed to be 2 overloaded signarures, one for LocalDAte, one for LocaLDateTime
  // compared to java this is a little bit less verbose because some minor type inference
  def add(startDate: LocalDate): LocalDateTime = {
    val startDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0))
    add(startDateTime)

  }


  //you dont need the brackets if the body is a single statement
  def add(startDateTime: LocalDateTime): LocalDateTime = startDateTime.plusSeconds(OneGigasecond)

  // a private constant
  private val OneGigasecond: Seconds = math.pow(10, 9) toLong

}
