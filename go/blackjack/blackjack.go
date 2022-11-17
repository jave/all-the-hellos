package blackjack



// ParseCard returns the integer value of a card following blackjack ruleset.
func ParseCard(card string) int {
	// you can do 2 types of switch in go, this type checks for
	// the value of a variable, and matches them to one or several
	// constants. also, a default value is supported. You do return from the branches, like C
	switch card {
	case "ace":  return 11
	case "two":  return 2
	case "three":return 3
	case "four": return 4
	case "five": return 5
	case "six":  return 6
	case "seven":return 7
	case "eight":return 8
	case "nine": return 9
	case "ten", "jack", "queen", "king": return 10
	default: return 0
	}
}
// FirstTurn returns the decision for the first turn, given two cards of the
// player and one card of the dealer.
func FirstTurn(card1, card2, dealerCard string) string {
	// assign a tuple of variables to a tuple of values, a bit like python
	card1Value, card2Value, dealerCardValue := ParseCard(card1), ParseCard(card2), ParseCard(dealerCard)
	switch {
	//this is the switch like C, or a cond in lisp
	case card1Value == 11 && card2Value == 11:
		return "P"
	case card1Value+card2Value == 21:
		// you could do this with 2 switch branches instead of course
		if dealerCardValue == 10 || dealerCardValue == 11 {
			return "S"
		} else {
			return "W"
		}
	case card1Value+card2Value >= 17 && card1Value+card2Value <= 20:
		return "S"
	case card1Value+card2Value >= 12 && card1Value+card2Value <= 16:
		if dealerCardValue >= 7 {
			return "H"
		} else {
			return "S"
		}
	default:
		return "H"
	}
}



