#include "isogram.h"
#include <stdio.h>
#include <string.h>
#include <ctype.h>
bool is_isogram(const char phrase[]){
  int len=strlen(phrase);
  int charcount[255] =  {0};
  
  for (int i = 0; i < len; ++i) {
    int lowecaseindex = (int)tolower(phrase[i]);
    charcount[lowecaseindex] = charcount[lowecaseindex] +1;
  }
  //start counting at lowecase a, dont care about non letter symbols
  for (int i = 97; i < 255; ++i) {
    //if any chars received >2 counts, terminate
    if(charcount[i]>=2) return false;
  }
  return true;

}


