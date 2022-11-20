package booking
import "time"
const (
	//golang has these "by example" templates for date management, which i cant remember seeing in other languages
	scheduleLayout string = "1/2/2006 15:04:05"
	calendarLayout      string = "January 2, 2006 15:04:05"
	noonLayout     string = "Monday, January 2, 2006 15:04:05"
	appointmentLayout     string = "You have an appointment on Monday, January 2, 2006, at 15:04."
)
// Schedule returns a time.Time from a string containing a date
func Schedule(date string) time.Time {
	//golang error management by modified C strategy, that is,
	// errors are handled as return values i kinda like it when
	// "happy path" logic isnt obscured by error handling, but
	// thats not the fashionable opinion these days
	t, err := time.Parse(scheduleLayout, date)
	if err != nil {
		panic(err)
	}
	return t
}
// HasPassed returns whether a date has passed
func HasPassed(date string) bool {
	//apart from the error handling and the template thing, golang seems like any other language api wise for time handling
	t, err := time.Parse(calendarLayout, date)
	if err != nil {
		panic(err)
	}
	return time.Now().After(t)
}
// IsAfternoonAppointment returns whether a time is in the afternoon
func IsAfternoonAppointment(date string) bool {
	t, err := time.Parse(noonLayout, date)
	if err != nil {
		panic(err)
	}
	hour := t.Hour()
	return hour >= 12 && hour < 18
}
// Description returns a formatted string of the appointment time
func Description(date string) string {
	return Schedule(date).Format(appointmentLayout)
}
// AnniversaryDate returns a Time with this year's anniversary
func AnniversaryDate() time.Time {
	return time.Date(time.Now().Year(), time.September, 15, 0, 0, 0, 0, time.UTC)
}

            
