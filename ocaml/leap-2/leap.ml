let is_divisable y x = (y mod x) = 0 ;;
let leap_year year =     is_divisable year 4 &&
                           not ( is_divisable year 100)
                         || is_divisable year 400;;


