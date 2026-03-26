package main

import (
	"fmt"
	"testing"
)

func TestFloatTruncation1(t *testing.T) {
	var result interface{} = Trunc(1.23456789)
	i := result.(int)
	fmt.Printf("%T\n", i)
}

func TestFloatTruncation2(t *testing.T) {
	var result interface{} = Trunc(9876543.21)
	i := result.(int) // will fail if not an int
	fmt.Printf("%T\n", i)
}
