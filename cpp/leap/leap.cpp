namespace leap {

  /*  
;; function isLeapYear (year):
;;     if ((year modulo 4 is 0) and (year modulo 100 is not 0))
;;     or (year modulo 400 is 0)
;;         then true
;;     else false
  */
  bool is_divisible(int y, int x){
    if(y % x == 0) return true; else return false;
  }
  
  bool is_leap_year(int y){
    if ((is_divisible(y, 4) && !(is_divisible(y, 100))) || is_divisible(y, 400)) return true; else return false;
  }

}
