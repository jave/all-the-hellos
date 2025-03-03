package thefarm

import (
	"errors"
	"fmt"
)

// See types.go for the types defined for this exercise.
//  this:
// // WeightFodder returns the amount of available fodder.
// type WeightFodder interface {
// 	FodderAmount() (float64, error)
// }

// // ErrScaleMalfunction indicates an error with the scale.
// var ErrScaleMalfunction = errors.New("sensor error")


//  SillyNephewError type here.
type SillyNephewError struct {
	cows int
}

func (e *SillyNephewError) Error() string {
	return fmt.Sprintf("silly nephew, there cannot be %d cows", e.cows)
}

// DivideFood computes the fodder amount per cow for the given cows.
func DivideFood(weightFodder WeightFodder, cows int) (float64, error) {
	amount, err := weightFodder.FodderAmount()
	if err == ErrScaleMalfunction && amount > 0 {
		return (amount * 2) / float64(cows), nil
	}
	if err != nil && err != ErrScaleMalfunction {
		return 0.0, err
	}
	if amount < 0 {
		return 0.0, errors.New("negative fodder")
	}
	if err != nil {
		return 0.0, err
	}
	if cows == 0 {
		return 0.0, errors.New("division by zero")
	}
	if cows < 0 {
		return 0.0, &SillyNephewError{cows}
	}
	return amount / float64(cows), nil
}	

