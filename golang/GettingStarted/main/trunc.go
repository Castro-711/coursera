package main

import "fmt"

func Trunc(floaty float64) int {
	return int(floaty)
}

func main() {
	var userFloat float64
	fmt.Printf("Please enter a float:\n")
	fmt.Scan(&userFloat)
	fmt.Printf("%d", Trunc(userFloat))
}
