import java.util.HashMap;

class RnaTranscription {

    HashMap<String, String> map = new HashMap<>();

    //instance initialization block
    {
        map.put("A", "U");
        map.put("G", "C");
        map.put("C", "G");
        map.put("T", "A");        
    }
    
    String transcribe(String dnaStrand) {
        StringBuffer rv = new StringBuffer();
        for(char c: dnaStrand.toCharArray()){
            rv.append(map.get(""+c));
        }
        return rv.toString();
    }

}
