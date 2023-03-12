import json
import random
import timeit
import sys
import matplotlib.pyplot as plt

## Quicksort
sys.setrecursionlimit(20000)
def func1(arr, low, high):
    if low < high:
        pi = func2(arr, low, high)
        func1(arr, low, pi-1)
        func1(arr, pi + 1, high)

def func2(array, start, end):
    p = array[start]
    low = start + 1
    high = end
    while True:
        while low <= high and array[high] >= p:
            high = high - 1
        while low <= high and array[low] <= p:
            low = low + 1
        if low <= high:
            array[low], array[high] = array[high], array[low]
        else:
            break
    array[start], array[high] = array[high], array[start]
    return high

## Setting up randomized data

# Load the data from ex2.json
with open("Assign-2/Ex2/ex2.json", "r") as file:
    data = json.load(file)

# Shuffle the elements in each array
for array in data:
    random.shuffle(array)

# Write the shuffled data to ex2.5.json
with open("Assign-2/Ex2/ex2.5.json", "w") as file:
    json.dump(data, file)


## Plotting 

with open("Assign-2/Ex2/ex2.5.json", "r") as file:
    data = json.load(file)

timings = []

# Time func1 for each array
for array in data:
    timing = timeit.timeit(lambda: func1(array, 0, len(array) - 1), number=1)
    timings.append(timing)

# Plot the timings
plt.plot(timings)
plt.xlabel("Array Number")
plt.ylabel("Time (in seconds)")
plt.title("Quicksort Timings for each Array")
plt.show()