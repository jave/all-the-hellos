package birdwatcher

// TotalBirdCount return the total bird count by summing
// the individual day's counts.
func TotalBirdCount(birdsPerDay []int) int {
	res := 0
	// this is somewhat like a "foreach", or "mapreduce"
	for _, v := range birdsPerDay {
		res += v
	}
	return res
}

// BirdsInWeek returns the total bird count by summing
// only the items belonging to the given week.
func BirdsInWeek(birdsPerDay []int, week int) int {
	begin := (week - 1) * 7
	end := begin + 7
	res := 0
	//this is just a plain c style loop
	for i := begin; i < end; i++ {
		res += birdsPerDay[i]
	}
	return res
}

// FixBirdCountLog returns the bird counts after correcting
// the bird counts for alternate days.
func FixBirdCountLog(birdsPerDay []int) []int {
	//just normal for loop, check mod 2, then do stuff
	for i := 0; i < len(birdsPerDay); i++ {
		if i%2 == 0 {
			birdsPerDay[i]++
		}
	}
	return birdsPerDay
}
