// Package Cars: pretend car factory
package cars

// costOfOneCar : Cost of one car.
const costOfOneCar = 10000

// costOf10Cars : Cost of 10 cars
const costOf10Cars = 95000

// CalculateWorkingCarsPerHour calculates how many working cars are
// produced by the assembly line every hour
// go is a bit like C but with types at the end rather than the start
func CalculateWorkingCarsPerHour(productionRate int, successRate float64) float64 {
	// also like C theres a lot of type casting going on
	return float64(productionRate) * successRate / 100
}

// CalculateWorkingCarsPerMinute calculates how many working cars are
// produced by the assembly line every minute
func CalculateWorkingCarsPerMinute(productionRate int, successRate float64) int {
	// unlike C you dont need som many semicolons
	return (int)(CalculateWorkingCarsPerHour(productionRate, successRate) / 60)
}

// CalculateCost works out the cost of producing the given number of cars
func CalculateCost(carsCount int) uint {
	// go is cool I guess, but I always feel like expressions should return values, like in Lisp, Julia and so on
	// here you have to have explicit returns
	if carsCount < 10 {
		return uint(carsCount * costOfOneCar)
	}
	return CalculateCost(carsCount-10) + costOf10Cars
}
