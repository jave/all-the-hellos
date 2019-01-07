class ReverseString {

    String reverse(String inputString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : inputString.toCharArray()){
            stringBuilder.insert(0, c);
        }
        return stringBuilder.toString();
    }
  
}
