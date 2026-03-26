package main

import (
	"fmt"
	"strings"
)

func main() {
	var inputStr string
	fmt.Println("Please enter a string:")
	_, err := fmt.Scan(&inputStr)
	if err != nil {
		fmt.Println("Not a valid string!")
	}

	caseInsensitiveInStr := strings.ToLower(inputStr)

	beginsWithI := strings.HasPrefix(caseInsensitiveInStr, "i")
	endsWithN := strings.HasSuffix(caseInsensitiveInStr, "n")
	containsA := strings.Contains(caseInsensitiveInStr, "a")

	if beginsWithI && containsA && endsWithN {
		fmt.Println("Found")
	} else {
		fmt.Println("Not Found")
	}
}
