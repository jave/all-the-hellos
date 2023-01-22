package expenses
import "errors"

// Record represents an expense record.
type Record struct {
	Day      int
	Amount   float64
	Category string
}

// DaysPeriod represents a period of days for expenses.
type DaysPeriod struct {
	From int
	To   int
}

// Filter returns the records for which the predicate function returns true.
func Filter(in []Record, predicate func(Record) bool) []Record {
	var result []Record
	// this is like a foreach loop, or a filter in lisp
	for _, expense := range in {
		//predicate is a function argument, go has 1st class functions, so you can pass them as args and so on
		if predicate(expense) {
			// so if the predicate accepts the expense record append it to result
			result = append(result, expense)
		}
	}        
	return result
}

// ByDaysPeriod returns predicate function that returns true when
// the day of the record is inside the period of day and false otherwise
func ByDaysPeriod(p DaysPeriod) func(Record) bool {
	//create an anonymouse function and return it
	// it "closes over " p, which is the arg of the maker fn
	return func(r Record) bool {
		return p.From <= r.Day && r.Day <= p.To
	}
}

// ByCategory returns predicate function that returns true when
// the category of the record is the same as the provided category
// and false otherwise
func ByCategory(c string) func(Record) bool {
	// similar to the previous one, just close over "c", and return a predicate fn
	return func(r Record) bool {
		return c == r.Category
	}
}

// TotalByPeriod returns total amount of expenses for records
// inside the period p
func TotalByPeriod(in []Record, p DaysPeriod) float64 {
	var totalAmount float64
	// 1st filter a bunch of recrds, then sum the remaining records
	for _, expense := range Filter(in, ByDaysPeriod(p)) {
		totalAmount += expense.Amount
	}
	return totalAmount
}

// CategoryExpenses returns total amount of expenses for records
// in category c that are also inside the period p.
// An error must be returned only if there are no records in the list that belong
// to the given category, regardless of period of time.
func CategoryExpenses(in []Record, p DaysPeriod, c string) (float64, error) {
	recordsByCategory := Filter(in, ByCategory(c))
	if len(recordsByCategory) == 0 {
		var err = errors.New("unknown category entertainment")
		return 0, err
	}
	return TotalByPeriod(recordsByCategory, p), nil
}
