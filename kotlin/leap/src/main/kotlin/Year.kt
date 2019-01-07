class Year(val theyear:Int){

        fun isDivisable(x:Int, y:Int):Boolean{
                return x % y == 0;
        }
        
        fun isLeap():Boolean {
                return isDivisable(theyear, 4) && ! (isDivisable(theyear, 100)) || isDivisable(theyear, 400);
                
        }
}
