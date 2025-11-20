import sys

raw = sys.stdin.read().strip()
parts = raw.split()
data = list(map(int, parts))

n = data[0]
heights = data[1:]

stack = []
answer = [0] * n
for i in range(n):
    while stack and stack[-1][1] <= heights[i]:
        stack.pop()
    if stack:
        answer[i] = stack[-1][0]+1
    stack.append((i, heights[i]))

print(*answer)