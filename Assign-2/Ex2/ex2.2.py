import sys
import time
import matplotlib.pyplot as plt
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

# Import the .json file
import json
with open('Ex2/ex2.json') as f:
    arr = json.load(f)

# Measure the time taken to sort the array using func1
start_time = time.time()
func1(arr, 0, len(arr) - 1)
time_taken_func1 = time.time() - start_time

# Measure the time taken to sort the array using func2
start_time = time.time()
func2(arr, 0, len(arr) - 1)
time_taken_func2 = time.time() - start_time

# Plot the time taken to sort the array using both functions
x = [1, 2]
y = [time_taken_func1, time_taken_func2]
labels = ['func1', 'func2']
plt.bar(x, y, tick_label=labels)
plt.xlabel('Function')
plt.ylabel('Time Taken (Seconds)')
plt.title('Time Comparison of func1 and func2')
plt.show()
