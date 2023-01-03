package elon
import "fmt"
// the 'Drive()' method. in go you put the "this" pointer before the fn
// parameter list it could just as well be the 1st arg to the fn, so
// atm i dont see the point, but i guess theres some reason, like
// generics or something
func (c *Car) Drive() {
	
	if c.battery >= c.batteryDrain {
		c.battery = c.battery - c.batteryDrain
		c.distance = c.distance + c.speed
	}
}

//  the 'DisplayDistance() string' method
func (c Car) DisplayDistance() string {
	return fmt.Sprintf("Driven %d meters", c.distance)
}

//  the 'DisplayBattery() string' method
func (c Car) DisplayBattery() string {
	return fmt.Sprintf("Battery at %d%%", c.battery)
}

// the 'CanFinish(trackDistance int) bool' method
func (c Car) CanFinish(trackDistance int) bool {
	// a little bit of casting going on
	return ((float64(c.battery) / float64(c.batteryDrain)) * float64(c.speed)) >= float64(trackDistance)
}	
