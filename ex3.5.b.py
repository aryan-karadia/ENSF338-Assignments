import random
import timeit
import matplotlib.pyplot as plt
import heapq

#inefficient implementation
class PriorityQueue:
    def __init__(self):
        self.queue = []

    def insert(self, value):
        self.queue.append(value)
        self.queue.sort(reverse=True)

    def extract_max(self):
        if not self.queue:
            return None
        return self.queue.pop(0)
    

#efficient search
class PriorityQueue:
    def __init__(self):
        self.queue = []

    def insert(self, value):
        heapq.heappush(self.queue, -value)

    def extract_max(self):
        if not self.queue:
            return None
        return -heapq.heappop(self.queue)


def test_priority_queue(pq, n):
    for i in range(n):
        pq.insert(random.randint(0, 10000))
    start = timeit.default_timer()
    for i in range(n):
        pq.extract_max()
    end = timeit.default_timer()
    return end - start

n = 1000
num_tests = 100

inefficient_times = []
efficient_times = []

for i in range(num_tests):
    pq1 = PriorityQueue()
    pq2 = PriorityQueue()
    inefficient_times.append(test_priority_queue(pq1, n))
    efficient_times.append(test_priority_queue(pq2, n))

print("Inefficient implementation average time:", sum(inefficient_times)/num_tests)
print("Efficient implementation average time:", sum(efficient_times)/num_tests)

plt.hist(inefficient_times, alpha=0.5, label='Inefficient')
plt.hist(efficient_times, alpha=0.5, label='Efficient')
plt.legend(loc='upper right')
plt.show()
