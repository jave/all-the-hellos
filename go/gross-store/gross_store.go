package gross

// Units stores the Gross Store unit measurements.
func Units() map[string]int {
	// this just creates and returns a map from string to ints
	return map[string]int{
		"quarter_of_a_dozen": 3,
		"half_of_a_dozen":    6,
		"dozen":              12,
		"small_gross":        120,
		"gross":              144,
		"great_gross":        1728,
	}
}

// NewBill creates a new bill.
func NewBill() map[string]int {
	// this clones a map, because maps are shallow so you need to deep copy them2
	return make(map[string]int)
}

// AddItem adds an item to customer bill.
func AddItem(bill, units map[string]int, item, unit string) bool {
	// check that theres a mapped value ifo so inc it with value
	value, exists := units[unit]
	if exists {
		bill[item] += value
		return true
	}
	return false
}

// RemoveItem removes an item from customer bill.
func RemoveItem(bill, units map[string]int, item, unit string) bool {
	quantityInBill, isPresentInBill := bill[item]
	if !isPresentInBill {
		return false
	}
	unitScore, isPresentInUnits := units[unit]
	if !isPresentInUnits {
		return false
	}
	newQty := quantityInBill - unitScore
	if newQty < 0 {
		return false
	}
	if newQty == 0 {
		delete(bill, item)
		return true
	}
	bill[item] = newQty
	return true
}
// GetItem returns the quantity of an item that the customer has in his/her bill.
func GetItem(bill map[string]int, item string) (int, bool) {
	quantityInBill, isPresentInBill := bill[item]
	if !isPresentInBill {
		return 0, false
	}
	return quantityInBill, true
}
