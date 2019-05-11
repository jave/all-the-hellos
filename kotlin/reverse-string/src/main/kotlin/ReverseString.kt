// old school C like solution
// iterate over the string as an array from the end to the beginning
// copy each char to a new return object
fun reverse(s: String): String{
        var rv=StringBuilder()
        for(i in 0 until s.length){
                rv.append(s[s.length - 1 - i])
        }
        return rv.toString()
        
}


// this was also possible:
// fun reverse(s: String): String = s.reversed()
