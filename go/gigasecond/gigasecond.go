package gigasecond

import "time"
//import "math"

func AddGigasecond(t time.Time) time.Time {
	  //math.Pow10(9) // i wanted to use Pow10, but didn't
	return t.Add(time.Second * 1000000000);
}
