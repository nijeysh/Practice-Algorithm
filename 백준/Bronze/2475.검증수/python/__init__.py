import sys

input = sys.stdin.read().strip().split()
sum = 0
for i in input:
    num = int(i)
    sum += num*num

print(sum % 10)