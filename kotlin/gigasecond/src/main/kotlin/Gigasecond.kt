import java.time.LocalDate
import java.time.LocalDateTime

// according to test specs date should be initialized from a LocalDate
// or LocalDateTime but become a LocalDateTime

// primary constructor
class Gigasecond(val initdate:LocalDateTime) {  
        val date = initdate.plusSeconds(1000000000)      // during initial construction, add 10e9 to initdate
        //2ndary constructor, call primary constructor
        constructor(initdate:LocalDate):this(initdate.atTime(0,0)){
                
        }

}
