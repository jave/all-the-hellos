package electionday
import "fmt"

// NewVoteCounter returns a new vote counter with
// a given number of inital votes.
func NewVoteCounter(initialVotes int) *int {
	// comming from C on the one hand, and Lisp on the other hand I find this really really weird
	// so you can allocate a local variable and return the address to it.
	// https://stackoverflow.com/questions/52996452/returning-pointer-from-a-local-variable-in-function#52996523
	// C would just die, Lisp, one needent bother with pointers...
	// Go uses "escape analysis" to find pointers that escape the scope of the enclosing function
	return &initialVotes
}

// VoteCount extracts the number of votes from a counter.
func VoteCount(counter *int) int {
	// more or less like C, except you couldnt be sure a pointer is "nil" if uninitialized
	if counter == nil {
		return 0
	}
	return *counter	
}

// IncrementVoteCount increments the value in a vote counter
func IncrementVoteCount(counter *int, increment int) {
	//this feels exactly like C
	*counter += increment
}


// NewElectionResult creates a new election result
func NewElectionResult(candidateName string, votes int) *ElectionResult {
	//this type is declared in a separate file, but eglot/lsp didnt seem to understand
	result := ElectionResult{
		Name:	candidateName,
		Votes:	votes,
	}
	//again this "escape analysis" thing
	return &result
}

// DisplayResult creates a message with the result to be displayed
func DisplayResult(result *ElectionResult) string {
	return fmt.Sprintf("%s (%d)", result.Name, result.Votes)
}

// DecrementVotesOfCandidate decrements by one the vote count of a candidate in a map
func DecrementVotesOfCandidate(results map[string]int, candidate string) {
	results[candidate] -= 1
}
