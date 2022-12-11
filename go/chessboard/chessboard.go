package chessboard

// Declare a type named Rank which stores if a square is occupied by a piece - this will be a slice of bools
type Rank []bool

// Declare a type named Chessboard which contains a map of eight Ranks, accessed with keys from "A" to "H"
type Chessboard map[string]Rank

// CountInRank returns how many squares are occupied in the chessboard,
// within the given rank
func CountInRank(chessboard Chessboard, rank string) int {
	chosenRank, rankExists := chessboard[rank]
	if !rankExists {
		return 0
	}
	rankCount := 0
	for _, isOnBoard := range chosenRank {
		if isOnBoard {
			rankCount += 1
		}
	}
	return rankCount
}

// CountInFile returns how many squares are occupied in the chessboard,
// within the given file
func CountInFile(chessboard Chessboard, file int) int {
	if file < 1 || file > 8 {
		return 0
	}
	fileCount := 0
	for _, rank := range chessboard {
		if rank[file-1] {
			fileCount += 1
		}
	}
	return fileCount	
}

// CountAll should count how many squares are present in the chessboard
func CountAll(chessboard Chessboard) int {
	squares := 0
	for _, rank := range chessboard {
		for range rank {
			squares += 1
		}
	}
	return squares
}

// CountOccupied returns how many squares are occupied in the chessboard
func CountOccupied(chessboard Chessboard) int {
	occupiedSquares := 0
	for _, rank := range chessboard {
		for _, isOnBoard := range rank {
			if isOnBoard {
				occupiedSquares += 1
			}
		}
	}
	return occupiedSquares
}

