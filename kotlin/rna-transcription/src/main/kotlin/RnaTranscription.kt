// for some reason the tests didnt work well for this one.
// but i verified in a repl.

val dnaToRna = mapOf('G' to 'C', 'C' to 'G', 'T'  to 'A', 'A' to 'U')

//'it' anaphoric ref
fun transcribeToRna(dna: String) = dna.map {dnaToRna[it]}.joinToString("")

//another way to do the mapping

// fun mapnuc (c:Char):Char{
//         return when (c){
//                 'A' -> 'U'
//                 'G' -> 'C'
//                 'C' -> 'G'
//                 'T' -> 'A'
//                 else -> c
//         }
// }

        
//  fun transcribeToRna(dna: String) = dna.map({c:Char -> mapnuc(c)}).joinToString("")

